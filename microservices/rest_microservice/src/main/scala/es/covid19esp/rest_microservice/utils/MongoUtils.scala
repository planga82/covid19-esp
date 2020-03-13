package es.covid19esp.rest_microservice.utils

import es.covid19esp.rest_microservice.model.User
import org.bson.codecs.configuration.CodecRegistries
import org.mongodb.scala.{MongoClient, MongoCollection, MongoDatabase}
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries._
import org.mongodb.scala.bson.codecs.Macros._



object MongoUtils {

  private val mongoClient: MongoClient = MongoClient()

  private val codecRegistry =
    fromRegistries(fromProviders(classOf[User]), DEFAULT_CODEC_REGISTRY )


  private val database: MongoDatabase =
    mongoClient.getDatabase("covid_db").withCodecRegistry(codecRegistry)

  val collection: MongoCollection[User] =
    database.getCollection("user")

}
