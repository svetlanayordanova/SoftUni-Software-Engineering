DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(12,4))
BEGIN
	START TRANSACTION;
    
    UPDATE accounts
    SET balance = balance + money_amount
    WHERE id = account_id;
    
    IF (money_amount <= 0) THEN
		ROLLBACK;
	ELSE 
		COMMIT;
	END IF;
END $$