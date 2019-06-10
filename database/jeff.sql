/*
 Navicat Premium Data Transfer

 Source Server         : 100
 Source Server Type    : MySQL
 Source Server Version : 50631
 Source Host           : 192.168.0.100:3306
 Source Schema         : jeff

 Target Server Type    : MySQL
 Target Server Version : 50631
 File Encoding         : 65001

 Date: 11/06/2019 00:53:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单类别',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态',
  `parent_id` bigint(19) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `opened` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否展开',
  `seq` tinyint(2) NULL DEFAULT 0 COMMENT '排序',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权标识，多个用逗号分隔, 如: user:list,user:create',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modify_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 227 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理', 'MENU', 'ENABLE', NULL, 'UNFOLD', 0, 'glyphicon-folder-open ', '', NULL, '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (11, '菜单管理', 'MENU', 'ENABLE', 1, 'UNFOLD', 1, 'glyphicon-th ', '/menu/manager', NULL, '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (12, '角色管理', 'MENU', 'ENABLE', 1, 'UNFOLD', 2, 'glyphicon-eye-open ', '/role/manager', NULL, '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (13, '用户管理', 'MENU', 'ENABLE', 1, 'UNFOLD', 4, 'glyphicon-user ', '/user/manager', NULL, '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (111, '列表', 'BUTTON', 'ENABLE', 11, 'UNFOLD', 1, 'glyphicon-list ', '/menu/treeGrid', 'menu:list', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:19:54', 'admin');
INSERT INTO `menu` VALUES (112, '添加', 'BUTTON', 'ENABLE', 11, 'UNFOLD', 2, 'glyphicon-plus icon-green', '/menu/add', 'menu:create', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:20:11', 'admin');
INSERT INTO `menu` VALUES (113, '编辑', 'BUTTON', 'ENABLE', 11, 'UNFOLD', 3, 'glyphicon-pencil icon-blue', '/menu/edit', 'menu:update', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:20:23', 'admin');
INSERT INTO `menu` VALUES (114, '删除', 'BUTTON', 'ENABLE', 11, 'UNFOLD', 4, 'glyphicon-trash icon-red', '/menu/delete', 'menu:delete', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:20:35', 'admin');
INSERT INTO `menu` VALUES (121, '列表', 'BUTTON', 'ENABLE', 12, 'UNFOLD', 1, 'glyphicon-list ', '/role/dataGrid', 'role:list', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:20:47', 'admin');
INSERT INTO `menu` VALUES (122, '添加', 'BUTTON', 'ENABLE', 12, 'UNFOLD', 2, 'glyphicon-plus icon-green', '/role/add', 'role:create', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:20:59', 'admin');
INSERT INTO `menu` VALUES (123, '编辑', 'BUTTON', 'ENABLE', 12, 'UNFOLD', 3, 'glyphicon-pencil icon-blue', '/role/edit', 'role:update', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:21:11', 'admin');
INSERT INTO `menu` VALUES (124, '删除', 'BUTTON', 'ENABLE', 12, 'UNFOLD', 4, 'glyphicon-trash icon-red', '/role/delete', 'role:delete', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:21:23', 'admin');
INSERT INTO `menu` VALUES (125, '授权', 'BUTTON', 'ENABLE', 12, 'UNFOLD', 5, 'glyphicon-ok icon-green', '/role/grant', 'role:auth', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:22:01', 'admin');
INSERT INTO `menu` VALUES (131, '列表', 'BUTTON', 'ENABLE', 13, 'UNFOLD', 0, 'glyphicon-list ', '/user/dataGrid', 'user:list', '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (132, '添加', 'BUTTON', 'ENABLE', 13, 'UNFOLD', 0, 'glyphicon-plus icon-green', '/user/add', 'user:create', '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (133, '编辑', 'BUTTON', 'ENABLE', 13, 'UNFOLD', 0, 'glyphicon-pencil icon-blue', '/user/edit', 'user:update', '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (134, '删除', 'BUTTON', 'ENABLE', 13, 'UNFOLD', 0, 'glyphicon-trash icon-red', '/user/delete', 'user:delete', '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `menu` VALUES (226, '修改密码', 'BUTTON', 'ENABLE', 13, 'UNFOLD', 5, 'glyphicon-eye-close ', '/user/editPwd', 'user:updatePwd', '2019-05-26 13:56:53', 'admin', '2019-06-05 10:23:25', 'admin');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态',
  `seq` tinyint(2) NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modify_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', 'ENABLE', 1, '2019-05-26 13:56:53', 'admin', '2019-06-08 23:42:32', 'admin');
INSERT INTO `role` VALUES (2, '管理员', 'ENABLE', 2, '2019-05-26 13:56:53', 'admin', NULL, NULL);
INSERT INTO `role` VALUES (3, '学生', 'ENABLE', 3, '2019-05-26 13:56:53', 'admin', NULL, NULL);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `menu_id` bigint(19) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_resource_ids`(`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7618 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (7600, 1, 1);
INSERT INTO `role_menu` VALUES (7601, 1, 11);
INSERT INTO `role_menu` VALUES (7606, 1, 12);
INSERT INTO `role_menu` VALUES (7612, 1, 13);
INSERT INTO `role_menu` VALUES (7602, 1, 111);
INSERT INTO `role_menu` VALUES (7603, 1, 112);
INSERT INTO `role_menu` VALUES (7604, 1, 113);
INSERT INTO `role_menu` VALUES (7605, 1, 114);
INSERT INTO `role_menu` VALUES (7607, 1, 121);
INSERT INTO `role_menu` VALUES (7608, 1, 122);
INSERT INTO `role_menu` VALUES (7609, 1, 123);
INSERT INTO `role_menu` VALUES (7610, 1, 124);
INSERT INTO `role_menu` VALUES (7611, 1, 125);
INSERT INTO `role_menu` VALUES (7613, 1, 131);
INSERT INTO `role_menu` VALUES (7614, 1, 132);
INSERT INTO `role_menu` VALUES (7615, 1, 133);
INSERT INTO `role_menu` VALUES (7616, 1, 134);
INSERT INTO `role_menu` VALUES (7617, 1, 226);
INSERT INTO `role_menu` VALUES (7588, 2, 1);
INSERT INTO `role_menu` VALUES (7589, 2, 11);
INSERT INTO `role_menu` VALUES (7594, 2, 12);
INSERT INTO `role_menu` VALUES (7590, 2, 111);
INSERT INTO `role_menu` VALUES (7591, 2, 112);
INSERT INTO `role_menu` VALUES (7592, 2, 113);
INSERT INTO `role_menu` VALUES (7593, 2, 114);
INSERT INTO `role_menu` VALUES (7595, 2, 121);
INSERT INTO `role_menu` VALUES (7596, 2, 122);
INSERT INTO `role_menu` VALUES (7597, 2, 123);
INSERT INTO `role_menu` VALUES (7598, 2, 124);
INSERT INTO `role_menu` VALUES (7599, 2, 125);
INSERT INTO `role_menu` VALUES (7574, 3, 1);
INSERT INTO `role_menu` VALUES (7575, 3, 12);
INSERT INTO `role_menu` VALUES (7576, 3, 121);
INSERT INTO `role_menu` VALUES (7577, 3, 122);
INSERT INTO `role_menu` VALUES (7578, 3, 123);
INSERT INTO `role_menu` VALUES (7579, 3, 124);
INSERT INTO `role_menu` VALUES (7580, 3, 125);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '性别',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'RESOURCE_ENABLE' COMMENT '状态',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birthday` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `headimg_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `role_id` bigint(11) NULL DEFAULT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modify_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `IDx_user_login_name`(`login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '6ffa588abb3519f6ef7b3182913d3305', 'jeff', 'MAN', 'ENABLE', '管理员', NULL, '18707173376', 'admin@163.com', '2019-06-02', NULL, 1, '2019-05-26 13:56:53', 'admin', '2019-06-02 13:56:53', 'admin');
INSERT INTO `user` VALUES (66, 'jeff', 'b56ab47690305b89be147d0fa16111d1', '47de1c7487d9436db49e6ac8076192c1', 'MAN', 'ENABLE', '杰', '小杰', '13000000001', 'jeff@163.com', '2019-06-02', NULL, 2, '2019-05-26 13:56:53', 'admin', '2019-06-02 13:57:06', 'jeff');
INSERT INTO `user` VALUES (67, 'zs', 'bbbe949ce3aeb0c113139f60ec77d057', '7fa91b678c8f434882c6a3fc3e29072d', 'MAN', 'ENABLE', '张三', '小三', '13000000005', 'zs@163.com', '2019-06-02', NULL, 3, '2019-05-26 13:56:53', 'admin', '2019-06-02 13:59:21', 'jeff');
INSERT INTO `user` VALUES (68, 'ls', 'ee5690bf377418ab9bd8fcbeafdeb712', 'b4c8aa6861a94cc8aa002d89929603c6', 'WOMAN', 'ENABLE', '李四', '小四', '13000000004', 'ls@163.com', '2019-06-02', NULL, 3, '2019-05-26 13:56:53', 'admin', '2019-06-02 14:02:32', 'jeff');
INSERT INTO `user` VALUES (69, 'ww', 'f9bca0416627d62c3946d541661e75f0', 'f19df35517e044bf9fa67048ca6a1048', 'SECRECY', 'ENABLE', '王五', '小五', '13000000005', 'ww@163.com', '2019-06-02', NULL, 3, '2019-05-26 13:56:53', 'admin', '2019-06-02 14:16:18', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
