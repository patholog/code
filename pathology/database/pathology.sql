# Host: localhost  (Version: 5.0.27-community-nt)
# Date: 2017-06-14 11:57:09
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "case"
#

DROP TABLE IF EXISTS `case`;
CREATE TABLE `case` (
  `id_case` varchar(32) NOT NULL default '',
  `hospitalcode` varchar(50) NOT NULL default '',
  `patientname` varchar(50) default NULL,
  `patientage` varchar(20) default NULL,
  `ageunit` varchar(20) default NULL,
  `patientsex` varchar(10) default NULL,
  `patientbirthday` datetime default NULL,
  `patientoccupation` varchar(50) default NULL,
  `pathologyno` varchar(50) default NULL,
  `idcard` varchar(32) default NULL,
  `mobile` varchar(16) default NULL,
  `specimenname` varchar(32) default NULL,
  `specimentype` varchar(20) default NULL,
  `inspectiondate` datetime default NULL,
  `clinicdiagnose` varchar(512) default NULL,
  `historysummary` varchar(512) default NULL,
  `isdeleted` varchar(10) default NULL,
  `deletor` varchar(50) default NULL,
  PRIMARY KEY  (`id_case`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "case"
#


#
# Source for table "cons"
#

DROP TABLE IF EXISTS `cons`;
CREATE TABLE `cons` (
  `id_cons` varchar(32) NOT NULL default '',
  `fromhospitalid` varchar(32) default NULL,
  `fromdoctorid` varchar(32) default NULL,
  `tohospitalid` varchar(32) default NULL,
  `todoctorid` varchar(32) default NULL,
  `applydatetime` datetime default NULL,
  `transferparentid` varchar(32) default NULL,
  `isdeleted` varchar(10) default NULL,
  `deletor` varchar(50) default NULL,
  PRIMARY KEY  (`id_cons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "cons"
#


#
# Source for table "hospital"
#

DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `id_hospital` varchar(32) NOT NULL default '',
  `name` varchar(50) NOT NULL default '',
  `code` varchar(50) default NULL,
  `hospitalcode` varchar(50) default NULL,
  `address` varchar(128) default NULL,
  `tel` varchar(50) default NULL,
  `memo` varchar(128) default NULL,
  `transferedhospital` varchar(32) default NULL,
  `delete` varchar(10) default NULL,
  `createTime` datetime default NULL,
  `creator` varchar(32) default NULL,
  PRIMARY KEY  (`id_hospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "hospital"
#


#
# Source for table "notice"
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id_notice` varchar(32) NOT NULL default '',
  `name` varchar(100) NOT NULL default '',
  `content` varchar(10240) default NULL,
  `creator` varchar(200) default NULL,
  `createtime` datetime default NULL,
  `groupid` varchar(100) default NULL,
  `isdeleted` varchar(20) default NULL,
  `deletor` varchar(50) default NULL,
  PRIMARY KEY  (`id_notice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "notice"
#


#
# Source for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id_users` varchar(32) NOT NULL default '',
  `username` varchar(100) NOT NULL default '',
  `realname` varchar(32) default NULL,
  `sex` varchar(8) default NULL,
  `birthday` datetime default NULL,
  `email` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `belonghospital` varchar(32) default NULL,
  `signature` varchar(255) default NULL,
  `stateid` varchar(32) default NULL,
  `specialty` varchar(521) default NULL,
  `mobile` varchar(16) default NULL,
  `tel` varchar(16) default NULL,
  `isdeleted` varchar(10) default NULL,
  `deletor` varchar(32) default NULL,
  `userstatus` varchar(1) default NULL,
  PRIMARY KEY  (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

INSERT INTO `users` VALUES ('1','user1','ddddd','男',NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('2','user2','ddddddddd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
