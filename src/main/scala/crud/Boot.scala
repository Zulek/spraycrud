package crud

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import crud.database.DatabaseConfig
import spray.can.Http

import scala.concurrent.duration._


object Boot extends App with DatabaseConfig {


  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("on-spray-can")
  implicit val executionContext = system.dispatcher

  val service = system.actorOf(Props[RestInterface])

  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}