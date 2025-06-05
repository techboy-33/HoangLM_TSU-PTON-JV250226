
let randomNumber = prompt("Hãy nhập dãy số bất kỳ");

let newArr = randomNumber.split("");

let bigNumber = 0;

for (let element of newArr) {
    if (bigNumber < element) {
        bigNumber = element;
    } else {
        continue
    }
}

alert(`${bigNumber} là giá trị lớn nhất`)