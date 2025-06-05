
let flag = true;
let lenght = +prompt("Bạn muốn nhập bao nhiêu số nguyên");
let array = [];

for (let i = 0; i < lenght; i++) {
    let num = +prompt(`Mời bạn nhập số nguyên thứ ${i + 1}`)
    if (Number.isInteger(num)) {
        array.push(num);
    } else {
        console.log(`${num} không phải là số nguyên`);
        flag = false;
        break
    }
}

let reverseArr = array.reverse();
if (flag) {
    console.log(`Mảng đảo ngược là ${reverseArr}`);
    
} else {
    console.log("Xin hãy nhập lại")
}