-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 04, 2024 at 04:26 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MAHOADON` int(100) NOT NULL,
  `MASACH` int(100) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `GIATIEN` int(11) NOT NULL,
  `THANHTIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MAHOADON`, `MASACH`, `SOLUONG`, `GIATIEN`, `THANHTIEN`) VALUES
(44, 12, 1, 40000, 40000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `mapn` int(11) NOT NULL,
  `MASACH` int(11) NOT NULL,
  `gianhap` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `tongtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`mapn`, `MASACH`, `gianhap`, `soluong`, `tongtien`) VALUES
(9, 9, 35000, 100, 3500000),
(9, 10, 20000, 100, 2000000),
(9, 11, 90000, 100, 9000000),
(9, 12, 40000, 100, 4000000),
(9, 13, 148000, 100, 14800000),
(9, 14, 70000, 100, 7000000),
(9, 15, 95000, 100, 9500000),
(11, 10, 20000, 3, 60000),
(11, 15, 95000, 5, 475000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHOADON` int(100) NOT NULL,
  `makh` int(100) DEFAULT NULL,
  `manv` int(11) NOT NULL,
  `NGAYLAP` date NOT NULL,
  `TONGTIEN` int(11) NOT NULL,
  `makhuyenmai` int(11) DEFAULT NULL,
  `tthd` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MAHOADON`, `makh`, `manv`, `NGAYLAP`, `TONGTIEN`, `makhuyenmai`, `tthd`) VALUES
(44, 1, 1, '2024-05-01', 36000, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dienthoai` int(11) NOT NULL,
  `tttk` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `hoten`, `diachi`, `email`, `dienthoai`, `tttk`) VALUES
(1, 'Nguyễn Xuân Dương', 'Đà Nẵng', 'xduong@gmail.com', 456433453, 1),
(2, 'Huỳnh Tấn Huy', 'Ninh Bình', 'thuy@gmail.com', 533563422, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `makhuyenmai` int(11) NOT NULL,
  `ngaytao` date NOT NULL,
  `ngaybatdau` date NOT NULL,
  `ngayketthuc` date NOT NULL,
  `tongtiencanthiet` int(11) NOT NULL,
  `phantramgiam` int(11) NOT NULL DEFAULT 1,
  `ISHIDDEN` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`makhuyenmai`, `ngaytao`, `ngaybatdau`, `ngayketthuc`, `tongtiencanthiet`, `phantramgiam`, `ISHIDDEN`) VALUES
(1, '2024-04-29', '2024-04-30', '2024-05-03', 40000, 10, 0),
(2, '2024-04-21', '2024-04-22', '2024-04-30', 3000, 20, 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dienthoai` int(11) NOT NULL,
  `tttk` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `diachi`, `email`, `dienthoai`, `tttk`) VALUES
(1, 'Nguyễn Xuân Duy', 'Tp HCM', 'duy@gmail.com', 94385435, 1),
(5, 'Lê Hoàng Huy', 'Tp HCM', 'huy@gmail.com', 943854343, 1),
(6, 'Lương Cẩm Đào', 'Tp HCM', 'dao@gmail.com', 458345663, 1),
(10, 'Huỳnh Tấn Dương', 'TpHCM', 'duong@gmail.com', 373148245, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `TENNHAXUATBAN` varchar(100) NOT NULL,
  `ISHIDDEN` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`TENNHAXUATBAN`, `ISHIDDEN`) VALUES
