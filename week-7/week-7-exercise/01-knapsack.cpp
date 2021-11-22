vector<vector<int>> f(n + 1, vector<int>(m + 1, -1000000000));
f[0][0] = 0;

for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= m; j++) 
        f[i][j] = f[i - 1][j];
    for (int j = v[i]; j <= m; j++) 
        f[i][j] = max(f[i][j], f[i - 1][j - v[i]] + w[i]);
}

int ans = 0;
for (int j = 0; j <= m; j++) ans = max(ans, f[n][j]);

// 

vector<int> f(m + 1, -1000000000);
f[0] = 0;

for (int i = 1; i <= n; i++) 
    for (int j = m; j >= v[i]; j--)
        f[j] = max(f[j], f[j - v[i]] + w[i]);

int ans = 0;
for (int j = 0; j <= m; j++) ans = max(ans, f[j]);