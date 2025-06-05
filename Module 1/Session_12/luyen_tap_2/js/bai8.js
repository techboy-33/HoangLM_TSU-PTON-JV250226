let a = +(prompt("Nhập vào một số"));

if (a % 1 === 0 && a > 0 && a < 120) {
    alert(`${a} là tuổi của người`);
} else {
    alert(`${a} không phải là tuổi của người`);
    
}