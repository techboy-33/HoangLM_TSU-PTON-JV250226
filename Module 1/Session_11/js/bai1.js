

let input = prompt("Hãy nhập năm bạn muốn kiểm tra: ")

if (input % 4 == 0 && input % 100 != 0) {
    console.log(`Năm ${input} là năm nhuận`);
} else {
    console.log(`Năm ${input} KHÔNG PHẢI là năm nhuận`);
}