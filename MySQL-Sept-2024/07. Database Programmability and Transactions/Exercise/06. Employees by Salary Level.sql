DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(20))
BEGIN
	SELECT
		first_name,
		last_name
	FROM employees
	WHERE salary_level = (
		SELECT CASE
			WHEN salary < 30000 THEN 'Low'
			WHEN salary <= 50000 THEN 'Average'
			WHEN salary > 50000 THEN 'High'
		END)
	ORDER BY first_name DESC, last_name DESC;
END $$