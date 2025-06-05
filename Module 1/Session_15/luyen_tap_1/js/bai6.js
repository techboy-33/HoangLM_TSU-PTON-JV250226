
let array = [];
let flag = true;

for (let i = 0; i <= 9; i++) {
    let num = +(prompt(`Hãy nhập vào số nguyên ${i + 1}`));
    if (Number.isInteger(num)) {
        array.push(num);
    } else {
        console.log(`${num} không phải là số nguyên`);
        flag = false;
        break
    }
}

let searchNum = +prompt("Hãy nhập số nguyên bạn muốn tìm kiếm");

if (flag) {
    if (array.includes(searchNum)) {
        console.log(`Number ${searchNum} is in the array`);       
    } else {
        console.log(`Number ${searchNum} is not in the array`);       
    }
} else {
    console.log("Xin hãy nhập lại");   
}