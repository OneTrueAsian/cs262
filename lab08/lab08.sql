SELECT * FROM Game ORDER BY time DESC;

SELECT * FROM Game WHERE time >= date_trunc
	('week', CURRENT_TIMESTAMP - interval '1 week');

SELECT Name FROM Player WHERE Name is not NULL;

SELECT id FROM Player, PlayerGame WHERE score > 1000;

SELECT name FROM Player WHERE emailaddress LIKE '%gmail%';

SELECT name, score FROM PlayerGame, Player 
	where name like '%The King%'order by score DESC; 

SELECT name, score
	from Player, PlayerGame, Game
	WHERE Player.ID = PlayerGame.PlayerID 
	and game.ID = PlayerGame.GameID
	and time = '2006-06-28 13:20:00'
	ORDER BY score DESC
	LIMIT 1;

SELECT P1.name
FROM Player AS P1, Player AS P2
WHERE P1.name = P2.name
  AND P1.ID < P2.ID;

-- This is just prevents it from having the same player from having the same ID.

/* The only situation where you'd have to use the samel table in the same query 
is the employee example.
So if you have an Employee table may have a SupervisorID column that points to 
the employee that is the boss of the current employee.
To query the data and get information for both people in one row, you could self join
*/