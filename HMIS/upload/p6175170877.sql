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
-- Table structure for table `db_hmis`.`access_group`
--

DROP TABLE IF EXISTS `access_group`;
CREATE TABLE `access_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_title` varchar(255) NOT NULL DEFAULT '0',
  `group_des` varchar(255) NOT NULL DEFAULT '0',
  `group_creator` int(10) unsigned NOT NULL DEFAULT '0',
  `group_c01` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c02` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c03` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c04` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c05` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c06` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c07` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c08` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c09` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c10` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c11` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c12` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c13` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c14` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c15` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c16` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c17` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c18` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c19` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c20` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c21` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c22` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c23` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c24` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c25` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c26` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c27` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c28` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c29` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c30` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c31` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c32` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c33` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c34` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c35` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c36` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c37` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c38` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c39` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c40` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c41` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c42` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c43` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c44` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c45` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c46` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c47` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c48` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c49` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c50` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c51` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c52` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c53` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c54` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c55` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c56` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c57` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c58` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c59` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c60` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c61` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c62` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c63` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c64` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c65` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c66` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c67` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c68` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c69` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c70` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c71` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c72` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c73` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c74` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c75` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c76` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c77` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c78` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c79` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c80` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c81` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c82` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c83` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c84` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c85` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c86` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c87` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c88` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c89` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c90` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c91` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c92` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c93` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c94` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c95` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c96` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c97` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c98` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c99` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c100` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c101` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c102` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c103` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c104` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c105` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c106` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c107` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c108` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c109` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c110` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c111` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c112` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c113` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c114` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c115` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c116` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c117` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c118` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c119` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c120` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c121` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c122` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c123` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c124` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c125` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c126` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c127` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c128` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c129` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c130` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c131` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c132` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c133` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c134` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c135` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c136` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c137` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c138` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c139` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c140` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c141` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c142` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c143` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c144` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c145` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c146` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c147` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c148` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c149` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c150` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c151` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c152` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c153` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c154` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c155` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c156` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c157` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c158` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c159` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c160` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c161` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c162` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c163` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c164` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c165` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c166` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c167` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c168` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c169` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c170` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c171` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c172` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c173` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c174` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c175` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c176` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c177` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c178` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c179` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c180` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c181` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c182` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c183` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c184` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c185` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c186` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c187` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c188` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c189` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c190` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c191` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c192` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c193` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c194` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c195` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c196` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c197` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c198` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c199` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c200` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c201` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c202` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c203` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c204` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c205` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c206` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c207` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c208` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c209` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c210` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c211` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c212` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c213` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c214` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c215` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c216` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c217` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c218` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c219` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c220` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c221` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c222` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c223` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c224` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c225` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c226` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c227` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c228` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c229` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c230` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c231` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c232` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c233` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c234` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c235` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c236` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c237` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c238` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c239` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c240` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c241` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c242` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c243` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c244` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c245` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c246` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c247` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c248` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c249` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c250` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c251` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c252` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c253` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c254` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c255` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c256` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c257` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c258` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c259` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c260` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c261` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c262` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c263` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c264` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c265` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c266` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c267` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c268` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c269` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c270` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c271` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c272` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c273` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c274` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c275` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c276` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c277` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c278` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c279` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c280` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c281` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c282` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c283` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c284` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c285` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c286` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c287` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c288` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c289` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c290` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c291` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c292` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c293` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c294` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c295` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c296` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c297` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c298` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c299` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c300` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c301` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c302` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c303` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c304` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c305` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c306` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c307` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c308` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c309` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c310` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c311` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c312` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c313` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c314` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c315` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c316` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c317` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c318` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c319` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c320` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c321` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c322` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c323` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c324` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c325` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c326` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c327` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c328` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c329` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c330` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c331` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c332` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c333` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c334` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c335` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c336` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c337` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c338` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c339` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c340` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c341` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c342` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c343` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c344` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c345` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c346` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c347` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c348` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c349` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c350` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c351` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c352` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c353` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c354` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c355` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c356` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c357` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c358` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c359` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c360` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c361` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c362` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c363` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c364` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c365` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c366` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c367` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c368` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c369` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c370` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c371` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c372` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c373` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c374` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c375` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c376` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c377` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c378` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c379` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c380` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c381` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c382` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c383` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c384` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c385` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c386` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c387` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c388` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c389` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c390` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c391` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c392` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c393` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c394` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c395` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c396` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c397` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c398` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c399` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c400` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c401` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c402` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c403` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c404` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c405` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c406` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c407` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c408` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c409` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c410` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c411` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c412` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c413` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c414` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c415` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c416` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c417` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c418` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c419` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c420` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c421` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c422` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c423` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c424` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c425` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c426` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c427` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c428` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c429` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c430` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c431` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c432` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c433` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c434` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c435` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c436` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c437` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c438` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c439` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c440` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c441` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c442` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c443` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c444` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c445` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c446` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c447` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c448` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c449` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c450` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c451` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c452` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c453` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c454` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c455` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c456` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c457` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c458` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c459` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c460` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c461` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c462` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c463` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c464` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c465` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c466` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c467` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c468` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c469` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c470` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c471` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c472` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c473` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c474` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c475` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c476` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c477` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c478` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c479` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c480` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c481` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c482` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c483` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c484` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c485` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c486` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c487` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c488` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c489` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c490` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c491` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c492` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c493` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c494` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c495` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c496` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c497` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c498` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c499` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `group_c500` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`access_group`
--

