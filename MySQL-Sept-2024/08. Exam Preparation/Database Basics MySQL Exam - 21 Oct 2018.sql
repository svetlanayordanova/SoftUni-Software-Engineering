CREATE DATABASE colonial_journey_management_system_db;

CREATE TABLE planets(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE spaceports(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    planet_id INT,
    
    FOREIGN KEY (planet_id)
    REFERENCES planets(id)
);

CREATE TABLE spaceships(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(30) NOT NULL,
    light_speed_rate INT
);

CREATE TABLE journeys(
	id INT PRIMARY KEY AUTO_INCREMENT,
    journey_start DATETIME NOT NULL,
    journey_end DATETIME NOT NULL,
    purpose ENUM('Medical', 'Technical', 'Educational', 'Military') NOT NULL,
    destination_spaceport_id INT,
    spaceship_id INT,
    
    FOREIGN KEY (destination_spaceport_id)
    REFERENCES spaceports(id),
    FOREIGN KEY (spaceship_id)
    REFERENCES spaceships(id)
);

CREATE TABLE colonists(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    ucn CHAR(10) NOT NULL UNIQUE,
    birth_date DATE NOT NULL
);

CREATE TABLE travel_cards(
	id INT PRIMARY KEY AUTO_INCREMENT,
    card_number CHAR(10) NOT NULL UNIQUE,
    job_during_journey ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook') NOT NULL,
    colonist_id INT,
    journey_id INT,
    
    FOREIGN KEY (colonist_id)
    REFERENCES colonists(id),
    FOREIGN KEY (journey_id)
    REFERENCES journeys(id)
);

INSERT INTO travel_cards(card_number, job_during_journey, colonist_id, journey_id)
SELECT 
	IF (birth_date > '1980-01-01', 
		CONCAT(YEAR(birth_date), DAY(birth_date), LEFT(ucn, 4)), 
		CONCAT(YEAR(birth_date), MONTH(birth_date), RIGHT(ucn, 4))),
	CASE
		WHEN id % 2 = 0 THEN 'Pilot'
		WHEN id % 3 = 0 THEN 'Cook'
        ELSE 'Engineer'
	END,
    id,
    LEFT(ucn, 1)
FROM colonists
WHERE id BETWEEN 96 AND 100; 

UPDATE journeys
SET purpose = CASE 
				WHEN id % 2 = 0 THEN 'Medical'
				WHEN id % 3 = 0 THEN 'Technical'
                WHEN id % 5 = 0 THEN 'Educational'
                WHEN id % 7 = 0 THEN 'Military'
                ELSE purpose
			  END;

DELETE c
FROM colonists c
LEFT JOIN travel_cards tc ON c.id = tc.colonist_id
WHERE tc.journey_id IS NULL; 

SELECT
	card_number,
    job_during_journey
FROM travel_cards
ORDER BY card_number;

SELECT
	id,
    CONCAT(first_name, ' ', last_name) AS full_name,
    ucn
FROM colonists
ORDER BY first_name, last_name, id;

SELECT
	id,
    journey_start,
    journey_end
FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start;

SELECT
	c.id,
    CONCAT(c.first_name, ' ', c.last_name) AS full_name
FROM colonists c
JOIN travel_cards tc ON c.id = tc.colonist_id
WHERE tc.job_during_journey = 'Pilot'
ORDER BY c.id; 

SELECT COUNT(*) AS count
FROM colonists c
JOIN travel_cards tc ON c.id = tc.colonist_id
JOIN journeys j ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';

SELECT
	s.name AS spaceship_name,
    sp.name AS spaceport_name
FROM spaceships s
JOIN journeys j ON s.id = j.spaceship_id
JOIN spaceports sp ON j.destination_spaceport_id = sp.id
WHERE s.light_speed_rate = (SELECT MAX(light_speed_rate) FROM spaceships);

SELECT
	s.name,
    s.manufacturer
FROM spaceships s
JOIN journeys j ON s.id = j.spaceship_id
JOIN travel_cards tc ON j.id = tc.journey_id
JOIN colonists c ON tc.colonist_id = c.id
WHERE tc.job_during_journey = 'Pilot' AND TIMESTAMPDIFF(YEAR, c.birth_date, '2019-01-01') < 30
ORDER BY s.name;

SELECT
	p.name AS planet_name,
    s.name AS spaceport_name
FROM planets p
JOIN spaceports s ON p.id = s.planet_id
JOIN journeys j ON s.id = j.destination_spaceport_id
WHERE j.purpose = 'Educational'
ORDER BY spaceport_name DESC;

SELECT
	p.name AS planet_name,
    COUNT(*) AS journeys_count
FROM planets p
JOIN spaceports s ON p.id = s.planet_id
JOIN journeys j ON s.id = j.destination_spaceport_id
GROUP BY p.name
ORDER BY journeys_count DESC, planet_name;

SELECT
	j.id,
    p.name AS planet_name,
    s.name AS spaceport_name,
    j.purpose AS journey_purpose
FROM journeys j
JOIN spaceports s ON j.destination_spaceport_id = s.id
JOIN planets p ON s.planet_id = p.id
WHERE DATEDIFF(j.journey_end, j.journey_start) = (SELECT MIN(DATEDIFF(journey_end, journey_start)) FROM journeys);

SELECT
	tc.job_during_journey AS job_name
FROM colonists c
JOIN travel_cards tc ON c.id = tc.colonist_id
JOIN journeys j ON tc.journey_id = j.id
WHERE DATEDIFF(j.journey_end, j.journey_start) = (SELECT MAX(DATEDIFF(journey_end, journey_start)) FROM journeys)
GROUP BY job_name
ORDER BY COUNT(*)
LIMIT 1;

DELIMITER $$
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*)
			FROM planets p
			JOIN spaceports s ON p.id = s.planet_id
			JOIN journeys j ON s.id = j.destination_spaceport_id
			JOIN travel_cards tc ON j.id = tc.journey_id
			WHERE p.name = planet_name);
END $$

SELECT udf_count_colonists_by_destination_planet('Otroyphus') AS count;

DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
BEGIN
	DECLARE spaceship_exists VARCHAR(50);
    SET spaceship_exists := (SELECT name FROM spaceships
							 WHERE name = spaceship_name);
    
	START TRANSACTION;
    
    UPDATE spaceships
    SET light_speed_rate = light_speed_rate + light_speed_rate_increse
    WHERE name = spaceship_name;
    
    IF (spaceship_exists IS NULL) THEN
		ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exist.';
	ELSE
		COMMIT;
	END IF;
END $$

CALL udp_modify_spaceship_light_speed_rate('Na Pesho koraba', 1914);
CALL udp_modify_spaceship_light_speed_rate('USS Templar', 5);