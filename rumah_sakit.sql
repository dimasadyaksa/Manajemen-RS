-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2018 at 02:43 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rumah_sakit`
--

-- --------------------------------------------------------

--
-- Table structure for table `info penyakit`
--

CREATE TABLE `info penyakit` (
  `Kode Penyakit` varchar(10) NOT NULL,
  `Nama Penyakit` varchar(20) NOT NULL,
  `Kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info penyakit`
--

INSERT INTO `info penyakit` (`Kode Penyakit`, `Nama Penyakit`, `Kategori`) VALUES
('A23', 'Hepatitis', 'Menengah'),
('F32', 'Beri-beri', 'Menengah'),
('F51', 'Mabuk Perjalanan', 'Ringan'),
('G43', 'Migren', 'Ringan'),
('H04.1', 'Mata Kering', 'Ringan'),
('H1N1', 'Flu Babi', 'Berat'),
('J09', 'Influenza', 'Ringan'),
('R56', 'Kejang Demam', 'Menengah');

-- --------------------------------------------------------

--
-- Table structure for table `kepegawaian`
--

CREATE TABLE `kepegawaian` (
  `NIP` varchar(10) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `Jenis Kelamin` char(1) NOT NULL,
  `Profesi` varchar(20) NOT NULL,
  `Keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kepegawaian`
--

INSERT INTO `kepegawaian` (`NIP`, `Nama`, `Alamat`, `Jenis Kelamin`, `Profesi`, `Keterangan`) VALUES
(' 1221123', 'Indra', 'Kedaton', 'P', 'Dokter', ' Spesialis Kandungan'),
(' 12332292', 'Andika', 'Metro, Lampung', 'P', 'Dokter', ' Spesialis Pernafasan'),
(' 1277272', 'Rada', 'Way Hui', 'P', 'Dokter', ' Umum'),
('11222312', ' Kiki', 'Jati Agung', 'L', 'Perawat', ' -'),
('1253235712', 'Rendra Novriardi', 'Magelang', 'L', 'Dokter', 'Umum'),
('1928736483', 'Karin Indah', 'Jakarta', 'P', 'Perawat', '-'),
('2135644237', 'Raina Sara', 'Bekasi Timur', 'P', 'Perawat', '-'),
('2185948327', 'Devinda', 'Maluku', 'P', 'Perawat', '-');

-- --------------------------------------------------------

--
-- Table structure for table `logindata`
--

CREATE TABLE `logindata` (
  `Username` varchar(10) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logindata`
--

INSERT INTO `logindata` (`Username`, `Password`) VALUES
('Admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `Kode Pasien` varchar(10) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Umur` int(3) NOT NULL,
  `Jenis Kelamin` char(1) NOT NULL,
  `Alamat` text NOT NULL,
  `Kode Perawatan` varchar(10) NOT NULL,
  `Kode Ruang` varchar(6) NOT NULL,
  `Kode Penyakit` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`Kode Pasien`, `Nama`, `Umur`, `Jenis Kelamin`, `Alamat`, `Kode Perawatan`, `Kode Ruang`, `Kode Penyakit`) VALUES
