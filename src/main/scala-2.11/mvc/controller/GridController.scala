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


  model.width.onChange((_, oldVal, newVal) => {
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


    service ? "asll" andThen  { case x =>
      println(x)
      service ? "123" andThen {
        case x => println(x)
      }
    }


  })
}
