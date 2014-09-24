package io.scak

case class Response(code: Int, headers: Map[String, String], body: Option[Any] = None)
