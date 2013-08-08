CREATE TABLE book(
  book_id INTEGER,
  book_name VARCHAR(80) UNIQUE,
  price INTEGER NOT NULL DEFAULT 0,
  book_type CHAR(1) NOT NULL,
  insert_datetime TIMESTAMP WITH TIME ZONE NOT NULL,
  update_datetime TIMESTAMP NOT NULL,
  CONSTRAINT pk_book PRIMARY KEY(book_id)
);

COMMENT ON TABLE book IS '書籍マスタ';

COMMENT ON COLUMN book.book_id IS '書籍ID';
COMMENT ON COLUMN book.book_name IS '書名';
COMMENT ON COLUMN book.price IS '価格';
COMMENT ON COLUMN book.book_type IS '書籍種別';
COMMENT ON COLUMN book.insert_datetime IS '登録日時';
COMMENT ON COLUMN book.update_datetime IS '更新登録日時';

CREATE UNIQUE INDEX book_price ON book(price);

CREATE UNIQUE INDEX book_ui1
  ON book(book_name,book_id);
CREATE INDEX book_ni1
  ON book(price,book_id);
