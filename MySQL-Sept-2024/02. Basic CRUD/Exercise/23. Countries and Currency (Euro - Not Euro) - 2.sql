ALTER TABLE countries
ADD COLUMN currency VARCHAR(10);

UPDATE countries
SET currency = 'Euro'
WHERE currency_code = 'EUR';

UPDATE countries
SET currency = 'Not Euro'
WHERE NOT currency_code = 'EUR';

SELECT country_name, country_code, currency
FROM countries
ORDER BY country_name;