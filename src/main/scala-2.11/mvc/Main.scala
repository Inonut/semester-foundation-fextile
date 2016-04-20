package mvc

import mvc.view.GridView

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

/**
  * Created by Dragos on 19.04.2016.
  */
object Main extends JFXApp{

  stage = new PrimaryStage {
    title = "My Application"
    width = 800
    height = 600
    scene = new GridView()
  }
}
