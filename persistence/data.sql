INSERT INTO Address_type (type) VALUES ('utca'),('tér'),('út'),('köz'),('dűlő');
INSERT INTO Customers(firstName,secondName,address,phone,email) VALUES
    ("Adigolyo","Toth","1","+40758987866","kecske@macska.com");
INSERT INTO Address  (zipCode, city, street_name, address_type, number) VALUES
	('1231',		'Alsómocsolád',		'Fabatka',  'utca',	'23'),
	('H-9231',	    'Homokbödöge',		'Kalapács', 'dűlő',	'13-16'),
	('4532',		'Vindornyalak',		'Fúró',     'tér',	'13/b');
INSERT INTO Container_size (type) VALUES ('5m3'),('8m3'),('10m3');
INSERT INTO Waste (type) VALUES ('építési_törmelék'),('veszélyes_hulladék'),('lom'),('kevert_hulladék');
INSERT INTO Container  (size) VALUES
	('5m3'),
	('8m3'),
	('10m3');
