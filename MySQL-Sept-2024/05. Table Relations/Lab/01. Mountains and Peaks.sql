CREATE TABLE mountains(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE peaks(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	mountain_id INT,

CONSTRAINT fk_peaks_mountains
FOREIGN KEY (mountain_id)
REFERENCES mountains(id)
);