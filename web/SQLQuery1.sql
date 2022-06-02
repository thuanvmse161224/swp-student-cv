<<<<<<< HEAD:SQLQuery1.sql
drop database StudentCV
go
create database StudentCV
go
use StudentCV
go
create table Student(
	StudentId int identity(1,1) PRIMARY KEY,
	JobPosition nvarchar(100) null,
	EduQua nvarchar(100) null,
	Experience nvarchar(100) null,
	StuName nvarchar(100) null,
	PhoneNum nvarchar(10) null,
	Addr nvarchar(255) null,
	Email nvarchar(255) not null
)

create table Major(
	MajorId nvarchar(50) Primary key,
	MajorName nvarchar(255)
)

create table Stu_Major(
	StudentId int foreign key references Student(StudentId),
	MajorId nvarchar(50) foreign key references Major(MajorId),
	PRIMARY KEY(StudentId,MajorId)
)

create table Skill(
	SkillId nvarchar(50) PRIMARY KEY,
	SkillName nvarchar(50) null,
	SkillType nvarchar(50) null
)

create table Stu_Skill(
	StudentId int foreign key references Student(StudentId),
	SkillId nvarchar(50) foreign key references Skill(SkillId),
	PRIMARY KEY(StudentId,SkillId)
)

create table Company(
	CompanyId nvarchar(50) PRIMARY KEY,
	Specialization nvarchar(250),
	Email nvarchar(50),
	PhoneNumber nvarchar(10),
	Addr nvarchar(250)
)

create table Job(
	JobId int identity(1,1) PRIMARY KEY,
	CompanyId nvarchar(50) foreign key references Company(CompanyId),
	JobReq text,
	Vacancies nvarchar(50),
	Salary float,
	JobInf text
)

create table Stu_Job(
	StudentId int foreign key references Student(StudentId),
	JobId int foreign key references Job(JobId),
	PRIMARY KEY(StudentId,JobId)
)

create table CV(
	CvId int identity(1,1) PRIMARY KEY,
	StudentId int FOREIGN KEY REFERENCES Student(StudentId)
)

create table CV_Company(
	CvId int FOREIGN KEY REFERENCES CV(CvId),
	CompanyId nvarchar(50) FOREIGN KEY REFERENCES Company(CompanyId),
	PRIMARY KEY(CvId,CompanyId)
)

create table Career(
	CareerId int identity(1,1) PRIMARY KEY,
	CareerName nvarchar(250)
)

create table Company_Career(
	CareerId int FOREIGN KEY REFERENCES Career(CareerId),
	CompanyId nvarchar(50) FOREIGN KEY REFERENCES Company(CompanyId),
	PRIMARY KEY(CareerId,CompanyId)
)