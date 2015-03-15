CREATE TABLE CLIENT(ID INT PRIMARY KEY,
   NAME VARCHAR(255), FIRSTNAME VARCHAR(255), EMAIL VARCHAR(255), PASSWORD  VARCHAR(255));

 CREATE TABLE CATEGORY(ID INT PRIMARY KEY auto_increment, NAME VARCHAR(255));

 CREATE TABLE ITEM(ID INT PRIMARY KEY auto_increment,COMPOSITION VARCHAR(255),
 	DESCRIPTION VARCHAR(255),  PRICE DOUBLE, REFERENCE INT, CATEGORY_ID INT);
 	
 CREATE TABLE LINK_ORDER_ITEM(ID_ORDER INT PRIMARY KEY,ID_ITEM INT PRIMARY KEY, QUANTITY INT);
 
 CREATE TABLE ORDERS(ID INT PRIMARY KEY,
 	REFERENCE_ID INT, CLIENT_ID INT, QUANTITY INT, ISVALIDATE INT);
 	
 CREATE TABLE STOCK(ID INT PRIMARY KEY, REFERENCE_ID INT, SIZE VARCHAR(5), STOCK INT);
 
 CREATE TABLE REFERENCE_SIZE(SIZE VARCHAR(5) PRIMARY KEY);