/*!40000 ALTER TABLE `access_group` DISABLE KEYS */;
INSERT INTO `access_group` (`id`,`group_title`,`group_des`,`group_creator`,`group_c01`,`group_c02`,`group_c03`,`group_c04`,`group_c05`,`group_c06`,`group_c07`,`group_c08`,`group_c09`,`group_c10`,`group_c11`,`group_c12`,`group_c13`,`group_c14`,`group_c15`,`group_c16`,`group_c17`,`group_c18`,`group_c19`,`group_c20`,`group_c21`,`group_c22`,`group_c23`,`group_c24`,`group_c25`,`group_c26`,`group_c27`,`group_c28`,`group_c29`,`group_c30`,`group_c31`,`group_c32`,`group_c33`,`group_c34`,`group_c35`,`group_c36`,`group_c37`,`group_c38`,`group_c39`,`group_c40`,`group_c41`,`group_c42`,`group_c43`,`group_c44`,`group_c45`,`group_c46`,`group_c47`,`group_c48`,`group_c49`,`group_c50`,`group_c51`,`group_c52`,`group_c53`,`group_c54`,`group_c55`,`group_c56`,`group_c57`,`group_c58`,`group_c59`,`group_c60`,`group_c61`,`group_c62`,`group_c63`,`group_c64`,`group_c65`,`group_c66`,`group_c67`,`group_c68`,`group_c69`,`group_c70`,`group_c71`,`group_c72`,`group_c73`,`group_c74`,`group_c75`,`group_c76`,`group_c77`,`group_c78`,`group_c79`,`group_c80`,`group_c81`,`group_c82`,`group_c83`,`group_c84`,`group_c85`,`group_c86`,`group_c87`,`group_c88`,`group_c89`,`group_c90`,`group_c91`,`group_c92`,`group_c93`,`group_c94`,`group_c95`,`group_c96`,`group_c97`,`group_c98`,`group_c99`,`group_c100`,`group_c101`,`group_c102`,`group_c103`,`group_c104`,`group_c105`,`group_c106`,`group_c107`,`group_c108`,`group_c109`,`group_c110`,`group_c111`,`group_c112`,`group_c113`,`group_c114`,`group_c115`,`group_c116`,`group_c117`,`group_c118`,`group_c119`,`group_c120`,`group_c121`,`group_c122`,`group_c123`,`group_c124`,`group_c125`,`group_c126`,`group_c127`,`group_c128`,`group_c129`,`group_c130`,`group_c131`,`group_c132`,`group_c133`,`group_c134`,`group_c135`,`group_c136`,`group_c137`,`group_c138`,`group_c139`,`group_c140`,`group_c141`,`group_c142`,`group_c143`,`group_c144`,`group_c145`,`group_c146`,`group_c147`,`group_c148`,`group_c149`,`group_c150`,`group_c151`,`group_c152`,`group_c153`,`group_c154`,`group_c155`,`group_c156`,`group_c157`,`group_c158`,`group_c159`,`group_c160`,`group_c161`,`group_c162`,`group_c163`,`group_c164`,`group_c165`,`group_c166`,`group_c167`,`group_c168`,`group_c169`,`group_c170`,`group_c171`,`group_c172`,`group_c173`,`group_c174`,`group_c175`,`group_c176`,`group_c177`,`group_c178`,`group_c179`,`group_c180`,`group_c181`,`group_c182`,`group_c183`,`group_c184`,`group_c185`,`group_c186`,`group_c187`,`group_c188`,`group_c189`,`group_c190`,`group_c191`,`group_c192`,`group_c193`,`group_c194`,`group_c195`,`group_c196`,`group_c197`,`group_c198`,`group_c199`,`group_c200`,`group_c201`,`group_c202`,`group_c203`,`group_c204`,`group_c205`,`group_c206`,`group_c207`,`group_c208`,`group_c209`,`group_c210`,`group_c211`,`group_c212`,`group_c213`,`group_c214`,`group_c215`,`group_c216`,`group_c217`,`group_c218`,`group_c219`,`group_c220`,`group_c221`,`group_c222`,`group_c223`,`group_c224`,`group_c225`,`group_c226`,`group_c227`,`group_c228`,`group_c229`,`group_c230`,`group_c231`,`group_c232`,`group_c233`,`group_c234`,`group_c235`,`group_c236`,`group_c237`,`group_c238`,`group_c239`,`group_c240`,`group_c241`,`group_c242`,`group_c243`,`group_c244`,`group_c245`,`group_c246`,`group_c247`,`group_c248`,`group_c249`,`group_c250`,`group_c251`,`group_c252`,`group_c253`,`group_c254`,`group_c255`,`group_c256`,`group_c257`,`group_c258`,`group_c259`,`group_c260`,`group_c261`,`group_c262`,`group_c263`,`group_c264`,`group_c265`,`group_c266`,`group_c267`,`group_c268`,`group_c269`,`group_c270`,`group_c271`,`group_c272`,`group_c273`,`group_c274`,`group_c275`,`group_c276`,`group_c277`,`group_c278`,`group_c279`,`group_c280`,`group_c281`,`group_c282`,`group_c283`,`group_c284`,`group_c285`,`group_c286`,`group_c287`,`group_c288`,`group_c289`,`group_c290`,`group_c291`,`group_c292`,`group_c293`,`group_c294`,`group_c295`,`group_c296`,`group_c297`,`group_c298`,`group_c299`,`group_c300`,`group_c301`,`group_c302`,`group_c303`,`group_c304`,`group_c305`,`group_c306`,`group_c307`,`group_c308`,`group_c309`,`group_c310`,`group_c311`,`group_c312`,`group_c313`,`group_c314`,`group_c315`,`group_c316`,`group_c317`,`group_c318`,`group_c319`,`group_c320`,`group_c321`,`group_c322`,`group_c323`,`group_c324`,`group_c325`,`group_c326`,`group_c327`,`group_c328`,`group_c329`,`group_c330`,`group_c331`,`group_c332`,`group_c333`,`group_c334`,`group_c335`,`group_c336`,`group_c337`,`group_c338`,`group_c339`,`group_c340`,`group_c341`,`group_c342`,`group_c343`,`group_c344`,`group_c345`,`group_c346`,`group_c347`,`group_c348`,`group_c349`,`group_c350`,`group_c351`,`group_c352`,`group_c353`,`group_c354`,`group_c355`,`group_c356`,`group_c357`,`group_c358`,`group_c359`,`group_c360`,`group_c361`,`group_c362`,`group_c363`,`group_c364`,`group_c365`,`group_c366`,`group_c367`,`group_c368`,`group_c369`,`group_c370`,`group_c371`,`group_c372`,`group_c373`,`group_c374`,`group_c375`,`group_c376`,`group_c377`,`group_c378`,`group_c379`,`group_c380`,`group_c381`,`group_c382`,`group_c383`,`group_c384`,`group_c385`,`group_c386`,`group_c387`,`group_c388`,`group_c389`,`group_c390`,`group_c391`,`group_c392`,`group_c393`,`group_c394`,`group_c395`,`group_c396`,`group_c397`,`group_c398`,`group_c399`,`group_c400`,`group_c401`,`group_c402`,`group_c403`,`group_c404`,`group_c405`,`group_c406`,`group_c407`,`group_c408`,`group_c409`,`group_c410`,`group_c411`,`group_c412`,`group_c413`,`group_c414`,`group_c415`,`group_c416`,`group_c417`,`group_c418`,`group_c419`,`group_c420`,`group_c421`,`group_c422`,`group_c423`,`group_c424`,`group_c425`,`group_c426`,`group_c427`,`group_c428`,`group_c429`,`group_c430`,`group_c431`,`group_c432`,`group_c433`,`group_c434`,`group_c435`,`group_c436`,`group_c437`,`group_c438`,`group_c439`,`group_c440`,`group_c441`,`group_c442`,`group_c443`,`group_c444`,`group_c445`,`group_c446`,`group_c447`,`group_c448`,`group_c449`,`group_c450`,`group_c451`,`group_c452`,`group_c453`,`group_c454`,`group_c455`,`group_c456`,`group_c457`,`group_c458`,`group_c459`,`group_c460`,`group_c461`,`group_c462`,`group_c463`,`group_c464`,`group_c465`,`group_c466`,`group_c467`,`group_c468`,`group_c469`,`group_c470`,`group_c471`,`group_c472`,`group_c473`,`group_c474`,`group_c475`,`group_c476`,`group_c477`,`group_c478`,`group_c479`,`group_c480`,`group_c481`,`group_c482`,`group_c483`,`group_c484`,`group_c485`,`group_c486`,`group_c487`,`group_c488`,`group_c489`,`group_c490`,`group_c491`,`group_c492`,`group_c493`,`group_c494`,`group_c495`,`group_c496`,`group_c497`,`group_c498`,`group_c499`,`group_c500`) VALUES 
 (1,'برنامه نویس','$',1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO `access_group` (`id`,`group_title`,`group_des`,`group_creator`,`group_c01`,`group_c02`,`group_c03`,`group_c04`,`group_c05`,`group_c06`,`group_c07`,`group_c08`,`group_c09`,`group_c10`,`group_c11`,`group_c12`,`group_c13`,`group_c14`,`group_c15`,`group_c16`,`group_c17`,`group_c18`,`group_c19`,`group_c20`,`group_c21`,`group_c22`,`group_c23`,`group_c24`,`group_c25`,`group_c26`,`group_c27`,`group_c28`,`group_c29`,`group_c30`,`group_c31`,`group_c32`,`group_c33`,`group_c34`,`group_c35`,`group_c36`,`group_c37`,`group_c38`,`group_c39`,`group_c40`,`group_c41`,`group_c42`,`group_c43`,`group_c44`,`group_c45`,`group_c46`,`group_c47`,`group_c48`,`group_c49`,`group_c50`,`group_c51`,`group_c52`,`group_c53`,`group_c54`,`group_c55`,`group_c56`,`group_c57`,`group_c58`,`group_c59`,`group_c60`,`group_c61`,`group_c62`,`group_c63`,`group_c64`,`group_c65`,`group_c66`,`group_c67`,`group_c68`,`group_c69`,`group_c70`,`group_c71`,`group_c72`,`group_c73`,`group_c74`,`group_c75`,`group_c76`,`group_c77`,`group_c78`,`group_c79`,`group_c80`,`group_c81`,`group_c82`,`group_c83`,`group_c84`,`group_c85`,`group_c86`,`group_c87`,`group_c88`,`group_c89`,`group_c90`,`group_c91`,`group_c92`,`group_c93`,`group_c94`,`group_c95`,`group_c96`,`group_c97`,`group_c98`,`group_c99`,`group_c100`,`group_c101`,`group_c102`,`group_c103`,`group_c104`,`group_c105`,`group_c106`,`group_c107`,`group_c108`,`group_c109`,`group_c110`,`group_c111`,`group_c112`,`group_c113`,`group_c114`,`group_c115`,`group_c116`,`group_c117`,`group_c118`,`group_c119`,`group_c120`,`group_c121`,`group_c122`,`group_c123`,`group_c124`,`group_c125`,`group_c126`,`group_c127`,`group_c128`,`group_c129`,`group_c130`,`group_c131`,`group_c132`,`group_c133`,`group_c134`,`group_c135`,`group_c136`,`group_c137`,`group_c138`,`group_c139`,`group_c140`,`group_c141`,`group_c142`,`group_c143`,`group_c144`,`group_c145`,`group_c146`,`group_c147`,`group_c148`,`group_c149`,`group_c150`,`group_c151`,`group_c152`,`group_c153`,`group_c154`,`group_c155`,`group_c156`,`group_c157`,`group_c158`,`group_c159`,`group_c160`,`group_c161`,`group_c162`,`group_c163`,`group_c164`,`group_c165`,`group_c166`,`group_c167`,`group_c168`,`group_c169`,`group_c170`,`group_c171`,`group_c172`,`group_c173`,`group_c174`,`group_c175`,`group_c176`,`group_c177`,`group_c178`,`group_c179`,`group_c180`,`group_c181`,`group_c182`,`group_c183`,`group_c184`,`group_c185`,`group_c186`,`group_c187`,`group_c188`,`group_c189`,`group_c190`,`group_c191`,`group_c192`,`group_c193`,`group_c194`,`group_c195`,`group_c196`,`group_c197`,`group_c198`,`group_c199`,`group_c200`,`group_c201`,`group_c202`,`group_c203`,`group_c204`,`group_c205`,`group_c206`,`group_c207`,`group_c208`,`group_c209`,`group_c210`,`group_c211`,`group_c212`,`group_c213`,`group_c214`,`group_c215`,`group_c216`,`group_c217`,`group_c218`,`group_c219`,`group_c220`,`group_c221`,`group_c222`,`group_c223`,`group_c224`,`group_c225`,`group_c226`,`group_c227`,`group_c228`,`group_c229`,`group_c230`,`group_c231`,`group_c232`,`group_c233`,`group_c234`,`group_c235`,`group_c236`,`group_c237`,`group_c238`,`group_c239`,`group_c240`,`group_c241`,`group_c242`,`group_c243`,`group_c244`,`group_c245`,`group_c246`,`group_c247`,`group_c248`,`group_c249`,`group_c250`,`group_c251`,`group_c252`,`group_c253`,`group_c254`,`group_c255`,`group_c256`,`group_c257`,`group_c258`,`group_c259`,`group_c260`,`group_c261`,`group_c262`,`group_c263`,`group_c264`,`group_c265`,`group_c266`,`group_c267`,`group_c268`,`group_c269`,`group_c270`,`group_c271`,`group_c272`,`group_c273`,`group_c274`,`group_c275`,`group_c276`,`group_c277`,`group_c278`,`group_c279`,`group_c280`,`group_c281`,`group_c282`,`group_c283`,`group_c284`,`group_c285`,`group_c286`,`group_c287`,`group_c288`,`group_c289`,`group_c290`,`group_c291`,`group_c292`,`group_c293`,`group_c294`,`group_c295`,`group_c296`,`group_c297`,`group_c298`,`group_c299`,`group_c300`,`group_c301`,`group_c302`,`group_c303`,`group_c304`,`group_c305`,`group_c306`,`group_c307`,`group_c308`,`group_c309`,`group_c310`,`group_c311`,`group_c312`,`group_c313`,`group_c314`,`group_c315`,`group_c316`,`group_c317`,`group_c318`,`group_c319`,`group_c320`,`group_c321`,`group_c322`,`group_c323`,`group_c324`,`group_c325`,`group_c326`,`group_c327`,`group_c328`,`group_c329`,`group_c330`,`group_c331`,`group_c332`,`group_c333`,`group_c334`,`group_c335`,`group_c336`,`group_c337`,`group_c338`,`group_c339`,`group_c340`,`group_c341`,`group_c342`,`group_c343`,`group_c344`,`group_c345`,`group_c346`,`group_c347`,`group_c348`,`group_c349`,`group_c350`,`group_c351`,`group_c352`,`group_c353`,`group_c354`,`group_c355`,`group_c356`,`group_c357`,`group_c358`,`group_c359`,`group_c360`,`group_c361`,`group_c362`,`group_c363`,`group_c364`,`group_c365`,`group_c366`,`group_c367`,`group_c368`,`group_c369`,`group_c370`,`group_c371`,`group_c372`,`group_c373`,`group_c374`,`group_c375`,`group_c376`,`group_c377`,`group_c378`,`group_c379`,`group_c380`,`group_c381`,`group_c382`,`group_c383`,`group_c384`,`group_c385`,`group_c386`,`group_c387`,`group_c388`,`group_c389`,`group_c390`,`group_c391`,`group_c392`,`group_c393`,`group_c394`,`group_c395`,`group_c396`,`group_c397`,`group_c398`,`group_c399`,`group_c400`,`group_c401`,`group_c402`,`group_c403`,`group_c404`,`group_c405`,`group_c406`,`group_c407`,`group_c408`,`group_c409`,`group_c410`,`group_c411`,`group_c412`,`group_c413`,`group_c414`,`group_c415`,`group_c416`,`group_c417`,`group_c418`,`group_c419`,`group_c420`,`group_c421`,`group_c422`,`group_c423`,`group_c424`,`group_c425`,`group_c426`,`group_c427`,`group_c428`,`group_c429`,`group_c430`,`group_c431`,`group_c432`,`group_c433`,`group_c434`,`group_c435`,`group_c436`,`group_c437`,`group_c438`,`group_c439`,`group_c440`,`group_c441`,`group_c442`,`group_c443`,`group_c444`,`group_c445`,`group_c446`,`group_c447`,`group_c448`,`group_c449`,`group_c450`,`group_c451`,`group_c452`,`group_c453`,`group_c454`,`group_c455`,`group_c456`,`group_c457`,`group_c458`,`group_c459`,`group_c460`,`group_c461`,`group_c462`,`group_c463`,`group_c464`,`group_c465`,`group_c466`,`group_c467`,`group_c468`,`group_c469`,`group_c470`,`group_c471`,`group_c472`,`group_c473`,`group_c474`,`group_c475`,`group_c476`,`group_c477`,`group_c478`,`group_c479`,`group_c480`,`group_c481`,`group_c482`,`group_c483`,`group_c484`,`group_c485`,`group_c486`,`group_c487`,`group_c488`,`group_c489`,`group_c490`,`group_c491`,`group_c492`,`group_c493`,`group_c494`,`group_c495`,`group_c496`,`group_c497`,`group_c498`,`group_c499`,`group_c500`) VALUES 
 (2,'کاربر پیشرفته','$',1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
INSERT INTO `access_group` (`id`,`group_title`,`group_des`,`group_creator`,`group_c01`,`group_c02`,`group_c03`,`group_c04`,`group_c05`,`group_c06`,`group_c07`,`group_c08`,`group_c09`,`group_c10`,`group_c11`,`group_c12`,`group_c13`,`group_c14`,`group_c15`,`group_c16`,`group_c17`,`group_c18`,`group_c19`,`group_c20`,`group_c21`,`group_c22`,`group_c23`,`group_c24`,`group_c25`,`group_c26`,`group_c27`,`group_c28`,`group_c29`,`group_c30`,`group_c31`,`group_c32`,`group_c33`,`group_c34`,`group_c35`,`group_c36`,`group_c37`,`group_c38`,`group_c39`,`group_c40`,`group_c41`,`group_c42`,`group_c43`,`group_c44`,`group_c45`,`group_c46`,`group_c47`,`group_c48`,`group_c49`,`group_c50`,`group_c51`,`group_c52`,`group_c53`,`group_c54`,`group_c55`,`group_c56`,`group_c57`,`group_c58`,`group_c59`,`group_c60`,`group_c61`,`group_c62`,`group_c63`,`group_c64`,`group_c65`,`group_c66`,`group_c67`,`group_c68`,`group_c69`,`group_c70`,`group_c71`,`group_c72`,`group_c73`,`group_c74`,`group_c75`,`group_c76`,`group_c77`,`group_c78`,`group_c79`,`group_c80`,`group_c81`,`group_c82`,`group_c83`,`group_c84`,`group_c85`,`group_c86`,`group_c87`,`group_c88`,`group_c89`,`group_c90`,`group_c91`,`group_c92`,`group_c93`,`group_c94`,`group_c95`,`group_c96`,`group_c97`,`group_c98`,`group_c99`,`group_c100`,`group_c101`,`group_c102`,`group_c103`,`group_c104`,`group_c105`,`group_c106`,`group_c107`,`group_c108`,`group_c109`,`group_c110`,`group_c111`,`group_c112`,`group_c113`,`group_c114`,`group_c115`,`group_c116`,`group_c117`,`group_c118`,`group_c119`,`group_c120`,`group_c121`,`group_c122`,`group_c123`,`group_c124`,`group_c125`,`group_c126`,`group_c127`,`group_c128`,`group_c129`,`group_c130`,`group_c131`,`group_c132`,`group_c133`,`group_c134`,`group_c135`,`group_c136`,`group_c137`,`group_c138`,`group_c139`,`group_c140`,`group_c141`,`group_c142`,`group_c143`,`group_c144`,`group_c145`,`group_c146`,`group_c147`,`group_c148`,`group_c149`,`group_c150`,`group_c151`,`group_c152`,`group_c153`,`group_c154`,`group_c155`,`group_c156`,`group_c157`,`group_c158`,`group_c159`,`group_c160`,`group_c161`,`group_c162`,`group_c163`,`group_c164`,`group_c165`,`group_c166`,`group_c167`,`group_c168`,`group_c169`,`group_c170`,`group_c171`,`group_c172`,`group_c173`,`group_c174`,`group_c175`,`group_c176`,`group_c177`,`group_c178`,`group_c179`,`group_c180`,`group_c181`,`group_c182`,`group_c183`,`group_c184`,`group_c185`,`group_c186`,`group_c187`,`group_c188`,`group_c189`,`group_c190`,`group_c191`,`group_c192`,`group_c193`,`group_c194`,`group_c195`,`group_c196`,`group_c197`,`group_c198`,`group_c199`,`group_c200`,`group_c201`,`group_c202`,`group_c203`,`group_c204`,`group_c205`,`group_c206`,`group_c207`,`group_c208`,`group_c209`,`group_c210`,`group_c211`,`group_c212`,`group_c213`,`group_c214`,`group_c215`,`group_c216`,`group_c217`,`group_c218`,`group_c219`,`group_c220`,`group_c221`,`group_c222`,`group_c223`,`group_c224`,`group_c225`,`group_c226`,`group_c227`,`group_c228`,`group_c229`,`group_c230`,`group_c231`,`group_c232`,`group_c233`,`group_c234`,`group_c235`,`group_c236`,`group_c237`,`group_c238`,`group_c239`,`group_c240`,`group_c241`,`group_c242`,`group_c243`,`group_c244`,`group_c245`,`group_c246`,`group_c247`,`group_c248`,`group_c249`,`group_c250`,`group_c251`,`group_c252`,`group_c253`,`group_c254`,`group_c255`,`group_c256`,`group_c257`,`group_c258`,`group_c259`,`group_c260`,`group_c261`,`group_c262`,`group_c263`,`group_c264`,`group_c265`,`group_c266`,`group_c267`,`group_c268`,`group_c269`,`group_c270`,`group_c271`,`group_c272`,`group_c273`,`group_c274`,`group_c275`,`group_c276`,`group_c277`,`group_c278`,`group_c279`,`group_c280`,`group_c281`,`group_c282`,`group_c283`,`group_c284`,`group_c285`,`group_c286`,`group_c287`,`group_c288`,`group_c289`,`group_c290`,`group_c291`,`group_c292`,`group_c293`,`group_c294`,`group_c295`,`group_c296`,`group_c297`,`group_c298`,`group_c299`,`group_c300`,`group_c301`,`group_c302`,`group_c303`,`group_c304`,`group_c305`,`group_c306`,`group_c307`,`group_c308`,`group_c309`,`group_c310`,`group_c311`,`group_c312`,`group_c313`,`group_c314`,`group_c315`,`group_c316`,`group_c317`,`group_c318`,`group_c319`,`group_c320`,`group_c321`,`group_c322`,`group_c323`,`group_c324`,`group_c325`,`group_c326`,`group_c327`,`group_c328`,`group_c329`,`group_c330`,`group_c331`,`group_c332`,`group_c333`,`group_c334`,`group_c335`,`group_c336`,`group_c337`,`group_c338`,`group_c339`,`group_c340`,`group_c341`,`group_c342`,`group_c343`,`group_c344`,`group_c345`,`group_c346`,`group_c347`,`group_c348`,`group_c349`,`group_c350`,`group_c351`,`group_c352`,`group_c353`,`group_c354`,`group_c355`,`group_c356`,`group_c357`,`group_c358`,`group_c359`,`group_c360`,`group_c361`,`group_c362`,`group_c363`,`group_c364`,`group_c365`,`group_c366`,`group_c367`,`group_c368`,`group_c369`,`group_c370`,`group_c371`,`group_c372`,`group_c373`,`group_c374`,`group_c375`,`group_c376`,`group_c377`,`group_c378`,`group_c379`,`group_c380`,`group_c381`,`group_c382`,`group_c383`,`group_c384`,`group_c385`,`group_c386`,`group_c387`,`group_c388`,`group_c389`,`group_c390`,`group_c391`,`group_c392`,`group_c393`,`group_c394`,`group_c395`,`group_c396`,`group_c397`,`group_c398`,`group_c399`,`group_c400`,`group_c401`,`group_c402`,`group_c403`,`group_c404`,`group_c405`,`group_c406`,`group_c407`,`group_c408`,`group_c409`,`group_c410`,`group_c411`,`group_c412`,`group_c413`,`group_c414`,`group_c415`,`group_c416`,`group_c417`,`group_c418`,`group_c419`,`group_c420`,`group_c421`,`group_c422`,`group_c423`,`group_c424`,`group_c425`,`group_c426`,`group_c427`,`group_c428`,`group_c429`,`group_c430`,`group_c431`,`group_c432`,`group_c433`,`group_c434`,`group_c435`,`group_c436`,`group_c437`,`group_c438`,`group_c439`,`group_c440`,`group_c441`,`group_c442`,`group_c443`,`group_c444`,`group_c445`,`group_c446`,`group_c447`,`group_c448`,`group_c449`,`group_c450`,`group_c451`,`group_c452`,`group_c453`,`group_c454`,`group_c455`,`group_c456`,`group_c457`,`group_c458`,`group_c459`,`group_c460`,`group_c461`,`group_c462`,`group_c463`,`group_c464`,`group_c465`,`group_c466`,`group_c467`,`group_c468`,`group_c469`,`group_c470`,`group_c471`,`group_c472`,`group_c473`,`group_c474`,`group_c475`,`group_c476`,`group_c477`,`group_c478`,`group_c479`,`group_c480`,`group_c481`,`group_c482`,`group_c483`,`group_c484`,`group_c485`,`group_c486`,`group_c487`,`group_c488`,`group_c489`,`group_c490`,`group_c491`,`group_c492`,`group_c493`,`group_c494`,`group_c495`,`group_c496`,`group_c497`,`group_c498`,`group_c499`,`group_c500`) VALUES 
 (14,'سپانو','jhghcvjhg',1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
INSERT INTO `access_group` (`id`,`group_title`,`group_des`,`group_creator`,`group_c01`,`group_c02`,`group_c03`,`group_c04`,`group_c05`,`group_c06`,`group_c07`,`group_c08`,`group_c09`,`group_c10`,`group_c11`,`group_c12`,`group_c13`,`group_c14`,`group_c15`,`group_c16`,`group_c17`,`group_c18`,`group_c19`,`group_c20`,`group_c21`,`group_c22`,`group_c23`,`group_c24`,`group_c25`,`group_c26`,`group_c27`,`group_c28`,`group_c29`,`group_c30`,`group_c31`,`group_c32`,`group_c33`,`group_c34`,`group_c35`,`group_c36`,`group_c37`,`group_c38`,`group_c39`,`group_c40`,`group_c41`,`group_c42`,`group_c43`,`group_c44`,`group_c45`,`group_c46`,`group_c47`,`group_c48`,`group_c49`,`group_c50`,`group_c51`,`group_c52`,`group_c53`,`group_c54`,`group_c55`,`group_c56`,`group_c57`,`group_c58`,`group_c59`,`group_c60`,`group_c61`,`group_c62`,`group_c63`,`group_c64`,`group_c65`,`group_c66`,`group_c67`,`group_c68`,`group_c69`,`group_c70`,`group_c71`,`group_c72`,`group_c73`,`group_c74`,`group_c75`,`group_c76`,`group_c77`,`group_c78`,`group_c79`,`group_c80`,`group_c81`,`group_c82`,`group_c83`,`group_c84`,`group_c85`,`group_c86`,`group_c87`,`group_c88`,`group_c89`,`group_c90`,`group_c91`,`group_c92`,`group_c93`,`group_c94`,`group_c95`,`group_c96`,`group_c97`,`group_c98`,`group_c99`,`group_c100`,`group_c101`,`group_c102`,`group_c103`,`group_c104`,`group_c105`,`group_c106`,`group_c107`,`group_c108`,`group_c109`,`group_c110`,`group_c111`,`group_c112`,`group_c113`,`group_c114`,`group_c115`,`group_c116`,`group_c117`,`group_c118`,`group_c119`,`group_c120`,`group_c121`,`group_c122`,`group_c123`,`group_c124`,`group_c125`,`group_c126`,`group_c127`,`group_c128`,`group_c129`,`group_c130`,`group_c131`,`group_c132`,`group_c133`,`group_c134`,`group_c135`,`group_c136`,`group_c137`,`group_c138`,`group_c139`,`group_c140`,`group_c141`,`group_c142`,`group_c143`,`group_c144`,`group_c145`,`group_c146`,`group_c147`,`group_c148`,`group_c149`,`group_c150`,`group_c151`,`group_c152`,`group_c153`,`group_c154`,`group_c155`,`group_c156`,`group_c157`,`group_c158`,`group_c159`,`group_c160`,`group_c161`,`group_c162`,`group_c163`,`group_c164`,`group_c165`,`group_c166`,`group_c167`,`group_c168`,`group_c169`,`group_c170`,`group_c171`,`group_c172`,`group_c173`,`group_c174`,`group_c175`,`group_c176`,`group_c177`,`group_c178`,`group_c179`,`group_c180`,`group_c181`,`group_c182`,`group_c183`,`group_c184`,`group_c185`,`group_c186`,`group_c187`,`group_c188`,`group_c189`,`group_c190`,`group_c191`,`group_c192`,`group_c193`,`group_c194`,`group_c195`,`group_c196`,`group_c197`,`group_c198`,`group_c199`,`group_c200`,`group_c201`,`group_c202`,`group_c203`,`group_c204`,`group_c205`,`group_c206`,`group_c207`,`group_c208`,`group_c209`,`group_c210`,`group_c211`,`group_c212`,`group_c213`,`group_c214`,`group_c215`,`group_c216`,`group_c217`,`group_c218`,`group_c219`,`group_c220`,`group_c221`,`group_c222`,`group_c223`,`group_c224`,`group_c225`,`group_c226`,`group_c227`,`group_c228`,`group_c229`,`group_c230`,`group_c231`,`group_c232`,`group_c233`,`group_c234`,`group_c235`,`group_c236`,`group_c237`,`group_c238`,`group_c239`,`group_c240`,`group_c241`,`group_c242`,`group_c243`,`group_c244`,`group_c245`,`group_c246`,`group_c247`,`group_c248`,`group_c249`,`group_c250`,`group_c251`,`group_c252`,`group_c253`,`group_c254`,`group_c255`,`group_c256`,`group_c257`,`group_c258`,`group_c259`,`group_c260`,`group_c261`,`group_c262`,`group_c263`,`group_c264`,`group_c265`,`group_c266`,`group_c267`,`group_c268`,`group_c269`,`group_c270`,`group_c271`,`group_c272`,`group_c273`,`group_c274`,`group_c275`,`group_c276`,`group_c277`,`group_c278`,`group_c279`,`group_c280`,`group_c281`,`group_c282`,`group_c283`,`group_c284`,`group_c285`,`group_c286`,`group_c287`,`group_c288`,`group_c289`,`group_c290`,`group_c291`,`group_c292`,`group_c293`,`group_c294`,`group_c295`,`group_c296`,`group_c297`,`group_c298`,`group_c299`,`group_c300`,`group_c301`,`group_c302`,`group_c303`,`group_c304`,`group_c305`,`group_c306`,`group_c307`,`group_c308`,`group_c309`,`group_c310`,`group_c311`,`group_c312`,`group_c313`,`group_c314`,`group_c315`,`group_c316`,`group_c317`,`group_c318`,`group_c319`,`group_c320`,`group_c321`,`group_c322`,`group_c323`,`group_c324`,`group_c325`,`group_c326`,`group_c327`,`group_c328`,`group_c329`,`group_c330`,`group_c331`,`group_c332`,`group_c333`,`group_c334`,`group_c335`,`group_c336`,`group_c337`,`group_c338`,`group_c339`,`group_c340`,`group_c341`,`group_c342`,`group_c343`,`group_c344`,`group_c345`,`group_c346`,`group_c347`,`group_c348`,`group_c349`,`group_c350`,`group_c351`,`group_c352`,`group_c353`,`group_c354`,`group_c355`,`group_c356`,`group_c357`,`group_c358`,`group_c359`,`group_c360`,`group_c361`,`group_c362`,`group_c363`,`group_c364`,`group_c365`,`group_c366`,`group_c367`,`group_c368`,`group_c369`,`group_c370`,`group_c371`,`group_c372`,`group_c373`,`group_c374`,`group_c375`,`group_c376`,`group_c377`,`group_c378`,`group_c379`,`group_c380`,`group_c381`,`group_c382`,`group_c383`,`group_c384`,`group_c385`,`group_c386`,`group_c387`,`group_c388`,`group_c389`,`group_c390`,`group_c391`,`group_c392`,`group_c393`,`group_c394`,`group_c395`,`group_c396`,`group_c397`,`group_c398`,`group_c399`,`group_c400`,`group_c401`,`group_c402`,`group_c403`,`group_c404`,`group_c405`,`group_c406`,`group_c407`,`group_c408`,`group_c409`,`group_c410`,`group_c411`,`group_c412`,`group_c413`,`group_c414`,`group_c415`,`group_c416`,`group_c417`,`group_c418`,`group_c419`,`group_c420`,`group_c421`,`group_c422`,`group_c423`,`group_c424`,`group_c425`,`group_c426`,`group_c427`,`group_c428`,`group_c429`,`group_c430`,`group_c431`,`group_c432`,`group_c433`,`group_c434`,`group_c435`,`group_c436`,`group_c437`,`group_c438`,`group_c439`,`group_c440`,`group_c441`,`group_c442`,`group_c443`,`group_c444`,`group_c445`,`group_c446`,`group_c447`,`group_c448`,`group_c449`,`group_c450`,`group_c451`,`group_c452`,`group_c453`,`group_c454`,`group_c455`,`group_c456`,`group_c457`,`group_c458`,`group_c459`,`group_c460`,`group_c461`,`group_c462`,`group_c463`,`group_c464`,`group_c465`,`group_c466`,`group_c467`,`group_c468`,`group_c469`,`group_c470`,`group_c471`,`group_c472`,`group_c473`,`group_c474`,`group_c475`,`group_c476`,`group_c477`,`group_c478`,`group_c479`,`group_c480`,`group_c481`,`group_c482`,`group_c483`,`group_c484`,`group_c485`,`group_c486`,`group_c487`,`group_c488`,`group_c489`,`group_c490`,`group_c491`,`group_c492`,`group_c493`,`group_c494`,`group_c495`,`group_c496`,`group_c497`,`group_c498`,`group_c499`,`group_c500`) VALUES 
 (15,'مسئول سایت','',2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `access_group` ENABLE KEYS */;


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
  `user_attachAxPersonal` varchar(45) DEFAULT NULL,
  `user_attachAxPersonnelCard` varchar(45) DEFAULT NULL,
  `user_attachAxSignature` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`access_user`
--

/*!40000 ALTER TABLE `access_user` DISABLE KEYS */;
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachAxPersonal`,`user_attachAxPersonnelCard`,`user_attachAxSignature`) VALUES 
 (0,'syetem','syetem','syetem','',0,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'','','',''),
 (1,'b','محمد','ثالثی','b',1,13910822,'','','11','22',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (3,'a','razieh','jafari','a',0,13930202,'1','morteza','1270428020','1270428020',0,13681013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'','','',''),
 (4,'ar63yann','mohamad','aryan','aryan_cctv@hotmail.com',0,13930304,'نام بهترین دوست شما چیست؟','Atena','','',0,13631118,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachAxPersonal`,`user_attachAxPersonnelCard`,`user_attachAxSignature`) VALUES 
 (5,'19931372','کمال','امیری','kamal_amiri1993@yahoo.com',1,13930416,'نام بهترین دوست شما چیست؟','علی','','',0,19930711,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (6,'8215101','amirmohamad','salimi','amirmohamad.salimi@yahoo.com',1,13930631,'نام بهترین دوست شما چیست؟','siavash','','',0,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (12,'mm123456','هادی','کاظمی','hgfhjkl@gmail.com',0,NULL,NULL,NULL,NULL,NULL,NULL,13971221,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'m,nbvvbnm',NULL,'23131321','nbvn','اقای','12121212121','1321321312321','bvhgjlkjkj','nbvbv','','','','','','','');
INSERT INTO `access_user` (`id`,`user_pass`,`user_name`,`user_family`,`user_email`,`user_is_active`,`user_createDate`,`user_question`,`user_answer`,`user_no1`,`user_no2`,`user_parent`,`user_birthdate`,`user_weblog`,`user_char1`,`user_char2`,`user_char3`,`user_int1`,`user_int2`,`user_int3`,`user_password_hint`,`user_mobile`,`user_AccountInformation`,`user_address`,`user_jensiat`,`user_codeMeli`,`user_shomareShenasname`,`user_grade`,`user_passwordReminder`,`user_file_personal`,`user_file_Signature`,`user_upload_file`,`user_attachFile`,`user_attachAxPersonal`,`user_attachAxPersonnelCard`,`user_attachAxSignature`) VALUES 
 (13,'ss123456','nm,n',',n,mn','shiran.shohreh@gmail.com',0,NULL,NULL,NULL,NULL,NULL,NULL,13971223,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','',NULL,NULL,NULL,'','','',''),
 (14,'','nbmnb','','',0,NULL,NULL,NULL,NULL,NULL,NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','اقای','','','','',NULL,NULL,NULL,'p1675185331.png#A#','','','');
/*!40000 ALTER TABLE `access_user` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`access_user_group`
--

DROP TABLE IF EXISTS `access_user_group`;
CREATE TABLE `access_user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `group_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`access_user_group`
--

/*!40000 ALTER TABLE `access_user_group` DISABLE KEYS */;
INSERT INTO `access_user_group` (`id`,`user_id`,`group_id`) VALUES 
 (57,1,1),
 (143,2,1);
/*!40000 ALTER TABLE `access_user_group` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`account_cust`
--

DROP TABLE IF EXISTS `account_cust`;
CREATE TABLE `account_cust` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_cust_name` varchar(45) DEFAULT NULL,
  `account_cust_famil` varchar(45) DEFAULT NULL,
  `account_cust_ful_name` varchar(45) DEFAULT NULL,
  `account_cust_code` varchar(45) DEFAULT NULL,
  `account_cust_birth` int(10) unsigned DEFAULT NULL,
  `account_cust_tell` varchar(45) DEFAULT NULL,
  `account_cust_mob` varchar(45) DEFAULT NULL,
  `account_cust_fax` varchar(45) DEFAULT NULL,
  `account_cust_val1` varchar(45) DEFAULT NULL,
  `account_cust_val2` varchar(45) DEFAULT NULL,
  `account_cust_val3` varchar(45) DEFAULT NULL,
  `account_cust_val4` varchar(45) DEFAULT NULL,
  `account_cust_val5` varchar(45) DEFAULT NULL,
  `account_cust_val6` varchar(100) DEFAULT NULL,
  `account_cust_val7` varchar(100) DEFAULT NULL,
  `account_cust_val8` varchar(100) DEFAULT NULL,
  `account_cust_val9` varchar(100) DEFAULT NULL,
  `account_cust_val10` longtext,
  `account_cust_val11` varchar(255) DEFAULT NULL,
  `account_cust_val12` varchar(255) DEFAULT NULL,
  `account_cust_val13` varchar(255) DEFAULT NULL,
  `account_cust_val14` varchar(255) DEFAULT NULL,
  `account_cust_val15` varchar(255) DEFAULT NULL,
  `account_cust_val16` int(10) unsigned DEFAULT NULL,
  `account_cust_val17` int(10) unsigned DEFAULT NULL,
  `account_cust_val18` int(10) unsigned DEFAULT NULL,
  `account_cust_val19` int(10) unsigned DEFAULT NULL,
  `account_cust_val20` int(10) unsigned DEFAULT NULL,
  `account_cust_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`account_cust`
--

/*!40000 ALTER TABLE `account_cust` DISABLE KEYS */;
INSERT INTO `account_cust` (`id`,`account_cust_name`,`account_cust_famil`,`account_cust_ful_name`,`account_cust_code`,`account_cust_birth`,`account_cust_tell`,`account_cust_mob`,`account_cust_fax`,`account_cust_val1`,`account_cust_val2`,`account_cust_val3`,`account_cust_val4`,`account_cust_val5`,`account_cust_val6`,`account_cust_val7`,`account_cust_val8`,`account_cust_val9`,`account_cust_val10`,`account_cust_val11`,`account_cust_val12`,`account_cust_val13`,`account_cust_val14`,`account_cust_val15`,`account_cust_val16`,`account_cust_val17`,`account_cust_val18`,`account_cust_val19`,`account_cust_val20`,`account_cust_email`) VALUES 
 (1,'','','محمد ثالثی','',13920528,'','09133368036','','','','','','','','','','','','','','','','',0,0,0,0,0,NULL),
 (2,'محمد','ثالثی','محمد ثالثی',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'dgdfgdfg',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `account_cust` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`account_factor`
--

DROP TABLE IF EXISTS `account_factor`;
CREATE TABLE `account_factor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_factor_code` varchar(45) DEFAULT NULL,
  `account_factor_user_id` int(10) unsigned DEFAULT NULL,
  `account_factor_user_name` varchar(255) DEFAULT NULL,
  `account_factor_cust_id` int(10) unsigned DEFAULT NULL,
  `account_factor_cust_name` varchar(255) DEFAULT NULL,
  `account_factor_type` int(10) unsigned DEFAULT NULL,
  `account_factor_date` int(10) unsigned DEFAULT NULL,
  `account_factor_sum` int(10) unsigned DEFAULT NULL,
  `account_factor_discount` int(10) unsigned DEFAULT NULL,
  `account_factor_pay` int(10) unsigned DEFAULT NULL,
  `account_factor_remainder` int(10) unsigned DEFAULT NULL,
  `account_factor_comment` varchar(255) DEFAULT NULL,
  `account_factor_pr_id_1` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_2` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_3` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_4` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_5` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_6` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_7` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_8` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_9` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_10` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_11` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_12` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_13` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_14` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_15` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_16` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_17` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_18` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_19` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_id_20` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_code_1` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_2` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_3` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_4` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_5` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_6` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_7` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_8` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_9` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_10` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_11` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_12` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_13` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_14` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_15` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_16` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_17` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_18` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_19` varchar(45) DEFAULT NULL,
  `account_factor_pr_code_20` varchar(45) DEFAULT NULL,
  `account_factor_pr_name_1` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_2` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_3` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_4` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_5` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_6` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_7` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_8` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_9` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_10` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_11` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_12` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_13` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_14` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_15` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_16` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_17` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_18` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_19` varchar(100) DEFAULT NULL,
  `account_factor_pr_name_20` varchar(100) DEFAULT NULL,
  `account_factor_pr_count_1` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_2` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_3` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_4` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_5` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_6` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_7` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_8` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_9` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_10` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_11` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_12` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_13` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_14` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_15` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_16` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_17` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_18` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_19` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_count_20` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_unit_1` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_2` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_3` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_4` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_5` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_6` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_7` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_8` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_9` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_10` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_11` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_12` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_13` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_14` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_15` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_16` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_17` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_18` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_19` varchar(45) DEFAULT NULL,
  `account_factor_pr_unit_20` varchar(45) DEFAULT NULL,
  `account_factor_pr_fee_1` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_2` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_3` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_4` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_5` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_6` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_7` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_8` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_9` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_10` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_11` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_12` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_13` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_14` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_15` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_16` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_17` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_18` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_19` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_fee_20` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_1` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_2` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_3` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_4` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_5` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_6` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_7` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_8` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_9` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_10` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_11` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_12` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_13` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_14` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_15` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_16` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_17` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_18` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_19` int(10) unsigned DEFAULT NULL,
  `account_factor_pr_sum_20` int(10) unsigned DEFAULT NULL,
  `account_factor_is_deliver` int(10) unsigned DEFAULT NULL,
  `account_factor_status` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`account_factor`
--

/*!40000 ALTER TABLE `account_factor` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_factor` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`account_product`
--

DROP TABLE IF EXISTS `account_product`;
CREATE TABLE `account_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_product_page` varchar(45) NOT NULL DEFAULT '0',
  `account_product_name` varchar(500) NOT NULL DEFAULT '',
  `account_product_quantity` int(10) unsigned NOT NULL DEFAULT '1' COMMENT 'تعداد موجودی',
  `account_product_pic1` varchar(255) DEFAULT NULL,
  `account_product_pic_ext` varchar(45) DEFAULT NULL,
  `account_product_price1` int(11) DEFAULT NULL,
  `account_product_price2` int(11) DEFAULT NULL,
  `account_product_currency` varchar(50) NOT NULL DEFAULT '',
  `account_product_code` varchar(45) DEFAULT NULL,
  `account_product_val1` varchar(45) DEFAULT NULL,
  `account_product_val2` varchar(45) DEFAULT NULL,
  `account_product_val3` varchar(45) DEFAULT NULL,
  `account_product_val4` varchar(45) DEFAULT NULL,
  `account_product_val5` varchar(45) DEFAULT NULL,
  `account_product_val6` varchar(100) DEFAULT NULL,
  `account_product_val7` varchar(100) DEFAULT NULL,
  `account_product_val8` varchar(100) DEFAULT NULL,
  `account_product_val9` varchar(100) DEFAULT NULL,
  `account_product_val10` longtext,
  `account_product_val11` varchar(255) DEFAULT NULL,
  `account_product_val12` varchar(255) DEFAULT NULL,
  `account_product_val13` varchar(255) DEFAULT NULL,
  `account_product_val14` varchar(255) DEFAULT NULL,
  `account_product_val15` varchar(255) DEFAULT NULL,
  `account_product_val16` varchar(255) DEFAULT NULL,
  `account_product_val17` varchar(255) DEFAULT NULL,
  `account_product_val18` varchar(255) DEFAULT NULL,
  `account_product_val19` varchar(255) DEFAULT NULL,
  `account_product_val20` varchar(255) DEFAULT NULL,
  `account_product_lang` varchar(45) NOT NULL DEFAULT '1',
  `account_product_parent` varchar(45) NOT NULL DEFAULT '0',
  `account_product_priority` varchar(45) NOT NULL DEFAULT '1',
  `account_product_visit` int(11) NOT NULL DEFAULT '1',
  `account_product_order` int(11) NOT NULL DEFAULT '0' COMMENT 'order numbers by customers',
  `account_product_rating` double NOT NULL DEFAULT '0',
  `account_product_like` int(11) NOT NULL DEFAULT '0',
  `account_product_dislike` int(11) NOT NULL DEFAULT '0',
  `account_product_date` int(10) unsigned NOT NULL DEFAULT '10000000',
  `account_product_category_id` int(10) unsigned NOT NULL DEFAULT '0',
  `account_products_abstract` longtext,
  `account_products_content` longtext,
  `account_product_pic2` varchar(255) DEFAULT NULL,
  `account_product_pic3` varchar(255) DEFAULT NULL,
  `account_product_pic4` varchar(255) DEFAULT NULL,
  `account_product_pic5` varchar(255) DEFAULT NULL,
  `account_product_pic6` varchar(255) DEFAULT NULL,
  `account_product_prop1` varchar(100) DEFAULT NULL,
  `account_product_prop2` varchar(100) DEFAULT NULL,
  `account_product_prop3` varchar(100) DEFAULT NULL,
  `account_product_prop4` varchar(100) DEFAULT NULL,
  `account_product_prop5` varchar(100) DEFAULT NULL,
  `account_product_prop6` varchar(100) DEFAULT NULL,
  `account_product_prop7` varchar(100) DEFAULT NULL,
  `account_product_prop8` varchar(100) DEFAULT NULL,
  `account_product_prop9` varchar(100) DEFAULT NULL,
  `account_product_prop10` varchar(100) DEFAULT NULL,
  `account_product_prop11` varchar(100) DEFAULT NULL,
  `account_product_prop12` varchar(100) DEFAULT NULL,
  `account_product_prop13` varchar(100) DEFAULT NULL,
  `account_product_prop14` varchar(100) DEFAULT NULL,
  `account_product_prop15` varchar(100) DEFAULT NULL,
  `account_product_prop16` varchar(100) DEFAULT NULL,
  `account_product_prop17` varchar(100) DEFAULT NULL,
  `account_product_prop18` varchar(100) DEFAULT NULL,
  `account_product_prop19` varchar(100) DEFAULT NULL,
  `account_product_prop20` varchar(100) DEFAULT NULL,
  `account_products_tag1` longtext,
  `account_products_relatedProducts` longtext,
  `account_products_active` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `account_products_block` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `account_product_groupPrice1` varchar(200) DEFAULT NULL,
  `account_product_groupPrice2` varchar(200) DEFAULT NULL,
  `account_product_groupPrice3` varchar(200) DEFAULT NULL,
  `account_product_groupPrice4` varchar(200) DEFAULT NULL,
  `account_product_groupPrice5` varchar(200) DEFAULT NULL,
  `account_product_userGroup1` varchar(200) DEFAULT NULL,
  `account_product_userGroup2` varchar(200) DEFAULT NULL,
  `account_product_userGroup3` varchar(200) DEFAULT NULL,
  `account_product_userGroup4` varchar(200) DEFAULT NULL,
  `account_product_userGroup5` varchar(200) DEFAULT NULL,
  `account_product_taxPercent` varchar(200) DEFAULT NULL,
  `account_product_discount` varchar(200) DEFAULT NULL,
  `account_product_discount_Date` varchar(100) DEFAULT NULL,
  `account_product_discount_Time` varchar(100) DEFAULT NULL,
  `account_product_has_link` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`account_product`
--

/*!40000 ALTER TABLE `account_product` DISABLE KEYS */;
INSERT INTO `account_product` (`id`,`account_product_page`,`account_product_name`,`account_product_quantity`,`account_product_pic1`,`account_product_pic_ext`,`account_product_price1`,`account_product_price2`,`account_product_currency`,`account_product_code`,`account_product_val1`,`account_product_val2`,`account_product_val3`,`account_product_val4`,`account_product_val5`,`account_product_val6`,`account_product_val7`,`account_product_val8`,`account_product_val9`,`account_product_val10`,`account_product_val11`,`account_product_val12`,`account_product_val13`,`account_product_val14`,`account_product_val15`,`account_product_val16`,`account_product_val17`,`account_product_val18`,`account_product_val19`,`account_product_val20`,`account_product_lang`,`account_product_parent`,`account_product_priority`,`account_product_visit`,`account_product_order`,`account_product_rating`,`account_product_like`,`account_product_dislike`,`account_product_date`,`account_product_category_id`,`account_products_abstract`,`account_products_content`,`account_product_pic2`,`account_product_pic3`,`account_product_pic4`,`account_product_pic5`,`account_product_pic6`,`account_product_prop1`,`account_product_prop2`,`account_product_prop3`,`account_product_prop4`,`account_product_prop5`,`account_product_prop6`,`account_product_prop7`,`account_product_prop8`,`account_product_prop9`,`account_product_prop10`,`account_product_prop11`,`account_product_prop12`,`account_product_prop13`,`account_product_prop14`,`account_product_prop15`,`account_product_prop16`,`account_product_prop17`,`account_product_prop18`,`account_product_prop19`,`account_product_prop20`,`account_products_tag1`,`account_products_relatedProducts`,`account_products_active`,`account_products_block`,`account_product_groupPrice1`,`account_product_groupPrice2`,`account_product_groupPrice3`,`account_product_groupPrice4`,`account_product_groupPrice5`,`account_product_userGroup1`,`account_product_userGroup2`,`account_product_userGroup3`,`account_product_userGroup4`,`account_product_userGroup5`,`account_product_taxPercent`,`account_product_discount`,`account_product_discount_Date`,`account_product_discount_Time`,`account_product_has_link`) VALUES 
 (10,'','دیوارکوب mdf',9999,'p6622909371.jpg','',0,0,'قیمت','','','','','','','','','','','','','','','','','0','0','0','0','0','1','0','2',27,0,0,0,0,13960427,1,'دیوارکوب چیست؟امروزه استفاده از دیوارکوب راهی شده که می توان در سریع ترین زمان ممکن و بدون استفاده از بنایی، با هزینه ای ایده آل و در طرح و رنگ های گوناگون دیواره های ساختمان خود را پوشش داد.','<p style=\"text-align: justify;\"><span style=\"color: #800080;\"><strong>دیوارکوب چیست؟</strong></span></p><p style=\"text-align: justify;margin-left: 27px;\">امروزه استفاده از دیوارکوب راهی شده که می توان در سریع ترین زمان ممکن و بدون استفاده از بنایی، با هزینه ای ایده آل و در طرح و رنگ های گوناگون دیواره های ساختمان خود را پوشش داد.</p><p style=\"text-align: justify;\">&nbsp;</p><p style=\"text-align: justify;margin-left: 22px;\">به دلیل استفاده بیش از حد دیوارکوب ها در ساختمان سازی و به خصوص دارا بودن قابلیتها و خصوصیاتی از جمله تنوع در طرح و رنگ، ضد آب بودن و قابلیت شستشو، عایق صدا و حرارت، وزن سبک، نصب سریع و دارا بودن قابلیت فرم دهی آن این محصول در مکان هایی همچون مراکز اداری و تجاری، رستوران ها، سالن های نمایش و فروشگاه ها و منازل بیش از پیش دیده می شود.</p><p>&nbsp;</p><p>&nbsp;</p><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" dir=\"ltr\" height=\"60\" width=\"13\"><tbody><tr><td style=\"width: 154px; height: 25px;\">&nbsp;</td></tr><tr><td nowrap=\"nowrap\" style=\"width: 154px; height: 28px;\">&nbsp;</td></tr></tbody></table>','p9772235893.jpg','p5461185311.png','p0548822189.jpg','p5035868275.jpg','p0714565228.jpg','','','','','','','','','','','','','','','','','','','','','','',1,0,'0','0','0','0','0','1','1','1','1','1','','','13950212','11:46',1);
INSERT INTO `account_product` (`id`,`account_product_page`,`account_product_name`,`account_product_quantity`,`account_product_pic1`,`account_product_pic_ext`,`account_product_price1`,`account_product_price2`,`account_product_currency`,`account_product_code`,`account_product_val1`,`account_product_val2`,`account_product_val3`,`account_product_val4`,`account_product_val5`,`account_product_val6`,`account_product_val7`,`account_product_val8`,`account_product_val9`,`account_product_val10`,`account_product_val11`,`account_product_val12`,`account_product_val13`,`account_product_val14`,`account_product_val15`,`account_product_val16`,`account_product_val17`,`account_product_val18`,`account_product_val19`,`account_product_val20`,`account_product_lang`,`account_product_parent`,`account_product_priority`,`account_product_visit`,`account_product_order`,`account_product_rating`,`account_product_like`,`account_product_dislike`,`account_product_date`,`account_product_category_id`,`account_products_abstract`,`account_products_content`,`account_product_pic2`,`account_product_pic3`,`account_product_pic4`,`account_product_pic5`,`account_product_pic6`,`account_product_prop1`,`account_product_prop2`,`account_product_prop3`,`account_product_prop4`,`account_product_prop5`,`account_product_prop6`,`account_product_prop7`,`account_product_prop8`,`account_product_prop9`,`account_product_prop10`,`account_product_prop11`,`account_product_prop12`,`account_product_prop13`,`account_product_prop14`,`account_product_prop15`,`account_product_prop16`,`account_product_prop17`,`account_product_prop18`,`account_product_prop19`,`account_product_prop20`,`account_products_tag1`,`account_products_relatedProducts`,`account_products_active`,`account_products_block`,`account_product_groupPrice1`,`account_product_groupPrice2`,`account_product_groupPrice3`,`account_product_groupPrice4`,`account_product_groupPrice5`,`account_product_userGroup1`,`account_product_userGroup2`,`account_product_userGroup3`,`account_product_userGroup4`,`account_product_userGroup5`,`account_product_taxPercent`,`account_product_discount`,`account_product_discount_Date`,`account_product_discount_Time`,`account_product_has_link`) VALUES 
 (36,'','میزهای متنوع',100000,'p1231467473.jpg','',0,0,'قیمت','','','','','','','','','','','','','','','','','0','0','0','0','0','1','0','1',19,0,0,0,0,13960427,11,'دکوراسیون منزل به سبک روستیک ؟؟؟ چه جوری ؟','<p>سبک روستیک (Rustic) یا همون روستایی سبکی است که هدف اصلی آن کشاندن طبیعت به داخل خانه است. یعنی استفاده از چیزهایی که در طبیعت هم موجود است. بیشترین چیزی که می تواند یک خانه به سبک روستیک را برای ما تداعی کند، استفاده از چوب و دکوری های چوبی می باشد.</p>','p0220541939.jpg','p6181998235.jpg','p2087463418.jpg','p1974995847.jpg','p4696049823.jpg','','','','','','','','','','','','','','','','','','','','','','',1,0,'0','0','0','0','0','1','1','1','1','1','','','13950526','13:05',1);
/*!40000 ALTER TABLE `account_product` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `answer_text` text,
  `answer_date` int(10) unsigned DEFAULT NULL,
  `question_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`answer`
--

/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`attachment`
--

DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `ID` bigint(20) NOT NULL,
  `FILE_NAME` varchar(50) NOT NULL,
  `FILE_DATA` blob NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`attachment`
--

/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`category_forum`
--

DROP TABLE IF EXISTS `category_forum`;
CREATE TABLE `category_forum` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_forum_title` varchar(255) DEFAULT NULL,
  `category_forum_creator` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`category_forum`
--

/*!40000 ALTER TABLE `category_forum` DISABLE KEYS */;
INSERT INTO `category_forum` (`id`,`category_forum_title`,`category_forum_creator`) VALUES 
 (1,'تست',1);
/*!40000 ALTER TABLE `category_forum` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`category_gallery`
--

DROP TABLE IF EXISTS `category_gallery`;
CREATE TABLE `category_gallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_gallery_title` varchar(100) DEFAULT NULL,
  `category_gallery_parent` int(10) unsigned DEFAULT NULL,
  `category_gallery_lang` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`category_gallery`
--

/*!40000 ALTER TABLE `category_gallery` DISABLE KEYS */;
INSERT INTO `category_gallery` (`id`,`category_gallery_title`,`category_gallery_parent`,`category_gallery_lang`) VALUES 
 (1,'اسلاید',0,1),
 (3,'Slide',1,2),
 (6,'عرض الشرائح',1,3),
 (7,'پروژه های شرکت',0,1),
 (8,'تصاویر سایت',0,1),
 (9,'سهامداران',0,1),
 (10,'تصاویر محصولات',0,1);
/*!40000 ALTER TABLE `category_gallery` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`category_news`
--

DROP TABLE IF EXISTS `category_news`;
CREATE TABLE `category_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_news_title` varchar(255) DEFAULT NULL,
  `category_news_parent` int(10) unsigned DEFAULT NULL,
  `category_news_lang` int(10) unsigned NOT NULL DEFAULT '1',
  `category_news_upperNode` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'as linking list or tree structure and for subset',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`category_news`
--

/*!40000 ALTER TABLE `category_news` DISABLE KEYS */;
INSERT INTO `category_news` (`id`,`category_news_title`,`category_news_parent`,`category_news_lang`,`category_news_upperNode`) VALUES 
 (1,'انواع چوب و MDF',0,1,0),
 (22,'Various',1,2,0),
 (38,'نحوه ی تابش نور برای دیزاین خانه',0,1,0),
 (39,'نحوه ی چیدمان وسایل منزل',0,1,0),
 (40,'دکوراسیون چوبی منزل، نجارباشی مرسی هستی!',0,1,0);
/*!40000 ALTER TABLE `category_news` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`category_poll`
--

DROP TABLE IF EXISTS `category_poll`;
CREATE TABLE `category_poll` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_poll_which` int(10) unsigned DEFAULT NULL,
  `category_poll_user_id` int(10) unsigned DEFAULT NULL,
  `category_poll_answer` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`category_poll`
--

/*!40000 ALTER TABLE `category_poll` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_poll` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`category_product`
--

DROP TABLE IF EXISTS `category_product`;
CREATE TABLE `category_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_product_title` varchar(255) DEFAULT NULL,
  `category_product_parent` int(10) unsigned DEFAULT NULL,
  `category_product_lang` int(10) unsigned DEFAULT NULL,
  `category_product_upperNode` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`category_product`
--

/*!40000 ALTER TABLE `category_product` DISABLE KEYS */;
INSERT INTO `category_product` (`id`,`category_product_title`,`category_product_parent`,`category_product_lang`,`category_product_upperNode`) VALUES 
 (1,'انواع دیوارکوب',0,1,0),
 (11,'مدل های مختلف میز با چوب',0,1,0);
/*!40000 ALTER TABLE `category_product` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`click_tracker`
--

DROP TABLE IF EXISTS `click_tracker`;
CREATE TABLE `click_tracker` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `click_tracker_link` varchar(500) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `click_tracker_visitor` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `click_tracker_clickCount` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`click_tracker`
--

/*!40000 ALTER TABLE `click_tracker` DISABLE KEYS */;
/*!40000 ALTER TABLE `click_tracker` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_text` text,
  `comment_full_name` varchar(100) DEFAULT NULL,
  `comment_email` varchar(100) DEFAULT NULL,
  `comment_date` int(11) DEFAULT NULL,
  `comment_tell` varchar(30) DEFAULT NULL,
  `comment_title` varchar(255) DEFAULT NULL,
  `comment_answer` text,
  `comment_char1` varchar(255) DEFAULT NULL,
  `comment_char2` varchar(255) DEFAULT NULL,
  `comment_char3` varchar(255) DEFAULT NULL,
  `comment_int1` int(10) unsigned DEFAULT NULL,
  `comment_int2` int(10) unsigned DEFAULT NULL,
  `comment_int3` int(10) unsigned DEFAULT NULL,
  `comment_refrenceId` varchar(200) DEFAULT NULL COMMENT 'نام جدول و آی دی رکوردی که کامنت برای آن ثبت شده است',
  `comment_publish` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`comment`
--

/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (1,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (2,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (3,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (4,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (5,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (6,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (7,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (8,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (9,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (10,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960724,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (11,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (12,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (13,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (14,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (15,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (16,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (17,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (18,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (19,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (20,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (21,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (22,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (23,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (24,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (25,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (26,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (27,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (28,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (29,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (30,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (31,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (32,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (33,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (34,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (35,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (36,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (37,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (38,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (39,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (40,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (41,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (42,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (43,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (44,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (45,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (46,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (47,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (48,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (49,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (50,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (51,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (52,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (53,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (54,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (55,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (56,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (57,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (58,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (59,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (60,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (61,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (62,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (63,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (64,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (65,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (66,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (67,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (68,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (69,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (70,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (71,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (72,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (73,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (74,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (75,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (76,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (77,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (78,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (79,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (80,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (81,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (82,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (83,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (84,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (85,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (86,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (87,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (88,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (89,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (90,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (91,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (92,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (93,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (94,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (95,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (96,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (97,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (98,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (99,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (100,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (101,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (102,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (103,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (104,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (105,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (106,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (107,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (108,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (109,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (110,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (111,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (112,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (113,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (114,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (115,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (116,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (117,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (118,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (119,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (120,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (121,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (122,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (123,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (124,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (125,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (126,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (127,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (128,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960730,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (129,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (130,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (131,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (132,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (133,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (134,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (135,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (136,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (137,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (138,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (139,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (140,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (141,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (142,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (143,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960802,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (144,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (145,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (146,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (147,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (148,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (149,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (150,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (151,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (152,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (153,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (154,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (155,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (156,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (157,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (158,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (159,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (160,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (161,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (162,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (163,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (164,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (165,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (166,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (167,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13960806,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (168,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13971101,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (169,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13971101,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (170,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13971101,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (171,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','سیستم','mrsalesi@gmail.com',13971101,'03112683807','مشکلی در سیستم','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (172,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971107,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (173,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971107,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (174,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971107,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (175,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971107,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (176,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971107,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (177,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971107,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (178,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (179,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (180,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (181,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (182,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (183,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (184,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (185,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (186,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (187,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (188,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (189,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (190,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (191,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971108,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (192,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (193,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (194,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 2, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (195,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 1, Size: 1</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (196,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 1, Size: 1</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (197,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 1, Size: 1</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (198,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (199,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (200,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (201,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (202,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (203,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (204,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (205,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (206,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (207,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (208,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (209,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (210,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (211,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (212,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (213,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (214,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (215,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (216,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (217,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (218,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (219,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (220,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (221,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (222,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (223,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (224,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (225,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (226,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (227,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (228,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (229,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (230,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (231,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (232,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (233,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (234,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (235,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971109,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (236,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971115,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (237,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971115,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (238,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (239,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (240,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (241,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (242,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (243,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (244,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (245,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (246,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971129,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (247,'<p style=\'direction:ltr\'>cms.tools.Js.setVal > line:96</p><p style=\'direction:ltr\'>cms.access.Access_User.select > line:434</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971206,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (248,'<p style=\'direction:ltr\'>cms.tools.Js.setVal > line:96</p><p style=\'direction:ltr\'>cms.access.Access_User.select > line:434</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971206,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (249,'<p style=\'direction:ltr\'>cms.tools.Js.setVal > line:96</p><p style=\'direction:ltr\'>cms.access.Access_User.select > line:434</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971206,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (250,'<p style=\'direction:ltr\'>cms.tools.Js.setVal > line:96</p><p style=\'direction:ltr\'>cms.access.Access_User.select > line:434</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971206,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (251,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:448</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971213,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (252,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971214,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (253,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971214,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (254,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971214,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (255,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971214,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (256,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971214,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (257,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (258,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (259,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (260,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (261,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (262,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (263,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (264,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (265,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (266,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971215,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (267,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (268,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (269,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (270,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (271,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (272,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (273,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (274,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (275,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (276,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (277,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (278,'<p style=\'direction:ltr\'>java.lang.NumberFormatException: For input string: \"\"</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (279,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (280,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (281,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 1, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (282,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (283,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (284,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 1, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (285,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 1, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (286,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (287,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (288,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (289,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (290,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (291,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (292,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (293,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (294,'<p style=\'direction:ltr\'>java.lang.RuntimeException: Uncompilable source code - Erroneous tree type: <any></p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (295,'<p style=\'direction:ltr\'>java.lang.RuntimeException: Uncompilable source code - Erroneous tree type: <any></p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (296,'<p style=\'direction:ltr\'>java.lang.RuntimeException: Uncompilable source code - Erroneous tree type: <any></p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (297,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (298,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971218,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (299,'<p style=\'direction:ltr\'>cms.tools.Js.setHtml > line:55</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971219,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (300,'<p style=\'direction:ltr\'>cms.tools.Js.setHtml > line:55</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971219,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (301,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971219,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (302,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971219,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (303,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971219,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (304,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971219,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (305,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (306,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (307,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (308,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (309,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (310,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (311,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:479</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (312,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:479</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971220,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (313,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (314,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (315,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (316,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (317,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (318,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:479</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (319,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (320,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (321,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (322,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (323,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (324,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971221,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (325,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:537</p><p style=\'direction:ltr\'>java.lang.RuntimeException: Uncompilable source code - Erroneous tree type: <any></p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (326,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (327,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (328,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (329,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (330,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (331,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (332,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (333,'<p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (334,'<p style=\'direction:ltr\'>cms.tools.Js.setVal > line:96</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (335,'<p style=\'direction:ltr\'>cms.tools.Js.setVal > line:96</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (336,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:429</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (337,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (338,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (339,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (340,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (341,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (342,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (343,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (344,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (345,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (346,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:436</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (347,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (348,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (349,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (350,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (351,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (352,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (353,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:437</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (354,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:533</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (355,'<p style=\'direction:ltr\'>cms.access.Access_User.select > line:533</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (356,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (357,'<p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (358,'<p style=\'direction:ltr\'>cms.access.Access_User.removeFile > line:429</p><p style=\'direction:ltr\'>java.lang.IndexOutOfBoundsException: Index: 0, Size: 0</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13971222,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (359,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:992</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (360,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:995</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (361,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:992</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (362,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:995</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (363,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:992</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (364,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:992</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
 (365,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:995</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `comment` (`id`,`comment_text`,`comment_full_name`,`comment_email`,`comment_date`,`comment_tell`,`comment_title`,`comment_answer`,`comment_char1`,`comment_char2`,`comment_char3`,`comment_int1`,`comment_int2`,`comment_int3`,`comment_refrenceId`,`comment_publish`) VALUES 
 (366,'<p style=\'direction:ltr\'>cms.access.Access_User.afterUserLoginOrRegist > line:995</p><p style=\'direction:ltr\'>cms.access.Access_User.loginUser > line:940</p><p style=\'direction:ltr\'>java.lang.NullPointerException</p>','Ø³ÛŒØ³ØªÙ…','mrsalesi@gmail.com',13980117,'03112683807','Ù…Ø´Ú©Ù„ÛŒ Ø¯Ø± Ø³ÛŒØ³ØªÙ…','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`comment_activity`
--

DROP TABLE IF EXISTS `comment_activity`;
CREATE TABLE `comment_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_text` text,
  `comment_full_name` varchar(100) DEFAULT NULL,
  `comment_email` varchar(100) DEFAULT NULL,
  `comment_date` int(11) DEFAULT NULL,
  `comment_tell` varchar(30) DEFAULT NULL,
  `comment_title` varchar(255) DEFAULT NULL,
  `comment_answer` text,
  `comment_char1` varchar(255) DEFAULT NULL,
  `comment_char2` varchar(255) DEFAULT NULL,
  `comment_char3` varchar(255) DEFAULT NULL,
  `comment_int1` int(10) unsigned DEFAULT NULL,
  `comment_int2` int(10) unsigned DEFAULT NULL,
  `comment_int3` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`comment_activity`
--

/*!40000 ALTER TABLE `comment_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_activity` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`content`
--

DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_title` varchar(600) DEFAULT NULL,
  `content_content` longtext,
  `content_parent` int(10) unsigned DEFAULT NULL,
  `content_lang` int(10) unsigned DEFAULT NULL,
  `content_has_link` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `content_tags` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`content`
--

/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (21,'Contact us','<p>Contact us</p>',14,2,1,NULL),
 (43,'استخدام','<p style=\"font-family: Tahoma; font-size: 10pt\"><span style=\"font-size:20px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><span style=\"color: rgb(0, 0, 128);\"><strong>نمایندگان فیوره</strong></span></span></span></p><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"724\" width=\"1069\"><tbody><tr><td><p style=\"font-family: Tahoma; font-size: 10pt; text-align: center;\"><span style=\"font-size:18px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><strong><span style=\"color: rgb(75, 0, 130);\">استان اصفهان</span></strong></span></span></p><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"133\" width=\"956\"><tbody><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">اصفهان</span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">شرکت سپانو</span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">خ 22 بهمن، روبروی مجتمع اداری امیرکبیر</span>،<span style=\"font-family:tahoma,geneva,sans-serif;\"> ساختمان غدیر</span>، <span style=\"font-family:tahoma,geneva,sans-serif;\">واحد 210</span></td></tr><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">لنجان</span> </span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">جناب آقای قاسمی </span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">فلاورجان، انتهای خ امام، جنب شعبه نفت، کامپیوترآریانا</span>،03137422056- 09137998681</td></tr><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">شاهین شهر</span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">جناب آقای براتیان</span></td><td>&nbsp;</td></tr><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">کاشان </span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">جناب آقای محبی</span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">کاشان، خ امیر کبیر، خ سلمان فارسی، نبش کوچه بهار، سیلک رایانه، 03155312008- 09389862954</span></td></tr></tbody></table></td></tr><tr><td style=\"text-align: center;\"><span style=\"font-size:18px;\"><strong><span style=\"color: rgb(75, 0, 130);\"><span style=\"font-family: tahoma,geneva,sans-serif;\">استان خوزستان</span></span></strong></span></td></tr><tr><td><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"123\" width=\"1062\"><tbody><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">اهواز</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">جناب آقای کیانی</span>&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;</td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">کیان پارس - خیابان 8 شرقی - مجتمع آسمانی 2 - &nbsp;طبقه اول - واحد 3</span> -<span style=\"font-family:tahoma,geneva,sans-serif;\">&nbsp;09106640766-06133911369</span></td></tr><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">بندر امام&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">جناب آقای میرکاظمی </span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">سربندر، کوی ش مطهری، سیصد دستگاه، تقاطع خ جهاد به خیام، شرکت فنی مهندسی الکتروسیما، 06512227654-06512690222</span></td></tr><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">دزفول</span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">جناب آقای آژند</span></td><td><p><span style=\"font-family:tahoma,geneva,sans-serif;\">تقاطع شریعتی و آفرینش، روبروی بانک پاسارگاد، ط فوقانی لوازم خانگی فارابی، 06412252828- 09106460406</span></p></td></tr></tbody></table><p style=\"text-align: center;\"><span style=\"font-size:18px;\"><strong><span style=\"color: rgb(75, 0, 130);\"><span style=\"font-family: tahoma,geneva,sans-serif;\">استان آذربایجان شرقی</span></span></strong></span></p></td></tr><tr><td><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"27\" width=\"588\"><tbody><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">تبریز&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">&nbsp;جناب آقای شمی پور</span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">تیریز، شهرک پرواز، 09142382620&nbsp; </span></td></tr></tbody></table><p style=\"text-align: center;\"><span style=\"font-size:18px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><strong><span style=\"color: rgb(75, 0, 130);\">استان تهران</span></strong></span></span></p></td></tr><tr><td><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"27\" width=\"396\"><tbody><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">تهران</span> </span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">&nbsp;&nbsp; جناب آقای دهقانی</span></td></tr></tbody></table><p style=\"text-align: center;\"><span style=\"font-size:18px;\"><strong><span style=\"color: rgb(75, 0, 130);\"><span style=\"font-family: tahoma,geneva,sans-serif;\">استان قم</span></span></strong></span></p></td></tr><tr><td><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"27\" width=\"555\"><tbody><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">قم</span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">&nbsp; &nbsp; &nbsp; &nbsp; جناب آقای مرادی</span></td></tr></tbody></table><p style=\"text-align: center;\"><span style=\"font-size:18px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><strong><span style=\"color: rgb(75, 0, 130);\">استان مازندران</span></strong></span></span></p></td></tr><tr><td><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"32\" width=\"492\"><tbody><tr><td><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#800080;\">نور&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></td><td><span style=\"font-family:tahoma,geneva,sans-serif;\">&nbsp; جناب آقای ناییجی</span></td><td>09119135819</td></tr></tbody></table></td></tr></tbody></table><p style=\"font-family: Tahoma; font-size: 10pt\">&nbsp;</p><p style=\"font-family: Tahoma; font-size: 10pt\">&nbsp;</p><p style=\"font-family: Tahoma; font-size: 10pt\">برای اخذ نمایندگی</p><p style=\"font-family: Tahoma; font-size: 10pt\">لطفا فرم زیر را به صورت صحیح پر نموده و در صورت لزوم رزومه شخصی خود را با نوع pdf برای ما ارسال فرمایید.</p>',0,1,1,NULL),
 (49,'مقالات دکوراسیون','<div class=\"gallery\" id=\"gallery\"><div class=\"container\"><h1><a class=\"active\" href=\"https://www.chidaneh.com/ideabooks/decoration/small-spaces/168648\">دکوراسیون آپارتمان های کوچک، کلید زندگی بزرگ در منزل کوچک!</a></h1><div id=\"gallery_hover\"><div class=\"gallery-grids\"><section><ul class=\"da-thumbs\" id=\"da-thumbs\"><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g1.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g1.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g1.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g1.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g1.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g2.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g2.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g2.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g2.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g2.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g3.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g3.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g3.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g3.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g3.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g4.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g4.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g4.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g4.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g4.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g5.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g5.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g5.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g5.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g5.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/polymer.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/polymer.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/polymer.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/polymer.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/polymer.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g7.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g7.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g7.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g7.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g7.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g8.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g8.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g8.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g8.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g8.jpg\"> </a></li><li><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g9.jpg\"><img alt=\"\" src=\"images_arminpolymer/img/g9.jpg\" /> </a><div><h5><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g9.jpg\"><span>آرمین </span>پلیمر</a></h5><p><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g9.jpg\">تهیه و تولید انواع قطعات و مواد اولیه پلی یورتان</a></p></div><a class=\"b-link-stripe b-animate-go  thickbox\" href=\"images_arminpolymer/img/g9.jpg\"> </a></li></ul></section></div></div><!--script--></div></div><script type=\"text/javascript\">            $(function () {                $(\" #da-thumbs > li \").each(function () {                    $(this).hoverdir();                });            });        </script><script type=\"text/javascript\">$(function () {  $(\".gallery a\").Chocolat();});    </script>',0,1,0,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (51,'اتوماسیون اداری','<p style=\"font-family:Tahoma;font-size:10pt\">شرکت دانش بنیان پژوهشگران سیستم های هوشمند سپانو مجری و طراح انواع CMS و اتوماسیون های اداری با ضریب امنیتی بالا و همچنین امکانات مختلف پشتیبانی و قابلیت های نوینی که با طراحی مالتی پلتفرم (Multi Platform) می تواند مجموعه اتوماسیون شما به ابزار کارا و انعطاف تبدیل کند .</p><p style=\"font-family:Tahoma;font-size:10pt\">برای تماس با ما و دریافت خدمات پشتیبانی تردید نکنید .</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p><p style=\"font-family:Tahoma;font-size:10pt\">مطالب مرتبط :</p><p style=\"font-family:Tahoma;font-size:10pt\">برنامه مدیریت محتوای سایت (CMS)</p><p style=\"font-family:Tahoma;font-size:10pt\">اتوماسیون صنعتی</p><p style=\"font-family:Tahoma;font-size:10pt\">بازگشت به صفحه اصلی</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p>',0,1,1,NULL),
 (66,'ویژگیهای یک طراحی خوب سایت','<p>چه طراحی سایتی یک <strong>طراحی سایت خوب</strong> محسوب می گردد؟ آیا <strong>طراحی سایت</strong> خوب به معنی استفاده از یک طراح گرافیست متخصص است؟ آیا <strong>طراحی سایت</strong> شما باعث واکنش طراحان سایت دیگر شده است؟ آیا طراحی سایت شما&nbsp; باعث ایجاد تعامل شما و بازدیدکننده گانتان&nbsp; بدون هیچ مانعی می شود؟</p><p>نکته ی آخر این که&nbsp; مهم ترین عامل، تعیین تفاوت اساسی، بین طراحی موفق و ناموفق سایت می باشد. با وجود اینکه درک افراد از یک طراحی سایت خوب از فردی به فرد دیگر متفاوت است، برخی از قراردادها یا (کنوانسیون) ها تاسیس شده و شما می توانید از این استاندارد ها پیروی کرده و اطمینان حاصل فرمایید که دسترسی به وب سایت شما برای تمامی افراد امکان پذیر می باشد.</p><p>هنگامی که شما در حال <strong>طراحی سایت</strong> خود هستید، به ویژه که این روزها به طور مداوم باید از این حقیقت آگاه باشید که برای دسترسی به وب سایت شما، مرورگرها و دستگاه های متعددی وجود دارند که افراد می توانند از آنها استفاده نمایند. در این سالها افراد زیادی می توانند به صورت مستقیم به اینترنت وصل شده و به وب سایت شما دسترسی پیدا کنند.</p><p>حتی می توانند از طریق استفاده از تلفن همراه خود، سایت شما را باز نمایند. گذشت آن روزهایی که مردم فقط از اینترنت اکسپلورر به عنوان مرورگر اصلی اینترنت استفاده می کردند. همچنین <a href=\"http://www.iransepano.ir:8787/IranSepano.ir/index5.html\" target=\"_blank\">طراحی سایت</a> شما بستگی به برنامه ریزی شما نیز دارد که چه مواردی در آن به نمایش گذاشته شود. آیا فقط دارای متن یا عکس یا ویدئو و یا ترکیبی از تمامی اینها باشد؟</p><p>پس <a href=\"http://www.iransepano.ir:8787/IranSepano.ir/index5.html\" rel=\"nofollow\" target=\"_blank\">طراحی وب سایت</a> شما باید بر این اساس باشد. اگر وب سایت شما صرفاً برای انتشار مطالب طراحی شده است ، پس سعی کنید تا حد ممکن کمتر از تصاویر گرافیکی استفاده نمایید. زیرا افرادی که به وب سایت شما مراجعه می کنند از مطالب و محتوای وب سایت شما بهره می برند و نه از تصاویر و ویدئو های وب سایت شما.</p><p>به طور مشابه اگر تخصص شما انیمیشن می باشد و <strong>طراحی وب سایت</strong> خود را به گونه ای انجام داده اید که کارهای فلش انیمیشن شما را به نمایش درآورد، بنابراین نیازی نیست که نگران باشید که در وب سایت شما محتوا و متنی برای دسترسی افراد وجود ندارد. بنابراین هنگامی که می خواهید طراحی سایت خود را شروع نمایید باید تمامی این پارامترها را در نظر بگیرید.</p><p>اما آیا این بدان معنی است که طراحی سایت شما همیشه باید منطبق با انواع مرورگرها و دستگاه ها باشد و نباید بر روی کسب و کار خود و هر آنچه که هست تمرکز نمایید! پس چه کاری باید انجام دهید؟ نه من دقیقاً این را پیشنهاد نکردم؛ کافی است فقط حواستان به دستورالعمل های طراحی سایت که در متن زیر ارائه شده باشد، این اطمینان به شما داده خواهد شد که ۹۵٪ افراد در اینترنت می توانند به وب سایت شما دسترسی داشته باشند.(آن ۵٪ هم همیشه هستند افرادی که نمی توانند به راحتی به یک وب سایت دسترسی پیدا کنند. خیلی هم مهم نیست که چه می کنند!)</p><p>۱-ایجاد یک طراحی سایت سبک: در صورت امکان در <a href=\"http://www.iransepano.ir:8787/IranSepano.ir/index5.html\" target=\"_blank\" title=\"طراحی سایت\"><strong>طراحی سایت</strong></a> خود از جاوا اسکریپت و یا گرافیک های حجیم که بر بخش عمده ای از عملکرد وب سایت شما تاثیر می گذارد، استفاده ننمایید. به عنوان مثال اگر برخی اطلاعات مهم در وب سایت شما وجود دارد و افراد نیازمند به دسترسی به این اطلاعات قبل از انجام هر معامله ای با شما هستند، پس سعی نکنید ارائهء اطلاعات و دسترسی به آن فقط از طریق جاوااسکریپت و یا فایل تصویر و انیمیشن باشد.</p><p>تمامی مطالب مهم خود را باید فقط به صورت متن در دسترس عموم قرار دهید؛ حتی اگر مجبور به استفاده از تصاویر و چیزهای دیگری شدید، همیشه مطمئن شوید که متنهای جایگزین دیگری برای آن در نظر گرفته اید.</p><p>۲-در <strong>طراحی سایت</strong> خود از رنگهایی که باعث فشار بر روی چشم می شود استفاده ننمایید. اگر می خواهید افراد به وب سایت شما بارها و بارها مراجعه نمایند و از مطالب شما استفاده کرده و یا با شما وارد معامله شوند، باید تا حد امکان شرایطی برای آنها فراهم کنید که از حضور در وب سایت شما لذت ببرند.</p><p>اگر ترکیب رنگ در وب سایت شما پر فشار باشد، دیگر مهم نیست که طراحی سایت شما چقدر عالی است؛ پس از مدتی افراد از حضور در وب سایت شما احساس خستگی کرده و دیگر به وب سایت شما مراجعه نمی کنند.</p><p>همچنین همیشه مراقب رنگ پس زمینه ی متن ها و مطالب باشید که روشن تر از متن و یا بالعکس آن باشد.</p><p>۳-در طراحی سایت خود تعریف دقیق و درستی از حرکت در سایت داشته باشید. اگر در وب سایت شما صفحات چندتایی وجود دارد، حتماً باید تعریف برجسته ای از سیستم حرکت و سهولت در حرکت در وب سایت برای تمامی افراد داشته باشید.</p><p>همانطور که در بالا ذکر شد اجازه دهید مرور وب سایت شما وابسته به تصاویر، جاوا اسکریپت و یا فلش انیمیشن باشد. در صورت امکان یک منوی اصلی را بصورت متنی ایجاد نمایید. با طراحی سایت به صورت css می توانید منوی اصلی متنی مناسبی ایجاد نمایید.</p><p>۴-در طراحی سایت خود از css استفاده نمایید. زیرا می توانید مطالب و منوی وب سایت خود را به سبک خطی ظاهر نمایید. از آنجایی که همه ی صفحه بندی ها مربوط به کارگذاری از طریق تعاریف css و صرف نظر از اینکه چگونه متن شما (متنی یا گرافیکی) ظاهر می شود، طرح خوشایندی به نظر خواهد رسید.</p><p>تکنیک های <strong>طراحی سایت</strong> با css این اجازه را به شما می دهد تا موقتی وب سایت خود را با صفحه بندی کامل بارگزاری نموده بدون اینکه هنگام بارگزاری وب سایت شما غیر قابل دسترس شود. طراحی سایت با شیوه ی css همیشه به شما کمک می کند تا محتوای اصلی خود را قبل از لینک ایجاد پیوند ، در زیر نوار و یا سمت راست آن به نمایش بگذارید.</p><p>اگر از این اصول اساسی <strong>طراحی وب سایت</strong> پیروی نمایید در این صورت می توانید طراحی سایت خود را به رخ دیگران بکشید. به خاطر داشته باشید که شما <a href=\"http://www.iransepano.ir:8787/IranSepano.ir/index5.html\" target=\"_blank\" title=\"طراحی سایت\"><strong>طراحی سایت</strong></a> را به خاطر بازدیدکننده انجام می دهید نه برای هوا و هوس خودتان!</p><p>منبع : sitedesign24</p><p>&nbsp;</p>',0,1,1,NULL);
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (68,'صفحه اصلی','<div class=\"team\" id=\"team\"><div class=\"container\"><!--<h3 class=\"tittle\">Our Designers</h3>--><div class=\"agile_team_grids\"><div class=\"col-md-3 agile_team_grid team-left-w3l-agile\"><div class=\"agile_team_grid_main\"><img alt=\" \" class=\"img-responsive\" src=\"images_najarbashi/img/company.jpg\" /><div class=\"p-mask\"><p>&nbsp;</p><ul class=\"social-icons\"><li dir=\"rtl\"><a href=\"https://t.me/najrbashi_admin/\"><img alt=\"telegram\" src=\"upload/p5388983158.png\" style=\"width: 50px; height: 25px;\" /></a></li><li dir=\"rtl\"><a href=\"https://www.instagram.com/najarbashi_group/\"><img alt=\"insta\" src=\"upload/p5694229609.png\" style=\"width: 50px; height: 25px;\" /></a></li></ul></div></div><div class=\"agile_team_grid1\"><h3>دکوراسیون دفتر کار</h3><p>یکی از المان های مهم در طراحی دکوراسیون داخلی در تمام بخش ها ، رنگ زمینه یا رنگ اصلی است که در آن فضا استفاده می شود . ..</p></div></div><div class=\"col-md-3 agile_team_grid team-left-w3l-agile\"><div class=\"agile_team_grid_main\"><img alt=\" \" class=\"img-responsive\" src=\"images_najarbashi/img/tchen.jpg\" /><div class=\"p-mask\"><ul class=\"social-icons\"><li dir=\"rtl\"><a href=\"https://t.me/najrbashi_admin/\"><img alt=\"telegram\" src=\"upload/p5388983158.png\" style=\"width: 50px; height: 25px;\" /></a></li><li dir=\"rtl\"><a href=\"https://www.instagram.com/najarbashi_group/\"><img alt=\"insta\" src=\"upload/p5694229609.png\" style=\"width: 50px; height: 25px;\" /></a></li></ul></div></div><div class=\"agile_team_grid1\"><h3>&nbsp;دکوراسیون آشپزخانه</h3><p>کابینت ها را می توان از اصلی ترین اجزاء در آشپزخانه ها با دکوراسیون کلایسک و مدرن محسوب می کرد.&nbsp; ...</p></div></div><div class=\"col-md-3 agile_team_grid team-left-w3l-agile\"><div class=\"agile_team_grid_main\"><img alt=\" \" class=\"img-responsive\" src=\"images_najarbashi/img/baby.jpg\" /><div class=\"p-mask\"><ul class=\"social-icons\"><li dir=\"rtl\"><a href=\"https://t.me/najrbashi_admin/\"><img alt=\"telegram\" src=\"upload/p5388983158.png\" style=\"width: 50px; height: 25px;\" /></a></li><li dir=\"rtl\"><a href=\"https://www.instagram.com/najarbashi_group/\"><img alt=\"insta\" src=\"upload/p5694229609.png\" style=\"width: 50px; height: 25px;\" /></a></li></ul></div></div><div class=\"agile_team_grid1\"><h3>دکوراسیون اتاق کودک</h3><p>طراحی دکوراسیون و چیدمان اتاق نوزاد پسر و دختر یکی از لذت بخش ترین کارها برای پدر و مادر های جوان است ...</p></div></div><div class=\"col-md-3 agile_team_grid team-left-w3l-agile\"><div class=\"agile_team_grid_main\"><img alt=\" \" class=\"img-responsive\" src=\"images_najarbashi/img/Living.jpg\" /><div class=\"p-mask\"><ul class=\"social-icons\"><li dir=\"rtl\"><a href=\"https://t.me/najrbashi_admin/\"><img alt=\"telegram\" src=\"upload/p5388983158.png\" style=\"width: 50px; height: 25px;\" /></a></li><li dir=\"rtl\"><a href=\"https://www.instagram.com/najarbashi_group/\"><img alt=\"insta\" src=\"upload/p5694229609.png\" style=\"width: 50px; height: 25px;\" /></a></li></ul></div></div><div class=\"agile_team_grid1\"><h3>دکوراسیون نشیمن</h3><p>امروزه با توجه به فضاهای آپارتمانی خانه ها, اهمیت دکوراسیون داخلی منزل بیشتر از گذشته شده است...</p></div></div><div class=\"clearfix\">&nbsp;</div></div></div></div><div class=\"services\" id=\"services\"><div class=\"container\"><h3 class=\"tittle\" style=\"font-family: SOGAND;\">مقالات مفید دکوراسیون</h3><div class=\"grid\"><div class=\"col-md-6 serve-agileinfo\"><figure class=\"effect-julia\"><img alt=\"img21\" src=\"images_najarbashi/img/S1.jpg\" /><figcaption><h4>نجار <span>باشی </span></h4><div><p>دکوراسیون آشپزخانه</p><p>دکوراسیون وطراحی داخلی</p><p>نورپردازی و ترکیب رنگ بندی</p></div><a class=\"scroll\" href=\"images_najarbashi/#\">View more</a></figcaption></figure><p class=\"ser-para-wthree\">شناسایی و تشخیص سبک طراحی یک آشپزخانه با تماشای آن راحت تر از شناسایی آن از طریق کلمات است. بدین معنی که سبک های طراحی را نمی توان کاملا در قالب کلمات گنجاند و از آنها تعریفی صد در صد مشخص نمود که با طراحی عملی در دنیای واقعی عینا یکی باشد. به هر حال ما در این مقاله با برشماردن ویژگی های هر یک از اصلی ترین سبک های طراحی به شما کمک می کنیم</p></div><div class=\"col-md-6 serve-agileinfo\"><figure class=\"effect-julia\"><img alt=\"img22\" src=\"images_najarbashi/img/S2.jpg\" /><figcaption><h4>نجار <span>باشی </span></h4><div><p>دکوراسیون نشیمن</p><p>طراحی داخلی نشیمن</p><p>نورپردازی و ترکیب رنگ بندی</p></div><a class=\"scroll\" href=\"images_najarbashi/#\">View more</a></figcaption></figure><p class=\"ser-para-wthree\">برای تماشای تلویزیون، مطالعه&zwnj;ی کتاب، استراحت کردن در خانه و حتی دورهمی&zwnj;های دوستانه و صمیمانه؛ بهترین قسمت خانه، &zwnj;اتاق نشیمن است؛ اتاقی که آرامش، راحتی و زیبایی را کنار هم داشته باشد. برای داشتن چنین اتاق نشیمنی، انتخاب و چیدمان صحیح اشیا موضوع مهمی است. در این انتخاب و چیدمان هماهنگی کالا&zwnj;های این اتاق از نظر طراحی، رنگ و حتی جنس اهمیت پیدا می&zwnj;کند.</p><p>&nbsp;</p></div><div class=\"col-md-6 serve-agileinfo two\"><figure class=\"effect-julia\"><img alt=\"img22\" src=\"images_najarbashi/img/S4.jpg\" /><figcaption><h4>نجار <span>باشی </span></h4><div><p>دکوراسیون اتاق کار</p><p>دکوراسیون و طراحی اتاق</p><p>نورپردازی و ترکیب رنگ بندی</p></div><a class=\"scroll\" href=\"images_najarbashi/#\">View more</a></figcaption></figure><p class=\"ser-para-wthree\">طراحی دکوراسیون داخلی ادارجات باید طوری باشد که هدف و مفهوم کاری یک شرکت را منعکس کند. دکوراسیون اداری مدرن و بروز می تواند رسیدن به چنین هدفی را ساده تر و کم هزینه تر کند. با طراحی درست فضای داخلی اداره، نوعی احساس غرور و افتخار در کارمندان و همچنین احساس اطمینان خاطر در مراجعه کنندگان ایجاد می شود که خود موضوع بسیار بسیار مهمی است.</p><p>&nbsp;</p></div><div class=\"col-md-6 serve-agileinfo two\"><figure class=\"effect-julia\"><img alt=\"img22\" src=\"images_najarbashi/img/S3.jpg\" /><figcaption><h4>نجار <span>باشی </span></h4><div><p>دکوراسیون اتاق کودک</p><p>طراحی داخلی اتاق</p><p>نورپردازی و ترکیب رنگ بندی</p></div><a class=\"scroll\" href=\"images_najarbashi/#\">View more</a></figcaption></figure><p class=\"ser-para-wthree\">اتاق کودکان فضایی است که کوچکترین اعضای خانواده در آن زندگی می کنند ، بزرگ میشوند و فعالیت های مختلفی برای رشد ذهنی و جسمی کودک در آن صورت می پذیرد. فضایی که فرزندان شما در آن بازی می کنند ،یاد می گیرند ،می خوابند و رویاپردازی می کنند . با توجه به نقش مهمی که فضای اتاق کودکان در پیشرفت آنها ایفا می کند ، این فضا باید جذاب ،شاد ،آموزنده و متناسب با سن و جنسیت فرزندتان باشد .</p><p>&nbsp;</p></div><div class=\"clearfix\">&nbsp;</div></div></div></div><!--//services--><!--/video--><!-- pop-up-box --><!--<link href=\"images_najarbashi/css/popuo-box.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />--><!--<script src=\"images_najarbashi/js/jquery.magnific-popup.js\" type=\"text/javascript\"></script>--><!--    <script>  $(document).ready(function () {    $(\".popup-with-zoom-anim\").magnificPopup({type: \"inline\",fixedContentPos: false,fixedBgPos: true,overflowY: \"auto\",closeBtnInside: true,preloader: false,midClick: true,removalDelay: 300,mainClass: \"my-mfp-zoom-in\"    });  });  </script>--><div class=\"news\" id=\"news\"><div class=\"container\"><h3 class=\"tittle\">مقالات چوب</h3><div class=\"news-bottom\"><div class=\"news-one-wthree-agile\"><div class=\"col-md-6 news-left\"><div class=\"biseller-column\"><a class=\"lightbox\" href=\"images_najarbashi/#one\"><img alt=\"\" src=\"images_najarbashi/img/n1.jpg\" /> </a><div class=\"lightbox-target\" id=\"one\"><img alt=\"\" src=\"images_najarbashi/img/n1.jpg\" /><p class=\"pop\">چوب یک ماده الیافی، آلی و نباتی است. دو ماده اصلی تشکیل دهنده آن عبارتند از: سلولز و لیگنین. طرز قرار گرفتن الیاف چوب به نوع درخت بستگی دارد. هر چوبی را نمی توان به صورت تخته درآورد و معمولاً تخته را از درخت های تولید کننده الوار می سازند. محصولات بسیار زیاد دیگری را نیز می توان از چوب ساخت. این محوصلات عبارتند از: خمیر سولز، کاغذ، الیاف زیان، پلاستیک، لاستیک، شکر، آهار و الکل</p><a class=\"lightbox-close\" href=\"images_najarbashi/#\"> </a><div class=\"clearfix\">&nbsp;</div></div></div></div><div class=\"col-md-6 news-right\"><h4><a href=\"images_najarbashi/#one\">شناخت ساختمان چوب </a></h4>&nbsp;<p class=\"one\">چوب یک ماده الیافی، آلی و نباتی است. دو ماده اصلی تشکیل دهنده آن عبارتند از: سلولز و لیگنین. طرز قرار گرفتن الیاف چوب به نوع درخت بستگی دارد. هر چوبی را نمی توان به صورت تخته درآورد و معمولاً تخته را از درخت های تولید کننده الوار می سازند. محصولات بسیار زیاد دیگری را نیز می توان از چوب ساخت. این محوصلات عبارتند از: خمیر سولز، کاغذ، الیاف زیان، پلاستیک، لاستیک، شکر، آهار و الکل.</p></div><div class=\"clearfix\">&nbsp;</div></div><div class=\"news-one-wthree-agile\"><div class=\"col-md-6 news-right\"><h4><a href=\"images_najarbashi/#three\">تقسیم بندی چوب ها</a></h4>&nbsp;<p class=\"one\">چوب را می توان بسته به كاربردهای گوناگون آن به دو گروه اصلی تقسیم كرد: الف-چوب طبیعی ب-چوب تبدیل شده هر یك از آنها هدف خاصی را بر آورده می كنند. مثلا برای بدست آوردن تیر و دیرك از گرده بینه استفاده می كنیم, برای تولید ورق از چوب بریده شده طبیعی سود می بریم. از نئوپان تبدیل شده می توان تخته , صفحه و قالب ساخت.ولی از همین چوب به شكل چهار گوش می توان قاب و چهار چوب ساخت.</p></div><div class=\"col-md-6 news-left\"><div class=\"biseller-column\"><a class=\"lightbox\" href=\"images_najarbashi/#three\"><img alt=\"\" src=\"images_najarbashi/img/n2.jpg\" /> </a><div class=\"lightbox-target\" id=\"three\"><img alt=\"\" src=\"images_najarbashi/img/n2.jpg\" /><p class=\"pop\">چوب را می توان بسته به كاربردهای گوناگون آن به دو گروه اصلی تقسیم كرد: الف-چوب طبیعی ب-چوب تبدیل شده هر یك از آنها هدف خاصی را بر آورده می كنند. مثلا برای بدست آوردن تیر و دیرك از گرده بینه استفاده می كنیم, برای تولید ورق از چوب بریده شده طبیعی سود می بریم. از نئوپان تبدیل شده می توان تخته , صفحه و قالب ساخت.ولی از همین چوب به شكل چهار گوش می توان قاب و چهار چوب ساخت</p><a class=\"lightbox-close\" href=\"images_najarbashi/#\"> </a><div class=\"clearfix\">&nbsp;</div></div></div></div><div class=\"clearfix\">&nbsp;</div></div><div class=\"news-one-wthree-agile\"><div class=\"col-md-6 news-left\"><div class=\"biseller-column\"><a class=\"lightbox\" href=\"images_najarbashi/#one\"><img alt=\"\" src=\"images_najarbashi/img/n3.jpg\" /> </a><div class=\"lightbox-target\" id=\"one\"><img alt=\"\" src=\"images_najarbashi/img/n3.jpg\" /><p class=\"pop\">چوب یک ماده الیافی، آلی و نباتی است. دو ماده اصلی تشکیل دهنده آن عبارتند از: سلولز و لیگنین. طرز قرار گرفتن الیاف چوب به نوع درخت بستگی دارد. هر چوبی را نمی توان به صورت تخته درآورد و معمولاً تخته را از درخت های تولید کننده الوار می سازند. محصولات بسیار زیاد دیگری را نیز می توان از چوب ساخت. این محوصلات عبارتند از: خمیر سولز، کاغذ، الیاف زیان، پلاستیک، لاستیک، شکر، آهار و الکل</p><a class=\"lightbox-close\" href=\"images_najarbashi/#\"> </a><div class=\"clearfix\">&nbsp;</div></div></div></div><div class=\"col-md-6 news-right\"><h4 dir=\"ltr\" style=\"text-align: right;\"><a href=\"images_najarbashi/#one\">MDF انواع </a></h4>&nbsp;<p class=\"one\">چوب یک ماده الیافی، آلی و نباتی است. دو ماده اصلی تشکیل دهنده آن عبارتند از: سلولز و لیگنین. طرز قرار گرفتن الیاف چوب به نوع درخت بستگی دارد. هر چوبی را نمی توان به صورت تخته درآورد و معمولاً تخته را از درخت های تولید کننده الوار می سازند. محصولات بسیار زیاد دیگری را نیز می توان از چوب ساخت. این محوصلات عبارتند از: خمیر سولز، کاغذ، الیاف زیان، پلاستیک، لاستیک، شکر، آهار و الکل.</p></div><div class=\"clearfix\">&nbsp;</div></div><!--    <div class=\"news-one-wthree-agile\"><div class=\"col-md-6 news-left\">  <div class=\"biseller-column\">    <a class=\"lightbox\" href=\"images_najarbashi/#two\"><img src=\"images_najarbashi/img/n3.jpg\" alt=\"\"/>    </a>     <div class=\"lightbox-target\" id=\"two\"><img src=\"images_najarbashi/img/n3.jpg\" alt=\"\"/><p class=\"pop\">  چوبی که از تنه درختان به دست می آید و به صورت تخته بریده می شود، بیشتر چوبی که در ساخت انواع اسباب و اثاثیه و تجهیزات (مبلمان) به کار می رود را تشکیل می دهد. نوع چوبی که ما انتخاب می کنیم زیبایی و استحکام وسیله ساخته شده را تعیین می کند. انواع زیادی از چوب ها در دسترس اند و هر کدام ویژگی های خاص خود را دارند</p><a class=\"lightbox-close\" href=\"images_najarbashi/#\"> </a><div class=\"clearfix\"> </div>    </div>  </div></div><div class=\"col-md-6 news-right\">   <a href=\"images_najarbashi/#two\"><h4> MDFانواع</h4></a>  <br>  <br>  <p class=\"one\">    چوبی که از تنه درختان به دست می آید و به صورت تخته بریده می شود، بیشتر چوبی که در ساخت انواع اسباب و اثاثیه و تجهیزات (مبلمان) به کار می رود را تشکیل می دهد. نوع چوبی که ما انتخاب می کنیم زیبایی و استحکام وسیله ساخته شده را تعیین می کند. انواع زیادی از چوب ها در دسترس اند و هر کدام ویژگی های خاص خود را دارند.  </p></div><div class=\"clearfix\"> </div>    </div>--></div></div></div>',0,1,1,''),
 (83,'سفارش خرید','<p style=\"font-family:Tahoma;font-size:10pt\">زمان تحویل بعد از تایید و پرداخت بین یک هفته تا 15 روز است و با تایید مشتری است.</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p><p style=\"font-family:Tahoma;font-size:10pt\">برای سفارش خرید در قسمت تماس با ما</p><p style=\"font-family:Tahoma;font-size:10pt\">یا شماره ی 03112683807 تماس حاصل فرمایید .</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p><p style=\"font-family:Tahoma;font-size:10pt\">&nbsp;</p>',0,1,1,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (84,'اطلاعات تماس','<p>آدرس دفتر مرکزی:</p><p>اصفهان،خیابان بزرگمهر، خیابان 22 بهمن، پلاک 171(ساختمان غدیر)، واحد210</p><p>تلفن: 2683807-0311</p><p>پست الکترونیکی: fioretech.ir@gmail.com</p>',0,1,1,NULL),
 (85,'درباره شرکت','<p>طراحی و تولید نرم افزار و تجهیزات صنایع مختلف<p/>                                <ul class=\"fbg_ul2\" style=\"direction: rtl\">                                    <li><a href=\"#\">سیستم های مانیتورینگ از راه دور</a></li>                                    <li><a href=\"#\">سیستم های کنترل هوشمند</a></li>                                    <li><a href=\"#\">سیستم های مدیریت هوشمند</a></li>                                </ul>',0,1,1,NULL),
 (87,'main page','<div class=\"center_content\"><div class=\"left_content\"><div class=\"title\"><span class=\"title_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/bullet0.png\" title=\"\" /></span> knowldge based products</div><div class=\"feat_prod_box\"><div class=\"prod_img\"><img alt=\"\" border=\"0\" src=\"images_siscovision/layout/images/prod1.gif\" title=\"\" /></div><div class=\"prod_det_box\"><div class=\"box_top\">&nbsp;</div><div class=\"box_center\"><div class=\"prod_title\">دستگاه تحلیل تصاویر میکروسکوپی متالوژی</div><p class=\"details\">با استفاده از تکنیک های پردازش تصویر،سطوح فلزات بررسی می شود.به دلیل دقت بسیار بالا در مقایسه با انواع خارجی دستگاه این دستگاه در مراکز صنعتی و نظامی در حال استفاده می باشد.</p><a class=\"more\" href=\"details.html\">- دریافت قیمت - </a><div class=\"clear\">&nbsp;</div></div><div class=\"box_bottom\">&nbsp;</div></div><div class=\"clear\">&nbsp;</div></div><div class=\"feat_prod_box\"><div class=\"prod_img\"><img alt=\"\" border=\"0\" src=\"images_siscovision/layout/images/prod2.gif\" title=\"\" /></div><div class=\"prod_det_box\"><div class=\"box_top\">&nbsp;</div><div class=\"box_center\"><div class=\"prod_title\">نرم افزار تشخیص بیماری های کولیت کلاژن و ملانوم</div><p class=\"details\">نرم افزار تشخیص بیماری های پاتولوژی کولیت کلاژن و ملانوم،با همکاری دانشگاه صنعتی اص فهان و بیمارستان الزهراو دانشگاه صنعتی اصفهان توسط محققان این شرکت اجرا شد. اکنون این محصول آماده عرضه به شایر مراکز درمانی و پزشکی می باشد.</p><a class=\"more\" href=\"details.html\">- دریافت قیمت - </a><div class=\"clear\">&nbsp;</div></div><div class=\"box_bottom\">&nbsp;</div></div><div class=\"clear\">&nbsp;</div></div><div class=\"feat_prod_box\"><div class=\"prod_img\"><img alt=\"\" border=\"0\" src=\"images_siscovision/layout/images/prod3.gif\" title=\"\" /></div><div class=\"prod_det_box\"><div class=\"box_top\">&nbsp;</div><div class=\"box_center\"><div class=\"prod_title\">نگهبان تردد</div><p class=\"details\">موارد استفاده: پارکینگ های عمومی، ادارات، پارکینگ های اختصاصی، پارکینگ مجتمع مسکونی، ورزشگاه ها و ... در این سیستم فقط به خودروهای از قبل مشخص شده اجازه تردد داده می شود. نگهبان هوشمند پارکینگ برمبنای تشخیص پلاک و تبدیل پلاک خودرو به حروف قابل تشخیص برای رایانه عمل می کند کلیه ملحقات و ملزومات در یک جعبه کوچک جاسازی شده اند. بنابراین با حداقل قیمت ممکن عرضه می شود</p><a class=\"more\" href=\"#\">- دریافت قیمت - </a><div class=\"clear\">&nbsp;</div></div><div class=\"box_bottom\">&nbsp;</div></div><div class=\"clear\">&nbsp;</div></div><div class=\"title\"><span class=\"title_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/bullet2.png\" title=\"\" /></span> فروش تین کلاینت و مینی پی سی</div><div class=\"new_products\"><div class=\"new_prod_box\"><a href=\"details.html\">Asus </a><div class=\"new_prod_bg\"><!--<span class=\"new_icon\"><img src=\"images_siscovision/layout/images/new_icon.gif\" alt=\"\" title=\"\"></span>--><a href=\"\"><img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/thumb1.gif\" title=\"\" /></a></div></div><div class=\"new_prod_box\"><a href=\"\"> Solmate </a><div class=\"new_prod_bg\"><!--<span class=\"new_icon\"><img src=\"images_siscovision/layout/images/new_icon.gif\" alt=\"\" title=\"\"></span>--><a href=\"\"><img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/thumb2.gif\" title=\"\" /></a></div></div><div class=\"new_prod_box\"><a href=\"details.html\">Minix </a><div class=\"new_prod_bg\"><!--<span class=\"new_icon\"><img src=\"images_siscovision/layout/images/new_icon.gif\" alt=\"\" title=\"\"></span>--><a href=\"#\"><img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/thumb3.gif\" title=\"\" /></a></div></div></div><div class=\"clear\">&nbsp;</div></div><!--end of left content--><div class=\"right_content\"><div class=\"cart\"><div class=\"title\"><span class=\"title_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/cart.gif\" title=\"\" /> </span> آموزش</div><div class=\"home_cart_content\"><!--3 x items | <span class=\"red\">TOTAL: 100$</span>--></div></div><div class=\"title\"><span class=\"title_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/bullet3.gif\" title=\"\" /></span> فروش محصولات بازرگانی</div><div class=\"about\"><p><img alt=\"\" class=\"right\" src=\"images_siscovision/layout/images/about.gif\" title=\"\" /> شرکت پژوهشگران سیستم های هوشمند سپانو در راستای ایجاد زیر ساخت های لازم برای ایجاد اتوماسیون های اداری و صنعتی اقدام به واردات برخی از محصولات سخت افزاری و الکترونیکی می نماید.</p><p>واردات این محصولات با توجه به چشم انداز علمی پیش رو می باشد. لذا در تامین نیاز مشتریان محترم با توجه به میزان تخصص بهترین محصولات را ارائه میکنیم.</p></div><div class=\"right_box\"><div class=\"title\"><span class=\"title_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/bullet4.gif\" title=\"\" /></span>Promotions</div><div class=\"new_prod_box\">Solmate-sasha 847<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/new_icon.gif\" title=\"\" /></span> <img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Solmate_sasha_847.png\" title=\"\" /></div></div><div class=\"new_prod_box\">EeeBox PC EB1006<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/new_icon.gif\" title=\"\" /></span> <img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/EeeBox_PC_EB1006.png\" title=\"\" /></div></div><div class=\"new_prod_box\">Origin Projector Q1<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/new_icon.gif\" title=\"\" /></span> <img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Origin_Projector_Q1.png\" title=\"\" /></div></div><div class=\"new_prod_box\">Giada Mini PC i33<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/new_icon.gif\" title=\"\" /></span> <img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Giada_Mini_PC_i33.png\" title=\"\" /></div></div></div><div class=\"right_box\"><div class=\"title\"><span class=\"title_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/bullet4.gif\" title=\"\" /></span>Promotions</div><div class=\"new_prod_box\">Origin Android PC Minix X5<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/new_icon.gif\" title=\"\" /></span> <img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Origin_Android_PC_Minix_X5.png\" title=\" Origin Android PC Minix X5\" /></div></div><div class=\"new_prod_box\">Origin WA7 Tablet 16GB<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/promo_icon.gif\" title=\"\" /></span> <img alt=\"Origin WA7 Tablet 16GB\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Origin_WA7_Tablet_16GB.png\" title=\"Origin WA7 Tablet 16GB\" /></div></div><div class=\"new_prod_box\">Origin Projector X2<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/promo_icon.gif\" title=\"\" /></span> <img alt=\"Origin Projector X2\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Origin_Projector_X2.png\" title=\"\" /></div></div><div class=\"new_prod_box\">Giada Mini Pc i35<div class=\"new_prod_bg\"><span class=\"new_icon\"><img alt=\"\" src=\"images_siscovision/layout/images/new_icon.gif\" title=\"\" /></span> <img alt=\"\" border=\"0\" class=\"thumb\" src=\"images_siscovision/layout/images/Giada_Mini_PC_i35.png\" title=\"\" /></div></div></div></div><!--end of right content--></div><p>&nbsp;</p>',68,2,1,NULL);
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (90,'منوی تصویر','<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 210px;float:left\"><tbody><tr><td><a href=\"http://www.siscovision.com\" onclick=\"sw(91);return false;\"><img alt=\"\" src=\"upload/f_15.jpg\" style=\"height: 100px; width: 100px;\" /></a></td><td><a href=\"http://www.siscovision.com\" onclick=\"sw(91);return false;\"><img alt=\"\" src=\"upload/f_13.jpg\" style=\"width: 100px; height: 100px;\" /></a></td></tr><tr><td><a href=\"http://www.siscovision.com\" onclick=\"sw(91);return false;\"><img alt=\"\" src=\"upload/f_14.jpg\" style=\"width: 100px; height: 100px;\" /></a></td><td><a href=\"http://www.siscovision.com\" onclick=\"sw(91);return false;\"><img alt=\"\" src=\"upload/f_12.jpg\" style=\"width: 100px; height: 100px;\" /></a></td></tr><tr></tr></tbody></table><p style=\"font-family:Tahoma;font-size:10pt\"><br />&nbsp;</p>',0,1,1,NULL),
 (93,'نمونه ایمیل','<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"center\" bgcolor=\"#555763\" style=\"background-color:#555763;\" valign=\"middle\"><p>&nbsp;</p><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" bgcolor=\"#171714\" style=\"background-color:#171714;\" valign=\"top\"><table align=\"center\" border=\"0\" cellpadding=\"15\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#71A4BE; font-family:Arial, Helvetica, sans-serif; font-size:36px; font-weight:normal;\" valign=\"middle\">Newsletter Title</td></tr></tbody></table></td></tr><tr><td align=\"left\" valign=\"top\"><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" bgcolor=\"#71A4BE\" style=\"background-color:#71A4BE;\" valign=\"top\"><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" style=\"margin-bottom:10px;\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; font-size:12px;\" valign=\"top\" width=\"100%\"><div align=\"justify\">Dear User Name,<br />Morbi feugiat. Etiam ut elit ac metus facilisis fermentum. Curabitur magna magna elementum fermentum placerat vel commodo vel tortor. Sed justo. Ut a orci ut arcu molestie pretium. Donec a mauris. Nullam vitae urna. Integer suscipit hendrerit magna.<br /><br />Donec ac arcu a diam auctor imperdiet. In non pede at est faucibus rhoncus. Vestibulum hendrerit tortor at sapien iaculis condimentum. Etiam nec dolor quis pede blandit semper. Praesent pretium fermentum massa. Etiam euismod volutpat lacus. In ligula. Proin vel ipsum pellentesque leo tincidunt fringilla. Sed porta molestie justo. Sed blandit. Mauris sapien. Proin placerat commodo leo. In bibendum faucibus tellus. Vestibulum odio. Class aptent taciti sociosqu ad litora torquent per conubia nostra per inceptos hymenaeos.</div></td></tr></tbody></table><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" style=\"margin-bottom:10px;\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#000000; font-family:Arial, Helvetica, sans-serif; font-size:18px;\" valign=\"top\" width=\"100%\"><b>Shows This Week</b></td></tr></tbody></table><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" style=\"margin-bottom:10px;\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#ffffff; font-family:Arial, Helvetica, sans-serif; font-size:13px;\" valign=\"top\" width=\"100%\"><img align=\"left\" height=\"95\" src=\"images/image1.jpg\" style=\"margin-right:15px;\" width=\"143\" /><div><b>Saturday April 10: </b></div><div style=\"font-size:18px;\">Enter Event Name Here From 7-9 pm</div><div style=\"font-size:14px;\">First 100 People in are FREE! General Admission $8, College Students $5</div></td></tr></tbody></table><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" style=\"margin-bottom:10px;\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#ffffff; font-family:Arial, Helvetica, sans-serif; font-size:13px;\" valign=\"top\" width=\"100%\"><img align=\"left\" height=\"96\" src=\"images/image2.jpg\" style=\"margin-right:15px;\" width=\"144\" /><div><b>Saturday April 10: </b></div><div style=\"font-size:18px;\">Enter Event Name Here From 7-9 pm</div><div style=\"font-size:14px;\">First 100 People in are FREE! General Admission $8, College Students $5</div></td></tr></tbody></table><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" style=\"margin-bottom:10px;\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#ffffff; font-family:Arial, Helvetica, sans-serif; font-size:13px;\" valign=\"top\" width=\"100%\"><img align=\"left\" height=\"95\" src=\"images/image1.jpg\" style=\"margin-right:15px;\" width=\"143\" /><div><b>Saturday April 10: </b></div><div style=\"font-size:18px;\">Enter Event Name Here From 7-9 pm</div><div style=\"font-size:14px;\">First 100 People in are FREE! General Admission $8, College Students $5</div></td></tr></tbody></table></td><td align=\"left\" bgcolor=\"#171714\" style=\"background-color:#171714;\" valign=\"top\" width=\"175\"><table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#D27E00; font-family:Arial, Helvetica, sans-serif; font-size:16px;\" valign=\"top\"><b>Upcoming Events</b></td></tr><tr><td align=\"left\" style=\"font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:11px;\" valign=\"top\"><div style=\"color:#71A4BE;\"><b>Mimas bibendum viverra massa.</b></div><b>May 1, 2009 </b><br />Mimas bibendum viverra massa. Integer nulla urna porttitor eget aliquam vel placerat feugiat orci. Phasellus tellus pede pulvinar et scelerisque.<br /><br /><div style=\"color:#71A4BE;\"><b>Mimas bibendum viverra massa.</b></div><b>May 1, 2009 </b><br />Mimas bibendum viverra massa. Integer nulla urna porttitor eget aliquam vel placerat feugiat orci. Phasellus tellus pede pulvinar et scelerisque.<br /><br /><div style=\"color:#71A4BE;\"><b>Mimas bibendum viverra massa.</b></div><b>May 1, 2009 </b><br />Mimas bibendum viverra massa. Integer nulla urna porttitor eget aliquam vel placerat feugiat orci. Phasellus tellus pede pulvinar et scelerisque.<br /><br />&nbsp;</td></tr></tbody></table><table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"color:#D27E00; font-family:Arial, Helvetica, sans-serif; font-size:16px;\" valign=\"top\"><b>Entertainment News</b></td></tr><tr><td align=\"left\" style=\"font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:11px;\" valign=\"top\"><div style=\"color:#71A4BE;\"><b>5/1/2009</b></div>Lorem ipsum dolor sit amet consectetuer adipiscing elit.<br /><br /><div style=\"color:#71A4BE;\"><b>5/1/2009</b></div>Lorem ipsum dolor sit amet consectetuer adipiscing elit.<br /><br /><div style=\"color:#71A4BE;\"><b>5/1/2009</b></div>Lorem ipsum dolor sit amet consectetuer adipiscing elit.<br />&nbsp;</td></tr></tbody></table><table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" style=\"font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px;\" valign=\"top\"><b>Company Name </b><br />Enter company address here<br /><b>Phone:</b> (000) 123 4567<br />&nbsp;</td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td align=\"left\" bgcolor=\"#D27E00\" style=\"background-color:#D27E00;\" valign=\"top\"><table align=\"center\" border=\"0\" cellpadding=\"15\" cellspacing=\"0\" width=\"600\"><tbody><tr><td style=\"font-family:Arial, Helvetica, sans-serif; color:#000000;\"><div style=\"font-size:19px;\">A thrilling musical party</div><div style=\"font-size:11px;\">Lorem ipsum ne mea postea minimum accusata, tritani voluptua reprimique per ne, id eam essent efficiendi instructior. Mea elit oportere dissentiunt ne, labore splendide ex eum. Vix porro repudiare evertitur in, natum utinam senserit et est. In per vitae malorum feugait, justo invidunt adolescens cu est, saepe phaedrum deterruisset sed ad. No vis justo perfecto interesset, nam wisi postulant forensibus an, id vis quem mucius mediocrem.<br />&nbsp;</div><div style=\"font-size:11px;\"><b>NEXT SUNDAY, May 5, 4-10 pm @ The Opera House</b><br />&nbsp;</div><div><a href=\"#\" style=\"color:#FFFFFF; font-size:14px;\"><b>GET YOUR TICKETS NOW</b></a></div></td></tr></tbody></table></td></tr></tbody></table><br />&nbsp;</td></tr></tbody></table><p>&nbsp;</p>',0,1,1,NULL);
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (94,'فعالیت ها','<div style=\"width: 98%;margin: 0 auto\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin: 0px; padding: 0px;\" width=\"100%\"><tbody><tr><td><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-top: 5px solid #1c1c1c; border-bottom: 1px solid #cccccc; ; margin:0 auto; padding: 0;\" width=\"100%\"><tbody><tr><td style=\"margin: 0px; padding: 5px; line-height: 16px; text-align: center; vertical-align: top; background-image: url(http://www.u4m.ir/images/22465780148769081411.jpg)\"><h2 style=\"font-family: Arial,Helvetica,sans-serif; font-size: 13px; margin: 0px; padding: 0px; color: rgb(111, 111, 111);\">&nbsp;</h2></td></tr></tbody></table></td></tr><tr><td style=\"margin: 0; padding: 0; line-height: 0\"><img height=\"5\" src=\"./architecture3_files/1.gif\" width=\"1\" /></td></tr><tr><td style=\"margin: 0px auto; padding: 0px;\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0; margin:0 auto;\" width=\"100%\"><tbody><tr><td style=\"; padding: 0\" valign=\"top\" width=\"30%\"><!-- bof LOGO --><p style=\"padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; margin-left: 0px; font-family: &quot;Arial&quot;, &quot;Helvetica&quot;, sans-serif; font-size: 36px; line-height: 42px; background-color: rgb(28, 28, 28); border-top-color: rgb(28, 28, 28); border-left-color: rgb(28, 28, 28); border-right-color: rgb(28, 28, 28); border-bottom-color: rgb(28, 28, 28); border-top-width: 5px; border-left-width: 5px; border-right-width: 5px; border-bottom-width: 5px; border-top-style: solid; border-left-style: solid; border-right-style: solid; border-bottom-style: solid; color: rgb(255, 255, 255); text-align: left;\">Fiore - Giada</p><!-- eof LOGO --><!-- bof MENU --><p>&nbsp;</p><br /><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%\" width=\"170\"><tbody><tr><td align=\"center\" style=\"margin: 0; padding:0\"><img src=\"upload/p6483457653.png\" style=\"border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; border-top-style: solid; border-right-style: solid; border-bottom-style: solid; border-left-style: solid; width: 225px; height: 225px;\" /></td></tr><tr><td style=\"margin:0; padding: 5px 0; line-height: 16px\"><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; margin:0; padding:0; color:#6f6f6f;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\"><strong>فعالیت های این شرکت در حوزه های :</strong></p><ul><li style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">بازرگانی تجهیزات الکترونیک و رایانه های کوچک سازی شده صنعتی</li><li style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">فروش و خدمات &nbsp;پس از فروش محصولات جیادا و فیوره</li><li style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">طراحی اتوماسیون های اداری و صنعتی با استفاده از بستر نانو پی سی</li></ul><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\">&nbsp;</p><p style=\"font-family: &quot;Tahoma&quot;; font-size: 10pt;\"><img alt=\"\" src=\"upload/p1068124437.png\" style=\"width: 100%;\" /></p><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; margin:0; padding:0; color:#6f6f6f;\">&nbsp;</p></td></tr></tbody></table></td><td style=\"margin:0; padding: 0\"><img border=\"0\" src=\"./architecture3_files/1.gif\" width=\"5\" /></td><td style=\"margin: 0; padding: 0\" valign=\"top\" width=\"70%\"><!-- bof BANNER --><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr style=\"margin:0; padding:0\" valign=\"top\"><td style=\"margin: 0; padding: 0; line-height: 0\" valign=\"top\">&nbsp;</td></tr><tr><td style=\"margin:0; padding:5px; background-color:#1c1c1c; text-align: left\" valign=\"top\"><p style=\"font-family: Arial,Helvetica,sans-serif; font-size: 13px; line-height: 16px; color: rgb(255, 255, 255); text-align: right;\">&nbsp;</p></td></tr></tbody></table><!-- eof BANNER --><!-- bof HIGHLIGHTS --><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td style=\"margin:0; padding: 5px; \" valign=\"top\"><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #1c1c1c; font-weight:bold;\">شرکت سیستم های هوشمند سپانو، به عنوان یک شرکت دانش بنیان مستقر در شهرک علمی تحقیقاتی اصفهان &nbsp;تبدیل دانش به محصولات تجاری را مبنای عملکرد خود قرار داده است.</p><h1 style=\"text-align: center;\"><span style=\"font-size:20px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><strong>امور بازرگانی</strong></span></span></h1><p><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">در راستای تامین نیاز صنایع و متخصصان کشور اقدام به فروش و خدمات پس از فروش مینی پی سی های فیوره-جیادا نموده ایم.</span></span></p><ul><li><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">&nbsp;فروش کامپیوترهای کوچک ( Mini PC )</span></span></li><li><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">فروش تین کلاینت ( Thin Client )</span></span></li><li><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">گارانتی و خدمات پس از فروش محصولات جیادا - فیوره</span></span></li><li><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">نمایندگی انحصاری محصولات فیوره</span></span></li></ul></td><td style=\"margin:0; padding: 5px 0\" valign=\"top\"><span style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><img alt=\"دانش بینان\" src=\"upload/p2587279705.png\" style=\"border-width: 0px; border-style: solid; width: 150px; height: 150px;\" /></span></td></tr></tbody></table><hr style=\"height:1px; background: #6f6f6f; margin:0; padding:0; border: 0\" /><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td style=\"margin:0; padding: 5px; \" valign=\"top\"><h1 style=\"margin: 0px 0px 10px; padding: 0px; font-family: Arial,Helvetica,sans-serif; font-size: 13px; line-height: 16px; color: rgb(28, 28, 28); font-weight: bold; text-align: center;\"><span style=\"font-size:20px;\"><strong><span style=\"font-family: tahoma,geneva,sans-serif;\">اتوماسیون Fiore</span></strong></span></h1><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">در طراحی سیستم &nbsp;هوشمند دانش بنیان فیوره، حجم اطلاعات بالا، نیاز به عملکرد &nbsp;Realtime در انتقال تصاویر و تصمیم گیری، قابلیت اجرا روی پلتفرم های مختلف مثل Android devices, PC, &nbsp;Server, Client و ... و همچنین عدم وجود چنین سیستمی با قابلیت های مذکور ما را برآن داشت تا برای تولید یک سیستم با این مشخصات اقدام کنیم.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">سیستم اتوماسیون انحصاری فیوره (Fiore Aoutomation) که برای غلبه بر مشکلات فنی موجود در ساخت طرح ایده محوری این شرکت ایجاد شده یک پایه و زیر ساخت مناسب برای ایجاد انواع اتوماسیون های صنعتی و حتی اداری شده است.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">این سیستم به دو بخش نرم افزاری و سخت افزاری تقسیم می شود، در این سامانه تمام ظرفیت تکنولوژی های زیر استفاده شده است:</span></span></p><h3 style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">سیستم پردازش تصویر</span></span></h3><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">پردازش تصویر : اساس و شالوده کار سیستم اتوماسیون صنعتی ما بر مبنای پردازش تصویر است.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">پردازش صوت : &nbsp;پردازش صوت برای دریافت تغییرات محیطی و حفاظت دقیق تر محیط قابل استفاده است.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">پردازش سیگنال دیجیتال : سیگنال خروجی از سنسورها توسط این ماژول پردازش می شود که با توجه به نوع سنسور پردازش متفاوت انجام می گیرد.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\">&nbsp;</p><h3 style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">سیستم اتوماسیون صنعتی</span></span></h3><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">کنترل گلخانه ها</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">کنترل مزارع پرورش ماهی</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">کنترل دستگاه ها و زمانبندی و...</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">برای ایجاد این اتوماسیون ها می توانید با کارشناسان خبره ما مشورت کنید.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\">&nbsp;</p><h3 style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">سیستم نرم افزار تحت وب</span></span></h3><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">JAVA Web :برنامه های تحت وب با زبان برنامه نویس جاوا، در زمان اجرا بعلت وجود JRE روی رم سیستم قرار می گیرند و به همین دلیل از سرعت اجرای بالاتری نسبت به برنامه ها به زبان های برنامه نویسی دیگر برخوردارند، همچنین منبع باز هستند و برنامه نویس کاملا با روند اجرا و نحوه تعامل با سیستم اطلاع دقیق حاصل و از اتلاف منابع سیستم جلوگیری می کند، لذا در نهایت برنامه تحت وب بهینه خواهد بود.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">SOAP &amp; EJB : تکنولوژی ای که برای برنامه نویسی Real Time استفاده می شود و حتی گفته می شود در سازمان هوایی امریکا برای کنترل پرتاب موشک ها از این تکنولوژی استفاده شده است.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">در سیستم اتوماسیون فیوره برای دسترسی به حداکثر سرعت انتقال داده ها، از این تکنولوژی استفاده می شود.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">&nbsp;Ajax,Jquery : برای ایجاد &nbsp;یک محیط زیبا و کاربر پسند از Jquery , برای به حداقل رساندن سربار تراکنش های میان کلاینت و سرور از Ajax استفاده شده است. همانطور که می دانیم غولهای انفورماتیک دنیا مثل گوگل، یاهو، AOL و... از این تکنولوژی در ارائه مهمترین سرویس های خود استفاده می کنند.</span></span></p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">CSS3 &amp; HTML5</span></span></p><h1 style=\"text-align: center;\"><span style=\"font-size:20px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><strong>پروژه های دانش بنیان</strong></span></span></h1><p><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\"><strong>&nbsp;&nbsp;&nbsp; پروژه های دانش بنیانی که منجر به بومی سازی شدن تکنولوژی در ایران شده است</strong></span></span>:</p><ul style=\"padding-right:20px;margin-right:20px\"><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">سیستم مدیریت هوشمند تولید ، انبار و فروش کارخانجات دارای خط تولید ریلی</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">تشخیص و تعیین محل تخلیه جزیی در ترانسفورمرهای قدرت با روش آنالیز صوت، مجتمع فولاد مبارکه</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">پروژه بازرسی اتوماتیک سطح تختال با استفاده از تکنیک های پردازش دیجیتال تصویر، مجتمع فولاد مبارکه</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">پروژه تحقیقاتی نرم افزار تشخیص بیماری های پاتولوژی کولیت کلاژن و ملانوم،&nbsp; دانشگاه صنعتی اصفهان و بیمارستان الزهرا</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">نرم افزار تحلیل نقشه های عمرانی، به سفارش شرکت پارس جویاب</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">نرم افزار تحلیل تصاویر میکروسکوپی متالوژی با استفاده از تکنیک های پردازش تصویر،امنیتی و نظامی</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">ساخت فرستنده گیرنده فرکانس دیجیتال، به سفارش شرکت کاوشگران انرژی های نو</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">تعیین محل های مناسب برای فرود اضطراری هواپیماهای بدون سرنشین با استفاده از بینایی ماشین، شهرک علمی تحقیقاتی اصفهان</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">طراحی <span dir=\"LTR\">CMS</span> اختصاصی مگاتیک</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">ثبت اختراع آیفون تصویری هوشمند</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">ثبت اختراع هشدار دهنده خودرو</span></span></li><li dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family: tahoma,geneva,sans-serif;\">ثبت اختراعات و ارائه مقالات متنوع در مجلات و کنفرانس&zwnj;های معتبر بین&zwnj;المللی</span></span></li></ul><p style=\"margin: 0; padding: 0;font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f; text-align:right\">&nbsp;</p></td><td style=\"margin:0; padding: 5px 0\" valign=\"top\"><img alt=\"aoutomaiton\" src=\"upload/p3964430355.png\" style=\"border-width: 0px; border-style: solid; width: 150px; height: 150px;\" /></td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td style=\"margin: 0; padding: 0; line-height: 0\"><img height=\"5\" src=\"./architecture3_files/1.gif\" width=\"1\" /></td></tr><tr><td style=\"margin: 0 auto; padding: 0; line-height: 0\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin: 0 auto; padding: 0; line-height: 0\" width=\"100%\"><tbody><tr><td><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; margin:0; padding:0; text-align:center; border-top: 1px solid #6f6f6f; padding: 10px;  color: #6f6f6f\">برای کسب اطلاعات بیشتر و تهیه مینی پی سی ها در قسمت <a class=\"mousePointer jjLink\" href=\"Server?do=Content.sw&amp;text=14\" onclick=\"sw(14);return false;\">تماس با ما</a> پیام خود را مرقوم بفرمایید.</p></td></tr><tr><td align=\"center\"><!-- bof SOCIAL --><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\"><tbody><tr><td style=\" padding-right:7px;\"><img src=\"upload/f_14.jpg\" style=\"border-width: 0px; border-style: solid; margin: 0px; width: 200px; height: 141px;\" /></td><td style=\" padding-right:7px;\"><img src=\"upload/f_15.jpg\" style=\"border-width: 0px; border-style: solid; margin: 0px; width: 200px; height: 200px;\" /></td><td style=\" padding-right:7px;\"><img src=\"upload/f_13.jpg\" style=\"border-width: 0px; border-style: solid; margin: 0px; width: 200px; height: 142px;\" /></td><td style=\" padding-right:0px;\"><img src=\"upload/f_12.jpg\" style=\"border-width: 0px; border-style: solid; margin: 0px; width: 200px; height: 142px;\" /></td></tr></tbody></table><!-- eof SOCIAL --></td></tr><tr><td align=\"center\" style=\"background: #1c1c1c; margin: 0; padding: 10px 20px\" valign=\"top\"><p style=\"color: #ffffff; font-size:13px; line-height: 16px; font-family:Verdana, Arial, Helvetica, sans-serif\">مطمئن باشید ، ما با شما هستیم و با شما می مانیم</p></td></tr></tbody></table></td></tr></tbody></table></div><p>&nbsp;</p>',0,1,1,NULL),
 (96,'پنل اطلاعات پایین','<div class=\"footer-left\"><h3>نجار <span> باشی</span></h3><p class=\"footer-links\">سفارش خرید &middot;&nbsp; تماس با ما&middot; صفحه اصلی</p><p class=\"footer-company-name\">نجارباشی &copy; 2015</p></div><div class=\"footer-center\"><div><p><span>21 Revolution Street</span> Esfahan, abshar</p></div><div><p>0313-3662256</p></div><div><p><a href=\"images_najarbashi/#\">najarbashi.com</a></p></div></div><div class=\"footer-right\"><div><p class=\"footer-company-about\" style=\"text-align: center;\">درباره ی ما</p><ol><li class=\"footer-company-about\">بازدید رایگان از مکان</li><li class=\"footer-company-about\">تهیه ی نقشه ی تری دی مکس از مکان</li><li class=\"footer-company-about\">پیاده سازی دیزاین مطابق با اخرین مد روز با توجه به سلیقه ی مشتری</li></ol><div class=\"footer-icons\">&nbsp;</div></div></div>',0,1,1,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (97,'درباره ما','<div style=\"width: 100%\"><div style=\" alignment-adjust: central  ;border:0px; cellpadding:0px; cellspacing:0px;width:240px;\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"240\"><tbody><tr><td align=\"center\" bgcolor=\"#f6d14e\" height=\"31\" new=\"\" roman=\"\" style=\"font-family:Georgia, \" times=\"\">نجار باشی</td></tr></tbody></table><p>&nbsp;</p><p>&nbsp;</p><p>نجار باشی با سابقه ی 5 ساله و&nbsp;کوله باری از تجربه عزم خود را جزم کرده تا در راستای درخواست و رضایت مشتری روز به روز تلقی حاصل نماید..</p>;پیشنهاد میشود کاتالوگ کارهای موجود را مشاهده کنید...<p>&nbsp;</p>شعار این شرکت همواره جلب نظر مشتری و پیاده سازی&nbsp; سلایق مطابق با اخرین جلوه های مد می باشد...<p>&nbsp;</p><p>&nbsp;</p><p>به امید زندگی بهتر.....</p><div style=\"border:0; cellpadding:0; cellspacing:0 ;width:100%\"><div style=\" align=left ;valign:top ;width:25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p2939500791.jpg\" style=\"display: block; width: 241px; margin:6px -106px; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div><div align=\"center\" valign=\"top\" width=\"25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p9194607129.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div></div><div align=\"center\" valign=\"top\" width=\"25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p9597474142.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div></div><div align=\"right\" valign=\"top\" width=\"25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p1805562761.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div><p>&nbsp;</p><div>&nbsp;</div><div><br /><br />&nbsp;</div><p><br />&nbsp;</p></div>',0,1,1,''),
 (98,'تمپلیت جدید 2','<div class=\"block\"><!-- Start of preheader --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"preheader\" width=\"100%\"><tbody><tr><td width=\"100%\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"580\"><tbody><!-- Spacing --><tr><td height=\"5\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td align=\"right\" st-content=\"preheader\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 10px;color: #999999\" valign=\"middle\">If you cannot read this email, please <a class=\"hlite\" href=\"#\" style=\"text-decoration: none; color: #0db9ea\">click here</a></td></tr><!-- Spacing --><tr><td height=\"5\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table><!-- End of preheader --></div><div class=\"block\"><!-- start of header --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"header\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#0db9ea\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" hlitebg=\"edit\" shadow=\"edit\" width=\"90%\"><tbody><tr><td><!-- logo --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"90%\"><tbody><tr><td class=\"logo\" style=\"padding: 10px 0 10px 20px;\" valign=\"middle\" width=\"100%\"><div class=\"imgpop\"><a href=\"#\"><img alt=\"logo\" border=\"0\" class=\"logo\" src=\"img/logo.png\" st-image=\"edit\" style=\"display:block; border:none; outline:none; text-decoration:none;\" /> </a></div></td></tr></tbody></table><!-- End of logo --><!-- menu --><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"100%\"><tbody><tr><td align=\"right\" class=\"menu\" st-content=\"menu\" style=\"font-family: Helvetica, Arial, sans-serif;font-size: 14px; color: #ffffff;line-height: 24px; padding: 10px 0;\" valign=\"middle\" width=\"270\"><a href=\"#\" style=\"text-decoration: none; color: #ffffff;\">HOME</a> &nbsp;|&nbsp; <a href=\"#\" style=\"text-decoration: none; color: #ffffff;\">ABOUT</a> &nbsp;|&nbsp; <a href=\"#\" style=\"text-decoration: none; color: #ffffff;\">SHOP</a></td><td width=\"20\">&nbsp;</td></tr></tbody></table><!-- End of Menu --></td></tr></tbody></table></td></tr></tbody></table><!-- end of header --></div><div class=\"block\"><!-- image + text --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"bigimage\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"100%\"><tbody><tr><!-- start of image --><td align=\"center\"><a href=\"#\" target=\"_blank\"><img alt=\"\" border=\"0\" class=\"bigimage\" height=\"282\" src=\"img/bigimage.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"540\" /> </a></td></tr><!-- end of image --><!-- Spacing --><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- title --><tr><td st-title=\"rightimage-title\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content --><tr><td st-content=\"rightimage-paragraph\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 24px;\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"10\" width=\"100%\">&nbsp;</td></tr><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --><!-- Spacing --><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table></td></tr></tbody></table></div><div class=\"block\"><!-- start textbox-with-title --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"fulltext\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><!-- Spacing --><tr><td height=\"30\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"90%\"><tbody><!-- Title --><tr><td st-title=\"fulltext-title\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:center;line-height: 20px;\">NICE HEADING HERE</td></tr><!-- End of Title --><!-- spacing --><tr><td height=\"5\">&nbsp;</td></tr><!-- End of spacing --><!-- content --><tr><td st-content=\"fulltext-paragraph\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 14px; color: #95a5a6; text-align:center;line-height: 30px;\">Lorem ipsum dolor sit amet</td></tr><!-- End of content --><!-- Spacing --><tr><td height=\"10\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- button --><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"36\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"36\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:25px; padding-right:25px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Download</a> </span></td></tr></tbody></table></td></tr><!-- /button --><!-- Spacing --><tr><td height=\"30\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table></td></tr></tbody></table><!-- end of textbox-with-title --></div><div class=\"block\"><!-- start of left image --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"leftimage\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><!-- Spacing --><tr><td height=\"20\">&nbsp;</td></tr><!-- Spacing --><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"90%\"><tbody><tr><td><!-- start of text content table --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"20%\"><tbody><!-- image --><tr><td align=\"center\" height=\"180\" width=\"200\"><img alt=\"\" border=\"0\" height=\"180\" src=\"img/left-image.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"180\" /></td></tr></tbody></table><!-- mobile spacing --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mobilespacing\"><tbody><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr></tbody></table><!-- mobile spacing --><!-- start of right column --><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"78%\"><tbody><!-- title --><tr><td st-title=\"leftimage-title\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content --><tr><td st-content=\"leftimage-paragraph\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 24px;\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"10\" width=\"100%\">&nbsp;</td></tr><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table><!-- end of right column --></td></tr></tbody></table></td></tr><!-- Spacing --><tr><td height=\"20\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table><!-- end of left image --></div><div class=\"block\"><!-- start of left image --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"rightimage\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"100%\"><tbody><!-- Spacing --><tr><td height=\"20\">&nbsp;</td></tr><!-- Spacing --><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"540\"><tbody><tr><td><!-- start of text content table --><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"200\"><tbody><!-- image --><tr><td align=\"center\" height=\"180\" width=\"200\"><img alt=\"\" border=\"0\" height=\"180\" src=\"img/right-image.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"180\" /></td></tr></tbody></table><!-- mobile spacing --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mobilespacing\"><tbody><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr></tbody></table><!-- mobile spacing --><!-- start of right column --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"330\"><tbody><!-- title --><tr><td st-title=\"rightimage-title\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content --><tr><td st-content=\"rightimage-paragraph\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 24px;\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"10\" width=\"100%\">&nbsp;</td></tr><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table><!-- end of right column --></td></tr></tbody></table></td></tr><!-- Spacing --><tr><td height=\"20\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table><!-- end of left image --></div><div class=\"block\"><!-- fulltext --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"fulltext\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><!-- Spacing --><tr><td height=\"30\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"100%\"><tbody><!-- Title --><tr><td st-title=\"fulltext-title\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:center;line-height: 20px;\">NICE HEADING HERE</td></tr><!-- End of Title --><!-- spacing --><tr><td height=\"5\">&nbsp;</td></tr><!-- End of spacing --><!-- content --><tr><td st-content=\"fulltext-paragraph\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 14px; color: #95a5a6; text-align:center;line-height: 30px;\">Lorem ipsum dolor sit amet</td></tr><!-- End of content --><!-- Spacing --><tr><td height=\"30\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table></td></tr></tbody></table><!-- end of fulltext --></div><div class=\"block\"><!-- Start of 2-columns --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"2columns\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"100%\"><tbody><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"30%\"><tbody><!-- image --><tr><td align=\"center\" class=\"devicewidth\" height=\"140\" width=\"260\"><img alt=\"\" border=\"0\" class=\"col2img\" height=\"140\" src=\"img/2col-image1.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"260\" /></td></tr><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"260\"><tbody><!-- title --><tr><td st-title=\"2col-title1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- /Spacing --><!-- content --><tr><td st-content=\"2col-para1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempam et justo duo dolores et ea rebum.</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- /Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table><!-- end of left column --><!-- spacing for mobile devices--><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"30%\"><tbody><!-- image --><tr><td align=\"center\" class=\"devicewidth\" height=\"140\" width=\"260\"><img alt=\"\" border=\"0\" class=\"col2img\" height=\"140\" src=\"img/2col-image1.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"260\" /></td></tr><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"260\"><tbody><!-- title --><tr><td st-title=\"2col-title1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- /Spacing --><!-- content --><tr><td st-content=\"2col-para1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempam et justo duo dolores et ea rebum.</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- /Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table><!-- end of for mobile devices--><!-- start of right column --><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"30%\"><tbody><!-- image --><tr><td align=\"center\" class=\"devicewidth\" height=\"140\" width=\"260\"><img alt=\"\" border=\"0\" class=\"col2img\" height=\"140\" src=\"img/2col-image2.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"260\" /></td></tr><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"260\"><tbody><!-- title --><tr><td st-title=\"2col-title2\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- /Spacing --><!-- content --><tr><td st-content=\"2col-para2\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempam et justo duo dolores et ea rebum.</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- /Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table><!-- end of right column --></td></tr></tbody></table></td></tr><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr></tbody></table></td></tr></tbody></table><!-- End of 2-columns --></div><div class=\"block\"><!-- 3-columns --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"3columns\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"100%\"><tbody><tr><td><!-- col 1 --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"24%\"><tbody><!-- image 2 --><tr><td align=\"center\" class=\"devicewidth\" width=\"90%\"><img alt=\"\" border=\"0\" class=\"col3img\" src=\"img/3col-image.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"100%\" /></td></tr><!-- end of image2 --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"100%\"><tbody><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- title2 --><tr><td st-title=\"3col-title1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">Lorem Ipsum</td></tr><!-- end of title2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content2 --><tr><td st-content=\"3col-para1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</td></tr><!-- end of content2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px; border-top-right-radius:4px; border-bottom-right-radius:4px;background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table><!-- spacing --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"removeMobile\" width=\"1%\"><tbody><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr></tbody></table><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"24%\"><tbody><!-- image 2 --><tr><td align=\"center\" class=\"devicewidth\" width=\"90%\"><img alt=\"\" border=\"0\" class=\"col3img\" src=\"img/3col-image.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"100%\" /></td></tr><!-- end of image2 --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"100%\"><tbody><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- title2 --><tr><td st-title=\"3col-title1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">Lorem Ipsum</td></tr><!-- end of title2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content2 --><tr><td st-content=\"3col-para1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</td></tr><!-- end of content2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px; border-top-right-radius:4px; border-bottom-right-radius:4px;background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"removeMobile\" width=\"1%\"><tbody><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr></tbody></table><!-- end of spacing --><!-- col 2 --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"24%\"><tbody><!-- image 2 --><tr><td align=\"center\" class=\"devicewidth\" width=\"90%\"><img alt=\"\" border=\"0\" class=\"col3img\" src=\"img/3col-image.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"100%\" /></td></tr><!-- end of image2 --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"100%\"><tbody><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- title2 --><tr><td st-title=\"3col-title1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">Lorem Ipsum</td></tr><!-- end of title2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content2 --><tr><td st-content=\"3col-para1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</td></tr><!-- end of content2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px; border-top-right-radius:4px; border-bottom-right-radius:4px;background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table><!-- end of col 2 --><!-- spacing --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"removeMobile\" width=\"1%\"><tbody><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr></tbody></table><!-- end of spacing --><!-- col 3 --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"24%\"><tbody><!-- image 2 --><tr><td align=\"center\" class=\"devicewidth\" width=\"90%\"><img alt=\"\" border=\"0\" class=\"col3img\" src=\"img/3col-image.png\" style=\"display:block; border:none; outline:none; text-decoration:none;\" width=\"100%\" /></td></tr><!-- end of image2 --><tr><td><!-- start of text content table --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"100%\"><tbody><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- title2 --><tr><td st-title=\"3col-title1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">Lorem Ipsum</td></tr><!-- end of title2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content2 --><tr><td st-content=\"3col-para1\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #95a5a6; text-align:left;line-height: 20px;\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</td></tr><!-- end of content2 --><!-- Spacing --><tr><td height=\"15\" style=\"font-size:1px; line-height:1px; mso-line-height-rule: exactly;\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px; border-top-right-radius:4px; border-bottom-right-radius:4px;background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --></tbody></table></td></tr><!-- end of text content table --></tbody></table></td><!-- spacing --><!-- end of spacing --></tr></tbody></table></td></tr><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr></tbody></table></td></tr></tbody></table><!-- end of 3-columns --></div><div class=\"block\"><!-- Full + text --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"fullimage\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" modulebg=\"edit\" width=\"90%\"><tbody><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidthinner\" width=\"540\"><tbody><!-- title --><tr><td st-title=\"rightimage-title\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 18px; color: #333333; text-align:left;line-height: 20px;\">LOREM IPSUM</td></tr><!-- end of title --><!-- Spacing --><tr><td height=\"10\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><!-- content --><tr><td st-content=\"rightimage-paragraph\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 13px; color: #666666; text-align:left;line-height: 24px;\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</td></tr><!-- end of content --><!-- Spacing --><tr><td height=\"10\" width=\"100%\">&nbsp;</td></tr><!-- button --><tr><td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablet-button\" height=\"30\" st-button=\"edit\" valign=\"middle\"><tbody><tr><td align=\"center\" height=\"30\" style=\" background-color:#0db9ea; border-top-left-radius:4px; border-bottom-left-radius:4px;border-top-right-radius:4px; border-bottom-right-radius:4px; background-clip: padding-box;font-size:13px; font-family:Helvetica, arial, sans-serif; text-align:center;  color:#ffffff; font-weight: 300; padding-left:18px; padding-right:18px;\" valign=\"middle\" width=\"auto\"><span style=\"color: #ffffff; font-weight: 300;\"><a href=\"#\" style=\"color: #ffffff; text-align:center;text-decoration: none;\">Read More</a> </span></td></tr></tbody></table></td></tr><!-- /button --><!-- Spacing --><tr><td height=\"20\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table></td></tr></tbody></table></div><div class=\"block\"><!-- Start of preheader --><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"backgroundTable\" st-sortable=\"postfooter\" width=\"100%\"><tbody><tr><td width=\"100%\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"devicewidth\" width=\"580\"><tbody><!-- Spacing --><tr><td height=\"5\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --><tr><td align=\"center\" st-content=\"preheader\" style=\"font-family: Helvetica, arial, sans-serif; font-size: 10px;color: #999999\" valign=\"middle\">If you don&#39;t want to receive updates. please <a class=\"hlite\" href=\"#\" style=\"text-decoration: none; color: #0db9ea\">unsubscribe</a></td></tr><!-- Spacing --><tr><td height=\"5\" width=\"100%\">&nbsp;</td></tr><!-- Spacing --></tbody></table></td></tr></tbody></table><!-- End of preheader --></div>',0,1,1,NULL);
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (102,'تمپلیت جدید 3','<div style=\"width: 98%;margin: 0 auto\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin: 0; padding: 0; line-height:0\" width=\"100%\"><tbody><tr><td><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-top: 5px solid #1c1c1c; border-bottom: 1px solid #cccccc; ; margin:0 auto; padding: 0;\" width=\"100%\"><tbody><tr><td align=\"center\" style=\"margin:0; padding: 5px; line-height: 16px\" valign=\"top\"><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; margin:0; padding:0; color:#6f6f6f;\">Welcome to our company newlsetter. #1 - 07.03.2013</p></td></tr></tbody></table></td></tr><tr><td style=\"margin: 0; padding: 0; line-height: 0\"><img height=\"5\" src=\"./architecture3_files/1.gif\" width=\"1\" /></td></tr><tr><td style=\"margin: 0 auto; padding: 0; line-height: 0\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0; margin:0 auto;\" width=\"100%\"><tbody><tr><td style=\"; padding: 0\" valign=\"top\" width=\"30%\"><!-- bof LOGO --><p style=\"padding: 0; margin: 0; font-family: Arial, Helvetica, sans-serif; font-size: 36px; line-height: 42px; background-color:#1c1c1c; border: 5px solid #1c1c1c; color:#ffffff;\">Company Name</p><!-- eof LOGO --><!-- bof MENU --><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><p>&rsaquo; <a href=\"#\" style=\"color: #1c1c1c;\">integer? Facilisis lundium</a></p><!-- eof MENU --><br /><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"170\"><tbody><tr><td align=\"center\" style=\"margin: 0; padding:0\"><img border=\"0\" height=\"170\" src=\"./architecture3_files/2.jpg\" width=\"170\" /></td></tr><tr><td style=\"margin:0; padding: 5px 0; line-height: 16px\"><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; margin:0; padding:0; color:#6f6f6f;\">Scelerisque massa magna etiam placerat, sociis! Velit nec enim lorem est integer in, scelerisque ultrices enim | <a href=\"#\" style=\"color: #1c1c1c;\">read more</a> |</p></td></tr></tbody></table></td><td style=\"margin:0; padding: 0\"><img border=\"0\" src=\"./architecture3_files/1.gif\" width=\"5\" /></td><td style=\"margin: 0; padding: 0\" valign=\"top\" width=\"70%\"><!-- bof BANNER --><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr style=\"margin:0; padding:0\" valign=\"top\"><td style=\"margin: 0; padding: 0; line-height: 0\" valign=\"top\"><img alt=\"image\" border=\"0\" height=\"250\" src=\"./architecture3_files/3.jpg\" width=\"100%\" /></td></tr><tr><td style=\"margin:0; padding:5px; background-color:#1c1c1c; text-align: left\" valign=\"top\"><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color:#ffffff;\">integer? Facilisis lundium, natoque integer, sed penatibus augue magna, nisi porta, pulvinar, ac auctor | <a href=\"#\" style=\"color:#ffffff;\">read more</a> |</p></td></tr></tbody></table><!-- eof BANNER --><!-- bof HIGHLIGHTS --><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td style=\"margin:0; padding: 5px; \" valign=\"top\"><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #1c1c1c; font-weight:bold;\">Scelerisque massa magna etiam placerat</p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\">integer? Facilisis lundium, natoque integer, sed penatibus augue magna,nisi porta</p><p style=\"margin: 0; padding: 0;font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f; text-align:right\">| <a href=\"#\" style=\"color: #1c1c1c\">read more</a> |</p></td><td style=\"margin:0; padding: 5px 0\" valign=\"top\"><span style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\"><img alt=\"image\" border=\"0\" height=\"122\" src=\"./architecture3_files/4.jpg\" width=\"180\" /></span></td></tr></tbody></table><hr style=\"height:1px; background: #6f6f6f; margin:0; padding:0; border: 0\" /><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td style=\"margin:0; padding: 5px; \" valign=\"top\"><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #1c1c1c; font-weight:bold;\">Scelerisque massa magna etiam placerat</p><p style=\"margin: 0; padding: 0; margin-bottom: 10px; font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f\">integer? Facilisis lundium, natoque integer, sed penatibus augue magna, nisi porta</p><p style=\"margin: 0; padding: 0;font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; color: #6f6f6f; text-align:right\">| <a href=\"#\" style=\"color: #1c1c1c\">read more</a> |</p></td><td style=\"margin:0; padding: 5px 0\" valign=\"top\"><img alt=\"image\" border=\"0\" height=\"122\" src=\"./architecture3_files/5.jpg\" width=\"180\" /></td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td style=\"margin: 0; padding: 0; line-height: 0\"><img height=\"5\" src=\"./architecture3_files/1.gif\" width=\"1\" /></td></tr><tr><td style=\"margin: 0 auto; padding: 0; line-height: 0\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin: 0 auto; padding: 0; line-height: 0\" width=\"100%\"><tbody><tr><td><p style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 16px; margin:0; padding:0; text-align:center; border-top: 1px solid #6f6f6f; padding: 10px;  color: #6f6f6f\">Scelerisque massa magna etiam placerat, sociis! Velit nec enim lorem est integer Facilisis lundium, natoque integer, sed penatibus augue magna,<a href=\"#\" style=\"color: #1c1c1c\"> nisi porta, pulvinar, ac aucto</a> massa? Porta in, scelerisque ultrices enim sed sed parturient.</p></td></tr><tr><td align=\"center\"><!-- bof SOCIAL --><table border=\"0\" cellpadding=\"10\" cellspacing=\"0\"><tbody><tr><td style=\" padding-right:7px;\"><a href=\"#\"><img border=\"0\" hspace=\"0\" src=\"./architecture3_files/6.gif\" vspace=\"0\" /></a></td><td style=\" padding-right:7px;\"><a href=\"#\"><img border=\"0\" hspace=\"0\" src=\"./architecture3_files/7.gif\" vspace=\"0\" /></a></td><td style=\" padding-right:7px;\"><a href=\"#\"><img border=\"0\" hspace=\"0\" src=\"./architecture3_files/8.gif\" vspace=\"0\" /></a></td><td style=\" padding-right:0px;\"><a href=\"#\"><img border=\"0\" hspace=\"0\" src=\"./architecture3_files/9.gif\" vspace=\"0\" /></a></td></tr></tbody></table><!-- eof SOCIAL --></td></tr><tr><td align=\"center\" style=\"background: #1c1c1c; margin: 0; padding: 10px 20px\" valign=\"top\"><p style=\"color: #ffffff; font-size:13px; line-height: 16px; font-family:Verdana, Arial, Helvetica, sans-serif\">Porta in, scelerisque ultrices enim sed <a href=\"#\" style=\"color: #ffffff;\">sed parturient</a> Porta in, scelerisque ultrices enim sed</p></td></tr></tbody></table></td></tr></tbody></table></div>',0,1,1,NULL),
 (106,'تمپلیت جدید5 رسپانسیو','<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td bgcolor=\"#ffffff\" style=\"padding-top:20px\" valign=\"top\" width=\"100%\"><!--Start Header--><table align=\"center\" bgcolor=\"#fff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td style=\"padding: 6px 0px 0px\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"650\"><tbody><tr><td width=\"100%\"><!--Start logo--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><tbody><tr><td class=\"center\" style=\"padding: 20px 0px 10px 0px\"><a href=\"#\"><img src=\"img/logo/logo_red.png\" /> </a></td></tr></tbody></table><!--End logo--><!--Start nav--><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><tbody><tr><td class=\"center\" style=\"font-size: 13px; color: #272727; font-weight: light; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 0px 10px 0px;\"><a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">PRODUCTS</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">SERVICES</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">WORK</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">BLOG</a></td></tr></tbody></table><!--End nav--></td></tr></tbody></table></td></tr></tbody></table><!--End Header--><!-- Start Headliner--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td class=\"center\" style=\"padding: 0px \" valign=\"top\" width=\"100%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"350\" src=\"img/headliner/headliner_red.jpg\" width=\"700\" /> </a></td></tr></tbody></table><!-- End Headliner--><!--Start Discount--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td align=\"center\" bgcolor=\"#f7f7f7\" style=\" padding: 20px 0;\" width=\"100%\"><!--Left Box--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><tbody><tr><td class=\"left\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0 20px 10px 20px;\" valign=\"top\">Book Today and Get 40% Discount</td></tr></tbody></table><!--End Left Box--><table><tbody><tr><td class=\"center\" style=\"padding: 7px 15px;  background-color: #e74c3c; \" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">BOOK NOW</a></td></tr></tbody></table></td></tr></tbody></table><!--End Discount--><!--Start Left Picture--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#fff\" width=\"100%\"><!-- Left box  --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"45%\"><tbody><tr><td style=\"padding: 20px 20px\" valign=\"top\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"190\" src=\"img/block_img/left_picture.jpg\" width=\"260\" /> </a></td></tr></tbody></table><!--End left box--><!--Right box--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"55%\"><tbody><tr><td style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px; 20px 0px 1 \">Now Traveling Is Easy</td></tr><tr><td style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0 20px 20px 40px; \">1Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End right box--></td></tr></tbody></table><!--End Left Picture--><!--Start Right Picture--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#f7f7f7\" width=\"100%\"><!--Left box--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"55%\"><tbody><tr><td style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0; \">Perfect Location</td></tr><tr><td style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px;\">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Left box--><!-- Right box  --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"30%\"><tbody><tr><td class=\"center\" style=\"padding: 20px;\" valign=\"top\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"190\" src=\"img/block_img/right_picture.jpg\" width=\"260\" /> </a></td></tr></tbody></table><!--End Right box--></td></tr></tbody></table><!--End Right Picture--><!--Start Midlle Picture --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td class=\"center\" style=\"padding: 40px 20px 10px \" valign=\"top\" width=\"100%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"264\" src=\"img/block_img/middle_picture.jpg\" width=\"660\" /> </a></td></tr><tr><td class=\"center\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"100%\"><tbody><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 0; \">Great Holiday Destinations Summer 2014</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind. Books whose front would purse if be do decay. Quitting you way formerly disposed perceive ladyship are. Common turned boy direct and yet.</td></tr><tr><td style=\" padding: 0 0 20px 20px;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><!--End Midlle Picture --><!--Start Two Texts--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#f7f7f7\" width=\"100%\"><!--Left box--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><tbody><tr><td class=\"center\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"center\" style=\"padding: 30px 20px 0\" valign=\"top\"><a href=\"#\"><img hight=\"190\" src=\"img/block_img/picture_two.jpg\" width=\"190\" /> </a></td></tr><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px;\">Amazing View</td></tr><tr><td class=\"center deviceWidth\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Left box--><!-- Right box  --><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><tbody><tr><td class=\"center\"><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"right\" style=\"padding: 30px 20px 0; \" valign=\"top\"><a href=\"#\"><img hight=\"190\" src=\"img/block_img/picture_two.jpg\" width=\"190\" /> </a></td></tr><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px; \">Wonderland</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Right box--><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><tbody><tr><td class=\"center\"><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"right\" style=\"padding: 30px 20px 0; \" valign=\"top\"><a href=\"#\"><img hight=\"190\" src=\"img/block_img/picture_one.jpg\" width=\"190\" /> </a></td></tr><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px; \">Quality Time</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Right box--></td></tr></tbody></table><!--End Two Texts--><!--Start Support--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#a5d1da\" class=\"center\" width=\"100%\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"center\" style=\"padding: 20px 10px \" valign=\"top\"><a href=\"#\"><img hight=\"60\" src=\"img/icons/icon_support.png\" width=\"60\" /> </a></td></tr></tbody></table><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"center\" style=\"font-size: 16px; color: #ffffff; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0px 10px; \">24 Hour Support</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #ffffff; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px; \">Arrival entered an if drawing requests iness she ham but instantlyt putif departuresam propr. Certain be yeamiasa ble by exposed Two differed husbands met screened his. How daughters not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr></tbody></table><!--End Support--><!-- Footer --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0px; \">Drawings me opinions returned absolute in. Otherwise therefore did are unfeeling something. Certain be ye amiable by exposed Two differed husbands met screened his. Bed was form wife out ask draw. Wholly coming at we no enable</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0px; \">If you would prefer not to receive email communications from Unify Template click <a href=\"#\" style=\"text-decoration: none; color: #e74c3c;\">here</a></td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 50px 0px 50px; \">Copyright &copy; Unify Template 2014</td></tr></tbody></table><!--End Footer--><div style=\"height:15px\">&nbsp;</div><!-- divider--></td></tr></tbody></table>',0,1,1,NULL);
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (107,'تمپلیت مقاله','<div><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td><table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><!-- Spacing --><tr><td><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><!-- End of Title --><!-- spacing --><!-- End of spacing --><!-- content --><!-- End of content --><!-- Spacing --><!-- /button --><!-- Spacing --><!-- Spacing --></tbody></table></td></tr></tbody></table></td></tr></tbody></table><span style=\"color:#800080;\"><!-- end of textbox-with-title --></span></div><div><table bgcolor=\"#f6f4f5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"99\" width=\"918\"><tbody><tr><td><table align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\"405\" width=\"915\"><tbody><tr><td><img alt=\"i35v\" src=\"http://fioretech.ir:8080/fioretech/upload/p1251095539.jpg\" style=\"width: 100%;\" /></td><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></div><p>&nbsp;</p>',0,1,1,''),
 (110,'تماس با ما','<div class=\"container\"><h3 class=\"tittle\">تماس با ما</h3><div class=\"contact-form\"><!--    --><div class=\"col-md-6 contact-in\"><p class=\"sed-para-wthree\">درباره ما</p><p class=\"para-wthree1\">شرکت نجار باشی یکی از باسابقه ترین شرکت های دکوراسیون داخلی می باشدکه فعالیت خود را از سال 1366 در حوزه دکوراسیون داخلی به طور رسمی آغاز به کار کرده</p><div class=\"more-address\"><div class=\"address-more\"><p class=\"location\"><!--    <i class=\"glyphicon glyphicon-map-marker\">    </i>-->اصفهان خیابان بزرگمهر</p><p class=\"phone\"><!--<i class=\"glyphicon glyphicon-phone\"></i>-->0313-3662256</p><p class=\"mail\"><a href=\"#\">najarbashi@gmail.com</a></p></div></div></div><div class=\"col-md-6 contact-grid\"><form action=\"#\" method=\"post\"><p class=\"your-para\">نام</p><input name=\"Your Name\" placeholder=\"\" required=\" \" type=\"text\" /><p class=\"your-para\">نام خانوادگی</p><input name=\"Your Email\" placeholder=\"\" required=\" \" type=\"email\" /><p class=\"your-para\">پیام</p><textarea name=\"Your Message\" placeholder=\"\" required=\"\"></textarea><div class=\"send\"><input type=\"submit\" value=\"ارسال\" /></div></form></div><div class=\"clearfix\">&nbsp;</div></div></div><script type=\"text/javascript\" >$(\"html, body\").animate({scrollTop: $(\"#maincontent\").offset().top}, 2000);</script>',0,1,1,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (113,'قوانین و مقررات سایت','<p dir=\"RTL\"><span style=\"font-size:14px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\"><span style=\"color:#0099ff;\"><strong>روش های درخواست محصولات </strong></span></span></span></p><p dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\">فرم موجود در بخش تماس با ما را در صورت تمایل (با ثبت آدرس ایمیل و شماره تلفن) برای ما ارسال کنید تا همکاران ما در اسرع وقت با شما تماس بگیرند.</span></span></p><p dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\">برای طرح هرگونه سوال یا درخواست مشاوره در روزهای شنبه تا چهارشنبه از ساعت 16-8 و در روز پنجشنبه از ساعت13-8 با شماره 32683807-031 زیر تماس بگیرید<span dir=\"LTR\">.</span></span></span></p><p dir=\"RTL\">&nbsp;</p><p dir=\"RTL\"><span style=\"color:#0099ff;\"><span style=\"font-size:14px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\"><strong>روش&zwnj;های پرداخت</strong></span></span></span></p><p dir=\"RTL\"><span style=\"font-size:12px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\">لطفا در روزهای شنبه تا چهارشنبه از ساعت 16-8 و در روز پنجشنبه از ساعت13-8 باشماره تلفن&nbsp;&nbsp;&nbsp; &nbsp;32683807-031 زیر تماس بگیرید<span dir=\"LTR\">.</span></span></span></p><p dir=\"RTL\"><span style=\"color:#0099ff;\"><span style=\"font-size:14px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\"><strong>روش های پیاده سازی&nbsp; محصولات&nbsp; </strong></span></span></span><strong><span style=\"color:#0099ff;\"><span style=\"font-size:14px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\">در اصفهان</span></span></span></strong><span style=\"color:#0099ff;\"><span style=\"font-size:14px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\"><strong>:</strong></span></span></span></p><p dir=\"RTL\" style=\"margin-right:.5in;\"><span style=\"font-size:12px;\"><span style=\"font-family:tahoma,geneva,sans-serif;\">سفارش&zwnj;ها &nbsp;در شهر اصفهان&nbsp;مطابق&nbsp;بازه زمانی که مشتریان هنگام ثبت سفارش انتخاب می&zwnj;کنند، انجام خواهد شد. </span></span></p>',0,1,1,''),
 (151,'قالب درباره ما قدیم','<p style=\"text-align: center;\">&nbsp;</p><p>&nbsp;</p><p><span dir=\"RTL\">شرکت فنی مهندسی پژوهشگران سیستم&zwnj;های هوشمند به&zwnj;عنوان یک شرکت دانش بنیان در شهرک علمی و تحقیقاتی اصفهان فعالیت می&zwnj;نماید. این شرکت با پشتوانه فنی و تجربی و کادر متخصص خود و هم&zwnj;چنین ارتباط مستمر با مراکز پژوهشی و دانشگاه&zwnj;های معتبر کشور پروژه&zwnj;های مختلفی در زمینه سیستم&zwnj;های حفاظتی، نظارتی و کنترلی هوشمند اجرا نموده است.</span></p><p>&nbsp;</p><p dir=\"RTL\"><strong>بازرگانی&nbsp;و فروش:</strong></p><ul dir=\"rtl\"><li>&nbsp;واردات محصولات متنوع از کشورهای اروپایی، آسیایی و آمریکایی در کمترین زمان و قیمت مناسب</li><li>&nbsp;واردات کالاهای تخصصی شبکه و <span dir=\"LTR\">&nbsp;IT</span></li><li>نماینده&shy; ی برند بین &shy;المللی<span dir=\"LTR\"> Giada </span>در ایران ( این شرکت در قاره&shy; های امریکا، آسیا، اقیانوسیه و کشورهای اروپایی 30&nbsp; نماینده&nbsp; فعال دارد )</li><li>&nbsp;واردات <a href=\"http://www.fioretech.ir\"><span dir=\"LTR\">مینی پی سی و تین کلاینت</span></a> برند <span dir=\"LTR\">Giada</span></li></ul><p dir=\"RTL\"><strong>توانمندی های &nbsp;خاص در بازرگانی:</strong></p><ul dir=\"rtl\"><li>واردات کلیه محصولات شرکت <span dir=\"LTR\">ublox</span> از جمله ماژول های <span dir=\"LTR\">GPS</span> زیر با قیمت مناسب و زمان تحویل دهی کم</li></ul><p dir=\"RTL\" style=\"text-align: left;\"><span dir=\"LTR\">LEA-6 series</span></p><p dir=\"RTL\" style=\"text-align: left;\"><span dir=\"LTR\">NEO 6&amp;7 series</span></p><p style=\"text-align: left;\">(NEO-7P(Precise Point Positioning</p><p style=\"text-align: left;\">(LEA-6N(Dead Rocking</p><p style=\"text-align: left;\"><strong>&hellip;</strong></p><ul><li>واردات کلیه محصولات ناوبری <span dir=\"LTR\">GPS</span>،<span dir=\"LTR\">GPS/GLONASS</span>،<span dir=\"LTR\">RTK</span> و... از شرکت های مطرح دنیا از قبیل: <span dir=\"LTR\">Trimble,Novatel,Garmin,Hemisphere,CHC China</span>و...</li><li>واردات کلیه سنسورهای ناوبری از قبیل انواع شتاب سنج ها و ژیروسکوپ های <span dir=\"LTR\">FOG ,LOG</span> و<span dir=\"LTR\">MEMS </span>&nbsp;از شرکت های مطرح دنیا</li></ul><p>&nbsp;</p>',0,1,1,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (159,'درباره ما قدیم','<p style=\"text-align: center;\">&nbsp;</p><p>&nbsp;</p><p><span dir=\"RTL\">شرکت فنی مهندسی پژوهشگران سیستم&zwnj;های هوشمند به&zwnj;عنوان یک شرکت دانش بنیان در شهرک علمی و تحقیقاتی اصفهان فعالیت می&zwnj;نماید. این شرکت با پشتوانه فنی و تجربی و کادر متخصص خود و هم&zwnj;چنین ارتباط مستمر با مراکز پژوهشی و دانشگاه&zwnj;های معتبر کشور پروژه&zwnj;های مختلفی در زمینه سیستم&zwnj;های حفاظتی، نظارتی و کنترلی هوشمند اجرا نموده است.</span></p><p>&nbsp;</p><p dir=\"RTL\"><strong>بازرگانی&nbsp;و فروش:</strong></p><ul dir=\"rtl\"><li>&nbsp;واردات محصولات متنوع از کشورهای اروپایی، آسیایی و آمریکایی در کمترین زمان و قیمت مناسب</li><li>&nbsp;واردات کالاهای تخصصی شبکه و <span dir=\"LTR\">&nbsp;IT</span></li><li>نماینده&shy; ی برند بین &shy;المللی<span dir=\"LTR\"> Giada </span>در ایران ( این شرکت در قاره&shy; های امریکا، آسیا، اقیانوسیه و کشورهای اروپایی 30&nbsp; نماینده&nbsp; فعال دارد )</li><li>&nbsp;واردات <a href=\"http://www.fioretech.ir\"><span dir=\"LTR\">مینی پی سی و تین کلاینت</span></a> برند <span dir=\"LTR\">Giada</span></li></ul><p dir=\"RTL\"><strong>توانمندی های &nbsp;خاص در بازرگانی:</strong></p><ul dir=\"rtl\"><li>واردات کلیه محصولات شرکت <span dir=\"LTR\">ublox</span> از جمله ماژول های <span dir=\"LTR\">GPS</span> زیر با قیمت مناسب و زمان تحویل دهی کم</li></ul><p dir=\"RTL\" style=\"text-align: left;\"><span dir=\"LTR\">LEA-6 series</span></p><p dir=\"RTL\" style=\"text-align: left;\"><span dir=\"LTR\">NEO 6&amp;7 series</span></p><p style=\"text-align: left;\">(NEO-7P(Precise Point Positioning</p><p style=\"text-align: left;\">(LEA-6N(Dead Rocking</p><p style=\"text-align: left;\"><strong>&hellip;</strong></p><ul><li>واردات کلیه محصولات ناوبری <span dir=\"LTR\">GPS</span>،<span dir=\"LTR\">GPS/GLONASS</span>،<span dir=\"LTR\">RTK</span> و... از شرکت های مطرح دنیا از قبیل: <span dir=\"LTR\">Trimble,Novatel,Garmin,Hemisphere,CHC China</span>و...</li><li>واردات کلیه سنسورهای ناوبری از قبیل انواع شتاب سنج ها و ژیروسکوپ های <span dir=\"LTR\">FOG ,LOG</span> و<span dir=\"LTR\">MEMS </span>&nbsp;از شرکت های مطرح دنیا</li></ul><p>&nbsp;</p>',0,1,1,''),
 (160,'درباره ما قدیم2','<div style=\"width: 100%\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"240\"><tbody><tr><td align=\"center\" bgcolor=\"#f6d14e\" height=\"31\" new=\"\" roman=\"\" style=\"font-family:Georgia, \" times=\"\">نجار باشی</td></tr></tbody></table><p>&nbsp;</p><p>&nbsp;</p><p>نجار باشی با سابقه ی 5 ساله و&nbsp;کوله باری از تجربه عزم خود را جزم کرده تا در راستای درخواست و رضایت مشتری روز به روز تلقی حاصل نماید..</p><p>&nbsp;</p><p>لذا چنانچه&nbsp; خواستار تغییر و تحولی بنیادی در زندگی و تغییر نگرش در سبک چیدمان منزل ومحیط کار خود هستید&nbsp;&nbsp;پیشنهاد میشود کاتالوگ کارهای موجود را مشاهده کنید...</p><p>&nbsp;</p><p>شعار این شرکت همواره جلب نظر مشتری و پیاده سازی&nbsp; سلایق مطابق با اخرین جلوه های مد می باشد...</p><p>&nbsp;</p><p>به امید زندگی بهتر.....</p><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td align=\"left\" valign=\"top\" width=\"25%\"><table style=\"width: 90%;margin: 0 auto\"><tbody><tr><td align=\"left\" valign=\"top\"><img src=\"upload/p2939500791.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></td></tr><tr><td align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</td></tr></tbody></table></td><td align=\"center\" valign=\"top\" width=\"25%\"><table style=\"width: 90%;margin: 0 auto\"><tbody><tr><td align=\"left\" valign=\"top\"><img src=\"upload/p9194607129.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></td></tr><tr><td align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</td></tr></tbody></table></td><td align=\"center\" valign=\"top\" width=\"25%\"><table style=\"width: 90%;margin: 0 auto\"><tbody><tr><td align=\"left\" valign=\"top\"><img src=\"upload/p9597474142.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></td></tr><tr><td align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</td></tr></tbody></table></td><td align=\"right\" valign=\"top\" width=\"25%\"><table style=\"width: 90%;margin: 0 auto\"><tbody><tr><td align=\"left\" valign=\"top\"><img src=\"upload/p0287434713.jpg\" style=\"display: block; width: 80%; margin: 0px auto;\" /></td></tr><tr><td align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</td></tr></tbody></table></td></tr></tbody></table>&nbsp;<div>&nbsp;</div><div><br /><br />&nbsp;</div><br />&nbsp;</div>',0,1,1,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (161,'درباره مممممما','<div style=\"width: 100%\"><div style=\" alignment-adjust: central  ;border:0px; cellpadding:0px; cellspacing:0px;width:240px;\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"240\"><tbody><tr><td align=\"center\" bgcolor=\"#f6d14e\" height=\"31\" new=\"\" roman=\"\" style=\"font-family:Georgia, \" times=\"\">نجار باشی</td></tr></tbody></table><p>&nbsp;</p><p>&nbsp;</p><p>نجار باشی با سابقه ی 5 ساله و&nbsp;کوله باری از تجربه عزم خود را جزم کرده تا در راستای درخواست و رضایت مشتری روز به روز تلقی حاصل نماید..</p><p>&nbsp;</p><p>لذا چنانچه&nbsp; خواستار تغییر و تحولی بنیادی در زندگی و تغییر نگرش در سبک چیدمان منزل ومحیط کار خود هستید&nbsp;&nbsp;پیشنهاد میشود کاتالوگ کارهای موجود را مشاهده کنید...</p><p>&nbsp;</p><p>شعار این شرکت همواره جلب نظر مشتری و پیاده سازی&nbsp; سلایق مطابق با اخرین جلوه های مد می باشد...</p><p>&nbsp;</p><p>به امید زندگی بهتر.....</p><div style=\"border:0; cellpadding:0; cellspacing:0 ;width:100%\"><div style=\" align=left ;valign:top ;width:25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p2939500791.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div><div align=\"center\" valign=\"top\" width=\"25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p9194607129.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div></div><div align=\"center\" valign=\"top\" width=\"25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p9597474142.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div></div><div align=\"right\" valign=\"top\" width=\"25%\"><div style=\"width: 90%;margin: 0 auto\"><div align=\"left\" valign=\"top\"><img src=\"upload/p1805562761.jpg\" style=\"display: block; width: 241px; margin: 0px auto; height: 173px;\" /></div><div align=\"left\" new=\"\" roman=\"\" times=\"\">&nbsp;</div></div></div><p>&nbsp;</p><div>&nbsp;</div><div><br /><br />&nbsp;</div><p><br />&nbsp;</p></div>',0,1,1,''),
 (162,'دکوراسیون نشیمن','<div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><div color=\"#ffffff\" style=\"padding-top:20px\" valign=\"top\" width=\"100%\"><!--Start Header--><div align=\"center\" bgcolor=\"#fff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div style=\"padding: 6px 0px 0px\"><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"650\"><div style=\"width:100%\"><!--Start logo--><div align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><div class=\"center\" style=\"margin-left: 44%;\"><a href=\"#\"><img src=\"upload/p8235864541.jpg\" style=\"width: 100%; height: 100%;margin-left: -37%;\" /> </a></div></div><!--End logo--><!--Start nav--><div class=\"deviceWidth\" style=\" align:right; border:0px; cellpadding:0px; cellspacing:0px;\"><div class=\"center\" style=\"font-size: 13px; color: #272727; font-weight: light; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 0px 10px 0px;\"><a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">PRODUCTS</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">SERVICES</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">WORK</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">BLOG</a></div></div><!--End nav--></div></div></div></div><!--End Header--><!-- Start Headliner--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div><div class=\"center\" style=\"padding: 0px \" valign=\"top\" width=\"100%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"50%\" src=\"img/headliner/headliner_red.jpg\" width=\"50%\" /> </a></div></div></div><!-- End Headliner--><!--Start Discount--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div align=\"center\" bgcolor=\"#f7f7f7\" style=\" padding: 20px 0;\" width=\"100%\"><!--Left Box--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><div class=\"left\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0 20px 10px 20px;\" valign=\"top\">Book Today and Get 40% Discount</div></div><!--End Left Box--><div><div class=\"center\" style=\"padding: 7px 15px;  background-color: #e74c3c; \" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">BOOK NOW</a></div></div></div></div><!--End Discount--><!--Start Left Picture--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div bgcolor=\"#fff\" width=\"100%\"><!-- Left box  --><div align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"45%\"><div style=\"margin-left: 35%\" valign=\"top\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"50%\" src=\"img/block_img/left_picture.jpg\" width=\"50%\" /> </a></div></div><!--End left box--><!--Right box--><div align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"55%\"><div style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px; 20px 0px 1 \">Now Traveling Is Easy</div><div style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0 20px 20px 40px; \">1Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</div><div style=\" padding: 0 0 20px 0;\"><div align=\"center\"><div class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></div></div></div></div><!--End right box--></div></div><!--End Left Picture--><!--Start Right Picture--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div bgcolor=\"#f7f7f7\" width=\"100%\"><!--Left box--><div align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"55%\"><div style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0; \">Perfect Location</div><div style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px;\">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</div><div style=\" padding: 0 0 20px 0;\"><div align=\"center\"><div class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></div></div></div></div><!--End Left box--><!-- Right box  --><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"30%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"50%\" src=\"img/block_img/right_picture.jpg\" width=\"50%\" /> </a></div></div><!--End Right box--></div><!--End Right Picture--><!--Start Midlle Picture --><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div class=\"center\" style=\"padding: 40px 20px 10px \" valign=\"top\" width=\"100%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"60%\" src=\"img/block_img/middle_picture.jpg\" width=\"60%\" /> </a></div><div class=\"center\"><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"100%\"><div class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 0; \">Great Holiday Destinations Summer 2014</div><div class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind. Books whose front would purse if be do decay. Quitting you way formerly disposed perceive ladyship are. Common turned boy direct and yet.</div><div style=\" padding: 0 0 20px 20px;\"><div align=\"center\"><div class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></div></div></div></div></div></div><!--End Midlle Picture --><!--Start Two Texts--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div bgcolor=\"#f7f7f7\" width=\"100%\"><!--Left box--><div align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><div class=\"center\"><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><div class=\"center\" style=\"padding: 30px 20px 0\" valign=\"top\"><a href=\"#\"><img hight=\"70%\" src=\"img/block_img/picture_two.jpg\" width=\"70%\" /> </a></div><div class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px;\">Amazing View</div><div class=\"center deviceWidth\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</div></div></div><div style=\" padding: 0 0 20px 0;\"><div align=\"center\"><div class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></div></div></div></div><!--End Left box--><!-- Right box  --><div align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><div class=\"center\"><div align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><div class=\"right\" style=\"padding: 30px 20px 0; \" valign=\"top\"><a href=\"#\"><img hight=\"90%\" src=\"img/block_img/picture_two.jpg\" width=\"90%\" /> </a></div><div class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px; \">Wonderland</div><div class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</div></div></div><div style=\" padding: 0 0 20px 0;\"><div align=\"center\"><div class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></div></div></div></div><!--End Right box--><div align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><div class=\"center\"><div align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><div class=\"right\" style=\"padding: 30px 20px 0; \" valign=\"top\"><a href=\"#\"><img hight=\"30%\" src=\"img/block_img/picture_one.jpg\" width=\"30%\" /> </a></div><div class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px; \">Quality Time</div><div class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</div></div></div><div style=\" padding: 0 0 20px 0;\"><div align=\"center\"><div class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></div></div></div></div><!--End Right box--></div></div><!--End Two Texts--><!--Start Support--><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div bgcolor=\"#a5d1da\" class=\"center\" width=\"100%\"><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><div class=\"center\" style=\"padding: 20px 10px \" valign=\"top\"><a href=\"#\"><img hight=\"60\" src=\"img/icons/icon_support.png\" width=\"60\" /> </a></div></div><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><div class=\"center\" style=\"font-size: 16px; color: #ffffff; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0px 10px; \">24 Hour Support</div><div class=\"center\" style=\"font-size: 12px; color: #ffffff; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px; \">Arrival entered an if drawing requests iness she ham but instantlyt putif departuresam propr. Certain be yeamiasa ble by exposed Two differed husbands met screened his. How daughters not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</div></div></div></div><!--End Support--><!-- Footer --><div align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><div class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0px; \">Drawings me opinions returned absolute in. Otherwise therefore did are unfeeling something. Certain be ye amiable by exposed Two differed husbands met screened his. Bed was form wife out ask draw. Wholly coming at we no enable</div><div class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0px; \">If you would prefer not to receive email communications from Unify Template click <a href=\"#\" style=\"text-decoration: none; color: #e74c3c;\">here</a></div><div class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 50px 0px 50px; \">Copyright &copy; Unify Template 2014</div></div><!--End Footer--><div style=\"height:15px\">&nbsp;</div><!-- divider--></div></div>',0,1,1,'');
INSERT INTO `content` (`id`,`content_title`,`content_content`,`content_parent`,`content_lang`,`content_has_link`,`content_tags`) VALUES 
 (163,'قالب دکوراسیون نشیمن','<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tbody><tr><td bgcolor=\"#ffffff\" style=\"padding-top:20px\" valign=\"top\" width=\"100%\"><!--Start Header--><table align=\"center\" bgcolor=\"#fff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td style=\"padding: 6px 0px 0px\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"650\"><tbody><tr><td width=\"100%\"><!--Start logo--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><tbody><tr><td class=\"center\" style=\"padding: 20px 0px 10px 0px\"><a href=\"#\"><img src=\"img/logo/logo_red.png\" /> </a></td></tr></tbody></table><!--End logo--><!--Start nav--><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><tbody><tr><td class=\"center\" style=\"font-size: 13px; color: #272727; font-weight: light; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 0px 10px 0px;\"><a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">PRODUCTS</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">SERVICES</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">WORK</a> <a href=\"#\" style=\"text-decoration: none; color: #3b3b3b;\">BLOG</a></td></tr></tbody></table><!--End nav--></td></tr></tbody></table></td></tr></tbody></table><!--End Header--><!-- Start Headliner--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td class=\"center\" style=\"padding: 0px \" valign=\"top\" width=\"100%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"350\" src=\"img/headliner/headliner_red.jpg\" width=\"700\" /> </a></td></tr></tbody></table><!-- End Headliner--><!--Start Discount--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td align=\"center\" bgcolor=\"#f7f7f7\" style=\" padding: 20px 0;\" width=\"100%\"><!--Left Box--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\"><tbody><tr><td class=\"left\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0 20px 10px 20px;\" valign=\"top\">Book Today and Get 40% Discount</td></tr></tbody></table><!--End Left Box--><table><tbody><tr><td class=\"center\" style=\"padding: 7px 15px;  background-color: #e74c3c; \" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">BOOK NOW</a></td></tr></tbody></table></td></tr></tbody></table><!--End Discount--><!--Start Left Picture--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#fff\" width=\"100%\"><!-- Left box  --><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"45%\"><tbody><tr><td style=\"padding: 20px 20px\" valign=\"top\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"190\" src=\"img/block_img/left_picture.jpg\" width=\"260\" /> </a></td></tr></tbody></table><!--End left box--><!--Right box--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"55%\"><tbody><tr><td style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px; 20px 0px 1 \">Now Traveling Is Easy</td></tr><tr><td style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0 20px 20px 40px; \">1Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End right box--></td></tr></tbody></table><!--End Left Picture--><!--Start Right Picture--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#f7f7f7\" width=\"100%\"><!--Left box--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"55%\"><tbody><tr><td style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0; \">Perfect Location</td></tr><tr><td style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px;\">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Left box--><!-- Right box  --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"30%\"><tbody><tr><td class=\"center\" style=\"padding: 20px;\" valign=\"top\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"190\" src=\"img/block_img/right_picture.jpg\" width=\"260\" /> </a></td></tr></tbody></table><!--End Right box--></td></tr></tbody></table><!--End Right Picture--><!--Start Midlle Picture --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td class=\"center\" style=\"padding: 40px 20px 10px \" valign=\"top\" width=\"100%\"><a href=\"#\"><img class=\"deviceWidth\" hight=\"264\" src=\"img/block_img/middle_picture.jpg\" width=\"660\" /> </a></td></tr><tr><td class=\"center\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"100%\"><tbody><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 0; \">Great Holiday Destinations Summer 2014</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind. Books whose front would purse if be do decay. Quitting you way formerly disposed perceive ladyship are. Common turned boy direct and yet.</td></tr><tr><td style=\" padding: 0 0 20px 20px;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><!--End Midlle Picture --><!--Start Two Texts--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#f7f7f7\" width=\"100%\"><!--Left box--><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><tbody><tr><td class=\"center\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"center\" style=\"padding: 30px 20px 0\" valign=\"top\"><a href=\"#\"><img hight=\"190\" src=\"img/block_img/picture_two.jpg\" width=\"190\" /> </a></td></tr><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px;\">Amazing View</td></tr><tr><td class=\"center deviceWidth\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Left box--><!-- Right box  --><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><tbody><tr><td class=\"center\"><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"right\" style=\"padding: 30px 20px 0; \" valign=\"top\"><a href=\"#\"><img hight=\"190\" src=\"img/block_img/picture_two.jpg\" width=\"190\" /> </a></td></tr><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px; \">Wonderland</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Right box--><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"33%\"><tbody><tr><td class=\"center\"><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"right\" style=\"padding: 30px 20px 0; \" valign=\"top\"><a href=\"#\"><img hight=\"190\" src=\"img/block_img/picture_one.jpg\" width=\"190\" /> </a></td></tr><tr><td class=\"center\" style=\"font-size: 16px; color: #303030; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 30px 20px 10px; \">Quality Time</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #b3b2b2; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 10px 20px 20px; \">Arrival entered an if drawing requests iness not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr><tr><td style=\" padding: 0 0 20px 0;\"><table align=\"center\"><tbody><tr><td class=\"center\" style=\"padding: 7px 15px; text-align: center; background-color: #e74c3c;\" valign=\"top\"><a href=\"#\" style=\"color: #fff; font-size: 12px; font-weight: bold; text-decoration: none; font-family: Arial, sans-serif; text-alight: center;\">VIEW MORE</a></td></tr></tbody></table></td></tr></tbody></table><!--End Right box--></td></tr></tbody></table><!--End Two Texts--><!--Start Support--><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td bgcolor=\"#a5d1da\" class=\"center\" width=\"100%\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"center\" style=\"padding: 20px 10px \" valign=\"top\"><a href=\"#\"><img hight=\"60\" src=\"img/icons/icon_support.png\" width=\"60\" /> </a></td></tr></tbody></table><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"center\" style=\"font-size: 16px; color: #ffffff; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 0px 10px; \">24 Hour Support</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #ffffff; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px; \">Arrival entered an if drawing requests iness she ham but instantlyt putif departuresam propr. Certain be yeamiasa ble by exposed Two differed husbands met screened his. How daughters not promotion few knowledge. contented. Yet winter law romotion few knowledge contented behind</td></tr></tbody></table></td></tr></tbody></table><!--End Support--><!-- Footer --><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"deviceWidth\" width=\"700\"><tbody><tr><td class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0px; \">Drawings me opinions returned absolute in. Otherwise therefore did are unfeeling something. Certain be ye amiable by exposed Two differed husbands met screened his. Bed was form wife out ask draw. Wholly coming at we no enable</td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 10px 0px; \">If you would prefer not to receive email communications from Unify Template click <a href=\"#\" style=\"text-decoration: none; color: #e74c3c;\">here</a></td></tr><tr><td class=\"center\" style=\"font-size: 12px; color: #687074; font-weight: bold; text-align: center; font-family: Arial, Helvetica, sans-serif; line-height: 25px; vertical-align: middle; padding: 20px 50px 0px 50px; \">Copyright &copy; Unify Template 2014</td></tr></tbody></table><!--End Footer--><div style=\"height:15px\">&nbsp;</div><!-- divider--></td></tr></tbody></table>',0,1,1,'');
/*!40000 ALTER TABLE `content` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department_title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_publicContent` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_praivateContent` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_organizationalCode` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_pic` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_icon` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `department_location` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`,`department_title`,`department_publicContent`,`department_praivateContent`,`department_organizationalCode`,`department_description`,`department_pic`,`department_icon`,`department_location`) VALUES 
 (1,'','','','','',NULL,NULL,'5'),
 (2,'','nmnmn','<p>hhhhhhhhhhh</p>','','',NULL,NULL,'4'),
 (3,'mnbmnbnb','<p>\"nbmnb\"</p>','<p>bbbbbb</p>','10','',NULL,'p6363076400.jpg','1'),
 (4,' nnmn','<p>,mn,mn</p>','<p>mmmm</p>','10','',NULL,'p3863977535.jpg','2'),
 (5,'nmmm','mn','m m','101','',NULL,'p2818184422.jpg','1'),
 (6,'','nnn','nnn','','',NULL,'p2558195328.jpg','1');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`departmentposition`
--

DROP TABLE IF EXISTS `departmentposition`;
CREATE TABLE `departmentposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentposition_parent` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `departmentposition_subcategory` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `departmentposition_level` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`departmentposition`
--

/*!40000 ALTER TABLE `departmentposition` DISABLE KEYS */;
INSERT INTO `departmentposition` (`id`,`departmentposition_parent`,`departmentposition_subcategory`,`departmentposition_level`) VALUES 
 (0,NULL,NULL,'0'),
 (1,'0','بیمارستان','1'),
 (2,'1','بخش چشم','2'),
 (3,'2','چشم مردان','3'),
 (4,'2','چشم زنان','3'),
 (5,'1','بخش قلب','2');
/*!40000 ALTER TABLE `departmentposition` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`email`
--

DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email_body` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `email_host` longtext CHARACTER SET utf8,
  `email_status` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `email_date` int(10) unsigned DEFAULT NULL,
  `email_to` longtext CHARACTER SET utf8,
  `email_send_time` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `email_comment` longtext CHARACTER SET utf8,
  `email_subject` longtext CHARACTER SET utf8,
  `email_from` longtext CHARACTER SET utf8,
  `email_visit_status` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `email_visit_time` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `email_visit_date` int(10) unsigned DEFAULT NULL,
  `email_visit_count` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`email`
--

/*!40000 ALTER TABLE `email` DISABLE KEYS */;
/*!40000 ALTER TABLE `email` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`enrolment`
--

DROP TABLE IF EXISTS `enrolment`;
CREATE TABLE `enrolment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `enrolment_val1` varchar(500) DEFAULT NULL,
  `enrolment_val2` varchar(500) DEFAULT NULL,
  `enrolment_val3` varchar(500) DEFAULT NULL,
  `enrolment_val4` varchar(500) DEFAULT NULL,
  `enrolment_val5` varchar(500) DEFAULT NULL,
  `enrolment_val6` varchar(500) DEFAULT NULL,
  `enrolment_val7` varchar(500) DEFAULT NULL,
  `enrolment_val8` varchar(500) DEFAULT NULL,
  `enrolment_val9` varchar(500) DEFAULT NULL,
  `enrolment_val10` varchar(500) DEFAULT NULL,
  `enrolment_val11` varchar(500) DEFAULT NULL,
  `enrolment_val12` varchar(500) DEFAULT NULL,
  `enrolment_val13` varchar(500) DEFAULT NULL,
  `enrolment_val14` varchar(500) DEFAULT NULL,
  `enrolment_val15` varchar(500) DEFAULT NULL,
  `enrolment_val16` varchar(500) DEFAULT NULL,
  `enrolment_val17` varchar(500) DEFAULT NULL,
  `enrolment_val18` varchar(500) DEFAULT NULL,
  `enrolment_val19` varchar(500) DEFAULT NULL,
  `enrolment_val20` varchar(500) DEFAULT NULL,
  `enrolment_val21` varchar(500) DEFAULT NULL,
  `enrolment_val22` varchar(500) DEFAULT NULL,
  `enrolment_val23` varchar(500) DEFAULT NULL,
  `enrolment_val24` varchar(500) DEFAULT NULL,
  `enrolment_val25` varchar(500) DEFAULT NULL,
  `enrolment_val26` varchar(500) DEFAULT NULL,
  `enrolment_val27` varchar(500) DEFAULT NULL,
  `enrolment_val28` varchar(500) DEFAULT NULL,
  `enrolment_val29` varchar(500) DEFAULT NULL,
  `enrolment_val30` varchar(500) DEFAULT NULL,
  `enrolment_val31` longtext,
  `enrolment_val32` longtext,
  `enrolment_title` varchar(500) DEFAULT NULL,
  `enrolment_file1` varchar(500) DEFAULT NULL,
  `enrolment_file2` varchar(500) DEFAULT NULL,
  `enrolment_pic1` varchar(255) DEFAULT NULL,
  `enrolment_pic2` varchar(255) DEFAULT NULL,
  `enrolment_pic3` varchar(255) DEFAULT NULL,
  `enrolment_pic4` varchar(255) DEFAULT NULL,
  `enrolment_send_date` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`enrolment`
--

/*!40000 ALTER TABLE `enrolment` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrolment` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`enrolment3`
--

DROP TABLE IF EXISTS `enrolment3`;
CREATE TABLE `enrolment3` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `enrolment3_name` varchar(255) DEFAULT NULL,
  `enrolment3_tell` varchar(255) DEFAULT NULL,
  `enrolment3_mobile` varchar(45) DEFAULT NULL,
  `enrolment3_birthdate` int(10) unsigned DEFAULT NULL,
  `enrolment3_marital_status` varchar(255) DEFAULT NULL,
  `enrolment3_certificate` varchar(255) DEFAULT NULL,
  `enrolment3_major` varchar(255) DEFAULT NULL,
  `enrolment3_university` varchar(255) DEFAULT NULL,
  `enrolment3_starting_date` int(10) unsigned DEFAULT NULL,
  `enrolment3_end_date` int(10) unsigned DEFAULT NULL,
  `enrolment3_favorite_group` varchar(255) DEFAULT NULL,
  `enrolment3_cv` varchar(255) DEFAULT NULL,
  `enrolment3_publish` varchar(255) DEFAULT NULL,
  `enrolment3_live` varchar(255) DEFAULT NULL,
  `enrolment3_address` varchar(255) DEFAULT NULL,
  `enrolment3_pic` varchar(255) DEFAULT NULL,
  `enrolment3_file1` varchar(255) DEFAULT NULL,
  `enrolment3_file2` varchar(255) DEFAULT NULL,
  `enrolment3_elementary` varchar(255) DEFAULT NULL,
  `enrolment3_intermediate` varchar(255) DEFAULT NULL,
  `enrolment3_advanced` varchar(255) DEFAULT NULL,
  `enrolment3_specific_course` varchar(255) DEFAULT NULL,
  `enrolment3_speaking` varchar(255) DEFAULT NULL,
  `enrolment3_listening` varchar(255) DEFAULT NULL,
  `enrolment3_writing` varchar(255) DEFAULT NULL,
  `enrolment3_reading` varchar(255) DEFAULT NULL,
  `enrolment3_date` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`enrolment3`
--

/*!40000 ALTER TABLE `enrolment3` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrolment3` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`forum`
--

DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `forum_date` int(10) unsigned DEFAULT NULL,
  `forum_content` longtext,
  `forum_creator` int(10) unsigned DEFAULT NULL,
  `forum_category_id` int(10) unsigned DEFAULT NULL,
  `forum_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`forum`
--

/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_approved`
--

DROP TABLE IF EXISTS `hmis_approved`;
CREATE TABLE `hmis_approved` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `approved_sessionsId` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_responsibleForTrackId` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_responsibleForExecutionId` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_title` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_startDate` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_endDate` int(10) unsigned NOT NULL DEFAULT '0',
  `approved_vaziat` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_file` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `approved_description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='مصوبه';

--
-- Dumping data for table `db_hmis`.`hmis_approved`
--

/*!40000 ALTER TABLE `hmis_approved` DISABLE KEYS */;
INSERT INTO `hmis_approved` (`id`,`approved_sessionsId`,`approved_responsibleForTrackId`,`approved_responsibleForExecutionId`,`approved_title`,`approved_startDate`,`approved_endDate`,`approved_vaziat`,`approved_file`,`approved_description`) VALUES 
 (4,5,1,1,'درصد تحقق اهداف اختصصاصی تعیین گردد',13971213,13971228,'غیر قابل انجام','','NO'),
 (5,5,1,1,'جلسه اردیبهشت کمیته ی اجرایی',13971216,13971211,'در حال انجام','','ندارد');
/*!40000 ALTER TABLE `hmis_approved` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_commettes`
--

DROP TABLE IF EXISTS `hmis_commettes`;
CREATE TABLE `hmis_commettes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `commettes_creatorId` int(10) unsigned NOT NULL DEFAULT '0',
  `commettes_superwizar` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `commettes_secretary` varchar(255) DEFAULT NULL,
  `commettes_dateOfHoldingMeeting` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `commettes_members` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `commettes_regulationFile` varchar(100) DEFAULT NULL,
  `commettes_title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `commettes_description` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`hmis_commettes`
--

/*!40000 ALTER TABLE `hmis_commettes` DISABLE KEYS */;
INSERT INTO `hmis_commettes` (`id`,`commettes_creatorId`,`commettes_superwizar`,`commettes_secretary`,`commettes_dateOfHoldingMeeting`,`commettes_members`,`commettes_regulationFile`,`commettes_title`,`commettes_description`) VALUES 
 (3,1,'5','5','سه ماهه دوم','','p6969366164.png%23A%23p8760558388.png%23A%23','کمیته ی مدیریت اجرایی',''),
 (4,1,'4','12','ماهانه','','','کمیته ی مدیریت اجرایی2','');
/*!40000 ALTER TABLE `hmis_commettes` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_plans`
--

DROP TABLE IF EXISTS `hmis_plans`;
CREATE TABLE `hmis_plans` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `plans_typeOfProgram` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_title` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_creatorId` int(10) unsigned NOT NULL DEFAULT '0',
  `plans_superwizarRol` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_minorGoal` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_hugeGoal` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_responsible` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_strategic` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_range` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_causeProblem` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_method` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_titleOfTheProblem` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_thePeriodAssess` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_domain` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_department` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_vaziat` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_ravandeVaziat` longtext CHARACTER SET utf8mb4,
  `plans_description` varchar(250) CHARACTER SET utf8mb4 DEFAULT NULL,
  `plans_date` int(10) unsigned NOT NULL DEFAULT '10000000',
  `plans_correction` varchar(250) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`hmis_plans`
--

/*!40000 ALTER TABLE `hmis_plans` DISABLE KEYS */;
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (1,'برنامه عملیاتی','ندارد',1,'مترون','3','1','مدیریتی','1','بالینی','','','','1','2','1','ثبت اولیه','ثبت اولیه:-1397/11/02 10:24:13#A#','ندارد',10000000,NULL),
 (2,'برنامه عملیاتی','',1,'مدیر مالی','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/02 10:29:51#A#','ندارد',13971102,NULL),
 (3,'برنامه عملیاتی','',1,'مترون','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/03 08:39:04#A#','',13971103,NULL),
 (4,'برنامه بهبود کیفیت','تجهیزات',1,'مدیر مالی','3','3','پشتیباتی','','مدیریتی','زیاد بودن مریض','','','2','1','5','ثبت اولیه','ثبت اولیه:-1397/11/03 09:19:06#A#','ندارد',13971103,NULL),
 (5,'برنامه بهبود کیفیت','',1,'رئیس امور عمومی','1','1','','3','','','','','2','','','ثبت اولیه','ثبت اولیه:-1397/11/13 15:54:33#A#','',13971113,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (6,'برنامه عملیاتی','',1,'مترون','1','1','','3','','','','','2','','1','ثبت اولیه','ثبت اولیه:-1397/11/13 15:56:29#A#','',13971113,NULL),
 (7,'برنامه عملیاتی','',1,'مدیر مالی','1','1','','3','','','','','1','','1','ثبت اولیه','ثبت اولیه:-1397/11/13 16:01:00#A#','',13971113,NULL),
 (8,'برنامه بهبود کیفیت','titlePlans',1,'رئیس امور عمومی','1','3','da','2','بالینی','c','vvvvv','vvvvvvvv','2','2','3','ثبت اولیه','ثبت اولیه:-1397/11/15 08:46:22#A#','dddddaaaaaaa',13971115,NULL),
 (9,'برنامه بهبود کیفیت','titlePlans',1,'مدیر مالی','1','3','da','2','بالینی','c','vvvvv','vvvvvvvv','2','2','3','ثبت اولیه','ثبت اولیه:-1397/11/16 09:24:20#A#','dddddaaaaaaa',13971116,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (10,'برنامه بهبود کیفیت','titlePlans',1,'مدیر مالی','1','3','da','2','بالینی','c','vvvvv','vvvvvvvv','2','2','3','ثبت اولیه','ثبت اولیه:-1397/11/16 09:26:24#A#','dddddaaaaaaa',13971116,NULL),
 (11,'برنامه بهبود کیفیت','',1,'رئیس امور عمومی','1','3','','2','','','','','1','3','3','ثبت اولیه','ثبت اولیه:-1397/11/16 09:37:05#A#','dddddaaaaaaa',13971116,NULL),
 (12,'برنامه عملیاتی','',1,'رئیس امور عمومی','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 09:48:46#A#','',13971116,NULL),
 (13,'برنامه بهبود کیفیت','',1,'مدیر مالی','2','3','','4','','','','','1','','1','ثبت اولیه','ثبت اولیه:-1397/11/16 09:50:35#A#','',13971116,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (14,'برنامه بهبود کیفیت','m',1,'رئیس امور عمومی','','3','مدیریتی','2','بالینی','','','n','2','2','2','ثبت اولیه','ثبت اولیه:-1397/11/16 10:28:42#A#','',13971116,NULL),
 (15,'برنامه بهبود کیفیت','',1,'مدیر مالی','1','1','','3','','','','','2','','2','تایید توسط مافوق','ثبت اولیه:-1397/11/16 10:33:22#A#تایید توسط مافوق-1397/11/16 15:05:54#A#','',13971116,NULL),
 (16,'برنامه بهبود کیفیت','',1,'مدیر مالی','1','1','','3','','','','','2','','2','ثبت اولیه','ثبت اولیه:-1397/11/16 11:37:51#A#','',13971116,NULL),
 (17,'برنامه عملیاتی','',1,'مدیر مالی','','','','','','','','','','','','تایید توسط مافوق','ثبت اولیه:-1397/11/16 11:43:55#A#تایید توسط مافوق-1397/11/16 15:40:06#A#','',13971116,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (18,'برنامه عملیاتی','JJJJ',1,'مترون','1','1','','1','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 11:45:02#A#','',13971116,NULL),
 (19,'برنامه عملیاتی','kk',1,'مترون','3','1','مدیریتی','3','بالینی','','','','3','1','1','تایید توسط مافوق','ثبت اولیه:-1397/11/16 13:45:18#A#تایید توسط مافوق-1397/11/16 14:56:54#A#','aaa',13971116,NULL),
 (20,'برنامه عملیاتی','JJJJ',1,'مترون','1','1','','1','','','','','','','','تایید توسط مافوق','ثبت اولیه:-1397/11/16 15:25:46#A#تایید توسط مافوق-1397/11/16 15:26:15#A#','',13971116,NULL),
 (21,'برنامه عملیاتی','kk',1,'مترون','3','1','مدیریتی','3','بالینی','','','','3','1','1','null','ثبت اولیه:-1397/11/16 15:50:58#A#','aaa',13971116,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (22,'برنامه عملیاتی','kk',1,'مترون','3','1','مدیریتی','3','بالینی','','','','3','1','1','null','ثبت اولیه:-1397/11/16 15:51:19#A#','aaa',13971116,NULL),
 (23,'برنامه عملیاتی','kk',1,'مترون','3','1','مدیریتی','3','بالینی','','','','3','1','1','null','ثبت اولیه:-1397/11/16 15:53:38#A#','aaa',13971116,NULL),
 (24,'برنامه عملیاتی','',1,'مترون','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 15:53:58#A#','',13971116,NULL),
 (25,'برنامه عملیاتی','',1,'مترون','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 15:54:12#A#','',13971116,NULL),
 (26,'برنامه عملیاتی','',1,'مترون','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 15:54:35#A#','',13971116,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (27,'برنامه عملیاتی','',1,'رئیس امور عمومی','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 15:56:10#A#','',13971116,NULL),
 (28,'برنامه عملیاتی','',1,'رئیس امور عمومی','','','','','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 15:58:27#A#','',13971116,NULL),
 (29,'برنامه عملیاتی','JJJJ',1,'مترون','1','1','','1','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 15:59:34#A#','',13971116,NULL),
 (30,'برنامه عملیاتی','JJJJ',1,'مترون','1','1','','1','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 16:01:01#A#','',13971116,NULL),
 (31,'برنامه عملیاتی','JJJJ',1,'مترون','1','1','','1','','','','','','','','ثبت اولیه','ثبت اولیه:-1397/11/16 16:02:13#A#','',13971116,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (32,'برنامه عملیاتی','ندارد',1,'مترون','3','1','مدیریتی','1','بالینی','','','','1','2','1','ثبت اولیه','ثبت اولیه:-1397/11/17 08:31:45#A#','ندارد',13971117,NULL),
 (33,'برنامه عملیاتی','ندارد',1,'مترون','3','1','مدیریتی','1','بالینی','','','','1','2','1','اصلاحیه','ثبت اولیه:-1397/11/17 08:33:18#A#اصلاحیه-1397/11/27 09:49:57#A#','ندارد',13971117,'ilhlh'),
 (34,'برنامه عملیاتی','bb',1,'رئیس امور عمومی','','','','','cb','','','','','','','تایید توسط مافوق','ثبت اولیه:-1397/11/17 08:38:07#A#تایید توسط مافوق-1397/11/17 08:38:28#A#','',13971117,NULL),
 (35,'برنامه عملیاتی','ندارد',1,'مترون','3','1','مدیریتی','1','بالینی','','','','1','2','1','تایید توسط مافوق','ثبت اولیه:-1397/11/17 09:07:41#A#تایید توسط مافوق-1397/11/17 13:19:43#A#','ندارد',13971117,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (36,'برنامه عملیاتی','ندارد',1,'مترون','3','1','مدیریتی','1','بالینی','','','','1','2','1','تایید توسط مافوق','ثبت اولیه:-1397/11/17 13:33:50#A#اصلاحیه-1397/11/17 15:42:18#A#تایید توسط مافوق-1397/11/27 08:54:00#A#','ندارد',13971117,''),
 (37,'برنامه عملیاتی','ندارد',1,'مترون','3','1','مدیریتی','1','بالینی','','','','1','2','1','تایید توسط مافوق','ثبت اولیه:-1397/11/27 08:59:33#A#تایید توسط مافوق-1397/11/30 09:14:53#A#','ندارد',13971127,NULL),
 (38,'برنامه بهبود کیفیت','knhvn',1,'رئیس امور عمومی','2','2','مدیریتی','2','بالینی','knhvn','پیگیری','knhvn','2','1','','ثبت اولیه','ثبت اولیه:-1397/12/04 08:31:35#A#','ندارد',13971204,NULL);
INSERT INTO `hmis_plans` (`id`,`plans_typeOfProgram`,`plans_title`,`plans_creatorId`,`plans_superwizarRol`,`plans_minorGoal`,`plans_hugeGoal`,`plans_responsible`,`plans_strategic`,`plans_range`,`plans_causeProblem`,`plans_method`,`plans_titleOfTheProblem`,`plans_thePeriodAssess`,`plans_domain`,`plans_department`,`plans_vaziat`,`plans_ravandeVaziat`,`plans_description`,`plans_date`,`plans_correction`) VALUES 
 (39,'برنامه بهبود کیفیت','knhvn',1,'رئیس امور عمومی','2','2','مدیریتی','2','بالینی','knhvn','پیگیری','knhvn','2','1','','اصلاحیه','ثبت اولیه:-1397/12/04 08:41:17#A#اصلاحیه-1397/12/04 09:29:38#A#','ندارد',13971204,'hdhfdh');
/*!40000 ALTER TABLE `hmis_plans` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_sessions`
--

DROP TABLE IF EXISTS `hmis_sessions`;
CREATE TABLE `hmis_sessions` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sessions_craetorId` int(11) NOT NULL DEFAULT '0',
  `sessions_commettesId` int(11) NOT NULL DEFAULT '0',
  `sessions_title` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_contextInvitation` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_agenda` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_date` varchar(45) DEFAULT NULL,
  `sessions_time` varchar(45) DEFAULT NULL,
  `sessions_dateReminder` varchar(45) DEFAULT NULL,
  `sessions_timeReminder` varchar(45) DEFAULT NULL,
  `sessions_Invitees` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_InviteesOutSide` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_file` varchar(45) DEFAULT NULL,
  `sessions_vaziat` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_ravandeVaziat` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_nextSessionDate` varchar(255) DEFAULT NULL,
  `sessions_strengths` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_weakPoint` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_titleIssue` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_checkingAgenda` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_titleFile` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_sessionDescription` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sessions_proposedSolution` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`hmis_sessions`
--

/*!40000 ALTER TABLE `hmis_sessions` DISABLE KEYS */;
INSERT INTO `hmis_sessions` (`id`,`sessions_craetorId`,`sessions_commettesId`,`sessions_title`,`sessions_contextInvitation`,`sessions_agenda`,`sessions_date`,`sessions_time`,`sessions_dateReminder`,`sessions_timeReminder`,`sessions_Invitees`,`sessions_InviteesOutSide`,`sessions_file`,`sessions_vaziat`,`sessions_ravandeVaziat`,`sessions_nextSessionDate`,`sessions_strengths`,`sessions_weakPoint`,`sessions_titleIssue`,`sessions_checkingAgenda`,`sessions_titleFile`,`sessions_sessionDescription`,`sessions_proposedSolution`) VALUES 
 (5,1,3,'جلسه خرداد کمیته ی اجرایی','متن دعوتنامه','دستور جلسه','1397/12/29','8 : 59 AM','1397/12/01','8 : 59 AM','1#A#2#A#3#A#','093025215487#A#09132254857#A#09121154585#A#','',NULL,NULL,'1397/12/05','قوت','ضعف','عنوان مسئله','دستور جلسه','عنوان فایل','شرح  جلسه','proposed');
/*!40000 ALTER TABLE `hmis_sessions` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`hmis_steps`
--

DROP TABLE IF EXISTS `hmis_steps`;
CREATE TABLE `hmis_steps` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `steps_plansId` int(10) unsigned NOT NULL DEFAULT '0',
  `steps_title` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_responsibleForRunning` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_responsibleForTrack` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_otherIndicators` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_startDate` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_endDate` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_cost` varchar(20) DEFAULT NULL,
  `steps_file1` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `steps_file2` varchar(45) DEFAULT NULL,
  `steps_file3` varchar(45) DEFAULT NULL,
  `steps_vaziat` varchar(100) DEFAULT NULL,
  `steps_ravandeVaziat` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`hmis_steps`
--

/*!40000 ALTER TABLE `hmis_steps` DISABLE KEYS */;
INSERT INTO `hmis_steps` (`id`,`steps_plansId`,`steps_title`,`steps_responsibleForRunning`,`steps_responsibleForTrack`,`steps_otherIndicators`,`steps_startDate`,`steps_endDate`,`steps_cost`,`steps_file1`,`steps_file2`,`steps_file3`,`steps_vaziat`,`steps_ravandeVaziat`) VALUES 
 (1,4,'','','','12','13970202','13961210','','','','',NULL,NULL),
 (2,4,'','','','102','13980102','13970201','','','','',NULL,NULL),
 (3,4,'titile','1','1','knhvn','13970201','13970102','12100000','','','',NULL,NULL),
 (4,4,'گام اجرایی','2','1','ندارد','13980205','13970205','50000','','','',NULL,NULL),
 (5,8,'xx','1','4','','','','200000000','','','',NULL,NULL),
 (6,13,'x','2','3','','','','40000','','','',NULL,NULL),
 (7,14,'hhh','2','4','','','','1200000','','','',NULL,NULL),
 (8,15,'x','2','3','','','','12100','','','',NULL,NULL),
 (9,12,'x','2','3','','','','50000','','','',NULL,NULL),
 (10,15,'z','1','3','','','','200000','','','',NULL,NULL),
 (11,18,'','','','','','','','','','',NULL,NULL),
 (12,18,'','','','','','','','','','',NULL,NULL),
 (13,18,'nnn','1','','x','','','503000','','','',NULL,NULL);
INSERT INTO `hmis_steps` (`id`,`steps_plansId`,`steps_title`,`steps_responsibleForRunning`,`steps_responsibleForTrack`,`steps_otherIndicators`,`steps_startDate`,`steps_endDate`,`steps_cost`,`steps_file1`,`steps_file2`,`steps_file3`,`steps_vaziat`,`steps_ravandeVaziat`) VALUES 
 (14,19,'kkk','1','3','','','','50000','','','',NULL,NULL),
 (15,19,'xxx','1','3','','','','1200000','','','',NULL,NULL),
 (16,19,'','','','','','','','','','',NULL,NULL),
 (17,1,'z','1','3','','','','','','','',NULL,NULL),
 (18,20,'z','1','','','','','','','','',NULL,NULL),
 (19,32,'','','','','','','','','','',NULL,NULL),
 (20,33,'f','2','','','','','85000000','','','',NULL,NULL),
 (21,34,'jj','','','','','','','','','',NULL,NULL),
 (22,34,'','','','','','','','','','',NULL,NULL),
 (23,35,'ظ','1','2','','','','450000','','','',NULL,NULL),
 (24,37,'','','','','','','','','','',NULL,NULL),
 (25,37,'','','','','1397/11/25','1397/12/17','','','','',NULL,NULL),
 (26,37,'گام 1','3','1','','1397/11/09','1397/11/24','1200000','','','',NULL,NULL),
 (27,38,'','','','','','','','','','',NULL,NULL);
INSERT INTO `hmis_steps` (`id`,`steps_plansId`,`steps_title`,`steps_responsibleForRunning`,`steps_responsibleForTrack`,`steps_otherIndicators`,`steps_startDate`,`steps_endDate`,`steps_cost`,`steps_file1`,`steps_file2`,`steps_file3`,`steps_vaziat`,`steps_ravandeVaziat`) VALUES 
 (28,39,'','','','','1397/12/09','1397/12/14','1000000','','','',NULL,NULL),
 (29,38,'','','','','','','','','','',NULL,NULL);
/*!40000 ALTER TABLE `hmis_steps` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`language`
--

DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `language_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_no_item` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `language_available` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_not_available` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_remain_time` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_day` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_hour` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_minute` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_like` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_dis_like` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_visited` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_add_cart` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_related` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_detail` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_product` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_more` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_news` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_payment` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_cont_buy` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_is_user` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_is_not_user` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_product_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_number` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_price` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_sum_price` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_delete` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_sumPayment` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `language_address` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `language_key_word` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`language`
--

/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` (`id`,`language_name`,`language_no_item`,`language_available`,`language_not_available`,`language_remain_time`,`language_day`,`language_hour`,`language_minute`,`language_like`,`language_dis_like`,`language_visited`,`language_add_cart`,`language_related`,`language_detail`,`language_product`,`language_more`,`language_news`,`language_payment`,`language_cont_buy`,`language_is_user`,`language_is_not_user`,`language_product_name`,`language_number`,`language_price`,`language_sum_price`,`language_delete`,`language_sumPayment`,`language_address`,`language_key_word`) VALUES 
 (1,'Farsi','کالایی وجود ندارد.','موجود','ناموجود','زمان باقی مانده','روز','ساعت','دقیقه','موافق','مخالف','بار مشاهده','افزودن به سبد خرید','مطالب مرتبط','مشاهده جزئیات','محصولات','ادامه مطلب','خبر','پرداخت','ادامه خرید','کاربر عضو هستم','کاربر عضو نیستم','نام محصول','تعداد','قیمت','قیمت کل','حذف','مبلغ قابل پرداخت :','آدرس','نمایندگی انحصاری محصولات فیوره-جیادا'),
 (2,'English','No Item!','Available','Not Available','Remain Time','Day','Hour','Minute','Like','Dislike','Visited','Add to shopping cart','Related','Details','Products','more','News','Payment','Continue.','I am user.','I am not user.','Product Name','Numbers','Price','Total Price','Remove','Total price','Address',NULL);
INSERT INTO `language` (`id`,`language_name`,`language_no_item`,`language_available`,`language_not_available`,`language_remain_time`,`language_day`,`language_hour`,`language_minute`,`language_like`,`language_dis_like`,`language_visited`,`language_add_cart`,`language_related`,`language_detail`,`language_product`,`language_more`,`language_news`,`language_payment`,`language_cont_buy`,`language_is_user`,`language_is_not_user`,`language_product_name`,`language_number`,`language_price`,`language_sum_price`,`language_delete`,`language_sumPayment`,`language_address`,`language_key_word`) VALUES 
 (3,'Arabic','الکالایی الوجود الندارد.','الموجود','لا موجود','الزمان الباقیه!!!!','الیوم','الساعه','الدقیقه','الموافق','المخالف','المشاهده','الافزودن به السبد الخرید','المطالب المرتبط','الجزئیات','الانتاج','الادامه المطلب','الاخبار','','','','','','','','','','','',NULL),
 (4,'Germany','-','verfügbar','Nicht verfügbar','-','Tag','Stunde','Minute','Mögen','Abneigung','besucht','Zum Warenkorb hinzufügen','verwandte','Einzelheiten','Produkt','Mehr','Nachrichten','','','','','','','','','','','',NULL);
INSERT INTO `language` (`id`,`language_name`,`language_no_item`,`language_available`,`language_not_available`,`language_remain_time`,`language_day`,`language_hour`,`language_minute`,`language_like`,`language_dis_like`,`language_visited`,`language_add_cart`,`language_related`,`language_detail`,`language_product`,`language_more`,`language_news`,`language_payment`,`language_cont_buy`,`language_is_user`,`language_is_not_user`,`language_product_name`,`language_number`,`language_price`,`language_sum_price`,`language_delete`,`language_sumPayment`,`language_address`,`language_key_word`) VALUES 
 (5,'Chinese','-','可用的','无法使用','-','日','小时','分钟','喜欢','反感','访问','放入购物车','有关','详情','产品','更多','新闻','','','','','','','','','','','',NULL);
/*!40000 ALTER TABLE `language` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `location_haspitalname` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `location_level` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `location_parent` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `location_child` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `location_parentname` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`location`
--

/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`,`location_haspitalname`,`location_level`,`location_parent`,`location_child`,`location_parentname`) VALUES 
 (0,NULL,'0','0',NULL,NULL),
 (1,'بیمارستان','1','0','0',NULL),
 (2,'بخش چشم','2','1',NULL,NULL),
 (3,'چشم مردان','3','2',NULL,NULL),
 (4,'چشم زنان','3','2',NULL,NULL),
 (5,'بخش قلب','2','1',NULL,NULL);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `message_sender` int(10) unsigned DEFAULT NULL,
  `message_geter` int(10) unsigned DEFAULT NULL,
  `message_title` varchar(255) DEFAULT NULL,
  `message_content` longtext,
  `message_attachment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`message`
--

/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`messenger`
--

DROP TABLE IF EXISTS `messenger`;
CREATE TABLE `messenger` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `messenger_title` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_textMessage` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_receiver` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_sender` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_postageDate` varchar(45) DEFAULT NULL,
  `messenger_dateOfCreation` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_displayed` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_status` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `messenger_sendingMethod` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`messenger`
--

/*!40000 ALTER TABLE `messenger` DISABLE KEYS */;
INSERT INTO `messenger` (`id`,`messenger_title`,`messenger_textMessage`,`messenger_receiver`,`messenger_sender`,`messenger_postageDate`,`messenger_dateOfCreation`,`messenger_displayed`,`messenger_status`,`messenger_sendingMethod`) VALUES 
 (1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (2,'n,n,mn,mn',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (3,'mn,mn',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (4,'mmmm',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (5,'nbn',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (8,'nmn,mn','nbnbnb','0121','12','','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `messenger` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_date` int(11) DEFAULT NULL,
  `news_priority` int(10) unsigned DEFAULT NULL,
  `news_title` varchar(255) DEFAULT NULL,
  `news_content` longtext,
  `news_category_id` int(11) DEFAULT NULL,
  `news_parent` int(11) DEFAULT NULL,
  `news_lang` int(10) unsigned DEFAULT NULL,
  `news_pic` varchar(255) DEFAULT NULL,
  `news_abstract` longtext,
  `news_rating` int(11) DEFAULT '0' COMMENT 'out of this service(v1.5.0)',
  `news_visit` int(11) DEFAULT '0',
  `news_likes` int(11) DEFAULT '0',
  `news_disLikes` int(11) DEFAULT '0',
  `news_has_link` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_news_news_group` (`news_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`news`
--

/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`,`news_date`,`news_priority`,`news_title`,`news_content`,`news_category_id`,`news_parent`,`news_lang`,`news_pic`,`news_abstract`,`news_rating`,`news_visit`,`news_likes`,`news_disLikes`,`news_has_link`) VALUES 
 (79,13960427,1,'دکوراسیون چوبی منزل، نجارباشی مرسی هستی!','<p style=\"    line-height: 2em;    font-size: 16px\";><br />اگرشما هم از طرفداران چوب باشید به خوبی می دانید که چه حس و انرژی خوبی با حضور چوب در خانه به شما منتقل می شود. داشتن وسایل چوبی در دکوراسیون منزل آنقدر متنوع است که بسیاری از مواقع نمی توان از بین آنها انتخاب کرد! گاهی شما ایده ای در ذهن خود دارید که آن را در هیچ مغازه و فروشگاهی پیدا نمی کنید و دوست دارید به هر نحوی آن را در چیدمان خانه خود ببینید. پس باید به سراغ افرادی رفت که بتوانند ایده های شما را به مرحله عمل برسانند. چطور می توان این کار را انجام داد؟</p><p style=\"line-height: 2em ;     font-size: 16px;\">این کار هر کسی نیست که بتواند ایده ها، طراحی ها و خواسته های شما را ساخته و اجرا کند. افراد متخصص و نجاران حرفه ای هستند که دست به کار می شوند و با شناخت درست و کامل از بافت، رنگ، ساختار و انواع چوب، وسایل و مبلمان مخصوص و مورد نظر شما را می سازند.</p><p style=\"    line-height: 2em  ;    font-size: 16px;\">بسیاری از نجاران در ساخت کابینت های آشپزخانه مشهور هستند در حالی که حوزه کاری و توانایی های آنها بسیار فراتر از ساخت کابینت می رود. چه شما نیاز به یک مبلمان زیبای دست ساز با منبت کاری های ظریف داشته باشید و چه به طبقه بندی هوشمندانه برای صرفه جویی در فضا، راه حل مشکل در دست نجاران حرفه ای و خبره است.</p><p>&nbsp;</p>',40,0,1,'upload/p3101158365.jpg','اگرشما هم از طرفداران چوب باشید به خوبی می دانید که چه حس و انرژی خوبی با حضور چوب در خانه به شما منتقل می شود. داشتن وسایل چوبی در دکوراسیون منزل آنقدر متنوع است که بسیاری از مواقع نمی توان از بین آنها انتخاب کرد! گاهی شما ایده ای در ذهن خود دارید که آن را در هیچ مغازه و فروشگاهی پیدا نمی کنید....',0,95,-1,-1,1),
 (80,13960427,1,'نحوه ی چیدمان وسایل منزل','<p style=\"    line-height: 2em;    font-size: 16px\">&nbsp;اتاق پذیرایی ویترین خانه شما است و دکوراسیون داخلی آن نقش زیادی در چیدمان کلی منزل دارد از این رو باید در هنگام طراحی اتاق پذیرایی همه حساسیت و دقت لازم را به خرج دهید تا بتوانید زیباترین طراحی را برای پذیرایی تان داشته باشید.</p><p style=\"    line-height: 2em;    font-size: 16px;\">پذیرایی مکانی از منزل است که بیشتر در دید مهمان ها است و امروزه به طراحی پذیرایی اهمیت زیادی داده می شود و بیشتر افراد سعی دارند تا با دیزاین یک دکوراسیون مدرن فضای پذیرایی شان را متفاوت و ایده آل کنند.</p><p style=\"    line-height: 2em;    font-size: 16px;\">در هنگام دیزاین طراحی اتاق پذیرایی ابتدا باید دکوراسیون مورد نظر خود را بر اساس ابعاد پذیرایی و با توجه به امکانات انتخاب کنید سپس طراحی مورد نظر خود را در درون دکوراسیون پذیرایی به مرحله اجراء برسانید. چیدمان و قرار دادن وسایلی نظیر مبل و میز و فرش و تابلو و سایر وسایل تزیین پذیرایی در مکان های مخصوص به خود از عواملی است که باید مورد توجه قرار بگیرد.</p><p style=\"    line-height: 2em;    font-size: 16px;\">رنگ کف پوش و دیوار ها نیز تاثیر زیادی بر روی فضای پذیرایی دارد و علاوه بر رنگ های موجود در دکوراسیون پذیرایی شما باید با یکدیگر مطابقت و همخوانی داشته باشند.<br />علاوه بر چیدمان وسایل طراحی نورپردازی مناسب برای پذیرایی از دیگر نکاتی است که باید مورد توجه قرار بگیرد.</p><p style=\"    line-height: 2em;    font-size: 16px;\">که شرکت ما با توجه به ارمان های خود که مهترینش جلب نظر و رضایت مشتریست در راستای این مهم قدم برداشته است..</p>',39,0,1,'upload/p5278904975.png','اتاق پذیرایی ویترین خانه شما است و دکوراسیون داخلی آن نقش زیادی در چیدمان کلی منزل دارد از این رو باید در هنگام طراحی اتاق پذیرایی همه حساسیت و دقت لازم را به خرج دهید تا بتوانید زیباترین طراحی را برای پذیرایی تان داشته باشید ...',0,71,0,1,1);
INSERT INTO `news` (`id`,`news_date`,`news_priority`,`news_title`,`news_content`,`news_category_id`,`news_parent`,`news_lang`,`news_pic`,`news_abstract`,`news_rating`,`news_visit`,`news_likes`,`news_disLikes`,`news_has_link`) VALUES 
 (81,13960427,1,'نحوه ی تابش نور برای دیزاین خانه','<p style=\"    line-height: 2em;    font-size: 16px;\">نور طبیعی در معماری ساختمان</p><p style=\"    line-height: 2em;    font-size: 16px;\">هر چند که خورشید برای ایجاد روشنایی طبیعی در یک ساختمان مورد نیاز است اما از آنجا که این نور سرانجام به حرارت تبدیل می شود، باید میزان تابش مورد نیاز برای هر ساختمان با توجه به نوع ساختمان و شرایط اقلیمی آن تامین شود چون اهمیت تابش آفتاب به نوع اقلیم منطقه و فصول مختلف سال بستگی دارد. در شرایط سرد حداکثر انرژی خورشیدی مورد نیاز بوده و ساختمان باید در جهتی قرار گیرد که بیشترین تابش آفتاب را دریافت نماید. برعکس وقتی هوا گرم است جهت ساختمان باید به نحوی باشد که شدت آفتاب در دیواره های آن به حداقل رسیده و نیز امکان نفوذ مستقیم اشعه خورشید به فضاهای داخل وجود نداشته باشد به همین دلیل نحوه نورپردازی بنا در اقلیم های مختلف مثل گرم و خشک و حاشیه کویر و اقلیم گرم و مرطوب و سردسیر با هم متفاوت است و هر کدام در این مناطق بر حسب اقلیم خاص خود نحوه ی نورگیری و نورپردازی خاصی را می طلبد.</p><p style=\"    line-height: 2em;    font-size: 16px;\">نور شمال در معماری ساختمان</p><p style=\"    line-height: 2em;    font-size: 16px;\">فضاهایی که رو به شمال هستند (در نیمکره شمالی) نور مستقیم دریافت نمی کنند. نور پراکنده بدون سایه یا انعکاس ایجاد می شود که برای کار کردن و نقاشی کردن و تماشای تلویزیون در کارگاه های نقاشی و دفتر کار مناسب است.<br />به منظور به دست آوردن حداکثر مقدار ممکن نور بدون هراس از نور مستقیم خورشید می توان از پنجره های بزرگ در جهت شمال استفاده کرد اما نور مستقیا در غذاخوری ، نشیمن و .... می توند سلب آسایش نماید . جذاب است اگر نور شمال را با نور در جهت های دیگر ترکیب کنیم. نور شمالی سرد و تمیز است اما نور جنوبی زرد رنگ و مستقیم است. در فضاهای خانگی باید پارکینگ را در شمال نقشه قرار داد و راه پله و انبارها یا هر محلی که زیاد به کار برده نمی شود. در کشورهای بسیار گرم این جهت یابی نامطلوب می شود و چون گرمای بیشتری ایجاد می کند اما برعکس در تابستان فضاهای سایه وار مطلوب تر هستند . فردی که همشیه در اتاق های رو به شمال است و تماس بسیار کمی با خورشید دارد و ممکن است احساس افسردگی و غم در او ایجاد شود .</p><p style=\"    line-height: 2em;    font-size: 16px;\">نور جنوب در معماری ساختمان</p><p style=\"    line-height: 2em;    font-size: 16px;\">حرکت دورانی ظاهری خورشید نسبت به زمین ایجاد می شود به همین دلیل اگرچه خورشید همیشه از شرق طلوع می کند و در غرب غروب می کند برای کشورهای نیمکره شمال خورشید یک خط سیر جنوبی دارد&nbsp; و برای آنها که در نیمکره جنوبی هستند خط سیر شمال دارد به همین دلیل نور خورشید در نیمکره شمال در قسمت جنوب با انحراف بیشتر و شدت گرم کنندگی کمتر در زمستان&nbsp; است و برعکس آن در تابستان می باشد معمولا فرض می شود که نمای جنوبی بهترین جهت یابی برای فضاهای خانگی است یعنی برای محل اتاق نشیمن و فضاهای داخلی خانه از طرف دیگر به دلیل انعکاس های این نور روی شیشه ها و سطوح سیقلی مکان مورد نظر همیشه هم نور مناسبی برای کار کردن نیست در طول ماه های سرد سال شدت گرمی نور برای این اتاق های جنوبی کمتر از اتاق های رو به شمال است اگر مناطق نورگیری اتاق بزرگتر شود آنگاه نیاز به وجود محافظت از نور مستقیم خورشید در تابستان به وجود می آید مثل یک سایبان و ....<br />نور جنوبی سایه و انعکاس ایجاد می کند و اجازه&nbsp; می دهد که با حجم ها بازی شود و منظره زیبایی ایجاد می کند به همین دلیل اشیا را مقابل آن طراحی می کنند یا حتی با قرار دادن یک استخر در مقابل ایوان یا پنجره های اتاق نشیمن با استفاده از انعکاس های روی سطح اب که دائما در حرکت اند روی دیوارها و سقف مناظر دلربایی ایجاد می کنند . جدا از نتایج فیزیکی نتایج روانی این نور دارد که استفاده مناسب باعث احساس سرزندگی می شود .</p><p style=\"    line-height: 2em;    font-size: 16px;\">نور شرق در معماری ساختمان (صبحگاهی)</p><p style=\"    line-height: 2em;    font-size: 16px;\">روشنایی صبح بهترین ابزار برای بیدار شدن از خواب است . خوردن صبحانه کامل بدون شتابزدگی در کنار روشنایی روز ارامش و نیروی کافی به انسان می دهد. بنابراین باید محل قرار گرفتن اتاق خواب و آشپزخانه و نشیمن و اتاق غذا خوری خوب جهت یابی می شود تا بیشترین استفاده از نور صبحگاهی شود که اشعه های آن ضعیف و خنک تر است این نور در زمان معین از دور سایه اجسام را تولید می کند که می توان از این سایه برای تزیین فضا استفاده کرد این نور ابتدا بر گرد و غبار تابیده می شود و با پراکنده شدن آن ها در فضا نور و گرما هم منتشر می شود .</p><p style=\"    line-height: 2em;    font-size: 16px;\">نور غرب در معماری ساختمان (غروب)</p><p style=\"    line-height: 2em;    font-size: 16px;\">با به اتمام رسیدن روز شدت نور کاسته می شود اما انعکاسان هنوز وجود دارد دیوارهای سفید با شدت بیشتر و با رنگ مایل به زرد می درخشند و دیوارهای بتونی رنگ نارنجی تندی به خود می گیرند تمام سطوح شهر تغییر شکل می یابد وقتی خورشید کاملا پایین آمد تابش خود را بر روی سنگ فرش ها ی آسفالت خیابان ها&nbsp; موقف می کند و شهر به یک پرده سینما تبدیل می شود و با گذشت زمان آسمان به سرخی می گراید و کم کم تاریک می شود و زمینه شکل و اشیاء پراکنده می شود و مرزهای اشیا روی همدیگر می افتد بنابراین تشخیص لبه های اشیاء مشکل می شود فضاهایی که در مغرب هستند باید از آخرین نورهای عمودی خورشید حفاظت شوند .</p>',38,0,1,'upload/p8214474063.jpg','هر چند که خورشید برای ایجاد روشنایی طبیعی در یک ساختمان مورد نیاز است اما از آنجا که این نور سرانجام به حرارت تبدیل می شود، باید میزان تابش مورد نیاز برای هر ساختمان با توجه به نوع ساختمان و شرایط اقلیمی آن تامین شود چون اهمیت تابش آفتاب به نوع اقلیم منطقه و فصول مختلف سال بستگی دارد....',0,9,0,0,1),
 (82,13960427,5,'انواع چوب و کاربرد آن ها','<p style=\"    line-height: 2em;    font-size: 16px;\">&nbsp;کاربرد چوب های مختلف:</p><p style=\"    line-height: 2em;    font-size: 16px;\">۱- چوب بلوط (سخت و محکم): مناسب برای روکش گیری (با عرض کمتر از ۱mm)، بشکه سازی، پارکت سازی، کف پوش ساختن تخته هایی که بر روی سقف خانه ها در مناطق پر باران نصب می شوند، (مقاوم در برابر رطوبت و به کارگیری در اسکله سازی و بنادر، استفاده در انواع مبلمان، کتابخانه، میز و صندلی و&hellip; ساخت تراورز (چوب های نصب شده در زیر ریل راه آهن)، ساخت دسته افزار و وسایل، استفاده در ساخت واگن و کشتی سازی و همچنین به عنوان تیرهای شبکه مخابراتی (بعد از اشباء شدن چوب) کاربرد دارند.<br />۲- چوب راش: چوبی است نیمه سخت و سنگین و خوشتراش با قابلیت تورقی بسیار مناسب، مناسب برای روکش گیری الوارگیری، پارکت تراورز، تخته چند لایه، صنایع مبلمان (به خصوص مبلهای خمیده)، قایق سازی.<br />۳- چوب افرا: چوبی است سخت، سنگین، راست تار، خوشکار، سبک و شکننده و قابل تورق و مناسب برای صنایع کف پوش و روکش سازی، ساخت تخته چند لایه، قالب کفش، ساخت لوازم مهندسی، پوشش سطوح بزرگ، دیوار ها و رویه میزها و تخته خرده چوب، قابلیت کنده کاری و ظریف کاری، مجسمه سازی، مبلمان و خراطی.<br />۴- چوب ملچ: از جمله چوب های زیبا، خوش نقش و دکوراتیو ایران می باشد. در درجه اول مناسب برای صنایع روکش سازی می باشد، همچنین ساخت تخته چند لایه، درهای ماسیو (چوب خالص)، ادوات ورزشی و خراطی پایه ها و نرده ها کاربرد دارد. ملچ چوبی نیمه سنگین و نیمه سخت، راست تار و خوشکار با قابلیت تورق عالی است.<br />۵- چوب آزاد: به دلیل وجود خاصیت ارتجاعی و ارتعاشی (الاستیسیته) در مواردی از جمله ساخت وسایل ورزشی قابل ارتجاع (تخته پارالل و بارفیکس)، پاروی قایقرانی، تخته زیر فنر اتومبیل، همچنین ساخت وسایل موسیقی (سنتور) کاربرد دارد. آزاد چوبی سنگین و با دوام است.<br />۶- چوب صنوبر و تبریزی: چوبی راست تار، نیمه سبک و خوشکار و قابل تورق است که به عنوان تیرهای مخابراتی، تیر ساختمانی، کبریت سازی، ساخت وسایل کشاورزی، جعبه سازی و ساخت قفسه بندی کاربرد دارد و کاغذ سازی و تبریزی برای سنبه کاری مناسب است.<br />۷- چوب گردو: چوبی نیمه سبک و نیمه نرم، قابل تورق، راست تار، خوشکار و بسیار بادوام است. چوبی است با مقبولیت جهانی بارگه ها و نقش و نگار بسیار زیبا، صیقل پذیر و همگن می باشد و رنگ پذیری و قابلیت کنده کاری خوب داشته و در صنایع مبلمان گران قیمت، ساخت پارکت، قنداق تفنگ، روکش سازی، مجسمه سازی، ابزار آلات موسیقی و&hellip; پوست گردو در صنایع رنگ رزی و برگ آن خاصیت ضد عفونی کنندگی دارد.<br />۸- زبان گنجشک (ون): چوبی محکم، قوی، بادوام، نسبتا ارزان با خاصیت الاستیکی زیاد که کم پیچ بر می دارد و در ساخت چهار چوب و درب، ساز ویلن، روکش و ساخت وسایل ورزشی (چوب اسکی) به کار برده می شود. (کرم مایل به قهوه ای)<br />۹- چوب ممرز: در ایران گسترده گی زیادی دارد و چوبی مقاوم و با دوام سخت و سنگین است که به عنوان تراورز و تیرک های معادن زغال سنگ، زغال گیری، ساخت واگن و همچنین در ساخت کاغذ کاربرد دارد. مقاوم به سایش است.<br />۱۰- توسکا: چوبی سبک، نرم، راست تار، خوشکار، زیر بافت و قابل تورق می باشد که در تخته چند لایی مخصوصا لایه های وسطی، جعبه سازی، مدل سازی، اسکلت مبلمان کاربرد دارد.<br />۱۱- نمدار (زیسنون- زیر نون): جهت ساخت روکش، تخته چند لایه، مجسمه سازی، خمیر کاغذ، ساخت وسایل تزئیناتی، مداد سازی و کارهای ساختمانی کاربرد دارد.<br />۱۲- چنار: چوبی سخت و راست تار، کم دوام، با قابلیت میخ خور خوب، در ساخت مبلمان و غربال، روکش سازی و همچنین ستون معابد و مساجد کاربرد دارد. پرداخت پذیر و با برش بدون پودر. (کارهای ظریف)<br />۱۳- چوب ساج: چوبی سنگین، روغنی، خوش تراش و زیبا که از آن در ساخت مجسمه های چوبی استفاده می گردد.<br />۱۴- چوب کاج: چوبی نرم، راست تار، سبک که کم دوام است و زود می پوسد، و از آن برای ساخت جعبه، مبلمان و همچنین کاغذ سازی استفاده می شود.<br />۱۵- چوب گلابی (امرود): چوبی سخت و مقاوم با دوام، راست تار، صاف،سنگین که در ساخت ابزارهای چوبی دقیق (مانند خط کش)، قاب سازی و ادوات چوبی وهمچنین در ساخت مهر (مهر قالب پارچه قلمکار) به کار می رود.<br />۱۶- چوب آبنوس: چوبی بسیار سخت و سنگین بوده که دارای استحکام فراوان می باشد لذا کم یاب و گران می باشد و از آن در ساخت خاتم (به عنوان مثلث های سیاه رنگ) استفاده می شود.<br />۱۷- چوب توت سفید: چوبی سخت، سنگین، راست تار و بادوام است که در ساخت روکش، ابزار چوبی منزل، خاتم کاری و ساخت سازهای موسیقی کاربرد دارد.<br />۱۸- چوب سرو: چوبی بسیار نرم و سبک که به آسانی قابل کار کردن و رنگ آمیزی می باشد و از آن بیشتر برای پوشش داخلی دیواره ها در کابین و ساختمان استفاده می شود. (قرمز مایل به قهوه ای)<br />۱۹- نارون: چوبی محکم، سنگین، مناسب برای هوای مرطوب با نقوش زیبا که از آن اغلب روکش تهیه می کنند و به علت خاصیت خم پذیری برای کارهایی که پیچاندن چوب لازم باشد به کار می رود.<br />۲۰٫ چوب ارسی: چوبی سخت، معطر، محکم و قوی که به آسانی خم می شود و زود می پوسد برای مبلمان سازی کاربرد داشته و برای خراطی بسیار مناسب است.<br />۲۱- چوب انجیلی: بسیار سخت با وزن مخصوص بالاست شکننده بوده و برای ستون معادن و تونل ها و اشیاء مقاوم به سایش (قرقره، دوک نخ ریسی، پاشنه کفش) به کار می رود.<br />۲۲- چوب شمشاد: از چوب های بسیار سخت، متراکم و سنگین و بادوام که در ساخت صنایع دستی و ادوات مهندسی لوازم خانگی کاربرد دارد.<br />۲۳- ماهون: چوبی نیمه سخت و نیمه مستحکم با سنگینی متوسط که از آن برای ساخت مبلمان گران قیمت استفاده می شود. از جمله زیباترین چوب های جهان است.<br />۲۴- سرخدار: چوبی سخت و سنگین و مقاوم در برابر حشرات که در منبت کاری، قایق سازی و مصنوعات تزئینی کاربرد دارند.<br />انواع چوب های مناسب در ایران برای مبل سازی و تزئینات<br />افرا، ملچ، آزاد، زبان گنجیشک، گردو، راش، گلابی، گیلاس وحشی</p><p>&nbsp;</p>',1,0,1,'upload/p7602435707.jpg','',0,79,0,0,1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `payment_order_id` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `payment_factor_id` int(10) unsigned DEFAULT NULL,
  `payment_user_id` int(10) unsigned DEFAULT NULL,
  `payment_sale_refrence_id` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `payment_amount` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `payment_status` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `payment_date` int(10) unsigned DEFAULT NULL,
  `payment_user_Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`payment_setting`
--

DROP TABLE IF EXISTS `payment_setting`;
CREATE TABLE `payment_setting` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `payment_setting_terminal_id` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `payment_setting_userName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `payment_setting_pass` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `payment_setting_webService` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `payment_setting_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`payment_setting`
--

/*!40000 ALTER TABLE `payment_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_setting` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`pic`
--

DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gallery_id` int(11) DEFAULT NULL,
  `pic_title` varchar(255) DEFAULT NULL,
  `pic_pic_name` varchar(255) DEFAULT NULL,
  `pic_pic_ex` varchar(255) DEFAULT NULL,
  `pic_parent` int(10) unsigned DEFAULT NULL,
  `pic_lang` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=294 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`pic`
--

/*!40000 ALTER TABLE `pic` DISABLE KEYS */;
INSERT INTO `pic` (`id`,`gallery_id`,`pic_title`,`pic_pic_name`,`pic_pic_ex`,`pic_parent`,`pic_lang`) VALUES 
 (266,8,'غلطک','p4043816080','jpg',0,1),
 (267,8,'','p9405410998','jpg',0,1),
 (268,8,'','p8362214795','jpg',0,1),
 (269,8,'','p9227815168','jpg',0,1),
 (270,8,'','p3939568203','jpg',0,1),
 (271,8,'telegram','p9319425439','png',0,1),
 (273,8,'اینستاگرام','p5671467677','png',0,1),
 (274,8,'تلفن','p5221207169','png',0,1),
 (275,8,'','p0142387902','jpg',0,1),
 (276,1,'طراحی نوین با اخرین متد روز','p6543754336','jpg',0,1),
 (277,1,'ایده هایی نو توسط گروهی مهندسی نجار باشی','p8507343636','jpg',0,1),
 (278,1,'زیباترین دکوراسیون داخلی ','p0880582719','jpg',0,1),
 (279,8,'','p3101158365','jpg',0,1),
 (280,8,'','p5278904975','png',0,1),
 (281,8,'','p8214474063','jpg',0,1),
 (282,8,'','p7602435707','jpg',0,1),
 (283,8,'','p3770156366','jpg',0,1),
 (284,8,'','p0287434713','jpg',0,1),
 (285,8,'','p9597474142','jpg',0,1),
 (286,8,'','p8235864541','jpg',0,1);
INSERT INTO `pic` (`id`,`gallery_id`,`pic_title`,`pic_pic_name`,`pic_pic_ex`,`pic_parent`,`pic_lang`) VALUES 
 (287,8,'','p2939500791','jpg',0,1),
 (288,8,'','p9194607129','jpg',0,1),
 (289,8,'','p1805562761','jpg',0,1),
 (291,8,'','p5720258813','png',0,1),
 (292,8,'','p5388983158','png',0,1),
 (293,8,'','p5694229609','png',0,1);
/*!40000 ALTER TABLE `pic` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`poll`
--

DROP TABLE IF EXISTS `poll`;
CREATE TABLE `poll` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `poll_qu` varchar(255) DEFAULT NULL,
  `poll_an1` varchar(100) DEFAULT NULL,
  `poll_an2` varchar(100) DEFAULT NULL,
  `poll_an3` varchar(100) DEFAULT NULL,
  `poll_an4` varchar(100) DEFAULT NULL,
  `poll_an5` varchar(100) DEFAULT NULL,
  `poll_an6` varchar(100) DEFAULT NULL,
  `poll_lang` int(10) unsigned DEFAULT NULL,
  `poll_parent` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`poll`
--

/*!40000 ALTER TABLE `poll` DISABLE KEYS */;
INSERT INTO `poll` (`id`,`poll_qu`,`poll_an1`,`poll_an2`,`poll_an3`,`poll_an4`,`poll_an5`,`poll_an6`,`poll_lang`,`poll_parent`) VALUES 
 (1,'آیا ظاهر سایت را می پسندید؟','بله','خیر','','','','',1,0);
/*!40000 ALTER TABLE `poll` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`portal_post`
--

DROP TABLE IF EXISTS `portal_post`;
CREATE TABLE `portal_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `portal_post_title` varchar(255) DEFAULT NULL,
  `portal_post_ownerId` int(10) unsigned DEFAULT '0',
  `portal_post_ownerName` varchar(255) DEFAULT NULL,
  `portal_post_detail` longtext,
  `portal_post_date` int(10) unsigned DEFAULT '0',
  `portal_post_priority` int(10) unsigned DEFAULT '0',
  `portal_post_val1` varchar(50) DEFAULT NULL,
  `portal_post_val2` varchar(50) DEFAULT NULL,
  `portal_post_val3` varchar(50) DEFAULT NULL,
  `portal_post_val4` varchar(50) DEFAULT NULL,
  `portal_post_val5` varchar(50) DEFAULT NULL,
  `portal_post_val6` varchar(50) DEFAULT NULL,
  `portal_post_val7` varchar(50) DEFAULT NULL,
  `portal_post_val8` varchar(50) DEFAULT NULL,
  `portal_post_val9` varchar(50) DEFAULT NULL,
  `portal_post_val10` varchar(50) DEFAULT NULL,
  `portal_post_pic1` varchar(255) DEFAULT NULL,
  `portal_post_pic2` varchar(255) DEFAULT NULL,
  `portal_post_pic3` varchar(255) DEFAULT NULL,
  `portal_post_pic4` varchar(255) DEFAULT NULL,
  `portal_post_pic5` varchar(255) DEFAULT NULL,
  `portal_post_visit` int(11) NOT NULL DEFAULT '0',
  `portal_post_like` int(11) DEFAULT '0',
  `portal_post_dislike` int(11) NOT NULL DEFAULT '0',
  `portal_post_isActive` tinyint(1) NOT NULL DEFAULT '0',
  `portal_post_parent` varchar(45) DEFAULT NULL COMMENT 'for language',
  `portal_post_prop1` varchar(45) DEFAULT NULL,
  `portal_post_prop2` varchar(45) DEFAULT NULL,
  `portal_post_prop3` varchar(45) DEFAULT NULL,
  `portal_post_prop4` varchar(45) DEFAULT NULL,
  `portal_post_prop5` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`portal_post`
--

/*!40000 ALTER TABLE `portal_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `portal_post` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`portal_user`
--

DROP TABLE IF EXISTS `portal_user`;
CREATE TABLE `portal_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `portal_user_UserId` int(10) unsigned NOT NULL COMMENT '???? ??? ?? ???? ??????-??????? ???? ???',
  `portal_user_UserName` varchar(255) DEFAULT NULL,
  `portal_user_pass` varchar(255) DEFAULT NULL,
  `portal_user_firstName` varchar(255) DEFAULT NULL,
  `portal_user_lastName` varchar(255) DEFAULT NULL,
  `portal_user_pageTitle1` varchar(255) DEFAULT NULL,
  `portal_user_pageTitle2` varchar(255) DEFAULT NULL,
  `portal_user_pic` varchar(255) DEFAULT NULL,
  `portal_user_mobile` varchar(45) DEFAULT NULL,
  `portal_user_phone` varchar(45) DEFAULT NULL,
  `portal_user_val1` varchar(255) DEFAULT NULL,
  `portal_user_val2` varchar(255) DEFAULT NULL,
  `portal_user_val3` varchar(255) DEFAULT NULL,
  `portal_user_val4` varchar(255) DEFAULT NULL,
  `portal_user_val5` varchar(255) DEFAULT NULL,
  `portal_user_val6` varchar(255) DEFAULT NULL,
  `portal_user_val7` varchar(255) DEFAULT NULL,
  `portal_user_val8` varchar(255) DEFAULT NULL,
  `portal_user_val9` varchar(255) DEFAULT NULL,
  `portal_user_val10` varchar(255) DEFAULT NULL,
  `portal_user_address` varchar(255) DEFAULT NULL,
  `portal_user_comment` varchar(255) DEFAULT NULL,
  `portal_user_isActive` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `portal_user_blocked` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `portal_user_status` varchar(45) DEFAULT NULL,
  `portal_user_visit` int(11) NOT NULL DEFAULT '0',
  `portal_user_creationDate` int(10) unsigned DEFAULT '0',
  `portal_user_content` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`portal_user`
--

/*!40000 ALTER TABLE `portal_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `portal_user` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_title` varchar(255) DEFAULT NULL,
  `product_des` varchar(255) DEFAULT NULL,
  `product_pic` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_persian_ci DEFAULT NULL,
  `product_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_persian_ci DEFAULT NULL,
  `product_lang` int(10) unsigned DEFAULT NULL,
  `product_parent` int(10) unsigned DEFAULT NULL,
  `product_detales` longtext COMMENT 'new in v1.5.0',
  `product_lable` varchar(255) DEFAULT NULL COMMENT 'new in v1.5.0',
  `product_numbers` int(11) DEFAULT NULL COMMENT 'new in v1.5.0',
  `product_field1` varchar(255) DEFAULT NULL COMMENT 'new in v1.5.0',
  `product_field2` varchar(255) DEFAULT NULL COMMENT 'new in v1.5.0',
  `product_field3` varchar(255) DEFAULT NULL COMMENT 'new in v1.5.0',
  `product_field4` varchar(255) DEFAULT NULL COMMENT 'new in v1.5.0',
  `product_des2` varchar(255) DEFAULT NULL COMMENT 'new in v1.5.0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_hmis`.`product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_title` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_user_id` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_date` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_condition` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_comment` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_discription` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_email` varchar(45) DEFAULT NULL,
  `role_family` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`role_title`,`role_user_id`,`role_date`,`role_condition`,`role_comment`,`role_discription`,`role_email`,`role_family`,`role_name`) VALUES 
 (3,'nmmnm','6','','','مترون2','','amirmohamad.salimi@yahoo.com','salimi','amirmohamad'),
 (4,'مدیر کمیته','12','','active','مدیر کمیته',NULL,NULL,NULL,NULL),
 (5,'nbmnbn','5','','active','','',NULL,NULL,NULL),
 (6,'hjkjhkjhkjhkjhkjhkjhkjhkjhkjh','11','','noActive','',NULL,NULL,NULL,NULL),
 (7,'مترون','5','','noActive','مترون',NULL,NULL,NULL,NULL),
 (8,'پرستار','12','','active','پرستار',NULL,NULL,NULL,NULL),
 (9,'hggjhgjhgjhg','13',NULL,'noActive','nmnmmnmn,m',NULL,NULL,NULL,NULL),
 (10,'hjkjhkjhkjhkjhkjhkjhkjhkjhkjh','12',NULL,'noActive','mbmnbmn',NULL,NULL,NULL,NULL),
 (11,'','9','','active','',NULL,NULL,NULL,NULL),
 (12,'hhhh','13','1397/12/11','noActive','bbbbbbb',NULL,NULL,NULL,NULL),
 (13,'','13','','noActive','',NULL,NULL,NULL,NULL),
 (14,'mnmn,n,n,mn,m','13','','active','',NULL,NULL,NULL,NULL),
 (15,'دبیر کمیته','12','','noActive','',NULL,NULL,NULL,NULL);
INSERT INTO `role` (`id`,`role_title`,`role_user_id`,`role_date`,`role_condition`,`role_comment`,`role_discription`,`role_email`,`role_family`,`role_name`) VALUES 
 (16,'دبیر کمیته','15','1397/12/01','noActive','',NULL,NULL,NULL,NULL),
 (17,'دبیر کمیته','15','1397/12/13','noActive','دبیر',NULL,NULL,NULL,NULL),
 (18,'mnmn','13','','','nnnnn','mnmn,m',NULL,NULL,NULL),
 (19,'','6','','undefined','','','amirmohamad.salimi@yahoo.com','salimi','amirmohamad');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`sms`
--

DROP TABLE IF EXISTS `sms`;
CREATE TABLE `sms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sms_text` varchar(500) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_sender` longtext CHARACTER SET utf8,
  `sms_status` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_date` int(10) unsigned NOT NULL DEFAULT '0',
  `sms_receiver` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_receiver_name` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_receiver_family` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_comment` longtext CHARACTER SET utf8,
  `sms_receiver_id` int(11) NOT NULL DEFAULT '0',
  `sms_subject` longtext CHARACTER SET utf8,
  `sms_characters` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_messageID` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `sms_send_time` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `sms_webService` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`sms`
--

/*!40000 ALTER TABLE `sms` DISABLE KEYS */;
INSERT INTO `sms` (`id`,`sms_text`,`sms_sender`,`sms_status`,`sms_date`,`sms_receiver`,`sms_receiver_name`,`sms_receiver_family`,`sms_comment`,`sms_receiver_id`,`sms_subject`,`sms_characters`,`sms_messageID`,`sms_send_time`,`sms_webService`) VALUES 
 (1,'دوست عزیز درخواست شما درسایت موسسه زبان هفت اقلیم ثبت گردید.سربلندباشید','09125662205','شناسه ی پیامک نامعتبر است',13940522,'','BABAK','','',0,'پیامک  نظرات/پیام ها','0','0','','');
/*!40000 ALTER TABLE `sms` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`sms_config`
--

DROP TABLE IF EXISTS `sms_config`;
CREATE TABLE `sms_config` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sms_config_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_wsdl` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_number` varchar(18) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_key` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_comment` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_status` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_system` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `sms_config_log` longtext CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`sms_config`
--

/*!40000 ALTER TABLE `sms_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_config` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`sms_setting`
--

DROP TABLE IF EXISTS `sms_setting`;
CREATE TABLE `sms_setting` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `smsSetting_apiKey` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_userName` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_pass` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_exclusive_numbers` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_webService` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_wsdl` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_domain` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `smsSetting_comment` longtext CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`sms_setting`
--

/*!40000 ALTER TABLE `sms_setting` DISABLE KEYS */;
INSERT INTO `sms_setting` (`id`,`smsSetting_apiKey`,`smsSetting_userName`,`smsSetting_pass`,`smsSetting_exclusive_numbers`,`smsSetting_webService`,`smsSetting_wsdl`,`smsSetting_domain`,`smsSetting_comment`) VALUES 
 (1,'-','atefeh_rashidi@outlook.com','-','30006703323323,300002525,5000160391,10008642,2000235','kavenegar.com','http://api.kavenegar.com/soap/v1.asmx?WSDL','--','');
/*!40000 ALTER TABLE `sms_setting` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tags_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`tags`
--

/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;


--
-- Table structure for table `db_hmis`.`upload`
--

DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `upload_file_name` varchar(455) DEFAULT NULL,
  `upload_date` varchar(45) DEFAULT NULL,
  `upload_title` varchar(45) DEFAULT NULL,
  `upload_comment` varchar(45) DEFAULT NULL,
  `upload_time` varchar(45) DEFAULT NULL,
  `upload_loader` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=384 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_hmis`.`upload`
--

/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
INSERT INTO `upload` (`id`,`upload_file_name`,`upload_date`,`upload_title`,`upload_comment`,`upload_time`,`upload_loader`) VALUES 
 (382,'p3886347852.png','13971222','png',NULL,'15:01:12','1'),
 (383,'p1675185331.png','13971222','png',NULL,'15:02:00','1');
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
