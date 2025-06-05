
const arr1 = [3, 5, 1, 8, -3, 7, 8];
const arr2 = [7, 12, 6, 9, 20, 56, 89];
const arr3 = [];
const arr4 = "xin chào";

function check(arr) {
    if (arr.length === 0) {
        console.log("Mảng này không có phần tử");
    } else if (!Array.isArray(arr)) {
        console.log("Dữ liệu nhập vào không hợp lệ");
    } else {
        let min = arr[0];
        for (let item of arr) {
            if (item < min) {
                min = item;
            }
        }
        return min
    }


}

console.log(check(arr4));
