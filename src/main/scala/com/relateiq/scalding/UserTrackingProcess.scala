package com.relateiq.scalding

// Scalding

import com.relateiq.tracking.UserTracking
import com.twitter.scalding._
import com.twitter.scalding.avro.PackedAvroSource

class UserTrackingProcess(args : Args) extends Job(args) {
//https://github.com/Tapad/scalding-avro-integration/blob/master/first-party/src/main/scala/jobs/SpecificExample.scala
  //val typedText : TypedPipe[String] = TypedPipe.from(TextLine( args("input") ))
  //PackedAvroSource[UserTracking](args("input"))
  //  .read
  val typedAvros  = TypedPipe.from[UserTracking](PackedAvroSource[UserTracking]( args("input") ))
  val records = typedAvros
    .map{ rec : UserTracking => (rec.getTimestamp, rec.getEventName) }

  //records.write(TypedSink UnpackedAvroSource(args("output")).addTrap(Tsv("errorFile.txt")))
  //records.write(Tsv( args("output")))


//  TextLine( args("input") )
//    .flatMap('line -> 'word) { line : String => tokenize(line) }
//    .groupBy('word) { _.size }
//    .write( Tsv( args("output") ) )

  // Split a piece of text into individual words.
  def tokenize(text : String) : Array[String] = {
    // Lowercase each word and remove punctuation.
    text.toLowerCase.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+")
  }
}