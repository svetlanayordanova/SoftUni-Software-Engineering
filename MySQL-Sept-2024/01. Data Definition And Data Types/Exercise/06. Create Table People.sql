CREATE TABLE people (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture TEXT,
    height DOUBLE(10,2),
    weight DOUBLE(10,2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people VALUES 
(1, 'Gosho', 'TEST', 1.90, 90, 'm', '1990-01-01', '123'),  
(2, 'Teodor', 'TEST', 1.75, 72, 'm', '1992-03-25', '123'),  
(3, 'Ivelina', 'TEST', 1.65, 63.33, 'f', '1992-04-01', '123'),  
(4, 'Gergana', 'TEST', 1.45, 56, 'f', '1993-10-01', '123'),  
(5, 'Kalin', 'TEST', 1.75, 70, 'm', '1994-11-05', '123');