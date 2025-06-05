/*
1. Thêm sách mới
    Nhập ID, Tên sách, Tác giả, Năm xuất bản.
    Thêm sách vào danh sách.
2. Hiển thị danh sách sách
    Duyệt qua danh sách và in thông tin của từng sách ra màn hình.
3. Tìm kiếm sách theo tên
    Nhập từ khóa tìm kiếm.
    Tìm và hiển thị sách có tên chứa từ khóa đó (không phân biệt hoa thường).
    Nếu không tìm thấy, thông báo cho người dùng.
4. Xóa sách theo ID
    Nhập ID của sách cần xóa.
    Nếu sách tồn tại, xóa khỏi danh sách.
    Nếu sách không tồn tại, thông báo lỗi.
5. Thoát chương trình
    Dừng chương trình khi người dùng chọn thoát.
*/

let books = [
    {
        id: 1,
        name: "Lão Hạc",
        author: "Nam Cao",
        year: 1976,
    },
    {
        id: 2,
        name: "Nghĩ giàu làm giàu",
        author: "Napoleon Hill",
        year: 1937,
    },
];

while (true) {
    let choose = + prompt(`
Hãy nhập vào màn hình từ 1 đến 5 :
    1. Thêm mới sách vào danh sách.
    2. Hiển thị danh sách sách.
    3. Tìm kiếm sách theo tên.
    4. Xóa sách theo ID.
    5. Thoát chương trình.
    `)

    if (choose == 1) {
        let id = prompt("Mời bạn nhập ID sách");
        for (const key in books) {
            if (id == books[key].id) {
                console.log("ID này đã nằm bị trùng lặp");
                break;
            } else {
                let name = prompt("Mời bạn nhập tên sách");
                let author = prompt("Mời bạn nhập tên tác giả");
                let year = prompt("Mời bạn nhập năm xuất bản");

                books.push({ id: id, name: name, author: author, year: year })
                ShowBookList()
                break;
            }
        }

    } else if (choose == 2) {
        ShowBookList();
    } else if (choose == 3) {
        let search = prompt("Nhập từ khóa tìm kiếm: ")
        flag = true;
        for (const key in books) {
            if (books[key].name.includes(search)) {
                console.log(`Sách bạn muốn tìm là ${books[key].name}, của tác giả ${books[key].author}, xuất bản năm ${books[key].year}`);
                flag = false;
            }
        }

        if(flag) {
            console.log("Sách bạn tìm kiếm không tồn tại");
        }

    } else if (choose == 4) {
        let id = prompt("Mời bạn nhập ID sách muốn xóa");
        let flag = true;
        for (const key in books) {
            if (id == books[key].id) {
                console.log(`Đã xóa sách ${books[key].name}`);
                books.splice(key, 1)
                ShowBookList();
                flag = false;
                break;
            }
        }
        if (flag) {
            console.log("ID này không có trong sanh sách");
            ShowBookList();
        }
    } else if (choose == 5) {
        break;
    } else {
        console.log("Số bạn nhập không có trong ứng dụng");
    }
}


function ShowBookList() {
    for (const key in books) {
        console.log("Danh sách sách đã được cập nhật: ");
        console.log(`${books[key].id}`);
        console.log(`${books[key].name}`);
        console.log(`${books[key].author}`);
        console.log(`${books[key].year}`);
        console.log("----------------------------");
    }
}