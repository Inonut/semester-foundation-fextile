package ia.view.impl

import javafx.scene.control.Label
import javafx.scene.layout.StackPane

import ia.controller.impl.SlidingElementController
import ia.model.impl.SlidingElementModel
import ia.view.View

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingElementView(val controller: SlidingElementController = new SlidingElementController,
                         val model: SlidingElementModel           = new SlidingElementModel) extends StackPane with View {

  this.getChildren add new Label{
    textProperty().bindBidirectional(model.title)
  }
}
