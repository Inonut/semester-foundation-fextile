package mvc.view

import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.{GridPane, Pane}

import mvc.controller.GridController
import mvc.model.{GeneralModel, GridModel}

/**
  * Created by Dragos on 14.04.2016.
  */
class SlidingView extends Scene(new Pane){

  GeneralModel.gridModel = new GridModel()

  val model = GeneralModel.gridModel
  val controller = new GridController()

  setRoot(new GridPane(){
    setAlignment(Pos.CENTER)
    model.columnConstraints.set(getColumnConstraints)
    model.rowConstraints.set(getRowConstraints)
    model.children.set(getChildren)
  })


}
