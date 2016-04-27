package ia.view.impl

import javafx.scene.control.Label
import javafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints}

import ia.controller.impl.{SlidingElementController, SlidingGridController}
import ia.model.GeneralModel
import ia.model.impl.{SlidingElementModel, SlidingGridModel}
import ia.util.Util
import ia.view.View

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingGridView extends GridPane with View {

  override def init(): Unit = {
    this.model.set(new SlidingGridModel)
    this.controller.set(new SlidingGridController)
  }

  override def bindToGlobal(): Unit = {
    GeneralModel.slidingGridModel set this.model.get.asInstanceOf[SlidingGridModel]
    super.bindToGlobal()
  }

  override def buildView = {

    case (model: SlidingGridModel, controller: SlidingGridController) =>

      this setStyle ""

      (1 to model.width.get).foreach(i => this.getRowConstraints add new RowConstraints)
      (1 to model.height.get).foreach(i => this.getColumnConstraints add new ColumnConstraints)
      for (i <- 1 to model.width.get; j <- 1 to model.height.get) {
        val continer = new SlidingElementView

        GridPane.setRowIndex(continer, i)
        GridPane.setColumnIndex(continer, j)

        continer.setOnMouseClicked(controller.setOnMouseClickedSlidingElement())

        this.getChildren add continer
        model.children add continer.model.get.asInstanceOf[SlidingElementModel]
      }

  }
}

