package ia

import ia.observable.FXListProperty
import ia.view.impl.SlidingView

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

/**
  * Created by Dragos on 19.04.2016.
  */
object Main extends JFXApp{

  val s = new FXListProperty[Int]

  s.add(4)
  s.add(4)
  s.add(4)

  val primaryStage = new PrimaryStage()

  primaryStage.setTitle("My Application")
  primaryStage.setWidth(800)
  primaryStage.setHeight(600)
  primaryStage.setScene(new SlidingView())

  this.stage = primaryStage

}
