SELECT 
	e.employee_id, 
    e.first_name,
	IF (YEAR(p.start_date) >= 2005, NULL, p.name) AS project_name
FROM employees e
JOIN employees_projects ep
	ON e.employee_id = ep.employee_id
JOIN projects p
	ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY project_name;