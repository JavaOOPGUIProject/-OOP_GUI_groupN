-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2026 at 12:09 PM
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
-- Database: `home`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `faculty_management_system`.`login` (
    `ID` INT NOT NULL AUTO_INCREMENT,
    `Username` VARCHAR(50) NOT NULL UNIQUE,
    `Password` VARCHAR(255) NOT NULL,
    `Role` ENUM('Admin', 'Student', 'Lecturer') NOT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `faculty_management_system`.`degrees` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `degree` VARCHAR(50)  NOT NULL,
    `department` VARCHAR(100) NOT NULL,
    `no_of_student` VARCHAR(10),
    UNIQUE KEY `degree_department_unique` (`degree`, `department`)  -- used together as the key for Edit/Delete
);

CREATE TABLE IF NOT EXISTS `faculty_management_system`.`departments` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL UNIQUE,  -- e.g. "Software Engineering" — used as the key for Edit/Delete
    `hod` VARCHAR(100),
    `degree` VARCHAR(50),
    `no_of_staff` VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS `faculty_management_system`.`courses` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `course_code` VARCHAR(50)  NOT NULL UNIQUE,  -- used as the key for Edit/Delete
    `course_name` VARCHAR(100),
    `credits` VARCHAR(10),
    `lecture` VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `faculty_management_system`.`lectures` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `full_name` VARCHAR(100) NOT NULL,
    `department` VARCHAR(100),
    `course_teaching` VARCHAR(100),
    `email`  VARCHAR(100) NOT NULL UNIQUE,  -- used as the key for Edit/Delete
    `mobile` VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS `faculty_management_system`.`departments` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL UNIQUE,  -- e.g. "Software Engineering" — used as the key for Edit/Delete
    `hod` VARCHAR(100),
    `degree` VARCHAR(50),
    `no_of_staff` VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS `faculty_management_system`.`students` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `full_name`  VARCHAR(100) NOT NULL,
    `student_id` VARCHAR(50)  NOT NULL UNIQUE,   -- e.g. "CT/22/026" — used as the unique key for Edit/Delete
    `degree`     VARCHAR(50),
    `email`      VARCHAR(100),
    `mobile`     VARCHAR(20)
);
--
-- Dumping data for table `user`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
