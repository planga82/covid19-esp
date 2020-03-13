package es.covid19esp.rest_microservice

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.ExceptionHandler
import akka.http.scaladsl.server.Directives._
import com.typesafe.scalalogging.LazyLogging
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import es.covid19esp.rest_microservice.ext.{UpdateRequest, UpdateResponse}
import org.json4s.{DefaultFormats, jackson}

trait JsonSupport extends Json4sSupport {
  implicit val serialization = jackson.Serialization // or native.Serialization
  implicit val formats = DefaultFormats
}

trait RestRoutes extends JsonSupport with LazyLogging {

  val myExceptionHandler = ExceptionHandler {
    case e =>
      extractRequest { rq =>
        logger.error(s"Error generated with $rq", e)
        complete(StatusCodes.InternalServerError -> "{\"msg\":\"Error processing request\"}")
      }
  }

  lazy val routes =
    handleExceptions(myExceptionHandler) {
      post {
        path("statusUpdate") {
          entity(as[UpdateRequest]) { rq =>
            logger.info(s"POST /api rq: $rq")
            complete(
              UpdateResponse(true)
            )
          }
        }
      }
    }

}
