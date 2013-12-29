CREATE TABLE author(
  author_id INTEGER NOT NULL,
  author_name VARCHAR(80),
  CONSTRAINT pk_author PRIMARY KEY(author_id)
);

COMMENT ON TABLE author IS '著者';

COMMENT ON COLUMN author.author_id IS '著者ID';
COMMENT ON COLUMN author.author_name IS '著者名';


