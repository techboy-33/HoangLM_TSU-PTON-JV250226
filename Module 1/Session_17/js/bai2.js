
let button = document.querySelector(".btn");
let body = document.querySelector(".body");
let count = 0;
button.addEventListener("click", function() {

    document.body.classList.toggle("dark");
    // if (count % 2 == 0) {
    //     body.classList.add("dark");
    //     count += 1;
    // } else {
    //     body.classList.remove("dark");
    //     count += 1;
    // }
})