package io.scak.example

import io.scak.jetty.Server
import io.scak.{App, Environment, Response}

class StringApp(str: String) extends App {
  def apply(env: Environment): Response = Response(200, Map.empty[String, String], Some(str))
}

object EchoApp extends App {
  def apply(env: Environment): Response = {
    Response(200, Map.empty[String, String], Some( s"""'${env.body.getOrElse("Nice Try...")}'"""))
  }
}

object Router extends App {
  val pongApp = new StringApp("pong")
  val helloApp = new StringApp("Hello World!")

  def apply(env: Environment): Response = {
    env.path match {
      case "/ping" => pongApp
      case "/echo" => EchoApp
      case _ => helloApp
    }
  }.apply(env)
}


object Example extends scala.App {
  new Server(Router).join()
}
