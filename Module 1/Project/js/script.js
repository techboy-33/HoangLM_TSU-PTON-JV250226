// Tạo mảng data base
let dataUser = JSON.parse(localStorage.getItem('dataUser')) || []

// check sign in logic

let signInform = document.querySelector("#sign_in #form");
let signInEmailInput = document.querySelector("#sign_in .input.email");
let signInPasswordInput = document.querySelector("#sign_in .input.password");
let signInSuccessMes = document.querySelector("#sign_in .success");
let signInErrorMes = document.querySelector("#sign_in .error");
let signInMesErrorEmail = document.querySelector("#sign_in .error_mess.email");
let signInMesEmailError = document.querySelector("#sign_in .error_mess.email_error");
let signInMesErrorPassword = document.querySelector("#sign_in .error_mess.password");
let signInMesPasswordError = document.querySelector("#sign_in .error_mess.password_error");
let signInCloseBtn = document.querySelector("#sign_in .close_btn");

// Sign in page

if (signInform) {
    signInform.addEventListener("submit", function (event) {
        event.preventDefault();

        let checkSignInEmail = dataUser.some(function (item) {
            return item.email === signInEmailInput.value
        })

        let checkSignInPassword = dataUser.some(function (item) {
            return item.password === signInPasswordInput.value
        })


        if (signInEmailInput.value !== "" && signInPasswordInput.value !== "") {
            // had email and password
            if (checkSignInEmail && checkSignInPassword) {
                // success sign in
                localStorage.setItem("isLoggedIn", "true");
                window.location.href = "../pages/dashboard.html";

            } else if (!checkSignInEmail) {
                // had not email
                signInErrorMes.classList.add("open");
                signInMesEmailError.classList.add("open");
                setTimeout(function () {
                    signInErrorMes.classList.remove("open");
                    signInMesEmailError.classList.remove("open");
                }, 5000);
            } else if (checkSignInEmail && !checkSignInPassword) {
                // had email but password not right
                signInErrorMes.classList.add("open");
                signInMesPasswordError.classList.add("open");
                setTimeout(function () {
                    signInErrorMes.classList.remove("open");
                    signInMesPasswordError.classList.remove("open");
                }, 5000);
            }
        } else if (signInEmailInput.value !== "" && signInPasswordInput.value === "") {
            // had email but had not password
            signInErrorMes.classList.add("open");
            signInMesErrorPassword.classList.add("open");
            setTimeout(function () {
                signInErrorMes.classList.remove("open");
                signInMesErrorPassword.classList.remove("open");
            }, 5000);
        } else if (signInEmailInput.value === "" && signInPasswordInput.value !== "") {
            // had password but had not email
            signInErrorMes.classList.add("open");
            signInMesErrorEmail.classList.add("open");
            setTimeout(function () {
                signInErrorMes.classList.remove("open");
                signInMesErrorEmail.classList.remove("open");
            }, 5000);
        } else if (signInEmailInput.value === "" && signInPasswordInput.value === "") {
            // had not email and password
            signInErrorMes.classList.add("open");
            signInMesErrorEmail.classList.add("open");
            signInMesErrorPassword.classList.add("open");
            setTimeout(function () {
                signInErrorMes.classList.remove("open");
                signInMesErrorEmail.classList.remove("open");
                signInMesErrorPassword.classList.remove("open");
            }, 5000);
        }
    });
    // delete message error
    signInCloseBtn.addEventListener("click", function () {
        signInErrorMes.classList.remove("open");
    });
}

// Show user list when sign in success
document.addEventListener("DOMContentLoaded", function () {
    let isLoggedIn = localStorage.getItem("isLoggedIn");
    let currentPath = window.location.pathname;

    if (isLoggedIn === "true") {
        let dataUser = JSON.parse(localStorage.getItem("dataUser")) || [];
        renderUserList(dataUser);
        renderUserList(1);
    } else {
        if (!currentPath.includes("sign_in.html") && !currentPath.includes("sign_up.html")) {
            window.location.href = "../pages/sign_in.html";
        }
    }
});

