package es.covid19esp.rest_microservice.utils

object MongoUtils {

  val mongoClient: MongoClient = MongoClient()
val database: MongoDatabase = mongoClient.getDatabase("mydb").withCodecRegistry(codecRegistry)
val collection: MongoCollection[Person] = database.getCollection("test")
}
