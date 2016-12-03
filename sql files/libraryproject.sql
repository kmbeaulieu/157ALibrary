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
 birthday DATE DEFAULT '0000-00-00',
 fees DOUBLE DEFAULT 0.0,
 updatedOn timestamp not null on update current_timestamp,
 archivedOn timestamp not null,
 CHECK(isEmployee<2),
 PRIMARY KEY (uID)
) ;
ALTER table ARCHIVE AUTO_INCREMENT = 9001;

--
-- Inserting dummy data into User
--
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Alice",1,1,'2000-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Bob",1,0,'2000-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Jerry",1,0,'2000-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Carrie",1,0,'2000-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Xavier",1,0,'2000-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Kelly",0,1,'2010-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Leon",0,0,'2000-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Daniel",0,0,'2009-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("George",0,0,'2003-10-10',0.0,'2016-12-3 12:30:00');
INSERT INTO USER (name, isEmployee, borrowed, birthday, fees, updatedOn)
VALUES ("Eleanor",0,0,'2000-10-10',0.0,'2016-12-3 12:30:00');

--
-- Inserting dummy data into Location
--
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (1, 5, 2001);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (1, 2, 2002);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (2, 2, 2003);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (2, 9, 2004);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (3, 1, 2005);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (3, 3, 2006);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (4, 7, 2007);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (6, 1, 2008);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (6, 4, 2009);
INSERT INTO LOCATION (shelfID, rowNumber, bookID)
VALUES (8, 10, 2010);

--
-- Inserting dummy data into Book
--
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Bambi', 'Felix Salten', 5, 3001);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Faraway Child', 'Amy Maida Wadsworth',	3, 3002);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Lion King', 'Don Ferguson', 11, 3003);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('The Silver Sun', 'Nancy Springer',	9, 3003);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Eye of Sierras', 'Robin Jones Gunn', 13, 3004);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('The Path\'s Secrets', 'Sayyid Haydar Amuli', 5, 3005);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Evening in the Ashes',	'Dorothy Love',	20,	3006);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('The Sage and the Lace', 'James Dove', 4, 3007);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Database Systems',	'Jennifer Widom', 1, 3008);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Every Perfect Gift', 'Dorothy Love', 5, 3009);
INSERT INTO BOOK (title, author, copies, locationID)
VALUES ('Everything We Have', 'Dorothy Love', 5, 3010);

--
-- Inserting dummy data into Loan
--
INSERT INTO LOAN(uID,bookID,checkoutDate,dueDate,overdue)
VALUES(1,2001,'2016-12-3','2016-12-10',0);
INSERT INTO LOAN(uID,bookID,checkoutDate,dueDate,overdue)
VALUES(6,2002,'2016-12-3','2016-12-10',0);

--
-- Inserting dummy data into Employee
--
Insert into employee(uID, department, name, date, employeePIN )  
VALUES (1 ,'deptName', 'Alice', '2016-11-08',	10101);
Insert into employee(uID, department, name, date, employeePIN)  
VALUES (2 ,'deptName',	'Bob' ,'2016-11-08',	22222);
Insert into employee(uID, department, name, date, employeePIN)  
VALUES (3,'deptName',	'Jerry'	,'2016-11-08',	12345);
Insert into employee(uID, department, name, date, employeePIN)  
VALUES ( 4,'deptName',	'Carrie',	'2016-11-08',	43215);
Insert into employee(uID, department, name, date, employeePIN)  
VALUES (5,'deptName', 'Xavier',	'2016-11-08',	55555);

--
-- Inserting dummy data into Archive 
--
