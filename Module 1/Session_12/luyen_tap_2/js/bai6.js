//  ax + b = 0,

let a = +prompt(" ax + b = 0, hãy nhập số a")
let b = +prompt(" ax + b = 0, hãy nhập số b")

if (a != 0) {
    let x = (-b) / a;
    alert(`x bằng ${x}`)
} else {
    alert("Phương trình vô nghiệm")
}
