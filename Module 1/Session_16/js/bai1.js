

function processConfirm(input) {
    let answer = confirm(input);
    let result = "";
    if (answer) {
        result = "Excellent. We'll play a nice game of chess."
    } else {
        result = "Maybe later then."
    }
    return result;
}

console.log(processConfirm("xin chao"));
