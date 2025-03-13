/*
 Navicat Premium Dump SQL

 Source Server         : mysql-localhost
 Source Server Type    : MySQL
 Source Server Version : 50728 (5.7.28-log)
 Source Host           : localhost:3306
 Source Schema         : farm-management-system

 Target Server Type    : MySQL
 Target Server Version : 50728 (5.7.28-log)
 File Encoding         : 65001

 Date: 13/03/2025 11:23:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nb_user
-- ----------------------------
DROP TABLE IF EXISTS `nb_user`;
CREATE TABLE `nb_user`  (
  `user_id` bigint(20) NOT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nb_user
-- ----------------------------
INSERT INTO `nb_user` VALUES (12345678912345678, 'rob', '114514', '123456', '130111111111111');
INSERT INTO `nb_user` VALUES (50313111438618001, '132', '123123', '123456', '1111111');
INSERT INTO `nb_user` VALUES (50313112258458002, '张三', 'zhangsan', '123456', '1111111');

SET FOREIGN_KEY_CHECKS = 1;
