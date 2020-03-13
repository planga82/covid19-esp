package es.covid19esp.rest_microservice.model

import java.util.Date

import org.mongodb.scala.bson.ObjectId

sealed trait Grade { def key: String}

case object None extends Grade { def key = "N"}
case object Low extends Grade { def key = "L"}
case object Medium extends Grade { def key = "M"}
case object High extends Grade { def key = "H"}


case class User(
                 _id: ObjectId,
                 lat: Double,
                 lon: Double,
                 lastStatuses: Seq[Status],
                 recovered: Boolean,
                 confirmed: Boolean,
               )

case class Status(
                   submission: Date,
                   illness: Report
                       )

case class Report(
                    fever: Grade,
                    cough: Grade,
                    snot: Grade,
                    yourOpinion: Boolean
                    )
