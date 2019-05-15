-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.31


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_hmis
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ db_hmis;
USE db_hmis;

--
-- Table structure for table `db_hmis`.`hmis_approved`
--

DROP TABLE IF EXISTS `hmis_approved`;
CREATE TABLE `hmis_approved` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `approved_sessionsId` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_trackerId` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_executorId` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_startDate` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_endDate` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_status` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_file` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_statusLog` longtext CHARACTER SET utf8mb4,
  `approved_fileOfResponsible` varchar(45) DEFAULT NULL,
  `approved_fileCheckOut` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COMMENT='مصوبه';

--
-- Dumping data for table `db_hmis`.`hmis_approved`
--

/*!40000 ALTER TABLE `hmis_approved` DISABLE KEYS */;
INSERT INTO `hmis_approved` (`id`,`approved_sessionsId`,`approved_trackerId`,`approved_executorId`,`approved_title`,`approved_startDate`,`approved_endDate`,`approved_status`,`approved_file`,`approved_description`,`approved_statusLog`,`approved_fileOfResponsible`,`approved_fileCheckOut`) VALUES 
 (5,5,1,2,'جلسه اردیبهشت کمیته ی اجرایی',13971216,13971211,'در حال انجام','','ندارد','در حال انجام-1398/02/10 09:45:59#A#','',NULL),
 (6,5,2,1,'تحقق ',13980105,13980201,'غیر قابل انجام','p6181782938.png%23A%23p5148789144.png%23A%23','یبیییییییییییییییییییییییییییییییییی','در حال انجام-1398/02/10 09:45:59#A#','',NULL),
 (7,6,1,1,'ختصصاصی تعیین گردد',13971203,13980203,'در حال انجام','','aaaaaaaaaaaaaaaaaaaaa','در حال انجام-1398/02/10 09:45:59#A#','',NULL),
 (8,7,2,1,'درصد ',13971201,13980231,'در حال انجام','','ندارد','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (9,7,2,2,'درصد تحقق اهداف اختصصاصی تعیین گردد',13971201,13980231,'در حال انجام','','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL);
INSERT INTO `hmis_approved` (`id`,`approved_sessionsId`,`approved_trackerId`,`approved_executorId`,`approved_title`,`approved_startDate`,`approved_endDate`,`approved_status`,`approved_file`,`approved_description`,`approved_statusLog`,`approved_fileOfResponsible`,`approved_fileCheckOut`) VALUES 
 (10,8,2,1,'',13971204,13980231,'در حال انجام','','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (11,6,1,1,'',13980126,13980203,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (12,6,2,2,'درصد تحقق اهداف اختصصاصی تعیین گردد',13980126,13980223,'غیر قابل انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#','',NULL),
 (13,6,2,1,'',13980126,13980203,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (14,7,1,1,'',13980126,13980231,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (15,7,1,1,'',13980126,13980231,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL);
INSERT INTO `hmis_approved` (`id`,`approved_sessionsId`,`approved_trackerId`,`approved_executorId`,`approved_title`,`approved_startDate`,`approved_endDate`,`approved_status`,`approved_file`,`approved_description`,`approved_statusLog`,`approved_fileOfResponsible`,`approved_fileCheckOut`) VALUES 
 (16,7,2,1,'',13980126,13980231,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (17,7,1,1,'',13980126,13980231,'انجام شده','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#','',NULL),
 (18,7,1,2,'',13980126,13980214,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:45:59#A#',NULL,NULL),
 (19,7,1,1,'',13980126,13980231,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:50:43#A#',NULL,NULL),
 (20,8,1,1,'درصد تحقق اهداف اختصصاصی تعیین گردد',13980126,13980231,'در حال انجام','','','در حال انجام-1398/02/10 09:58:24#A#',NULL,NULL),
 (21,6,2,1,'',13980126,13980231,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 09:59:06#A#',NULL,NULL);
INSERT INTO `hmis_approved` (`id`,`approved_sessionsId`,`approved_trackerId`,`approved_executorId`,`approved_title`,`approved_startDate`,`approved_endDate`,`approved_status`,`approved_file`,`approved_description`,`approved_statusLog`,`approved_fileOfResponsible`,`approved_fileCheckOut`) VALUES 
 (22,7,1,1,'',13980126,13980231,'در حال انجام','[object Object]','','در حال انجام-1398/02/10 10:00:40#A#',NULL,NULL);
/*!40000 ALTER TABLE `hmis_approved` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_sessions`
--

