package io.scak.middleware

import com.fasterxml.jackson.databind.ObjectMapper
import io.scak.{App, Response, defaults}

class JsonResponse(app: App)(implicit mapper: ObjectMapper = defaults.ObjectMapper.objectMapper) extends App {

  override def apply(env: Map[String, Any]): Response = {
    val res = app.apply(env)
    res.copy(
      body = res.body.map(jsonify),
      headers = res.headers ++ Map("Content-Type" -> "application/json;charset=UTF-8")
    )
  }

  def jsonify(obj: Any): String =
    mapper.writeValueAsString(obj)

}
