package com.michaelmaysonet74.slickexample.schemas

import com.michaelmaysonet74.slickexample.models.User
import slick.jdbc.PostgresProfile.api._

class Users(tag: Tag) extends Table[User](tag, "users") {

  def id = column[String]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def age = column[Int]("age")

  override def * = (id, name, age) <> (User.tupled, User.unapply)

}

object Users {
  lazy val table = TableQuery[Users]
}
