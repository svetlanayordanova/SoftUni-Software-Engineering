SELECT AVG(salary) AS min_average_salary
FROM employees
GROUP BY department_id
ORDER BY min_average_salary
LIMIT 1;

/* SELECT MIN(avg_salary) AS min_average_salary
FROM (SELECT AVG(salary) AS avg_salary
		FROM employees
		GROUP BY department_id) AS dept_averages; */