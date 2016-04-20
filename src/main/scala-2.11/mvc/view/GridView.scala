package mvc.view

import mvc.controller.GridController
import mvc.model.{GeneralModel, GridModel}

import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.layout.{GridPane, Priority, StackPane}

/**
  * Created by Dragos on 14.04.2016.
  */
class GridView extends Scene{

  GeneralModel.gridModel = new GridModel()

  val model = GeneralModel.gridModel
  val controller = new GridController()


  root = new GridPane(){
    alignment = Pos.Center
    model.columnConstraints.set(columnConstraints)
    model.rowConstraints.set(rowConstraints)
    model.children.set(children)
  }


}
