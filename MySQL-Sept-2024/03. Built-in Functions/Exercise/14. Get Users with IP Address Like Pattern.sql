SELECT user_name, ip_address
FROM users
WHERE ip_address LIKE '___.1%.%.___'
-- WHERE ip_address REGEXP '^[0-9]{3}[.]+1[0-9]*[.][0-9]*[.][0-9]{3}$'
ORDER BY user_name;