Isolated test to reproduce NPE in value class on calling null'able Java method



````
 // TestNPE.scala
package example {
  object TestNPE extends Object {
    def main(args: Array[String]): Unit = {
      val target: npe.Target = new npe.Target();
      val keyO: Option = scala.Option.apply(new example.Key("key"));
      keyO.flatMap({
        ((k: String) => TestNPE.this.$anonfun$main$1(target, k))
      });
      {
        keyO.map({
          {
            ((k: String) => TestNPE.this.$anonfun$main$2(target, k))
          }
        }).flatMap({
          {
            ((x: String) => TestNPE.this.$anonfun$main$3(x))
          }
        });
        ()
      }
    };
    final <artifact> private[this] def $anonfun$main$1(target$1: npe.Target, k: String): Option = scala.Option.apply(target$1.operationNullable(new example.Key(k)));
    final <artifact> private[this] def $anonfun$main$2(target$1: npe.Target, k: String): String = target$1.operationNullable(new example.Key(k)).$asInstanceOf[example.Value]().underlying();
    final <artifact> private[this] def $anonfun$main$3(x: String): Option = scala.Option.apply(new example.Value(x));
    def <init>(): example.TestNPE.type = {
      TestNPE.super.<init>();
      ()
    }
  }
}
```