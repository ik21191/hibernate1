CREATE TABLE BANKEMPLOYEE 
( id INT NOT NULL AUTO_INCREMENT, 
first_name VARCHAR(20) DEFAULT NULL, 
last_name VARCHAR(20) DEFAULT NULL, 
salary INT DEFAULT NULL, 
address INT NOT NULL, PRIMARY KEY (id) );

CREATE TABLE BANKEMPLOYEEADDRESS 
( id INT NOT NULL AUTO_INCREMENT, 
street_name VARCHAR(40) DEFAULT NULL, 
city_name VARCHAR(40) DEFAULT NULL, 
state_name VARCHAR(40) DEFAULT NULL, 
zipcode VARCHAR(10) DEFAULT NULL, 
PRIMARY KEY (id) );