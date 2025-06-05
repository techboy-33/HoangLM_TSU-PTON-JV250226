let a = +prompt ("Hãy nhập số nguyên đầu tiên");
let b = +prompt ("Hãy nhập số nguyên thứ hai");
let c = +prompt ("Hãy nhập số nguyên thứ ba");

let big = 0;
let bigName = "";

if (a > b) {
    big = a;
    bigName = "a";
} else {
    big = b
    bigName = "b";
}

if (c > b) {
    big = c;
    bigName = "c";
} else {
    big = b
    bigName = "b";
}

alert(`${bigName} là số lớn nhất có giá trị bằng ${big}`)