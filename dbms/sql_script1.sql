use master;

IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'stucv')
BEGIN
    CREATE DATABASE stucv;
END;
GO

use stucv;

/*
create table tbl_Account_info (
	email varchar(50) primary key,
	password varchar(64) not null,
	fullname varchar(30) not null,
	address varchar(30) not null,
	phoneNum varchar(10) not null,
	createDate date not null
)

create table tbl_Account_status (
	email varchar(50) FOREIGN KEY
	REFERENCES tbl_Account_info(email),
	accStatus bit not null,
	role bit not null
)

create table tbl_Hotel_info (
	hotelName varchar(30) primary key,
	address varchar(30) not null,
	phoneNum varchar(10) not null,
	createDate date not null
)

create table tbl_Room_info (
	roomID varchar(10) primary key,
	type varchar(30) not null,
	price int not null,
	amount int not null,
	createDate date not null,
	hotelName varchar(30) FOREIGN KEY
	REFERENCES tbl_Hotel_info(hotelName)
)
*/