--KUKA-0005 Create Customer domain

CREATE TABLE IF NOT EXISTS Customers (
    customer_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(24) NOT NULL,
    secondName VARCHAR(24) NOT NULL,
    address_id BIGINT NOT NULL,
    phoneNumber VARCHAR(24),
    email VARCHAR(50),
    FOREIGN KEY(address)
        REFERENCES Address (address_id)
);