package crud.resources

import crud.entities.Student
import spray.json.DefaultJsonProtocol

/**
  * Created by Zulek on 10.11.2017.
  */
object StudentJson extends DefaultJsonProtocol{
  implicit val studentFormat = DefaultJsonProtocol.jsonFormat4(Student)
}
