SET SQL_SAFE_UPDATES = 0;
UPDATE employees SET salary = salary + salary * 0.1;
SELECT salary FROM employees;