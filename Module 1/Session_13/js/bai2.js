
let numberArr = [1, 4, 6, 8, 20];

let luckyNumber = +prompt("Hãy nhập vào một số bất kỳ");

let check = 0;

for (let element of numberArr) {
    if (luckyNumber == element) {
        check ++;
    } else {
        continue
    }
}

if (check == 1) {
    alert("Bingo");
} else {
    alert("Chúc bạn may mắn lần sau");
}