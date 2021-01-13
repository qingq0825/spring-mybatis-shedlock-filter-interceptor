-- auto Generated on 2021-01-06
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	username VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'username',
	num INT (11) NOT NULL DEFAULT -1 COMMENT 'num',
	INDEX(id),
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';