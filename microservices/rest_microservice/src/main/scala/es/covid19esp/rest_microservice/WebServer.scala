package es.covid19esp.rest_microservice

import akka.http.scaladsl.Http
import com.typesafe.scalalogging.LazyLogging
import es.covid19esp.rest_microservice.utils.ActorSystemUtils

object WebServer extends LazyLogging with RestRoutes {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystemUtils.system
    implicit val materializer = ActorSystemUtils.materializer
    implicit val executionContext = system.dispatcher

    val plannerRoutes = routes

    val binding = Http().bindAndHandle(plannerRoutes, "localhost")
    logger.info(s"Server online at http://localhost:16000/")
  }

}
