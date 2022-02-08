package club.zqprime

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.io.File


case object FirstSparkApplication{
  def main(args: Array[String]): Unit = {
//    val wordCount = new SparkConf().setMaster("spark://zqprime-desktop:7077").setAppName("WordCount")
//    val wordCount = new SparkConf().setMaster("spark://162.14.97.85:7077").setAppName("WordCount")
    val wordCount = new SparkConf().setMaster("local").setAppName("WordCount")
    val spark = new SparkContext(wordCount)

    val lines: RDD[String] = spark.textFile("/home/zqprime/IdeaProjects/zqprime-cloud/bigdata/spark-core/src/main/resources/datas/words")

    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordGroup: RDD[(String,Iterable[String])] = words.groupBy(words => words)

    val result = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }

    val array: Array[(String,Int)] = result.collect()

    print("===========start============")
    array.foreach(print)
    print("============end==========")

    spark.stop()
  }
}
