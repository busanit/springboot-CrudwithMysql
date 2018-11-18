### Env
java 1.8
vscode
maven
jpaRepository
Lombok
MySQL
JSTL
bootstrap
pageable

### MySQL setting
mysql> create database spring_db;
mysql> create user 'spring'@'localhost' identified by 'bitc5600';
mysql> grant all on spring_db.* to 'spring'@'localhost';

### Git Clone - Project Download

### Project Excute - Jpa auto run - Table create

### Revoke
mysql> revoke all on spring_db.* from 'spring'@'localhost';
mysql> grant select, insert, delete, update on spring_db.* to 'spring'@'localhost';

### yml update
spring.jpa.hibernate.ddl-auto=none

