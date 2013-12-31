package ermtool


class Sequence {
	def name
	def increment
	def minValue
	def maxValue
	def start
	def cache
	def nocache
	def cycle
	def order
	def description
	def dataType
	def decimalSize

	Sequence(sequence) {
		name = sequence.name.text()
		increment = sequence.increment.text()
		minValue = sequence.min_value.text()
		maxValue = sequence.max_value.text()
		start = sequence.start.text()
		cache = sequence.cache.text()
		nocache = (sequence.nocache.text() == "true")
		cycle = (sequence.cycle.text() == "true")
		order = (sequence.order.text() == "true")
		description = sequence.description.text()
	}
}
