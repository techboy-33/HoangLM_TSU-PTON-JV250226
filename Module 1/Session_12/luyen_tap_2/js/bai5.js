let a = +prompt("Hãy nhập cạnh a")
let b = +prompt("Hãy nhập cạnh b")


if (a > 0 && b > 0) {
    let dieTich = (a * b) / 2;
    alert(`Diện tích bằng ${dieTich}`);
} else {
    alert("cạnh a và b phải lớn hơn 0")
}