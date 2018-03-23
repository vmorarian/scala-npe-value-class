package example

class Key(val underlying: String) extends AnyVal {
  def operationQuote: String = "'" + underlying + "'"
}
