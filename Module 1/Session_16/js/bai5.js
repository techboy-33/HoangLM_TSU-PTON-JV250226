
function isPalindrome(question) {
    let input = prompt(question);
    let reversed_input = input.split("").reverse().join("");
    if (input === reversed_input) {
        alert("Chuỗi nhập vào là chuỗi đối xứng")
    } else {
        alert("Chuỗi nhập vào không phải là chuỗi đối xứng")
    }
}

isPalindrome()

