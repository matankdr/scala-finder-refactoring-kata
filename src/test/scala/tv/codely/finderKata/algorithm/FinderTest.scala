package tv.codely.finderKata.algorithm

import java.util.ArrayList
import com.github.nscala_time.time.Imports._
import org.scalatest._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class FinderTest extends AnyWordSpec with BeforeAndAfterEach with Matchers {

  var sue: Thing = new Thing()
  var greg: Thing = new Thing()
  var sarah: Thing = new Thing()
  var mike: Thing = new Thing()

  override def beforeEach(): Unit = {
    sue.name = "Sue"
    sue.birthDate = DateTime.parse("1950-01-01")

    greg.name = "Greg"
    greg.birthDate = DateTime.parse("1952-05-01")
    sarah.name = "Sarah"
    sarah.birthDate = DateTime.parse("1982-01-01")
    mike.name = "Mike"
    mike.birthDate = DateTime.parse("1979-01-01")
  }

  "Finder" should {
    "Return empty results when given empty list" in {
      val list = new ArrayList[Thing]()

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe null
      result.P2 shouldBe null
    }

    "Return empty results when given one person" in {
      val list = new ArrayList[Thing]()
      list.add(sue)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe null
      result.P2 shouldBe null
    }

    "Return closest two for two people" in {
      val list = new ArrayList[Thing]()
      list.add(sue)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe sue
      result.P2 shouldBe greg
    }

    "Return furthest two for two people" in {
      val list = new ArrayList[Thing]()
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.Two)

      result.P1 shouldBe greg
      result.P2 shouldBe mike
    }

    "Return furthest two for four people" in {
      val list = new ArrayList[Thing]()
      list.add(sue)
      list.add(sarah)
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.Two)

      result.P1 shouldBe sue
      result.P2 shouldBe sarah
    }

    "Return closest two for four people" in {
      val list = new ArrayList[Thing]()
      list.add(sue)
      list.add(sarah)
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)


      result.P1 shouldBe sue
      result.P2 shouldBe greg
    }
  }
}

