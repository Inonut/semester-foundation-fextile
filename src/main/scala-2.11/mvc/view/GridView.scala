package mvc.view

import mvc.controller.GridController
import mvc.model.{GeneralModel, GridModel}

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.GridPane

/**
  * Created by Dragos on 14.04.2016.
  */
class GridView {

  GeneralModel.gridModel = new GridModel()

  val model = GeneralModel.gridModel
  val controller = new GridController()




  val stage = new PrimaryStage {
    title = "My Application"
    width = 800
    height = 600
    scene = new Scene {
      root = new GridPane(){
        model.columnConstraints.set(columnConstraints)
        model.rowConstraints.set(rowConstraints)
        model.children.set(children)
      }
    }
  }

}
