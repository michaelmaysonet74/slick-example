package com.michaelmaysonet74.slickexample.schemas

import com.michaelmaysonet74.slickexample.models.Product
import slick.jdbc.PostgresProfile.api._

import java.time.LocalDate

class Products(tag: Tag) extends Table[Product](tag, "products") {

  def id = column[Int]("id", O.PrimaryKey)
  def title = column[String]("title")
  def creationDate = column[LocalDate]("creation_date")

  override def * = (id, title, creationDate) <> (Product.tupled, Product.unapply)

}

object Products {
  lazy val table = TableQuery[Products]
}
