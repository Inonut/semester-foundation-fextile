package mvc

import mvc.util.Util
import mvc.view.GridView

import scala.async.Async.async
import scala.async.Async.await
import scala.concurrent.{Await, ExecutionContext, Future}
import scalafx.application.JFXApp
import scala.concurrent.ExecutionContext.Implicits.global
import scalafx.beans.property.IntegerProperty

/**
  * Created by Dragos on 11.04.2016.
  */
object Main extends JFXApp {

 /* val view = new GridView()

  stage = view.stage;*/

  def fct1(a: Future[Int]): Future[Int] = async {
    Thread.sleep(5000)
    await(a) * 2
  }
  def fct2(a: Future[Int]): Future[Int] = async {
    await(a) + 5;
  }


  def fct3(a: Int): Int = {
    Thread.sleep(5000)
    a * 2
  }
  def fct4(a: Int): Int = {
    a + 5
  }

  println("------")

  val q = fct1 _ andThen fct2 _ andThen fct2 _


  async {
    println(fct3(5))
  } andThen {
    case _ => async {println(fct4(10))}
  }

  q(Future{5}).onComplete(x=>println(x))


  println("------")


  /*stage = null

  implicit val ec = ExecutionContext.Implicits.global

  var asd = new IntegerProperty()
  asd.onChange((_, oldVal, newVal) => println(newVal))

  future(asd)
  future(asd)


  println("----")


  def future(param: IntegerProperty): Unit = async {
    Thread.sleep(5000)

    param.synchronized {
      for (i <- 1 to 10) {
        println("----" + i)

        param.value = param.value + 1
      }
    }


    //future(param)
  }*/

}


