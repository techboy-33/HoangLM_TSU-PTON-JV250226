
// let numberArr = [1, 2, 3, 4]
let numberArr = [10, 8, 6, 5, 4, 3, 12, 11, 18, 13, 7, 9, 15]

let evenTotal = 0;

let oddTotal = 0;

for (let element of numberArr) {
    if (element % 2 == 0) {
        evenTotal += element
    } else {
        oddTotal += element
    }
}

alert(`tổng số chẵn bằng ${evenTotal}, tổng số lẻ bằng ${oddTotal}`)