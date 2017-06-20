# Host: localhost  (Version 5.0.27-community-nt)
# Date: 2017-06-20 16:57:09
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "bank"
#

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id_bank` varchar(50) NOT NULL default '',
  `userId` varchar(255) default NULL,
  `accountType` varchar(255) default NULL,
  `accountName` varchar(255) default NULL,
  `accountNo` varchar(255) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_bank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='é¶è¡';

#
# Data for table "bank"
#


#
# Structure for table "case"
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
  `memo` varchar(255) default NULL,
  `SORT_NO` varchar(255) default NULL,
  `SPELL_NO` varchar(255) default NULL,
  `WUBI_NO` varchar(255) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(255) default NULL,
  `CRT_DEPT_CD` varchar(255) default NULL,
  `LAST_UPD_TIME` datetime default NULL,
  `LAST_UPD_DEPT_CD` varchar(255) default NULL,
  `LAST_UPD_USER_ID` varchar(255) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_case`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "case"
#


#
# Structure for table "collection"
#

DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id_collection` varchar(50) NOT NULL default '',
  `case_Id` varchar(255) default NULL,
  `collectioner_Id` varchar(255) default NULL,
  `collectionTime` datetime default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_collection`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ççæ¶è';

#
# Data for table "collection"
#


#
# Structure for table "description_app"
#

DROP TABLE IF EXISTS `description_app`;
CREATE TABLE `description_app` (
  `id_description_app` varchar(11) NOT NULL default '' COMMENT 'ä¸»é®',
  `fromHospitalId` varchar(255) default NULL COMMENT 'ç³è¯·å»é¢',
  `fromDoctorId` varchar(255) default NULL COMMENT 'ç³è¯·å»ç',
  `toHospitalId` varchar(255) default NULL,
  `toDoctorId` varchar(255) default NULL,
  `applyDateTime` datetime default NULL,
  `transferParentId` varchar(255) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_description_app`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ä¼è¯ç³è¯·';

#
# Data for table "description_app"
#


#
# Structure for table "function"
#

DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id_function` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `name` varchar(255) default NULL COMMENT 'åè½åç§°',
  `url` varchar(255) default NULL COMMENT 'url',
  `short` varchar(255) default NULL COMMENT 'é¡ºåº',
  `description` varchar(255) default NULL COMMENT 'æè¿°',
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_function`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "function"
#


#
# Structure for table "hospital"
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
  `deleted` varchar(10) default NULL,
  `createTime` datetime default NULL,
  `creator` varchar(32) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_hospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "hospital"
#


#
# Structure for table "image"
#

DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id_image` varchar(50) NOT NULL default '',
  `case_id` varchar(255) default NULL,
  `row_image` int(11) default NULL,
  `col_image` int(11) default NULL,
  `path_image` varchar(255) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='å¾å';

#
# Data for table "image"
#


#
# Structure for table "message"
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id_message` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `fromDoctorId` varchar(255) default NULL,
  `toDoctorId` varchar(255) default NULL,
  `content` varchar(1000) default NULL,
  `case_id` varchar(255) default NULL,
  `messageOrder` varchar(255) default NULL,
  `isReaded` varchar(255) default NULL,
  `createTime` datetime default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_message`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='çè¨';

#
# Data for table "message"
#


#
# Structure for table "notice"
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
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_notice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "notice"
#


#
# Structure for table "permissions"
#

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `Id_permissions` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `name` varchar(255) default NULL COMMENT 'æéåç§°',
  `description` varchar(255) default NULL COMMENT 'æè¿°',
  `element` varchar(255) default NULL COMMENT 'åç´ ',
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`Id_permissions`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='æé';

#
# Data for table "permissions"
#


#
# Structure for table "result"
#

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id_Result` varchar(50) NOT NULL default '',
  `case_id` varchar(255) default NULL,
  `doctorId` varchar(255) default NULL,
  `reportTime` datetime default NULL,
  `reportOrder` int(11) default NULL,
  `generalSee` varchar(4000) default NULL COMMENT 'å¤§ä½æè§',
  `microscopeSee` varchar(4000) default NULL COMMENT 'åéæè§',
  `diagnosed` varchar(4000) default NULL COMMENT 'åè¯æè§',
  `result` varchar(4000) default NULL COMMENT 'ç»æ',
  `description` varchar(255) default NULL COMMENT 'å¤æ³¨',
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_Result`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ç»æ';

#
# Data for table "result"
#


#
# Structure for table "roles"
#

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `Id_roles` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `description` varchar(255) default NULL COMMENT 'æè¿°',
  `name` varchar(255) default NULL COMMENT 'åç§°',
  `roleType` varchar(255) default NULL COMMENT 'ç±»å',
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`Id_roles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='è§è²';

#
# Data for table "roles"
#


#
# Structure for table "roles_permissions"
#

DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id_roles_permissions` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `id_role` varchar(255) default NULL,
  `permissions_id` varchar(255) default NULL,
  `type_roles` varchar(255) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_roles_permissions`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='è§è²æé';

#
# Data for table "roles_permissions"
#


#
# Structure for table "share"
#

DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `id_share` varchar(50) NOT NULL default '',
  `case_Id` varchar(255) default NULL,
  `DoctorId` varchar(255) default NULL,
  `shareTime` datetime default NULL,
  `hospitalId` varchar(255) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_share`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='åäº«';

#
# Data for table "share"
#


#
# Structure for table "specimen"
#

DROP TABLE IF EXISTS `specimen`;
CREATE TABLE `specimen` (
  `id_specimen` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `id_hospital` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_specimen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='æ æ¬';

#
# Data for table "specimen"
#


#
# Structure for table "status"
#

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `Id_stattus` varchar(50) NOT NULL default '' COMMENT 'ä¸»é®',
  `description` varchar(255) default NULL COMMENT 'æè¿°',
  `name` varchar(255) default NULL COMMENT 'åç§°',
  `type_status` varchar(255) default NULL COMMENT 'ç±»å',
  `typename` varchar(255) default NULL COMMENT 'typename è¯´æ',
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`Id_stattus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ç¶æè¡¨';

#
# Data for table "status"
#


#
# Structure for table "users"
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
  `doctorctfsrc` blob,
  `isdeleted` varchar(10) default NULL,
  `deletor` varchar(32) default NULL,
  `userstatus` varchar(1) default NULL,
  `MEMO` varchar(2000) default NULL,
  `SORT_NO` varchar(32) default NULL,
  `SPELL_NO` varchar(64) default NULL,
  `WUBI_NO` varchar(32) default NULL,
  `UPD_CNT` int(11) default NULL,
  `CRT_TIME` datetime default NULL,
  `CRT_USER_ID` varchar(32) default NULL,
  `CRT_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_TIME` date default NULL,
  `LAST_UPD_DEPT_CD` varchar(32) default NULL,
  `LAST_UPD_USER_ID` varchar(32) default NULL,
  `DEL_F` int(11) default NULL,
  PRIMARY KEY  (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

