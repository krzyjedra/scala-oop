import org.scalatest._
import flatspec._
import matchers._

class CalendarSpec extends AnyFlatSpec with should.Matchers {

  "A calendar" should "have number of days defined" in {
    val calendar = Calendar(365)
    calendar.nrOfDays shouldBe 365
  }
  it should "have scheduled 2 days with some tasks" in {
    val calendar = Calendar(365)
    calendar.dayScheduler("bieganie", 5)
    calendar.dayScheduler("joga", 7)
    calendar.scheduledDays shouldBe 2
  }
  it should "have a list with 2 scheduled days for some tasks" in {
    val calendar = Calendar(365)
    calendar.dayScheduler("bieganie", 5)
    calendar.dayScheduler("joga", 7)
    calendar.listOfSchDays.toList shouldBe List(5,7)
  }
  it should "schedule only joga for day 7th" in {
    val calendar = Calendar(365)
    calendar.dayScheduler("bieganie", 5)
    calendar.dayScheduler("joga", 7)
    calendar.dayScheduler("hokej", 7)
    calendar.listOfSchTasks.toList shouldBe List("bieganie", "joga")
  }
}
