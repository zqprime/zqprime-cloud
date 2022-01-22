package club.zqprime

import org.apache.spark.{SparkConf, SparkContext}

case object FirstSparkApplication{
  def main(args: Array[String]): Unit = {
    print("FirstSparkApplication")
    val wordCount = new SparkConf().setMaster("spark://VM-0-7-centos:7077").setAppName("WordCount")

    val context = new SparkContext(wordCount)

  }
}
