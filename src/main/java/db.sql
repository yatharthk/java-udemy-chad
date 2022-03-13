-- DROP TABLE IF EXISTS `spring_security_demo_plaintext`; 

create database if not exists `spring_security_demo_plaintext`;
use `spring_security_demo_plaintext`;

DROP TABLE IF EXISTS `users`;
create table`users`(
`username` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`enabled` tinyint(1) NOT NULL,
primary key(`username`)
)engine=InnoDB default charset=latin1;

INSERT INTO `users` values 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);

DROP TABLE IF EXISTS `authorities`;

create table`authorities`(
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,
unique key`authorities_idx_1` (`username`,`authority`),
constraint `authorities_ibfk_1` foreign key (`username`) references `users`(`username`)
)engine=InnoDB default charset=latin1;

INSERT INTO `authorities` values 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');

