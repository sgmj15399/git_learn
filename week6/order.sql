CREATE TABLE t_order
(
id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单id',
order_no VARCHAR(255) COMMENT '订单号',
status int(2) COMMENT '订单状态',
order_price decimal(12,2) COMMENT '订单价格',
pay_type int(2) COMMENT  '支付方式',
pay_no varchar(255) COMMENT  '交易号',
user_id int(11) COMMENT  '收货人ID',
create_time datetime COMMENT  '创建时间',
pay_time datetime COMMENT  '支付时间',
ship_time datetime COMMENT  '发货时间',
);