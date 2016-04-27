package ia.view.impl

import javafx.scene.control.Label
import javafx.scene.layout.StackPane

import ia.controller.impl.SlidingElementController
import ia.model.Model
import ia.model.impl.SlidingElementModel
import ia.view.View

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingElementView extends StackPane with View {
  override def init(): Unit = {
    this.model.set(new SlidingElementModel)
  }

  override def buildView = {

    case (model: SlidingElementModel, controller: SlidingElementController) =>

      this.getChildren add new Label {
        textProperty().bindBidirectional(model.title)
      }

  }
}
