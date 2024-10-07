CREATE DATABASE softuni_stores_system;

CREATE TABLE pictures(
	id INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(100) NOT NULL,
    added_on DATETIME NOT NULL
);

CREATE TABLE categories(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE products(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    best_before DATE,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    category_id INT NOT NULL,
    picture_id INT NOT NULL,
    
    FOREIGN KEY (category_id)
    REFERENCES categories(id),
    FOREIGN KEY (picture_id)
    REFERENCES pictures(id)
);

CREATE TABLE towns(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE addresses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    town_id INT NOT NULL,
    
    FOREIGN KEY (town_id)
    REFERENCES towns(id)
);

CREATE TABLE stores(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE,
    rating FLOAT NOT NULL,
    has_parking TINYINT(1),
    address_id INT NOT NULL,
    
    FOREIGN KEY (address_id)
    REFERENCES addresses(id)
);

CREATE TABLE products_stores(
	product_id INT NOT NULL,
    store_id INT NOT NULL,
    
    PRIMARY KEY (product_id, store_id),
    FOREIGN KEY (product_id)
    REFERENCES products(id),
    FOREIGN KEY (store_id)
    REFERENCES stores(id)
);

CREATE TABLE employees(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(15) NOT NULL,
    middle_name CHAR(1),
    last_name VARCHAR(20) NOT NULL,
    salary DECIMAL(19,2) NOT NULL,
    hire_date DATE NOT NULL,
    manager_id INT,
    store_id INT NOT NULL,
    
    FOREIGN KEY (manager_id)
    REFERENCES employees(id),
    FOREIGN KEY (store_id)
    REFERENCES stores(id)
);

INSERT INTO products_stores
SELECT 
	p.id, 
    1
FROM products p
LEFT JOIN products_stores ps ON p.id = ps.product_id 
WHERE ps.store_id IS NULL;

SET SQL_SAFE_UPDATES = 0;
UPDATE employees e
JOIN stores s ON e.store_id = s.id
SET e.manager_id = 3, e.salary = salary + 500
WHERE YEAR(hire_date) > 2003 AND 
	s.name <> 'Cardguard' AND 
    s.name <> 'Veribet';
    
SELECT * FROM employees e
JOIN employees m ON e.id = m.id
WHERE e.manager_id <> m.id AND
	  e.manager_id IS NOT NULL AND
      e.salary >= 6000;
      
DELETE e
FROM employees e
JOIN employees m ON e.id = m.id
WHERE e.manager_id <> m.id AND
	  e.manager_id IS NOT NULL AND
      e.salary >= 6000;
      
SELECT 
	first_name,
    middle_name,
    last_name,
    salary,
    hire_date
FROM employees
ORDER BY hire_date DESC;

SELECT
	p.name AS product_name,
    p.price,
    p.best_before,
    CONCAT(LEFT(p.description, 10), '...') AS short_description,
    pc.url
FROM products p
JOIN pictures pc ON p.picture_id = pc.id
WHERE LENGTH(p.description) > 100 AND 
	  YEAR(pc.added_on) < 2019 AND 
      p.price > 20
ORDER BY p.price DESC;

SELECT
	s.name,
    COUNT(p.id) AS product_count,
    ROUND(AVG(p.price), 2) AS avg
FROM stores s
LEFT JOIN products_stores ps ON s.id = ps.store_id
LEFT JOIN products p ON ps.product_id = p.id
GROUP BY s.name
ORDER BY product_count DESC, avg DESC, s.id;

SELECT
	CONCAT(e.first_name, ' ', e.last_name) AS Full_name,
    s.name AS Store_name,
    a.name,
    e.salary
FROM employees e
JOIN stores s ON e.store_id = s.id
JOIN addresses a ON s.address_id = a.id
WHERE e.salary < 4000 AND 
	  a.name LIKE '%5%' AND
      LENGTH(s.name) > 8 AND
      e.last_name LIKE '%n';
      
SELECT 
	REVERSE(s.name) AS reversed_name,
    CONCAT(UPPER(t.name), '-', a.name) AS full_address,
    COUNT(*) AS employees_count
FROM stores s
JOIN addresses a ON s.address_id = a.id
JOIN towns t ON a.town_id = t.id
JOIN employees e ON s.id = e.store_id
GROUP BY s.name
HAVING employees_count >= 1
ORDER BY full_address;

DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
	RETURN (SELECT
				CONCAT(e.first_name, ' ', e.middle_name, '. ', e.last_name, ' works in store for ', TIMESTAMPDIFF(YEAR, e.hire_date, '2020-10-18'), ' years')
			FROM employees e
			JOIN stores s ON e.store_id = s.id
			WHERE s.name = store_name
            ORDER BY e.salary DESC
            LIMIT 1);
END $$

SELECT udf_top_paid_employee_by_store('Stronghold') AS full_info;
SELECT udf_top_paid_employee_by_store('Keylex') AS full_info;

DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
	DECLARE price_increment INT;

    IF LEFT(address_name, 1) = '0' THEN
        SET price_increment = 100;
    ELSE
        SET price_increment = 200;
    END IF;
    
	UPDATE products p
	JOIN products_stores ps ON p.id = ps.product_id
	JOIN stores s ON ps.store_id = s.id
	JOIN addresses a ON s.address_id = a.id
	SET p.price = p.price + price_increment
    WHERE a.name = address_name;
END $$

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;