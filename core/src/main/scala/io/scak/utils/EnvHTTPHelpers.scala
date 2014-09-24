package io.scak.utils


trait HTTPHelpers {
  implicit class EnvImprovements(val env: Map[String, Any]) {
    def getMethod(): String =
      env.get("http.method").map {
        _.asInstanceOf[String]
      }.get

    def getPath(): String =
      env.get("http.path").map {
        _.asInstanceOf[String]
      }.get

    def getHeaders(): Map[String, String] =
      env.get("http.headers").map {
        _.asInstanceOf[Map[String, String]]
      }.get

    def getBody(): Option[String] = {
      env.get("http.body").map(_.asInstanceOf[Option[String]]).flatten
    }
  }
}

object EnvHTTPHelpers extends HTTPHelpers{

}
