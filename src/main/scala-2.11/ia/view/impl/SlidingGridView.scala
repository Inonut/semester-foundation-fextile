package ia.view.impl

import javafx.scene.Scene
import javafx.scene.layout.{RowConstraints, ColumnConstraints, GridPane, Pane}

import ia.controller.impl.{SlidingGridController, SlidingController}
import ia.model.GeneralModel
import ia.model.impl.{SlidingGridModel, SlidingModel}
import ia.service.impl.SlidingGridService
import ia.util.Util
import ia.view.View

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingGridView(val controller: SlidingGridController = new SlidingGridController,
                      val model: SlidingGridModel           = Util.default(GeneralModel.slidingGridModel, new SlidingGridModel)) extends GridPane with View {

  GeneralModel.slidingGridModel = model


  this setStyle ""

  (1 to model.width.get).foreach(i => this.getRowConstraints add new RowConstraints)
  (1 to model.height.get).foreach(i => this.getColumnConstraints add new ColumnConstraints)
  for(i <- 1 to model.width.get; j <- 1 to model.height.get) {
    val continer = new SlidingElementView

    GridPane.setRowIndex(continer,i)
    GridPane.setColumnIndex(continer,j)

    continer.setOnMouseClicked(this.controller.setOnMouseClickedSlidingElement())

    this.getChildren add continer
    this.model.children add continer.model
  }

  this.controller.reinit()
}

