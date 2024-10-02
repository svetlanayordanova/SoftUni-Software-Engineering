SELECT 
	c.country_code,
    COUNT(*) AS mountain_range
FROM countries c
JOIN mountains_countries mc
	ON c.country_code = mc.country_code
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code
ORDER BY mountain_range DESC;