package crud

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import crud.database.DatabaseConfig
import spray.can.Http

import scala.concurrent.duration._


object Boot extends App with DatabaseConfig {

  implicit val system = ActorSystem("on-spray-can")
  implicit val executionContext = system.dispatcher

  val service = system.actorOf(Props[RestInterface])

  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
