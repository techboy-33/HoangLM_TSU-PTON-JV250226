
let flag = true;
let lenght = +prompt("Bạn muốn nhập bao nhiêu số nguyên");
let array = [];
let sum = 0;

for (let i = 0; i < lenght; i++) {
    let num = +prompt(`Mời bạn nhập số nguyên thứ ${i + 1}`)
    if (Number.isInteger(num)) {
        array.push(num);
        sum += num;
    } else {
        console.log(`${num} không phải là số nguyên`);
        flag = false;
        break
    }
}

let bigest = 0;
let average = sum/lenght;
if (flag) {
    for (let i = 0; i <= array.length; i++) {
        if (array[i] > bigest) {
            bigest = array[i];
        }
    }

    console.log(`Giá trị lớn nhất trong mảng là: ${bigest}`);
    console.log(`Giá trị trung bình của các phần từ trong mảng là: ${average}`);
    
} else {
    console.log("Xin hãy nhập lại")
}