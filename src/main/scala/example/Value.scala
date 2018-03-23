package example

class Value(val underlying: String) extends AnyVal {
  def pretty: String = "[" + underlying + "]"
}
