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
-- Table structure for table `db_hmis`.`upload`
--

DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `upload_file_name` varchar(455) NOT NULL DEFAULT '',
  `upload_date` varchar(45) DEFAULT NULL,
  `upload_title` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `upload_comment` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `upload_time` varchar(45) DEFAULT NULL,
  `upload_loader` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `upload_logStatus` longtext CHARACTER SET utf8mb4,
  `upload_status` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `upload_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`upload_file_name`)
) ENGINE=InnoDB AUTO_INCREMENT=673 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`upload`
--

/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (495,'p1164316422.png','13980209','',NULL,'11:32:01',' ','',NULL,''),
 (496,'p1417677412.png','13980209','',NULL,'11:58:42',' ','',NULL,'png'),
 (497,'p3629535824.png','13980209','',NULL,'12:08:59',' ','',NULL,'png'),
 (498,'p5806473760.png','13980209','',NULL,'12:11:48',' ','',NULL,'png'),
 (499,'p6802248842.png','13980209','',NULL,'12:29:01',' ','',NULL,'png'),
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
 (528,'p4252419159.jpg','13980210','',NULL,'15:29:07',' ','',NULL,'jpg'),
 (529,'p2561252611.jpg','13980214',NULL,NULL,'15:20:19','محمد ثالثی','',NULL,NULL),
 (530,'p3330411476.jpg','13980214',NULL,NULL,'15:31:22',' ','',NULL,NULL),
 (531,'p0104564946.jpg','13980214',NULL,NULL,'15:31:54',' ','',NULL,NULL);
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (532,'p9018961660.jpg','13980214',NULL,NULL,'15:32:30',' ','',NULL,NULL),
 (533,'p4626468868.jpg','13980214',NULL,NULL,'15:36:16',' ','',NULL,NULL),
 (534,'p7147606991.jpg','13980214',NULL,NULL,'15:41:03',' ','',NULL,NULL),
 (535,'p6099257934.jpg','13980214',NULL,NULL,'15:43:14',' ','',NULL,NULL),
 (536,'p3356609535.jpg','13980214',NULL,NULL,'15:45:15',' ','',NULL,NULL),
 (537,'p2269483108.jpg','13980214',NULL,NULL,'15:46:41',' ','',NULL,NULL),
 (538,'p5884770959.jpg','13980214',NULL,NULL,'15:50:35',' ','',NULL,NULL),
 (539,'p5958280766.jpg','13980214',NULL,NULL,'15:54:51',' ','',NULL,NULL),
 (540,'p6371446220.png','13980214',NULL,NULL,'15:57:52',' ','',NULL,NULL),
 (541,'p4861703953.jpg','13980214',NULL,NULL,'15:59:26',' ','',NULL,NULL),
 (542,'p5960070410.jpg','13980214',NULL,NULL,'16:00:41',' ','',NULL,NULL),
 (543,'p1871557690.jpg','13980215',NULL,NULL,'08:16:13','محمد ثالثی','',NULL,NULL);
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (544,'p5350811376.jpg','13980215',NULL,NULL,'08:21:38',' ','',NULL,NULL),
 (545,'p5392247025.png','13980215',NULL,NULL,'08:22:55',' ','',NULL,NULL),
 (546,'p0184623297.jpg','13980215',NULL,NULL,'08:26:05',' ','',NULL,NULL),
 (547,'p7633814889.jpg','13980215',NULL,NULL,'08:34:35',' ','',NULL,NULL),
 (548,'p9141797787.jpg','13980215',NULL,NULL,'08:42:25',' ','',NULL,NULL),
 (549,'p6680989540.jpg','13980215','',NULL,'08:45:51','محمد ثالثی','',NULL,NULL),
 (550,'p0557608547.jpg','13980215','',NULL,'08:46:17','محمد ثالثی','',NULL,NULL),
 (551,'p1847614259.jpg','13980215','',NULL,'08:47:14',' ','',NULL,NULL),
 (552,'p2949541980.jpg','13980215','',NULL,'08:47:51',' ','',NULL,NULL),
 (553,'p4134452054.jpg','13980215','hhhh',NULL,'08:53:29',' ','',NULL,NULL),
 (554,'p2631328332.jpg','13980215','undefined',NULL,'08:56:48',' ','',NULL,NULL),
 (555,'p7259274158.jpg','13980215','undefined',NULL,'08:59:27',' ','',NULL,NULL);
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (556,'p3922699313.jpg','13980215','uuuuuuuu',NULL,'09:02:21',' ','',NULL,NULL),
 (557,'p6460304752.jpg','13980215','ooooo',NULL,'09:17:24',' ','',NULL,NULL),
 (558,'p8622753913.jpg','13980215',NULL,NULL,'09:23:51',' ','',NULL,NULL),
 (559,'p3466997225.jpg','13980215',NULL,NULL,'09:24:10',' ','',NULL,NULL),
 (560,'p9749094312.jpg','13980215','bbbbbbbb',NULL,'09:27:14',' ','',NULL,NULL),
 (561,'p6513362446.jpg','13980215','ggg',NULL,'09:35:39',' ','',NULL,NULL),
 (562,'p4618466030.jpg','13980215','kjhgkjjhg',NULL,'09:38:25',' ','',NULL,NULL),
 (563,'p3895708408.png','13980215','jjj',NULL,'09:44:16',' ','',NULL,NULL),
 (564,'p9716012812.jpg','13980215','hjjhjh',NULL,'09:46:25',' ','',NULL,NULL),
 (565,'p7627218768.jpg','13980215',NULL,NULL,'10:00:40',' ','پاک شده توسط محمد ثالثی-1398/02/15 12:34:30%23A%23','پاک شده توسط محمد ثالثی',NULL),
 (566,'p4583316938.jpg','13980215','mnm',NULL,'10:26:04',' ','',NULL,NULL);
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (567,'p0591818943.jpg','13980215','hhhhhh',NULL,'10:26:26',' ','',NULL,NULL),
 (568,'p7241991797.jpg','13980215',NULL,NULL,'10:26:40',' ','',NULL,NULL),
 (569,'p9383991947.jpg','13980215','jjjjjj',NULL,'10:27:16',' ','',NULL,NULL),
 (570,'p3610124415.jpg','13980215','m,nm,n',NULL,'10:32:00',' ','',NULL,NULL),
 (571,'p6530643141.jpg','13980215','kkkkkk',NULL,'10:32:44',' ','',NULL,NULL),
 (572,'p6019964788.jpg','13980215','uuuuuuuuuu',NULL,'10:33:33',' ','',NULL,NULL),
 (573,'p0973040543.jpg','13980215','nnn',NULL,'10:33:48',' ','',NULL,NULL),
 (574,'p5769821443.jpg','13980215','nnnn',NULL,'10:33:59',' ','',NULL,NULL),
 (575,'p8144774071.jpg','13980215','mmm',NULL,'10:36:20',' ','',NULL,NULL),
 (576,'p5010286195.jpg','13980215','mnmn',NULL,'10:37:57',' ','',NULL,NULL),
 (577,'p9475377066.jpg','13980215','lllllll',NULL,'10:40:04',' ','',NULL,NULL),
 (578,'p8950068537.jpg','13980215','mmm',NULL,'10:41:03',' ','',NULL,NULL);
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (579,'p2094715294.jpg','13980215','nn',NULL,'10:41:24',' ','',NULL,NULL),
 (580,'p9051517331.jpg','13980215',NULL,NULL,'10:58:42','محمد ثالثی','',NULL,NULL),
 (581,'p9482778310.jpg','13980215',NULL,NULL,'11:00:15','محمد ثالثی','',NULL,NULL),
 (582,'p6658211614.jpg','13980215','nnn',NULL,'11:01:24','محمد ثالثی','',NULL,NULL),
 (583,'p3853851587.pdf','13980217','',NULL,'11:48:03','محمد ثالثی','',NULL,NULL),
 (584,'p1657125046.pdf','13980217','nnnn',NULL,'12:05:48','محمد ثالثی','',NULL,NULL),
 (585,'p6923743242.jpg','13980217','',NULL,'12:06:40','محمد ثالثی','',NULL,NULL),
 (586,'p4179626694.jpg','13980218','',NULL,'11:27:38','محمد ثالثی','',NULL,NULL),
 (587,'p6742207762.jpg','13980218','',NULL,'12:38:00','محمد ثالثی','',NULL,NULL),
 (588,'p4838756991.jpg','13980218',',mnbbnm,.',NULL,'15:20:35','محمد ثالثی','',NULL,NULL),
 (589,'p7639915512.jpg','13980221',NULL,NULL,'08:30:17','محمد ثالثی','',NULL,NULL);
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (590,'p5551308438.jpg','13980221','بخش',NULL,'08:37:43',' ','',NULL,'jpg'),
 (591,'p9269491300.jpg','13980221','nbnb',NULL,'08:39:10','محمد ثالثی','',NULL,'jpg'),
 (592,'p1032151389.jpg','13980221','bbv',NULL,'08:39:13','محمد ثالثی','',NULL,'jpg'),
 (593,'p3274711437.jpg','13980221','bnv',NULL,'08:39:30','محمد ثالثی','',NULL,'jpg'),
 (594,'p0398939742.jpg','13980221','',NULL,'08:55:08','محمد ثالثی','',NULL,'jpg'),
 (595,'p9471302536.jpg','13980221','mn',NULL,'09:22:53','razieh jafari','',NULL,'jpg'),
 (596,'p0722126154.png','13980223','',NULL,'11:52:08','محمد ثالثی','',NULL,'png'),
 (597,'p0415045887.png','13980224',NULL,NULL,'08:20:02','محمد ثالثی','',NULL,'png'),
 (598,'p8495024541.png','13980228',NULL,NULL,'08:56:44','محمد ثالثی','پاک شده توسط محمد ثالثی-1398/02/28 09:03:18%23A%23','پاک شده توسط محمد ثالثی','png'),
 (599,'p5350772750.png','13980228',NULL,NULL,'09:03:58','محمد ثالثی','',NULL,'png');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (600,'p3674028587.png','13980228',NULL,NULL,'09:04:11','محمد ثالثی','',NULL,'png'),
 (601,'p1098392725.png','13980228',NULL,NULL,'09:09:09','محمد ثالثی','',NULL,'png'),
 (602,'p2034459761.png','13980228',NULL,NULL,'09:12:01',' ','',NULL,'png'),
 (603,'p2717896579.png','13980228',NULL,NULL,'09:13:11',' ','',NULL,'png'),
 (604,'p5771076609.png','13980228',NULL,NULL,'09:17:42',' ','',NULL,'png'),
 (605,'p8049202589.png','13980228',NULL,NULL,'09:20:35',' ','',NULL,'png'),
 (606,'p1202506538.png','13980228',NULL,NULL,'09:26:26','محمد ثالثی','',NULL,'png'),
 (607,'p7942987102.png','13980228',NULL,NULL,'09:36:44','محمد ثالثی','',NULL,'png'),
 (608,'p5860490690.png','13980228',NULL,NULL,'09:40:27','محمد ثالثی','',NULL,'png'),
 (609,'p7681899883.png','13980228',NULL,NULL,'09:48:11','محمد ثالثی','',NULL,'png'),
 (610,'p8270634831.png','13980228',NULL,NULL,'15:53:00','کمال امیری','',NULL,'png');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (611,'p8171825399.png','13980229',NULL,NULL,'14:05:38','محمد ثالثی','',NULL,'png'),
 (612,'p7568397978.jpg','13980229',NULL,NULL,'14:08:45','محمد ثالثی','',NULL,'jpg'),
 (613,'p1280816519.png','13980229',NULL,NULL,'14:15:33','محمد ثالثی','',NULL,'png'),
 (614,'p7242129297.png','13980229',NULL,NULL,'14:16:28','محمد ثالثی','',NULL,'png'),
 (615,'p2453339111.png','13980229',NULL,NULL,'14:21:58','محمد ثالثی','',NULL,'png'),
 (616,'p0205765694.jpg','13980229',NULL,NULL,'14:25:59','محمد ثالثی','',NULL,'jpg'),
 (617,'p5590469013.png','13980229',NULL,NULL,'14:28:50','محمد ثالثی','',NULL,'png'),
 (618,'p0063792217.png','13980229',NULL,NULL,'14:30:00','محمد ثالثی','',NULL,'png'),
 (619,'p6262415172.png','13980229',NULL,NULL,'14:33:04','محمد ثالثی','',NULL,'png'),
 (620,'p0391501013.png','13980229',NULL,NULL,'14:34:21','محمد ثالثی','',NULL,'png');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (621,'p0229263937.png','13980229',NULL,NULL,'14:38:03',' ','',NULL,'png'),
 (622,'p5388922504.png','13980229',NULL,NULL,'14:45:05',' ','پاک شده توسط محمد ثالثی-1398/02/29 14:54:41%23A%23پاک شده توسط محمد ثالثی-1398/02/29 14:54:45%23A%23','پاک شده توسط محمد ثالثی','png'),
 (623,'p8812110104.png','13980229',NULL,NULL,'14:46:16',' ','',NULL,'png'),
 (624,'p0961919884.png','13980229',NULL,NULL,'14:46:30',' ','',NULL,'png'),
 (625,'p5314546064.png','13980229',NULL,NULL,'14:47:28',' ','',NULL,'png'),
 (626,'p7634963255.jpg','13980229',NULL,NULL,'14:47:33',' ','پاک شده توسط  -1398/02/29 14:58:32%23A%23','پاک شده توسط  ','jpg'),
 (627,'p4576194179.png','13980229',NULL,NULL,'15:43:55','محمد ثالثی','',NULL,'png'),
 (628,'p7266367905.png','13980229',NULL,NULL,'15:50:40',' ','',NULL,'png'),
 (629,'p2110070791.jpg','13980230',NULL,NULL,'09:44:31',' ','پاک شده توسط  -1398/03/21 11:14:04%23A%23','پاک شده توسط  ','jpg');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (630,'p3110280747.jpg','13980319',NULL,NULL,'11:33:40','user user','',NULL,'jpg'),
 (631,'p4482985808.jpg','13980319',NULL,NULL,'11:33:58','user user','',NULL,'jpg'),
 (632,'p0908983075.jpg','13980319','kkkk',NULL,'12:08:21',' ','',NULL,'jpg'),
 (633,'p0677176234.jpg','13980319','llllhhh',NULL,'12:12:22',' ','',NULL,'jpg'),
 (634,'p7368389254.jpg','13980319',NULL,NULL,'12:26:35',' ','',NULL,'jpg'),
 (635,'p0399713924.jpg','13980319','undefined',NULL,'12:29:19',' ','',NULL,'jpg'),
 (636,'p3529904569.jpg','13980319','undefined',NULL,'12:31:40',' ','',NULL,'jpg'),
 (637,'p6448040652.jpg','13980319','',NULL,'12:45:55',' ','',NULL,'jpg'),
 (638,'p4185629984.jpg','13980319','',NULL,'12:51:24',' ','',NULL,'jpg'),
 (639,'p9366229640.png','13980319','',NULL,'12:55:16',' ','',NULL,'png'),
 (640,'p8219923426.jpg','13980319','',NULL,'12:57:28',' ','',NULL,'jpg'),
 (641,'p3543500992.jpg','13980319','',NULL,'13:00:27',' ','',NULL,'jpg');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (642,'p4338123423.jpg','13980319','',NULL,'13:05:52',' ','',NULL,'jpg'),
 (643,'p8543639517.jpg','13980319','',NULL,'13:06:37',' ','',NULL,'jpg'),
 (644,'p3084980003.png','13980319','',NULL,'14:00:26',' ','',NULL,'png'),
 (645,'p5936235731.jpg','13980319','',NULL,'14:00:59',' ','',NULL,'jpg'),
 (646,'p2160410707.jpg','13980319','',NULL,'14:02:53',' ','',NULL,'jpg'),
 (647,'p1937941788.jpg','13980319','',NULL,'14:04:03',' ','',NULL,'jpg'),
 (648,'p1363664843.png','13980319','',NULL,'14:05:33',' ','',NULL,'png'),
 (649,'p3202003092.jpg','13980319','',NULL,'14:06:26',' ','',NULL,'jpg'),
 (650,'p8626719462.png','13980319','',NULL,'14:10:52',' ','',NULL,'png'),
 (651,'p3845702855.png','13980319','',NULL,'14:15:12',' ','',NULL,'png'),
 (652,'p1027881669.png','13980319','',NULL,'14:18:12',' ','',NULL,'png'),
 (653,'p8162822978.jpg','13980319','',NULL,'14:22:37',' ','',NULL,'jpg'),
 (654,'p7307527442.jpg','13980319','bnbnb',NULL,'14:28:30',' ','',NULL,'jpg');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (655,'p4972774993.png','13980319','klklklk',NULL,'14:29:59',' ','',NULL,'png'),
 (656,'p8046318208.jpg','13980319','ghghg',NULL,'14:40:09',' ','',NULL,'jpg'),
 (657,'p5906969475.jpg','13980319','nmn',NULL,'14:42:28',' ','',NULL,'jpg'),
 (658,'p9524973700.jpg','13980319','jkjlkjlk',NULL,'14:45:23',' ','',NULL,'jpg'),
 (659,'p3479786792.jpg','13980319',',.mnvbnm,.',NULL,'14:47:48',' ','',NULL,'jpg'),
 (660,'p9482899069.png','13980319','oikjhgfghj',NULL,'14:53:41',' ','',NULL,'png'),
 (661,'p3045942888.jpg','13980319','kjkjk',NULL,'14:58:34',' ','',NULL,'jpg'),
 (662,'p1056054409.jpg','13980319',',mnm,n',NULL,'14:59:52',' ','',NULL,'jpg'),
 (663,'p0874133287.jpg','13980319','lkjkj',NULL,'15:01:53',' ','',NULL,'jpg'),
 (664,'p2534048171.jpg','13980319',',mnmm',NULL,'15:03:24',' ','',NULL,'jpg'),
 (665,'p3890852101.jpg','13980319',',n,mnm,n',NULL,'15:13:12',' ','',NULL,'jpg'),
 (666,'p9070432511.jpg','13980319','klklk',NULL,'15:18:30',' ','',NULL,'jpg');
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`,`upload_logStatus`,`upload_status`,`upload_type`) VALUES 
 (667,'p3146732126.jpg','13980319',',nmn',NULL,'15:21:08',' ','',NULL,'jpg'),
 (668,'p0852717284.jpg','13980319',',m,m',NULL,'15:25:34',' ','',NULL,'jpg'),
 (669,'p7657060723.jpg','13980320','kjlkjk',NULL,'15:06:16',' ','',NULL,'jpg'),
 (670,'p6458198686.jpg','13980321','nmn',NULL,'10:17:25','dddd dddd','',NULL,'jpg'),
 (671,'p6415591848.jpg','13980321','',NULL,'11:13:18',' ','',NULL,'jpg'),
 (672,'p7074313598.jpg','13980321','',NULL,'11:14:12',' ','',NULL,'jpg');
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
