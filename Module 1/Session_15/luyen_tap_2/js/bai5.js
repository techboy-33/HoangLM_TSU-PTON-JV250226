

let n = prompt("Bạn muốn nhập vào mảng bao nhiêu ký tư");
let arrInput = [];
for (let i = 0; i < n; i++) {
    let input = prompt(`Hãy nhập ký tự thứ ${i+1}`);
    for (const element of input) {
        if (element == "-") {
            arrInput.push("_")
        } else {
            arrInput.push(element)
        }
    }
}

console.log(arrInput);

