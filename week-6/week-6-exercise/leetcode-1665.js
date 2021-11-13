/**
 * 題目： 完成所有任务的最少初始能量 (Hard)
 */
/**
 * @param {number[][]} tasks
 * @return {number}
 */
var minimumEffort = function(tasks) {
    tasks.sort((a, b) => {
        if (a[0] - a[1] < b[0] - b[1]) {
            return -1
        }
        if (a[0] - a[1] > b[0] - b[1]) {
            return 1
        }
        return 0
    })
    let ans = 0
    for (let i = tasks.length - 1; i >= 0; i--) {
        ans = Math.max(tasks[i][1], ans + tasks[i][0])
    }
    return ans;
};