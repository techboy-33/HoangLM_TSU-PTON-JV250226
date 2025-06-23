-- 2.2. Thiết kế cơ sở dữ liệu có tên Ecommerce từ ERD

create database Ecommerce;
use Ecommerce;
CREATE TABLE User
(
    user_id    INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Category
(
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE Product
(
    product_id  CHAR(5) PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL UNIQUE,
    price       DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    stock       INT DEFAULT 0,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Category (category_id)
);

CREATE TABLE `Order`
(
    order_id     INT AUTO_INCREMENT PRIMARY KEY,
    user_id      INT,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);

CREATE TABLE Order_Detail
(
    order_id      INT,
    product_id    CHAR(5),
    quantity      INT            NOT NULL CHECK (quantity > 0),
    price_at_time DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES `Order` (order_id),
    FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

-- 2.3. Sử dụng câu lệnh insert thêm dữ liệu cho các bảng

INSERT INTO Category (name, description)
VALUES ('Điện tử', 'Thiết bị công nghệ'),
       ('Thời trang', 'Quần áo, phụ kiện'),
       ('Gia dụng', 'Đồ dùng gia đình'),
       ('Thể thao', 'Thiết bị thể thao'),
       ('Sách', 'Sách học, kỹ năng, kỹ thuật');

INSERT INTO User (name, email, password)
VALUES ('Nguyễn Văn An', 'annv@gmail.com', '123456'),
       ('Trần Thị Bình', 'binhtt@rikkeisoft.com', '123456'),
       ('Lê Văn Chiến', 'chienlv@rikkei.academy.com', '123456'),
       ('Nguyễn Hà Quyên', 'quyennh@rikkei.education.com', '123456'),
       ('Võ Văn Hải', 'haivv@rikkei.education.com', '123456');

INSERT INTO Product (product_id, name, price, stock, category_id)
VALUES ('P001', 'Iphone 14', 20000000, 10, 1),
       ('P002', 'Laptop Dell XPS', 30000000, 5, 1),
       ('P003', 'Áo thun nam', 250000, 50, 2),
       ('P004', 'Quần jeans nữ', 400000, 40, 2),
       ('P005', 'Nồi cơm điện Sharp', 800000, 20, 3);

INSERT INTO `Order` (user_id, total_amount, created_at)
VALUES (1, 20200000, '2024-06-01'),
       (2, 325000, '2024-06-01'),
       (3, 800000, '2024-06-02'),
       (4, 1500000, '2024-06-02'),
       (5, 700000, '2024-08-03'),
       (1, 150000, '2024-08-03'),
       (2, 3000000, '2024-08-03'),
       (3, 400000, '2024-08-03'),
       (4, 600000, '2024-09-20'),
       (5, 800000, '2024-09-20');

INSERT INTO Order_Detail (order_id, product_id, quantity, price_at_time)
VALUES (1, 'P001', 1, 20000000),
       (1, 'P003', 1, 250000),
       (2, 'P004', 1, 400000),
       (2, 'P005', 1, 800000),
       (3, 'P003', 2, 250000),
       (4, 'P002', 1, 30000000),
       (5, 'P005', 1, 800000),
       (6, 'P001', 1, 20000000),
       (7, 'P002', 1, 30000000),
       (8, 'P004', 1, 400000),
       (9, 'P003', 2, 250000),
       (10, 'P005', 1, 800000);

-- 2.4. Cập nhật dữ liệu

update Product
set stock = 3
where  product_id = 'P002';

update  category
set name = 'Thời trang và phụ kiện'
where name = 'Thời trang';

-- 2.5. Xóa danh mục có tên là ‘Sách’

delete from Category
where name = 'Sách';

-- select * from Category;