SELECT name FROM towns
WHERE CHAR_LENGTH(name) IN (5, 6)
-- WHERE LENGTH(name) IN (5, 6)
ORDER BY name;