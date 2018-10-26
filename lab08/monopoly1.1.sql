
DROP TABLE IF EXISTS SaveGame;
DROP TABLE IF EXISTS GamePieces;
DROP TABLE IF EXISTS Buildings;
DROP TABLE IF EXISTS Property CASCADE;
DROP TABLE IF EXISTS PlayerGame;
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS Player;

-- Create the schema.
CREATE TABLE Player (
	ID integer PRIMARY KEY, 
	emailAddress varchar(50) NOT NULL,
	name varchar(50)
	);

CREATE TABLE Game (
	ID integer PRIMARY KEY, 
	time timestamp,
	Finished Boolean
	);

CREATE TABLE PlayerGame (
	gameID integer REFERENCES Game(ID), 
	playerID integer REFERENCES Player(ID),
	Score integer,
	Cash integer,
	Location integer
	);
CREATE TABLE Property(
	ID integer PRIMARY KEY,
	Name varchar,
	playerID integer REFERENCES Player(ID)
	);

CREATE TABLE Buildings(
	ID  integer PRIMARY KEY,
	BuildType integer,
	PropID integer REFERENCES Property(ID)
	);

CREATE TABLE GamePieces(
	ID integer PRIMARY KEY,
	BuildID integer REFERENCES Buildings(ID)
	);

CREATE TABLE SaveGame(
	PlayerID integer REFERENCES Player(ID),
	GameID integer REFERENCES Game(ID),
	GPieceID integer REFERENCES GamePieces(ID),
	PropID integer REFERENCES Property(ID)
	);

-- Allow users to select data from the tables.
GRANT SELECT ON Game TO PUBLIC;
GRANT SELECT ON Player TO PUBLIC;
GRANT SELECT ON PlayerGame TO PUBLIC;
GRANT SELECT ON Property TO PUBLIC;
GRANT SELECT ON Buildings TO PUBLIC;
GRANT SELECT ON GamePieces TO PUBLIC;
GRANT SELECT ON SaveGame TO PUBLIC;

-- Add sample records.
INSERT INTO Game VALUES (1, '2006-06-25 08:00:00', FALSE);
INSERT INTO Game VALUES (2, '2006-06-28 13:20:00', TRUE);
INSERT INTO Game VALUES (3, '2006-06-25 18:41:00', FALSE);
INSERT INTO Game VALUES (4, '2015-06-25 08:00:00', FALSE);
INSERT INTO Game VALUES (5, '2013-06-22 13:20:00', TRUE);
INSERT INTO Game VALUES (6, '2015-06-29 14:41:00', FALSE);
INSERT INTO Game VALUES (7, '2018-10-16 10:00:00', FALSE);
INSERT INTO Game VALUES (8, '2018-10-23 13:20:00', TRUE);
INSERT INTO Game VALUES (9, '2018-10-24 23:41:00', FALSE);

INSERT INTO Player VALUES (1, 'me@calvin.edu', 'No Name');
INSERT INTO Player VALUES (2, 'king@gmail.com', 'The King');
INSERT INTO Player VALUES (3, 'dog@gmail.com', 'Dogbreath');
INSERT INTO Player VALUES (4, 'dog@gmail.com', 'Dogbreath');


INSERT INTO PlayerGame VALUES (1, 1, 0.00, 2000.00, 1);
INSERT INTO PlayerGame VALUES (1, 2, 0.00, 1.00, 12);
INSERT INTO PlayerGame VALUES (1, 3, 2350.00, 500.00);
INSERT INTO PlayerGame VALUES (2, 1, 1000.00, 1500.00, 30);
INSERT INTO PlayerGame VALUES (2, 2, 0.00, 2000.00, 12);
INSERT INTO PlayerGame VALUES (2, 3, 500.00, 150.00, 32);
INSERT INTO PlayerGame VALUES (3, 2, 0.00, 1400.00, 12);
INSERT INTO PlayerGame VALUES (3, 3, 5500.00, 300.00, 23);

INSERT INTO Property VALUES (1, 'Vermont Avenue', 2);
INSERT INTO Property VALUES (2, 'Connecticut Avenue' );
INSERT INTO Property VALUES (3, 'St. Charles Place', 3);
INSERT INTO Property VALUES (4, 'Virginia Avenue', 1);
INSERT INTO Property VALUES (5, 'St. James Place', 2);
INSERT INTO Property VALUES (6, 'Board Walk' );
INSERT INTO Property VALUES (7, 'Park Avenue', 1);
INSERT INTO Property VALUES (8, 'Marvin Gardens', 1);
INSERT INTO Property VALUES (9, 'Baltic Avenue', 3);

INSERT INTO Buildings VALUES (1, 1, 4);
INSERT INTO Buildings VALUES (2, 2, 5);
INSERT INTO Buildings VALUES (3, 2, 5);
INSERT INTO Buildings VALUES (4, 1, 4);
INSERT INTO Buildings VALUES (5, 1, 6);
INSERT INTO Buildings VALUES (6, 2, 6);
INSERT INTO Buildings VALUES (7, 2, 4);
INSERT INTO Buildings VALUES (8, 1, 4);
INSERT INTO Buildings VALUES (9, 1, 8);

INSERT INTO GamePieces VALUES (1, 1);
INSERT INTO GamePieces VALUES (2, 2);
INSERT INTO GamePieces VALUES (3, 3);
INSERT INTO GamePieces VALUES (4, 4);
INSERT INTO GamePieces VALUES (5, 5);
INSERT INTO GamePieces VALUES (6, 4);
INSERT INTO GamePieces VALUES (7, 3);
INSERT INTO GamePieces VALUES (8, 7);
INSERT INTO GamePieces VALUES (9, 2);


INSERT INTO SaveGame VALUES (1, 1, 1, 5);
INSERT INTO SaveGame VALUES (2, 2, 4, 5);
INSERT INTO SaveGame VALUES (2, 1, 1, 5);
INSERT INTO SaveGame VALUES (7, 9, 6, 7);
INSERT INTO SaveGame VALUES (9, 9, 7, 9);
INSERT INTO SaveGame VALUES (8, 9, 4, 6);

--SELECT COUNT(*) FROM PlayerGame;
--SELECT * FROM Property;