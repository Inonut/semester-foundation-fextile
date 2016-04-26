package ia.view.impl

import javafx.scene.Scene
import javafx.scene.layout.{GridPane, Pane, VBox}

import ia.controller.impl.SlidingController
import ia.model.GeneralModel
import ia.model.impl.{SlidingGridModel, SlidingElementModel, SlidingModel}
import ia.util.Util
import ia.view.View

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingView(val controller: SlidingController = new SlidingController,
                  val model: SlidingModel           = Util.default(GeneralModel.slidingModel, new SlidingModel)) extends Scene(new Pane) with View{

  GeneralModel.slidingModel = model

  private val root = new VBox{
    this setStyle ""
    getChildren add new SlidingGridView(model = new SlidingGridModel{
      width set 3
      height set 3
    })
  }

  this setRoot root
}
