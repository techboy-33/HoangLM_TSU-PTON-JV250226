
function isEven(question) {
    let input = +prompt(question)
    if (Number.isInteger(input)) {
        if (input % 2 == 0) {
            return true;
        } else if (input % 2 != 0) {
            return false;
        }
    } else {
        alert("Dữ liệu nhập vào không hợp lệ")
    }
}

alert(isEven("Hãy nhập vào 1 số nguyên: "))