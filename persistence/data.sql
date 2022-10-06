INSERT INTO Address_type (type)
VALUES  ('utca'),('tér'),('út'),('köz'),('dűlő');

INSERT INTO Address  (zip_code, city, street_name, address_type, number)
VALUES  ('1231',		'Alsómocsolád',		'Fabatka',  '1',	'23'),
	    ('H-9231',	    'Homokbödöge',		'Kalapács', '5',	'13-16'),
	    ('4532',		'Vindornyalak',		'Fúró',     '2',	'13/b');

INSERT INTO customers(first_name,second_name,address_id,phone_number,email)
VALUES  ('Adigolyo','Toth','1','+40758987866','kecske@macska.com');

INSERT INTO Container_size (type)
VALUES  ('5m3'),('8m3'),('10m3');

INSERT INTO Waste (type)
VALUES  ('építési_törmelék'),('veszélyes_hulladék'),('lom'),('kevert_hulladék');

INSERT INTO Container  (size)
VALUES  ('5m3'),
	    ('8m3'),
	    ('10m3');
