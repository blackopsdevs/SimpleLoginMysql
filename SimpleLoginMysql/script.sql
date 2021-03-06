
CREATE DATABASE ADMLOGIN;
USE ADMLOGIN;
CREATE USER 'USRADMGLOGIN'@'localhost' IDENTIFIED BY 'PASSUSER123';
GRANT ALL PRIVILEGES ON ADMLOGIN.* TO 'USRADMGLOGIN'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
--DROP TABLE IF EXISTS ADMLOGIN.LOGIN;
  CREATE TABLE ADMLOGIN.LOGIN (
	ID INT(11) NOT NULL,
    USERNAME VARCHAR(255) NOT NULL ,  
    PASSWORD VARCHAR(255) NOT NULL ,
	ESTATUS INT(2)    NOT NULL , 
	FECHA_ALTA TIMESTAMP   NOT NULL , 
	FECHA_ULT_ACT TIMESTAMP  DEFAULT LOCALTIMESTAMP  NOT NULL , 
	PRIMARY KEY(ID)
  ) ENGINE=INNODB;