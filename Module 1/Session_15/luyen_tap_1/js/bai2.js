
let array = []

let flag = 0;
for (let i = 0; i < 10; i++) {
    let num = +(prompt(`Hãy nhập vào số nguyên ${i + 1}`));
    if (Number.isInteger(num)) {
        if (array.includes(num)) {
            console.log(`Số ${num} đã tồn tại`);
            flag = false;
            break
        } else {
            array.push(num);
            flag = false;
        }
    } else {
        console.log(`${num} không phải là số nguyên`);
        flag = false;
        break
    }
}

let bigest = 0;
let index = 0;

if (flag) {
    for (let i = 0; i <= array.length; i++) {
        if (array[i] > bigest) {
            bigest = array[i];
            index = i + 1;
        }
    }
    console.log(`${bigest} là số lớn Nhất, nằm ở vị trí thứ ${index}`);
    console.log('===============================');
    console.log(array);
    console.log('===============================');
} else {
    console.log("Xin hãy nhập lại");
}
