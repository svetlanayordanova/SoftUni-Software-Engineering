DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(12,4), yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS DECIMAL(12,4)
DETERMINISTIC
BEGIN 
	DECLARE future_value DECIMAL(12,4);
    SET future_value := sum * POW(1 + yearly_interest_rate, number_of_years);
    
RETURN future_value;
END $$