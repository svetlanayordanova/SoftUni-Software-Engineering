CREATE DATABASE ruk_database;

CREATE TABLE branches(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE employees(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    started_on DATE NOT NULL,
    branch_id INT NOT NULL,

    CONSTRAINT fk_employees_branches
        FOREIGN KEY (branch_id)
            REFERENCES branches(id)
);

CREATE TABLE clients(
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE employees_clients(
    employee_id INT,
    client_id INT,

    CONSTRAINT fk_employees_clients_employees
        FOREIGN KEY (employee_id)
            REFERENCES employees(id),

    CONSTRAINT fk_employees_clients_clients
        FOREIGN KEY (client_id)
            REFERENCES clients(id)
);

CREATE TABLE bank_accounts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(10) NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    client_id INT NOT NULL UNIQUE,

    CONSTRAINT fk_bank_accounts_clients
        FOREIGN KEY (client_id)
            REFERENCES clients(id)
);

CREATE TABLE cards(
    id INT PRIMARY KEY AUTO_INCREMENT,
    card_number VARCHAR(19) NOT NULL,
    card_status VARCHAR(7) NOT NULL,
    bank_account_id INT NOT NULL,

    CONSTRAINT fk_cards_bank_accounts
        FOREIGN KEY (bank_account_id)
            REFERENCES bank_accounts(id)
);

INSERT INTO cards(card_number, card_status, bank_account_id)
SELECT
	REVERSE(full_name),
    'Active',
    id
FROM clients
WHERE id BETWEEN 191 AND 200;

UPDATE employees_clients
SET employee_id = 10
WHERE employee_id = client_id;

DELETE e
FROM employees e
LEFT JOIN employees_clients ec ON e.id = ec.employee_id
WHERE ec.client_id IS NULL;

SELECT id, full_name
FROM clients
ORDER BY id;

SELECT
	id,
    CONCAT(first_name, ' ', last_name) AS full_name,
    CONCAT('$', salary) AS salary,
    started_on
FROM employees
WHERE salary >= 100000 AND started_on >= '2018-01-01'
ORDER BY salary DESC, id;

SELECT
	cd.id,
    CONCAT(cd.card_number, ' : ', c.full_name) AS card_token 
FROM cards cd
JOIN bank_accounts ba ON cd.bank_account_id = ba.id
JOIN clients c ON ba.client_id = c.id
ORDER BY cd.id DESC;

SELECT
	CONCAT(e.first_name, ' ', e.last_name) AS full_name,
    e.started_on,
    COUNT(*) AS count_of_clients
FROM employees e
JOIN employees_clients ec ON e.id = ec.employee_id
GROUP BY e.id
ORDER BY count_of_clients DESC, id
LIMIT 5;

SELECT
	b.name,
    COUNT(cd.id) AS count_of_cards
FROM branches b
LEFT JOIN employees e ON b.id = e.branch_id
LEFT JOIN employees_clients ec ON e.id = ec.employee_id
LEFT JOIN clients c ON ec.client_id = c.id
LEFT JOIN bank_accounts ba ON c.id = ba.client_id
LEFT JOIN cards cd ON ba.id = cd.bank_account_id
GROUP BY b.id
ORDER BY count_of_cards DESC, b.name;

DELIMITER $$
CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) 
			FROM clients c
			JOIN bank_accounts ba ON c.id = ba.client_id
			JOIN cards cd ON ba.id = cd.bank_account_id
			WHERE c.full_name = name
			GROUP BY c.id);
END $$

SELECT udf_client_cards_count('Baxy David') AS cards;

DELIMITER $$
CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(50))
BEGIN
	SELECT
		c.full_name,
        c.age,
        ba.account_number,
        CONCAT('$', ba.balance) AS balance
    FROM clients c
    JOIN bank_accounts ba ON c.id = ba.client_id
    WHERE c.full_name = full_name;
END $$

CALL udp_clientinfo('Hunter Wesgate');