DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(12,4))
BEGIN
	DECLARE initial_outgoing_balance DECIMAL(12,4);
    SET initial_outgoing_balance := (SELECT balance
									FROM accounts
                                    WHERE id = from_account_id);

	START TRANSACTION;
    
    UPDATE accounts
    SET balance = balance - amount
    WHERE id = from_account_id;
    
    UPDATE accounts
    SET balance = balance + amount
    WHERE id = to_account_id;
    
    IF ((SELECT id FROM accounts WHERE id = from_account_id) IS NULL
		OR (SELECT id FROM accounts WHERE id = to_account_id) IS NULL
        OR amount < 0 OR initial_outgoing_balance < amount
        OR from_account_id = to_account_id) THEN
        ROLLBACK;
	ELSE 
		COMMIT;
	END IF;
END $$