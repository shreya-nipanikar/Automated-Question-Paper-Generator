/*
MySQL Data Transfer
Source Host: localhost
Source Database: fuzzyaqpnew
Target Host: localhost
Target Database: fuzzyaqpnew
Date: 4/25/2018 3:46:05 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for counsil_details
-- ----------------------------
DROP TABLE IF EXISTS `counsil_details`;
CREATE TABLE `counsil_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for customizationquestion_table
-- ----------------------------
DROP TABLE IF EXISTS `customizationquestion_table`;
CREATE TABLE `customizationquestion_table` (
  `cust_qid` bigint(50) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(50) DEFAULT NULL,
  `old_qid` bigint(50) DEFAULT NULL,
  `question` varchar(500) DEFAULT NULL,
  `marks` bigint(50) DEFAULT NULL,
  `question_status` varchar(255) DEFAULT NULL,
  `mark_scheme` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `set_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_qid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for marking_table
-- ----------------------------
DROP TABLE IF EXISTS `marking_table`;
CREATE TABLE `marking_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `questionid` bigint(20) DEFAULT NULL,
  `answer_type` varchar(255) DEFAULT NULL,
  `marks` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for marks_scheme_table
-- ----------------------------
DROP TABLE IF EXISTS `marks_scheme_table`;
CREATE TABLE `marks_scheme_table` (
  `scheme_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(50) DEFAULT NULL,
  `scheme_type` varchar(255) DEFAULT NULL,
  `marks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`scheme_id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for paper_set_details
-- ----------------------------
DROP TABLE IF EXISTS `paper_set_details`;
CREATE TABLE `paper_set_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `set_name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for paper_set1
-- ----------------------------
DROP TABLE IF EXISTS `paper_set1`;
CREATE TABLE `paper_set1` (
  `set1_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(50) DEFAULT NULL,
  `teacher_id` bigint(50) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `paper_marks` bigint(50) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `sem` varchar(255) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`set1_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for question_table
-- ----------------------------
DROP TABLE IF EXISTS `question_table`;
CREATE TABLE `question_table` (
  `q_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(50) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `formula_equation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for sub_admin_details
-- ----------------------------
DROP TABLE IF EXISTS `sub_admin_details`;
CREATE TABLE `sub_admin_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roll_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for subject_details
-- ----------------------------
DROP TABLE IF EXISTS `subject_details`;
CREATE TABLE `subject_details` (
  `sub_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `branch` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for teacher_details
-- ----------------------------
DROP TABLE IF EXISTS `teacher_details`;
CREATE TABLE `teacher_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `roll_id` int(50) DEFAULT NULL,
  `add_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for teacher_question
-- ----------------------------
DROP TABLE IF EXISTS `teacher_question`;
CREATE TABLE `teacher_question` (
  `question_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint(50) NOT NULL,
  `branch` varchar(255) NOT NULL,
  `year` varchar(255) DEFAULT NULL,
  `semester` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `no_of_module` int(50) NOT NULL,
  `difficulty_text` varchar(255) DEFAULT NULL,
  `difficulty_level` varchar(255) NOT NULL,
  `marks` double(100,2) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for teacher_subject_details
-- ----------------------------
DROP TABLE IF EXISTS `teacher_subject_details`;
CREATE TABLE `teacher_subject_details` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `branch` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `no_of_module` int(50) DEFAULT NULL,
  `teacher_id` bigint(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `counsil_details` VALUES ('1', 'Pooja', '1223232323', 'rani.marathe9@gmail.com', 'pooja@123');
INSERT INTO `counsil_details` VALUES ('3', 'Damini', '1212121212', 'daminipandita@gmail.com', 'pandita');
INSERT INTO `customizationquestion_table` VALUES ('1', '1', '18', 'Explain Multilevel association rules with suitable examples.', '12', 'not alternative', 'Theory2.00,Diagram2.00', null, 'set1');
INSERT INTO `customizationquestion_table` VALUES ('2', '2', '3', 'Describe the different types of attributes one may come across in a data mining data set with two examples of each type.', '10', 'not alternative', 'Theory3.00', null, 'set1');
INSERT INTO `customizationquestion_table` VALUES ('3', '3', '74', 'Define following terms & differentiate them:\r\nData Mart , Enterprise Warehouse & Virtual\r\nWarehouse.', '5', 'not alternative', 'theory5.00', null, 'set1');
INSERT INTO `customizationquestion_table` VALUES ('4', '4', '34', 'Explain the KDD process in details.', '6', 'not alternative', 'theory6.00', null, 'set1');
INSERT INTO `customizationquestion_table` VALUES ('5', '5', '68', 'What do you mean by data mart? What are the different types of data mart?', '4', 'not alternative', 'theory4.00', null, 'set1');
INSERT INTO `customizationquestion_table` VALUES ('6', '1', '55', 'Explain Market Basket Analysis with it?s use and Association Rules in brief', '12', 'not alternative', 'theory12.00', null, 'set2');
INSERT INTO `customizationquestion_table` VALUES ('7', '2', '109', 'What is Cuboid? Explain any three OLAP Operations on Data Cube with\r\nexample.', '10', 'not alternative', 'theory10.00', null, 'set2');
INSERT INTO `customizationquestion_table` VALUES ('8', '3', '142', 'adddsd', '5', 'not alternative', 'Theory5.0', null, 'set2');
INSERT INTO `customizationquestion_table` VALUES ('9', '4', '114', ' Explain in detail different level of data analysis?', '6', 'not alternative', 'Theory6.0', null, 'set2');
INSERT INTO `customizationquestion_table` VALUES ('10', '5', '73', 'Explain the various methods which evaluate the accuracy of a classifier or a\r\npredictor.\r\n', '4', 'not alternative', 'theory4.00', null, 'set2');
INSERT INTO `customizationquestion_table` VALUES ('11', '1', '20', 'Explain Multidimensional and Multilevel association rules with suitable examples.', '12', 'not alternative', 'Theory2.00,Diagram2.00', null, 'set3');
INSERT INTO `customizationquestion_table` VALUES ('12', '2', '65', 'Explain with an example attribute removal and attribute generalization', '10', 'not alternative', 'theory10.00', null, 'set3');
INSERT INTO `customizationquestion_table` VALUES ('13', '3', '96', 'What is the difference between dependent data warehouse and independent data warehouse?', '5', 'not alternative', 'theory5.00', null, 'set3');
INSERT INTO `customizationquestion_table` VALUES ('14', '4', '118', 'aaaaaaaaaaaa', '6', 'not alternative', 'Theory6.0', 'Tulips.jpg', 'set3');
INSERT INTO `customizationquestion_table` VALUES ('15', '5', '2', 'what is text mining? Explain different approaches to text mining.', '4', 'not alternative', 'Theory2.00,Diagram2.00', null, 'set3');
INSERT INTO `marks_scheme_table` VALUES ('1', '1', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('2', '1', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('3', '2', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('4', '2', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('5', '3', 'Theory', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('6', '4', 'Theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('7', '4', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('8', '5', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('9', '5', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('10', '6', 'Theory', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('11', '7', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('12', '8', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('13', '8', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('14', '9', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('15', '9', 'Diagram', '1.00');
INSERT INTO `marks_scheme_table` VALUES ('16', '10', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('17', '10', 'Diagram', '1.00');
INSERT INTO `marks_scheme_table` VALUES ('18', '11', 'Theory', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('19', '11', 'Diagram', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('20', '12', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('21', '12', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('22', '13', 'Theory', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('23', '13', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('24', '14', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('25', '14', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('26', '15', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('27', '16', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('28', '17', 'Theory', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('29', '18', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('30', '18', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('31', '19', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('32', '20', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('33', '20', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('34', '21', 'Theory', '3.00');
INSERT INTO `marks_scheme_table` VALUES ('35', '22', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('36', '23', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('37', '23', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('38', '24', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('39', '25', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('40', '25', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('41', '26', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('42', '27', 'Theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('43', '27', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('44', '28', 'Theory', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('45', '28', 'Diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('46', '30', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('47', '30', null, '0.00');
INSERT INTO `marks_scheme_table` VALUES ('48', '31', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('49', '32', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('50', '33', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('51', '34', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('52', '35', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('53', '36', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('54', '37', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('55', '38', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('56', '39', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('57', '40', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('58', '41', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('59', '42', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('60', '43', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('61', '44', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('62', '45', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('63', '46', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('64', '47', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('65', '48', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('66', '49', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('67', '49', 'diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('68', '50', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('69', '50', null, '0.00');
INSERT INTO `marks_scheme_table` VALUES ('70', '51', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('71', '52', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('72', '53', 'theory', '8.00');
INSERT INTO `marks_scheme_table` VALUES ('73', '53', 'diagram', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('74', '54', 'theory', '12.00');
INSERT INTO `marks_scheme_table` VALUES ('75', '55', 'theory', '12.00');
INSERT INTO `marks_scheme_table` VALUES ('76', '56', 'theory', '12.00');
INSERT INTO `marks_scheme_table` VALUES ('77', '57', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('78', '57', 'diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('79', '58', 'theory', '8.00');
INSERT INTO `marks_scheme_table` VALUES ('80', '59', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('81', '59', 'diagram', '2.00');
INSERT INTO `marks_scheme_table` VALUES ('82', '60', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('83', '61', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('84', '62', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('85', '63', 'theory', '6.00');
INSERT INTO `marks_scheme_table` VALUES ('86', '63', 'diagram', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('87', '64', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('88', '65', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('89', '66', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('90', '67', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('91', '68', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('92', '69', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('93', '70', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('94', '72', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('95', '72', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('96', '73', 'theory', '4.00');
INSERT INTO `marks_scheme_table` VALUES ('97', '74', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('98', '75', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('99', '76', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('100', '77', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('101', '78', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('102', '79', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('103', '80', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('104', '81', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('105', '82', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('106', '83', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('107', '84', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('108', '85', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('109', '86', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('110', '87', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('111', '88', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('112', '89', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('113', '90', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('114', '91', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('115', '92', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('116', '93', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('117', '94', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('118', '95', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('119', '96', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('120', '97', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('121', '98', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('122', '99', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('123', '100', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('124', '101', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('125', '102', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('126', '103', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('127', '104', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('128', '105', 'theory', '5.00');
INSERT INTO `marks_scheme_table` VALUES ('129', '106', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('130', '107', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('131', '108', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('132', '109', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('133', '110', 'theory', '10.00');
INSERT INTO `marks_scheme_table` VALUES ('134', '111', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('135', '112', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('136', '113', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('137', '114', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('138', '29', 'Theory', '10');
INSERT INTO `marks_scheme_table` VALUES ('142', '118', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('146', '122', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('150', '126', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('157', '133', 'Theory', '6.0');
INSERT INTO `marks_scheme_table` VALUES ('158', '134', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('159', '135', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('160', '136', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('161', '137', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('162', '138', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('163', '139', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('164', '140', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('165', '141', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('166', '142', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('167', '143', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('168', '144', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('169', '145', 'Theory', '5.0');
INSERT INTO `marks_scheme_table` VALUES ('170', '146', 'Theory', '5.0');
INSERT INTO `paper_set_details` VALUES ('1', '1', '13.0', '1523713484201template1for30marksMarkingSchemeDMBISet1.aes', 'DMBI', '2018-04-14');
INSERT INTO `paper_set_details` VALUES ('2', '1', '13.0', '1523713484888template1for30marksDMBISet1.aes', 'DMBI', '2018-04-14');
INSERT INTO `question_table` VALUES ('1', '1', 'Explain data mining as a step in KDD. Give the architecture of typical data mining system.', 'Chrysanthemum.jpg', null);
INSERT INTO `question_table` VALUES ('2', '2', 'what is text mining? Explain different approaches to text mining.', null, null);
INSERT INTO `question_table` VALUES ('3', '3', 'Describe the different types of attributes one may come across in a data mining data set with two examples of each type.', null, null);
INSERT INTO `question_table` VALUES ('4', '4', 'consider the following data points: 13,15,16,16,19,20,20,21,22,22,25,25,25,25,30,33,33,35,35,35,36,40,45,46,52,70.', 'Chrysanthemum.jpg', null);
INSERT INTO `question_table` VALUES ('5', '4', ' (a) what is the mean and median of data? (b) what is mode of data? (c) what is the midrange of the data? ', null, null);
INSERT INTO `question_table` VALUES ('6', '4', '(d)what is the first quartile and third quartile of the data?', null, null);
INSERT INTO `question_table` VALUES ('7', '4', ' (e) show a box plot of the data', null, null);
INSERT INTO `question_table` VALUES ('8', '5', 'Describe the different visualization techniques that can be used in data mining.', null, null);
INSERT INTO `question_table` VALUES ('9', '6', 'What is data preprocessing? Explain the different methods for the data cleansing phase', null, null);
INSERT INTO `question_table` VALUES ('10', '7', 'Partition the given data into 4 bins using Equi-depth binning method and perform smoothing according to mean, median, mode. Data: ', null, null);
INSERT INTO `question_table` VALUES ('11', '8', 'What do you mean by data Integration?', null, null);
INSERT INTO `question_table` VALUES ('12', '9', 'Explain different methods that can be used to evaluate and compare the accuracy of different algorithms.', null, null);
INSERT INTO `question_table` VALUES ('13', '10', 'Explain different methods that can be used to evaluate and compare the accuracy of different classification algorithms.', null, null);
INSERT INTO `question_table` VALUES ('14', '11', 'Define classification, issues of classification and explain ID3 classification with example.', null, null);
INSERT INTO `question_table` VALUES ('15', '12', 'Briefly explain Bagging and Boosting of Classifiers.', null, null);
INSERT INTO `question_table` VALUES ('16', '13', 'Explain the different distance measures that can be used to compute distances between two clusters.', null, null);
INSERT INTO `question_table` VALUES ('17', '14', 'Explain in brief: DBSCAN clustering algorithm with an example.', null, null);
INSERT INTO `question_table` VALUES ('18', '15', 'What is hierarchical clustering? Explain any two techniques for finding distances between the clusters in hierarchical clustering.', null, null);
INSERT INTO `question_table` VALUES ('19', '16', 'What is an outlier? Describe methods that can be used for outlier analysis.', null, null);
INSERT INTO `question_table` VALUES ('20', '17', 'Describe various outlier detection methods.', null, null);
INSERT INTO `question_table` VALUES ('21', '18', 'Explain Multilevel association rules with suitable examples.', null, null);
INSERT INTO `question_table` VALUES ('22', '19', 'Explain sequence mining in transactional databases.', null, null);
INSERT INTO `question_table` VALUES ('23', '20', 'Explain Multidimensional and Multilevel association rules with suitable examples.', null, null);
INSERT INTO `question_table` VALUES ('24', '21', 'Define \"business intelligence\" with examples.', 'Chrysanthemum.jpg', null);
INSERT INTO `question_table` VALUES ('25', '22', 'Explain the various architectures of Business Intelligence.', null, null);
INSERT INTO `question_table` VALUES ('26', '23', 'Explain the roles of mathematical models in Business Intelligence.', null, null);
INSERT INTO `question_table` VALUES ('27', '24', 'Define \"Decision support\" with examples.', null, null);
INSERT INTO `question_table` VALUES ('28', '25', 'Explain the concept of a decision support system with the help of an example application.', null, null);
INSERT INTO `question_table` VALUES ('29', '26', 'Represent and explain the decision making process.', null, null);
INSERT INTO `question_table` VALUES ('30', '27', 'Design a BI system for fraud detection. Describe all the steps from Data collection to Decision making clearly.', null, null);
INSERT INTO `question_table` VALUES ('31', '28', 'Explain Business Intelligence Issues.', null, null);
INSERT INTO `question_table` VALUES ('32', '30', 'List and describe major issues in data mining. ', null, null);
INSERT INTO `question_table` VALUES ('33', '31', 'Explain the methodologies for stream data processing and stream data\r\nSystems. ', null, null);
INSERT INTO `question_table` VALUES ('34', '32', 'Short note: Information gain, Gain ratio, Gini index. ', null, null);
INSERT INTO `question_table` VALUES ('35', '33', 'Write the typical requirements of clustering in data mining. ', null, null);
INSERT INTO `question_table` VALUES ('36', '34', 'Explain the KDD process in details.', null, null);
INSERT INTO `question_table` VALUES ('37', '35', 'Explain meta data repository', null, null);
INSERT INTO `question_table` VALUES ('38', '36', 'Differentiate between OLTP and OLAP systems. ', null, null);
INSERT INTO `question_table` VALUES ('39', '37', 'Explain rule based classification and case based reasoning in details. ', null, null);
INSERT INTO `question_table` VALUES ('40', '38', 'Short Note: Distributive and Holistic measures. ', null, null);
INSERT INTO `question_table` VALUES ('41', '39', 'Explain three-tier data warehouse architecture. ', null, null);
INSERT INTO `question_table` VALUES ('42', '40', 'Explain data transformation in data mining. ', null, null);
INSERT INTO `question_table` VALUES ('43', '41', 'Compare OLTP & OLAP systems. ', null, null);
INSERT INTO `question_table` VALUES ('44', '42', 'Explain the Classification by Decision Tree Induction Algorithm', null, null);
INSERT INTO `question_table` VALUES ('45', '43', 'Explain Rule-based Classification in brief. ', null, null);
INSERT INTO `question_table` VALUES ('46', '44', 'Explain how the accuracy of a classifier can be measured.', null, null);
INSERT INTO `question_table` VALUES ('47', '45', 'Write a short note on hierarchical clustering. ', null, null);
INSERT INTO `question_table` VALUES ('48', '46', 'Explain ?Linear Regression? using suitable example. ', null, null);
INSERT INTO `question_table` VALUES ('49', '47', 'Explain the information retrieval methods used in text mining. ', null, null);
INSERT INTO `question_table` VALUES ('50', '48', 'Explain how the topology of a neural network is designed', null, null);
INSERT INTO `question_table` VALUES ('51', '49', 'Discuss applications of ?Fuzzy Logic?. ', null, null);
INSERT INTO `question_table` VALUES ('52', '50', 'Explain how a search engine automatically identifies authoritative web\r\npages on a user?s search topic. ', null, null);
INSERT INTO `question_table` VALUES ('53', '51', 'Define Data Mining. Explain various application area of Data Mining\r\nTechniques and Knowledge Discovery Process in brief.\r\n', null, null);
INSERT INTO `question_table` VALUES ('54', '52', 'Explain Data Cube with all OLAP Operations in brief. ', null, null);
INSERT INTO `question_table` VALUES ('55', '53', 'Explain Star, Snowflake, Fact Constellation Schema for Multidimensional\r\nDatabase.', null, null);
INSERT INTO `question_table` VALUES ('56', '54', 'Explain Data Discretizaion and Concept Hierarchy Generation in brief', null, null);
INSERT INTO `question_table` VALUES ('57', '55', 'Explain Market Basket Analysis with it?s use and Association Rules in brief', null, null);
INSERT INTO `question_table` VALUES ('58', '56', 'Explain Classification with Decision Tree Induction method', null, null);
INSERT INTO `question_table` VALUES ('59', '57', 'Explain Baye?s Theorm and Naïve Bayesian Classification.', null, null);
INSERT INTO `question_table` VALUES ('60', '58', 'Differentiate Classification and Clustering.', null, null);
INSERT INTO `question_table` VALUES ('61', '59', 'Explain use of Data Mining techniques in Web/Internet Technology.', null, null);
INSERT INTO `question_table` VALUES ('62', '60', 'Explain Linear Regression with example.', null, null);
INSERT INTO `question_table` VALUES ('63', '61', 'Write short note on Spatial, Legacy and Multimedia Database.', null, null);
INSERT INTO `question_table` VALUES ('64', '62', 'List and describe methods for handling missing values in data cleaning', null, null);
INSERT INTO `question_table` VALUES ('65', '63', 'What is Concept Hierarchy? List and explain types of Concept Hierarchy.', null, null);
INSERT INTO `question_table` VALUES ('66', '64', ' List and explain types of Concept Hierarchy.', null, null);
INSERT INTO `question_table` VALUES ('67', '65', 'Explain with an example attribute removal and attribute generalization', null, null);
INSERT INTO `question_table` VALUES ('68', '66', 'Explain different types of web mining with suitable example.', null, null);
INSERT INTO `question_table` VALUES ('69', '67', 'What is web log? Explain web structure mining and web usage mining in detail.', null, null);
INSERT INTO `question_table` VALUES ('70', '68', 'What do you mean by data mart? What are the different types of data mart?', null, null);
INSERT INTO `question_table` VALUES ('71', '69', 'Explain detail about OLAP servers', null, null);
INSERT INTO `question_table` VALUES ('72', '70', 'Describe and explain the different types of clustering methods. ', null, null);
INSERT INTO `question_table` VALUES ('73', '72', 'Describe and explain the different types of clustering methods. ', null, null);
INSERT INTO `question_table` VALUES ('74', '72', 'Describe and explain the different types of clustering methods. ', null, null);
INSERT INTO `question_table` VALUES ('75', '73', 'Explain the various methods which evaluate the accuracy of a classifier or a\r\npredictor.\r\n', null, null);
INSERT INTO `question_table` VALUES ('76', '74', 'Define following terms & differentiate them:\r\nData Mart , Enterprise Warehouse & Virtual\r\nWarehouse.', null, null);
INSERT INTO `question_table` VALUES ('77', '75', 'What do you mean by data mart? What are the\r\ndifferent types of data mart?', null, null);
INSERT INTO `question_table` VALUES ('78', '76', 'Explain why data warehouses are needed for\r\ndeveloping business solutions from today?s\r\nperspective. Discuss the role of data marts.', null, null);
INSERT INTO `question_table` VALUES ('79', '77', 'Differentiate Fact table vs. Dimension table.', null, null);
INSERT INTO `question_table` VALUES ('80', '78', 'What are the major challenges of mining a huge\r\namount of data in comparison with mining a small\r\namount of data?', null, null);
INSERT INTO `question_table` VALUES ('81', '79', 'Define KDD. How data mining techniques applied\r\nover multimedia database, temporal database and\r\nspatial database to extract useful knowledge.', null, null);
INSERT INTO `question_table` VALUES ('82', '80', 'Define sampling. Explain different type of sampling\r\ntechniques with example.', null, null);
INSERT INTO `question_table` VALUES ('83', '81', 'What is noise? Explain the different techniques to\r\nremove the noise from data.', null, null);
INSERT INTO `question_table` VALUES ('84', '82', 'Explain the need for data smoothing during pre-\r\nprocessing and discuss data smoothing by Binning.', null, null);
INSERT INTO `question_table` VALUES ('85', '83', 'List and describe methods ', null, null);
INSERT INTO `question_table` VALUES ('86', '84', 'What is data transformation? Explain the different data\r\ntransformation approaches for transforming data.', null, null);
INSERT INTO `question_table` VALUES ('87', '85', 'What is data transformation? Explain the different data\r\ntransformation approaches for transforming data.', null, null);
INSERT INTO `question_table` VALUES ('88', '86', 'Why strong association rule is not always interesting?\r\nExplain with example.', null, null);
INSERT INTO `question_table` VALUES ('89', '87', 'How multilevel association rules can be mined\r\nefficiently using concept hierarchy?', null, null);
INSERT INTO `question_table` VALUES ('90', '88', 'Discuss basic principle of Attribute Oriented Indication', null, null);
INSERT INTO `question_table` VALUES ('91', '89', 'Write and explain the algorithm for mining frequent\r\nitemsets without candidate itemsets generation with\r\nsuitable example.', null, null);
INSERT INTO `question_table` VALUES ('92', '90', 'What is decision tree induction? Write Basic algorithm\r\nfor inducing a decision tree from training tuples.', null, null);
INSERT INTO `question_table` VALUES ('93', '91', 'Briefly explain Linear and Non-linear regression.', null, null);
INSERT INTO `question_table` VALUES ('94', '92', 'What are measures for assessing quality of text retrieval\r\nmining system?', null, null);
INSERT INTO `question_table` VALUES ('95', '93', 'What are measures for assessing quality of text retrieval\r\nmining system?', null, null);
INSERT INTO `question_table` VALUES ('96', '94', 'Discuss the main features of Hadoop Distributed File\r\nSystem.', null, null);
INSERT INTO `question_table` VALUES ('97', '95', 'Briefly state different between data ware house & data mart?', null, null);
INSERT INTO `question_table` VALUES ('98', '96', 'What is the difference between dependent data warehouse and independent data warehouse?', null, null);
INSERT INTO `question_table` VALUES ('99', '97', 'What is MODEL in Data mining world?', null, null);
INSERT INTO `question_table` VALUES ('100', '98', 'Explain how to use DMX-the data mining query language.', null, null);
INSERT INTO `question_table` VALUES ('101', '99', 'Explain clustering algorithm.', null, null);
INSERT INTO `question_table` VALUES ('102', '100', 'Explain Association algorithm in Data mining?', null, null);
INSERT INTO `question_table` VALUES ('103', '101', 'Explain virtual data warehouse.', null, null);
INSERT INTO `question_table` VALUES ('104', '102', 'What are the causes of model over fitting?', null, null);
INSERT INTO `question_table` VALUES ('105', '103', 'What are frequent patterns?', null, null);
INSERT INTO `question_table` VALUES ('106', '104', 'What can business analysts gain from having a data warehouse?', null, null);
INSERT INTO `question_table` VALUES ('107', '105', 'What is Data purging?', null, null);
INSERT INTO `question_table` VALUES ('108', '106', 'Explain Prepruning and Postpruning with an example.', null, null);
INSERT INTO `question_table` VALUES ('109', '107', 'Explain Hadoop storage ? HDFS', null, null);
INSERT INTO `question_table` VALUES ('110', '108', 'Explain sampling methods for data reduction. ', null, null);
INSERT INTO `question_table` VALUES ('111', '109', 'What is Cuboid? Explain any three OLAP Operations on Data Cube with\r\nexample.', null, null);
INSERT INTO `question_table` VALUES ('112', '110', 'Explain role of Business intelligence in any one of following domain:\r\nFraud Detection,Market Segmentation,retail industry, telecommunications\r\nindustry. Explain how data mininig can be helpful in any of these cases.', null, null);
INSERT INTO `question_table` VALUES ('113', '111', 'Name some terminologies of data mining?', null, null);
INSERT INTO `question_table` VALUES ('114', '112', ' Explain applications of data mining?', null, null);
INSERT INTO `question_table` VALUES ('115', '113', 'What are pros of data mining?', null, null);
INSERT INTO `question_table` VALUES ('116', '114', ' Explain in detail different level of data analysis?', null, null);
INSERT INTO `question_table` VALUES ('117', '29', 'What is mining??', null, null);
INSERT INTO `question_table` VALUES ('121', '118', 'aaaaaaaaaaaa', 'Tulips.jpg', null);
INSERT INTO `question_table` VALUES ('125', '122', 'ddddd', 'Hydrangeas.jpg', null);
INSERT INTO `question_table` VALUES ('129', '126', 'wqeqweeqw', 'Desert.jpg', null);
INSERT INTO `question_table` VALUES ('136', '133', 'bdhs', null, null);
INSERT INTO `question_table` VALUES ('137', '134', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('138', '135', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('139', '136', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('140', '137', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('141', '138', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('142', '139', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('143', '140', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('144', '141', 'which algoritham used for data mining?', null, null);
INSERT INTO `question_table` VALUES ('145', '142', 'adddsd', null, null);
INSERT INTO `question_table` VALUES ('146', '143', 'shgvhshssgdh', null, null);
INSERT INTO `question_table` VALUES ('147', '144', 'What Are The Different Problems That \"data Mining\" Can Solve?', null, null);
INSERT INTO `question_table` VALUES ('148', '145', 'What Are Different Stages Of \"data Mining\"?', null, null);
INSERT INTO `question_table` VALUES ('149', '146', ' Explain Clustering Algorithm?', null, null);
INSERT INTO `sub_admin_details` VALUES ('1', 'meeraaa', '1234567890', 'meera@gmail.com', 'meera', '0');
INSERT INTO `sub_admin_details` VALUES ('2', 'Priya Marathe', '1212121212', 'priya@gmail.com', 'priya', '0');
INSERT INTO `sub_admin_details` VALUES ('5', 'Pooja Ayare', '9561576797', 'poojaayare29@gmail.com', 'pooja', '0');
INSERT INTO `sub_admin_details` VALUES ('9', 'damini', '8851798118', 'daminipandita@gmail.com', 'damini', '0');
INSERT INTO `subject_details` VALUES ('1', 'Computer', 'First Year', 'I sem', 'English');
INSERT INTO `subject_details` VALUES ('2', 'Computer', 'First Year', 'I sem', 'Physics');
INSERT INTO `subject_details` VALUES ('3', 'Computer', 'First Year', 'II sem', 'OOP');
INSERT INTO `subject_details` VALUES ('4', 'Computer', 'First Year', 'II sem', 'Electronics');
INSERT INTO `subject_details` VALUES ('5', 'Computer', 'Second Year', 'III sem', 'Data Structures');
INSERT INTO `subject_details` VALUES ('6', 'Computer', 'Second Year', 'III sem', 'Applied Mathematics III');
INSERT INTO `subject_details` VALUES ('7', 'Computer', 'Second Year', 'IV sem', 'Computer Graphics');
INSERT INTO `subject_details` VALUES ('8', 'Computer', 'Second Year', 'IV sem', 'Database Management System');
INSERT INTO `subject_details` VALUES ('9', 'Computer', 'Third Year', 'V sem', 'Computer Network');
INSERT INTO `subject_details` VALUES ('10', 'Computer', 'Third Year', 'V sem', 'Microprocessor');
INSERT INTO `subject_details` VALUES ('11', 'Computer', 'Third Year', 'VI sem', ' Data warehousing and Mining');
INSERT INTO `subject_details` VALUES ('12', 'Computer', 'Third Year', 'VI sem', 'Object Oriented software Engineering');
INSERT INTO `subject_details` VALUES ('13', 'Computer', 'Fourth Year', 'VII sem', 'Digital Signal & Image Processing');
INSERT INTO `subject_details` VALUES ('14', 'Computer', 'Fourth Year', 'VII sem', 'Mobile Computing');
INSERT INTO `subject_details` VALUES ('15', 'Computer', 'Fourth Year', 'VIII sem', 'Parallel and distributed Systems');
INSERT INTO `subject_details` VALUES ('16', 'Computer', 'Fourth Year', 'VIII sem', '-Machine Learning');
INSERT INTO `subject_details` VALUES ('17', 'IT', 'First Year', 'I sem', 'Physics');
INSERT INTO `subject_details` VALUES ('18', 'IT', 'First Year', 'I sem', 'Mechanics of Solids');
INSERT INTO `subject_details` VALUES ('19', 'IT', 'First Year', 'II sem', 'Chemistry');
INSERT INTO `subject_details` VALUES ('20', 'IT', 'First Year', 'II sem', 'Linear Algebra');
INSERT INTO `subject_details` VALUES ('21', 'IT', 'Second Year', 'III sem', 'Basic Electronics');
INSERT INTO `subject_details` VALUES ('22', 'IT', 'Second Year', 'III sem', 'Digital Systems');
INSERT INTO `subject_details` VALUES ('23', 'IT', 'Second Year', 'IV sem', 'Communication Engineering');
INSERT INTO `subject_details` VALUES ('24', 'IT', 'Second Year', 'IV sem', 'Probability Statistics and Numerical Analysis');
INSERT INTO `subject_details` VALUES ('25', 'IT', 'Third Year', 'V sem', 'Theory of Computation');
INSERT INTO `subject_details` VALUES ('26', 'IT', 'Third Year', 'V sem', 'Data Communication Networks');
INSERT INTO `subject_details` VALUES ('27', 'IT', 'Third Year', 'VI sem', 'Design and Analysis of Algorithms');
INSERT INTO `subject_details` VALUES ('28', 'IT', 'Third Year', 'VI sem', 'Java Technologies (Elective I)');
INSERT INTO `subject_details` VALUES ('29', 'IT', 'Fourth Year', 'VII sem', 'Network Protocol');
INSERT INTO `subject_details` VALUES ('30', 'IT', 'Fourth Year', 'VII sem', 'Network Programming');
INSERT INTO `subject_details` VALUES ('31', 'IT', 'Fourth Year', 'VIII sem', 'Major Project');
INSERT INTO `subject_details` VALUES ('32', 'IT', 'Fourth Year', 'VIII sem', 'Major Project');
INSERT INTO `subject_details` VALUES ('33', 'EXTC', 'First Year', 'I sem', 'Engineering Graphics');
INSERT INTO `subject_details` VALUES ('34', 'EXTC', 'First Year', 'I sem', 'Mechanical Workshop Practices');
INSERT INTO `subject_details` VALUES ('35', 'EXTC', 'First Year', 'II sem', 'Environment and Energy Studies');
INSERT INTO `subject_details` VALUES ('36', 'EXTC', 'First Year', 'II sem', 'Communication Skills');
INSERT INTO `subject_details` VALUES ('37', 'EXTC', 'Second Year', 'III sem', 'Digital Circuits');
INSERT INTO `subject_details` VALUES ('38', 'EXTC', 'Second Year', 'III sem', 'Linear Control System');
INSERT INTO `subject_details` VALUES ('39', 'EXTC', 'Second Year', 'IV sem', 'Electronics Design, Tools and Packages');
INSERT INTO `subject_details` VALUES ('40', 'EXTC', 'Second Year', 'IV sem', 'Signals and Systems');
INSERT INTO `subject_details` VALUES ('41', 'EXTC', 'Third Year', 'V sem', 'Electromagnetics Engineering');
INSERT INTO `subject_details` VALUES ('42', 'EXTC', 'Third Year', 'V sem', 'Microprocessor and Computer Architecture');
INSERT INTO `subject_details` VALUES ('43', 'EXTC', 'Third Year', 'VI sem', 'Antenna and Wave Propagation');
INSERT INTO `subject_details` VALUES ('44', 'EXTC', 'Third Year', 'VI sem', 'Analog Integrated Circuit Design');
INSERT INTO `subject_details` VALUES ('45', 'EXTC', 'Fourth Year', 'VII sem', 'Wireless Communications');
INSERT INTO `subject_details` VALUES ('46', 'EXTC', 'Fourth Year', 'VII sem', 'Image Processing');
INSERT INTO `subject_details` VALUES ('47', 'EXTC', 'Fourth Year', 'VIII sem', 'Major Project');
INSERT INTO `subject_details` VALUES ('48', 'EXTC', 'Fourth Year', 'VIII sem', 'Comprehensive Viva/Voce');
INSERT INTO `subject_details` VALUES ('49', 'MECHANICAL', 'First Year', 'I sem', 'Elements of Electrical Engineering');
INSERT INTO `subject_details` VALUES ('50', 'MECHANICAL', 'First Year', 'I sem', 'Art of Programming');
INSERT INTO `subject_details` VALUES ('51', 'MECHANICAL', 'First Year', 'II sem', 'Physics');
INSERT INTO `subject_details` VALUES ('52', 'MECHANICAL', 'First Year', 'II sem', 'Linear Algebra');
INSERT INTO `subject_details` VALUES ('53', 'MECHANICAL', 'Second Year', 'III sem', 'Kinematics');
INSERT INTO `subject_details` VALUES ('54', 'MECHANICAL', 'Second Year', 'III sem', 'Thermodynamics');
INSERT INTO `subject_details` VALUES ('55', 'MECHANICAL', 'Second Year', 'IV sem', 'Fluid Mechanics');
INSERT INTO `subject_details` VALUES ('56', 'MECHANICAL', 'Second Year', 'IV sem', 'ICT Tools and Security');
INSERT INTO `subject_details` VALUES ('57', 'MECHANICAL', 'Third Year', 'V sem', 'Control Engineering');
INSERT INTO `subject_details` VALUES ('58', 'MECHANICAL', 'Third Year', 'V sem', 'Heat and Mass Transfer');
INSERT INTO `subject_details` VALUES ('59', 'MECHANICAL', 'Third Year', 'VI sem', 'Production Technology');
INSERT INTO `subject_details` VALUES ('60', 'MECHANICAL', 'Third Year', 'VI sem', 'Thermal Engineering');
INSERT INTO `subject_details` VALUES ('61', 'MECHANICAL', 'Fourth Year', 'VII sem', 'Computer Aided Design');
INSERT INTO `subject_details` VALUES ('62', 'MECHANICAL', 'Fourth Year', 'VII sem', 'Production and Industrial Management');
INSERT INTO `subject_details` VALUES ('63', 'MECHANICAL', 'Fourth Year', 'VIII sem', 'Major Project');
INSERT INTO `subject_details` VALUES ('64', 'MECHANICAL', 'Fourth Year', 'VIII sem', 'Major Project');
INSERT INTO `subject_details` VALUES ('65', null, null, null, null);
INSERT INTO `teacher_details` VALUES ('1', 'Supriya', '1223232323', 'rani.marathe9@gmail.com', 'supriya@123', 'IT', '1', 'meera@gmail.com');
INSERT INTO `teacher_details` VALUES ('3', 'Siddhi', '1223232323', 'siddhi@gmail.com', 'siddhi', 'Mechanical', '1', null);
INSERT INTO `teacher_details` VALUES ('5', 'Shital', '1223232323', 'shital@gmail.com', 'shital', 'IT', '0', null);
INSERT INTO `teacher_details` VALUES ('7', 'sidhhi', '1234567890', 'shirgaonkarsiddhi@gmail.com', 'siddhi', 'civil', '0', null);
INSERT INTO `teacher_details` VALUES ('8', 'anil', '1234567890', 'anil@gmail.com', 'kirti', 'Computer', '1', null);
INSERT INTO `teacher_details` VALUES ('9', 'ashok', '1234567890', 'mitali@gmail.com', 'kirti', 'mitali', '1', 'meera@gmail.com');
INSERT INTO `teacher_question` VALUES ('1', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('2', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '4.00');
INSERT INTO `teacher_question` VALUES ('3', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Medium', '3', '10.00');
INSERT INTO `teacher_question` VALUES ('4', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Difficult', '5', '6.00');
INSERT INTO `teacher_question` VALUES ('5', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('6', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '3', '4.00');
INSERT INTO `teacher_question` VALUES ('7', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('8', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('9', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '10.00');
INSERT INTO `teacher_question` VALUES ('10', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('11', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Difficult', '6', '10.00');
INSERT INTO `teacher_question` VALUES ('12', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('13', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('14', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Medium', '4', '12.00');
INSERT INTO `teacher_question` VALUES ('15', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('16', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('17', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Medium', '3', '10.00');
INSERT INTO `teacher_question` VALUES ('18', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '4', '12.00');
INSERT INTO `teacher_question` VALUES ('19', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('20', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '4', '12.00');
INSERT INTO `teacher_question` VALUES ('21', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('22', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Easy', '2', '8.00');
INSERT INTO `teacher_question` VALUES ('23', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('24', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Easy', '2', '8.00');
INSERT INTO `teacher_question` VALUES ('25', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('26', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Easy', '2', '8.00');
INSERT INTO `teacher_question` VALUES ('27', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '10', 'Difficult', '6', '10.00');
INSERT INTO `teacher_question` VALUES ('28', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '10', 'Medium', '4', '8.00');
INSERT INTO `teacher_question` VALUES ('29', '5', 'IT', 'Third Year', 'VI sem', 'DMBI', '10', 'Difficult', '6', '10.00');
INSERT INTO `teacher_question` VALUES ('30', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('31', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('32', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('33', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Difficult', '5', '6.00');
INSERT INTO `teacher_question` VALUES ('34', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Difficult', '5', '6.00');
INSERT INTO `teacher_question` VALUES ('35', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('36', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('37', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('38', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('39', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('40', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('41', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('42', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Difficult', '5', '6.00');
INSERT INTO `teacher_question` VALUES ('43', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('44', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('45', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('46', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('47', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('48', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('49', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('50', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('51', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('52', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Difficult', '6', '6.00');
INSERT INTO `teacher_question` VALUES ('53', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '12.00');
INSERT INTO `teacher_question` VALUES ('54', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '2', '12.00');
INSERT INTO `teacher_question` VALUES ('55', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '1', '12.00');
INSERT INTO `teacher_question` VALUES ('56', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '1', '12.00');
INSERT INTO `teacher_question` VALUES ('57', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '8.00');
INSERT INTO `teacher_question` VALUES ('58', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '2', '8.00');
INSERT INTO `teacher_question` VALUES ('59', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '8.00');
INSERT INTO `teacher_question` VALUES ('60', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('61', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('62', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('63', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('64', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '10.00');
INSERT INTO `teacher_question` VALUES ('65', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '3', '10.00');
INSERT INTO `teacher_question` VALUES ('66', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '1', '4.00');
INSERT INTO `teacher_question` VALUES ('67', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '4.00');
INSERT INTO `teacher_question` VALUES ('68', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '4.00');
INSERT INTO `teacher_question` VALUES ('69', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Medium', '4', '4.00');
INSERT INTO `teacher_question` VALUES ('70', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '4.00');
INSERT INTO `teacher_question` VALUES ('71', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '4.00');
INSERT INTO `teacher_question` VALUES ('72', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '4.00');
INSERT INTO `teacher_question` VALUES ('73', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '3', '4.00');
INSERT INTO `teacher_question` VALUES ('74', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('75', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('76', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('77', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('78', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('79', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('80', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('81', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('82', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('83', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('84', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('85', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('86', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('87', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('88', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('89', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('90', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('91', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('92', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('93', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('94', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('95', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('96', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('97', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('98', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('99', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('100', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('101', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('102', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('103', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('104', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('105', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '9', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('106', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '5', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('107', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('108', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('109', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Easy', '2', '10.00');
INSERT INTO `teacher_question` VALUES ('110', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '8', 'Medium', '4', '10.00');
INSERT INTO `teacher_question` VALUES ('111', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('112', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '6', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('113', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '7', 'Medium', '3', '6.00');
INSERT INTO `teacher_question` VALUES ('114', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('118', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '1', '6.00');
INSERT INTO `teacher_question` VALUES ('122', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('126', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '1', 'Easy', '2', '6.00');
INSERT INTO `teacher_question` VALUES ('133', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '6.00');
INSERT INTO `teacher_question` VALUES ('134', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('135', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('136', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '2', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('137', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('138', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('139', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '3', '5.00');
INSERT INTO `teacher_question` VALUES ('140', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Difficult', '5', '5.00');
INSERT INTO `teacher_question` VALUES ('141', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Easy', '1', '5.00');
INSERT INTO `teacher_question` VALUES ('142', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('143', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('144', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Easy', '2', '5.00');
INSERT INTO `teacher_question` VALUES ('145', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '4', 'Medium', '4', '5.00');
INSERT INTO `teacher_question` VALUES ('146', '1', 'IT', 'Third Year', 'VI sem', 'DMBI', '3', 'Medium', '4', '5.00');
INSERT INTO `teacher_subject_details` VALUES ('7', 'IT', 'Third Year', 'VI sem', 'DMBI', '10', '1');
INSERT INTO `teacher_subject_details` VALUES ('8', 'IT', 'Third Year', 'VI sem', 'SWS', '7', '5');
INSERT INTO `teacher_subject_details` VALUES ('9', 'IT', 'Fourth Year', 'VII sem', 'SPM', '10', '6');
