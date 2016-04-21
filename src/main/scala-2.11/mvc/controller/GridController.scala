package mvc.controller

import akka.actor.{ActorRef, Props}
import akka.pattern.ask
import mvc.game.SlidingGame
import mvc.model.{GeneralModel, GridModel}
import mvc.service.GridService
import mvc.util.Util
import mvc.util.Util.PopulateGrid

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Dragos on 19.04.2016.
  */
class GridController(val model: GridModel = GeneralModel.gridModel, val service: ActorRef = Util.system.actorOf(Props[GridService])) extends Controller{


  //val context = new SlidingGame()


  override def init(): Unit = {
    model.width.value = 3
    model.height.value = 3
  }

  override def bind(): Unit = {
    model.width.onChange( (_, oldVal, newVal) => service ? PopulateGrid(model) onComplete {x=> println(x)})
    model.height.onChange( (_, oldVal, newVal) => service ? PopulateGrid(model))
  }
}

/*service ? "" flatMap( res => {
      println(res)
      service ? ""
    }) flatMap( res => {
      println(res)
      service ? ""
    }) map ( res => {
      println(res)
    })*/
