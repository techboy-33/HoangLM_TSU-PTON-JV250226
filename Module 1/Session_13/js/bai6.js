
let k = prompt("Nhập vào một số nguyên để kiểm tra")

let numberArr = [1, 2, 2, 4]
// let numberArr = [10, 8, 6, 5, 9, 3, 12, 12, 18, 12, 7, 9, 15]

let count  = 0;

for (let element of numberArr) {
    if (element == k) {
        count += 1
    } else {
        continue
    }
}

alert(`k xuất hiện ${count} lần`)