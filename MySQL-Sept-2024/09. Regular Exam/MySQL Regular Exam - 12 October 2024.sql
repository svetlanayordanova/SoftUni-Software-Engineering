CREATE DATABASE summer_olympics;

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE sports(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE disciplines(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    sport_id INT NOT NULL,
    
    FOREIGN KEY (sport_id)
    REFERENCES sports(id)
);

CREATE TABLE athletes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    country_id INT NOT NULL,
    
    FOREIGN KEY (country_id)
    REFERENCES countries(id)
);

CREATE TABLE medals(
	id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE disciplines_athletes_medals(
	discipline_id INT NOT NULL,
    athlete_id INT NOT NULL,
    medal_id INT NOT NULL,
    
    PRIMARY KEY (discipline_id, athlete_id),
    FOREIGN KEY (discipline_id)
    REFERENCES disciplines(id),
    FOREIGN KEY (athlete_id)
    REFERENCES athletes(id),
    FOREIGN KEY (medal_id)
    REFERENCES medals(id)
);

INSERT INTO athletes(first_name, last_name, age, country_id)
SELECT
	UPPER(a.first_name),
    CONCAT(a.last_name, ' comes from ', c.name),
    a.age + a.country_id,
    a.country_id
FROM athletes a
JOIN countries c ON a.country_id = c.id
WHERE c.name LIKE 'A%';

UPDATE disciplines
SET name = REPLACE(name, 'weight', '')
WHERE name LIKE '%weight%';

DELETE FROM athletes
WHERE age > 35;

SELECT
	c.id,
    c.name
FROM countries c
LEFT JOIN athletes a ON c.id = a.country_id
WHERE a.country_id IS NULL
ORDER BY c.name DESC
LIMIT 15;

SELECT
	CONCAT(a.first_name, ' ', a.last_name) AS full_name,
    a.age
FROM athletes a
JOIN disciplines_athletes_medals dam ON a.id = dam.athlete_id
WHERE age = (SELECT MIN(age) FROM athletes) AND dam.medal_id IS NOT NULL
ORDER BY a.id
LIMIT 2;

SELECT
	a.id,
    a.first_name,
    a.last_name
FROM athletes a
LEFT JOIN disciplines_athletes_medals dam ON a.id = dam.athlete_id
WHERE dam.medal_id IS NULL
ORDER BY a.id;

SELECT
	a.id,
    a.first_name,
    a.last_name,
    COUNT(*) AS medals_count,
    s.name AS sport
FROM athletes a
JOIN disciplines_athletes_medals dam ON a.id = dam.athlete_id
JOIN disciplines d ON dam.discipline_id = d.id
JOIN sports s ON d.sport_id = s.id
GROUP BY a.id, s.name
ORDER BY medals_count DESC, a.first_name
LIMIT 10;

SELECT
	CONCAT(first_name, ' ', last_name) AS full_name,
    CASE 
		WHEN age <= 18 THEN 'Teenager'
		WHEN age <= 25 THEN 'Young adult'
		WHEN age >= 26 THEN 'Adult'
	END AS age_group
FROM athletes
ORDER BY age DESC, first_name;

DELIMITER $$
CREATE FUNCTION udf_total_medals_count_by_country(name VARCHAR(40)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*)
	FROM disciplines_athletes_medals dam
	JOIN athletes a ON dam.athlete_id = a.id
	JOIN countries c ON a.country_id = c.id
	WHERE c.name = name);
END $$

DELIMITER $$
CREATE PROCEDURE udp_first_name_to_upper_case(letter CHAR(1))
BEGIN
	UPDATE athletes
    SET first_name = UPPER(first_name) 
	WHERE first_name LIKE CONCAT('%', letter);
END $$