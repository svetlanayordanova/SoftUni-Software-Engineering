CREATE DATABASE restaurant_db;

CREATE TABLE waiters(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    salary DECIMAL(10,2)
);

CREATE TABLE tables(
	id INT PRIMARY KEY AUTO_INCREMENT,
    floor INT NOT NULL,
    reserved TINYINT(1),
    capacity INT NOT NULL
);

CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
    table_id INT NOT NULL,
    waiter_id INT NOT NULL,
    order_time TIME NOT NULL,
    payed_status TINYINT(1),
    
    FOREIGN KEY (table_id)
    REFERENCES tables(id),
    FOREIGN KEY (waiter_id)
    REFERENCES waiters(id)
);

CREATE TABLE products(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE clients(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    card VARCHAR(50),
    review TEXT
);

CREATE TABLE orders_products(
	order_id INT,
    product_id INT,
    
    KEY (order_id, product_id),
    FOREIGN KEY (order_id)
    REFERENCES orders(id),
    FOREIGN KEY (product_id)
    REFERENCES products(id)
);

CREATE TABLE orders_clients(
	order_id INT,
    client_id INT,
    
    KEY (order_id, client_id),
    FOREIGN KEY (order_id)
    REFERENCES orders(id),
    FOREIGN KEY (client_id)
    REFERENCES clients(id)
);

INSERT INTO products(name, type, price)
SELECT 
	CONCAT(last_name, ' ', 'specialty'),
    'Cocktail',
    CEIL(0.01 * salary)
FROM waiters
WHERE id > 6;

UPDATE orders
SET table_id = table_id - 1
WHERE id BETWEEN 12 AND 23;

SET SQL_SAFE_UPDATES = 0;
DELETE w
FROM waiters w
LEFT JOIN orders o ON w.id = o.waiter_id
WHERE o.id IS NULL;

SELECT * FROM clients
ORDER BY birthdate DESC, id DESC;

SELECT 
	first_name,
    last_name,
    birthdate,
    review
FROM clients
WHERE card IS NULL AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY last_name DESC, id
LIMIT 5;

SELECT
	CONCAT(last_name, first_name, LENGTH(first_name), 'Restaurant') AS username,
    REVERSE(SUBSTRING(email, 2, 12)) AS password
FROM waiters
WHERE salary IS NOT NULL
ORDER BY password DESC;

SELECT 
	p.id,
    p.name,
    COUNT(*) AS count
FROM products p
JOIN orders_products op ON p.id = op.product_id 
GROUP BY p.name
HAVING count >= 5
ORDER BY count DESC, p.name;

SELECT
	t.id AS table_id,
    t.capacity,
    COUNT(*) AS count_clients,
    CASE
		WHEN t.capacity > COUNT(*) THEN 'Free seats'
        WHEN t.capacity = COUNT(*) THEN 'Full'
        WHEN t.capacity < COUNT(*) THEN 'Extra seats'
	END AS availability
FROM tables t
JOIN orders o ON t.id = o.table_id
JOIN orders_clients oc ON o.id = oc.order_id
WHERE t.floor = 1
GROUP BY t.id
ORDER BY table_id DESC;

DELIMITER $$
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
	RETURN (SELECT SUM(p.price)
			FROM clients c
			JOIN orders_clients oc ON c.id = oc.client_id
			JOIN orders o ON oc.order_id = o.id
			JOIN orders_products op ON o.id = op.order_id
			JOIN products p ON op.product_id = p.id
			WHERE CONCAT(c.first_name, ' ', c.last_name) = full_name);
END $$

SELECT udf_client_bill('Silvio Blyth') AS bill;

DELIMITER $$
CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN
	UPDATE products p
	SET price = price - price * 0.2
	WHERE price >= 10 AND p.type = type;
END $$

CALL udp_happy_hour('Cognac');