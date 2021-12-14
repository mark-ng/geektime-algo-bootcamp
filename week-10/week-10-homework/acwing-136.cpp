/**
 * 題目： 136. 邻值查找
 */

#include <iostream>
#include <map>

using namespace std;

typedef long long LL;
typedef pair<LL, int> PII;
const int N = 100010;

int n;
int a[N];

PII ans[N];
map<LL, int> mp = {{-3e9, -1}, {3e9, -1}};

void calMinAdjacent() {
    for (int i = n - 1; i >= 0; i--) {
        int x = a[i];
        auto it = mp.lower_bound(x);
        auto it2 = it, it1 = it;
        it1--, it2++;
        if (x - it1->first <= it2->first - x) {
            ans[i] = {x - it1->first, it1->second};
        } else {
            ans[i] = {it2->first - x, it2->second};
        }
        mp.erase(x);
    }
}

int main()
{   
    cin >> n;
    for (int i = 0; i < n; i ++ )
    {
        cin >> a[i];
        mp[a[i]] = i;
    }
    calMinAdjacent();
    for (int i = 1; i < n; i ++ ) cout << ans[i].first << ' ' << ans[i].second + 1 << endl;
    return 0;
}
