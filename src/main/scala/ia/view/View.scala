package ia.view

import ia.controller.Controller
import ia.model.Model
import ia.observable.FXObjectProperty

/**
  * Created by Dragos on 4/26/2016.
  */
trait View {

  val controller = new FXObjectProperty[Controller]
  val model = new FXObjectProperty[Model]

  def init(): Unit
  def bindToGlobal(): Unit = { this.controller.get.start() }
  def buildView: PartialFunction[Tuple2[Model,Controller], Unit]

  init()
  bindToGlobal()
  buildView(Tuple2(model.get, controller.get))

}
