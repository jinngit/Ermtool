package ermtool

import com.google.common.base.CaseFormat


class Table {
	def id
	def logicalName
	def physicalName
	def description
	def columnList
	def primaryKeyList
	def indexList

	Table(table, dictionaryMap, columnGroupMap) {
		id = table.id.text()
		logicalName = table.logical_name.text()
		physicalName = table.physical_name.text()
		description = table.description.text()
		columnList = [:]
		primaryKeyList = []
		indexList = []

		table.columns.normal_column.collect().each {
			def column = new Column(it)
			def dictColumn = dictionaryMap[it.word_id.text()]

			if (dictColumn != null) {
				column.dictInfo(dictColumn)
			}
			columnList[it.id.text()] = column
			if (it.primary_key.text() == "true") {
				primaryKeyList.add(column.physicalName)
			}
		}
		table.columns.column_group.collect().each {
			def columnGroup = columnGroupMap[it.text()]
			columnGroup.columnList.each { columnList[it.id] = it }
		}
		table.indexes.inidex.collect().each {
			indexList.add(new Index(it, columnList, physicalName))
		}
	}

	public String getClassName() {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, physicalName)
	}

	public String getJavaDescription() {
		String[] lines = description.split("\n")
		String result = ""
		for (i in 0..<lines.length) {
			// 最初の行以外
			if (i > 0) {
				result = result + " * "
			}
			result = result + lines[i]
			// 次の行があれば
			if (i + 1 < lines.length) {
				result =  result + "<br>\n"
			}
		}

		return result
	}

	public String getSelectSql() {
		String sql = "SELECT "
		columnList.eachWithIndex { key, value, i ->
			if (i > 0) {
				sql = sql + ","
			}
			sql = "${sql}${value.physicalName}"
		}
		sql = "${sql}\nFROM ${physicalName};"
	}

	public String getInsertSql() {
		String sql = "INSERT INTO ${physicalName}("
		columnList.eachWithIndex { key, value, i ->
			if (i > 0) {
				sql = sql + ","
			}
			sql = "${sql}${value.physicalName}"
		}
		sql = sql + ")\nVALUES("
		columnList.eachWithIndex { key, value, i ->
			if (i > 0) {
				sql = sql + ","
			}
			sql = sql + "?"
		}
		sql = sql + ");"
		return sql
	}

	public String getUpdateSql() {
		String sql = "UPDATE ${physicalName}\nSET "
		columnList.eachWithIndex { key, value, i ->
			if (i > 0) {
				sql = sql + ","
			}
			sql = "${sql}${value.physicalName}=?"
		}
		sql = sql + ";"
		return sql
	}
}
