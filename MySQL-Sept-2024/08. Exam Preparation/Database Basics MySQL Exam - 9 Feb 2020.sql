CREATE DATABASE fsd;

CREATE TABLE coaches(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(10) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
    salary DECIMAL(10,2) NOT NULL DEFAULT 0,
    coach_level INT NOT NULL
);

CREATE TABLE skills_data(
	id INT PRIMARY KEY AUTO_INCREMENT,
    dribbling INT,
    pace INT,
    passing INT,
    shooting INT,
    speed INT,
    strength INT
);

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE towns(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    country_id INT NOT NULL,
    
    FOREIGN KEY (country_id)
    REFERENCES countries(id)
);

CREATE TABLE stadiums(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    capacity INT NOT NULL,
    town_id INT NOT NULL,
    
    FOREIGN KEY (town_id)
    REFERENCES towns(id)
);

CREATE TABLE teams(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    established DATE NOT NULL,
    fan_base BIGINT NOT NULL,
    stadium_id INT NOT NULL,
    
    FOREIGN KEY (stadium_id)
    REFERENCES stadiums(id)
);

CREATE TABLE players(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(10) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    position CHAR(1) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    hire_date DATETIME,
    skills_data_id INT NOT NULL,
    team_id INT,
    
    FOREIGN KEY (skills_data_id)
    REFERENCES skills_data(id),
    FOREIGN KEY (team_id)
    REFERENCES teams(id)
);

CREATE TABLE players_coaches(
	player_id INT,
    coach_id INT,
    
    PRIMARY KEY (player_id, coach_id),
    FOREIGN KEY (player_id)
    REFERENCES players(id),
    FOREIGN KEY (coach_id)
    REFERENCES coaches(id)
);

INSERT INTO coaches(first_name, last_name, salary, coach_level)
SELECT
	first_name,
    last_name,
    salary * 2,
    LENGTH(first_name)
FROM players
WHERE age >= 45;

SELECT COUNT(*)
		FROM coaches c
		JOIN players_coaches pc ON c.id = pc.coach_id
		GROUP BY c.id;
        
UPDATE coaches c
JOIN players_coaches pc ON c.id = pc.coach_id
SET c.coach_level = c.coach_level + 1
WHERE LEFT(c.first_name, 1) = 'A';

SET SQL_SAFE_UPDATES = 0;
DELETE FROM players
WHERE age >= 45;

SELECT 
	first_name,
    age,
    salary
FROM players
ORDER BY salary DESC;

SELECT
	p.id,
	CONCAT(p.first_name, ' ', p.last_name) AS full_name,
    p.age,
    p.position,
    p.hire_date
FROM players p
JOIN skills_data sd ON p.skills_data_id = sd.id
WHERE p.age < 23 AND p.position = 'A' AND p.hire_date IS NULL AND sd.strength > 50
ORDER BY p.salary, p.age;

SELECT
	t.name AS team_name,
    t.established,
    t.fan_base,
    COUNT(p.id) AS players_count
FROM teams t
LEFT JOIN players p ON t.id = p.team_id
GROUP BY t.id
ORDER BY players_count DESC, t.fan_base DESC;

SELECT
	MAX(sd.speed) AS max_speed,
    t.name AS town_name
FROM towns t
LEFT JOIN stadiums s ON t.id = s.town_id
LEFT JOIN teams tm ON s.id = tm.stadium_id
LEFT JOIN players p ON tm.id = p.team_id
LEFT JOIN skills_data sd ON sd.id = p.skills_data_id
WHERE tm.name != 'Devify'
GROUP BY t.name
ORDER BY max_speed DESC, town_name;

SELECT 
	c.name,
    COUNT(p.id) AS total_count_of_players,
    SUM(p.salary) AS total_sum_of_salaries
FROM countries c
LEFT JOIN towns t ON c.id = t.country_id
LEFT JOIN stadiums s ON t.id = s.town_id
LEFT JOIN teams tm ON s.id = tm.stadium_id
LEFT JOIN players p ON tm.id = p.team_id
GROUP BY c.name
ORDER BY total_count_of_players DESC, c.name;

DELIMITER $$
CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(p.id) 
			FROM stadiums s
			JOIN teams t ON s.id = t.stadium_id
			JOIN players p ON t.id = p.team_id
			WHERE s.name = stadium_name);
END $$

SELECT udf_stadium_players_count('Jaxworks') AS count; 
SELECT udf_stadium_players_count('Linklinks') AS count; 

DELIMITER $$
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
	SELECT
		CONCAT(p.first_name, ' ', p.last_name) AS full_name,
		p.age,
		p.salary,
		sd.dribbling,
		sd.speed,
		t.name AS team_name
	FROM players p
	JOIN skills_data sd ON p.skills_data_id = sd.id
	JOIN teams t ON p.team_id = t.id
	WHERE sd.dribbling > min_dribble_points AND t.name = team_name
	ORDER BY sd.speed DESC
	LIMIT 1;
END $$

CALL udp_find_playmaker(20, 'Skyble');