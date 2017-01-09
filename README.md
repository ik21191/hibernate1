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

The <set> element sets the relationship between Certificate and Employee classes. We used the cascade attribute in the <set> element to tell Hibernate to persist the Certificate objects at the same time as the Employee objects. The name attribute is set to the defined Set variable in the parent class, in our case it is certificates. For each set variable, we need to define a separate set element in the mapping file.

The <key> element is the column in the CERTIFICATE table that holds the foreign key to the parent object ie. table EMPLOYEE.

The <one-to-many> element indicates that one Employee object relates to many Certificate objects.

<strong>One to One mapping</strong>

A one-to-one association is similar to many-to-one association with a difference that the column will be set as unique. For example an address object can be associated with a single employee object.

Define RDBMS Tables:
Consider a situation where we need to store our employee records in EMPLOYEE table which will have following structure:

create table BANKEMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   address    INT NOT NULL,
   PRIMARY KEY (id)
);
Further, assuming that an address can be associated a single employee only, so this association can be presented using one-to-one association. We will store address related information in a separate table which has following structure:

create table BANKEMPLOYEEADDRESS (<br/>
   id INT NOT NULL auto_increment,<br/>
   street_name VARCHAR(40) default NULL,<br/>
   city_name VARCHAR(40) default NULL,<br/>
   state_name VARCHAR(40) default NULL,<br/>
   zipcode VARCHAR(10) default NULL,<br/>
   PRIMARY KEY (id)<br/>
);<br/>

The <many-to-one> element is used to set the relationship between EMPLOYEE and ADDRESS entities. The name attribute is set to the defined variable in the parent class, in our case it is address. The column attribute is used to set the column name in the parent table EMPLOYEE which is set to unique so that only one Employee object can be associated with an address object.

A <strong>Many-to-Many mapping</strong> can be implemented using a Set java collection that does not contain any duplicate element. We already have seen how to map Set collection in hibernate, so if you already learned Set mapping then you are all set to go with many-to-many mapping.

A Set is mapped with a <set> element in the mapping table and initialized with java.util.HashSet. You can use Set collection in your class when there is no duplicate element required in the collection.

Define RDBMS Tables:
Consider a situation where we need to store our employee records in EMPLOYEE table which will have following structure:

create table STUDENT (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);
Further, assume each employee can have one or more certificate associated with him/her and a similar certificate can be associated with more than one employee. We will store certificate related information in a separate table which has following structure:

create table CERTIFICATE_OF_STUDENT (
   id INT NOT NULL auto_increment,
   certificate_name VARCHAR(30) default NULL,
   PRIMARY KEY (id)
);
Now to implement many-to-many relationship between EMPLOYEE and CERTIFICATE objects, we would have to introduce one more intermediate table having Employee ID and Certificate ID as follows:

create table STU_CERT (
   employee_id INT NOT NULL,
   certificate_id INT NOT NULL,
   PRIMARY KEY (employee_id,certificate_id)
);

The <set> element sets the relationship between Certificate and Employee classes. We set cascade attribute to save-update to tell Hibernate to persist the Certificate objects for SAVE i.e. CREATE and UPDATE operations at the same time as the Employee objects. The name attribute is set to the defined Set variable in the parent class, in our case it is certificates. For each set variable, we need to define a separate set element in the mapping file. Here we used name attribute to set the intermediate table name to EMP_CERT.

The <key> element is the column in the EMP_CERT table that holds the foreign key to the parent object ie. table EMPLOYEE and links to the certification_id in the CERTIFICATE table.

The <many-to-many> element indicates that one Employee object relates to many Certificate objects and column attributes are used to link intermediate EMP_CERT.
