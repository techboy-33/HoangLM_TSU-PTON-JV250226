
let hideBtn = document.querySelector(".hide_btn");
let showBtn = document.querySelector(".show_btn");
let text = document.querySelector(".text");

hideBtn.addEventListener('click' , () => {
    text.classList.remove("show");
});

showBtn.addEventListener('click',() => {
    text.classList.add("show");
});