('Kim Đồng', 0),
('Nhà Xuất Bản Giáo Dục', 0),
('Nhà xuất bản Trẻ', 0),
('Nhà xuất bản văn học', 0),
('Nhà Xuất Bản Xây Dựng', 0),
('Nhà Xuất Bản Đại Học Quốc Gia TP.HCM', 0);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `mapn` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `noinhap` varchar(255) DEFAULT NULL,
  `tongtien` int(11) NOT NULL,
  `ngaynhap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`mapn`, `manv`, `noinhap`, `tongtien`, `ngaynhap`) VALUES
(9, 1, ' Công Ty Cổ Phần Phát Hành Sách Tp. HCM', 49800000, '2024-05-01'),
(11, 1, ' Công Ty Cổ Phần Phát Hành Sách Tp. HCM', 535000, '2024-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MASACH` int(100) NOT NULL,
  `TENSACH` varchar(100) NOT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `SOLUONG` int(11) NOT NULL DEFAULT 0,
  `GIABIA` int(11) NOT NULL,
  `LANTAIBAN` int(11) DEFAULT NULL,
  `TENNHAXUATBAN` varchar(100) DEFAULT NULL,
  `ISHIDDEN` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MASACH`, `TENSACH`, `IMAGE`, `SOLUONG`, `GIABIA`, `LANTAIBAN`, `TENNHAXUATBAN`, `ISHIDDEN`) VALUES
(9, 'Frieren tập5', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\frieren.jpg', 99, 35000, 1, 'Kim Đồng', 0),
(10, 'Doraemon tập 1', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\doraemon.jpg', 100, 20000, 1, 'Kim Đồng', 0),
(11, 'Cho tôi xin một vé đi tuổi thơ', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\chotoixin1vedituoitho.jpg', 98, 90000, 2, 'Nhà xuất bản Trẻ', 0),
(12, 'Dế Mèn phiêu lưu ký', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\demen.jpg', 97, 40000, 3, 'Kim Đồng', 0),
(13, 'Đứa trẻ hiểu chuyện thường không có kẹo ăn', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\dua-tre-hieu-chuyen-thuong-khong-co-keo-an.jpg', 100, 148000, 5, 'Nhà xuất bản văn học', 0),
(14, 'Giải tích 1', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\gt1.jpg', 99, 70000, 3, 'Nhà Xuất Bản Đại Học Quốc Gia TP.HCM', 0),
(15, 'Lập trình Java', 'C:\\Users\\DELL\\Desktop\\TIEPTUC_DoAnJava_BookStore\\BookStore\\src\\images\\Book_img\\java.png', 105, 95000, 6, 'Nhà Xuất Bản Xây Dựng', 0);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `ROLE` varchar(100) NOT NULL,
  `makh` int(11) DEFAULT NULL,
  `manv` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`USERNAME`, `PASSWORD`, `ROLE`, `makh`, `manv`) VALUES
('aa', 'ssssd', 'Khách Hàng', 2, NULL),
('admin', 'admin', 'Quản Trị Viên', NULL, NULL),
('duongkh', 'vvvv', 'Khách Hàng', 1, NULL),
('duynv', '123', 'Nhân Viên', NULL, 1),
('duythongkeeeeeeee', 'aaaa', 'Nhân Viên', NULL, 1),
('duyxxx1111', 'sss', 'Nhân Viên', NULL, 1),
('huygoblin@gmail.com', '123456', 'Nhân Viên', NULL, 5),
('huyyyyyyyyyyyyyyyyyyyy', 'aaaaaaaaaaaaaaa', 'Khách Hàng', 2, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `chitiethoadon_ibfk_1` (`MASACH`),
  ADD KEY `chitiethoadon_ibfk_2` (`MAHOADON`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `mapn` (`mapn`),
  ADD KEY `MASACH` (`MASACH`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHOADON`),
  ADD KEY `makhuyenmai` (`makhuyenmai`),
  ADD KEY `hoadon_ibfk_1` (`manv`),
  ADD KEY `hoadon_ibfk_5` (`makh`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`makhuyenmai`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`TENNHAXUATBAN`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`mapn`),
  ADD KEY `manv` (`manv`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MASACH`),
  ADD KEY `FK_SACH_NHAXUATBAN` (`TENNHAXUATBAN`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`USERNAME`),
  ADD KEY `makh` (`makh`),
  ADD KEY `manv` (`manv`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MAHOADON` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `makhuyenmai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `mapn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `MASACH` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MASACH`) REFERENCES `sach` (`MASACH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MAHOADON`) REFERENCES `hoadon` (`MAHOADON`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`mapn`) REFERENCES `phieunhap` (`mapn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MASACH`) REFERENCES `sach` (`MASACH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_4` FOREIGN KEY (`makhuyenmai`) REFERENCES `khuyenmai` (`makhuyenmai`),
  ADD CONSTRAINT `hoadon_ibfk_5` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `FK_SACH_NHAXUATBAN` FOREIGN KEY (`TENNHAXUATBAN`) REFERENCES `nhaxuatban` (`TENNHAXUATBAN`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
