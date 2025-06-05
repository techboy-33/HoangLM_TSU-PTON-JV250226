let a = parseFloat(prompt('Nhập số a = '));
let b = parseFloat(prompt('Nhập số b = '));
let c = parseFloat(prompt('Nhập số c = '));


if (a + b > c && Math.abs(a - b) < c) {
    alert("a, b, c là cạnh của 1 tam giác")
} else {
    alert("a, b, c không là cạnh của 1 tam giác")
}