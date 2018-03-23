package example

import npe.Target

object TestNPE {
  def main(args: Array[String]): Unit = {
    val target = new Target[Key, Value]

    val keyO = Option(new Key("key"))

    //works
    keyO
      .flatMap(k => Option(target.operationNullable(k)))

    // throws NPE
    keyO
      .map(target.operationNullable)
      .flatMap(Option.apply)
  }
}
