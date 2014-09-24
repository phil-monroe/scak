package io.scak.defaults

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object ObjectMapper {
  implicit val objectMapper = new ObjectMapper
  objectMapper.registerModule(DefaultScalaModule)
}
