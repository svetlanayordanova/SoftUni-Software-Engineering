CREATE DATABASE online_stores;

CREATE TABLE reviews(
	id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
    rating DECIMAL(10,2) NOT NULL,
    picture_url VARCHAR(80) NOT NULL,
    published_at DATETIME NOT NULL
);

CREATE TABLE brands(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE categories(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE products(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    quantity_in_stock INT,
    description TEXT,
    brand_id INT NOT NULL,
    category_id INT NOT NULL,
    review_id INT,
    
    FOREIGN KEY (brand_id)
    REFERENCES brands(id),
    FOREIGN KEY (category_id)
    REFERENCES categories(id),
    FOREIGN KEY (review_id)
    REFERENCES reviews(id)
);

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    phone VARCHAR(30) NOT NULL UNIQUE,
    address VARCHAR(60) NOT NULL,
    discount_card BIT(1) NOT NULL
);

CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
    order_datetime DATETIME NOT NULL,
    customer_id INT NOT NULL,
    
    FOREIGN KEY (customer_id)
    REFERENCES customers(id)
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

INSERT INTO reviews(content, picture_url, published_at, rating)
SELECT
	LEFT(description, 15),
    REVERSE(name),
    '2010-10-10',
    price / 8
FROM products
WHERE id >= 5;

UPDATE products
SET quantity_in_stock = quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70;

DELETE c
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
WHERE o.id IS NULL;

SELECT id, name
FROM categories
ORDER BY name DESC;

SELECT 
	p.id,
    b.id AS brand_id,
    p.name,
    p.quantity_in_stock
FROM products p
JOIN brands b ON p.brand_id = b.id
WHERE p.price > 1000 AND p.quantity_in_stock < 30
ORDER BY p.quantity_in_stock, p.id;

SELECT * FROM reviews
WHERE content LIKE 'My%' AND LENGTH(content) > 61
ORDER BY rating DESC;

SELECT 
	CONCAT(c.first_name, ' ', c.last_name) AS full_name,
    c.address,
    o.order_datetime AS order_date
FROM customers c
JOIN orders o ON c.id = o.customer_id
WHERE YEAR(o.order_datetime) <= 2018
ORDER BY full_name DESC;

SELECT 
	COUNT(*) AS items_count,
    c.name,
    SUM(p.quantity_in_stock) AS total_quantity
FROM categories c
JOIN products p ON c.id = p.category_id
GROUP BY c.name
ORDER BY items_count DESC, total_quantity
LIMIT 5;

DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*)
			FROM customers c
			JOIN orders o ON c.id = o.customer_id
			JOIN orders_products op ON o.id = op.order_id
			WHERE c.first_name = name);
END $$

SELECT udf_customer_products_count('Shirley') AS total_products;

DELIMITER $$
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
	UPDATE products p
	JOIN reviews r ON p.review_id = r.id
	JOIN categories c ON p.category_id = c.id
    SET p.price = p.price - p.price * 0.3
    WHERE r.rating < 4 AND c.name = category_name;
END $$

CALL udp_reduce_price('Phones and tablets');