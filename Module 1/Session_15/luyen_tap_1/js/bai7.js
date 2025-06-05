
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

if (flag) {
    let sorted = array.sort((a,b) => b-a)
    console.log(`Mảng đã được sắp xếp theo thứ tự giảm dần ${sorted}`);
    
} else {
    console.log("Xin hãy nhập lại");   
}