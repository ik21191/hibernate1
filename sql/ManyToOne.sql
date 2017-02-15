A many-to-one association is the most common kind of association where an Object can be associated with multiple 
objects. For example a same address object can be associated with multiple employee objects.

create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   address    INT DEFAULT NULL,
   PRIMARY KEY (id)
);

create table ADDRESS (
   id INT NOT NULL auto_increment,
   street_name VARCHAR(40) default NULL,
   city_name VARCHAR(40) default NULL,
   state_name VARCHAR(40) default NULL,
   zipcode VARCHAR(10) default NULL,
   PRIMARY KEY (id)
);