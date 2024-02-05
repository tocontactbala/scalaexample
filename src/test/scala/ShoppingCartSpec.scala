import utils.SpecBase

  class CheckoutSystemSpec extends SpecBase {
    "CheckoutSystem" should "calculate the total cost without any offers" in {
      val items = List("Apple", "Apple", "Orange", "Apple")
      val totalCost = Main.checkout(items)
      totalCost shouldEqual 205
    }

    it should "apply the buy one, get one free offer on Apples" in {
      val items = List("Apple", "Apple", "Apple", "Apple")
      val totalCost = Main.checkout(items)
      totalCost shouldEqual 180
    }

    it should "apply the 3 for the price of 2 offer on Oranges" in {
      val items = List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
      val totalCost = Main.checkout(items)
      totalCost shouldEqual 150
    }

    it should "apply both offers" in {
      val items = List("Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange")
      val totalCost = Main.checkout(items)
      totalCost shouldEqual 240
    }
}
