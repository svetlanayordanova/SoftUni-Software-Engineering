SELECT 
	mountain_range, 
    peak_name, 
    elevation AS peak_elevation 
FROM peaks p
JOIN mountains m
ON p.mountain_id = m.id
WHERE mountain_range = 'Rila'
ORDER BY peak_elevation DESC;