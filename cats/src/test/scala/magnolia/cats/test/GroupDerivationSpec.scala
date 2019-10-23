package magnolia.cats.test

import cats._
import cats.instances.all._
import cats.kernel.laws.discipline._
import magnolia.cats.auto._
import magnolia.scalacheck.auto._
import magnolia.test.SerializableUtils
import magnolia.test.Simple._
import org.scalacheck._

import scala.reflect._

object GroupDerivationSpec extends Properties("GroupDerivation") {
  private def test[T: Arbitrary : ClassTag : Eq : Group]: Unit = {
    SerializableUtils.ensureSerializable(implicitly[Group[T]])
    val name = classTag[T].runtimeClass.getSimpleName
    include(GroupTests[T].semigroup.all, s"$name.")
  }

  test[Integers]
}