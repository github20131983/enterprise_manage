/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_affairmanage

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-01-18 16:45:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_criticism
-- ----------------------------
DROP TABLE IF EXISTS `tb_criticism`;
CREATE TABLE `tb_criticism` (
  `criticismID` int(11) NOT NULL AUTO_INCREMENT,
  `criticismContent` text,
  `employeeID` int(11) DEFAULT NULL,
  `criticismTime` datetime DEFAULT NULL,
  `messageID` int(11) DEFAULT NULL,
  PRIMARY KEY (`criticismID`),
  KEY `employeeID` (`employeeID`),
  KEY `messageID` (`messageID`),
  CONSTRAINT `tb_criticism_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`),
  CONSTRAINT `tb_criticism_ibfk_2` FOREIGN KEY (`messageID`) REFERENCES `tb_message` (`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `employeeID` int(11) NOT NULL DEFAULT '0',
  `employeeName` varchar(20) DEFAULT NULL,
  `employeeSex` bit(1) DEFAULT NULL,
  `employeeBirth` date DEFAULT NULL,
  `employeePhone` varchar(20) DEFAULT NULL,
  `employeePlace` varchar(50) DEFAULT NULL,
  `joinTime` date DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `isLead` bit(1) DEFAULT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `messageID` int(11) NOT NULL AUTO_INCREMENT,
  `messageTitle` varchar(50) DEFAULT NULL,
  `messageContent` text,
  `employeeID` int(11) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  PRIMARY KEY (`messageID`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `tb_message_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply` (
  `replyID` int(11) NOT NULL AUTO_INCREMENT,
  `replyContent` text,
  `employeeID` int(11) DEFAULT NULL,
  `replyTime` datetime DEFAULT NULL,
  `messageID` int(11) DEFAULT NULL,
  PRIMARY KEY (`replyID`),
  KEY `employeeID` (`employeeID`),
  KEY `messageID` (`messageID`),
  CONSTRAINT `tb_reply_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`),
  CONSTRAINT `tb_reply_ibfk_2` FOREIGN KEY (`messageID`) REFERENCES `tb_message` (`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

