package pppp;

import com.example.base.BaseClass;
import aaa;

/**
 * book 【書籍マスタ】
 * テーブルの説明<br>
 * あいうえお<br>
 * かきくけこ<br>
 * 改行込みだよ
 *
 * @author test
 */
public class Book extends BaseClass {
/* SQL
SELECT book_id,book_name,price,book_type,insert_datetime,update_datetime
FROM book;

INSERT INTO book(book_id,book_name,price,book_type,insert_datetime,update_datetime)
VALUES(?,?,?,?,?,?);

UPDATE book
SET book_id=?,book_name=?,price=?,book_type=?,insert_datetime=?,update_datetime=?;
*/

	private static final long serialVersionUID = 1L;

	private Integer bookId;
	private String bookName;
	private Integer price;
	private String bookType;
	private Timestamp insertDatetime;
	private Timestamp updateDatetime;

	/**
	 * book_id 【書籍ID】の取得<br>
	 * 【型】 INTEGER
	 * 
	 * @return bookId 【書籍ID】
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * book_id 【書籍ID】のセット<br>
	 * 【型】 INTEGER
	 * 
	 * @param bookId
	 *             【書籍ID】
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * book_name 【書名】の取得<br>
	 * 【型】 VARCHAR(80)
	 * 
	 * @return bookName 【書名】
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * book_name 【書名】のセット<br>
	 * 【型】 VARCHAR(80)
	 * 
	 * @param bookName
	 *             【書名】
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * price 【価格】の取得<br>
	 * 【型】 INTEGER
	 * 
	 * @return price 【価格】
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * price 【価格】のセット<br>
	 * 【型】 INTEGER
	 * 
	 * @param price
	 *             【価格】
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * book_type 【書籍種別】の取得<br>
	 * 【型】 CHAR(1)
	 *
	 * 1: 小説<br>
	 * 2: コミック<br>
	 * 3: 実用書
	 * 
	 * @return bookType 【書籍種別】
	 */
	public String getBookType() {
		return bookType;
	}

	/**
	 * book_type 【書籍種別】のセット<br>
	 * 【型】 CHAR(1)
	 *
	 * 1: 小説<br>
	 * 2: コミック<br>
	 * 3: 実用書
	 * 
	 * @param bookType
	 *             【書籍種別】
	 */
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	/**
	 * insert_datetime 【登録日時】の取得<br>
	 * 【型】 TIMESTAMP WITH TIME ZONE
	 * 
	 * @return insertDatetime 【登録日時】
	 */
	public Timestamp getInsertDatetime() {
		return insertDatetime;
	}

	/**
	 * insert_datetime 【登録日時】のセット<br>
	 * 【型】 TIMESTAMP WITH TIME ZONE
	 * 
	 * @param insertDatetime
	 *             【登録日時】
	 */
	public void setInsertDatetime(Timestamp insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	/**
	 * update_datetime 【更新登録日時】の取得<br>
	 * 【型】 TIMESTAMP
	 * 
	 * @return updateDatetime 【更新登録日時】
	 */
	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	/**
	 * update_datetime 【更新登録日時】のセット<br>
	 * 【型】 TIMESTAMP
	 * 
	 * @param updateDatetime
	 *             【更新登録日時】
	 */
	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

}
