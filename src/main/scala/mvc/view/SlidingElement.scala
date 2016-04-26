package mvc.view

import javafx.scene.control.Label
import javafx.scene.layout.StackPane

import mvc.controller.SlidingElementController
import mvc.model.SlidingElementModel


/**
  * Created by Dragos on 20.04.2016.
  */
class SlidingElement extends StackPane{

  val model = new SlidingElementModel()
  val controller = new SlidingElementController(model)


  getChildren.addAll(new Label(){
    textProperty().bindBidirectional(model.text)
  })

}
