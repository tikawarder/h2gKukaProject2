INSERT INTO Container_size (type) VALUES ('5m3'),('8m3'),('10m3');
INSERT INTO Waste (type) VALUES ('építési_törmelék'),('veszélyes_hulladék'),('lom'),('kevert_hulladék');
INSERT INTO Container  (size, is_booked) VALUES
	('5m3',     FALSE),
	('8m3',     FALSE),
	('10m3',    TRUE);
