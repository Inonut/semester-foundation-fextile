package mvc.controller

import javafx.beans.value.{ChangeListener, ObservableValue}

import akka.actor.{ActorRef, Props}
import akka.pattern.ask
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
    model.width.set(4)
    model.height.set(4)
  }

  override def bind(): Unit = {

    model.width.addListener(new ChangeListener[Number] {
      override def changed(observable: ObservableValue[_ <: Number], oldValue: Number, newValue: Number): Unit = service ? PopulateGrid(model)
    })

    model.height.addListener(new ChangeListener[Number] {
      override def changed(observable: ObservableValue[_ <: Number], oldValue: Number, newValue: Number): Unit = service ? PopulateGrid(model)
    })
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
