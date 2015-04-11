-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2014 年 04 月 02 日 06:55
-- 服务器版本: 5.5.32
-- PHP 版本: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `dataminingplatform`
--
CREATE DATABASE IF NOT EXISTS `dataminingplatform` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dataminingplatform`;

-- --------------------------------------------------------

--
-- 表的结构 `algorithm`
--

CREATE TABLE IF NOT EXISTS `algorithm` (
  `AlgorithmID` int(10) NOT NULL AUTO_INCREMENT,
  `AlgorithmName` varchar(200) DEFAULT NULL,
  `AlgorithmType` varchar(200) DEFAULT NULL,
  `AlgorithmSourcer` varchar(200) DEFAULT NULL,
  `AlgorithmCreater` varchar(200) DEFAULT NULL,
  `AlgorithmCreaterCompany` varchar(200) DEFAULT NULL,
  `AlgorithmCreaterAddr` varchar(200) DEFAULT NULL,
  `AlgorithmCreaterPostcode` varchar(200) DEFAULT NULL,
  `AlgorithmCreaterPhone` varchar(200) DEFAULT NULL,
  `AlgorithmCreaterEmail` varchar(200) DEFAULT NULL,
  `AlgorithmCreaterData` varchar(200) DEFAULT NULL,
  `AlgorithmVersion` varchar(200) DEFAULT NULL,
  `AlgorithmPath` varchar(200) DEFAULT NULL,
  `AlgorithmParameter` varchar(200) DEFAULT NULL,
  `AlgorithmUploader` varchar(200) DEFAULT NULL,
  `AlgorithmUploaderCompany` varchar(200) DEFAULT NULL,
  `AlgorithmUploaderAddr` varchar(200) DEFAULT NULL,
  `AlgorithmUploaderPostcode` varchar(200) DEFAULT NULL,
  `AlgorithmUploaderPhone` varchar(200) DEFAULT NULL,
  `AlgorithmUploaderEmail` varchar(200) DEFAULT NULL,
  `AlgorithmCreateTime` date DEFAULT NULL,
  `AlgorithmChangeTime` date DEFAULT NULL,
  `AlgorithmParameterPath` varchar(200) DEFAULT NULL,
  `AlgorithmDescription` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`AlgorithmID`),
  UNIQUE KEY `AlgorithmName` (`AlgorithmName`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `algorithm`
--

INSERT INTO `algorithm` (`AlgorithmID`, `AlgorithmName`, `AlgorithmType`, `AlgorithmSourcer`, `AlgorithmCreater`, `AlgorithmCreaterCompany`, `AlgorithmCreaterAddr`, `AlgorithmCreaterPostcode`, `AlgorithmCreaterPhone`, `AlgorithmCreaterEmail`, `AlgorithmCreaterData`, `AlgorithmVersion`, `AlgorithmPath`, `AlgorithmParameter`, `AlgorithmUploader`, `AlgorithmUploaderCompany`, `AlgorithmUploaderAddr`, `AlgorithmUploaderPostcode`, `AlgorithmUploaderPhone`, `AlgorithmUploaderEmail`, `AlgorithmCreateTime`, `AlgorithmChangeTime`, `AlgorithmParameterPath`, `AlgorithmDescription`) VALUES
(3, 'apriori', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'minsupport', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '��'),
(4, 'charm', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'minsupport', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'wewqewq'),
(7, 'prefixspan', 'fim', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'D:Program Filescygwinhomeyizhouprojectdmplatformversion3webWEB-INFlibprefixspan.jar', 'minsupport', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'D:Program Filescygwinhomeyizhouprojectdmplatformversion3configsprefixspan.xml', 'ee');

-- --------------------------------------------------------

--
-- 表的结构 `dataset`
--

CREATE TABLE IF NOT EXISTS `dataset` (
  `DSID` int(10) NOT NULL AUTO_INCREMENT,
  `DSName` varchar(50) DEFAULT NULL,
  `DSType` varchar(50) DEFAULT NULL,
  `DSPath` varchar(200) DEFAULT NULL,
  `DSSource` varchar(200) DEFAULT NULL,
  `DSCreater` varchar(200) DEFAULT NULL,
  `DSCreaterCompany` varchar(200) DEFAULT NULL,
  `DSCreaterAddr` varchar(200) DEFAULT NULL,
  `DSCreaterPostcode` varchar(200) DEFAULT NULL,
  `DSPhone` varchar(200) DEFAULT NULL,
  `DSEmail` varchar(200) DEFAULT NULL,
  `DSRecordNumber` varchar(200) DEFAULT NULL,
  `DSFieldNumber` varchar(200) DEFAULT NULL,
  `DSSize` varchar(200) DEFAULT NULL,
  `DSTpye` varchar(200) DEFAULT NULL,
  `DSMetadataDescription` varchar(200) DEFAULT NULL,
  `DSUploader` varchar(200) DEFAULT NULL,
  `DSUploaderCompany` varchar(200) DEFAULT NULL,
  `DSUploaderAddr` varchar(200) DEFAULT NULL,
  `DSUploaderPostcode` varchar(200) DEFAULT NULL,
  `DSUploaderPhone` varchar(200) DEFAULT NULL,
  `DSUploaderEmail` varchar(200) DEFAULT NULL,
  `DSCreateTime` date DEFAULT NULL,
  `DSUploadTime` date DEFAULT NULL,
  `DSChangeTime` date DEFAULT NULL,
  `DSDescription` varchar(200) DEFAULT NULL,
  `DSCount` int(11) NOT NULL DEFAULT '0',
  `DSTableHeadDefined` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`DSID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- 转存表中的数据 `dataset`
