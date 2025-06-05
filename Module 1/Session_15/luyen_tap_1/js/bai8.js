
let arrayA = [];
let arrayB = [];
let arrayC = [];
let flag = true;

for (let i = 0; i <= 9; i++) {
    let num = +(prompt(`Hãy nhập vào A số nguyên ${i + 1}`));
    if (Number.isInteger(num)) {
        arrayA.push(num);
    } else {
        console.log(`${num} không phải là số nguyên`);
        flag = false;
        break
    }
}

for (let i = 0; i <= 9; i++) {
    let num = +(prompt(`Hãy nhập vào B số nguyên ${i + 1}`));
    if (Number.isInteger(num)) {
        arrayB.push(num);
    } else {
        console.log(`${num} không phải là số nguyên`);
        flag = false;
        break
    }
}

if (flag) {
    arrayC = arrayA.concat(arrayB);
    console.log(`Mảng C là ${arrayC}`);
} else {
    console.log("Xin hãy nhập lại");   
}