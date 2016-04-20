package mvc.controller

import akka.actor.Props
import akka.pattern.ask
import mvc.model.GeneralModel
import mvc.service.GridService
import mvc.util.Util

import scala.async.Async.await
import scala.async.Async.async
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, Promise}
import scala.util.Try

/**
  * Created by Dragos on 19.04.2016.
  */
class GridController extends Controller{

  val model = GeneralModel.gridModel
  val service = Util.system.actorOf(Props[GridService])



  model.width.onChange(op = (_, oldVal, newVal) => {
    /*async {
      val fct = {
        service ? _
      } andThen { x =>
        println(Await.result(x,timeout.duration))
        service ? "123"
      } andThen { x =>
        println(Await.result(x,timeout.duration))
      }

      fct("asll")
    }*/


    val fct1: Future[Any] => Future[Any] = x => {
      x.onComplete(res => {
        println(res)
        service ? res
      })
    }
    val fct2: Future[Any] => Future[Any] = x => {
      println(x)
      service ? x
    }
    val fct3: Future[Any] => Unit = x => println(x)

    val fct = fct1 andThen fct2 andThen fct3

    fct(Future{123})

  })
}
