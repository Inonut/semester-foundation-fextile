package mvc.controller

import akka.actor.Props
import akka.pattern.ask
import mvc.model.GeneralModel
import mvc.service.GridService
import mvc.util.Util
import mvc.util.Util.PopulateGrid

/**
  * Created by Dragos on 19.04.2016.
  */
class GridController extends Controller{

  val model = GeneralModel.gridModel
  val service = Util.system.actorOf(Props[GridService])

  model.width.onChange( (_, oldVal, newVal) => service ? PopulateGrid(model))
  model.height.onChange( (_, oldVal, newVal) => service ? PopulateGrid(model))

  model.width.value = 30
  model.height.value = 30
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
