

let weight = +prompt("Hãy nhập vào cân nặng của bạn");
let height = +prompt("Hãy nhập vào chiều cao của bạn, ví dụ 1m65 --> 1.65");

let bmi = weight / (height * height);

if (bmi < 18.5) {
    alert("Cân nặng thấp")
} else if ( 18.5 < bmi < 24.9) {
    alert("Bình thường")
} else if (25 < bmi < 29.9) {
    alert("Tiền béo phì")
    alert("Thừa cân")
} else if ( 30 < bmi < 34.9) {
    alert("Béo phì độ I")
    alert("Thừa cân")
} else if ( 35 < bmi < 39.9) {
    alert("Béo phì độ II")
    alert("Thừa cân")
} else {
    alert("Béo phì độ III")
    alert("Thừa cân")
}
