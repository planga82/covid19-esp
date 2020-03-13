package es.covid19esp.rest_microservice.ext

case class UpdateRequest(
                          healthy: Boolean,
                          fever: Option[Float] //TODO
                        )
