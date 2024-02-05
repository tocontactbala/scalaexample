  sealed trait Item

  case object Apple extends Item

  case object Orange extends Item

  object CheckoutSystem {
    val prices: Map[Item, Double] = Map(
      Apple -> 0.60,
      Orange -> 0.25
    )

    // calculate the total cost of items
    def calculateTotalCost(items: List[Item]): Double = {
      val totalCost = items.map(item => prices(item)).sum
      totalCost
    }

    def simpleOffers(items: List[Item]): Double = {
      val appleCount = items.count(_ == Apple)
      val orangeCount = items.count(_ == Orange)

      val appleCost = (appleCount / 2 + appleCount % 2) * prices(Apple)
      val orangeCost = (orangeCount / 3 * 2 + orangeCount % 3) * prices(Orange)

      appleCost + orangeCost
    }

    def getTotalCostWithOffers(items: List[Item]): Double = {
      val totalCost = simpleOffers(items)
      totalCost
    }
  }

  object Main extends App {
    val items = List(Apple, Apple, Orange, Apple)
    val totalCost = CheckoutSystem.calculateTotalCost(items)
    val totalCostWithOffers = CheckoutSystem.getTotalCostWithOffers(items)
    println(s"Total cost without offers: £$totalCost")
    println(s"Total cost with offers: £$totalCostWithOffers")
}
