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
-- Table structure for table `db_hmis`.`access_user`
--

DROP TABLE IF EXISTS `access_user`;
CREATE TABLE `access_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_pass` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_family` varchar(100) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_is_active` tinyint(1) DEFAULT NULL,
  `user_createDate` int(10) unsigned DEFAULT NULL,
  `user_question` varchar(255) DEFAULT NULL,
  `user_answer` varchar(255) DEFAULT NULL,
  `user_no1` varchar(255) DEFAULT NULL,
  `user_no2` varchar(255) DEFAULT NULL,
  `user_parent` int(10) unsigned DEFAULT NULL,
  `user_birthdate` int(10) unsigned DEFAULT NULL,
  `user_weblog` longtext,
  `user_char1` varchar(255) DEFAULT NULL,
  `user_char2` varchar(255) DEFAULT NULL,
  `user_char3` varchar(255) DEFAULT NULL,
  `user_int1` int(10) unsigned DEFAULT NULL,
  `user_int2` int(10) unsigned DEFAULT NULL,
  `user_int3` int(10) unsigned DEFAULT NULL,
  `user_password_hint` varchar(225) DEFAULT NULL,
  `user_mobile` varchar(100) DEFAULT NULL,
  `user_AccountInformation` varchar(100) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_jensiat` varchar(45) DEFAULT NULL,
  `user_codeMeli` varchar(100) DEFAULT NULL,
  `user_shomareShenasname` varchar(100) DEFAULT NULL,
  `user_grade` varchar(100) DEFAULT NULL,
  `user_passwordReminder` varchar(255) DEFAULT NULL,
  `user_file_personal` varchar(45) DEFAULT NULL,
  `user_file_Signature` varchar(45) DEFAULT NULL,
  `user_upload_file` varchar(45) DEFAULT NULL,
  `user_attachFile` varchar(255) DEFAULT NULL,
  `user_attachPicPersonal` varchar(45) DEFAULT NULL,
  `user_attachPicPersonnelCard` varchar(45) DEFAULT NULL,
  `user_attachPicSignature` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`access_user`
--

/*!40000 ALTER TABLE `access_user` DISABLE KEYS */;
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachPicPersonal`,`user_attachPicPersonnelCard`,`user_attachPicSignature`) VALUES 
 (0,'syetem','syetem','syetem',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (1,'b','محمد','ثالثی','b',1,13910822,'','','11','22',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (3,'a','razieh','jafari','a',0,13930202,'1','morteza','1270428020','1270428020',0,13681013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'p8904112256.jpg#A#p9825317778.jpg#A#','p3248818830.jpg','p9119122122.jpg','p7781201565.jpg');
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachPicPersonal`,`user_attachPicPersonnelCard`,`user_attachPicSignature`) VALUES 
 (17,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'p8904112256.jpg#A#','p5339429801.jpg','p9119122122.jpg','p7781201565.jpg'),
 (18,'','mmm','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'p8904112256.jpg#A#','p0748467556.jpg','p9119122122.jpg','p7781201565.jpg'),
 (19,'','elahe','shiran','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'','p0748467556.jpg','p9119122122.jpg','p7781201565.jpg');
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachPicPersonal`,`user_attachPicPersonnelCard`,`user_attachPicSignature`) VALUES 
 (20,'','mmmmmmmmmmm','','',0,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'','p2662244021.jpg','p9119122122.jpg','p7781201565.jpg'),
 (21,'','لاله','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,NULL,'p2662244021.jpg','p1292438841.jpg','p7781201565.jpg'),
 (22,'','مبینا','اللهی','shiran.shohreh@gmail.com',0,NULL,NULL,NULL,NULL,NULL,NULL,13980115,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'23131321','','خانم','12121212121','1321321312321','','',NULL,NULL,NULL,'','p0756985189.jpg','p9737441440.jpg','p3358216513.jpg');
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachPicPersonal`,`user_attachPicPersonnelCard`,`user_attachPicSignature`) VALUES 
 (23,'','nnnn','','',0,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'p5424491882.jpg#A#','p9032079157.jpg','',''),
 (24,'','hjhjk','jhkj','jkhkj@gmail.com',0,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','اقای','','','','',NULL,NULL,NULL,'','p6103900071.png','p6524158662.png','');
/*!40000 ALTER TABLE `access_user` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_createdocumentary`
--

DROP TABLE IF EXISTS `hmis_createdocumentary`;
CREATE TABLE `hmis_createdocumentary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `createDocumentary_title` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_owner` varchar(45) DEFAULT NULL,
  `createDocumentary_owner_role` varchar(45) DEFAULT NULL,
  `createDocumentary_file1` varchar(45) DEFAULT NULL,
  `createDocumentary_file2` varchar(45) DEFAULT NULL,
  `createDocumentary_file3` varchar(45) DEFAULT NULL,
  `createDocumentary_htmlContent` longtext CHARACTER SET utf8,
  `createDocumentary_signatory_user_1` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_2` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_3` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_4` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_5` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_6` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_7` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_8` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_9` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_10` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_11` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_12` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_13` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_14` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_15` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_16` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_17` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_18` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_19` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_user_20` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_1` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_title_2` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_title_3` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_4` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_5` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_6` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_7` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_8` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_9` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_10` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_11` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_12` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_13` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_14` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_15` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_16` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_17` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_18` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_19` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_title_20` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_signature_1` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_2` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_3` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_4` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_5` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_6` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_7` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_8` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_9` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_10` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_11` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_12` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_13` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_14` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_15` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_16` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_17` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_18` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_19` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_signature_20` int(11) NOT NULL DEFAULT '-1',
  `createDocumentary_signatory_comment_1` longtext,
  `createDocumentary_signatory_comment_2` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_3` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_4` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_5` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_6` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_7` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_8` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_9` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_10` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_11` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_12` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_13` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_14` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_15` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_16` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_17` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_18` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_19` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_comment_20` varchar(45) DEFAULT NULL,
  `createDocumentary_attachmentfile3` varchar(45) DEFAULT NULL,
  `createDocumentary_attachmentfile2` varchar(45) DEFAULT NULL,
  `createDocumentary_attachmentfile1` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_date` varchar(45) DEFAULT NULL,
  `createDocumentary_summary` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_category` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_titleFile3` varchar(45) DEFAULT NULL,
  `createDocumentary_titleFile2` varchar(45) DEFAULT NULL,
  `createDocumentary_titleFile1` varchar(45) DEFAULT NULL,
  `createDocumentary_signatory_role_1` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_2` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_3` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_4` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_5` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_6` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_7` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_8` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_9` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_10` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_11` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_12` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_13` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_14` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_15` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_16` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_17` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_18` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_19` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_signatory_role_20` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `createDocumentary_attachmentfileTitle1` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`hmis_createdocumentary`
--

/*!40000 ALTER TABLE `hmis_createdocumentary` DISABLE KEYS */;
INSERT INTO `hmis_createdocumentary` (`id`,`createDocumentary_title`,`createDocumentary_owner`,`createDocumentary_owner_role`,`createDocumentary_file1`,`createDocumentary_file2`,`createDocumentary_file3`,`createDocumentary_htmlContent`,`createDocumentary_signatory_user_1`,`createDocumentary_signatory_user_2`,`createDocumentary_signatory_user_3`,`createDocumentary_signatory_user_4`,`createDocumentary_signatory_user_5`,`createDocumentary_signatory_user_6`,`createDocumentary_signatory_user_7`,`createDocumentary_signatory_user_8`,`createDocumentary_signatory_user_9`,`createDocumentary_signatory_user_10`,`createDocumentary_signatory_user_11`,`createDocumentary_signatory_user_12`,`createDocumentary_signatory_user_13`,`createDocumentary_signatory_user_14`,`createDocumentary_signatory_user_15`,`createDocumentary_signatory_user_16`,`createDocumentary_signatory_user_17`,`createDocumentary_signatory_user_18`,`createDocumentary_signatory_user_19`,`createDocumentary_signatory_user_20`,`createDocumentary_signatory_title_1`,`createDocumentary_signatory_title_2`,`createDocumentary_signatory_title_3`,`createDocumentary_signatory_title_4`,`createDocumentary_signatory_title_5`,`createDocumentary_signatory_title_6`,`createDocumentary_signatory_title_7`,`createDocumentary_signatory_title_8`,`createDocumentary_signatory_title_9`,`createDocumentary_signatory_title_10`,`createDocumentary_signatory_title_11`,`createDocumentary_signatory_title_12`,`createDocumentary_signatory_title_13`,`createDocumentary_signatory_title_14`,`createDocumentary_signatory_title_15`,`createDocumentary_signatory_title_16`,`createDocumentary_signatory_title_17`,`createDocumentary_signatory_title_18`,`createDocumentary_signatory_title_19`,`createDocumentary_signatory_title_20`,`createDocumentary_signatory_signature_1`,`createDocumentary_signatory_signature_2`,`createDocumentary_signatory_signature_3`,`createDocumentary_signatory_signature_4`,`createDocumentary_signatory_signature_5`,`createDocumentary_signatory_signature_6`,`createDocumentary_signatory_signature_7`,`createDocumentary_signatory_signature_8`,`createDocumentary_signatory_signature_9`,`createDocumentary_signatory_signature_10`,`createDocumentary_signatory_signature_11`,`createDocumentary_signatory_signature_12`,`createDocumentary_signatory_signature_13`,`createDocumentary_signatory_signature_14`,`createDocumentary_signatory_signature_15`,`createDocumentary_signatory_signature_16`,`createDocumentary_signatory_signature_17`,`createDocumentary_signatory_signature_18`,`createDocumentary_signatory_signature_19`,`createDocumentary_signatory_signature_20`,`createDocumentary_signatory_comment_1`,`createDocumentary_signatory_comment_2`,`createDocumentary_signatory_comment_3`,`createDocumentary_signatory_comment_4`,`createDocumentary_signatory_comment_5`,`createDocumentary_signatory_comment_6`,`createDocumentary_signatory_comment_7`,`createDocumentary_signatory_comment_8`,`createDocumentary_signatory_comment_9`,`createDocumentary_signatory_comment_10`,`createDocumentary_signatory_comment_11`,`createDocumentary_signatory_comment_12`,`createDocumentary_signatory_comment_13`,`createDocumentary_signatory_comment_14`,`createDocumentary_signatory_comment_15`,`createDocumentary_signatory_comment_16`,`createDocumentary_signatory_comment_17`,`createDocumentary_signatory_comment_18`,`createDocumentary_signatory_comment_19`,`createDocumentary_signatory_comment_20`,`createDocumentary_attachmentfile3`,`createDocumentary_attachmentfile2`,`createDocumentary_attachmentfile1`,`createDocumentary_date`,`createDocumentary_summary`,`createDocumentary_category`,`createDocumentary_titleFile3`,`createDocumentary_titleFile2`,`createDocumentary_titleFile1`,`createDocumentary_signatory_role_1`,`createDocumentary_signatory_role_2`,`createDocumentary_signatory_role_3`,`createDocumentary_signatory_role_4`,`createDocumentary_signatory_role_5`,`createDocumentary_signatory_role_6`,`createDocumentary_signatory_role_7`,`createDocumentary_signatory_role_8`,`createDocumentary_signatory_role_9`,`createDocumentary_signatory_role_10`,`createDocumentary_signatory_role_11`,`createDocumentary_signatory_role_12`,`createDocumentary_signatory_role_13`,`createDocumentary_signatory_role_14`,`createDocumentary_signatory_role_15`,`createDocumentary_signatory_role_16`,`createDocumentary_signatory_role_17`,`createDocumentary_signatory_role_18`,`createDocumentary_signatory_role_19`,`createDocumentary_signatory_role_20`,`createDocumentary_attachmentfileTitle1`) VALUES 
 (32,'',NULL,NULL,'','','','','3','','','','','','','','','','','','','','','','','','','','uuuuuuuu','','','','','','','','','','','','','','','','','','','',-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,'','','','','','','','','','','','','','','','','','','','','','','','','','','','','','مترون','','','','','','','','','','','','','','','','','','','',NULL);
/*!40000 ALTER TABLE `hmis_createdocumentary` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`upload`
--

DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `upload_file_name` varchar(455) NOT NULL DEFAULT '',
  `upload_date` varchar(45) DEFAULT NULL,
  `upload_title` varchar(45) DEFAULT NULL,
  `upload_comment` varchar(45) DEFAULT NULL,
  `upload_time` varchar(45) DEFAULT NULL,
  `upload_loader` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `upload_logStatus` longtext CHARACTER SET utf8,
  `upload_status` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `upload_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`upload_file_name`)
) ENGINE=InnoDB AUTO_INCREMENT=529 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`upload`
--

