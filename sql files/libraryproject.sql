DROP DATABASE IF EXISTS LIBRARYPROJECT;
CREATE DATABASE LIBRARYPROJECT;
USE LIBRARYPROJECT; 

DROP TABLE IF EXISTS USER;
CREATE TABLE USER
(uID INT AUTO_INCREMENT,
 name VARCHAR(30),
 isEmployee TINYINT DEFAULT 0,
 borrowed INT DEFAULT 0,
 birthday DATE DEFAULT '0000-00-00',
 fees DOUBLE DEFAULT 0.0,
 updatedOn timestamp not null on update current_timestamp,
 CHECK(isEmployee<2),
 PRIMARY KEY (uID)
) ;
ALTER table USER AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS LOCATION;
CREATE TABLE LOCATION
(locationID INT AUTO_INCREMENT,
shelfID INT,
rowNumber INT,
bookID INT,
CHECK(shelfID>0 and shelfID<11 and rowNumber>0 and rowNumber<21),
PRIMARY KEY(locationID)
);
ALTER table LOCATION AUTO_INCREMENT = 3001;

DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK
(bookID INT AUTO_INCREMENT,
 title VARCHAR(50),
  author VARCHAR(30),
 copies INT,
 locationID INT, 
 CHECK(copies>=0),
 PRIMARY KEY(bookID),
 FOREIGN KEY(locationID) references Location (locationID)
);
ALTER table BOOK AUTO_INCREMENT = 2001;

DROP TABLE IF EXISTS LOAN;
CREATE TABLE LOAN
(loanID INT AUTO_INCREMENT,
 uID INT ,
 bookID INT,
 checkoutDate DATE DEFAULT '0000-00-00',
 dueDate DATE DEFAULT '0000-00-00',
 overdue TINYINT DEFAULT 0,
 CHECK(overdue <2),
 PRIMARY KEY(loanID),
 FOREIGN KEY (uID) references User (uID),
 FOREIGN KEY (bookID) references Book(bookID) 
) ;
ALTER table LOAN AUTO_INCREMENT = 1001;

DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE EMPLOYEE
(eID INT AUTO_INCREMENT,
uID INT,
department VARCHAR(30),
name VARCHAR(30),
date DATE DEFAULT '0000-00-00',
employeePIN INT DEFAULT 00000,
CHECK (employeePIN<=99999),
PRIMARY KEY (eID),
FOREIGN KEY (uID) references User(uID)
);
ALTER table EMPLOYEE AUTO_INCREMENT = 4001;

DROP TABLE IF EXISTS ARCHIVE;
CREATE TABLE ARCHIVE
(uID INT AUTO_INCREMENT,
 name VARCHAR(30),
 isEmployee TINYINT DEFAULT 0,
 borrowed INT DEFAULT 0,
 birthdate DATE DEFAULT '0000-00-00',
 fees DOUBLE DEFAULT 0.0,
 updatedOn timestamp not null on update current_timestamp,
 archivedOn timestamp not null,
 CHECK(isEmployee<2),
 PRIMARY KEY (uID)
) ;
ALTER table USER AUTO_INCREMENT = 9001;

-- local files. comment out what you dont need. highlight then ctrl + divide (the / on the num pad)
-- Krystle table files
LOAD DATA LOCAL INFILE 'c:\\Users\\Kori\\Documents\\GitHub\\157AProject\\sql files\\user.txt' INTO TABLE USER;
LOAD DATA LOCAL INFILE 'C:\\Users\\Kori\\Documents\\GitHub\\157ALibrary\\sql files\\location.txt' INTO TABLE LOCATION;
LOAD DATA LOCAL INFILE 'c:\\Users\\Kori\\Documents\\GitHub\\157AProject\\sql files\\book.txt' INTO TABLE BOOK;
LOAD DATA LOCAL INFILE 'C:\\Users\\Kori\\Documents\\GitHub\\157ALibrary\\sql files\\employee.txt' INTO TABLE EMPLOYEE;
-- Fion table files
-- LOAD DATA LOCAL INFILE 'c:\\Users\\Fion\\Desktop\\locations.txt' INTO TABLE LOCATION;
-- LOAD DATA LOCAL INFILE 'c:\\Users\\Fion\\Desktop\\books.txt' INTO TABLE BOOK;
-- Shakti table files