--

INSERT INTO `dataset` (`DSID`, `DSName`, `DSType`, `DSPath`, `DSSource`, `DSCreater`, `DSCreaterCompany`, `DSCreaterAddr`, `DSCreaterPostcode`, `DSPhone`, `DSEmail`, `DSRecordNumber`, `DSFieldNumber`, `DSSize`, `DSTpye`, `DSMetadataDescription`, `DSUploader`, `DSUploaderCompany`, `DSUploaderAddr`, `DSUploaderPostcode`, `DSUploaderPhone`, `DSUploaderEmail`, `DSCreateTime`, `DSUploadTime`, `DSChangeTime`, `DSDescription`, `DSCount`, `DSTableHeadDefined`) VALUES
(1, 'null', 'null', 'D://bootstrap-validation.js', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '162', '1', '6555', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-23', '2014-03-23', '2014-03-27', 'null', 0, 0),
(2, '', '', 'D://xx.txt', '', '', '', '', '', '', '', '1', '3', '19', '', '', '', '', '', '', '', '', '2014-03-23', '2014-03-23', '2014-03-23', '', 0, 0),
(4, 'null', 'null', 'D://null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '0', '1', '0', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-27', '2014-03-27', '2014-03-27', 'null', 0, 0),
(5, 'null', 'null', 'D://crashrept.ini', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '35', '1', '3623', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-27', '2014-03-27', '2014-03-27', 'null', 0, 0),
(6, 'null', 'null', 'D://1.txt', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '1', '3', '382', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-27', '2014-03-27', '2014-03-27', 'null', 0, 0),
(7, 'null', 'null', 'D://1.txt', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '1', '3', '401', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-27', '2014-03-27', '2014-03-27', 'null', 0, 0),
(8, 'asas', '', 'D://xx.txt', '', '', '', '', '', '', '', '1', '3', '19', '', '', '', '', '', '', '', '', '2014-03-28', '2014-03-28', '2014-03-28', '', 0, 0),
(9, 'qwe', '', 'D:/xx.txt', '', '', '', '', '', '', '', '1', '3', '19', '', '', '', '', '', '', '', '', '2014-03-28', '2014-03-28', '2014-03-28', '', 0, 0),
(10, 'null', 'null', 'D:/Program Files/Apache Software Foundation/Tomcat 7.0/upload/1.txt', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '6', '1', '0', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-29', '2014-03-29', '2014-03-29', 'null', 0, 0),
(11, 'null', 'null', 'D:/Program Files/Apache Software Foundation/Tomcat 7.0/upload/1.txt', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '0', '3', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-29', '2014-03-29', '2014-03-29', 'null', 0, 0),
(12, 'null', 'null', 'D:/Program Files/Apache Software Foundation/Tomcat 7.0/upload/1.txt', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '0', '3', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-29', '2014-03-29', '2014-03-29', 'null', 0, 0),
(13, 'null', 'null', 'D:/Program Files/Apache Software Foundation/Tomcat 7.0/upload/1.txt', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2', '1', '0', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '2014-03-29', '2014-03-29', '2014-03-29', 'null', 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `dsmetadata`
--

CREATE TABLE IF NOT EXISTS `dsmetadata` (
  `DSID` int(11) NOT NULL AUTO_INCREMENT,
  `DSTableHeadDefined` varchar(1) NOT NULL DEFAULT 'N',
  `DSFieldsInfo` varchar(2000) DEFAULT '',
  PRIMARY KEY (`DSID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- 转存表中的数据 `dsmetadata`
--

INSERT INTO `dsmetadata` (`DSID`, `DSTableHeadDefined`, `DSFieldsInfo`) VALUES
(2, 'Y', 'field1$#$String$#$-xzczc$#$field2$#$String$#$-撒旦$#$field3$#$String$#$-$#$'),
(10, 'N', ''),
(11, 'N', ''),
(12, 'N', ''),
(13, 'N', '');

-- --------------------------------------------------------

--
-- 表的结构 `result`
--

CREATE TABLE IF NOT EXISTS `result` (
  `ResultID` int(10) NOT NULL AUTO_INCREMENT,
  `ResultName` varchar(200) DEFAULT NULL,
  `ResultPath` varchar(200) DEFAULT NULL,
  `TaskID` int(10) DEFAULT NULL,
  `TaskName` varchar(200) DEFAULT NULL,
  `TIID` int(10) DEFAULT NULL,
  `TIName` varchar(200) DEFAULT NULL,
  `ResultType` varchar(200) DEFAULT NULL,
  `ResultTime` date DEFAULT NULL,
  `ResultDescription` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ResultID`),
  KEY `TaskID` (`TaskID`),
  KEY `TIID` (`TIID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

-- --------------------------------------------------------

--
-- 表的结构 `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `TaskID` int(10) NOT NULL AUTO_INCREMENT,
  `TaskName` varchar(200) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `TaskConfiguration` varchar(500) DEFAULT NULL,
  `TaskDSID` int(10) DEFAULT NULL,
  `TaskCreateTime` datetime DEFAULT NULL,
  `TaskChangeTime` datetime DEFAULT NULL,
  `TaskDescription` varchar(200) DEFAULT NULL,
  `TaskPriority` int(10) DEFAULT NULL,
  `AlgorithmID` int(11) NOT NULL,
  `TaskLatestRunTime` datetime DEFAULT NULL,
  `TaskRunNumber` int(11) NOT NULL DEFAULT '0',
  `TaskResultPath` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`TaskID`),
  KEY `UserID` (`UserID`),
  KEY `AlgorithmID` (`AlgorithmID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=49 ;

--
-- 转存表中的数据 `task`
--

INSERT INTO `task` (`TaskID`, `TaskName`, `UserID`, `TaskConfiguration`, `TaskDSID`, `TaskCreateTime`, `TaskChangeTime`, `TaskDescription`, `TaskPriority`, `AlgorithmID`, `TaskLatestRunTime`, `TaskRunNumber`, `TaskResultPath`) VALUES
(4, 'asdf', 10, 'G:/dataminingplatform/git/10/Task/4/paraments.xml', 1, '2014-03-24 10:55:29', '2014-03-24 10:55:29', '', 5, 3, '2014-03-30 20:31:09', 1, 'G:/dataminingplatform/git/10/Task/4'),
(19, '1qwq', 10, 'C:/10/Task/5/paraments.xml', 1, '2014-03-25 12:33:00', '2014-03-25 12:33:00', '', 1, 4, NULL, 0, 'C:/10/Task/5'),
(20, 'qw', 10, 'C:/10/Task/20/paraments.xml', 1, '2014-03-25 12:34:27', '2014-03-25 12:34:27', '', 5, 4, NULL, 0, 'C:/10/Task/20'),
(22, 'op', 10, 'C:/10/Task/21/paraments.xml', 1, '2014-03-25 20:35:49', '2014-03-25 20:35:49', '', 2, 4, NULL, 0, 'C:/10/Task/21'),
(23, 'wqeqweqw', 10, 'C:/10/Task/23/paraments.xml', 1, '2014-03-25 20:39:10', '2014-03-25 20:39:10', '', 4, 4, NULL, 0, 'C:/10/Task/23'),
(24, 'rtretret', 10, 'C:/10/Task/24/paraments.xml', 1, '2014-03-25 20:39:22', '2014-03-25 20:39:22', '', 1, 3, '2014-03-27 17:26:41', 2, 'C:/10/Task/24'),
(25, 'ewrewrew', 10, 'C:/10/Task/25/paraments.xml', 1, '2014-03-25 20:45:44', '2014-03-25 20:45:44', '', 5, 3, NULL, 0, 'C:/10/Task/25'),
(26, '21321321321', 10, 'C:/10/Task/26/paraments.xml', 1, '2014-03-25 20:45:54', '2014-03-25 20:45:54', '', 5, 3, NULL, 0, 'C:/10/Task/26'),
(27, 'asd', 10, 'C:/10/Task/27/paraments.xml', 2, '2014-03-26 11:42:02', '2014-03-26 11:42:02', '', 1, 4, NULL, 0, 'C:/10/Task/27'),
(28, 'ioi', 10, 'C:/10/Task/28/paraments.xml', 2, '2014-03-26 11:49:43', '2014-03-26 11:49:43', '', 1, 3, NULL, 0, 'C:/10/Task/28'),
(29, 'ioiee', 10, 'C:/10/Task/29/paraments.xml', 2, '2014-03-26 11:50:24', '2014-03-26 11:50:24', '', 1, 4, NULL, 0, 'C:/10/Task/29'),
(30, 'ert', 10, 'C:/10/Task/30/paraments.xml', 2, '2014-03-26 11:52:19', '2014-03-26 11:52:19', '', 1, 4, NULL, 0, 'C:/10/Task/30'),
(31, 'ert', 10, 'C:/10/Task/31/paraments.xml', 2, '2014-03-26 11:55:17', '2014-03-26 11:55:17', '', 1, 4, '2014-03-26 11:55:58', 1, 'C:/10/Task/31'),
(32, 'qqqqq', 10, 'C:/10/Task/32/paraments.xml', 2, '2014-03-27 16:57:55', '2014-03-27 16:57:55', '', 1, 4, '2014-03-27 16:58:09', 1, 'C:/10/Task/32'),
(33, 'zyzpp', 10, 'C:/10/Task/33/paraments.xml', 2, '2014-03-28 12:16:21', '2014-03-28 12:16:21', '', 5, 4, '2014-03-28 12:34:34', 5, 'C:/10/Task/33'),
(34, 'qwewqeqw', 10, 'C:/10/Task/34/paraments.xml', 8, '2014-03-28 12:38:26', '2014-03-28 12:38:26', '', 5, 4, '2014-03-28 12:38:49', 1, 'C:/10/Task/34'),
(35, '', 10, 'C:/10/Task/35/paraments.xml', 9, '2014-03-30 19:42:38', '2014-03-30 19:42:38', '', 3, 4, '2014-03-28 13:57:03', 7, 'C:/10/Task/35'),
(36, 'sadsadsa', 10, 'C:/10/Task/36/paraments.xml', 2, '2014-03-28 14:02:55', '2014-03-28 14:02:55', '', 4, 4, '2014-03-28 14:24:31', 8, 'C:/10/Task/36'),
(37, 'TaskName', 10, 'C:/10/Task/37/paraments.xml', 9, '2014-03-28 14:27:59', '2014-03-28 14:27:59', 'sdasdarewrew', 5, 7, '2014-03-29 11:12:46', 15, 'C:/10/Task/37'),
(38, 'sadsadsa', 10, 'C:/10/Task/38/paraments.xml', 2, '2014-03-29 10:56:04', '2014-03-29 10:56:04', '', 5, 4, NULL, 0, 'C:/10/Task/38'),
(39, 'asdsadsadas', 10, 'C:/10/Task/39/paraments.xml', 2, '2014-03-29 10:58:10', '2014-03-29 10:58:10', '', 5, 4, NULL, 0, 'C:/10/Task/39'),
(40, 'zyzohye', 10, 'C:/10/Task/40/paraments.xml', 2, '2014-03-29 10:59:41', '2014-03-29 10:59:41', '', 5, 4, NULL, 0, 'C:/10/Task/40'),
(41, 'zyzho', 10, 'C:/10/Task/41/paraments.xml', 2, '2014-03-29 11:11:33', '2014-03-29 11:11:33', '', 5, 7, NULL, 0, 'C:/10/Task/41'),
(42, 'sadsadsa', 10, 'C:/10/Task/42/paraments.xml', 2, '2014-03-29 11:45:06', '2014-03-29 11:45:06', 'sadsadas', 2, 7, NULL, 0, 'C:/10/Task/42'),
(43, 'adsadsa', 10, 'C:/10/Task/43/paraments.xml', 2, '2014-03-29 11:46:15', '2014-03-29 11:46:15', '21312312', 2, 7, NULL, 0, 'C:/10/Task/43'),
(44, 'SDADSA', 10, 'C:/10/Task/44/paraments.xml', 2, '2014-03-29 11:47:01', '2014-03-29 11:47:01', '', 1, 4, NULL, 0, 'C:/10/Task/44'),
(45, 'asdsadsa', 10, 'C:/10/Task/45/paraments.xml', 2, '2014-03-29 11:48:01', '2014-03-29 11:48:01', '', 1, 7, NULL, 0, 'C:/10/Task/45'),
(46, 'sadsa', 10, 'C:/10/Task/46/paraments.xml', 2, '2014-03-29 11:48:45', '2014-03-29 11:48:45', '', 2, 4, NULL, 0, 'C:/10/Task/46'),
(47, 'zyzohye', 10, 'C:/10/Task/47/paraments.xml', 2, '2014-03-30 10:55:19', '2014-03-30 10:55:19', 'dsfsaf', 3, 7, '2014-04-02 10:46:44', 3, 'C:/10/Task/47'),
(48, '任务名称', 10, 'C:/10/Task/48/paraments.xml', 1, '2014-04-02 10:12:45', '2014-04-02 10:12:45', '任务描述', 1, 7, '2014-04-02 12:09:02', 14, 'C:/10/Task/48');

-- --------------------------------------------------------

--
-- 表的结构 `taskinstance`
--

CREATE TABLE IF NOT EXISTS `taskinstance` (
  `TIID` int(10) NOT NULL AUTO_INCREMENT,
  `TIName` varchar(200) DEFAULT NULL,
  `TaskID` int(10) DEFAULT NULL,
  `TIConfiguration` varchar(500) DEFAULT NULL,
  `TIDSID` int(10) DEFAULT NULL,
  `TIResultID` int(10) DEFAULT NULL,
  `TIStartTime` datetime DEFAULT NULL,
  `TIDescription` varchar(200) DEFAULT NULL,
  `TIState` int(10) DEFAULT NULL,
  `TISuspendtime` datetime DEFAULT NULL,
  `TIEndtime` datetime DEFAULT NULL,
  `TIResultPath` varchar(200) DEFAULT NULL,
  `AlgorithmID` int(10) NOT NULL,
  `UserID` int(11) NOT NULL,
  PRIMARY KEY (`TIID`),
  KEY `TIDSID` (`TIDSID`),
  KEY `TaskID` (`TaskID`),
  KEY `AlgorithmID` (`AlgorithmID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=47 ;

--
-- 转存表中的数据 `taskinstance`
--

INSERT INTO `taskinstance` (`TIID`, `TIName`, `TaskID`, `TIConfiguration`, `TIDSID`, `TIResultID`, `TIStartTime`, `TIDescription`, `TIState`, `TISuspendtime`, `TIEndtime`, `TIResultPath`, `AlgorithmID`, `UserID`) VALUES
(9, 'dsfdsfds', 36, 'C:/10/Task/36/4/paraments.xml', 2, NULL, '2014-03-28 14:10:12', '', -1, '2014-03-30 20:30:58', '2014-03-28 14:10:12', 'C:/10/Task/36/4', 4, 10),
(10, 'dsfdsfdsfdsfsd', 36, 'C:/10/Task/36/6/paraments.xml', 2, NULL, '2014-03-28 14:11:57', '', -1, '2014-03-30 20:12:59', '2014-03-28 14:14:41', 'C:/10/Task/36/6', 4, 10),
(11, 'dsfdsfdsfdsfsd', 36, 'C:/10/Task/36/6/paraments.xml', 2, NULL, '2014-03-28 14:14:41', '', -1, '2014-03-30 20:31:02', '2014-03-28 14:14:41', 'C:/10/Task/36/6', 4, 10),
(12, 'qqq', 36, 'C:/10/Task/36/8/paraments.xml', 2, NULL, '2014-03-28 14:24:31', '', -1, '2014-03-30 20:31:00', '2014-03-28 14:24:31', 'C:/10/Task/36/8', 4, 10),
(13, 'TIName', 37, 'C:/10/Task/37/1/paraments.xml', 9, NULL, '2014-03-28 14:28:34', 'sdasdarewrew', 1, NULL, '2014-03-28 14:29:54', 'C:/10/Task/37/1', 7, 10),
(14, 'TIName', 37, 'C:/10/Task/37/1/paraments.xml', 9, NULL, '2014-03-28 14:29:54', 'sdasdarewrew', 1, NULL, '2014-03-28 14:29:54', 'C:/10/Task/37/1', 7, 10),
(15, 'TIName1', 37, 'C:/10/Task/37/3/paraments.xml', 9, NULL, '2014-03-28 14:33:48', 'sdasdarewrew', 1, NULL, '2014-03-28 14:36:21', 'C:/10/Task/37/3', 7, 10),
(16, 'TIName1', 37, 'C:/10/Task/37/3/paraments.xml', 9, NULL, '2014-03-28 14:34:46', 'sdasdarewrew', 1, NULL, '2014-03-28 14:36:21', 'C:/10/Task/37/3', 7, 10),
(17, 'TIName1', 37, 'C:/10/Task/37/3/paraments.xml', 9, NULL, '2014-03-28 14:36:21', 'sdasdarewrew', 1, NULL, '2014-03-28 14:36:21', 'C:/10/Task/37/3', 7, 10),
(18, 'sdsd', 37, 'C:/10/Task/37/6/paraments.xml', 9, NULL, '2014-03-29 10:53:52', 'sdasdarewrew', 1, NULL, '2014-03-29 10:53:52', 'C:/10/Task/37/6', 7, 10),
(19, 'wqewqewqewqeqw', 37, 'C:/10/Task/37/7/paraments.xml', 9, NULL, '2014-03-29 10:55:19', 'sdasdarewrew', 1, NULL, '2014-03-29 10:55:37', 'C:/10/Task/37/7', 7, 10),
(20, 'wqewqewqewqeqw', 37, 'C:/10/Task/37/7/paraments.xml', 9, NULL, '2014-03-29 10:55:37', 'sdasdarewrew', 1, NULL, '2014-03-29 10:55:37', 'C:/10/Task/37/7', 7, 10),
(21, 'fdsfdsfdsfsd', 37, 'C:/10/Task/37/9/paraments.xml', 9, NULL, '2014-03-29 11:02:05', 'sdasdarewrew', 1, NULL, '2014-03-29 11:03:21', 'C:/10/Task/37/9', 7, 10),
(22, 'fdsfdsfdsfsd', 37, 'C:/10/Task/37/9/paraments.xml', 9, NULL, '2014-03-29 11:03:21', 'sdasdarewrew', 1, NULL, '2014-03-29 11:03:21', 'C:/10/Task/37/9', 7, 10),
(23, 'saDSadsADsa', 37, 'C:/10/Task/37/11/paraments.xml', 9, NULL, '2014-03-29 11:03:39', 'sdasdarewrew', 1, NULL, '2014-03-29 11:03:39', 'C:/10/Task/37/11', 7, 10),
(24, 'dsfdsfdsfds', 37, 'C:/10/Task/37/12/paraments.xml', 9, NULL, '2014-03-29 11:04:32', 'sdasdarewrew', 1, NULL, '2014-03-29 11:04:32', 'C:/10/Task/37/12', 7, 10),
(25, 'sdsadasdas', 37, 'C:/10/Task/37/13/paraments.xml', 9, NULL, '2014-03-29 11:05:21', 'sdasdarewrew', 1, NULL, '2014-03-29 11:05:21', 'C:/10/Task/37/13', 7, 10),
(26, 'zyzoh', 37, 'C:/10/Task/37/14/paraments.xml', 9, NULL, '2014-03-29 11:08:42', 'sdasdarewrew', 1, NULL, '2014-03-29 11:08:42', 'C:/10/Task/37/14', 7, 10),
(27, 'asd', 37, 'C:/10/Task/37/15/paraments.xml', 9, NULL, '2014-03-29 11:12:46', 'sdasdarewrew', 1, NULL, '2014-03-29 11:12:46', 'C:/10/Task/37/15', 7, 10),
(29, 'zyzohyeye', 47, 'C:/10/Task/47/1/paraments.xml', 2, NULL, '2014-03-30 10:57:20', 'dsfsaf', 1, NULL, '2014-03-30 10:57:20', 'C:/10/Task/47/1', 7, 10),
(31, '', 4, 'G:/dataminingplatform/git/10/Task/4/1/paraments.xml', 1, NULL, '2014-03-30 20:31:09', '', 1, NULL, '2014-03-30 20:31:09', 'G:/dataminingplatform/git/10/Task/4/1', 3, 10),
(32, '任务实例', 48, 'C:/10/Task/48/1/paraments.xml', 1, NULL, '2014-04-02 10:17:16', '任务描述', 1, NULL, '2014-04-02 10:17:16', 'C:/10/Task/48/1', 7, 10),
(33, '任务实例2', 47, 'C:/10/Task/47/3/paraments.xml', 2, NULL, '2014-04-02 10:46:44', 'dsfsaf', 1, NULL, '2014-04-02 10:46:44', 'C:/10/Task/47/3', 7, 10),
(34, 'TIName1', 48, 'C:/10/Task/48/2/paraments.xml', 1, NULL, '2014-04-02 11:02:22', '任务描述', 1, NULL, '2014-04-02 11:08:24', 'C:/10/Task/48/2', 7, 10),
(35, 'TIName1', 48, 'C:/10/Task/48/2/paraments.xml', 1, NULL, '2014-04-02 11:08:23', '????', 1, NULL, '2014-04-02 11:08:24', 'C:/10/Task/48/2', 7, 10),
(36, 'TIName', 48, 'C:/10/Task/48/4/paraments.xml', 1, NULL, '2014-04-02 11:11:12', '????', 1, NULL, '2014-04-02 11:11:12', 'C:/10/Task/48/4', 7, 10),
(39, 'TIName', 48, 'C:/10/Task/48/5/paraments.xml', 1, NULL, '2014-04-02 11:19:53', '????', 1, NULL, '2014-04-02 11:19:54', 'C:/10/Task/48/5', 7, 10),
(40, 'TIName', 48, 'C:/10/Task/48/8/paraments.xml', 1, NULL, '2014-04-02 11:28:24', '????', 1, NULL, '2014-04-02 11:28:25', 'C:/10/Task/48/8', 7, 10),
(41, 'TIName', 48, 'C:/10/Task/48/9/paraments.xml', 1, NULL, '2014-04-02 11:30:53', '????', 1, NULL, '2014-04-02 11:30:53', 'C:/10/Task/48/9', 7, 10),
(42, 'TIName', 48, 'C:/10/Task/48/10/paraments.xml', 1, NULL, '2014-04-02 11:47:34', '????', 1, NULL, '2014-04-02 11:47:34', 'C:/10/Task/48/10', 7, 10),
(43, 'TIName', 48, 'C:/10/Task/48/11/paraments.xml', 1, NULL, '2014-04-02 11:54:05', '????', 1, NULL, '2014-04-02 11:54:05', 'C:/10/Task/48/11', 7, 10),
(44, 'TIName', 48, 'C:/10/Task/48/12/paraments.xml', 1, NULL, '2014-04-02 11:58:32', '????', 1, NULL, '2014-04-02 11:58:32', 'C:/10/Task/48/12', 7, 10),
(45, 'TIName', 48, 'C:/10/Task/48/13/paraments.xml', 1, NULL, '2014-04-02 12:01:43', '????', 1, NULL, '2014-04-02 12:01:43', 'C:/10/Task/48/13', 7, 10),
(46, 'TIName', 48, 'C:/10/Task/48/14/paraments.xml', 1, NULL, '2014-04-02 12:09:02', '????', 1, NULL, '2014-04-02 12:09:02', 'C:/10/Task/48/14', 7, 10);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(10) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `Profession` varchar(50) DEFAULT NULL,
  `Company` varchar(200) DEFAULT NULL,
  `CAddress` varchar(200) DEFAULT NULL,
  `CPhone` varchar(50) DEFAULT NULL,
  `CEmail` varchar(50) DEFAULT NULL,
  `UserEmail` varchar(50) DEFAULT NULL,
  `UserMSN` varchar(50) DEFAULT NULL,
  `UserQQ` varchar(50) DEFAULT NULL,
  `UserMobile` varchar(50) DEFAULT NULL,
  `UserPhone` varchar(50) DEFAULT NULL,
  `Password` blob NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `image` varchar(50) DEFAULT NULL,
  `LoginTag` int(1) NOT NULL DEFAULT '0',
  `LastLoginTime` timestamp NULL DEFAULT '1970-03-21 03:37:45',
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserName` (`UserName`),
  UNIQUE KEY `UserName_2` (`UserName`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`UserID`, `UserName`, `Profession`, `Company`, `CAddress`, `CPhone`, `CEmail`, `UserEmail`, `UserMSN`, `UserQQ`, `UserMobile`, `UserPhone`, `Password`, `status`, `image`, `LoginTag`, `LastLoginTime`) VALUES
(7, 'op', '海贼', '', '无', '', 'dsfds@fdsf', '', '', '', '', '', 0x2c2c0bea239b27e73154487840cedbe9, 0, 'null', 1, '2014-03-27 02:45:45'),
(9, '111', '', '', '', '', '', '', '', '', '', '', 0x2c2c0bea239b27e73154487840cedbe9, 0, 'null', 0, '1970-03-21 03:37:45'),
(10, 'zyz', '学生', '无', '张一舟', '18801734831', '', 'wqewq@fdsf', 'dsf', '28299933467', '11111111111', '', 0x2c2c0bea239b27e73154487840cedbe9, 0, 'null', 0, '2014-04-02 04:39:05'),
(11, 'sdf', '', '', '', '', '', '', '', '', '', '', 0x2c2c0bea239b27e73154487840cedbe9, 0, 'null', 0, '1970-03-21 03:37:45'),
(12, 'iop', '', '', '', '', '', '', '', '', '', '', 0x2c2c0bea239b27e73154487840cedbe9, 0, 'null', 0, '1970-03-21 03:37:45');

--
-- 限制导出的表
--

--
-- 限制表 `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`TaskID`) REFERENCES `task` (`TaskID`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`TIID`) REFERENCES `taskinstance` (`TIID`);

--
-- 限制表 `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  ADD CONSTRAINT `task_ibfk_2` FOREIGN KEY (`AlgorithmID`) REFERENCES `algorithm` (`AlgorithmID`);

--
-- 限制表 `taskinstance`
--
ALTER TABLE `taskinstance`
  ADD CONSTRAINT `taskinstance_ibfk_1` FOREIGN KEY (`TIDSID`) REFERENCES `dataset` (`DSID`),
  ADD CONSTRAINT `taskinstance_ibfk_2` FOREIGN KEY (`TaskID`) REFERENCES `task` (`TaskID`),
  ADD CONSTRAINT `taskinstance_ibfk_3` FOREIGN KEY (`AlgorithmID`) REFERENCES `algorithm` (`AlgorithmID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
