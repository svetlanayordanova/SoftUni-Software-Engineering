CREATE TABLE high_paid_employees
SELECT * FROM employees
WHERE salary > 30000;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM high_paid_employees
WHERE manager_id = 42;

UPDATE high_paid_employees
SET salary = salary + 5000
WHERE department_id = 1;

SELECT 
	department_id,
    AVG(salary) AS avg_salary
FROM high_paid_employees
GROUP BY department_id
ORDER BY department_id;