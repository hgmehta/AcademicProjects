-- 1
# Calculates the CGPA.
DELIMITER $$
CREATE TRIGGER cgpa_calculat BEFORE INSERT ON result
FOR EACH ROW
BEGIN
	declare sum_credit numeric(10,2);
    declare point_ numeric(10,2);
    declare mspi numeric(10,2);
    declare total_credit numeric(10,2);
    declare cr numeric(10,2);
    SET sum_credit = 0;
    SET total_credit =0;
    SET point_ = 0;
    SET mspi = 0;
    CREATE OR REPLACE VIEW stud AS SELECT StudentID FROM Registered Where AcadYear = acady ANd Semester = sem;
    label1: loop
     CREATE OR REPLACE VIEW course AS SELECT StudentID,Grade,AcadYear,Semester FROM registered WHERE AcadYear = acady AND Semester = sem AND StudentID = stud.StudentID;
		label2: loop
			IF (course.grade = 'A+') THEN
				SET point_ = 4.33;
            ELSEIF (course.grade = 'A') THEN
				SET point_ = 4.00;
            ELSEIF (course.grade = 'A-') THEN
				SET point_ = 3.63;
			ELSEIF (course.grade = 'B+') THEN
				SET point_ = 3.33;
            ELSEIF (course.grade = 'B') THEN
				SET point_ = 3.00;
            ELSEIF (course.grade = 'B-') THEN
				SET point_ = 2.63;
			ELSEIF (course.grade = 'C+') THEN
				SET point_ = 2.33;
            ELSEIF (course.grade = 'C') THEN
				SET point_ = 2.00;
            ELSEIF (course.grade = 'C-') THEN
				SET point_ = 1.63;
			ELSEIF (course.grade = 'D+') THEN
				SET point_ = 1.33;
            ELSEIF (course.grade = 'D') THEN
				SET point_ = 1.00;
            ELSEIF (course.grade = 'F') THEN
				SET point_ = 0.00;
            END IF;
            SELECT credit INTO cr FROM courses WHERE CourseID = course.CourseID;
				SET total_credit = total_credit + cr;
                SET sum_credit = sum_credit + cr * point_;
			leave label2;
            SET mspi = sum_point / sum_credit;
            UPDATE result SET CGPA = mspi WHERE AcadYear = acady and Semester = sem and StudentID = stud.StudentID;
        end loop label2;
        leave label1;
    end loop label1;
END$$
DELIMITER ;
#Calculates the GPA
-- 2
DELIMITER $$
CREATE TRIGGER gpa_calculation BEFORE INSERT ON result
FOR EACH ROW
BEGIN
	CREATE VIEW gpac AS SELECT StudentID,(SUM(CGPA)/COUNT(Semester)) AS mgpa FROM result GROUP BY StudentID HAVING AcadYear = NEW.Acadyear AND Semester = New.Semester;
    UPDATE result SET GPA = temp.mgpa WHERE StudentID = temp.StudentID AND Semester = NEW.Semester AND AcadYear = NEW.AcadYear;
END $$
DELIMITER ;
#Calculates the Average Performance based on CGPA
-- 3
DELIMITER $$
CREATE PROCEDURE avg_performance(acay int, sem int)
BEGIN
	SELECT StudentID,AVG(CGPA) AS avg_cgpa FROM result GROUP BY StudentID,AcadYear,Semester HAVING AcadYear = acay AND Semester = sem;
END
$$
DELIMITER ;
CALL avg_performance(2015,5);

# For a given student,semester and year it aggregates the grades.
-- 4
DELIMITER $$
CREATE PROCEDURE count_grade(acay int, sem int,grade_ varchar(3))
BEGIN
	SELECT StudentID,AcadYear,Semester,Grade,count(grade)As totalgrade FROM registered WHERE AcadYear = acay And semester = sem And grade = grade_;  
END
$$
DELIMITER ;

CALL count_grade(2015,5,'B');
# Total Salary given by the institute for a particular Year.
-- 5
DELIMITER $$
CREATE PROCEDURE year_salary(acay int)
BEGIN
	SELECT SUM(Amount) AS TotalSalary FROM Salary Where Extract(YEAR FROM Salary.Date) = acay;
END
$$
DELIMITER ;

CALL year_salary(2014);
# Toral Profit earned by the institute for a given year.
-- 6
DELIMITER $$
CREATE PROCEDURE profit(acay int)
BEGIN
	Declare fee_ int;
	Declare salary_ int;
    Declare acc int;
    SET acc = (SELECT SUM(PurchaseAmount) As totalexpenses FROM Accessories WHERE Extract(YEAR FROM Accessories.PurchaseDate));
    SET fee_ = (SELECT SUM(Amount) AS TotalFee FROM fee Where Extract(YEAR FROM Fee.Date) = acay);
    SET salary_ = (SELECT SUM(Amount) AS TotalSalary FROM Salary Where Extract(YEAR FROM Salary.Date) = acay);
    SELECT (fee_ - salary_ - acc) As profit;
END
$$
DELIMITER ;
CALL profit(2014);