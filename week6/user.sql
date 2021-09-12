CREATE TABLE t_user
(
id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
name VARCHAR(255) COMMENT '用户姓名',
password varchar(255) COMMENT '密码',
phone varchar(255) COMMENT '用户手机',
address varchar(255) COMMENT '用户地址',
pay_account varchar(255) COMMENT '支付账号',
sex tinyint(1) COMMENT '性别',
is_used tinyint(1) COMMENT '是否在用',
create_time datetime COMMENT '创建时间',
update_time datetime COMMENT '修改时间' 
);