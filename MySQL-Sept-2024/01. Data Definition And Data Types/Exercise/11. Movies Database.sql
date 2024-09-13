CREATE TABLE directors (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE genres (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE categories (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE movies (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year DATE,
    length DOUBLE(10,2), 
    genre_id INT,
    category_id INT,
    rating DOUBLE(5,2),
    notes TEXT
);

INSERT INTO directors(director_name, notes) VALUES
('Georgi', 'Test'),
('Kalin', 'Test'),
('Viliyan', 'Test'),
('Konstantin', 'Test'),
('Sabrina', 'Test');

INSERT INTO genres(genre_name, notes) VALUES
('Thriller', 'Test'),
('Drama', 'Test'),
('Comedy', 'Test'),
('Sci-fi', 'Test'),
('Fantastica', 'Test');

INSERT INTO categories(category_name, notes) VALUES
('A', 'Test'),
('B', 'Test'),
('C', 'Test'),
('D', 'Test'),
('E', 'Test');

INSERT INTO movies VALUES
(1, 'Harry Potter', 1, '2003-12-02', 2, 3, 1, 5.2, 'Test'),
(2, 'Game of Thrones', 2, '2003-12-02', 2, 3, 1, 5.2, 'Test'),
(3, 'Castle', 3, '2003-12-02', 2, 3, 1, 5.2, 'Test'),
(4, 'Merry Poppins', 4, '2003-12-02', 2, 3, 1, 5.2, 'Test'),
(5, 'Snowflake', 5, '2003-12-02', 2, 3, 1, 5.2, 'Test');