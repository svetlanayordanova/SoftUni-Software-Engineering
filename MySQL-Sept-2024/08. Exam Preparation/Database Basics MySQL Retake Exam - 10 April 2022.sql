CREATE DATABASE softuni_imdb;

CREATE TABLE movies_additional_info(
	id INT PRIMARY KEY AUTO_INCREMENT,
    rating DECIMAL(10,2) NOT NULL,
    runtime INT NOT NULL,
    picture_url VARCHAR(80) NOT NULL,
    budget DECIMAL(10,2),
    release_date DATE NOT NULL,
    has_subtitles TINYINT(1),
    description TEXT
);

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    continent VARCHAR(30) NOT NULL,
    currency VARCHAR(5) NOT NULL
);

CREATE TABLE actors(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    height INT,
    awards INT,
    country_id INT NOT NULL,
    
    FOREIGN KEY (country_id)
    REFERENCES countries(id)
);

CREATE TABLE movies(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(70) NOT NULL UNIQUE,
    country_id INT NOT NULL,
    movie_info_id INT NOT NULL UNIQUE,
    
    FOREIGN KEY (country_id)
    REFERENCES countries(id),
    FOREIGN KEY (movie_info_id)
    REFERENCES movies_additional_info(id)    
);

CREATE TABLE movies_actors(
	movie_id INT,
    actor_id INT,
    
    KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id)
    REFERENCES movies(id),
    FOREIGN KEY (actor_id)
    REFERENCES actors(id)
);

CREATE TABLE genres(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE genres_movies(
	genre_id INT,
    movie_id INT,
    
    KEY (genre_id, movie_id),
    FOREIGN KEY (genre_id)
    REFERENCES genres(id),
    FOREIGN KEY (movie_id)
    REFERENCES movies(id)
);

INSERT INTO actors(first_name, last_name, birthdate, height, awards, country_id)
SELECT
	REVERSE(first_name),
    REVERSE(last_name),
    DATE_SUB(birthdate, INTERVAL 2 DAY),
    height + 10,
    country_id,
    (SELECT id FROM countries WHERE name = 'Armenia')
FROM actors
WHERE id <= 10;

UPDATE movies_additional_info
SET runtime = runtime - 10
WHERE id BETWEEN 15 AND 25;

DELETE c
FROM countries c
LEFT JOIN movies m ON c.id = m.country_id
WHERE m.id IS NULL;

SELECT * FROM countries
ORDER BY currency DESC, id;

SELECT
	ma.id,
    m.title,
    ma.runtime,
    ma.budget,
    ma.release_date
FROM movies_additional_info ma
JOIN movies m ON ma.id = m.movie_info_id
WHERE YEAR(ma.release_date) BETWEEN 1996 AND 1999
ORDER BY runtime, id
LIMIT 20;

SELECT 
	CONCAT(first_name, ' ', last_name) AS full_name,
    CONCAT(REVERSE(last_name), LENGTH(last_name), '@cast.com') AS email,
    2022 - YEAR(birthdate) AS age,
    height
FROM actors a
LEFT JOIN movies_actors ma ON a.id = ma.actor_id
WHERE ma.movie_id IS NULL
ORDER BY height;

SELECT
	c.name,
    COUNT(*) AS movies_count
FROM countries c
JOIN movies m ON c.id = m.country_id
GROUP BY c.name
HAVING movies_count >= 7
ORDER BY c.name DESC;

SELECT
	m.title,
    CASE
		WHEN ma.rating <= 4 THEN 'poor'
		WHEN ma.rating <= 7 THEN 'good'
		WHEN ma.rating > 7 THEN 'excellent'
	END AS rating,
    CASE 
		WHEN ma.has_subtitles = 1 THEN 'english'
		WHEN ma.has_subtitles = 0 THEN '-'
	END AS subtitles,
    ma.budget
FROM movies m
JOIN movies_additional_info ma ON m.movie_info_id = ma.id
ORDER BY budget DESC;

DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) FROM movies m
			JOIN genres_movies gm ON m.id = gm.movie_id
			JOIN genres g ON gm.genre_id = g.id
			JOIN movies_actors ma ON m.id = ma.movie_id
			JOIN actors a ON ma.actor_id = a.id
			WHERE g.name = 'History' AND 
				  CONCAT(a.first_name, ' ', a.last_name) = full_name);
END $$

SELECT udf_actor_history_movies_count('Stephan Lundberg') AS history_movies;
SELECT udf_actor_history_movies_count('Jared Di Batista') AS history_movies;

DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN
	UPDATE actors a
	JOIN movies_actors ma ON a.id = ma.actor_id
	JOIN movies m ON ma.movie_id = m.id
	SET awards = awards + 1
	WHERE m.title = movie_title;
END $$

CALL udp_award_movie('Tea For Two');