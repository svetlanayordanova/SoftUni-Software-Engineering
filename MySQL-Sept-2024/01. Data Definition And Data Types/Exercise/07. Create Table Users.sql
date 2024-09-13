CREATE TABLE users (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(26) NOT NULL,
    profile_picture TEXT,
    last_login_time DATETIME,
    is_deleted BOOLEAN
);

INSERT INTO users(username, password, profile_picture, last_login_time, is_deleted) VALUES
('liliya', '123456', 'TEST', '2024-09-12 08:11:23', false),
('teodora', '123456', 'TEST', '2024-09-12 08:11:23', false),
('kalin', '123456', 'TEST', '2024-09-12 08:11:23', false),
('daliya', '123456', 'TEST', '2024-09-12 08:11:23', false),
('sabrina', '123456', 'TEST', '2024-09-12 08:11:23', false);