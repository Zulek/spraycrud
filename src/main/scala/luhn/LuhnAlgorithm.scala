package luhn

object LuhnAlgorithm {

  def toList(cardnum: String): List[Int] = {
    cardnum.filterNot(c => c.isWhitespace).map(_.toInt).toList
  }

  def changeNumbers(list: List[Int]): List[Int]  = {
    list.reverse.zipWithIndex.map{
      case (value,index) =>
        if (index % 2 == 0) {
          val newValue = 2*value
          if (newValue>9) newValue-9
          else newValue
        }
        else value
    }
  }

  def isValidCard(cardNumber: String): Boolean = {
    val cardNumberList = toList(cardNumber)
    val changedList = changeNumbers(cardNumberList)
    changedList.sum % 10 == 0
  }

}
