CREATE TABLE IF NOT EXISTS Address_type(
    id 		    SERIAL PRIMARY KEY,
    type 	    VARCHAR(32) 	NOT NULL
);

CREATE TABLE IF NOT EXISTS Address(
    id 		    SERIAL          PRIMARY KEY,
    zip_code     VARCHAR(8)		NOT NULL,
    state 	    VARCHAR(32),
    city 	    VARCHAR(32) 	NOT NULL,
    street_name VARCHAR(32)		NOT NULL,
    address_type INTEGER 	NOT NULL,
	number 	    VARCHAR(8)	 	NOT NULL,
	FOREIGN KEY (address_type) 	REFERENCES Address_type(id)
);

CREATE TABLE IF NOT EXISTS Customers (
    customer_id SERIAL          PRIMARY KEY,
    first_name VARCHAR(24) NOT NULL,
    second_name VARCHAR(24) NOT NULL,
    address_id INTEGER NOT NULL,
    phone_number VARCHAR(24),
    email VARCHAR(50),
    FOREIGN KEY(address_id)
        REFERENCES Address (id)
);



CREATE TABLE IF NOT EXISTS Container(
    id 		    SERIAL          PRIMARY KEY,
    size        VARCHAR(32) 	NOT NULL
);

CREATE TABLE IF NOT EXISTS Waste(
    id          SERIAL          PRIMARY KEY,
    type        VARCHAR(32)     NOT NULL
);
