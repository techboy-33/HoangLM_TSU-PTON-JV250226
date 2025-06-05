let diemKiemTra = + prompt("Hãy nhập điểm kiểm tra");
let diemThiGiuaKy = + prompt("Hãy nhập điểm thi giữa kỳ");
let diemThiCuoiKy = + prompt("Hãy nhập điểm thi cuối kỳ");

let averageScore = (diemKiemTra + diemThiGiuaKy + diemThiCuoiKy) / 3;
console.log(averageScore);

if (averageScore > 9) {
    alert("Xuất sắc")
} else if (9 >= averageScore && averageScore >= 8) {
    alert("Giỏi")
} else if (8 > averageScore && averageScore >= 6) {
    alert("Khá")
} else if (6 > averageScore && averageScore >= 4) {
    alert("Trung bình")
} else {
    alert("Yếu")
}