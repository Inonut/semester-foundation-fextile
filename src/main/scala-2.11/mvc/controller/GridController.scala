package mvc.controller

import akka.actor.Props
import akka.pattern.ask
import akka.routing.RoundRobinPool
import mvc.model.GeneralModel
import mvc.service.GridService
import mvc.util.Util

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Dragos on 19.04.2016.
  */
class GridController extends Controller{

  val model = GeneralModel.gridModel
  val service = Util.system.actorOf(Props[GridService].withRouter(RoundRobinPool(10)))



  model.width.onChange(op = (_, oldVal, newVal) => {

    service ? "" flatMap( res => {
      println(res)
      service ? ""
    }) flatMap( res => {
      println(res)
      service ? ""
    }) map ( res => {
      println(res)
    })

  })
}
