DROP TABLE IF EXISTS users, books, tags, Authors, BooksAuthors, MarkedToRead, tags_books, bookstagstemp;
CREATE TABLE users
(
  id serial NOT NULL,
  --firstname VARCHAR(40),
  --lastname VARCHAR(40),
  --email TEXT,
  --passwd TEXT,
  PRIMARY KEY (id)
);

CREATE TABLE userstemp
(
  id INTEGER,
  skip1 INTEGER,
  skip2 INTEGER
);

\COPY userstemp(id,skip1,skip2) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\ratings.csv' DELIMITER ',' CSV HEADER;

INSERT INTO users (id) SELECT DISTINCT ON (userstemp.id) id FROM userstemp ORDER BY id;
DROP TABLE userstemp;

CREATE TABLE books
(
  id serial NOT NULL,
  goodreadsbookid INTEGER UNIQUE,
  isbn TEXT,
  originalpublicationyear VARCHAR(7),
  originaltitle TEXT,
  internationaltitle TEXT,
  languagecode VARCHAR(5),
  averagerating DECIMAL,
  ratingscount INTEGER,
  imageurl TEXT,
  smallimageurl TEXT,
  PRIMARY KEY (id)
);

CREATE TABLE bookstemp
(
  id INTEGER,
  goodreadsbookid INTEGER,
  bestbookid INTEGER,
  workid INTEGER,
  bookscount INTEGER,
  isbn TEXT,
  isbn13 TEXT,
  authors TEXT,
  originalpublicationyear VARCHAR(7),
  originaltitle TEXT,
  internationaltitle TEXT,
  languagecode VARCHAR(5),
  averagerating DECIMAL,
  ratingscount INTEGER,
  workratingscount INTEGER,
  worktextreviewscount INTEGER,
  ratings1 INTEGER,
  ratings2 INTEGER,
  ratings3 INTEGER,
  ratings4 INTEGER,
  ratings5 INTEGER,
  imageurl TEXT,
  smallimageurl TEXT
);

\COPY bookstemp(id,goodreadsbookid,bestbookid,workid,bookscount,isbn,isbn13,authors,originalpublicationyear,originaltitle,internationaltitle,languagecode,averagerating,ratingscount,workratingscount,worktextreviewscount,ratings1,ratings2,ratings3,ratings4,ratings5,imageurl,smallimageurl) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\books.csv' DELIMITER ',' CSV HEADER;

INSERT INTO books (id, goodreadsbookid, isbn, originalpublicationyear, originaltitle, internationaltitle, languagecode, averagerating, ratingscount, imageurl, smallimageurl)
SELECT DISTINCT ON (bookstemp.id) id, goodreadsbookid, isbn, originalpublicationyear, originaltitle, internationaltitle, languagecode, averagerating, ratingscount, imageurl, smallimageurl FROM bookstemp ORDER BY id;
DROP TABLE bookstemp;

CREATE TABLE tags(
  id serial NOT NULL,
  tagname TEXT,
  PRIMARY KEY (id)
);

CREATE TABLE tagstemp(
  id INTEGER ,
  tagname TEXT
);

\COPY tagstemp(id, tagname) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\tags.csv' DELIMITER ',' CSV HEADER;

INSERT INTO tags (id, tagname) SELECT DISTINCT ON (tagstemp.id) id, tagname FROM tagstemp ORDER BY id ON CONFLICT DO NOTHING;
DROP TABLE tagstemp;




CREATE TABLE tags_books(
  book_id INTEGER REFERENCES books(id) ON DELETE CASCADE, 
  tag_id INTEGER REFERENCES tags(id) ON DELETE CASCADE,
  counter INTEGER,
  PRIMARY KEY (book_id, tag_id));

CREATE TABLE bookstagstemp(
 book_id INTEGER,
 tag_id INTEGER,
 counter INTEGER
);

\COPY bookstagstemp(book_id, tag_id, counter) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\book_tags.csv' DELIMITER ',' CSV HEADER;

INSERT INTO tags_books SELECT DISTINCT ON (bookstagstemp.book_id, bookstagstemp.tag_id, bookstagstemp.counter) * FROM bookstagstemp ON CONFLICT DO UPSERT;
DROP TABLE BooksTagsTemp;

CREATE TABLE ratings(
  user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
  book_id INTEGER REFERENCES books(id) ON DELETE CASCADE,
  rating INTEGER,
  PRIMARY KEY (book_id, user_id)
);

CREATE TABLE usersratingstemp(
 user_id INTEGER,
 book_id INTEGER,
 rating INTEGER
);

\COPY usersratingstemp(user_id, book_id, rating) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\ratings.csv' DELIMITER ',' CSV HEADER;

INSERT INTO ratings SELECT DISTINCT ON (usersratingstemp.user_id, usersratingstemp.book_id) * FROM usersratingstemp;
DROP TABLE usersratingstemp;
/*
CREATE TABLE markedtoread(
  user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
  book_id INTEGER REFERENCES books(id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, book_id)
);

\COPY markedtoread(user_id, book_id) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\to_read.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE authors(
  id serial NOT NULL,
  fullname TEXT,
  PRIMARY KEY (id));

\COPY authors(fullname) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\author.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE authors_books(
author_id INTEGER NOT NULL REFERENCES authors(id) ON DELETE CASCADE,
book_id INTEGER NOT NULL REFERENCES books(id) ON DELETE CASCADE,
PRIMARY KEY (author_id, book_id)
);

\COPY authors_books(book_id, author_id) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\booksauthors.csv' DELIMITER ',' CSV HEADER;
*/