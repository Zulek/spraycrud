package crud

import akka.actor.Props
import crud.service.StudentService
import crud.resources.StudentResource
import spray.routing.{HttpServiceActor, Route}

import scala.concurrent.ExecutionContext
import scala.language.postfixOps

class RestInterface extends HttpServiceActor with Resources {

  def receive = runRoute(routes)

  val studentService = new StudentService

  val routes: Route = studentRoutes

}

trait Resources extends StudentResource