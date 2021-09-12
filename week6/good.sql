CREATE TABLE t_good
(
id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品id',
good_name VARCHAR(255) COMMENT '商品名称',
price decimal(12,2)  COMMENT '商品名称',
stock int(11)  COMMENT '商品库存',
color varchar(255) COMMENT '商品颜色',
size varchar(255) COMMENT '尺码',
brand varchar(255) COMMENT '品牌',
material varchar(255) COMMENT '材料',
application_people varchar(255) COMMENT '适用人群',
is_used tinyint(1) COMMENT '是否生效',
create_time datetime COMMENT '创建时间',
update_time datetime COMMENT '修改时间'
);