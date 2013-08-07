package ermtool

import com.google.common.base.CaseFormat

class Column {
	def id
	def wordId
	def physicalName
	def logicalName
	def type
	def description
	def length
	def notNull
	def uniqueKey
	def uniqueKeyName
	// 扱いがちょっと微妙なの文字列にしておく
	String defaultValue

	Column(column) {
		id = column.id.text()
		wordId = column.word_id.text()
		logicalName = column.logical_name.text()
		physicalName = column.physical_name.text()
		type = column.type.text()
		description = column.description.text()
		length = column.length.text()
		notNull = (column.not_null.text() == "true")
		uniqueKey = (column.unique_key.text() == "true")
		uniqueKeyName = column.unique_key_name.text()
		if (column.default_value.text() != "") {
			defaultValue = column.default_value.text()
		}
	}

	public void dictInfo(dictColumn) {
		logicalName = dictColumn.logicalName
		physicalName = dictColumn.physicalName
		type = dictColumn.type
		length = dictColumn.length
		description = dictColumn.description
	}

	private final def TYPE_MAP = ["integer" : "INTEGER",
		"date": "DATE", "timestamp with time zone": "TIMESTAMP WITH TIME ZONE",
		"timestamp": "TIMESTAMP"]
	private final def TYPE_STRING_MAP = new HashSet([
		"char",
		"char(n)",
		"varchar",
		"varchar(n)"
	])

	public String getTypeInfo() {
		def typeName = TYPE_MAP[type]
		if (typeName == null) {
			if (type == "varchar(n)") {
				typeName = "VARCHAR(${length})"
			} else if (type == "character(n)") {
				typeName = "CHAR(${length})"
			}
		}
		return typeName
	}

	public String getUniqueKeyInfo() {
		if (uniqueKey && uniqueKeyName == "") {
			return " UNIQUE"
		}
		return ""
	}

	public boolean isColumnUnique() {
		return uniqueKey && uniqueKeyName != ""
	}

	public String getNotNullInfo() {
		if (!notNull) {
			return " NOT NULL"
		}

		return ""
	}

	public String getDefaultValueInfo() {
		if (defaultValue != null) {
			if (TYPE_STRING_MAP.contains(type)) {
				// Eclipseだと直接returnできない。
				def ret = / DEFAULT "${defaultValue}"/
				return ret;
			} else {
				return " DEFAULT " + defaultValue
			}
		}
		return ""
	}

	public String getColumnInfo() {
		def typeName = getTypeInfo()
		def columnInfo = "${physicalName} ${typeName}"
		if (!notNull) {
			columnInfo = columnInfo + " NOT NULL"
		}
		if (defaultValue != null) {
			if (TYPE_STRING_MAP.contains(typeName)) {
				columnInfo = columnInfo + / DEFAULT "${defaultValue}"/
			} else {
				columnInfo = columnInfo + " DEFAULT " + defaultValue
			}
		}

		return columnInfo
	}

	public String getJavaPhysicalName() {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, physicalName)
	}

	public String getGetter() {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "get_${physicalName}")
	}

	public String getSetter() {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "set_${physicalName}")
	}

	private final def JAVA_TYPE_MAP = [
		"integer" : "Integer", "date": "Date", "timestamp with time zone": "Timestamp",
		"timestamp": "Timestamp",
		"character": "String", "character(n)": "String",
		"varchar":"String", "varchar(n)": "String"]

	public String getJavaType() {
		return JAVA_TYPE_MAP[type]
	}

	public String getJavaDescription() {
		String[] lines = description.split("\n")
		String result = ""
		for (i in 0..<lines.length) {
			// 最初の行以外
			if (i > 0) {
				result = result + "\t * "
			}
			result = result + lines[i]
			// 次の行があれば
			if (i + 1 < lines.length) {
				result =  result + "<br>\n"
			}
		}

		return result
	}
}
