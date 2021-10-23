/**
 * 題目：课程表 II (Medium)
 */
class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
         to = vector<vector<int>>(numCourses, vector<int>());
        inDeg = vector<int>(numCourses, 0);
        for(vector<int>& pre: prerequisites) {
            int ai = pre[0];
            int bi = pre[1];
            // pre course
            // course -> in degree 0
            to[bi].push_back(ai);
            inDeg[ai]++;
        }
        queue<int> q;
        // First Step to topological sort is start from in-degree 0
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) q.push(i);
        }
        vector<int> lessons;
        while(!q.empty()) {
            int x = q.front();
            q.pop();
            lessons.push_back(x);
            // Second Step: 擴展一個點，周圍的點入度減一
            for(int y : to[x]) {
                inDeg[y]--;
                // Third Step: 入度減爲零，表示可以修
                if(inDeg[y] == 0) {
                    q.push(y);
                } 
            }
        }
        
        if(lessons.size() < numCourses) return {};
        return lessons;
    }
private:
    vector<vector<int>> to;
    vector<int> inDeg;
};