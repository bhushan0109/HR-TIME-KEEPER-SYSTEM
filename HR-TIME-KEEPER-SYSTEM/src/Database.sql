/*DROP, CREATE, USE DATABASE daoproject*/
DROP DATABASE IF EXISTS daoproject;
CREATE DATABASE daoproject CHARACTER SET UTF8;
USE daoproject;

/*DROP, CREATE, TEST TABLE employee*/
DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
    eid INT,
    NAME VARCHAR(100),
    post VARCHAR(100),
    mobileNo VARCHAR(100),
    annual_package FLOAT, 
    hireDate DATE ,
    PRIMARY KEY (eid)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    uid INT,
    role VARCHAR(100),
    emailId VARCHAR(100),
    PASSWORD VARCHAR(100), 
    PRIMARY KEY (uid)
);
INSERT INTO users(uid, role, emailId,PASSWORD)
VALUES(1,'admin','admin@gmail.com','1234');

DROP TABLE IF EXISTS timesheetTable;
CREATE TABLE timesheetTable(
    tid INT,
    eid INT,
    NAME VARCHAR(100),
    role VARCHAR(100),
    total_hr_per_day FLOAT ,
    workingDate DATE,
    per_day_salary FLOAT,
    per_hour_rate FLOAT,
    annual_package FLOAT,
    time_sheet_status VARCHAR(100),
    leave_status VARCHAR(100),
    PRIMARY KEY (eid)
);
