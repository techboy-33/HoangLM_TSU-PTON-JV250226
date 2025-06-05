

let arr = ["dfa", "s5df", "ydsf", "s8dfs", "s5ffds", "sdh", "gsfs", "sfd9g"];
count = 0;

for (const i in arr) {
    for (const k in arr[i]) {
        
        if (!isNaN(arr[i][k])) {
            console.log(`${arr[i][k]}`);
            count += 1
        }
    }

}

console.log(`Tổng ký tự số là ${count}`);
