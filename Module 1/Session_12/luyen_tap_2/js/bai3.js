let a = +prompt("Hãy nhập cạnh a")
if (a <= 0) {
    alert("Cạnh a phải lớn hơn 0")
} else {
    let dieTich = a * a;
    alert(`Diện tích bằng ${dieTich}`);
}