create database StudentManagement;

use studentmanagement;
CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Classes (
    class_id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Teachers (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE ClassAssignments (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    class_id INT,
    teacher_id INT,
    FOREIGN KEY (student_id)
        REFERENCES Students (student_id),
    FOREIGN KEY (class_id)
        REFERENCES Classes (class_id),
    FOREIGN KEY (teacher_id)
        REFERENCES Teachers (teacher_id)
);


INSERT INTO Students (full_name, date_of_birth, email) VALUES
    ('Nguyễn Văn An', '2005-03-15', 'an.nguyen@example.com'),
    ('Trần Thị Bình', '2004-07-22', 'binh.tran@example.com'),
    ('Lê Minh Cường', '2006-01-10', 'cuong.le@example.com'),
    ('Phạm Thị Dung', '2003-11-05', 'dung.pham@example.com'),
    ('Hoàng Văn Em', '2005-09-01', 'em.hoang@example.com'),
    ('Nguyễn Văn Tân', '2003-05-15', 'tan.nguyen@example.com'),
    ('Trần Thị Ngọc', '1996-07-22', 'ngoc.tran@example.com'),
    ('Nguyễn Hoàng Cường', '1996-01-10', 'cuong.nguyen33@example.com'),
    ('Phạm Thị Hoài', '2005-11-15', 'hoai.pham2005@example.com'),
    ('Hoàng Văn Thụ', '2003-09-01', 'thu.hoang@example.com'),
    ('Nguyễn Duy Tân', '2000-05-15', 'tan.nguyen2000@example.com'),
    ('Trần Thị Bích Ngọc', '1998-07-12', 'ngoc.tran98@example.com'),
    ('Nguyễn Xuân Cường', '1996-01-10', 'cuong.nguyen96@example.com'),
    ('Phạm Thị Hoài Xuân', '2000-11-15', 'hoaixuan.pham2000@example.com'),
    ('Hoàng Minh Đạt', '2002-08-01', 'datminh.hoang@example.com');

INSERT INTO Classes (class_name) VALUES
    ('Toán'),
    ('Lý'),
    ('Sinh'),
    ('Văn'),
    ('Sử');

INSERT INTO Teachers (full_name, email) VALUES
    ('PGS.TS. Nguyễn A', 'nguyena@university.edu'),
    ('TS. Trần B', 'tranb@university.edu'),
    ('ThS. Lê C', 'lec@university.edu'),
    ('Cô Phạm D', 'phamde@university.edu'),
    ('Thầy Hoàng E', 'hoange@university.edu');

INSERT INTO ClassAssignments (student_id, class_id, teacher_id) VALUES
    (1, 1, 1), (2, 2, 2), (3, 3, 3), (4, 1, 4), (5, 5, 5),
    (2, 1, 2), (4, 1, 4), (5, 2, 5), (2, 2, 3), (4, 1, 2),
    (5, 2, 5), (2, 5, 2), (4, 1, 1), (2, 1, 2), (3, 2, 2),
    (6, 1, 1), (7, 2, 2), (8, 3, 3), (9, 4, 4), (10, 5, 5),
    (11, 1, 2), (12, 2, 3), (13, 3, 4), (14, 4, 5), (15, 5, 1),
    (6, 2, 1), (7, 1, 2), (8, 5, 3), (9, 3, 4), (10, 4, 5);

-- Xóa tạo lại table 
-- drop table classassignments;
-- drop table classes;
-- drop table teachers;
-- drop table students;

-- 1. Lấy tất cả thông tin sinh viên cùng với tên lớp và tên giáo viên của sinh viên đó .
select  s.student_id ,
		s.full_name as StudentName,
        s.date_of_birth as StudentBirthDate,
		s.email as StudentEmail,
        c.class_name,
        t.full_name as TeacherName
from Students s
join ClassAssignments ca on ca.student_id = s.student_id
join Classes c on c.class_id = ca.class_id
join Teachers t on t.teacher_id = ca.teacher_id;

-- 2. Tìm sinh viên có email chứa "ng" và sinh năm lớn hơn 2000.
select full_name as StudentName, date_of_birth as StudentBirthDate, email as StudentEmail
from students
where email like '%ng%' and year(date_of_birth) > 2000;

-- 3. Cập nhật tên lớp cho sinh viên có student_id = 2.
update ClassAssignments
set class_id = 3
where student_id = 2;

-- In ra xem thay đổi 
select class_name as NewClassName
from Classes
where class_id in (select class_id
					from ClassAssignments
                    where student_id = 2);

-- 4. Xóa sinh viên có student_id = 3 và tất cả thông tin liên quan.
-- Xóa khóa ngoại trước  
delete from ClassAssignments
where student_id = 3;

-- Xóa khóa chính sau  
delete from students
where student_id = 3;

-- 5. Đếm số sinh viên trong từng lớp và chỉ hiển thị lớp có hơn 3 sinh viên.
select c.class_name, count(ca.student_id) as NumberOfStudents
from classes c
join classassignments ca on c.class_id = ca.class_id
group by c. class_name
having count(ca.student_id) > 3;

-- 6. Tìm giáo viên dạy nhiều lớp nhất.
select t.full_name as TeacherName, count(distinct ca.class_id) as NumberOfClassesTaught
from teachers t
join classassignments ca on ca.teacher_id = t.teacher_id
group by t.teacher_id
having count(distinct ca.class_id) = (
			select count(distinct class_id)
			from classassignments
			group by teacher_id
			order by count(distinct class_id) desc
			limit 1);

-- 7. Lấy danh sách sinh viên và số lượng lớp tham gia của họ.
select s.full_name as StudentName, count(ca.class_id) as NumberOfClass
from students s
join classassignments ca on ca.student_id = s.student_id
group by s.student_id;

-- 8. Tìm lớp có số sinh viên lớn hơn trung bình của tất cả các lớp.
select c.class_name, count(ca.student_id) as StudentCount
from classes c
join classassignments ca on c.class_id = ca.class_id
group by c.class_id
having count(ca.student_id) > (select avg(student_count) 
							from (select count(*) as student_count
								  from classassignments
								  group by class_id) as sub);

-- 9. Tìm giáo viên dạy sinh viên có student_id = 1.
select t.full_name as TeacherName, ca.student_id
from teachers t
join classassignments ca on t.teacher_id = ca.teacher_id
where ca.student_id = 1;

-- 10. Lấy danh sách sinh viên sắp xếp theo ngày sinh từ sớm đến muộn.
select full_name as StudentName, date_of_birth
from students
order by date_of_birth;

-- 11. Tìm sinh viên có tên bắt đầu bằng 'A' và tham gia ít nhất 2 lớp.
select s.full_name as StudentName, count(distinct ca.class_id)
from students s
join classassignments ca on s.student_id = ca.student_id
where LOWER(SUBSTRING_INDEX(full_name, ' ', -1)) LIKE 'a%'
group by s.student_id
having count(distinct ca.class_id) >= 2;

-- 12. Tìm các giáo viên không dạy lớp nào.
select t.full_name as TeacherName
from teachers t
left join classassignments ca on t.teacher_id = ca.teacher_id
where ca.class_id is  null;

-- 13. Lấy thông tin lớp và giáo viên cho những sinh viên có điểm trung bình lớn hơn 8.0.


-- 14. Thống kê số lượng giáo viên và sinh viên theo từng lớp.
select c.class_name as ClassName, count(distinct ca.student_id) as StudentCount, count(distinct ca.teacher_id) as TeacherCount
from classassignments ca
join classes c on c.class_id = ca.class_id
group by ca.class_id;

-- 15. Lấy danh sách sinh viên có số lớp tham gia bằng số lớp tối đa. 
select s.full_name as StudentName,count(distinct ca.class_id) as ClassCount
from students s
join classassignments ca on ca.student_id = s.student_id
group by s.student_id
having count(distinct ca.class_id) in (select count(*) from classes);



