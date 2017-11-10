package crud.service

import crud.database.StudentTable
import crud.entities._
import org.squeryl.PrimitiveTypeMode._

import scala.concurrent.ExecutionContext

class StudentService {

  def create(student: Student) =
    StudentTable.students.insert(student)


  def all() =
    from( StudentTable.students ) (s => select(s)).toList


  def update(student: Student) = {
      StudentTable.students.update(i =>
        where(i.id=== student.id)
          set(i.birthdate := student.birthdate, i.name := student.name, i.age := student.age ))
    all()
  }

  def delete(id: Long) =
    StudentTable.students.deleteWhere(i => i.id === id)
}
