package pppp;

import com.example.base.BaseClass;
import aaa;

/**
 * author 【著者】
 * 
 *
 * @author test
 */
public class Author extends BaseClass {
/* SQL
SELECT author_id,author_name
FROM author;

INSERT INTO author(author_id,author_name)
VALUES(?,?);

UPDATE author
SET author_id=?,author_name=?;
*/

	private static final long serialVersionUID = 1L;

	private Integer authorId;
	private String authorName;

	/**
	 * author_id 【著者ID】の取得<br>
	 * 【型】 INTEGER
	 * 
	 * @return authorId 【著者ID】
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * author_id 【著者ID】のセット<br>
	 * 【型】 INTEGER
	 * 
	 * @param authorId
	 *             【著者ID】
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * author_name 【著者名】の取得<br>
	 * 【型】 VARCHAR(80)
	 * 
	 * @return authorName 【著者名】
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * author_name 【著者名】のセット<br>
	 * 【型】 VARCHAR(80)
	 * 
	 * @param authorName
	 *             【著者名】
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
