DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS userSeqGen;

CREATE SEQUENCE userSeqGen START WITH 10 INCREMENT BY 1;
CREATE TABLE users
(
    user_id       INT PRIMARY KEY,
    first_name     VARCHAR(50) NOT NULL,
    middle_initial CHAR(1) DEFAULT NULL,
    last_name      VARCHAR(50) NOT NULL,
    city          VARCHAR(150),
    state         VARCHAR(150),
    zip_code       VARCHAR(150),
    phone_number   VARCHAR(20)
);
INSERT INTO users(user_id, first_name, middle_initial, last_name, city, state, zip_code, phone_number)
values (1, 'Kevin', 'K', 'Doe', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (2, 'John', 'J', 'DoeJ', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (3, 'Laura', 'L', 'DoeL', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (4, 'Arnold', 'A', 'DoeA', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (5, 'Taulok', 'T', 'DoeT', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (6, 'Joe', 'J', 'DoeJ', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (7, 'Keyban', 'K', 'DoeK', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (8, 'Frank', 'F', 'DoeF', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (9, 'Armand', 'A', 'DoeA', 'Minneapolis', 'MN', '55414', '934-675-43-23'),
       (10,'Dania', 'A', 'DCAT', 'Minneapolis', 'MN', '55414', '934-675-43-23');

