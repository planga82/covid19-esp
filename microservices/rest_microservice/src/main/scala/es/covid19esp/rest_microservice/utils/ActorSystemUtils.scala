package es.covid19esp.rest_microservice.utils

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object ActorSystemUtils {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

}
