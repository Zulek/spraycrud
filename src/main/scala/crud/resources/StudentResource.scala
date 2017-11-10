package crud.resources

import crud.entities.Student
import crud.service.StudentService
import spray.http.{HttpHeaders, MediaTypes}
import spray.routing._
import org.squeryl.PrimitiveTypeMode._
import spray.httpx.SprayJsonSupport._

trait StudentResource extends HttpService {

  import crud.resources.StudentJson._

  val studentService: StudentService

  def studentRoutes: Route =
      post {
          entity(as[Student]) { student =>
            complete(transaction{studentService.create(student)})
        }
      } ~
      get {
        respondWithMediaType(MediaTypes.`application/json`) {
          complete(transaction{studentService.all()})
        }
      } ~
      path(Segment) { id =>
          put {
            entity(as[Student]) { updStudent =>
              respondWithMediaType(MediaTypes.`application/json`) {
                complete(transaction{studentService.update(updStudent)})
              }
            }
          } ~
          delete {
            complete(204, transaction{studentService.delete(id.toLong)})
          }
      }



}