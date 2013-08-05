package ermtool

class Index {
	def unique
	def name
	def description
	def columnNameList
	def descList
	def tableName

	Index(index, columnList, tableName) {
		this.tableName = tableName
		unique = !Boolean.valueOf(index.non_unique.text())
		name = index.name.text()
		description = index.description.text()

		columnNameList = []
		descList = []
		index.columns.column.collect() {
			columnNameList.add(columnList[it.id.text()].physicalName)
		}
	}
}
