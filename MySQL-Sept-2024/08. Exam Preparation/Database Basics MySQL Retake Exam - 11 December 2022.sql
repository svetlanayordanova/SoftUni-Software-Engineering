CREATE DATABASE airlines_db;

CREATE TABLE airplanes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(50) NOT NULL UNIQUE,
    passengers_capacity INT NOT NULL,
    tank_capacity DECIMAL(19,2) NOT NULL,
    cost DECIMAL(19,2) NOT NULL
);

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    description TEXT,
    currency VARCHAR(5) NOT NULL
);

CREATE TABLE passengers(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    country_id INT NOT NULL,
    
    FOREIGN KEY (country_id)
    REFERENCES countries(id)
);

CREATE TABLE flights(
	id INT PRIMARY KEY AUTO_INCREMENT,
    flight_code VARCHAR(30) NOT NULL UNIQUE,
    departure_country INT NOT NULL,
    destination_country INT NOT NULL,
    airplane_id INT NOT NULL,
    has_delay TINYINT(1),
    departure DATETIME,
    
    FOREIGN KEY (departure_country)
    REFERENCES countries(id),
    FOREIGN KEY (destination_country)
    REFERENCES countries(id),
    FOREIGN KEY (airplane_id)
    REFERENCES airplanes(id)
);

CREATE TABLE flights_passengers(
	flight_id INT,
    passenger_id INT,
    
    KEY (flight_id, passenger_id),
    FOREIGN KEY (flight_id)
    REFERENCES flights(id),
    FOREIGN KEY (passenger_id)
    REFERENCES passengers(id)
);

INSERT INTO airplanes(model, passengers_capacity, tank_capacity, cost)
SELECT 
	CONCAT(REVERSE(first_name), '797'),
    LENGTH(last_name) * 17,
    id * 790,
    LENGTH(first_name) * 50.6
FROM passengers
WHERE id <= 5; 

UPDATE flights f
JOIN countries c ON f.departure_country = c.id
SET airplane_id = airplane_id + 1
WHERE c.name = 'Armenia';

SET SQL_SAFE_UPDATES = 0;
DELETE f
FROM flights f
LEFT JOIN flights_passengers fp ON f.id = fp.flight_id
WHERE fp.passenger_id IS NULL;

SELECT * FROM airplanes
ORDER BY cost DESC, id DESC;

SELECT 
	flight_code,
    departure_country,
    airplane_id,
    departure
FROM flights
WHERE YEAR(departure) = '2022'
ORDER BY airplane_id, flight_code
LIMIT 20;

SELECT 
	CONCAT(UPPER(LEFT(p.last_name, 2)), p.country_id) AS flight_code,
    CONCAT(p.first_name, ' ', p.last_name) AS full_name,
    p.country_id
FROM passengers p
LEFT JOIN flights_passengers fp ON p.id = fp.passenger_id
WHERE fp.flight_id IS NULL
ORDER BY p.country_id;

SELECT * FROM flights;

SELECT 
	c.name,
    c.currency,
    COUNT(*) AS booked_tickets
FROM countries c
JOIN flights f ON c.id = f.destination_country
JOIN flights_passengers fp ON f.id = fp.flight_id
GROUP BY c.name
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;

SELECT 
	flight_code,
    departure,
    CASE 
		WHEN HOUR(departure) BETWEEN '05:00' AND '11:59' THEN 'Morning'
        WHEN HOUR(departure) BETWEEN '12:00' AND '16:59' THEN 'Afternoon'
		WHEN HOUR(departure) BETWEEN '17:00' AND '20:59' THEN 'Evening'
        WHEN HOUR(departure) BETWEEN '21:00' AND '23:59' THEN 'Night'
		WHEN HOUR(departure) BETWEEN '00:00' AND '04:59' THEN 'Night'
	END AS day_part
FROM flights
ORDER BY flight_code DESC;

DELIMITER $$
CREATE FUNCTION udf_count_flights_from_country(country VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*)
			FROM flights f
			JOIN countries c ON f.departure_country = c.id
			WHERE c.name = country);
END $$

SELECT udf_count_flights_from_country('Brazil') AS flights_count;
SELECT udf_count_flights_from_country('Philippines') AS flights_count;

SELECT * FROM flights
WHERE flight_code = 'ZP-782'

DELIMITER $$
CREATE PROCEDURE udp_delay_flight(code VARCHAR(50))
BEGIN
	UPDATE flights
	SET 
		has_delay = 1,
		departure = DATE_ADD(departure, INTERVAL 30 MINUTE)
	WHERE flight_code = code;
END $$

CALL udp_delay_flight('ZP-782');