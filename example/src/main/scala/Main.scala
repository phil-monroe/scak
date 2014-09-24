import io.scak.jetty.Server
import io.scak.middleware.JsonResponse
import middleware.Router

object Main extends App {

  val app = new JsonResponse(Router)
  val server = Server(app)

   sys.addShutdownHook {
     server.stop()
   }

}
