package io.scak.jetty

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import io.scak.App
import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.handler.AbstractHandler

import scala.collection.JavaConversions._
import scala.io.Source

class ScakHandler(app: App) extends AbstractHandler {
  override def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse): Unit = {

    val headers: Map[String, String] = baseRequest.getHeaderNames.toSeq.map(h => h -> baseRequest.getHeader(h))(collection.breakOut)
    val bodyStr = Source.fromInputStream(baseRequest.getInputStream).getLines().mkString("\n")
    val body = bodyStr match {
      case b if !b.isEmpty => Some(b)
      case _ => None
    }

    val res = app(Map(
      "http.method" -> baseRequest.getMethod,
      "http.path" -> baseRequest.getPathInfo,
      "http.headers" -> headers,
      "http.body" -> body
    ))

    response.setContentType(res.headers.getOrElse("Content-Type", "text/html;charset=utf-8"))
    response.setStatus(res.code)

    baseRequest.setHandled(true)
    res.body.map(response.getWriter().println)
  }
}
