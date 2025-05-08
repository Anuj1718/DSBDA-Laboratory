// Take inputs before Spark logic
val a = scala.io.StdIn.readDouble()
val op = scala.io.StdIn.readLine()
val b = scala.io.StdIn.readDouble()

// Create a dummy RDD with 1 element to simulate Spark usage
val rdd = sc.parallelize(Seq((a, op, b)))

val result = rdd.map {
  case (x, "+", y) => s"$x + $y = ${x + y}"
  case (x, "-", y) => s"$x - $y = ${x - y}"
  case (x, "*", y) => s"$x * $y = ${x * y}"
  case (x, "/", y) =>
    if (y != 0) s"$x / $y = ${x / y}"
    else s"$x / $y = Error (division by zero)"
  case (x, o, y)   => s"$x $o $y = Invalid operator"
}

result.collect().foreach(println)


// ✅ Summary
// Task	Tool
// Language	Scala
// Framework	Apache Spark
// Shell used	spark-shell
// Input method	StdIn.readLine()
// Output	Printed result using Spark RDD 

// In Apache Spark, an RDD (Resilient Distributed Dataset) is the fundamental data structure used for distributed data processing. RDDs // // are immutable and distributed, which means the data they hold is spread across multiple machines, and they offer fault tolerance.