('P010', 'Koko', 55, 'L', 'Bandar Lampung', 'PR010', 'R002', 'R56'),
('P017', 'Andre', 33, 'L', 'Way Kandis', 'PR017', 'R212', 'J09'),
('P018', 'Sinta', 33, 'P', 'Way Kandis', 'PR018', 'R201', 'A23'),
('P019', 'Boni', 13, 'L', 'Sumedang', 'PR019', 'R212', 'R56'),
('P020', 'Jojo', 23, 'P', 'Jakarta', 'PR020', 'R103', 'H04.1'),
('P021', 'Rada', 21, 'P', 'Prabumulih', 'PR021', 'R002', 'H1N1'),
('P022', 'Surya', 22, 'L', 'Bogor', 'PR022', 'R002', 'A23'),
('P024', 'Dani', 22, 'L', 'Kotagajah', 'PR024', 'R102', 'G43'),
('P025', 'Siska', 13, 'P', 'Jati Agung', 'PR025', 'R103', 'F51'),
('P026', 'Nur', 15, 'P', 'Kalianda', 'PR026', 'R212', 'F51'),
('P027', 'Hermawan', 37, 'L', 'Way Hui', 'PR027', 'R002', 'A23'),
('P028', 'Reza', 10, 'P', 'Korpri', 'PR028', 'R103', 'A23'),
('P030', 'Ardi', 43, 'L', 'Panjang', 'PR030', 'R002', 'G43'),
('P031', 'Aldi', 54, 'L', 'Kota Baru', 'PR031', 'R002', 'H04.1'),
('P032', 'Arya', 23, 'L', 'Kota Bumi', 'PR032', 'R103', 'H1N1'),
('P033', 'Anita', 12, 'P', 'Kedaton', 'PR033', 'R002', 'H04.1'),
('P034', 'Asri', 45, 'P', 'Metro', 'PR034', 'R002', 'G43'),
('P035', 'Anggi', 33, 'P', 'Liwa', 'PR035', 'R103', 'F51'),
('P036', 'Ben', 24, 'L', 'Medan', 'PR036', 'R002', 'F32');

-- --------------------------------------------------------

--
-- Table structure for table `penempatan`
--

CREATE TABLE `penempatan` (
  `Kode Penempatan` varchar(10) NOT NULL,
  `Kode Ruang` varchar(10) NOT NULL,
  `Kode Pasien` varchar(10) NOT NULL,
  `Tanggal Masuk` date NOT NULL,
  `Tanggal Keluar` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penempatan`
--

INSERT INTO `penempatan` (`Kode Penempatan`, `Kode Ruang`, `Kode Pasien`, `Tanggal Masuk`, `Tanggal Keluar`) VALUES
('PT010', 'R002', 'P010', '2018-04-25', '2018-05-02'),
('PT017', 'R212', 'P017', '2018-04-29', '2018-04-30'),
('PT018', 'R201', 'P018', '2018-04-29', '2018-04-30'),
('PT019', 'R212', 'P019', '2018-04-30', '2018-05-22'),
('PT020', 'R103', 'P020', '2018-04-30', '2018-05-05'),
('PT021', 'R002', 'P021', '2018-04-30', '2018-05-08'),
('PT022', 'R002', 'P022', '2018-04-30', '2018-05-04'),
('PT024', 'R102', 'P024', '2018-04-30', '2018-05-31'),
('PT025', 'R103', 'P025', '2018-04-30', '2018-05-04'),
('PT026', 'R212', 'P026', '2018-04-30', '2018-05-05'),
('PT027', 'R002', 'P027', '2018-04-30', '2018-05-06'),
('PT028', 'R103', 'P028', '2018-04-29', '2018-04-30'),
('PT030', 'R002', 'P030', '2018-04-30', '2018-05-05'),
('PT031', 'R002', 'P031', '2018-04-29', '2018-05-03'),
('PT032', 'R103', 'P032', '2018-04-29', '2018-05-05'),
('PT033', 'R002', 'P033', '2018-04-30', '2018-05-04'),
('PT034', 'R002', 'P034', '2018-04-30', '2018-05-05'),
('PT035', 'R103', 'P035', '2018-04-30', '2018-05-03'),
('PT036', 'R002', 'P036', '2018-05-03', '2018-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `perawatan`
--

CREATE TABLE `perawatan` (
  `Kode Perawatan` varchar(10) NOT NULL,
  `Kode Pasien` varchar(10) NOT NULL,
  `Kode Dokter` varchar(10) NOT NULL,
  `Kode Perawat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perawatan`
--

INSERT INTO `perawatan` (`Kode Perawatan`, `Kode Pasien`, `Kode Dokter`, `Kode Perawat`) VALUES
('PR010', 'P010', '1253235712', '2135644237'),
('PR017', 'P017', ' 1221123', '1928736483'),
('PR018', 'P018', ' 12332292', '2185948327'),
('PR019', 'P019', ' 12332292', '2185948327'),
('PR020', 'P020', '1253235712', '1928736483'),
('PR021', 'P021', ' 12332292', '2135644237'),
('PR022', 'P022', '1253235712', '2185948327'),
('PR024', 'P024', ' 12332292', '2135644237'),
('PR025', 'P025', '1253235712', '2185948327'),
('PR026', 'P026', ' 12332292', '2185948327'),
('PR027', 'P027', ' 1221123', '1928736483'),
('PR028', 'P028', '1253235712', '2185948327'),
('PR030', 'P030', ' 12332292', '2135644237'),
('PR031', 'P031', '1253235712', '1928736483'),
('PR032', 'P032', ' 1221123', '1928736483'),
('PR033', 'P033', ' 1221123', '1928736483'),
('PR034', 'P034', '1253235712', '2135644237'),
('PR035', 'P035', '1253235712', '2185948327'),
('PR036', 'P036', ' 12332292', '2185948327');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `Kode Ruang` varchar(6) NOT NULL,
  `Nama Ruang` varchar(20) NOT NULL,
  `Jenis Ruang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`Kode Ruang`, `Nama Ruang`, `Jenis Ruang`) VALUES
