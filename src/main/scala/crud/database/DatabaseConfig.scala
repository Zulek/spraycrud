package crud.database

import org.squeryl.adapters.PostgreSqlAdapter
import org.squeryl.{Session, SessionFactory}

trait DatabaseConfig {

  Class.forName("org.postgresql.Driver")

  SessionFactory.concreteFactory = Some(()=>
    Session.create(
      java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root"),
      new PostgreSqlAdapter))

  import org.squeryl.PrimitiveTypeMode._

  try{
    transaction {
      from( StudentTable.students ) (s => select(s)).toList
    }
  }
  catch {
    case e: Exception => {
      try {
        transaction{
          StudentTable.create
        }
        transaction{
          from( StudentTable.students ) (s => select(s)).toList
        }
      } catch {
        case e:Exception =>
      }
    }
  }
}
