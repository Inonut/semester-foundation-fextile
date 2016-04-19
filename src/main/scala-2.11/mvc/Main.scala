package mvc

import javafx.embed.swing.JFXPanel

import mvc.model.GeneralModel
import mvc.util.Util
import mvc.view.GridView

import scalafx.application.JFXApp
import scalafx.scene.layout.Pane

/**
  * Created by Dragos on 19.04.2016.
  */
object Main extends JFXApp{

  stage = new GridView().stage

  //GeneralModel.gridModel.width.value = 5
}
