# hibernate1
A many-to-one association is the most common kind of association where an Object can be associated with multiple objects. For example a same address object can be associated with multiple employee objects.

Define RDBMS Tables:
Consider a situation where we need to store our employee records in EMPLOYEE table which will have following structure:

create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   address    INT NOT NULL,
   PRIMARY KEY (id)
);
Further, many employee can have same address, so this association can be presented using many-to-one association. We will store address related information in a separate table which has following structure:

create table ADDRESS (
   id INT NOT NULL auto_increment,
   street_name VARCHAR(40) default NULL,
   city_name VARCHAR(40) default NULL,
   state_name VARCHAR(40) default NULL,
   zipcode VARCHAR(10) default NULL,
   PRIMARY KEY (id)
);
-----------------------------------------------------------
A <strong>One-to-Many</strong> mapping can be implemented using a Set java collection that does not contain any duplicate element. We already have seen how to map Set collection in hibernate, so if you already learned Set mapping then you are all set to go with one-to-many mapping.

A Set is mapped with a <strong>set</strong> element in the mapping table and initialized with java.util.HashSet. You can use Set collection in your class when there is no duplicate element required in the collection.

Define RDBMS Tables:
Consider a situation where we need to store our employee records in EMPLOYEE table which will have following structure:

create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);
Further, assume each employee can have one or more certificate associated with him/her. So we will store certificate related information in a separate table which has following structure:

create table CERTIFICATE (
   id INT NOT NULL auto_increment,
   certificate_name VARCHAR(30) default NULL,
   employee_id INT default NULL,
   PRIMARY KEY (id)
);
