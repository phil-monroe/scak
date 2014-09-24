package io.scak.jetty

import io.scak.App

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Server{
  def apply(app: App) = {

    val server = new org.eclipse.jetty.server.Server(8080)
    server.setHandler(new ScakHandler(app))
    server.start()
    server.setStopAtShutdown(true)

    server
  }
}
