CREATE DATABASE real_estate_db;

CREATE TABLE cities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE buyers(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    city_id INT,
    
    FOREIGN KEY (city_id)
    REFERENCES cities(id)
);

CREATE TABLE agents(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    city_id INT,
    
    FOREIGN KEY (city_id)
    REFERENCES cities(id)
);

CREATE TABLE property_types(
	id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(40) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE properties(
	id INT PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(80) NOT NULL UNIQUE,
    price DECIMAL(19,2) NOT NULL,
    area DECIMAL(19,2),
    property_type_id INT,
    city_id INT,
    
    FOREIGN KEY (property_type_id)
    REFERENCES property_types(id),
    FOREIGN KEY (city_id)
    REFERENCES cities(id)
);

CREATE TABLE property_transactions(
	id INT PRIMARY KEY AUTO_INCREMENT,
    property_id INT NOT NULL,
    buyer_id INT NOT NULL,
    transaction_date DATE,
    bank_name VARCHAR(30),
    iban VARCHAR(40) UNIQUE,
    is_successful TINYINT(1),
    
    FOREIGN KEY (property_id)
    REFERENCES properties(id),
    FOREIGN KEY (buyer_id)
    REFERENCES buyers(id)
);

CREATE TABLE property_offers(
	property_id INT NOT NULL,
    agent_id INT NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    offer_datetime DATETIME,
    
    KEY (property_id, agent_id),
    FOREIGN KEY (property_id)
    REFERENCES properties(id),
    FOREIGN KEY (agent_id)
    REFERENCES agents(id)
);

INSERT INTO property_transactions(property_id, buyer_id, transaction_date, bank_name, iban, is_successful)
SELECT
	agent_id + DAY(offer_datetime),
    agent_id + MONTH(offer_datetime),
    DATE(offer_datetime),
    CONCAT('Bank', ' ', agent_id),
    CONCAT('BG', price, agent_id),
    1
FROM property_offers
WHERE agent_id <= 2;

SELECT * FROM property_transactions;

SELECT price
FROM properties
WHERE price > 800000;

SET SQL_SAFE_UPDATES = 0;
UPDATE properties
SET price = price - 50000
WHERE price >= 800000;

DELETE FROM property_transactions
WHERE is_successful = 0;

SELECT * FROM agents
ORDER BY city_id DESC, phone DESC;

SELECT * FROM property_offers
WHERE YEAR(offer_datetime) = '2021'
ORDER BY price
LIMIT 10;

SELECT 
	LEFT(p.address, 6) AS agent_name,
    LENGTH(p.address) * 5430 AS price
FROM properties p
LEFT JOIN property_offers po ON p.id = po.property_id
WHERE po.property_id IS NULL
ORDER BY agent_name DESC, price DESC;

SELECT 
	bank_name,
    COUNT(*) AS count
FROM property_transactions
GROUP BY bank_name
HAVING count >= 9
ORDER BY count DESC, bank_name;

SELECT 
	address,
    area,
    CASE 
		WHEN area <= 100 THEN 'small'
        WHEN area <= 200 THEN 'medium'
        WHEN area <= 500 THEN 'large'
        WHEN area > 500 THEN 'extra large'
	END AS size
FROM properties
ORDER BY area, address DESC;

DELIMITER $$
CREATE FUNCTION udf_offers_from_city_name(city_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) AS count
			FROM property_offers po
			JOIN properties p ON po.property_id = p.id
			JOIN cities c ON p.city_id = c.id
			WHERE c.name = city_name);
END $$

SELECT udf_offers_from_city_name('Vienna') AS offers_count;
SELECT udf_offers_from_city_name('Amsterdam') AS offers_count;

SELECT 
	first_name,
    price
FROM property_offers po
JOIN agents a ON po.agent_id = a.id
WHERE a.first_name = 'Hans';

DELIMITER $$
CREATE PROCEDURE udp_special_offer(first_name VARCHAR(50))
BEGIN
	UPDATE property_offers po
	JOIN agents a ON po.agent_id = a.id
	SET price = price - price * 0.1
	WHERE a.first_name = first_name;
END $$

CALL udp_special_offer('Hans');