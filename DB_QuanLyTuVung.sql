DROP DATABASE IF EXISTS quan_ly_tu_vung;
CREATE DATABASE quan_ly_tu_vung;
USE quan_ly_tu_vung;

-- Tạo bảng User
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender ENUM('Female', 'Male'),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);


-- Tạo bảng Admin
DROP TABLE IF EXISTS teacher;
create table teacher (
	id INT PRIMARY KEY ,
	`level` INT NOT NULL,
	country_name ENUM ("VietNam","Japan") NOT NULL,
	ExpInYear INT NOT NULL
     FOREIGN KEY (id) REFERENCES `User`(id) ON DELETE CASCADE
);

-- Chèn dữ liệu vào bảng teacher
INSERT INTO teacher (`level`, country_name, ExpInYear) VALUES
(1, 'VietNam', 5),
(2, 'Japan', 10),
(3, 'VietNam', 8),
(4, 'Japan', 12);

-- Thêm dữ liệu cho bảng User
insert into `user` (id, first_name, last_name, gender, email, pass_word) 
values  (1, 'Denna', 'Cohn', 'Female', 'dcohn0@wordpress.com', 'aI3|F)MJgtZq0'),
		(2, 'Ingra', 'Coorington', 'Male', 'icoorington1@wp.com', 'kM7&%=JI'),
		(3, 'Arly', 'Angelo', 'Female', 'aangelo2@harvard.edu', 'iU5!&`P<~82vU+i6'),
		(4, 'Trenton', 'Gallamore', 'Male', 'tgallamore3@de.vu', 'nH4(E\aG{c'),
		(5, 'Viviene', 'Draayer', 'Female', 'vdraayer4@marriott.com', 'qA2@Y=S0}O'),
		(6, 'Vidovic', 'Garaway', 'Male', 'vgaraway5@seesaa.net', 'pE6<9gVfm0M'),
		(7, 'Janot', 'Hurles', 'Female', 'jhurles6@myspace.com', 'qZ7''UnBabQ'),
		(8, 'Bertie', 'Cowins', 'Female', 'bcowins7@virginia.edu', 'uC8.aPqMeY9@>mSR'),
		(9, 'Natty', 'Ivasyushkin', 'Female', 'nivasyushkin8@dailymail.co.uk', 'oY3*TmUsB~o7J'),
		(10, 'Stearne', 'Fowley', 'Male', 'sfowley9@wunderground.com', 'yV8<Y\qpib86y`in');