package com.michaelmaysonet74.slickexample

import com.michaelmaysonet74.slickexample.models.{Product, User}
import com.michaelmaysonet74.slickexample.schemas.{Products, Users}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import java.sql.Date
import java.time.LocalDate

object Main extends App {

  val db = Database.forConfig("slick")

  db.run(
    Products.table
      .map(p => (p.title, p.creationDate))
      += (
        "El Ingenioso Hidalgo Don Quijote de La Mancha",
        LocalDate.now()
      )
  )

  val queryUsers = Users.table.sortBy(_.age).result
  val usersResult: Future[Seq[User]] = db.run(queryUsers)

  usersResult.foreach(println)

  Thread.sleep(100)

  db.close()

}
