SELECT * FROM towns
WHERE LEFT(name, 1) NOT IN ('R', 'B', 'D')
-- WHERE name REGEXP '^[^rbd\]'
ORDER BY name;