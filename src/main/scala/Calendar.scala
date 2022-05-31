import scala.collection.mutable.ListBuffer

case class Calendar(nrOfDays: Int) {

  if (nrOfDays < 1 || nrOfDays > 365) {
    throw new IllegalStateException("nrOfDays must be greater than 0 and lower than 366")
  }

  var scheduledDays = 0
  var listOfSchDays = new ListBuffer[Int]()
  var listOfSchTasks = new ListBuffer[String]()

  def dayScheduler(subject: String, day: Int): Boolean = {
    if ((scheduledDays > nrOfDays) || listOfSchDays.contains(day)) false
    else {
      scheduledDays += 1
      listOfSchDays += day
      listOfSchTasks += subject
      true
    }
  }
}
