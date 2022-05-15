package com.michaelmaysonet74.slickexample

import com.michaelmaysonet74.slickexample.models.User
import com.michaelmaysonet74.slickexample.schemas.Users
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  val db = Database.forConfig("slick")
  val query = Users.table.sortBy(_.age).result
  val queryResult: Future[Seq[User]] = db.run(query)
  queryResult.foreach(println)

  Thread.sleep(100)

}
