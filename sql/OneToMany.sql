CREATE TABLE EMPLOYEE1 (
   id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(20) DEFAULT NULL,
   last_name  VARCHAR(20) DEFAULT NULL,
   salary     INT  DEFAULT NULL,
   PRIMARY KEY (id)
);

create table CERTIFICATE (
   id INT NOT NULL auto_increment,
   certificate_name VARCHAR(30) default NULL,
   employee_id INT default NULL,
   PRIMARY KEY (id)
);