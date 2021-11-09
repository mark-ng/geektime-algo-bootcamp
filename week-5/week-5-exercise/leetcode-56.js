/**
 * 題目： 合并区间 (Medium)
 * Method: 差分
 */
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    let events = [];
    for (let interval of intervals) {
        events.push([interval[0], 1])
        events.push([interval[1] + 1, -1])
    }
    events.sort((pair1, pair2) => {
        if (pair1[0] < pair2[0]) {
            return -1
        } else if (pair1[0] == pair2[0]) {
            if (pair1[1] < pair2[1]) {
                return -1
            } else {
                return 1
            }
        } else {
            return 1
        }
    })
    // console.log(events)
    
    let covering = 0
    let start;
    let ans = []
    for (let event of events) {
        if (covering == 0) start = event[0]
        covering += event[1];
        if (covering == 0) {
            ans.push([start, event[0] - 1])
        }
    }
    return ans
};
/**
 * 題目： 合并区间 (Medium)
 * Method: 排序
 */
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
 var merge = function(intervals) {
    intervals.sort((pair1, pair2) => {
        if (pair1[0] > pair2[0]) {
            return 1;
        }
        if (pair1[0] < pair2[0]) {
            return -1;
        }
        if (pair1[0] == pair2[0]) {
            return pair1[1] - pair2[1];
        }
    })

    let ans = [];
    let farthest = -1;
    let start = -1;
    for (let i = 0; i < intervals.length; i++) {
        let left = intervals[i][0];
        let right = intervals[i][1];
        if (left <= farthest) {
            farthest = Math.max(farthest, right);
        } else {
            if (farthest != -1) {
                ans.push([start, farthest]);
            }
            start = left
            farthest = right;
        }
    }
    ans.push([start, farthest]);
    return ans;
};