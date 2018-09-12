-- ----------------------------
-- Records of admin
-- 管理员表
-- ----------------------------
CREATE TABLE `T_Admin`(
	`admin_id` int(11) NOT NULL AUTO_INCREMENT,
	`admin_name` varchar(255) NOT NULL COMMENT '管理员名称',
	`admin_pwd` varchar(255) NOT NULL COMMENT '管理员密码',
	PRIMARY KEY (`admin_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of user
-- 用户表
-- ----------------------------
CREATE TABLE `T_User`(
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
	`user_name` varchar(255) NOT NULL COMMENT '用户名'，
	`user_pwd` varchar(255) NOT NULL COMMENT '用户密码',
	`user_email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
	`user_phone` varchar(255) DEFAULT NULL COMMENT '手机号',
	`user_adress` varchar(255) DEFAULT NULL COMMENT '用户收件地址',
	PRIMARY KEY (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of category
-- 商品分类表
-- ----------------------------
CREATE TABLE `T_Ccategory`(
	`category_id` int(11) NOT NULL AUTO_INCREMENT,
	'category_name' varchar(255) NOT NULL COMMENT '分类名称',
	PRIMARY KEY (`category_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- 商品表
-- ----------------------------
CREATE TABLE `T_Goods`(
	`goods_id` int(11) NOT NULL AUTO_INCREMENT,
	`goods_name` varchar(255) NOT NULL COMMENT '商品名称',
	`goods_num` varchar(255) NOT NULL COMMENT '商品库存',
	`goods_price` varchar(255) NOT NULL COMMENT '商品价格',
	`goods_image` varchar(255) NOT NULL COMMENT '商品图片',
	`goods_desc` varchar(255) NOT NULL COMMENT '商品描述',
	`category_id` int(11) NOT NULL COMMENT '商品分类ID',
	PRIMARY KEY (`goods_id`),
	CONSTRAINT goods_category FOREIGN KEY (`category_id`) REFERENCES T_Ccategory(`category_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- 购物车表
-- ----------------------------

CREATE TABLE `T_Cart`(
	`cart_id` int(11) NOT NULL AUTO_INCREMENT,
	`goods_id` int(11) NOT NULL,
	`order_num` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	PRIMARY KEY (`goods_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ----------------------------
-- 创建唯一索引
-- ----------------------------
ALTER TABLE `T_Cart` ADD UNIQUE INDEX(goods_id,user_id);

-- ----------------------------
-- Records of order
-- 订单表
-- ----------------------------
CREATE TABLE `T_Order`(
	`order_id` varchar(50) NOT NULL AUTO_INCREMENT,
	`order_price` float(50) DEFAULT NULL COMMENT '订单总额',
	`order_time` timestamp  COMMENT '下单时间',
	PRIMARY KEY(`order_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of orderdetail
-- 订单详情表
-- ----------------------------
CREATE TABLE `T_OrderDetail`(
	`orderderail_id` int(11) NOT NULL AUTO_INCREMENT,
	`order_id` varchar(50) NOT NULL,
	`goods_price` float(50) COMMENT '商品价格',
	`goods_name` varchar(255) COMMENT '商品名称',
	`user_id` int(11) COMMENT '用户ID',
	`order_num` int(11) COMMENT '订购数量',
	PRIMARY KEY(`orderderail_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
