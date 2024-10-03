DELIMITER $$ 
CREATE PROCEDURE usp_get_towns_starting_with(string VARCHAR(20))
BEGIN
	SELECT name AS town_name
	FROM towns
	WHERE name LIKE CONCAT(string, '%')
	ORDER BY town_name;
END $$