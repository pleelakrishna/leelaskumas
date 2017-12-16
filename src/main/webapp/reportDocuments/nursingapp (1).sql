-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2017 at 06:18 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nursingapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `batches`
--

CREATE TABLE `batches` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `last_updated_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batches`
--

INSERT INTO `batches` (`id`, `course_id`, `batch`, `status`, `created_date_time`, `last_updated_date_time`) VALUES
(1, 1, '2015-2018', 1, '2015-08-27 18:15:19', '0000-00-00 00:00:00'),
(2, 2, '2015-2017', 1, '2015-08-27 18:15:22', '0000-00-00 00:00:00'),
(3, 1, '2016-2019', 1, '2016-08-27 18:15:38', '0000-00-00 00:00:00'),
(4, 2, '2016-2018', 1, '2016-08-27 18:15:42', '0000-00-00 00:00:00'),
(5, 1, '2017-2020', 1, '2017-08-27 18:16:18', '0000-00-00 00:00:00'),
(6, 2, '2017-2019', 1, '2017-08-27 18:16:23', '0000-00-00 00:00:00'),
(7, 0, '2017-2017', 1, '2017-08-28 10:39:48', '0000-00-00 00:00:00'),
(8, 0, '2017-2017', 1, '2017-08-28 10:40:31', '0000-00-00 00:00:00'),
(9, 0, '2017-2017', 1, '2017-08-28 10:41:56', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `course_name` varchar(250) NOT NULL,
  `short_name` varchar(250) NOT NULL,
  `duration` varchar(20) NOT NULL,
  `status` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `last_updated_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `course_name`, `short_name`, `duration`, `status`, `created_date_time`, `last_updated_date_time`) VALUES
(1, 'BSC Nursing 2', 'BSC Nursing', '3', 1, '2017-08-27 17:23:13', '2017-08-27 17:23:27'),
(2, 'GNM', 'GNM', '2', 1, '2017-08-27 17:23:35', '0000-00-00 00:00:00'),
(5, 'GNM', 'GNM', '3', 1, '2017-09-20 16:18:26', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `fee_structure`
--

CREATE TABLE `fee_structure` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `year` varchar(50) NOT NULL,
  `fee_type` varchar(50) NOT NULL,
  `quota` varchar(50) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `last_updated_by` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `last_updated_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fee_structure`
--

INSERT INTO `fee_structure` (`id`, `course_id`, `batch_id`, `year`, `fee_type`, `quota`, `total_amount`, `status`, `created_by`, `last_updated_by`, `created_date_time`, `last_updated_date_time`) VALUES
(1, 1, 1, 'I YEAR', 'College Fee', 'Government', 32000, 1, 1, 0, '2017-08-27 22:19:40', '0000-00-00 00:00:00'),
(2, 1, 1, 'II YEAR', 'College Fee', 'Government', 32000, 1, 1, 0, '2017-08-27 22:19:40', '0000-00-00 00:00:00'),
(3, 1, 1, 'III YEAR', 'College Fee', 'Government', 32000, 1, 1, 0, '2017-08-27 22:19:40', '0000-00-00 00:00:00'),
(4, 1, 1, 'I YEAR', 'College Fee', 'Management', 25000, 1, 1, 0, '2017-08-27 22:19:56', '0000-00-00 00:00:00'),
(5, 1, 1, 'II YEAR', 'College Fee', 'Management', 25000, 1, 1, 0, '2017-08-27 22:19:56', '0000-00-00 00:00:00'),
(6, 1, 1, 'III YEAR', 'College Fee', 'Management', 25000, 1, 1, 0, '2017-08-27 22:19:56', '0000-00-00 00:00:00'),
(7, 2, 2, 'I YEAR', 'College Fee', 'Government', 32000, 1, 1, 0, '2017-08-27 22:20:16', '0000-00-00 00:00:00'),
(8, 2, 2, 'II YEAR', 'College Fee', 'Government', 32000, 1, 1, 0, '2017-08-27 22:20:16', '0000-00-00 00:00:00'),
(12, 1, 1, 'I YEAR', 'Hostel Fee', 'Both', 28500, 1, 1, 0, '2017-08-27 22:21:13', '0000-00-00 00:00:00'),
(13, 1, 1, 'II YEAR', 'Hostel Fee', 'Both', 28500, 1, 1, 0, '2017-08-27 22:21:13', '0000-00-00 00:00:00'),
(14, 1, 1, 'III YEAR', 'Hostel Fee', 'Both', 28500, 1, 1, 0, '2017-08-27 22:21:13', '0000-00-00 00:00:00'),
(15, 1, 3, 'I YEAR', 'College Fee', 'Government', 22000, 1, 1, 0, '2017-08-27 22:21:38', '0000-00-00 00:00:00'),
(16, 1, 3, 'II YEAR', 'College Fee', 'Government', 22000, 1, 1, 0, '2017-08-27 22:21:38', '0000-00-00 00:00:00'),
(17, 1, 3, 'III YEAR', 'College Fee', 'Government', 22000, 1, 1, 0, '2017-08-27 22:21:38', '0000-00-00 00:00:00'),
(18, 1, 3, 'I YEAR', 'Hostel Fee', 'Both', 29000, 1, 1, 0, '2017-08-27 22:21:56', '0000-00-00 00:00:00'),
(19, 1, 3, 'II YEAR', 'Hostel Fee', 'Both', 29000, 1, 1, 0, '2017-08-27 22:21:56', '0000-00-00 00:00:00'),
(20, 1, 3, 'III YEAR', 'Hostel Fee', 'Both', 29000, 1, 1, 0, '2017-08-27 22:21:56', '0000-00-00 00:00:00'),
(21, 2, 2, 'I YEAR', 'College Fee', 'Management', 5800, 1, 1, 0, '2017-08-28 19:43:43', '0000-00-00 00:00:00'),
(22, 2, 2, 'II YEAR', 'College Fee', 'Management', 5800, 1, 1, 0, '2017-08-28 19:43:43', '0000-00-00 00:00:00'),
(23, 2, 2, 'I YEAR', 'Hostel Fee', 'Both', 24000, 1, 1, 0, '2017-08-28 19:44:03', '0000-00-00 00:00:00'),
(24, 2, 2, 'II YEAR', 'Hostel Fee', 'Both', 24000, 1, 1, 0, '2017-08-28 19:44:03', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `fee_structure_details`
--

CREATE TABLE `fee_structure_details` (
  `id` int(11) NOT NULL,
  `fee_structure_id` int(11) NOT NULL,
  `label` varchar(250) NOT NULL,
  `amount` int(11) NOT NULL,
  `term_range` varchar(10) NOT NULL,
  `terms` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fee_structure_details`
--

INSERT INTO `fee_structure_details` (`id`, `fee_structure_id`, `label`, `amount`, `term_range`, `terms`) VALUES
(1, 1, 'Tution Fee', 8500, '', 0),
(2, 1, 'Special Fee', 8500, '', 0),
(3, 1, 'Transporation Fee', 15000, '', 0),
(4, 2, 'Tution Fee', 8500, '', 0),
(5, 2, 'Special Fee', 8500, '', 0),
(6, 2, 'Transporation Fee', 15000, '', 0),
(7, 3, 'Tution Fee', 8500, '', 0),
(8, 3, 'Special Fee', 8500, '', 0),
(9, 3, 'Transporation Fee', 15000, '', 0),
(10, 4, 'Tution Fee', 7500, '', 0),
(11, 4, 'Special Fee', 8500, '', 0),
(12, 4, 'Transporation Fee', 9000, '', 0),
(13, 5, 'Tution Fee', 7500, '', 0),
(14, 5, 'Special Fee', 8500, '', 0),
(15, 5, 'Transporation Fee', 9000, '', 0),
(16, 6, 'Tution Fee', 7500, '', 0),
(17, 6, 'Special Fee', 8500, '', 0),
(18, 6, 'Transporation Fee', 9000, '', 0),
(19, 7, 'Tution Fee', 8500, '', 0),
(20, 7, 'Special Fee', 8500, '', 0),
(21, 7, 'Transporation Fee', 15000, '', 0),
(22, 8, 'Tution Fee', 8500, '', 0),
(23, 8, 'Special Fee', 8500, '', 0),
(24, 8, 'Transporation Fee', 15000, '', 0),
(25, 9, 'I Term - September', 7500, '7-9', 3),
(26, 9, 'II Term - December', 7500, '10-12', 3),
(27, 9, 'III Term - March', 7500, '1-3', 3),
(28, 9, 'IV Term - June', 6000, '4-6', 3),
(29, 10, 'I Term - September', 7500, '7-9', 3),
(30, 10, 'II Term - December', 7500, '10-12', 3),
(31, 10, 'III Term - March', 7500, '1-3', 3),
(32, 10, 'IV Term - June', 6000, '4-6', 3),
(33, 11, 'I Term - September', 7500, '7-9', 3),
(34, 11, 'II Term - December', 7500, '10-12', 3),
(35, 11, 'III Term - March', 7500, '1-3', 3),
(36, 11, 'IV Term - June', 6000, '4-6', 3),
(37, 12, 'I Term - September', 7500, '7-9', 3),
(38, 12, 'II Term - December', 7500, '10-12', 3),
(39, 12, 'III Term - March', 7500, '1-3', 3),
(40, 12, 'IV Term - June', 6000, '4-6', 3),
(41, 13, 'I Term - September', 7500, '7-9', 3),
(42, 13, 'II Term - December', 7500, '10-12', 3),
(43, 13, 'III Term - March', 7500, '1-3', 3),
(44, 13, 'IV Term - June', 6000, '4-6', 3),
(45, 14, 'I Term - September', 7500, '7-9', 3),
(46, 14, 'II Term - December', 7500, '10-12', 3),
(47, 14, 'III Term - March', 7500, '1-3', 3),
(48, 14, 'IV Term - June', 6000, '4-6', 3),
(49, 15, 'Tution Fee', 8500, '', 0),
(50, 15, 'Special Fee', 7500, '', 0),
(51, 15, 'Transporation Fee', 6000, '', 0),
(52, 16, 'Tution Fee', 8500, '', 0),
(53, 16, 'Special Fee', 7500, '', 0),
(54, 16, 'Transporation Fee', 6000, '', 0),
(55, 17, 'Tution Fee', 8500, '', 0),
(56, 17, 'Special Fee', 7500, '', 0),
(57, 17, 'Transporation Fee', 6000, '', 0),
(58, 18, 'I Term - September', 7500, '7-9', 3),
(59, 18, 'II Term - December', 7500, '10-12', 3),
(60, 18, 'III Term - March', 7500, '1-3', 3),
(61, 18, 'IV Term - June', 6500, '4-6', 3),
(62, 19, 'I Term - September', 7500, '7-9', 3),
(63, 19, 'II Term - December', 7500, '10-12', 3),
(64, 19, 'III Term - March', 7500, '1-3', 3),
(65, 19, 'IV Term - June', 6500, '4-6', 3),
(66, 20, 'I Term - September', 7500, '7-9', 3),
(67, 20, 'II Term - December', 7500, '10-12', 3),
(68, 20, 'III Term - March', 7500, '1-3', 3),
(69, 20, 'IV Term - June', 6000, '4-6', 3),
(70, 21, 'Tution Fee', 1800, '', 0),
(71, 21, 'Special Fee', 1500, '', 0),
(72, 21, 'Transporation Fee', 2500, '', 0),
(73, 22, 'Tution Fee', 1800, '', 0),
(74, 22, 'Special Fee', 1500, '', 0),
(75, 22, 'Transporation Fee', 2500, '', 0),
(76, 23, 'I Term - September', 3000, '7-9', 3),
(77, 23, 'II Term - December', 7500, '10-12', 3),
(78, 23, 'III Term - March', 7500, '1-3', 3),
(79, 23, 'IV Term - June', 6000, '4-6', 3),
(80, 24, 'I Term - September', 3000, '7-9', 3),
(81, 24, 'II Term - December', 7500, '10-12', 3),
(82, 24, 'III Term - March', 7500, '1-3', 3),
(83, 24, 'IV Term - June', 6000, '4-6', 3);

-- --------------------------------------------------------

--
-- Table structure for table `health_history`
--

CREATE TABLE `health_history` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `year` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `remarks` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `health_history`
--

INSERT INTO `health_history` (`id`, `student_id`, `year`, `date`, `remarks`) VALUES
(1, 3, 'I YEAR', '2017-10-24', 'Fever'),
(2, 3, 'I YEAR', '2017-10-18', 'dsf sdfdsf sdf'),
(3, 3, 'I YEAR', '2017-10-24', 'fuyuyguygygygui dgfdgfdgfdg'),
(4, 3, 'I YEAR', '2017-10-25', 'safsd fds'),
(5, 3, 'I YEAR', '2017-10-12', 'dfs fsf sfdsfsdf');

-- --------------------------------------------------------

--
-- Table structure for table `health_labels`
--

CREATE TABLE `health_labels` (
  `id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `label` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `health_labels`
--

INSERT INTO `health_labels` (`id`, `type_id`, `label`) VALUES
(7, 2, 'BPSD'),
(8, 1, 'BP'),
(9, 1, 'Height'),
(10, 1, 'Blood P.'),
(11, 1, 'Urine'),
(12, 2, 'Montonax'),
(13, 2, 'BCG'),
(14, 2, 'Tetanus Toxoid'),
(15, 2, 'T.A.B'),
(16, 1, 'Vision'),
(17, 1, 'Fits');

-- --------------------------------------------------------

--
-- Table structure for table `health_reports`
--

CREATE TABLE `health_reports` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  `year` varchar(20) NOT NULL,
  `value` varchar(250) NOT NULL,
  `examin_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `health_reports`
--

INSERT INTO `health_reports` (`id`, `student_id`, `type_id`, `label_id`, `year`, `value`, `examin_date`) VALUES
(1, 1, 2, 13, 'I YEAR', '5.2', '2017-09-19'),
(2, 1, 2, 14, 'I YEAR', '6', '2017-09-19'),
(3, 1, 2, 15, 'I YEAR', '9', '2017-09-19'),
(4, 1, 2, 15, 'II YEAR', '9', '2017-09-19'),
(5, 1, 2, 14, 'III YEAR', '6', '2017-09-19');

-- --------------------------------------------------------

--
-- Table structure for table `health_types`
--

CREATE TABLE `health_types` (
  `id` int(11) NOT NULL,
  `type_name` varchar(250) NOT NULL,
  `key_label` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `health_types`
--

INSERT INTO `health_types` (`id`, `type_name`, `key_label`) VALUES
(1, 'Physical Examination', 'Exam'),
(2, 'VACCINATION', 'Year');

-- --------------------------------------------------------

--
-- Table structure for table `health_weight_chart`
--

CREATE TABLE `health_weight_chart` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `year` varchar(20) NOT NULL,
  `month` varchar(250) NOT NULL,
  `weight` varchar(250) NOT NULL,
  `mensus` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `health_weight_chart`
--

INSERT INTO `health_weight_chart` (`id`, `student_id`, `year`, `month`, `weight`, `mensus`) VALUES
(1, 3, 'I YEAR', 'July', '25', '28'),
(2, 3, 'I YEAR', 'August', '28', '29'),
(3, 2, 'I YEAR', 'August', '28', '29');

-- --------------------------------------------------------

--
-- Table structure for table `monthly_calander`
--

CREATE TABLE `monthly_calander` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `holiday_name` text NOT NULL,
  `created_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monthly_calander`
--

INSERT INTO `monthly_calander` (`id`, `date`, `holiday_name`, `created_date_time`) VALUES
(2, '2017-10-15', 'Legend Birthday That is Prasad', '2017-08-23 11:16:51'),
(3, '2017-08-25', 'BETWEEN', '2017-08-23 11:31:14'),
(5, '2017-08-03', 'BETWEEN', '2017-08-23 11:31:19'),
(6, '2014-02-04', 'Event 4', '2017-08-23 20:51:22'),
(7, '2017-07-04', 'First Day of College Absent', '2017-08-23 16:33:33'),
(8, '2017-02-28', 'Mega*Developers*Birthday*Mukesh Birthday', '2017-08-23 20:50:42'),
(11, '2017-11-02', 'some*this*data', '2017-08-23 20:35:19'),
(12, '2017-03-02', 'Dates', '2017-08-23 20:38:17'),
(15, '2017-08-26', 'Bund', '2017-08-28 10:50:39'),
(16, '2017-02-08', 'Holiday', '2017-08-31 10:02:44'),
(17, '2017-03-08', 'Holiday', '2017-09-22 11:15:56'),
(18, '2017-02-27', 'Break up Day', '2017-09-22 11:07:20'),
(19, '2017-03-01', 'Date', '2017-09-22 11:16:08');

-- --------------------------------------------------------

--
-- Table structure for table `progress_reports`
--

CREATE TABLE `progress_reports` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `year` varchar(20) NOT NULL,
  `exam_type` varchar(20) NOT NULL,
  `progress_subject_id` int(11) NOT NULL,
  `max_marks` int(11) NOT NULL,
  `exam_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progress_reports`
--

INSERT INTO `progress_reports` (`id`, `course_id`, `batch_id`, `year`, `exam_type`, `progress_subject_id`, `max_marks`, `exam_date`) VALUES
(1, 1, 1, 'I YEAR', 'term', 1, 52, '0000-00-00'),
(2, 1, 1, 'I YEAR', 'term', 2, 35, '0000-00-00'),
(3, 1, 1, 'I YEAR', 'term', 3, 75, '0000-00-00'),
(4, 1, 1, 'I YEAR', 'term', 4, 85, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `progress_reports_exams_list`
--

CREATE TABLE `progress_reports_exams_list` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `year` varchar(20) NOT NULL,
  `assignments` int(11) NOT NULL,
  `terms` int(11) NOT NULL,
  `prefinals` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progress_reports_exams_list`
--

INSERT INTO `progress_reports_exams_list` (`id`, `course_id`, `batch_id`, `year`, `assignments`, `terms`, `prefinals`) VALUES
(2, 1, 1, 'I YEAR', 5, 3, 2),
(3, 1, 3, 'I YEAR', 1, 2, 2),
(4, 1, 1, 'II YEAR', 0, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `progress_subjects`
--

CREATE TABLE `progress_subjects` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `year` varchar(20) NOT NULL,
  `subject_name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progress_subjects`
--

INSERT INTO `progress_subjects` (`id`, `course_id`, `batch_id`, `year`, `subject_name`) VALUES
(1, 1, 1, 'I YEAR', 'English'),
(2, 1, 1, 'I YEAR', 'Telugu1'),
(3, 1, 1, 'I YEAR', 'HIndi'),
(4, 1, 1, 'I YEAR', 'Social');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `admission_no` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `quota` varchar(50) NOT NULL,
  `last_date_of_submission` date NOT NULL,
  `name` varchar(250) NOT NULL,
  `dob` date NOT NULL,
  `age` varchar(250) NOT NULL,
  `years` varchar(250) NOT NULL,
  `caste` varchar(20) NOT NULL,
  `religion` varchar(20) NOT NULL,
  `email` varchar(250) NOT NULL,
  `phno` bigint(20) NOT NULL,
  `address` text NOT NULL,
  `guardian_name` varchar(250) NOT NULL,
  `income` bigint(20) NOT NULL,
  `max_marks` int(11) NOT NULL,
  `total_percent` int(11) NOT NULL,
  `obtained_marks` int(11) NOT NULL,
  `group_percent` int(11) NOT NULL,
  `gnm_obtained_marks` int(11) NOT NULL,
  `gnm_total_percent` int(11) NOT NULL,
  `hallticket_no` varchar(250) NOT NULL,
  `present_year` varchar(250) NOT NULL,
  `status` int(11) NOT NULL,
  `is_releave` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `last_updated_date_time` datetime NOT NULL,
  `photo` varchar(250) NOT NULL,
  `year_updated_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `admission_no`, `course_id`, `batch_id`, `quota`, `last_date_of_submission`, `name`, `dob`, `age`, `years`, `caste`, `religion`, `email`, `phno`, `address`, `guardian_name`, `income`, `max_marks`, `total_percent`, `obtained_marks`, `group_percent`, `gnm_obtained_marks`, `gnm_total_percent`, `hallticket_no`, `present_year`, `status`, `is_releave`, `created_date_time`, `last_updated_date_time`, `photo`, `year_updated_date`) VALUES
(1, 125455, 1, 1, 'Government', '2017-08-27', 'Durga', '2017-08-27', '26', '26', 'NA', 'Hindhu', 'durga@gmail.com', 9491862697, 'Guntur', 'Durga Bhavani', 150000, 95, 95, 89, 89, 0, 0, '45454', 'I YEAR', 1, 0, '2017-08-27 23:03:21', '2017-08-28 10:37:56', '', '2017-08-27'),
(2, 12345678, 1, 1, 'Government', '2017-08-28', 'Bhavani', '2017-08-28', '22', '22', 'NA', 'NA', 'bhavani@gmail.com', 9491862697, 'Guntur', 'Bhavani', 10000, 89, 89, 89, 89, 0, 0, '', 'I YEAR', 1, 0, '2017-08-28 10:37:35', '0000-00-00 00:00:00', '', '2017-08-28'),
(3, 145689, 2, 2, 'Government', '2017-08-28', 'Kalyani', '2017-08-28', '21', '21', 'NA', 'NA', 'kalyani@gmail.com', 9491862696, 'Tenali', 'kalyani Durga', 150000, 94, 93, 94, 92, 95, 94, '123456', 'I YEAR', 1, 0, '2017-08-28 10:39:33', '0000-00-00 00:00:00', '', '2017-08-28');

-- --------------------------------------------------------

--
-- Table structure for table `students_attendance`
--

CREATE TABLE `students_attendance` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `student_year` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `session` int(11) NOT NULL COMMENT '1 morning session,2 afternoon session,3 fullday',
  `remarks` text NOT NULL,
  `created_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students_attendance`
--

INSERT INTO `students_attendance` (`id`, `student_id`, `student_year`, `date`, `session`, `remarks`, `created_date_time`) VALUES
(1, 3, 'I YEAR', '2017-08-09', 3, 'Fever', '2017-08-10 00:00:00'),
(4, 1, 'I YEAR', '2017-08-16', 3, 'Fever', '2017-08-24 12:34:53'),
(6, 3, 'I YEAR', '2017-08-26', 3, 'Absent', '2017-08-24 12:45:31'),
(8, 2, 'I YEAR', '2017-08-10', 3, 'Fever', '2017-08-24 13:04:41'),
(9, 1, 'I YEAR', '2017-08-18', 3, 'Fever', '2017-08-28 18:44:20'),
(10, 1, 'I YEAR', '2017-08-01', 3, 'Absent*Fever', '2017-08-28 18:44:53');

-- --------------------------------------------------------

--
-- Table structure for table `student_fee_paid`
--

CREATE TABLE `student_fee_paid` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `year` varchar(50) NOT NULL,
  `amount` int(11) NOT NULL,
  `paid_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_fee_paid`
--

INSERT INTO `student_fee_paid` (`id`, `student_id`, `year`, `amount`, `paid_date_time`) VALUES
(1, 1, 'I YEAR', 11000, '2017-08-28 19:50:14'),
(2, 1, 'I YEAR', 100, '2017-08-28 19:51:44'),
(3, 1, 'I YEAR', 100, '2017-08-28 19:52:30'),
(4, 1, 'III YEAR', 1500, '2017-08-28 19:54:10'),
(5, 1, 'II YEAR', 1000, '2017-08-28 19:54:34'),
(6, 1, 'I YEAR', 43000, '2017-08-28 19:55:06'),
(7, 3, 'I YEAR', 5000, '2017-08-28 20:22:53'),
(8, 3, 'II YEAR', 30000, '2017-08-28 20:23:14'),
(9, 1, 'III YEAR', 2500, '2017-08-29 12:47:32'),
(10, 1, 'I YEAR', 23200, '2017-08-29 18:54:13'),
(11, 1, 'I YEAR', 800, '2017-08-29 19:39:09'),
(12, 1, 'II YEAR', 135000, '2017-08-29 19:42:12'),
(13, 1, 'I YEAR', 11880, '2017-08-30 11:37:37'),
(14, 1, 'II YEAR', 2500, '2017-08-30 13:07:14'),
(15, 1, 'III YEAR', 3377, '2017-08-30 13:08:41'),
(16, 2, 'III YEAR', 5440, '2017-08-30 13:15:37'),
(17, 1, 'III YEAR', 1750, '2017-08-30 13:37:23');

-- --------------------------------------------------------

--
-- Table structure for table `student_fee_paid_history`
--

CREATE TABLE `student_fee_paid_history` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `fee_paid_id` int(11) NOT NULL,
  `year` varchar(50) NOT NULL,
  `fee_type` varchar(50) NOT NULL,
  `paid_amount` int(11) NOT NULL,
  `extra_amount` int(11) NOT NULL,
  `remarks` text NOT NULL,
  `paid_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_fee_paid_history`
--

INSERT INTO `student_fee_paid_history` (`id`, `student_id`, `fee_paid_id`, `year`, `fee_type`, `paid_amount`, `extra_amount`, `remarks`, `paid_date_time`) VALUES
(2, 1, 1, 'I YEAR', 'Hostel Fee', 5000, 6000, '', '2017-08-28 19:50:14'),
(3, 1, 2, 'I YEAR', 'College Fee', 100, 0, '', '2017-08-28 19:51:44'),
(4, 1, 3, 'I YEAR', 'College Fee', 100, 0, '', '2017-08-28 19:52:30'),
(5, 1, 4, 'III YEAR', 'College Fee', 1500, 0, '', '2017-08-28 19:54:10'),
(6, 1, 5, 'II YEAR', 'Hostel Fee', 0, 1000, '', '2017-08-28 19:54:34'),
(7, 1, 6, 'I YEAR', 'College Fee', 18000, 0, '', '2017-08-28 19:55:06'),
(8, 1, 6, 'I YEAR', 'Hostel Fee', 18320, 6680, '', '2017-08-28 19:55:06'),
(9, 3, 7, 'I YEAR', 'College Fee', 5000, 0, '', '2017-08-28 20:22:53'),
(10, 3, 8, 'II YEAR', 'College Fee', 15000, 0, '', '2017-08-28 20:23:14'),
(11, 3, 8, 'II YEAR', 'Hostel Fee', 11460, 3540, '', '2017-08-28 20:23:14'),
(12, 1, 9, 'III YEAR', 'Hostel Fee', 2070, 430, '', '2017-08-29 12:47:32'),
(13, 1, 10, 'I YEAR', 'College Fee', 13000, 0, '', '2017-08-29 18:54:13'),
(14, 1, 11, 'I YEAR', 'College Fee', 800, 0, '', '2017-08-29 19:39:09'),
(15, 1, 12, 'II YEAR', 'College Fee', 5000, 0, '', '2017-08-29 19:42:12'),
(16, 1, 13, 'I YEAR', 'Hostel Fee', 5180, 6700, '', '2017-08-30 11:37:37'),
(17, 1, 14, 'II YEAR', 'Hostel Fee', 0, 2500, '', '2017-08-30 13:07:14'),
(18, 1, 15, 'III YEAR', 'Hostel Fee', 2937, 440, '', '2017-08-30 13:08:41'),
(19, 2, 16, 'III YEAR', 'Hostel Fee', 5000, 440, '', '2017-08-30 13:15:37'),
(20, 1, 17, 'III YEAR', 'College Fee', 1500, 0, '', '2017-08-30 13:37:23'),
(21, 1, 17, 'III YEAR', 'Hostel Fee', 250, 0, '', '2017-08-30 13:37:23');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `year` varchar(50) NOT NULL,
  `subject_name` varchar(250) NOT NULL,
  `theory_hours_required` int(11) NOT NULL,
  `practical_hours_required` int(11) NOT NULL,
  `theory_marks` int(11) NOT NULL,
  `practical_marks` int(11) NOT NULL,
  `theory_hours_provided` int(11) NOT NULL,
  `practical_hours_provided` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `last_updated_by` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `last_updated_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `course_id`, `batch_id`, `year`, `subject_name`, `theory_hours_required`, `practical_hours_required`, `theory_marks`, `practical_marks`, `theory_hours_provided`, `practical_hours_provided`, `status`, `created_by`, `last_updated_by`, `created_date_time`, `last_updated_date_time`) VALUES
(1, 1, 1, 'I YEAR', 'Telugu', 55, 55, 100, 0, 0, 0, 1, 1, 0, '2017-08-27 18:32:33', '0000-00-00 00:00:00'),
(2, 1, 1, 'I YEAR', 'English', 55, 55, 100, 0, 0, 0, 1, 1, 0, '2017-08-27 18:32:33', '0000-00-00 00:00:00'),
(3, 1, 1, 'I YEAR', 'Social', 55, 55, 100, 0, 0, 0, 1, 1, 0, '2017-08-27 18:32:33', '0000-00-00 00:00:00'),
(4, 1, 1, 'II YEAR', 'Computer Sciense', 50, 55, 100, 0, 40, 45, 1, 1, 1, '2017-08-27 18:38:53', '2017-08-29 00:03:45'),
(5, 1, 1, 'II YEAR', 'Electrical Sciense', 50, 45, 100, 0, 40, 35, 1, 1, 1, '2017-08-27 18:38:53', '2017-08-29 00:03:45'),
(6, 1, 1, 'II YEAR', 'Physical Sciense', 50, 45, 100, 0, 40, 35, 1, 1, 1, '2017-08-27 18:38:53', '2017-08-29 00:03:45'),
(11, 1, 1, 'INTERNSHIP', 'Telugu', 0, 150, 0, 0, 0, 100, 1, 1, 1, '2017-08-27 18:53:22', '2017-08-29 00:03:20'),
(12, 1, 1, 'INTERNSHIP', 'English', 0, 150, 0, 0, 0, 95, 1, 1, 1, '2017-08-27 18:53:22', '2017-08-29 00:03:20'),
(13, 1, 1, 'III YEAR', 'Telugu', 70, 70, 100, 0, 0, 0, 1, 1, 1, '2017-08-29 01:01:04', '2017-08-29 01:04:45'),
(14, 1, 1, 'III YEAR', 'Hindi', 70, 70, 100, 0, 0, 0, 1, 1, 1, '2017-08-29 01:01:12', '2017-08-29 01:04:45'),
(15, 1, 1, 'III YEAR', 'Social', 70, 70, 100, 0, 0, 0, 1, 1, 1, '2017-08-29 01:02:19', '2017-08-29 01:04:45'),
(16, 2, 2, 'I YEAR', 'Telugu', 100, 100, 100, 0, 0, 0, 1, 1, 0, '2017-08-29 08:58:42', '0000-00-00 00:00:00'),
(17, 2, 2, 'I YEAR', 'English', 100, 100, 100, 0, 0, 0, 1, 1, 0, '2017-08-29 08:58:42', '0000-00-00 00:00:00'),
(18, 2, 2, 'I YEAR', 'Social', 100, 100, 100, 0, 0, 0, 1, 1, 0, '2017-08-29 08:58:42', '0000-00-00 00:00:00'),
(19, 2, 2, 'II YEAR', 'Socail', 100, 100, 150, 0, 0, 0, 1, 1, 0, '2017-08-29 08:59:13', '0000-00-00 00:00:00'),
(20, 2, 2, 'II YEAR', 'English', 150, 150, 150, 0, 0, 0, 1, 1, 0, '2017-08-29 08:59:13', '0000-00-00 00:00:00'),
(21, 2, 2, 'II YEAR', 'Hindi', 100, 150, 100, 0, 0, 0, 1, 1, 0, '2017-08-29 08:59:13', '0000-00-00 00:00:00'),
(22, 1, 3, 'I YEAR', 'Test', 15, 0, 0, 0, 0, 0, 1, 1, 0, '2017-10-01 11:55:45', '0000-00-00 00:00:00'),
(23, 1, 3, 'I YEAR', 'dfds', 15, 0, 0, 0, 0, 0, 1, 1, 0, '2017-10-01 11:55:45', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `userid` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `role` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `last_updated_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `userid`, `password`, `role`, `status`, `created_date_time`, `last_updated_date_time`) VALUES
(1, 'MASTER', 'MAS001', '12345', 'Master', 1, '2017-08-27 17:17:47', '0000-00-00 00:00:00'),
(2, 'Admin 1', 'ADM002', '12345', 'Admin', 1, '2017-08-27 17:18:23', '2017-08-27 17:19:58');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `batches`
--
ALTER TABLE `batches`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fee_structure`
--
ALTER TABLE `fee_structure`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fee_structure_details`
--
ALTER TABLE `fee_structure_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `health_history`
--
ALTER TABLE `health_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `health_labels`
--
ALTER TABLE `health_labels`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `health_reports`
--
ALTER TABLE `health_reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `health_types`
--
ALTER TABLE `health_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `health_weight_chart`
--
ALTER TABLE `health_weight_chart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `monthly_calander`
--
ALTER TABLE `monthly_calander`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `progress_reports`
--
ALTER TABLE `progress_reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `progress_reports_exams_list`
--
ALTER TABLE `progress_reports_exams_list`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `progress_subjects`
--
ALTER TABLE `progress_subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students_attendance`
--
ALTER TABLE `students_attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_fee_paid`
--
ALTER TABLE `student_fee_paid`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_fee_paid_history`
--
ALTER TABLE `student_fee_paid_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `batches`
--
ALTER TABLE `batches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `fee_structure`
--
ALTER TABLE `fee_structure`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `fee_structure_details`
--
ALTER TABLE `fee_structure_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;
--
-- AUTO_INCREMENT for table `health_history`
--
ALTER TABLE `health_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `health_labels`
--
ALTER TABLE `health_labels`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `health_reports`
--
ALTER TABLE `health_reports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `health_types`
--
ALTER TABLE `health_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `health_weight_chart`
--
ALTER TABLE `health_weight_chart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `monthly_calander`
--
ALTER TABLE `monthly_calander`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `progress_reports`
--
ALTER TABLE `progress_reports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `progress_reports_exams_list`
--
ALTER TABLE `progress_reports_exams_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `progress_subjects`
--
ALTER TABLE `progress_subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `students_attendance`
--
ALTER TABLE `students_attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `student_fee_paid`
--
ALTER TABLE `student_fee_paid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `student_fee_paid_history`
--
ALTER TABLE `student_fee_paid_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
