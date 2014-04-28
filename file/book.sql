CREATE TABLE book(
  book_id INTEGER NOT NULL,
  book_name VARCHAR(80) UNIQUE NOT NULL,
  price INTEGER DEFAULT 0,
  uriage BIGINT,
  book_type CHAR(1),
  want_flag NUMERIC(1),
  length9 NUMERIC(9),
  length10 NUMERIC(10),
  numeric41 NUMERIC(4,1),
  insert_datetime TIMESTAMP WITH TIME ZONE,
  update_datetime TIMESTAMP,
  CONSTRAINT pk_book PRIMARY KEY(book_id)
);

COMMENT ON TABLE book IS '書籍マスタ';

COMMENT ON COLUMN book.book_id IS '書籍ID';
COMMENT ON COLUMN book.book_name IS '書名';
COMMENT ON COLUMN book.price IS '価格';
COMMENT ON COLUMN book.uriage IS '売上';
COMMENT ON COLUMN book.book_type IS '書籍種別';
COMMENT ON COLUMN book.want_flag IS '購入予定フラグ';
COMMENT ON COLUMN book.length9 IS '長さ9';
COMMENT ON COLUMN book.length10 IS '長さ10';
COMMENT ON COLUMN book.numeric41 IS '小数';
COMMENT ON COLUMN book.insert_datetime IS '登録日時';
COMMENT ON COLUMN book.update_datetime IS '更新登録日時';

CREATE UNIQUE INDEX book_price ON book(price);

CREATE UNIQUE INDEX book_ui1
  ON book(book_name,book_id);
CREATE INDEX book_ni1
  ON book(price,book_id);
