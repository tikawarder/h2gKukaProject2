CREATE TABLE Container (
    id 		    BIGINT		 	PRIMARY KEY AUTO_INCREMENT,
    size        VARCHAR(32) 	NOT NULL,
    is_booked   BOOLEAN         NOT NULL,
	FOREIGN KEY (size) 	        REFERENCES Container_size(id)
);
CREATE TABLE Container_size (
    id 		    BIGINT		 	PRIMARY KEY AUTO_INCREMENT,
    type 	    VARCHAR(32) 	NOT NULL
);
CREATE TABLE Waste (
    id          BIGINT          PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(32)     NOT NULL
);
