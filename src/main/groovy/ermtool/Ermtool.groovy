package ermtool

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity


class Ermtool {
	static main(args) {
		def cli = new CliBuilder(usage:"groovy Ermtool.groovy -i ermfile -t table -o output_dir")
		cli.i(argName: 'input', required: true, args: 1, 'ERMasterの.ermファイル')
		cli.t(argName: 'table', required: true, args: 1, '出力テーブル名')
		cli.o(argName: 'output', required: true, args: 1, '出力先ディレクトリ')
		def options = cli.parse(args)
		if (!options) return
			def config = new ConfigSlurper().parse(new File("config/config.groovy").toURI().toURL())
		def reader = new Ermtool(new File(options.i))
		reader.output(config, options.t, options.o);
	}

	private def erm
	private def dictionaryMap
	private def columnGroupMap
	private def categoryMap
	private def tableCategoryMap
	private def tableMap

	Ermtool(File file) {
		erm = new XmlSlurper().parseText(file.text)

		initDictionaryMap()
		initColumnGroupMap()
		initCategoryMap()
		initTableMap()
	}

	public void output(config, target, output) {
		//Velocityの初期化
		Velocity.init();
		//Velocityコンテキストに値を設定
		def context = new VelocityContext()
		def table = tableMap[target]
		context.put("config", config)
		context.put("table", table)

		new File("${output}/${table.physicalName}.sql").withWriter { writer ->
			def template = Velocity.getTemplate("config/table.vm", "UTF-8");
			//テンプレートとマージ
			template.merge(context, writer);
		}
		new File("${output}/${table.className}.java").withWriter { writer ->
			def template = Velocity.getTemplate("config/entity.vm", "UTF-8");
			//テンプレートとマージ
			template.merge(context, writer);
		}
	}

	private void initDictionaryMap() {
		dictionaryMap = [:]
		erm.dictionary.word.collect().each {
			dictionaryMap[it.id.text()] = new Column(it)
		}
	}

	private void initColumnGroupMap() {
		columnGroupMap = [:]
		erm.column_groups.column_group.collect().each {
			columnGroupMap[it.id.text()] = new ColumnGroup(it, dictionaryMap)
		}
	}

	private void initCategoryMap() {
		categoryMap = [:]
		tableCategoryMap = [:]
		erm.settings.category_settings.categories.category.collect().each {
			def categoryName = it.id.name.text()
			if (categoryMap[categoryName] == null) {
				categoryMap[categoryName] = []
			}
			def nodeList = categoryMap[it.id.name.text()]
			it.node_element.collect().each {
				nodeList.push(it.text())
				tableCategoryMap[it.text()] = categoryName
			}
		}
	}

	private void initTableMap() {
		tableMap = [:]
		erm.contents.table.collect().each {
			tableMap[it.physical_name.text()] = new Table(it, dictionaryMap, columnGroupMap)
		}
	}
}
