package io.scak

case class Environment(method: String, path: String, body: Option[String], headers: Map[String, String])
case class Response(code: Int, headers: Map[String, String], body: Option[String] = None)

trait App {
  def apply(env: Environment): Response
}