// check sign up logic
let signUpform = document.querySelector("#sign_up #form");
let signUpEmailInput = document.querySelector("#sign_up .input.email");
let signUpUsernameInput = document.querySelector("#sign_up .input.username");
let signUpPasswordInput = document.querySelector("#sign_up .input.password");
let signUpSuccessMes = document.querySelector("#sign_up .success");
let signUpErrorMes = document.querySelector("#sign_up .error");
let signUpMesErrorEmail = document.querySelector("#sign_up .error_mess.email");
let signUpMesErrorUsername = document.querySelector("#sign_up .error_mess.username");
let signUpMesErrorPassword = document.querySelector("#sign_up .error_mess.password");
let signUpMesErrorCheckEmail = document.querySelector("#sign_up .error_mess.check_email");
let signUpMesErrorCheckPassword = document.querySelector("#sign_up .error_mess.check_password");
let signUpCloseBtn = document.querySelector("#sign_up .close_btn");


// Sign up page 

if (signUpform) {
    signUpform.addEventListener("submit", function (event) {
        event.preventDefault();
        signUpMesErrorEmail.classList.remove("open");
        signUpMesErrorUsername.classList.remove("open");
        signUpMesErrorPassword.classList.remove("open");

        // Sign up success
        if (signUpEmailInput.value !== "" && signUpUsernameInput.value !== "" && signUpPasswordInput.value !== "") {
            
            let inputUser = {
                id: dataUser.length + 1,
                email: signUpEmailInput.value,
                username: signUpUsernameInput.value,
                password: signUpPasswordInput.value,
                role: "USER",
                status: "active",
                birthday: ""
            };
            // xử lí logic không bị trùng email
            let checkEmail = dataUser.some(function (item) {
                return item.email === inputUser.email
            })
            if (checkEmail) {
                signUpErrorMes.classList.add("open");
                signUpMesErrorCheckEmail.classList.add("open");
                setTimeout(function () {
                    signUpErrorMes.classList.remove("open");
                }, 5000);

            } else {
                // password check
                let checkPassword = /[a-z]/.test(inputUser.password) && /[A-Z]/.test(inputUser.password) && /[0-9]/.test(inputUser.password) && inputUser.password.length >= 8;
                if (checkPassword) {
                    let currentData = JSON.parse(localStorage.getItem("dataUser")) || [];
                    currentData.push(inputUser);
                    localStorage.setItem("dataUser", JSON.stringify(currentData));
                    window.location.href = "../pages/sign_in.html"
                    setTimeout(function () {
                        signUpSuccessMes.classList.remove("open");
                    }, 3000);
                } else {
                    signUpErrorMes.classList.add("open");
                    signUpMesErrorCheckPassword.classList.add("open");
                    setTimeout(function () {
                        signUpErrorMes.classList.remove("open");
                    }, 7000);
                }
            }

        } else if (signUpEmailInput.value === "" || signUpUsernameInput.value === "" || signUpPasswordInput.value === "") {
            signUpErrorMes.classList.add("open");

            // logic sign up check input
            let inputsArray = [signUpEmailInput, signUpUsernameInput, signUpPasswordInput];
            let messagesArray = [signUpMesErrorEmail, signUpMesErrorUsername, signUpMesErrorPassword];
            for (index in inputsArray) {
                if (inputsArray[index]) {
                    if (inputsArray[index].value === "") {
                        messagesArray[index].classList.add("open")
                    } else {
                        messagesArray[index].classList.remove("open")
                    }
                }
            }
            setTimeout(function () {
                signUpErrorMes.classList.remove("open");
            }, 5000);
        }

    });
    signUpCloseBtn.addEventListener("click", function () {
        signUpErrorMes.classList.remove("open");
    });
}


