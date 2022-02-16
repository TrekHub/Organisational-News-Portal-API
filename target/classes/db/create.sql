SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 departName VARCHAR,
 departDesc VARCHAR,
 employeeNo VARCHAR
);


CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 department VARCHAR,
 departId int
);


CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 content VARCHAR,
 departmentId int
);