('R001', 'Mawar', 'VIP'),
('R002', 'Kenanga', 'Reguler'),
('R100', 'Bougenville', 'VIP'),
('R102', 'Melati', 'VIP'),
('R103', 'Kutilang', 'Reguler'),
('R132', 'Kamboja', 'Reguler'),
('R201', 'Rafflesia', 'Reguler'),
('R211', 'Aster', 'Reguler'),
('R212', 'Merpati', 'VIP'),
('R222', 'Anggrek', 'Reguler');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `info penyakit`
--
ALTER TABLE `info penyakit`
  ADD PRIMARY KEY (`Kode Penyakit`);

--
-- Indexes for table `kepegawaian`
--
ALTER TABLE `kepegawaian`
  ADD PRIMARY KEY (`NIP`);

--
-- Indexes for table `logindata`
--
ALTER TABLE `logindata`
  ADD PRIMARY KEY (`Username`),
  ADD UNIQUE KEY `Password` (`Password`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`Kode Pasien`),
  ADD KEY `Kode Penyakit` (`Kode Penyakit`),
  ADD KEY `Kode Ruang` (`Kode Ruang`),
  ADD KEY `Kode Perawatan` (`Kode Perawatan`);

--
-- Indexes for table `penempatan`
--
ALTER TABLE `penempatan`
  ADD PRIMARY KEY (`Kode Penempatan`),
  ADD KEY `Kode Pasien` (`Kode Pasien`),
  ADD KEY `Kode Ruang` (`Kode Ruang`);

--
-- Indexes for table `perawatan`
--
ALTER TABLE `perawatan`
  ADD PRIMARY KEY (`Kode Perawatan`),
  ADD KEY `perawatan_ibfk_1` (`Kode Dokter`),
  ADD KEY `perawatan_ibfk_2` (`Kode Perawat`),
  ADD KEY `perawatan_ibfk_3` (`Kode Pasien`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`Kode Ruang`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `pasien_ibfk_1` FOREIGN KEY (`Kode Penyakit`) REFERENCES `info penyakit` (`Kode Penyakit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pasien_ibfk_2` FOREIGN KEY (`Kode Ruang`) REFERENCES `ruangan` (`Kode Ruang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penempatan`
--
ALTER TABLE `penempatan`
  ADD CONSTRAINT `penempatan_ibfk_1` FOREIGN KEY (`Kode Pasien`) REFERENCES `pasien` (`Kode Pasien`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `perawatan`
--
ALTER TABLE `perawatan`
  ADD CONSTRAINT `perawatan_ibfk_1` FOREIGN KEY (`Kode Dokter`) REFERENCES `kepegawaian` (`NIP`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `perawatan_ibfk_2` FOREIGN KEY (`Kode Perawat`) REFERENCES `kepegawaian` (`NIP`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `perawatan_ibfk_3` FOREIGN KEY (`Kode Pasien`) REFERENCES `pasien` (`Kode Pasien`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
