package mvc.view

import mvc.controller.SlidingElementController
import mvc.model.{GeneralModel, SlidingElementModel}

import scalafx.scene.control.Label
import scalafx.scene.layout.StackPane

/**
  * Created by Dragos on 20.04.2016.
  */
class SlidingElement extends StackPane{

  val model = new SlidingElementModel()
  val controller = new SlidingElementController(model)


  children = List(
    new Label {
      text <== model.text
    }
  )

}
