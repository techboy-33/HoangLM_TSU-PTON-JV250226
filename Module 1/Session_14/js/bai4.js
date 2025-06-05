
let original = {
    name: "Bob",
    age: 30,
}

let copy = {...original}

copy.name = "Charlie";

console.log(original);
console.log(copy);


