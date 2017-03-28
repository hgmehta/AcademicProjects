 -- 1
# Output : Give Course name ,Grade and Cresit of Course of StudentId = 1301001 in Academic Year 2015 and semester = 5.
SELECT Courses.CourseName,grade_details.grade,Courses.Credit
FROM
(
	SELECT CourseID,grade
    FROM registered
    GROUP BY semester,acadyear,StudentID
    HAVING acadyear = 2015 and semester = 5 and StudentID = 1301001
)As grade_details INNER JOIN Courses
ON Courses.CourseID = grade_details.CourseID;

-- 2
# Output : Count of different grades given by the faculty till today.
SELECT distinct  CourseName,count_of_grades.CourseID,count_of_grades.grade,count_of_grades.No_Of_Students
FROM Courses
INNER JOIN (
	SELECT distinct course_faculty.CourseID,registered.grade,COUNT(StudentId) As No_Of_Students
	FROM Registered 
	INNER JOIN 
	(
		SELECT CourseID 
		FROM Offers 
		WHERE FacultyID = 1101001
	)As course_faculty GROUP BY CourseID,grade
) as count_of_grades ON  count_of_grades.courseID = Courses.CourseID;

-- 3
# List of Students who got A grade in all the subjects in a given semester in a given year. 
SELECT innr_query.StudentID FROM Student INNER JOIN
(
	SELECT StudentID 
	FROM registered
	WHERE StudentID IN
	(
		SELECT DISTINCT StudentID 
		FROM Registered 
		WHERE Semester = 5 AND AcadYear = 2015 AND Grade = 'A'
	)
	AND StudentID NOT IN
	(
		SELECT DISTINCT StudentID 
		FROM Registered 
		WHERE Semester = 5 AND AcadYear = 2015 AND Grade != 'A'
	)
)As innr_query ON innr_query.StudentID = Student.StudentID;

-- 4
# Products who are still in warranty Period and gives the number of months left.
SELECT DeviceID, DATEDIFF(current_date(),PurchaseDate) / 12 As Remaining_Year 
FROM accessories 
WHERE DATEDIFF(current_date(),PurchaseDate) > WarrantyPeriod * 12;
-- 5
# Students who have never got an F Grade in a given batch.
SELECT innr_query.StudentID,ProgID FROM Student INNER JOIN
(
	SELECT registered.StudentID 
	FROM registered 
	WHERE StudentID IN
	(
		SELECT DISTINCT StudentID 
		FROM Registered 
		WHERE AcadYear >= 2014 AND AcadYear <= 2018 AND Grade != 'FF'
	)
	AND StudentID NOT IN
	(
		SELECT DISTINCT StudentID 
		FROM Registered
		WHERE AcadYear >= 2014 AND AcadYear <= 2018 AND Grade = 'FF'
	)
)As innr_query ON innr_query.StudentID = Student.StudentID;

-- 6
#
SELECT StudentID,registered.CourseID,registered.grade FROM registered
INNER JOIN 
(
	SELECT pre_requisitesCourse 
    FROM courses 
    INNER JOIN pre_requisites 
    ON Courses.CourseID = pre_requisites.CourseID 
	WHERE pre_requisites.CourseID = 'ES_302'
) As pre_requisitesCourseList
ON pre_requisitesCourseList.pre_requisitesCourse = registered.courseID
WHERE AcadYear = 2016 AND grade IN ('A+','A','A-','B','B+','B-');

SELECT StudentID,GPA FROM result GROUP BY StudentID HAVING Count(Semester) = 6 ORDER BY GPA DESC  LIMIT 10 ;

-- 7
SELECT StudentID,concat(Fname, ' ',Mname,' ',Lname)As Name FROM Person INNER JOIN
(SELECT StudentID FROM Registered WHERE AcadYear = 2015 and Semester = 5 and Grade = 'F') As reg ON person.PersonID = reg.StudentID;

-- 8
SELECT temp.*,concat(Fname,' ',Mname,' ',Lname) As name FROM Person INNER JOIN 
(SELECT FacultyID,Semester,Count(CourseID) As NO_Of_courseTaken FROM offers GROUP BY FacultyID,Semester) as temp
ON Person.PersonID = temp.FacultyID;

