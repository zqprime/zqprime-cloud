package club.zqprime

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.io.File


case object FirstSparkApplication{
  def main(args: Array[String]): Unit = {
    val wordCount = new SparkConf().setMaster("spark://zqprime-desktop:7077").setAppName("WordCount")
//    val wordCount = new SparkConf().setMaster("local").setAppName("WordCount")
    val context = new SparkContext(wordCount)
    val lines: RDD[String] = context.textFile("bigdata/spark-core/target/classes/datas/words")

    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordGroup: RDD[(String,Iterable[String])] = words.groupBy(words => words)

    val result:RDD[(String,Int)] = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }

    print("===========start============")
    result.foreach(print)
    print("============end==========")

    context.stop()
  }
}
