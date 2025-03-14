DROP DATABASE IF EXISTS quan_ly_tu_vung;
CREATE DATABASE quan_ly_tu_vung;
USE quan_ly_tu_vung;

-- Tạo bảng User
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(50) NOT NULL,
    gender ENUM('Female', 'Male'),
    age INT NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL  -- Sửa VARCHAR(12) -> VARCHAR(50)
);

-- Tạo bảng Teacher
DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher (
    id INT PRIMARY KEY,
    levelNow INT NOT NULL,
    ExpInYear INT NOT NULL,    
    country ENUM("VietNam", "Japan") NOT NULL,
    FOREIGN KEY (id) REFERENCES `user`(id) ON DELETE CASCADE
);

-- Tạo bảng Student
DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id INT PRIMARY KEY,
    levelNow INT NOT NULL,
    finishedWord INT NOT NULL,
    FOREIGN KEY (id) REFERENCES `user`(id) ON DELETE CASCADE
);

-- Chèn dữ liệu vào bảng User trước
INSERT INTO `user` (fullName, gender, age, email, password) VALUES
    ('Nguyễn Văn A', 'Male', 30, 'nguyenvana@example.com', 'password123'),
    ('Trần Thị B', 'Female', 25, 'tranthib@example.com', 'abc@12345'),
    ('Lê Văn C', 'Male', 40, 'levanc@example.com', 'securePass!'),
    ('Hoàng Thị D', 'Female', 35, 'hoangthid@example.com', 'mypassword'),
    ('Phạm Văn E', 'Male', 28, 'phamvane@example.com', 'pass@word1'),
    ('Đặng Thị F', 'Female', 32, 'dangthif@example.com', 'admin123'),
    ('Bùi Văn G', 'Male', 27, 'buivang@example.com', 'qwerty2024'),
    ('Đỗ Thị H', 'Female', 29, 'dothih@example.com', 'letmein321'),
    ('Vũ Văn I', 'Male', 45, 'vuvani@example.com', 'helloWorld'),
    ('Lý Thị J', 'Female', 26, 'lythij@example.com', 'test@12345'),                    
    ('Denna Cohn', 'Female', 30, 'dcohn0@wordpress.com', 'aI3|F)MJgtZq0'),
    ('Ingra Coorington', 'Male', 28, 'icoorington1@wp.com', 'kM7&%=JI'),
    ('Arly Angelo', 'Female', 35, 'aangelo2@harvard.edu', 'iU5!&`P<~82vU+i6'),
    ('Trenton Gallamore', 'Male', 40, 'tgallamore3@de.vu', 'nH4(E\\aG{c'),
    ('Viviene Draayer', 'Female', 27, 'vdraayer4@marriott.com', 'qA2@Y=S0}O'),
    ('Vidovic Garaway', 'Male', 33, 'vgaraway5@seesaa.net', 'pE6<9gVfm0M'),
    ('Janot Hurles', 'Female', 25, 'jhurles6@myspace.com', 'qZ7\UnBabQ'),
    ('Bertie Cowins', 'Female', 29, 'bcowins7@virginia.edu', 'uC8.aPqMeY9@>mSR'),
    ('Natty Ivasyushkin', 'Female', 31, 'nivasyushkin8@dailymail.co.uk', 'oY3*TmUsB~o7J'),
    ('Stearne Fowley', 'Male', 26, 'sfowley9@wunderground.com', 'yV8<Y\\qpib86yin');

-- Chèn dữ liệu vào bảng Student
INSERT INTO student (id, levelNow, finishedWord) VALUES
    (1, 1, 50),
    (4, 2, 100),
    (5, 3, 75),
    (6, 4, 120),
    (12, 2, 90),
    (14, 5, 130),
    (15, 3, 80),
    (16, 4, 110),
    (17, 1, 60),
    (19, 5, 140);

-- Chèn dữ liệu vào bảng Teacher
INSERT INTO teacher (id, levelNow, country, ExpInYear) VALUES
    (2, 1, 'VietNam', 5),
    (3, 2, 'Japan', 10),
    (7, 3, 'VietNam', 8),
    (8, 4, 'Japan', 12),
    (9, 2, 'VietNam', 6),
    (10, 5, 'Japan', 9),
    (11, 3, 'VietNam', 7),
    (13, 1, 'VietNam', 3),
    (18, 5, 'Japan', 10),
    (20, 5, 'VietNam', 4);

