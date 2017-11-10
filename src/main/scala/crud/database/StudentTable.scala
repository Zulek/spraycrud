package crud.database

import crud.entities.Student
import org.squeryl.{Schema, Table}


object StudentTable extends Schema {
  val students: Table[Student] = table[Student]

}
