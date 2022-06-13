drop table if exists people;

CREATE TABLE people
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    age  INT CHECK (age >= 0 AND age <= 200)
);

INSERT INTO people(name, age)
VALUES ('anna', 12);
INSERT INTO people(name, age)
VALUES ('bob', 18);
INSERT INTO people(name, age)
VALUES ('charly', 25);

SELECT *
FROM people
ORDER BY name;