CREATE TABLE book(
  book_id INTEGER,
  book_name VARCHAR(80) UNIQUE,
  price INTEGER NOT NULL DEFAULT 0,
  book_type CHAR(1) NOT NULL,
  insert_datetime TIMESTAMP WITH TIME ZONE NOT NULL,
  update_datetime TIMESTAMP NOT NULL,
  PRIMARY KEY(book_id)
);

COMMENT ON TABLE book IS '書籍マスタ';

COMMENT ON COLUMN book_id IS '書籍ID';
COMMENT ON COLUMN book_name IS '書名';
COMMENT ON COLUMN price IS '価格';
COMMENT ON COLUMN book_type IS '書籍種別';
COMMENT ON COLUMN insert_datetime IS '登録日時';
COMMENT ON COLUMN update_datetime IS '更新登録日時';

CREATE UNIQUE INDEX book_ui1
  ON book(book_name,book_id);
CREATE INDEX book_ni1
  ON book(price,book_id);