/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (495,'p1164316422.png','13980209','png',NULL,'11:32:01',' ','',NULL,''),
 (496,'p1417677412.png','13980209','',NULL,'11:58:42',' ','',NULL,'png'),
 (497,'p3629535824.png','13980209','',NULL,'12:08:59',' ','',NULL,'png'),
 (498,'p5806473760.png','13980209','',NULL,'12:11:48',' ','',NULL,'png'),
 (499,'p6802248842.png','13980209','png',NULL,'12:29:01',' ','',NULL,'png'),
 (500,'p9185211304.png','13980209','',NULL,'12:37:53',' ','',NULL,'png'),
 (501,'p7991046891.png','13980209','',NULL,'12:42:00',' ','',NULL,'png'),
 (502,'p4953188238.jpg','13980209','',NULL,'14:59:01',' ','',NULL,'jpg'),
 (503,'p3875909136.jpg','13980209','',NULL,'15:06:22',' ','',NULL,'jpg'),
 (504,'p0938352939.jpg','13980209','',NULL,'15:12:52',' ','',NULL,'jpg'),
 (505,'p5579093666.jpg','13980209','',NULL,'15:13:51',' ','',NULL,'jpg'),
 (506,'p1952166467.jpg','13980209','',NULL,'15:18:53',' ','',NULL,'jpg'),
 (507,'p3040916371.jpg','13980209','',NULL,'15:20:36',' ','',NULL,'jpg');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (508,'p8765117807.jpg','13980209','',NULL,'15:29:12',' ','',NULL,'jpg'),
 (509,'p4547039607.jpg','13980209','',NULL,'15:32:28',' ','',NULL,'jpg'),
 (510,'p1791886992.jpg','13980209','',NULL,'15:35:35',' ','',NULL,'jpg'),
 (511,'p4118661774.jpg','13980209','',NULL,'15:37:59',' ','',NULL,'jpg'),
 (512,'p9707210855.jpg','13980209','',NULL,'15:41:37',' ','',NULL,'jpg'),
 (513,'p1520058445.jpg','13980209','',NULL,'15:42:05',' ','',NULL,'jpg'),
 (514,'p6240681293.jpg','13980209','',NULL,'15:44:57',' ','',NULL,'jpg'),
 (515,'p3817518952.jpg','13980209','',NULL,'15:47:35',' ','',NULL,'jpg'),
 (516,'p3630450466.jpg','13980209','',NULL,'15:49:16',' ','',NULL,'jpg'),
 (517,'p2608401828.jpg','13980210','',NULL,'07:58:28',' ','',NULL,'jpg'),
 (518,'p4128599200.jpg','13980210','',NULL,'08:00:21',' ','',NULL,'jpg'),
 (519,'p3620090412.jpg','13980210','',NULL,'08:05:59','محمد ثالثی','',NULL,'jpg'),
 (520,'p9482000873.jpg','13980210','',NULL,'08:09:21','محمد ثالثی','',NULL,'jpg');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (521,'p0692241933.jpg','13980210','',NULL,'08:19:55','محمد ثالثی','',NULL,'jpg'),
 (522,'p9073201171.jpg','13980210','',NULL,'08:25:05','محمد ثالثی','',NULL,'jpg'),
 (523,'p3391320594.jpg','13980210','',NULL,'08:29:01','محمد ثالثی','',NULL,'jpg'),
 (524,'p0288718603.jpg','13980210','',NULL,'08:37:20','محمد ثالثی','',NULL,'jpg'),
 (525,'p0384713481.jpg','13980210','',NULL,'08:37:43','محمد ثالثی','',NULL,'jpg'),
 (526,'p5361066550.jpg','13980210','',NULL,'08:53:09','محمد ثالثی','',NULL,'jpg'),
 (527,'p9974680959.jpg','13980210','',NULL,'08:56:20','محمد ثالثی','',NULL,'jpg'),
 (528,'p4252419159.jpg','13980210','',NULL,'15:29:07',' ','',NULL,'jpg');
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;