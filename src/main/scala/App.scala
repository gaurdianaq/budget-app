
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import scala.io.StdIn
import scala.sys.env
import slick.jdbc.MySQLProfile.api._

@main def main =
    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.executionContext

    val db = Database.forURL("jdbc:mysql:172.17.0.2:user=root&password=gaurdianAQ#123", driver="com.mysql.jdbc.Driver")

    val route =
        path("hello")
            get
                complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
                
    
    Http().newServerAt("0.0.0.0", 8080).bind(route)

    println(s"Server now online.")