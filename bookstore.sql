-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2024 at 12:00 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

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
(38, 1, 50000, 2, 25000),
(38, 2, 22000, 1, 22000),
(39, 1, 25000, 1, 25000),
(39, 2, 22000, 1, 22000);

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
(3, 1, 5, 22000, 110000),
(3, 8, 2, 40000, 80000),
(4, 8, 6, 30000, 180000),
(4, 2, 9, 22000, 198000),
(4, 1, 5, 20000, 100000),
(5, 8, 1, 50000, 50000),
(6, 2, 22000, 1, 22000);

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
(38, 2, 1, '2024-04-26', 72000, NULL, 1),
(39, 1, 1, '2024-04-27', 47000, NULL, 1);

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
(1, 'huỳnh tấn dương', '12', 'sadfsdf@gmail.com', 1213323, 1),
(2, 'HUY', '1221', 'HUY@', 239492394, 0),
(3, 'duy', 'nhà mới', 'duydan@gmai.com', 123456789, 1),
(4, 'đào', '098', '098', 98, 1);

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
(1, 'huy', '179', '@gmail.com', 9, 0),
(2, 'dương', '1', '1', 1, 1),
(5, 'huy', '179', '@gmail.com', 9, 1),
(6, 'huy', '179', '@gmail.com', 9, 1);

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
('Nhà Xuất Bản Giáo Dục', 0);

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
(1, 1, 'ĐẠI HỌC SÀI GÒN', 50000, '2024-04-23'),
(3, 1, '', 190000, '2024-04-30'),
(4, 1, '', 478000, '2024-04-30'),
(5, 1, '', 50000, '2024-04-30'),
(6, 1, '', 22000, '2024-04-30');

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
(1, 'Doreamon', NULL, 20001, 25000, 5, 'Kim Đồng', 0),
(2, 'Conan', NULL, 22001, 22000, 2, 'Kim Đồng', 0),
(8, 'Dragon Ball', 'C:\\Users\\Admin\\Pictures\\Saved Pictures\\superhuman.jpg', 80001, 50000, 2, 'Kim Đồng', 0);

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
('dương', '123', 'nv', NULL, NULL),
('duyduongngu', '123', 'Nhân Viên', NULL, 1),
('huy', '123', 'Quản Trị Viên', NULL, NULL),
('huygoblin@gmail.com', '123456', 'Nhân Viên', NULL, 5);

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
  MODIFY `MAHOADON` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `makhuyenmai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `mapn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `MASACH` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
