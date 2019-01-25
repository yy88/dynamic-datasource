/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.13.157-本地VM-docker
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : 172.16.13.157:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 25/01/2019 14:05:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int(11) NOT NULL,
  `country_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country_code` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'HH',
  `version` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '中国', '10', 1);
INSERT INTO `country` VALUES (2, '美国', '11', 1);
INSERT INTO `country` VALUES (3, '英国', '12', 1);
INSERT INTO `country` VALUES (4, '韩国', '13', 1);
INSERT INTO `country` VALUES (5, '俄国', '14', 1);
INSERT INTO `country` VALUES (6, '德国', '15', 1);
INSERT INTO `country` VALUES (7, '埃及', '16', 1);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '12345678',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` int(11) NULL DEFAULT NULL,
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'test1', '12345678', '1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (2, 'test2', 'aaaa', '2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (3, 'test3', 'bbbb', '1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (4, 'test4', '12345678', '4', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (5, 'test5', '12345678', '5', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (6, 'test6', '12345678', '6', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (7, 'test7', '12345678', '7', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (8, 'test8', '12345678', '8', NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
