package mvc

import javafx.application.Application
import javafx.stage.Stage

import mvc.view.SlidingView

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

/**
  * Created by Dragos on 19.04.2016.
  */
object Main extends JFXApp{

  val primaryStage = new PrimaryStage()

  primaryStage.setTitle("My Application")
  primaryStage.setWidth(800)
  primaryStage.setHeight(600)
  primaryStage.setScene(new SlidingView())

  this.stage = primaryStage

}
