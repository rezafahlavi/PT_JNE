-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2021 at 11:10 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jne`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `berat` varchar(20) NOT NULL,
  `payment` varchar(20) NOT NULL,
  `origin` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL,
  `tanggal` date NOT NULL,
  `type` varchar(20) NOT NULL,
  `kendala` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `jumlah`, `berat`, `payment`, `origin`, `harga`, `tanggal`, `type`, `kendala`) VALUES
('123', 'baju bola', 3, '2', 'COD', 'jakarta', 20000, '2020-01-02', 'Parcel', 'Alamat salah'),
('234', 'sepatu bola', 1, '1', 'COD', 'depok', 10000, '2020-01-01', 'Parcel', 'alamat salah'),
('3132322', 'Jaket bola', 2, '1', 'COD', 'tebet', 10000, '2020-01-02', 'Parcel', 'alamat salah'),
('4534425', 'Celana bola', 1, '1', 'Cash', 'bogor', 20000, '2020-01-02', 'Parcel', 'alamat salah');

-- --------------------------------------------------------

--
-- Table structure for table `penerima`
--

CREATE TABLE `penerima` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `id_penjual` varchar(20) NOT NULL,
  `nama_penjual` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `petugas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerima`
--

INSERT INTO `penerima` (`id`, `nama`, `id_barang`, `nama_barang`, `id_penjual`, `nama_penjual`, `tanggal`, `alamat`, `no_telp`, `petugas`) VALUES
('C0001', 'gigi', '234', 'sepatu bola', 'P0002', 'adi shop', '2020-01-03', 'jakarta', '085172839452', 'adi'),
('C0002', 'dudi', '234', 'sepatu bola', 'P0003', 'budi shop', '2020-01-03', 'jakarta', '08562892738', 'adi'),
('C0003', 'puput', '4534425', 'Celana bola', 'P0004', 'uus shop', '2020-01-03', 'depok', '085738910743', 'sip');

-- --------------------------------------------------------

--
-- Table structure for table `penjual`
--

CREATE TABLE `penjual` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_telp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjual`
--

INSERT INTO `penjual` (`id`, `nama`, `id_barang`, `nama_barang`, `tanggal`, `alamat`, `no_telp`) VALUES
('P0002', 'adi shop', '234', 'sepatu bola', '2020-01-02', 'Jakarta', '021345678'),
('P0003', 'budi shop', '234', 'sepatu bola', '2020-01-02', 'jakarta', '021564378'),
('P0004', 'uus shop', '4534425', 'Celana bola', '2020-01-02', 'depok', '0218375845');

-- --------------------------------------------------------

--
-- Table structure for table `penugasan`
--

CREATE TABLE `penugasan` (
  `id` varchar(20) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `id_penjual` varchar(20) NOT NULL,
  `nama_penjual` varchar(20) NOT NULL,
  `id_penerima` varchar(20) NOT NULL,
  `nama_penerima` varchar(20) NOT NULL,
  `telp` varchar(20) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `tgl_selesai` date NOT NULL,
  `petugas` varchar(20) NOT NULL,
  `tindakan` varchar(20) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penugasan`
--

INSERT INTO `penugasan` (`id`, `id_barang`, `nama_barang`, `id_penjual`, `nama_penjual`, `id_penerima`, `nama_penerima`, `telp`, `tgl_masuk`, `tgl_selesai`, `petugas`, `tindakan`, `keterangan`) VALUES
('T0001', '123', 'baju bola', 'P0002', 'adi shop', 'C0001', 'gigi', '085172839452', '2020-01-02', '2020-01-03', 'adi', 'Return', 'minta return'),
('T0002', '234', 'sepatu bola', 'P0003', 'budi shop', 'C0002', 'dudi', '08562892738', '2020-01-02', '2020-01-03', 'adi', 'Kirim Ulang', 'alamat baru'),
('T0003', '4534425', 'Celana bola', 'P0004', 'uus shop', 'C0003', 'puput', '085738910743', '2020-01-02', '2020-01-03', 'sip', 'Kirim Ulang', 'alamat baru');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `pass`, `alamat`, `no_hp`, `email`) VALUES
('123', 'adi', 'admin', 'admin', 'depok', '082121212121', 'adi@gmail.com'),
('sip', 'sip', '123', '123sip', 'mampang', '085634563456', 'sip@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjual`
--
ALTER TABLE `penjual`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
