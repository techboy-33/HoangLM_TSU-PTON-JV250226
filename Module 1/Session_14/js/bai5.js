/* 
Viết một chương trình quản lý danh sách sinh viên với các chức năng cơ bản sau:

1. Thêm sinh viên mới
- Nhập tên, tuổi, mã số sinh viên (ID).
- Thêm sinh viên vào danh sách.
 
2. Hiển thị danh sách sinh viên
- Duyệt qua danh sách và in thông tin của từng sinh viên ra màn hình.
 
3. Xóa sinh viên theo ID
- Nhập ID của sinh viên cần xóa.
- Nếu ID tồn tại, xóa sinh viên khỏi danh sách.
- Nếu ID không tồn tại, thông báo lỗi.
*/

let students = [
    {
        name: "LE MINH HOANG",
        age: 25,
        id: 1
    },
    {
        name: "TRAN MINH HIEU",
        age: 20,
        id: 2
    },
];

let choose = prompt(`
        Chào mừng bạn đến với chương trình quản lý danh sách sinh viên, 
        hãy nhập số chức năng bạn muốn sử dụng :
        1. Thêm sinh viên mới
        2. Hiển thị danh sách sinh viên
        3. Xóa sinh viên theo ID
        `)

if (choose == 1) {
    let name = prompt("Hãy nhập tên sinh viên");
    let age = prompt(`Hãy nhập tuổi của ${name}`);
    let id = prompt(`Hãy nhập mã số ID của ${name}`);

    let flag = true;
    for (const key in students) {
        if (id == students[key].id) {
            flag = false;
            break;
        }
    }
    if (flag) {
        let item = {
            name: name,
            age: age,
            id: id,
        }
        students.push(item);
        callItem();
    } else {
        console.log("ID này đã tồn tại");
    }
} else if (choose == 2) {
    callItem();
} else if (choose == 3) {
    let deleteId = prompt("Hãy nhập ID muốn xóa");
    let flag = true;
    for (const i in students) {
        if (students[i].id == deleteId) {
            console.log(`Đã xóa ${students[i].name}`);
            students.splice(i, 1);
            flag = false;
            callItem();
        }
    }
    if (flag) {
        console.log(`không có học sinh ID là ${deleteId}`);
    }
} else {
    alert("Xin hãy nhập số từ 1 đến 3");
}


function callItem() {
    console.log("Danh sách học sinh:");
    for (const element of students) {
        console.log(`${element.name}`);
        console.log(`${element.age} tuổi`);
        console.log(`ID là ${element.id}`);
        console.log('==========================');
    }
}