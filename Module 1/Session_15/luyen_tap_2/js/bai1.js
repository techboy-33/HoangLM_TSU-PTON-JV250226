
let threeAlphabet = [];
let threeNumber = [];

for (let i = 0; i <= 2; i++) {
    let alphabetItem = prompt(`Hãy nhập vào chữ cái thứ ${i+1}`);
    threeAlphabet.push(alphabetItem)
}

for (let i = 0; i <= 2; i++) {
    let numberItem = prompt(`Hãy nhập vào chữ số thứ ${i+4}`);
    threeNumber.push(numberItem)
}

let newArr = threeNumber.concat(threeAlphabet)
console.log(newArr.join(""));
