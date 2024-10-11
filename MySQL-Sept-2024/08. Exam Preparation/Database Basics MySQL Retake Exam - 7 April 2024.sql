CREATE DATABASE go_roadie;

CREATE TABLE cities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cars(
	id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE driving_schools(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    night_time_driving TINYINT(1) NOT NULL,
    average_lesson_price DECIMAL(10,2),
    car_id INT NOT NULL,
    city_id INT NOT NULL,
    
    FOREIGN KEY (car_id)
    REFERENCES cars(id),
    FOREIGN KEY (city_id)
    REFERENCES cities(id)
);

CREATE TABLE instructors(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    has_a_license_from DATE NOT NULL
);

CREATE TABLE instructors_driving_schools(
	instructor_id INT,
    driving_school_id INT NOT NULL,
    
    KEY (instructor_id, driving_school_id),
    FOREIGN KEY (instructor_id)
    REFERENCES instructors(id),
    FOREIGN KEY (driving_school_id)
    REFERENCES driving_schools(id)
);

CREATE TABLE students(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    age INT,
    phone_number VARCHAR(20) UNIQUE
);

CREATE TABLE instructors_students(
	instructor_id INT NOT NULL,
    student_id INT NOT NULL,
    
    KEY (instructor_id, student_id),
    FOREIGN KEY (instructor_id)
    REFERENCES instructors(id),
    FOREIGN KEY (student_id)
    REFERENCES students(id)
);

INSERT INTO students(first_name, last_name, age, phone_number)
SELECT 
	REVERSE(LOWER(first_name)),
    REVERSE(LOWER(last_name)),
	age + LEFT(phone_number, 1),
	CONCAT('1+', phone_number)
FROM students
WHERE age < 20;

UPDATE driving_schools ds
JOIN cities c ON ds.city_id = c.id
SET average_lesson_price = average_lesson_price + 30
WHERE c.name = 'London' AND ds.night_time_driving = 1;

SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM driving_schools
WHERE night_time_driving = 0;

SELECT 
	CONCAT(first_name, ' ', last_name) AS full_name,
    age
FROM students
WHERE first_name LIKE '%a%' AND age = (SELECT MIN(age) FROM students)
ORDER BY id;

SELECT 
	ds.id,
    ds.name,
    c.brand
FROM driving_schools ds
JOIN cars c ON ds.car_id = c.id
LEFT JOIN instructors_driving_schools ids ON ds.id = ids.driving_school_id
WHERE ids.instructor_id IS NULL
ORDER BY c.brand, ds.id
LIMIT 5;

SELECT 
	i.first_name,
    i.last_name, 
    COUNT(*) AS students_count,
    c.name
FROM instructors i
JOIN instructors_students ins ON i.id = ins.instructor_id
JOIN instructors_driving_schools ids ON i.id = ids.instructor_id
JOIN driving_schools ds ON ids.driving_school_id = ds.id
JOIN cities c ON ds.city_id = c.id
GROUP BY i.first_name, i.last_name, c.name
HAVING students_count > 1
ORDER BY students_count DESC, i.first_name;

SELECT 
	c.name,
    COUNT(*) AS instructors_count
FROM cities c
JOIN driving_schools ds ON c.id = ds.city_id
JOIN instructors_driving_schools ids ON ds.id = ids.driving_school_id
GROUP BY c.name
ORDER BY instructors_count DESC;

SELECT 
	CONCAT(first_name, ' ', last_name) AS full_name,
    CASE
		WHEN YEAR(has_a_license_from) BETWEEN 1980 AND 1989 THEN 'Specialist'
        WHEN YEAR(has_a_license_from) BETWEEN 1990 AND 1999 THEN 'Advanced'
        WHEN YEAR(has_a_license_from) BETWEEN 2000 AND 2007 THEN 'Experienced'
        WHEN YEAR(has_a_license_from) BETWEEN 2008 AND 2014 THEN 'Qualified'
        WHEN YEAR(has_a_license_from) BETWEEN 2015 AND 2019 THEN 'Provisional'
        WHEN YEAR(has_a_license_from) >= 2020 THEN 'Trainee'
	END AS level
FROM instructors
ORDER BY YEAR(has_a_license_from), first_name;

DELIMITER $$
CREATE FUNCTION udf_average_lesson_price_by_city(name VARCHAR(40))
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
	RETURN (SELECT AVG(ds.average_lesson_price)
			FROM driving_schools ds
			JOIN cities c ON ds.city_id = c.id
			WHERE c.name = name);
END $$

SELECT udf_average_lesson_price_by_city('London') AS average_lesson_price;

DELIMITER $$
CREATE PROCEDURE udp_find_school_by_car(brand VARCHAR(20))
BEGIN
	SELECT 
		ds.name,
		ds.average_lesson_price
	FROM driving_schools ds
	JOIN cars c ON ds.car_id = c.id
	WHERE c.brand = brand
	ORDER BY ds.average_lesson_price DESC;
END $$

CALL udp_find_school_by_car('Mercedes-Benz');