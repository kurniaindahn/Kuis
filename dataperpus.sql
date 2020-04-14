-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 01:11 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dataperpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `NIS` varchar(10) NOT NULL,
  `Nama_Siswa` varchar(20) NOT NULL,
  `TTL` date NOT NULL,
  `Jenis_Kelamin` varchar(10) NOT NULL,
  `Agama` varchar(10) NOT NULL,
  `Tgl_Daftar` date NOT NULL,
  `Berlaku` date NOT NULL,
  `Kelas` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`NIS`, `Nama_Siswa`, `TTL`, `Jenis_Kelamin`, `Agama`, `Tgl_Daftar`, `Berlaku`, `Kelas`) VALUES
('123180095', 'Kurnia', '2000-05-22', 'Perempuan', 'Islam', '2020-04-14', '2020-09-14', '4');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `Kode_Buku` varchar(3) NOT NULL,
  `Nama_Buku` varchar(10) NOT NULL,
  `Nama_Pengarang` varchar(10) NOT NULL,
  `Nama_Penerbit` varchar(10) NOT NULL,
  `Tahun_Terbit` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `NIK` varchar(10) NOT NULL,
  `Nama_Karyawan` varchar(20) NOT NULL,
  `Jenis_Kelamin` varchar(10) NOT NULL,
  `Golongan` varchar(5) NOT NULL,
  `Jabatan` varchar(10) NOT NULL,
  `Tunjangan` varchar(20) NOT NULL,
  `Total_Gaji` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `No_Pinjam` varchar(3) NOT NULL,
  `NIS` varchar(10) NOT NULL,
  `Nama_Siswa` varchar(20) NOT NULL,
  `Kelas` varchar(1) NOT NULL,
  `Kode_Buku` varchar(3) NOT NULL,
  `Nama_Buku` varchar(10) NOT NULL,
  `Penerbit` varchar(10) NOT NULL,
  `Tgl_Pinjam` date NOT NULL,
  `Tgl_Kembali` date NOT NULL,
  `Lama_Pinjam` varchar(5) NOT NULL,
  `Denda` varchar(20) NOT NULL,
  `Petugas` varchar(20) NOT NULL,
  `NIK` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`NIS`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`Kode_Buku`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`NIK`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD KEY `fkNIS` (`NIS`),
  ADD KEY `fkNIK` (`NIK`),
  ADD KEY `fkKode_Buku` (`Kode_Buku`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `fkKode_Buku` FOREIGN KEY (`Kode_Buku`) REFERENCES `buku` (`Kode_Buku`),
  ADD CONSTRAINT `fkNIK` FOREIGN KEY (`NIK`) REFERENCES `karyawan` (`NIK`),
  ADD CONSTRAINT `fkNIS` FOREIGN KEY (`NIS`) REFERENCES `anggota` (`NIS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
