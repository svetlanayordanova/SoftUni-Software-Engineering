DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(number DECIMAL(12,4))
BEGIN
	SELECT 
		first_name,
		last_name
	FROM employees
	WHERE salary >= number
	ORDER BY first_name, last_name, employee_id;
END $$