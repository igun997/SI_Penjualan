-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 16 Nov 2017 pada 09.23
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama`, `jumlah`, `harga`) VALUES
('001', 'Laptop Acer', 2500000, 10),
('002', 'Komputer', 90, 5000000),
('003', 'Xiomi Yii3', 10, 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detil_jual`
--

CREATE TABLE `detil_jual` (
  `no_faktur` varchar(25) NOT NULL,
  `kode_barang` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detil_jual`
--

INSERT INTO `detil_jual` (`no_faktur`, `kode_barang`, `jumlah`, `harga`) VALUES
('FK001', '001', 1, 20000),
('FK001', '001', 23, 200000),
('FK002', '002', 1, 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `notlp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `jk`, `alamat`, `notlp`) VALUES
('001', 'Indra Gunandar', 'Laki-Laki', 'Dipatikur', '081214267695'),
('002', 'Andri Gunandar', 'Laki-Laki', 'Banjar		', '08121426765');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `no_faktur` varchar(25) NOT NULL,
  `tgl_penjualan` date NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`no_faktur`, `tgl_penjualan`, `id_pelanggan`) VALUES
('FK001', '2017-10-27', '001'),
('FK002', '2017-10-27', '001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `detil_jual`
--
ALTER TABLE `detil_jual`
  ADD KEY `no_faktur` (`no_faktur`),
  ADD KEY `ix_kb` (`kode_barang`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_faktur`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detil_jual`
--
ALTER TABLE `detil_jual`
  ADD CONSTRAINT `detil_jual_ibfk_1` FOREIGN KEY (`no_faktur`) REFERENCES `penjualan` (`no_faktur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detil_jual_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
