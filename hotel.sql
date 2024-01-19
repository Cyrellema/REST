-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 03 jan. 2022 à 03:29
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `agency`
--

DROP TABLE IF EXISTS `agency`;
CREATE TABLE IF NOT EXISTS `agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `reduction` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `agency`
--

INSERT INTO `agency` (`id`, `login`, `password`, `reduction`) VALUES
(1, 'superagency', 'superagencypassword', 0.2),
(2, 'mehagency', 'mehagencypassword', 0.1),
(3, 'noobagency', 'noobagencypassword', 0.05);

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `first_name`, `last_name`) VALUES
(1, 'Michel', 'Thalia'),
(2, 'Michel', 'Thaliaa'),
(3, 'Michel', 'Thalio'),
(4, 'Jean', 'Luc'),
(5, 'Jean', 'Oui'),
(6, 'Jean', 'Non');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrived` datetime DEFAULT NULL,
  `confirmation` bit(1) DEFAULT NULL,
  `departure` datetime DEFAULT NULL,
  `customer` bigint(20) NOT NULL,
  `room` bigint(20) NOT NULL,
  `agency_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `UK_f7ufcy1ns4l97s61t8pkwgyyu` (`customer`) USING BTREE,
  KEY `UK_7g44v8byktbsjao12a3orwjsp` (`room`) USING BTREE,
  KEY `UK_rlpty2aewdr3pnmw6gv6s5b2y` (`agency_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `arrived`, `confirmation`, `departure`, `customer`, `room`, `agency_id`) VALUES
(1, '2019-10-11 15:33:06', b'1', '2019-10-13 15:33:06', 1, 5, 3),
(4, '2019-10-14 15:33:06', b'1', '2019-10-15 15:33:06', 1, 5, 3),
(5, '2019-10-16 15:33:06', b'1', '2019-10-18 15:33:06', 1, 5, 3),
(6, '2019-10-16 15:33:06', b'1', '2019-10-18 15:33:06', 1, 4, 3),
(7, '2019-10-16 15:33:06', b'1', '2019-10-18 15:33:06', 1, 3, 3),
(8, '2019-10-19 15:33:06', b'1', '2019-10-21 15:33:06', 1, 3, 3),
(9, '2019-10-22 15:33:06', b'1', '2019-10-24 15:33:06', 1, 3, 3),
(10, '2019-10-22 15:33:06', b'1', '2019-10-24 15:33:06', 2, 2, 3),
(11, '2019-10-22 15:33:06', b'1', '2019-10-24 15:33:06', 2, 1, 3),
(12, '2019-10-22 15:33:06', b'1', '2019-10-24 15:33:06', 3, 6, 3),
(13, '2019-10-25 15:33:06', b'1', '2019-10-28 14:33:06', 4, 6, 2),
(14, '2019-11-25 14:33:06', b'1', '2019-11-28 14:33:06', 5, 5, 2),
(15, '2019-11-27 14:33:06', b'1', '2019-11-29 14:33:06', 6, 4, 2);

-- --------------------------------------------------------

--
-- Structure de la table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `beds` int(11) DEFAULT NULL,
  `image` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `room`
--

INSERT INTO `room` (`id`, `beds`, `image`, `price`) VALUES
(1, 2, 'https://www.alibabuy.com/photos/library/1500/11556.jpg', 50),
(2, 3, 'https://assets.hotelaparis.com/uploads/pictures/000/030/809/rect700_Ibis_Budget.jpg', 60),
(3, 2, 'http://hoteldemontaulbain.fr/wp-content/uploads/2016/12/CH20B.jpg', 50),
(4, 2, 'https://hoteldenell.com/img/room-chambre-luxe.jpg', 50),
(5, 1, 'https://hotellesevigne.fr/wp-content/uploads/2018/04/vue-chambre-single-1.jpg', 40),
(6, 1, 'https://www.thonhotels.com/globalassets/hoteller/norge/oslo/thon-hotel-terminus/romtyper/small-single-room/thon-hotel-terminus-small-single-room-1.jpg?width=1100&height=550&mode=crop&quality=80', 40);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKnmagexg7tgm567i76oymur32k` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`),
  ADD CONSTRAINT `FKpdv4c8ailn2iaw1rexwfsjmcd` FOREIGN KEY (`room`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `FKsg8770wfft7ktwtf9r8a6cwos` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
