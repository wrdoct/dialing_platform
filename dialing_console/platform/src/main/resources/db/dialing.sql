/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.222.253_30036_vm
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : 192.168.222.253:30036
 Source Schema         : dialing

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 18/04/2024 14:54:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '提示信息',
  `access_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '系统用户登录记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '所属上级',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜单标题',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件名称',
  `sort_value` int NOT NULL DEFAULT 1 COMMENT '排序',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态(0:禁止,1:正常)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', 'system', 1, 1, '2023-05-04 10:46:47', '2023-05-06 17:33:53', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'sysUser', 1, 1, '2023-05-04 10:47:13', '2023-05-06 17:33:57', 0);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sysRole', 2, 1, '2023-05-04 10:47:19', '2023-05-06 17:33:58', 0);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sysMenu', 3, 1, '2023-05-04 10:47:26', '2023-05-06 17:33:58', 0);
INSERT INTO `sys_menu` VALUES (5, 0, '基础数据管理', 'base', 2, 1, '2023-05-05 12:25:07', '2023-05-15 15:37:36', 0);
INSERT INTO `sys_menu` VALUES (21, 1, '操作日志', 'sysOperLog', 4, 1, '2023-06-02 09:04:13', '2023-06-02 09:04:21', 0);

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `method` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `business_type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '0' COMMENT '业务类型 (0默认，1新增，2删除，3修改，4查询)',
  `operator_type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '0' COMMENT '操作类别（0其它 1后台用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `oper_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_param` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (166, '分页用户列表', 'com.boca.iot.platform.controller.SysUserController', 'GET', 'FIND', 'MANAGE', 'admin', '/admin/system/sysUser/findByPage', '0:0:0:0:0:0:0:1', NULL, '{\"code\":200,\"data\":{\"endRow\":3,\"hasNextPage\":false,\"hasPreviousPage\":false,\"isFirstPage\":true,\"isLastPage\":true,\"list\":[{\"createTime\":\"2024-04-18 10:40:50\",\"description\":\"1\",\"id\":14,\"isDeleted\":0,\"name\":\"1\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"phone\":\"1\",\"status\":1,\"updateTime\":\"2024-04-18 10:40:50\",\"userName\":\"1\"},{\"avatar\":\"http://192.168.222.253:9001/dialing-bucket/20240418/d0182d2778184b9ba9046373c1374ebetest.png\",\"createTime\":\"2024-04-18 09:58:25\",\"description\":\"用户\",\"id\":13,\"isDeleted\":0,\"name\":\"user\",\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"13498765432\",\"status\":1,\"updateTime\":\"2024-04-18 10:39:08\",\"userName\":\"user\"},{\"avatar\":\"https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg\",\"createTime\":\"2024-04-17 10:17:18\",\"description\":\"管理员\",\"id\":1,\"isDeleted\":0,\"name\":\"admin\",\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"18729357726\",\"status\":1,\"updateTime\":\"2024-04-18 09:08:57\",\"userName\":\"admin\"}],\"navigateFirstPage\":1,\"navigateLastPage\":1,\"navigatePages\":8,\"navigatepageNums\":[1],\"nextPage\":0,\"pageNum\":1,\"pageSize\":10,\"pages\":1,\"prePage\":0,\"size\":3,\"startRow\":1,\"total\":3},\"message\":\"操作成功\"}', 0, NULL, '2024-04-18 10:40:50', NULL, 0);
INSERT INTO `sys_oper_log` VALUES (167, '修改用户', 'com.boca.iot.platform.controller.SysUserController', 'PUT', 'EDIT', 'MANAGE', 'admin', '/admin/system/sysUser/updateSysUser', '0:0:0:0:0:0:0:1', '[SysUser(userName=1, password=c4ca4238a0b923820dcc509a6f75849b, name=1, phone=1, avatar=null, description=1, status=0)]', '{\"code\":200,\"message\":\"操作成功\"}', 0, NULL, '2024-04-18 10:40:55', NULL, 0);
INSERT INTO `sys_oper_log` VALUES (168, '分页用户列表', 'com.boca.iot.platform.controller.SysUserController', 'GET', 'FIND', 'MANAGE', 'admin', '/admin/system/sysUser/findByPage', '0:0:0:0:0:0:0:1', NULL, '{\"code\":200,\"data\":{\"endRow\":3,\"hasNextPage\":false,\"hasPreviousPage\":false,\"isFirstPage\":true,\"isLastPage\":true,\"list\":[{\"createTime\":\"2024-04-18 10:40:50\",\"description\":\"1\",\"id\":14,\"isDeleted\":0,\"name\":\"1\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"phone\":\"1\",\"status\":1,\"updateTime\":\"2024-04-18 10:40:55\",\"userName\":\"1\"},{\"avatar\":\"http://192.168.222.253:9001/dialing-bucket/20240418/d0182d2778184b9ba9046373c1374ebetest.png\",\"createTime\":\"2024-04-18 09:58:25\",\"description\":\"用户\",\"id\":13,\"isDeleted\":0,\"name\":\"user\",\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"13498765432\",\"status\":1,\"updateTime\":\"2024-04-18 10:39:08\",\"userName\":\"user\"},{\"avatar\":\"https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg\",\"createTime\":\"2024-04-17 10:17:18\",\"description\":\"管理员\",\"id\":1,\"isDeleted\":0,\"name\":\"admin\",\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"18729357726\",\"status\":1,\"updateTime\":\"2024-04-18 09:08:57\",\"userName\":\"admin\"}],\"navigateFirstPage\":1,\"navigateLastPage\":1,\"navigatePages\":8,\"navigatepageNums\":[1],\"nextPage\":0,\"pageNum\":1,\"pageSize\":10,\"pages\":1,\"prePage\":0,\"size\":3,\"startRow\":1,\"total\":3},\"message\":\"操作成功\"}', 0, NULL, '2024-04-18 10:40:55', NULL, 0);
INSERT INTO `sys_oper_log` VALUES (169, '删除用户', 'com.boca.iot.platform.controller.SysUserController', 'DELETE', 'DELETE', 'MANAGE', 'admin', '/admin/system/sysUser/deleteById/14', '0:0:0:0:0:0:0:1', NULL, '{\"code\":200,\"message\":\"操作成功\"}', 0, NULL, '2024-04-18 10:40:59', NULL, 0);
INSERT INTO `sys_oper_log` VALUES (170, '分页用户列表', 'com.boca.iot.platform.controller.SysUserController', 'GET', 'FIND', 'MANAGE', 'admin', '/admin/system/sysUser/findByPage', '0:0:0:0:0:0:0:1', NULL, '{\"code\":200,\"data\":{\"endRow\":2,\"hasNextPage\":false,\"hasPreviousPage\":false,\"isFirstPage\":true,\"isLastPage\":true,\"list\":[{\"avatar\":\"http://192.168.222.253:9001/dialing-bucket/20240418/d0182d2778184b9ba9046373c1374ebetest.png\",\"createTime\":\"2024-04-18 09:58:25\",\"description\":\"用户\",\"id\":13,\"isDeleted\":0,\"name\":\"user\",\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"13498765432\",\"status\":1,\"updateTime\":\"2024-04-18 10:39:08\",\"userName\":\"user\"},{\"avatar\":\"https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg\",\"createTime\":\"2024-04-17 10:17:18\",\"description\":\"管理员\",\"id\":1,\"isDeleted\":0,\"name\":\"admin\",\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"18729357726\",\"status\":1,\"updateTime\":\"2024-04-18 09:08:57\",\"userName\":\"admin\"}],\"navigateFirstPage\":1,\"navigateLastPage\":1,\"navigatePages\":8,\"navigatepageNums\":[1],\"nextPage\":0,\"pageNum\":1,\"pageSize\":10,\"pages\":1,\"prePage\":0,\"size\":2,\"startRow\":1,\"total\":2},\"message\":\"操作成功\"}', 0, NULL, '2024-04-18 10:40:59', NULL, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (9, '管理员', 'wrdoct', '管理员', '2024-04-18 10:36:06', '2024-04-18 09:07:25', 0);
INSERT INTO `sys_role` VALUES (10, '用户', 'user', '用户', '2024-04-18 10:36:22', '2024-04-18 11:06:48', 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL DEFAULT 0,
  `menu_id` bigint NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  `is_half` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id` ASC) USING BTREE,
  INDEX `idx_menu_id`(`menu_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (38, 9, 1, '2023-06-29 11:52:31', '2023-06-29 11:52:31', 0, 0);
INSERT INTO `sys_role_menu` VALUES (39, 9, 2, '2023-06-29 11:52:31', '2023-06-29 11:52:31', 0, 0);
INSERT INTO `sys_role_menu` VALUES (40, 9, 3, '2023-06-29 11:52:31', '2023-06-29 11:52:31', 0, 0);
INSERT INTO `sys_role_menu` VALUES (41, 9, 4, '2023-06-29 11:52:31', '2023-06-29 11:52:31', 0, 0);
INSERT INTO `sys_role_menu` VALUES (42, 9, 21, '2023-06-29 11:52:31', '2023-06-29 11:52:31', 0, 0);
INSERT INTO `sys_role_menu` VALUES (43, 9, 5, '2023-06-29 11:52:31', '2023-06-29 11:52:31', 0, 0);
INSERT INTO `sys_role_menu` VALUES (112, 10, 5, '2024-04-18 09:59:00', '2024-04-18 09:59:00', 0, 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态（1：正常 0：停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '96e79218965eb72c92a549dd5a330112', 'admin', '18729357726', 'https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg', '管理员', 1, '2024-04-17 10:17:18', '2024-04-18 09:08:57', 0);
INSERT INTO `sys_user` VALUES (13, 'user', '96e79218965eb72c92a549dd5a330112', 'user', '13498765432', 'http://192.168.222.253:9001/dialing-bucket/20240418/d0182d2778184b9ba9046373c1374ebetest.png', '用户', 1, '2024-04-18 09:58:25', '2024-04-18 10:39:08', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint NOT NULL DEFAULT 0 COMMENT '角色id',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id` ASC) USING BTREE,
  INDEX `idx_admin_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (7, 9, 1, '2023-07-18 10:59:09', '2024-04-11 11:17:37', 0);
INSERT INTO `sys_user_role` VALUES (10, 10, 1, '2023-07-18 11:09:35', '2024-04-11 11:17:39', 0);
INSERT INTO `sys_user_role` VALUES (14, 10, 13, '2024-04-18 09:58:32', '2024-04-18 09:58:32', 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(17) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `open_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信open id',
  `union_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信开放平台unionID',
  `last_login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后一次登录ip',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态：1为正常，0为禁止',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
