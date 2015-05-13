package com.relateiq.scalding

// Specs2
import org.specs2.mutable.Specification

// Scalding
import com.twitter.scalding._

class UserTrackingProcessTest extends Specification {
  "A WordCount job" should {
    JobTest("com.relateiq.scalding.UserTrackingProcess").
//      arg("input", "inputFile").
//      arg("output", "outputFile").
//      source(TextLine("inputFile"), List("0" -> "hack hack hack and hack")).
//      sink[(String,Int)](Tsv("outputFile")){ outputBuffer =>
//        val outMap = outputBuffer.toMap
//        "count words correctly" in {
//          outMap("hack") must be_==(4)
//          outMap("and") must be_==(1)
//        }
//      }.
//      run.
      finish
  }
}