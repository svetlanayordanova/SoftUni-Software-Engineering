CREATE TABLE categories (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(50),
    daily_rate DOUBLE(5,2),
    weekly_rate DOUBLE(5,2),
    monthly_rate DOUBLE(5,2),
    weekend_rate DOUBLE(5,2)
);

CREATE TABLE cars (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(10),
    make VARCHAR(50),
    model VARCHAR(50),
    car_year DATE,
    category_id INT,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(50),
    available BOOLEAN
);
  
CREATE TABLE employees (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    title VARCHAR(50),
    notes TEXT
);

CREATE TABLE customers (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT,
    full_name VARCHAR(100),
    address VARCHAR(150),
    city VARCHAR(50),
    zip_code INT,
    notes TEXT
);

CREATE TABLE rental_orders (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition VARCHAR(50),
	tank_level DOUBLE(5,2),
    kilometrage_start INT,
	kilometrage_end INT,
    total_kilometrage INT,
    start_date DATE,
    end_date DATE,
    total_days INT,
	rate_applied DOUBLE(5,2),
    tax_rate DOUBLE(5,2),
    order_status VARCHAR(50),
    notes TEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
('SUV', 5.2, 10, 40.5, 10.2),
('Jeep', 5.2, 10, 40.5, 10.2),
('Motorcycle', 5.2, 10, 40.5, 10.2);

INSERT INTO cars(plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) VALUES
('A1', 'Audi', 'TT', '2021-12-12', 1, 4, NULL, 'brand new', true), 
('A1', 'BMW', 'X6', '2021-12-12', 1, 4, NULL, 'brand new', true), 
('A1', 'Audi', 'RS7', '2021-12-12', 1, 4, NULL, 'brand new', true);

INSERT INTO employees(first_name, last_name, title, notes) VALUES
('Gergana', 'Yordanova', 'Teacher', 'TEST'),
('Ivan', 'Stoyanov', 'Teacher', 'TEST'),
('Liliya', 'Georgieva', 'Teacher', 'TEST');

INSERT INTO customers(driver_licence_number, full_name, address, city, zip_code, notes) VALUES
(123, 'Silviya Stiliyanova', 'Mladost', 'Sofia', '1712', 'TEST'), 
(345, 'Ivan Angelov', 'Mladost', 'Sofia', '1712', 'TEST'), 
(567, 'Darina Ivanova', 'Mladost', 'Sofia', '1712', 'TEST');

INSERT INTO rental_orders(employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) VALUES
(1, 1, 1, 'brand new', 5.2, 10000, 30000, 40000, '2024-09-12', '2024-09-21', 9, 5.2, 2.62, 'active', 'TEST'),
(2, 2, 2, 'brand new', 5.2, 10000, 30000, 40000, '2024-09-12', '2024-09-21', 9, 5.2, 2.62, 'active', 'TEST'),
(3, 3, 3, 'brand new', 5.2, 10000, 30000, 40000, '2024-09-12', '2024-09-21', 9, 5.2, 2.62, 'active', 'TEST');