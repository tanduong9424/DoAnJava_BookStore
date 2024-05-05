-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 05, 2024 at 05:56 PM
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
(46, 19, 10, 148000, 1480000),
(47, 18, 1, 40000, 40000),
(48, 17, 12, 35000, 420000),
(48, 19, 33, 148000, 4884000),
(48, 20, 2, 100000, 200000),
(48, 21, 1, 70000, 70000),
(49, 18, 1, 40000, 40000),
(49, 20, 2, 100000, 200000),
(49, 20, 3, 100000, 300000),
(50, 18, 12, 40000, 480000),
(50, 21, 3, 70000, 210000),
(50, 19, 33, 148000, 4884000),
(51, 20, 6, 100000, 600000),
(51, 18, 5, 40000, 200000),
(51, 21, 4, 70000, 280000),
(52, 19, 4, 148000, 592000),
(53, 19, 6, 148000, 888000),
(54, 18, 7, 40000, 280000),
(55, 20, 122, 100000, 12200000),
(57, 24, 22, 60000, 1320000),
(57, 23, 3, 40000, 120000);

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
(15, 18, 40000, 88, 3520000),
(15, 19, 148000, 77, 11396000),
(15, 20, 100000, 66, 6600000),
(15, 21, 70000, 55, 3850000),
(16, 21, 70000, 11, 770000),
(16, 19, 148000, 1, 148000),
(16, 20, 100000, 222, 22200000),
(17, 19, 148000, 20, 2960000),
(17, 22, 32000, 33, 1056000),
(17, 23, 40000, 23, 920000),
(17, 24, 60000, 66, 3960000);

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
(46, 1, 1, '2024-04-05', 1332000, 4, 1),
(47, 1, 1, '2024-05-05', 36000, 4, 1),
(48, 2, 1, '2024-06-06', 5016600, 4, 1),
(49, 2, 1, '2024-07-01', 486000, 4, 1),
(50, 2, 1, '2024-05-14', 5016600, 4, 1),
(51, 2, 1, '2024-05-22', 972000, 4, 1),
(52, 10, 1, '2024-08-01', 532800, 4, 1),
(53, 8, 1, '2024-09-05', 799200, 4, 1),
(54, 11, 1, '2024-10-05', 252000, 4, 1),
(55, 1, 1, '2024-05-14', 10980000, 4, 1),
(57, 1, 5, '2024-05-05', 1281600, 12, 1);

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
(1, 'Huỳnh Tấn Dương', 'Tp HCM', 'tduong@gmail.com', 945345832, 1),
(2, 'Lương Cẩm Đào', 'Tp HCM', 'cdao@gmail.com', 943538346, 1),
(8, 'Phạm Trúc Ly', 'Đà Nẵng', 'ly@gmail.com', 947392747, 1),
(10, 'Lê Quý Đôn', 'Quảng Ngãi', 'don@gmail.com', 958374235, 1),
(11, 'Cao Văn Thắng', 'Thanh Hóa', 'thang@gmail.com', 842234211, 1),
(12, 'Lê Chí Cường', 'Quảng Nam', 'cuong@gmail.com', 948342324, 1),
(13, 'Lê Thị Thùy Trang', 'Thái Bình', 'trang@gmail.com', 987534534, 1),
(15, 'Võ Ngọc Châu', 'Vinh', 'chau@gmail.com', 987834544, 1),
(16, 'Lê Minh Hiền', 'Gia Định', 'hien@gmail.com', 354345123, 1),
(17, 'Trương Huỳnh Phương Lan', 'Lào Cai', 'lan@gmail.com', 978543453, 1),
(18, 'Trương Trí Tuệ', 'Vĩnh Long', 'tue@gmail.com', 998354234, 1);

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
(4, '2024-05-05', '2024-05-05', '2024-05-05', 100, 10, 1),
(12, '2024-05-05', '2024-05-05', '2024-05-05', 120000, 11, 0),
(14, '2024-05-05', '2024-05-06', '2024-05-09', 100000, 6, 0),
(15, '2024-05-05', '2024-05-06', '2024-05-10', 220000, 22, 0),
(16, '2024-05-05', '2024-05-01', '2024-05-02', 20000, 12, 0);

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
(1, 'Nguyễn Xuân Duy', 'Tp HCM', 'duy@gmail.com', 943854351, 1),
(5, 'Lê Hoàng Huy', 'Tp HCM', 'huy@gmail.com', 943854343, 1),
(12, 'Hồ Hữu Đại', 'Tp HCM', 'dai@gmail.com', 958832744, 1),
(13, 'Nguyễn Thành Nam', 'Quảng Bình', 'nam@gmail.com', 742239538, 1),
(14, 'Nguyễn Thái Thịnh', 'Đà Nẵng', 'thinh@gmail.com', 966345923, 1),
(15, 'Trương Thị Tú Nhi', 'Hà Nội', 'nhi@gmail.com', 493386434, 1),
(16, 'Lê Chí Đức', 'Quảng Ngãi', 'duc@gmail.com', 957983425, 1),
(17, 'Nguyễn Văn Thắng', 'Huế', 'thang@gmail.com', 947392343, 1),
(18, 'Nguyễn Thanh Truyền', 'Bắc Giang', 'truyen@gmail.com', 583955433, 1);

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
(15, 1, ' Công Ty Cổ Phần Phát Hành Sách Tp. HCM', 25366000, '2024-05-05'),
(16, 1, 'Trường Đại Học Sài Gòn', 23118000, '2024-05-05'),
(17, 5, 'Nhà Cung Cấp Cá Chép', 8896000, '2024-05-05');

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
(17, 'Cho tôi xin một vé đi tuổi thơ', 'img_default.png', 81, 35000, 2, 'Kim Đồng', 0),
(18, 'Dế Mèn phiêu lưu ký', 'img_default.png', 62, 40000, 2, 'Kim Đồng', 0),
(19, 'Đứa trẻ hiểu chuyện thường không có kẹo ăn', 'img_default.png', 10, 148000, 5, 'Nhà xuất bản văn học', 0),
(20, 'Lập Trình Java Căn Bản', 'img_default.png', 53, 100000, 3, 'Nhà Xuất Bản Xây Dựng', 0),
(21, 'Giải Tích 1', 'img_default.png', 58, 70000, 2, 'Nhà Xuất Bản Đại Học Quốc Gia TP.HCM', 0),
(22, 'Cuộc phiêu lưu của Cua ẩn sĩ', 'img_default.png', 33, 32000, 3, 'Kim Đồng', 0),
(23, 'Người biết đi đường dài', 'img_default.png', 20, 40000, 1, 'Kim Đồng', 0),
(24, 'Thị trấn mèo tập 1', 'img_default.png', 44, 60000, 2, 'Kim Đồng', 0);

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
('admin', 'admin', 'Quản Trị Viên', NULL, NULL),
('daoKH', '345', 'Khách Hàng', 2, NULL),
('duongKH', '345', 'Khách Hàng', 1, NULL),
('duongKH2', '678', 'Khách Hàng', 1, NULL),
('htd', '123', 'Quản Trị Viên', NULL, NULL),
('lcdNV', '888', 'Nhân Viên', NULL, 16),
('lhhNV', '123', 'Nhân Viên', NULL, 5),
('nvtNV', '111', 'Nhân Viên', NULL, 17),
('nxdNV', '123', 'Nhân Viên', NULL, 1),
('thplKH', '333', 'Khách Hàng', 17, NULL),
('tttKH', '777', 'Khách Hàng', 18, NULL);

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
  MODIFY `MAHOADON` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `makhuyenmai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `mapn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `MASACH` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

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
