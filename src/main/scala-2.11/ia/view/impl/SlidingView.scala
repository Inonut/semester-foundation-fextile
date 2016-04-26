package ia.view.impl

import javafx.scene.Scene
import javafx.scene.layout.{Pane, VBox}

import ia.controller.Controller
import ia.controller.impl.{SlidingController, SlidingGridController}
import ia.model.{GeneralModel, Model}
import ia.model.impl.{SlidingGridModel, SlidingModel}
import ia.util.Util
import ia.view.View

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingView extends Scene(new Pane) with View {


  override def init(): Unit = {
    this.model set new SlidingModel
    this.controller set new SlidingController
  }

  override def buildView: PartialFunction[(Model, Controller), Unit] = {
    case (model: SlidingModel, controller: SlidingController) =>

      val root = new VBox {
        this setStyle ""
        getChildren add new SlidingGridView
      }

      this setRoot root
  }
}
