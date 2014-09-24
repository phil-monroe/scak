package app

import io.scak.utils.HTTPHelpers
import io.scak.{App, Response}

object EchoApp extends App with HTTPHelpers {
  def apply(env: Map[String, Any]): Response =
    Response(
      200,
      Map.empty[String, String],
      Some(env.getBody.getOrElse("Nice Try..."))
    )
}
