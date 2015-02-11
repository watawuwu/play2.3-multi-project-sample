package controllers.application

import play.api._
import play.api.mvc._

object Application extends Application {
  import play.api.Play.current
  val configuration = play.api.Play.application.configuration
}

trait Application extends Controller {

  val configuration: Configuration

  def index = Action {
    val langs = configuration.getString("application.langs").get
    Ok(langs)
  }
}