// dash board page logic
if (window.location.pathname.includes("dashboard.html")) {

    function renderUserList(page = 1, customList = null) {
        const usersPerPage = 5;
        let dataUser = customList || JSON.parse(localStorage.getItem("dataUser")) || [];

        const startIndex = (page - 1) * usersPerPage;
        const paginatedUsers = dataUser.slice(startIndex, startIndex + usersPerPage);

        const userTableBody = document.getElementById("user_table_body");
        userTableBody.innerHTML = "";

        paginatedUsers.forEach(user => {
            let userTr = document.createElement("tr");
            userTr.classList.add("user_item");

            userTr.innerHTML = `
                <td class="user_info user_number">TR00${user.id}</td>
                <td class="user_info user_name">${user.username}</td>
                <td class="user_info user_email">${user.email}</td>
                <td class="user_info user_role">${user.role}</td>
                <td class="user_info user_birthday">${user.birthday}</td>
                <td class="user_info user_status">
                    <li class="user_status_item active ${user.status === 'active' ? 'open' : ''}">Active</li>
                    <li class="user_status_item deactivate ${user.status === 'deactivate' ? 'open' : ''}">Deactivate</li>
                </td>
                <td class="user_info user_actions">
                    <i class="fa-solid fa-trash delete_btn" id="user-${user.id}"></i>
                    <i class="fa-solid fa-pencil edit_btn" id="user-${user.id}"></i>
                </td>
            `;
            userTableBody.appendChild(userTr);
        });

        deleteEventListeners();
        editEventListeners();
        renderPagination(dataUser.length, page);
    }


    function renderPagination(totalItems, currentPage) {
        const usersPerPage = 5;
        const totalPages = Math.ceil(totalItems / usersPerPage);

        const paginationContainer = document.getElementById("pagination");
        paginationContainer.innerHTML = "";

        for (let i = 1; i <= totalPages; i++) {
            let pageBtn = document.createElement("button");
            pageBtn.textContent = i;
            pageBtn.className = className = "pagination-btn" + (i === currentPage ? " active" : "");

            pageBtn.addEventListener("click", () => {
                
                const dataToRender = filteredUsers || JSON.parse(localStorage.getItem("dataUser")) || [];
                renderUserList(i, dataToRender);
            });

            paginationContainer.appendChild(pageBtn);
        }
    }

    function deleteEventListeners() {
        document.querySelectorAll(".delete_btn").forEach(btn => {
            btn.addEventListener("click", function () {
                let userId = parseInt(this.id.split("-")[1]);

                let dataUser = JSON.parse(localStorage.getItem("dataUser")) || [];
                let newList = dataUser.filter(user => user.id !== userId);

                localStorage.setItem("dataUser", JSON.stringify(newList));

                renderUserList();
            });
        });
    }

    function editEventListeners() {
        document.querySelectorAll(".edit_btn").forEach(button => {
            button.addEventListener("click", function () {
                let userId = Number(this.id.split("-")[1]);
                currentEditingUserId = userId;

                let dataUser = JSON.parse(localStorage.getItem("dataUser")) || [];
                let user = dataUser.find(u => u.id === userId);

                document.getElementById("user_list").style.display = "none";
                document.getElementById("edit_user").style.display = "block";

                document.querySelector("#edit_user input[name='userName']").value = user.username;
                document.querySelector("#edit_user input[name='email']").value = user.email;
                document.querySelector("#edit_user input[name='password']").value = user.password;
                document.querySelector("#edit_user input[name='birthday']").value = user.birthday || "";

                document.querySelectorAll("#edit_user input[name='status']").forEach(radio => {
                    radio.checked = radio.value === user.status;
                });
            });
        });
    }

    // search logic
    let searchInput = document.querySelector(".search_input");
    let filteredUsers = null;

    // Gọi lại hàm render với danh sách lọc
    function searchUsersByName(keyword) {
        const allUsers = JSON.parse(localStorage.getItem("dataUser")) || [];
        filteredUsers = allUsers.filter(user =>
            user.username.toLowerCase().includes(keyword.toLowerCase())
        );
        renderUserList(1, filteredUsers);
    }

    // Hoặc tìm kiếm ngay khi nhập
    searchInput.addEventListener("input", function () {
        const keyword = searchInput.value.trim();
        searchUsersByName(keyword);
    });

    // delete user
    document.querySelectorAll(".delete_btn").forEach(btn => {
        btn.addEventListener("click", function () {
            let btnId = this.id;

            // Lấy mỗi số id
            let userId = parseInt(btnId.split("-")[1]);

            // Lấy data từ localStorage
            let dataUser = JSON.parse(localStorage.getItem("dataUser")) || [];

            // Xóa user có id trùng
            let newList = dataUser.filter(user => user.id !== userId);

            // Lưu lại
            localStorage.setItem("dataUser", JSON.stringify(newList));

            // reload lại trang
            location.reload();
        });
    });

    // edit pages
    let yourDassboardBtn = document.querySelector(".your_dashboard_name");
    let addUserBtn = document.querySelector(".add_new_user");

    // when click user dash board
    yourDassboardBtn.addEventListener("click", function (event) {
        event.preventDefault();
        document.getElementById("edit_user").style.display = "none";
        document.getElementById("add_new_user").style.display = "none";
        document.getElementById("user_list").style.display = "block";

        renderUserList();
    });

    // when click add new user button
    addUserBtn.addEventListener("click", function (event) {
        event.preventDefault();
        document.getElementById("edit_user").style.display = "none";
        document.getElementById("user_list").style.display = "none";

        document.getElementById("add_new_user").style.display = "block";
    })




    // when click edit button
    let currentEditingUserId = null;

    document.querySelectorAll(".edit_btn").forEach(button => {
        button.addEventListener("click", function () {
            // Lấy id user cần chỉnh sửa từ button
            let userId = Number(this.id.split("-")[1]);
            currentEditingUserId = userId;

            // Lấy thông tin user từ dataUser trong localStorage
            let currentData = JSON.parse(localStorage.getItem("dataUser")) || [];
            let user = currentData.find(u => u.id === userId);

            // Hiển thị form edit
            document.getElementById("user_list").style.display = "none";
            document.getElementById("edit_user").style.display = "block";

            // Điền dữ liệu cũ vào form
            document.querySelector("#edit_user input[name='userName']").value = user.username;
            document.querySelector("#edit_user input[name='email']").value = user.email;
            document.querySelector("#edit_user input[name='password']").value = user.password;
            document.querySelector("#edit_user input[name='birthday']").value = user.birthday || "";

            // Chọn đúng status
            document.querySelectorAll("#edit_user input[name='status']").forEach(radio => {
                if (radio.value === user.status) {
                    radio.checked = true;
                }
            });
        });
    });

    // Lắng nghe sự kiện submit form edit
    let editUserForm = document.querySelector("#edit_user");

    if (editUserForm) {
        editUserForm.addEventListener("submit", function (event) {
            event.preventDefault();

            // Lấy các input trong form
            let usernameInput = editUserForm.querySelector('input[name="userName"]');
            let emailInput = editUserForm.querySelector('input[name="email"]');
            let passwordInput = editUserForm.querySelector('input[name="password"]');
            let roleInput = editUserForm.querySelector('select[name="role"]');
            let birthdayInput = editUserForm.querySelector('input[name="birthday"]');
            let statusInput = editUserForm.querySelector('input[name="status"]:checked'); // Chọn radio được chọn

            // Lấy các message lỗi
            let errorMes = document.querySelector(".mes_area .error");
            let errorEmail = document.querySelector(".mes_area .error_mess.email");
            let errorUsername = document.querySelector(".mes_area .error_mess.username");
            let errorPassword = document.querySelector(".mes_area .error_mess.password");
            let errorCheckEmail = document.querySelector(".mes_area .error_mess.check_email");
            let errorCheckPassword = document.querySelector(".mes_area .error_mess.check_password");

            // Reset lỗi
            [errorEmail, errorUsername, errorPassword, errorCheckEmail, errorCheckPassword].forEach(e => e.classList.remove("open"));
            errorMes.classList.remove("open");

            // Validate rỗng cho các trường bắt buộc
            let isValid = true;
            if (emailInput.value.trim() === "") {
                errorEmail.classList.add("open");
                isValid = false;
            }
            if (usernameInput.value.trim() === "") {
                errorUsername.classList.add("open");
                isValid = false;
            }
            if (passwordInput.value.trim() === "") {
                errorPassword.classList.add("open");
                isValid = false;
            }

            // Nếu có lỗi thì không lưu
            if (!isValid) {
                errorMes.classList.add("open");
                setTimeout(() => errorMes.classList.remove("open"), 5000);
                return;
            }

            let checkPassword = /[a-z]/.test(passwordInput.value) && /[A-Z]/.test(passwordInput.value) && /[0-9]/.test(passwordInput.value) && passwordInput.value.length >= 8;
            if (!checkPassword) {
                errorCheckPassword.classList.add("open");
                errorMes.classList.add("open");
                setTimeout(() => errorMes.classList.remove("open"), 7000);
                return;
            }

            // Lấy dữ liệu từ localStorage
            let currentData = JSON.parse(localStorage.getItem("dataUser")) || [];

            // Tạo đối tượng user mới sau khi edit
            let editedUser = {
                id: currentEditingUserId,
                username: usernameInput.value.trim(),
                email: emailInput.value.trim(),
                password: passwordInput.value.trim(),
                role: roleInput?.value || "USER",
                status: statusInput?.value || "active",
                birthday: birthdayInput?.value || ""
            };

            // Cập nhật lại thông tin của user
            let userIndex = currentData.findIndex(u => u.id === currentEditingUserId);
            if (userIndex !== -1) {
                currentData[userIndex] = editedUser;
                localStorage.setItem("dataUser", JSON.stringify(currentData)); // Lưu lại vào localStorage
            }

            // Chuyển hướng về dashboard sau khi chỉnh sửa thành công
            window.location.href = "../pages/dashboard.html";
        });
    }


    // when click Save and Back button
    let backBtnAddPage = document.querySelector("#add_new_user .back_btn");
    let backBtnEditPage = document.querySelector("#edit_user .back_btn");

    // Back button edit uuser
    backBtnEditPage.addEventListener("click", function (event) {
        event.preventDefault();
        document.getElementById("edit_user").style.display = "none";
        document.getElementById("user_list").style.display = "block";
        currentEditingUserId = null;
    });


    // add user
    let addUserForm = document.querySelector("#add_new_user");

    if (addUserForm) {
        addUserForm.addEventListener("submit", function (event) {
            event.preventDefault();

            // Lấy các input
            let emailInput = addUserForm.querySelector('input[name="email"]');
            let usernameInput = addUserForm.querySelector('input[name="username"]');
            let passwordInput = addUserForm.querySelector('input[name="password"]');
            let roleInput = addUserForm.querySelector('select[name="role"]');
            let birthdayInput = addUserForm.querySelector('input[name="birthday"]');
            let statusInput = addUserForm.querySelector('input[name="status"]:checked');

            // Lấy các message lỗi
            let errorMes = document.querySelector(".mes_area .error");
            let errorEmail = document.querySelector(".mes_area .error_mess.email");
            let errorUsername = document.querySelector(".mes_area .error_mess.username");
            let errorPassword = document.querySelector(".mes_area .error_mess.password");
            let errorCheckEmail = document.querySelector(".mes_area .error_mess.check_email");
            let errorCheckPassword = document.querySelector(".mes_area .error_mess.check_password");

            // Reset lỗi
            [errorEmail, errorUsername, errorPassword, errorCheckEmail, errorCheckPassword].forEach(e => e.classList.remove("open"));
            errorMes.classList.remove("open");

            // Validate rỗng
            let isValid = true;
            if (emailInput.value.trim() === "") {
                errorEmail.classList.add("open");
                isValid = false;
            }
            if (usernameInput.value.trim() === "") {
                errorUsername.classList.add("open");
                isValid = false;
            }
            if (passwordInput.value.trim() === "") {
                errorPassword.classList.add("open");
                isValid = false;
            }

            if (!isValid) {
                errorMes.classList.add("open");
                setTimeout(() => errorMes.classList.remove("open"), 5000);
                return;
            }

            let currentData = JSON.parse(localStorage.getItem("dataUser")) || [];

            let inputUser = {
                id: currentData.length + 1,
                email: emailInput.value.trim(),
                username: usernameInput.value.trim(),
                password: passwordInput.value,
                role: roleInput?.value || "USER",
                status: statusInput?.value || "active",
                birthday: birthdayInput?.value || "",
            };

            let checkEmail = currentData.some(item => item.email === inputUser.email);
            if (checkEmail) {
                errorCheckEmail.classList.add("open");
                errorMes.classList.add("open");
                setTimeout(() => errorMes.classList.remove("open"), 5000);
                return;
            }

            let checkPassword = /[a-z]/.test(inputUser.password) && /[A-Z]/.test(inputUser.password) && /[0-9]/.test(inputUser.password) && inputUser.password.length >= 8;
            if (!checkPassword) {
                errorCheckPassword.classList.add("open");
                errorMes.classList.add("open");
                setTimeout(() => errorMes.classList.remove("open"), 7000);
                return;
            }

            currentData.push(inputUser);
            localStorage.setItem("dataUser", JSON.stringify(currentData));

            window.location.href = "../pages/dashboard.html";
        });
    }

    // Back button add user page
    backBtnAddPage.addEventListener("click", function (event) {
        event.preventDefault();
        document.getElementById("add_new_user").style.display = "none";
        document.getElementById("user_list").style.display = "block";
        currentEditingUserId = null;
    });

    // logout
    document.querySelector(".logout_btn").addEventListener("click", function () {
        localStorage.removeItem("isLoggedIn");
        window.location.href = "../pages/sign_in.html";
    });
}
