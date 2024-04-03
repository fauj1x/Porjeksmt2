-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2024 at 09:36 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajemenprod`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `jumlah` int(4) NOT NULL,
  `kategori` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jumlah`, `kategori`) VALUES
('B00000', 'kayu pinus', 8, 'jadi');

-- --------------------------------------------------------

--
-- Table structure for table `detail_produksi`
--

CREATE TABLE `detail_produksi` (
  `id_detail_produksi` varchar(7) NOT NULL,
  `jumlah_karyawan` int(11) NOT NULL,
  `id_produksi` varchar(11) DEFAULT NULL,
  `target_produksi` int(11) NOT NULL,
  `anggaran` int(18) NOT NULL,
  `id_karyawan` varchar(6) NOT NULL,
  `id_barang` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `karyawan1`
--

CREATE TABLE `karyawan1` (
  `id_karyawan` varchar(6) NOT NULL,
  `nama_karyawan` varchar(25) NOT NULL,
  `umur` int(2) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `kehadiran` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `karyawan1`
--

INSERT INTO `karyawan1` (`id_karyawan`, `nama_karyawan`, `umur`, `jenis_kelamin`, `alamat`, `jabatan`, `kehadiran`) VALUES
('K0001', 'rudi surya', 99, 'Laki laki', 'Ngawi', 'boss', 'Hadir');

-- --------------------------------------------------------

--
-- Table structure for table `produksi`
--

CREATE TABLE `produksi` (
  `id_produksi` varchar(11) NOT NULL,
  `nama_produksi` varchar(25) NOT NULL,
  `tgl_mul` date NOT NULL,
  `tgl_sel` date NOT NULL,
  `penanggung_jawab` varchar(25) NOT NULL,
  `status` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `produksi`
--
DELIMITER $$
CREATE TRIGGER `update_status_produksi` BEFORE INSERT ON `produksi` FOR EACH ROW BEGIN
    DECLARE tgl_mulai DATE;
    DECLARE tgl_selesai DATE;

    -- Ambil nilai tanggal mulai dan tanggal selesai dari baris yang baru diinsert
    SET tgl_mulai = NEW.tgl_mul;
    SET tgl_selesai = NEW.tgl_sel;

    -- Jika tanggal mulai produksi lebih besar dari tanggal hari ini, set status produksi menjadi 'Berjalan'
    IF tgl_mulai > CURDATE() THEN
        SET NEW.status = 'Berjalan';
    END IF;

    -- Jika tanggal selesai produksi sudah lewat, set status produksi menjadi 'Selesai'
    IF tgl_selesai < CURDATE() THEN
        SET NEW.status = 'Selesai';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `qc_checking`
--

CREATE TABLE `qc_checking` (
  `id_checking` varchar(11) NOT NULL,
  `jumlah_pass` int(4) NOT NULL,
  `jumlah_reject` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `detail_produksi`
--
ALTER TABLE `detail_produksi`
  ADD PRIMARY KEY (`id_detail_produksi`),
  ADD KEY `id_produksi` (`id_produksi`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_karyawan` (`id_karyawan`);

--
-- Indexes for table `karyawan1`
--
ALTER TABLE `karyawan1`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`id_produksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_produksi`
--
ALTER TABLE `detail_produksi`
  ADD CONSTRAINT `detail_produksi_ibfk_2` FOREIGN KEY (`id_produksi`) REFERENCES `produksi` (`id_produksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_produksi_ibfk_3` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_produksi_ibfk_4` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan1` (`id_karyawan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
