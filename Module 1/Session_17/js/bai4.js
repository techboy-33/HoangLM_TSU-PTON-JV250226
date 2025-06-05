
let body = document.querySelector(".body")
let yellow = document.querySelector(".yellow")
let green = document.querySelector(".green")
let grey = document.querySelector(".grey")

// biến thành màu vàng
yellow.addEventListener("mouseenter" , function() {
    document.body.classList.toggle("yellow")
})
yellow.addEventListener("mouseleave" , function() {
    document.body.classList.toggle("yellow")
})
// biến thành màu xanh lá
green.addEventListener("mouseenter" , function() {
    document.body.classList.toggle("green")
})
green.addEventListener("mouseleave" , function() {
    document.body.classList.toggle("green")
})
// biến thành màu xám
grey.addEventListener("mouseenter" , function() {
    document.body.classList.toggle("grey")
})
grey.addEventListener("mouseleave" , function() {
    document.body.classList.toggle("grey")
})