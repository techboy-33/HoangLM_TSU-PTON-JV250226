let a = +prompt("Mời bạn nhập vào số a")
let b = +prompt("Mời bạn nhập vào số b")
let math = prompt("Mời bạn nhập vào phép tính (+, -, *, /)")


if (math == "+") {
    alert(`Kết quả của phép tính a + b = ${a + b}`)
} else if (math == "-") {
    alert(`Kết quả của phép tính a - b = ${a - b}`)
} else if (math == "*") {
    alert(`Kết quả của phép tính a * b = ${a * b}`)
} else if (math == "/") {
    alert(`Kết quả của phép tính a / b = ${a / b}`)
} else {
    alert(`Điều kiện nhập vào không hợp lệ`)
}
