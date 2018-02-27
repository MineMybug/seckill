--数据库初始化脚本

--创建数据库
create database seckill;

--使用数据库
use seckill;
--创建秒杀库存表
create table seckill(
	`seckill_id` bigint not null AUTO_INCREMENT COMMENT '商品库存表',
	`name`varchar(120) not null COMMENT '商品名字',
	`number`int not null COMMENT '库存数量',
	`start_time` timestamp not null COMMENT '秒杀开始时间',
	`end_time` timestamp not null COMMENT '秒杀结束时间',
	`create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)engine=innoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT='秒杀库存表'

--初始化数据
insert into 
	seckill(name,number,start_time,end_time)
values
	('1000元秒杀iPhonex','100','2018-02-27 00:00:00','2018-02-28 00:00:00'),
	('500元秒杀iPhonex','200','2018-02-27 00:00:00','2018-02-28 00:00:00'),
	('300元秒杀iPhonex','300','2018-02-27 00:00:00','2018-02-28 00:00:00'),
	('200元秒杀iPhonex','400','2018-02-27 00:00:00','2018-02-28 00:00:00')
	
--秒杀成功明细表
--用户登录认证相关信息

create table success_killed(
	`seckill_id` bigint not null COMMENT '秒杀商品id',
	`user_phone` bigint not null COMMENT '用户手机号码',
	`state` tinyint not null DEFAULT -1 COMMENT '状态标识：-1：无效  0：成功  1：已付款',
	`create_time` timestamp not null COMMENT '创建时间',
	PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
	key idx_create_time(create_time)
)engine=innoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT='秒杀成功明细表'