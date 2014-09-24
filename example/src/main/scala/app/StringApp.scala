package app

import io.scak.{App, Response}

class StringApp(str: String) extends App {
  def apply(env: Map[String, Any]) =
    Response(
      200,
      Map.empty[String, String],
      Some(str)
    )
}
