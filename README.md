# Problem
Nullable method (may return `null`, for instance Java interop) with return type of [value class](http://docs.scala-lang.org/sips/completed/value-classes.html) 
may cause `NullPointerException` in specific cases.

# NPE

```
Exception in thread "main" java.lang.NullPointerException
    at example.TestNPE$.$anonfun$main$2(TestNPE.scala:17)
    at example.TestNPE$.$anonfun$main$2$adapted(TestNPE.scala:17)
    at scala.Option.map(Option.scala:146)
    at example.TestNPE$.main(TestNPE.scala:17)
    at example.TestNPE.main(TestNPE.scala)

```

# Generated code 

```
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