
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
    let newArray = [];

    for (const key in array) {
        if (array[key] >= 10) {
            newArray.push(array[key]);
        }
    }

    console.log(`Có ${newArray.length} số nguyên lớn hơn hoặc bằng 10`);
    for (const element of newArray) {
        console.log(element);
    }
} else {
    console.log("Xin hãy nhập lại");
    
}


