package ermtool

class ColumnGroup {
	def id
	def groupName
	def columnList

	ColumnGroup(columnGroup, dictionaryMap) {
		id = columnGroup.id.text()
		groupName = columnGroup.group_name.text()
		columnList = new ArrayList()

		columnGroup.columns.normal_column.collect().each {
			def column = new Column(it)
			def dictColumn = dictionaryMap[it.word_id.text()]

			if (dictColumn != null) {
				column.dictInfo(dictColumn)
			}
			columnList.add(column)
		}
	}
}
