CREATE DATABASE stc;

CREATE TABLE addresses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE clients(
	id INT PRIMARY KEY AUTO_INCREMENT,
	full_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE categories(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE cars(
	id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20),
    year INT NOT NULL,
    mileage INT,
	`condition` CHAR(1) NOT NULL,
    category_id INT NOT NULL,
    
    FOREIGN KEY (category_id)
    REFERENCES categories(id)
);

CREATE TABLE courses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    from_address_id INT NOT NULL,
    start DATETIME NOT NULL,
    car_id INT NOT NULL,
    client_id INT NOT NULL,
    bill DECIMAL(10,2),
    
    FOREIGN KEY (from_address_id)
    REFERENCES addresses(id),
    FOREIGN KEY (car_id)
    REFERENCES cars(id),
    FOREIGN KEY (client_id)
    REFERENCES clients(id)
);

CREATE TABLE drivers(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    rating FLOAT
);

CREATE TABLE cars_drivers(
	car_id INT,
    driver_id INT,
    
    PRIMARY KEY (car_id, driver_id),
    FOREIGN KEY (car_id)
    REFERENCES cars(id),
    FOREIGN KEY (driver_id)
    REFERENCES drivers(id)
);

INSERT INTO clients(full_name, phone_number)
SELECT
	CONCAT(first_name, ' ', last_name),
    CONCAT('(088) 9999', id * 2)
FROM drivers
WHERE id BETWEEN 10 AND 20;

UPDATE cars
SET `condition` = 'C' 
WHERE (mileage >= 800000 OR mileage IS NULL) AND year <= 2010 AND make <> 'Mercedes-Benz';

DELETE c
FROM clients c
LEFT JOIN courses co ON c.id = co.client_id
WHERE co.id IS NULL AND LENGTH(full_name) > 3;

SELECT
	make,
    model,
    `condition`
FROM cars
ORDER BY id;

SELECT
	d.first_name,
    d.last_name,
    c.make,
    c.model,
    c.mileage
FROM drivers d
JOIN cars_drivers cd ON d.id = cd.driver_id
JOIN cars c ON cd.car_id = c.id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

SELECT
	c.id AS car_id,
    c.make,
    c.mileage,
    COUNT(co.id) AS count_of_courses,
    ROUND(AVG(co.bill), 2) AS avg_bill 
FROM cars c
LEFT JOIN courses co ON c.id = co.car_id
GROUP BY c.id
HAVING count_of_courses <> 2
ORDER BY count_of_courses DESC, c.id;

SELECT
	cl.full_name,
    COUNT(*) AS count_of_cars,
    SUM(co.bill) AS total_sum
FROM clients cl
JOIN courses co ON cl.id = co.client_id
JOIN cars c ON co.car_id = c.id
WHERE SUBSTRING(cl.full_name, 2, 1) = 'a'
GROUP BY cl.full_name
HAVING count_of_cars > 1
ORDER BY cl.full_name;

SELECT
	a.name,
    CASE 
		WHEN HOUR(start) BETWEEN 6 AND 20 THEN 'Day'
        WHEN HOUR(start) BETWEEN 20 AND 23 THEN 'Night' 
        WHEN HOUR(start) BETWEEN 0 AND 5 THEN 'Night'
	END AS day_time,
	co.bill,
    cl.full_name,
    c.make,
    c.model,
    ct.name AS category_name
FROM courses co
JOIN addresses a ON co.from_address_id = a.id
JOIN clients cl ON co.client_id = cl.id
JOIN cars c ON co.car_id = c.id
JOIN categories ct ON c.category_id = ct.id
ORDER BY co.id;

DELIMITER $$
CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*)
			FROM clients c
			JOIN courses co ON c.id = co.client_id
			WHERE c.phone_number = phone_num);
END $$

SELECT udf_courses_by_client('(803) 6386812') AS count;
SELECT udf_courses_by_client('(831) 1391236') AS count;
SELECT udf_courses_by_client('(704) 2502909') AS count;

DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
	SELECT
		a.name,
		cl.full_name,
		CASE 
			WHEN co.bill <= 20 THEN 'Low'
			WHEN co.bill <= 30 THEN 'Medium'
			WHEN co.bill > 30 THEN 'High'
		END AS level_of_bill,
		c.make,
		c.`condition`,
		ct.name AS cat_name
	FROM addresses a
	JOIN courses co ON a.id = co.from_address_id
	JOIN clients cl ON co.client_id = cl.id
	JOIN cars c ON co.car_id = c.id
	JOIN categories ct ON c.category_id = ct.id
	WHERE a.name = address_name
	ORDER BY c.make, cl.full_name;
END $$

CALL udp_courses_by_address('700 Monterey Avenue');
CALL udp_courses_by_address('66 Thompson Drive');