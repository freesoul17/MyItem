# SpringBoot-crud

使用SpringBoot整合ssm实现crud操作

# 技术支持

## 后端

- SpringBoot
- lombok
- MySQL8.0
- MySQL驱动
- druid数据库连接池
- mybaits
- pagehelper

## 前端

- vue
- axios
- element-ui

## 数据库

```sql
DROP DATABASE IF EXISTS springboot_db;

CREATE DATABASE springboot_db DEFAULT CHARSET utf8;

USE springboot_db;

CREATE TABLE t_book(
	`id` INT(12) PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	`type` VARCHAR(20) KEY NOT NULL COMMENT '类型',
	`name` VARCHAR(20) NOT NULL COMMENT '书名',
	`note` VARCHAR(255) COMMENT '描述'
)ENGINE = INNODB DEFAULT CHARSET = utf8;
```

