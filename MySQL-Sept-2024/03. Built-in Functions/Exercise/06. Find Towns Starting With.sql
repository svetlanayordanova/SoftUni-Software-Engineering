SELECT * FROM towns
WHERE LEFT(name, 1) IN ('M', 'K', 'B', 'E')
-- WHERE name REGEXP '^[mkbe]'
ORDER BY name;