package com.michaelmaysonet74.slickexample.models

import java.time.LocalDate

final case class Product(
  id: Int,
  title: String,
  creationDate: LocalDate
)
