package mvc.controller

import akka.actor.Props
import akka.pattern.ask
import mvc.model.{GeneralModel, GridModel}
import mvc.service.GridService
import mvc.util.Util
import mvc.util.Util.PopulateGrid

/**
  * Created by Dragos on 19.04.2016.
  */
class GridController(val model: GridModel = GeneralModel.gridModel) extends Controller{

  val service = Util.system.actorOf(Props[GridService])

  bind()
  init()


  override def init(): Unit = {
    model.width.value = 3
    model.height.value = 3
  }

  override def bind(): Unit = {
    model.width.onChange( (_, oldVal, newVal) => service ? PopulateGrid(model))
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
