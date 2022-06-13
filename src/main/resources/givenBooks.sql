drop table if exists given_book;

CREATE TABLE given_book
(
    book_id   INT REFERENCES book (id) ON DELETE CASCADE UNIQUE,
    people_id INT REFERENCES people (id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, people_id)

);

INSERT INTO given_book(book_id, people_id) VALUES (1,1);
INSERT INTO given_book(book_id, people_id) VALUES (2,1);
INSERT INTO given_book(book_id, people_id) VALUES (3,3);

SELECT * FROM given_book;