-- 9
SELECT temp.StudentID,ProgID,batch 
FROM(
	SELECT StudentID 
    FROM Registered
    WHERE courseID IN
    (
		SELECT CourseID 
		FROM Faculty INNER JOIN Offers 
		ON Faculty.FacultyID = Offers.FacultyID
		WHERE Faculty.FacultyID = '1101001'
	)
    AND courseID NOT IN
    (
		SELECT CourseID
		FROM Faculty INNER JOIN Offers 
		ON Faculty.FacultyID = Offers.FacultyID
		WHERE Faculty.FacultyID != '1101001'
	)
)AS temp INNER JOIN Student ON temp.StudentID = Student.StudentID;

-- 10
SELECT FacultyID,temp.CourseID,temp.AcadYear,temp.Semester 
FROM (SELECT CourseID,AcadYear,Semester FROM registered WHERE grade = 'F') As temp 
INNER JOIN Offers ON offers.CourseID = temp.CourseID AND offers.AcadYear = temp.AcadYear AND offers.Semester = temp.Semester;

-- 11
SELECT concat(Fname,' ',Mname,' ',Lname) As name FROM Person INNER JOIN
(
	SELECT FacultyID FROM (SELECT FacultyID FROM faculty WHERE VisingOfNot = 1)As temp 
	INNER JOIN Staff ON temp.FacultyID = Staff.StaffID AND staff.Experience > 3
)as temp1 ON temp1.FacultyID = Person.PersonID;

-- 12
SELECT temp.CourseID,CourseName FROM Courses INNER JOIN 
(
	SELECT CourseID FROM registered WHERE CourseID IN
	(
		SELECT DISTINCT CourseID FROM registered WHERE registered.Grade != 'F'
	) AND CourseID NOT IN
	(
		SELECT DISTINCT CourseID FROM registered WHERE registered.Grade = 'F'
	)
)As temp ON temp.CourseID = courses.CourseID;

-- 13
SELECT DISTINCT salary.StaffID,AMOUNT 
FROM SALARY 
WHERE StaffID IN 
( 
	SELECT StaffID 
    FROM 
    (
		SELECT suportstaffid from Suportstaff where WorkID = '4'
	) AS temp 
JOIN Salary on temp.suportstaffid = Salary.staffid
);

-- 14
SELECT SellerName,ContactNo FROM Seller 
INNER JOIN
( 
	SELECT SellerID,count(DeviceID) AS totalDevice FROM accessories GROUP BY SellerID ORDER BY Count(DeviceID) DESC LIMIT 1
) as temp 
ON temp.SellerID = Seller.SellerID;

-- 15
SELECT CompanyName,Count(DeviceID) As totalDevice 
FROM accessories 
GROUP BY CompanyName ORDER BY count(DeviceID) DESC LIMIT 1;

-- 16
SELECT DISTINCT StudentID FROM student WHERE StudentID NOT IN (SELECT DISTINCT StudentID FROM Fee WHERE AcadYear = 2014);

-- 17
SELECT temp.CommitteeID,temp2.President,temp.Vicepresident 
FROM 
(
	SELECT temp3.CommitteeID,concat(Fname,' ',Mname,' ',Lname) As VicePresident 
	FROM 
	(
		SELECT CommitteeID,MemberID As President 
		FROM committeemember 
		WHERE MemberPosition = 'Vice President'
	) as temp3 INNER JOIN Person ON temp3.President = Person.PersonID
)As temp
INNER JOIN 
(
	SELECT temp1.CommitteeID,concat(Fname,' ',Mname,' ',Lname) As President 
	FROM 
	(
		SELECT CommitteeID,MemberID As President 
		FROM committeemember 
		WHERE MemberPosition = 'President'
	) as temp1 INNER JOIN Person ON temp1.President = Person.PersonID
) As temp2 
ON temp.CommitteeID = temp2.CommitteeID;

-- 18
SELECT CourseID,Count(pre_requisitesCourse) As No_Of_prerequisites FROm pre_requisites group by CourseID;

-- 19
SELECT FacultyID FROM faculty INNER JOIN Staff ON staff.StaffID = faculty.FacultyID WHERE datediff(staff.Experience,current_date()) > 1;

-- 20
SELECT FacultyID,datediff(AppointmentDate,current_date()) AS Year_ FROM faculty INNER JOIN Staff ON staff.StaffID = faculty.FacultyID ORDER BY Year_ DESC LIMIT 1;

-- 21
SELECT ProgramID,Count(DISTINCT CourseNAme) FROM special_Courses ORDER BY COUNT(DISTINCT courseName) LIMIT 1;



