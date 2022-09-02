CREATE TABLE Address_type (
    id 		    BIGINT		 	PRIMARY KEY AUTO_INCREMENT,
    type 	    VARCHAR(32) 	NOT NULL,
);
CREATE TABLE Address (
    id 		    BIGINT		 	PRIMARY KEY AUTO_INCREMENT,
    zipCode     VARCHAR(8)		NOT NULL,
    state 	    VARCHAR(32),
    city 	    VARCHAR(32) 	NOT NULL,
    street_name VARCHAR(32)		NOT NULL,
    address_type INTEGER(32) 	NOT NULL,
	number 	    VARCHAR(8)	 	NOT NULL,
	FOREIGN KEY (address) 	REFERENCES Address_type(id)
);
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
