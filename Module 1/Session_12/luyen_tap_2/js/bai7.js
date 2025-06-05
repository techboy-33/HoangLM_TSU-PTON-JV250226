//  ax2 + bx + c = 0,

let a = parseFloat(prompt('Nhập số a = '))
let b = parseFloat(prompt('Nhập số b = '))
let c = parseFloat(prompt('Nhập số c = '))

if (a == 0) {
    if (b == 0) {
        if (c == 0) {
            alert('phương trình vô số nghiệm')
        } else {
            alert('phương trình vô nghiệm')
        }
    } else {
        x = -c / b
        alert('nghiệm x = ' + x)
    }
} else {
    dt = b * b - 4 * a * c;
    if (dt < 0) {
        alert('phương trình vô nghiệm')
    } else if (dt == 0) {
        x = -b / (2 * a)
        alert('nghiệm của phương trình bằng x1 = x2 = ' + x)
    } else {
        x1 = (-b + Math.sqrt(dt)) / (2 * a)
        x2 = (-b - Math.sqrt(dt)) / (2 * a)
        alert(`nghiệm x1 = ${x1}, x2 = ${x2}`)
    }
}