SELECT first_name, last_name
FROM employees
WHERE CHAR_LENGTH(last_name) = 5;
-- WHERE LENGTH(last_name) = 5;