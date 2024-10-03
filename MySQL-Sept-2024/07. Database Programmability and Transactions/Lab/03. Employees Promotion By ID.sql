DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(user_id INT)
BEGIN
	DECLARE e_cnt INT;
    SET e_cnt := (SELECT COUNT(*) 
				  FROM employees 
                  WHERE employee_id = user_id);
    
    START TRANSACTION;
    
    UPDATE employees
    SET salary = salary * 1.05
    WHERE employee_id = user_id;
    
    IF (e_cnt = 0) THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END $$