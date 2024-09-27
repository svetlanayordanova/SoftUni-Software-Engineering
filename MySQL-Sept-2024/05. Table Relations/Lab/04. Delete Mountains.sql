CREATE TABLE mountains(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);

CREATE TABLE peaks(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    mountain_id INT,
    
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
    ON DELETE CASCADE
);