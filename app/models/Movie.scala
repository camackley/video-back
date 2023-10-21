package models

import com.google.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import slick.jdbc.JdbcProfile

import java.util.UUID
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.{ExecutionContext, Future}

case class Movie (
  id: Option[String] = Option(UUID.randomUUID().toString),
  title: String,
  year: Int,
  cover: String,
  description: String,
  duration: Int,
  contentRating: String,
  source: String,
  tags: Option[String]
)

class MovieTable(tag: Tag) extends Table[Movie](tag, "movie") {
  def id = column[String]("id", O.PrimaryKey)
  def title = column[String]("title")
  def year = column[Int]("year")
  def cover = column[String]("cover")
  def description = column[String]("description")
  def duration = column[Int]("duration")
  def contentRating = column[String]("contentRating")
  def source = column[String]("source")
  def tags = column[Option[String]]("tags", O.Length(2000, varying = true))
  def * = (id.?, title, year, cover, description, duration, contentRating, source, tags) <> (Movie.tupled, Movie.unapply)
}

class MovieRepository @Inject()(
  protected val dbConfigProvider: DatabaseConfigProvider,
  cc: ControllerComponents
)(implicit ec: ExecutionContext) extends AbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {
  private lazy val movieQuery = TableQuery[MovieTable]

  def dbInit: Future[Unit] = {
    val createSchema = movieQuery.schema.createIfNotExists
    db.run(createSchema)
  }

  def getAll = ???

  def getOne = ???

  def create = ???

  def update = ???

  def delete = ???
}