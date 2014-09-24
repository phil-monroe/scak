package middleware

import app.{EchoApp, StringApp}
import io.scak.utils.HTTPHelpers
import io.scak.{App, Response}

case class Timestamp(stamp: String)

object Router extends App with HTTPHelpers {
  val pongApp = new StringApp("pong")
  val helloApp = new StringApp("Hello World!")
  val timeApp = (env: Map[String, Any]) => {
    Response(200, Map.empty, Some(Timestamp(new java.sql.Timestamp(System.currentTimeMillis()).toString)))
  }


  def apply(env: Map[String, Any]): Response = {
    (env.getMethod, env.getPath) match {
      case (_,      "/ping") => pongApp(env)
      case (_,      "/time") => timeApp(env)
      case ("PUT" | "POST", "/echo") => EchoApp(env)
      case _ => helloApp(env)
    }
  }
}
