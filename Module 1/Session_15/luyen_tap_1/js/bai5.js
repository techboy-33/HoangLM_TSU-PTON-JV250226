
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
let count = 0;
let vowelArr = [];
if (flag) {
    for (const key in array) {
        if (array[key]< 0) {
            count += 1;
            vowelArr.push(array[key]);
        }
    }    
    console.log(`Có ${count} số nguyên âm trong mảng`);
    console.log(`Các số nguyên âm đó là ${vowelArr}`);
    
} else {
    console.log("Xin hãy nhập lại")
}