let m = +prompt("Hãy nhập mét mà bạn muốn chuyển sang Feet")

if (m <= 0) {
    alert("Giá trị nhập vào phải lớn hơn 0")
} else {
    let ft = m * 3.2808;
    alert(`Feet bằng ${ft}`);
}
