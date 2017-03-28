CREATE DATABASE collegeDBMS;
DROP DATABASE collegeDBMS;
use collegeDBMS;

CREATE TABLE Person
(
	PersonID varchar(10) PRIMARY KEY,
    Fname varchar(35) NOT NULL,
    Mname varchar(35) NOT NULL,
    Lname varchar(35) NOT NULL,
    Dob date NOT NULL,
    Gender varchar(10) NOT NULL,
    StreetAddress varchar(50) NOT NULL,
    PIN varchar(10) NOT NULL,
    FOREIGN KEY (PIN) REFERENCES PINDetails(PIN)
);
CREATE TABLE PINDetails
(
	PIN varchar(10) PRIMARY KEY,
    City varchar(25) NOT NULL,
    State varchar(25) NOT NULL,
    Country varchar(25) NOT NULL
);
CREATE TABLE EmailAddress
(
	PersonID varchar(10),
    EmailID varchar(50) NOT NULL,
    PRIMARY KEY(PersonID,EmailID),
	FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
DROP TABLE EmailAddress;
CREATE TABLE ContactDetails
(
	PersonID varchar(10),
    ContactNo varchar(20),
    PRIMARY KEY(PersonID,ContactNo),
	FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
DROP TABLE ContactDetails;

CREATE TABLE Committee
(
	CommitteeID varchar(3) PRIMARY KEY,
    Since date,
    CommitteeName varchar(25) NOT NULL
);
DROP TABLE Committee;


CREATE TABLE CommitteeMember
(
	MemberID varchar(10) NOT NULL,
    Year int NOT NULL,
    CommitteeID varchar(3) NOT NULL,
    MemberPosition varchar(20),
    PRIMARY KEY(MemberID,Year),
    FOREIGN KEY (MemberID) REFERENCES Person(PersonID),
    FOREIGN KEY (CommitteeID) REFERENCES Committee(CommitteeID)
);

drop TABLE CommitteeMember;


CREATE TABLE Forms
(
	MemberID varchar(10) NOT NULL,
    Year int NOT NULL,
    CommitteeID varchar(3) NOT NULL,
    PRIMARY KEY(MemberID,Year,CommitteeID),
    FOREIGN KEY (MemberID,Year) REFERENCES CommitteeMember(MemberID,Year),
    FOREIGN KEY (CommitteeID) REFERENCES Committee(CommitteeID)
);
drop table Forms;


CREATE TABLE Program
(
	ProgID varchar(6) NOT NULL PRIMARY KEY,
    ProgramName varchar(15) NOT NULL
);



CREATE TABLE Student
(
	StudentID varchar(10) PRIMARY KEY,
    NameOfSchool varchar(40) NOT NULL,
    GuardianContactNo varchar(20) NOT NULL,
    BoardSeatNo varchar(15) NOT NULL UNIQUE KEY,
    ProgID varchar(6) NOT NULL,
    ACPCNO varchar(10) UNIQUE KEY,
    Attempts int NOT NULL,
    AddressOfSchool varchar(60) NOT NULL,
    HSCBoard varchar(20) NOT NULL,
    GradeObtained varchar(5) NOT NULL,
    JEEROllNO varchar(15) NOT NULL UNIQUE KEY,
    Medium varchar(10) NOT NULL,
    JEEScore int NOT NULL,
    YearOfPassing int NOT NULL,
    Batch int NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Person(PersonID),
    FOREIGN KEY (progID) REFERENCES Program(ProgID)
);
Drop table student;


CREATE TABLE Fee
(
	ReceiptNo varchar(15) PRIMARY KEY,
    ChequeNo varchar(20) NOT NULL UNIQUE KEY,
    BankName varchar(35) NOT NULL,
    Date date NOT NULL,
    Amount int NOT NULL,
    AcadYear int NOT NULL,
    Semester int NOT NULL,
    StudentID varchar(10) NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentId)
);
drop table Fee;



CREATE TABLE Courses
(
	CourseID varchar(15) NOT NULL PRIMARY KEY,
    Since date,
    CourseName varchar(60) NOT NULL,
    Credit numeric(10,2) NOT NULL
);
drop table courses;

CREATE TABLE pre_requisites
(
	CourseID varchar(15) NOT NULL,
	pre_requisitesCourse varchar(15) NOT NULL,
	PRIMARY KEY(CourseID,pre_requisitesCourse),
	FOREIGN KEY (CourseID) REFERENCES Courses(CourseId),
	FOREIGN KEY (pre_requisitesCourse) REFERENCES Courses(CourseId)
);
drop table pre_requisites;

CREATE TABLE Staff
(
	StaffID varchar(10) NOT NULL PRIMARY KEY,
    AppointmentDate date NOT NULL,
    Experience int NOT NULL,
    FOREIGN KEY (StaffID) REFERENCES Person(PersonID)
);
drop table Staff;

CREATE TABLE Faculty
(
	FacultyID varchar(10) PRIMARY KEY,
    VisingOfNot varchar(1) NOT NULL,
    Designation varchar(40) NOT NULL,
    Specialization varchar(40),
    FOREIGN KEY (FacultyID) REFERENCES Staff(StaffID)
);

CREATE TABLE Salary
(
	PaySlipNo varchar(10) PRIMARY KEY,
    ChequeNo varchar(20) UNIQUE KEY,
    BankName varchar(30) NOT NULL,
    StaffID varchar(10) NOT NULL,
    Amount int NOT NULL,
    Date date NOT NULL,
    FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);


CREATE TABLE Seller
(
	SellerID varchar(10) PRIMARY KEY,
    SellerMail varchar(30) UNIQUE KEY,
    SellerAddress varchar(40),
    SellerName varchar(35) NOT NULL,
    ContactNo varchar(25) NOT NULL UNIQUE KEY
);

drop table Seller;

CREATE TABLE Accessories
(
	DeviceID varchar(15) PRIMARY KEY,
    SellerID varchar(6) NOT NULL,
    CompanyName varchar(25) NOT NULL,
    ProductName varchar(25) NOT NULL,
    WarrantyPeriod int NOT NULL,
    InvoiceNo varchar(7) NOT NULL,
    PurchaseDate date NOT NULL,
    PurchaseAmount int NOT NULL,
    FOREIGN KEY (SellerID) REFERENCES Seller(SellerID) 
);

drop table Accessories;
CREATE TABLE WorkType
(
	WorkID varchar(5) PRIMARY KEY,
    TypeOfWork varchar(25)
);
drop table WorkType;

CREATE TABLE DegreeList
(
	StaffID varchar(10) NOT NULL,
    Degree varchar(60) NOT NULL,
    PRIMARY KEY(StaffID,Degree),
    foreign key (staffID) references Staff(staffID)
);
drop table DegreeList;


CREATE TABLE Peon
(
	PeonID varchar(10) PRIMARY KEY,
    WorkID varchar(5),
    FOREIGN KEY (WorkID) REFERENCES WorkType(WorkID)
);
drop table Peon;


CREATE TABLE SuportStaff
(
	SuportStaffID varchar(10) PRIMARY KEY,
    Designation varchar(40) NOT NULL,
    WorkID varchar(5),
    FOREIGN KEY (SuportStaffID) REFERENCES Staff(StaffID),
    FOREIGN KEY (WorkID) REFERENCES WorkType(WorkID)
);


CREATE TABLE Offers
(
	CourseID varchar(10) NOT NULL,
    Semester int NOT NULL,
    AcadYear int NOT NULL,
    FacultyID varchar(10) NOT NULL,
    PRIMARY KEY(CourseID,Semester,AcadYear,FacultyID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
    FOREIGN KEY (FacultyID) REFERENCES Faculty(FacultyID)
);
drop table Offers;



CREATE TABLE Registered
(
	StudentID varchar(10) NOT NULL,
	CourseID varchar(10) NOT NULL,
	Semester int NOT NULL,
	AcadYear int NOT NULL,
	Grade varchar(5) NOT NULL,
	PRIMARY KEY(CourseID,Semester,AcadYear,StudentID),
	FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
	FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
	FOREIGN KEY (CourseId,Semester,AcadYear) REFERENCES Offers(CourseID,Semester,AcadYear)
);
drop table Registered;


CREATE TABLE Result
(
	StudentID varchar(10) NOT NULL,
    AcadYear int NOT NULL,
    Semester int NOT NULL,
    GPA numeric(10,2) NOT NULL,
    CGPA numeric(10,2) NOT NULL,
    PRIMARY KEY(StudentID,Semester,AcadYear),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);
drop table Result;

USE collegeDBMS;

CREATE TABLE Special_Courses
(
	SpecialCourseID varchar(25) NOT NULL PRIMARY KEY,
	FacultyID varchar(10) NOT NULL,
    Semester int NOT NULL,
    CourseName varchar(50) NOT NULL,
    Numberoflectures int,
    ProgramID varchar(10) NOT NULL
);
drop table Special_Courses;