DROP TABLE IF EXISTS `hmis_sessions`;
CREATE TABLE `hmis_sessions` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sessions_creatorId` int(11) NOT NULL DEFAULT '0',
  `sessions_commettesId` varchar(255) DEFAULT NULL,
  `sessions_title` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_contextInvitation` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_agenda` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_date` varchar(45) DEFAULT NULL,
  `sessions_time` varchar(45) DEFAULT NULL,
  `sessions_dateReminder` varchar(45) DEFAULT NULL,
  `sessions_timeReminder` varchar(45) DEFAULT NULL,
  `sessions_Invitees` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_InviteesOutSide` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_file` varchar(255) DEFAULT NULL,
  `sessions_InviteesFile` varchar(255) DEFAULT NULL,
  `sessions_status` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_statusLog` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_nextSessionDate` varchar(255) DEFAULT NULL,
  `sessions_strengths` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_weakPoint` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_titleIssue` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_checkingAgenda` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_sessionDescription` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_proposedSolution` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_InviteesInSide` varchar(255) DEFAULT NULL,
  `sessions_invitationDate` int(10) unsigned NOT NULL DEFAULT '100000000',
  `sessions_audience` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_audienceOutSide` varchar(255) DEFAULT NULL,
  `sessions_signers` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`hmis_sessions`
--

/*!40000 ALTER TABLE `hmis_sessions` DISABLE KEYS */;
INSERT INTO `hmis_sessions` (`id`,`sessions_creatorId`,`sessions_commettesId`,`sessions_title`,`sessions_contextInvitation`,`sessions_agenda`,`sessions_date`,`sessions_time`,`sessions_dateReminder`,`sessions_timeReminder`,`sessions_Invitees`,`sessions_InviteesOutSide`,`sessions_file`,`sessions_InviteesFile`,`sessions_status`,`sessions_statusLog`,`sessions_nextSessionDate`,`sessions_strengths`,`sessions_weakPoint`,`sessions_titleIssue`,`sessions_checkingAgenda`,`sessions_sessionDescription`,`sessions_proposedSolution`,`sessions_InviteesInSide`,`sessions_invitationDate`,`sessions_audience`,`sessions_audienceOutSide`,`sessions_signers`) VALUES 
 (5,1,'3','جلسه  فروردین کمیته ی اجرایی','متن دعوتنامه2','دستور جلسه2','1398/01/31','11 : 31 AM','1398/01/20','11 : 31 AM','2%23A%23','shiran,09302585485,s@yahoo.com,metron#A#shahla,09133368036,shahlaShiran@yahoo.com,parastar#A#','',NULL,'ابلاغ شده','ایجاد شده-1398/02/07 11:01:25#A#تایید نهایی-1398/02/07 11:01:25#A#ابلاغ شده-1398/02/08 09:14:57#A#','1397/12/05','قوت','ضعف','عنوان مسئله','دستور جلسه','شرح  جلسه','proposed','3%23A%234%23A%235%23A%23',13980128,'3%23A%234%23A%235%23A%231%23A%23','','3%23A%231%23A%23'),
 (6,1,'4','جلسه  فروردین کمیته ی اجرایی','متن دعوتنامه','دستور جلسه','1398/12/01','10 : 47 AM','1398/01/03','10 : 47 AM','1%23A%23','شهره شیران,09305282485,shiran_shohreh@yahoo.com,نماینده#A#','p7827950848.png%23A%23p9472619035.png%23A%23p1358937612.png%23A%23p6599507047.png%23A%23',NULL,'ابلاغ شده','ایجاد شده-1398/02/07 11:01:25#A#تایید نهایی-1398/02/07 11:01:25#A#ابلاغ شده-1398/02/08 09:14:57#A#','1398/01/21','','','','دستور جلسه','','','1%23A%233%23A%235%23A%23',13980202,'1%23A%233%23A%23','','1%23A%23');
INSERT INTO `hmis_sessions` (`id`,`sessions_creatorId`,`sessions_commettesId`,`sessions_title`,`sessions_contextInvitation`,`sessions_agenda`,`sessions_date`,`sessions_time`,`sessions_dateReminder`,`sessions_timeReminder`,`sessions_Invitees`,`sessions_InviteesOutSide`,`sessions_file`,`sessions_InviteesFile`,`sessions_status`,`sessions_statusLog`,`sessions_nextSessionDate`,`sessions_strengths`,`sessions_weakPoint`,`sessions_titleIssue`,`sessions_checkingAgenda`,`sessions_sessionDescription`,`sessions_proposedSolution`,`sessions_InviteesInSide`,`sessions_invitationDate`,`sessions_audience`,`sessions_audienceOutSide`,`sessions_signers`) VALUES 
 (7,1,'5','تیر','متن دعوتنامه','دستور جلسه','1398/04/16','11 : 33 AM','1398/03/29','11 : 33 AM','1%23A%232%23A%23','شهره شیران,09305285485,sh.sho@yahoo.com,مهمان#A#',NULL,'p4218347755.zip%23A%23','ابلاغ شده','ایجاد شده-1398/02/07 11:01:25#A#تایید نهایی-1398/02/07 11:01:25#A#ابلاغ شده-1398/02/08 09:14:57#A#','1398/02/31','','','','','','','3%23A%235%23A%2313%23A%23',13980204,'3%23A%235%23A%2312%23A%231%23A%23','',''),
 (8,1,'6','تست جلسات ','برای بهبود عملیات ها تشریف بیاورید ','نکات ارزشمند','1398/02/17','8 : 43 AM','1398/02/01','8 : 43 AM','1%23A%232%23A%23','شهره شیران,09305285485,sh.sho@yahoo.com,مهمان#A#',NULL,'p0493326189.png%23A%23','ابلاغ شده','ایجاد شده-1398/02/07 11:01:25#A#تایید نهایی-1398/02/07 11:01:25#A#ابلاغ شده-1398/02/08 09:14:57#A#','','','','','','','','3%23A%235%23A%23',13980211,'3%23A%235%23A%2312%23A%231%23A%23','','11%23A%23');
INSERT INTO `hmis_sessions` (`id`,`sessions_creatorId`,`sessions_commettesId`,`sessions_title`,`sessions_contextInvitation`,`sessions_agenda`,`sessions_date`,`sessions_time`,`sessions_dateReminder`,`sessions_timeReminder`,`sessions_Invitees`,`sessions_InviteesOutSide`,`sessions_file`,`sessions_InviteesFile`,`sessions_status`,`sessions_statusLog`,`sessions_nextSessionDate`,`sessions_strengths`,`sessions_weakPoint`,`sessions_titleIssue`,`sessions_checkingAgenda`,`sessions_sessionDescription`,`sessions_proposedSolution`,`sessions_InviteesInSide`,`sessions_invitationDate`,`sessions_audience`,`sessions_audienceOutSide`,`sessions_signers`) VALUES 
 (10,1,'6','test2','test2','','1398/02/01','9 : 01 AM','1398/02/31','9 : 01 AM','2%23A%23','شهره شیران,09305285485,sh.sho@yahoo.com,مهمان#A#',NULL,'p5519554919.png%23A%23','ایجاد شده','ایجاد شده-1398/02/11 09:04:11#A#',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'8%23A%2314%23A%23',13980211,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hmis_sessions` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
