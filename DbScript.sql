CREATE TABLE employee (
  employee_id int NOT NULL AUTO_INCREMENT,
  employee_name varchar(60) NOT NULL,
  employee_salary double DEFAULT '0',
  employee_dept varchar(30) DEFAULT NULL,
  employee_doj date NOT NULL,
  PRIMARY KEY (employee_id)
) ;

INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('John',5000,'IT','2021-01-20');
INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('Sean',9000,'Operation','2021-01-22');
INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('Tom',4000,'Admin','2021-01-25');

MYSQL Stored Procedure without parameter.
------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEmployees`()
BEGIN
SELECT * FROM employee;
END

MYSQL Stored Procedure with one input parameter..
---------------------------------------------------------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmployeeById`(IN empId int)
BEGIN
SELECT * FROM employee WHERE employee_id=empId;
END

MYSQL Stored Procedure with one input parameter and two output parameters..
--------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmployeeNameAndSalaryById`(IN empId INT,OUT empName VARCHAR(100),OUT empSal double)
BEGIN

SELECT employee_name,employee_salary INTO empName,empSal FROM employee WHERE employee_id=empId;

END

You can call above stored procedure from MySQL Workbench as below..
================================================================================================
CALL getAllEmployees();
CALL getEmployeeById(20);

CALL getEmployeeNameAndSalaryById(2,@empName,@empSal);
SELECT @empName,@empSal;

