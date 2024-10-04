DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(12,4))
BEGIN
	DECLARE initial_balance DECIMAL(12,4);
    SET initial_balance := (SELECT balance
							FROM accounts
							WHERE id = account_id);

	START TRANSACTION;
    
    UPDATE accounts
    SET balance = balance - money_amount
    WHERE id = account_id;
                        
    IF (initial_balance < money_amount OR money_amount < 0) THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END $$