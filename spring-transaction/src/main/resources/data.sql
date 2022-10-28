CREATE DATABASE `spring-transaction` /*!40100 COLLATE 'utf8mb4_general_ci' */
use `spring-transaction`;



CREATE TABLE `prd01_car` (
     `id` BIGINT(50) UNSIGNED NOT NULL COMMENT '主键',
     `name` VARCHAR(50) NOT NULL DEFAULT '',
     `price` DECIMAL(20,6) NOT NULL DEFAULT 0,
     `version` INT(10) NOT NULL DEFAULT 0,
     `count` INT(10) NOT NULL DEFAULT 0,
     `is_delete` TINYINT(1) NOT NULL DEFAULT 0,
     PRIMARY KEY (`id`)
)
    COMMENT='汽车'
COLLATE='utf8mb4_0900_ai_ci'
;
