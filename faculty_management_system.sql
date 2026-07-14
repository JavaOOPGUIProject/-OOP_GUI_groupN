- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2026 at 08:26 PM
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
-- Database: `faculty_management_system`
--

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `course_code`, `course_name`, `credits`, `lecture`) VALUES
(1, 'c12', 'SE', '2', 'lecture1'),
(2, 'c123', 'SE', '3', 'lecture123');

--
-- Dumping data for table `degrees`
--

INSERT INTO `degrees` (`id`, `degree`, `department`, `no_of_student`) VALUES
(1, 'er', 'er', 'er'),
(2, 'test', 'test', 'test'),
(3, 'BICT', 'SE', '10');

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`id`, `name`, `hod`, `degree`, `no_of_staff`) VALUES
(1, 'er', 'erer', 'er', 'er'),
(2, 'test', 'test', 'test', 'test'),
(3, 'SE', 'kasun', 'BICT', '10');

--
-- Dumping data for table `lectures`
--

INSERT INTO `lectures` (`id`, `full_name`, `department`, `course_teaching`, `email`, `mobile`) VALUES
(1, 'lecture1', 'SE', 'CTEC12023', 'lucture@com', '0781234456'),
(2, 'newlecture', 'SE', 'ctec23028', 'newlec@com', '084758393');

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `Username`, `Password`, `Role`) VALUES
(1, 'er', 'er', 'Admin'),
(2, 'vini', 'vini', 'Student'),
(3, 'sankalpa', 'ct021', 'Student'),
(4, 'eranda', '21', 'Student'),
(5, 'vishwa', '90', 'Admin'),
(8, 'saduni', '200306', 'Student'),
(9, 'kasun', '12', 'Student'),
(10, 'dinu', 'dinu', 'Student'),
(11, 'Amal', 'amal123', 'Student'),
(12, 'nadeera', 'nadeera123', 'Admin'),
(13, 'Gayan', 'gayan123', 'Student'),
(14, 'admin', 'admin', 'Admin'),
(15, 'LEC', 'LEC', 'Lecturer'),
(16, 'LEC1', 'LEC1', 'Lecturer');

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `full_name`, `student_id`, `degree`, `email`, `mobile`) VALUES
(1, 'er', '34', 'er', 'er', 'er'),
(2, 'test', 'test', 'test', 'test', 'test'),
(3, 'dinu', 'dinu', 'dinu', 'dinu', 'dinu'),
(4, 'Amal perera', 'ct/2022/021', 'BICT', 'amal@email.com', '0777333123'),
(6, 'sunet amunugama', 'ct/2022/023', 'ET', 'sunet@com', '0999999'),
(7, 'gayan samidu', 'ct/123', 'ET', 'ganay@com', '0756234157'),
(8, 'student1', '123', 'et', 'student@com', '0968273923');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
