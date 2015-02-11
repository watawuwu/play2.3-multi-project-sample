package controllers.application

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends Specification {

  "Application" should {

    "with configuration" in new WithApplication {

      val res = Application.index()(FakeRequest())
      status(res) === OK
      contentType(res) must beSome.which(_ == "text/plain")
      contentAsString(res) must contain ("en")
    }
  }
}
