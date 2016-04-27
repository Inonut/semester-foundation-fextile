package ia

import javafx.scene.Scene

import ia.model.impl.SlidingElementModel
import ia.observable.FXObjectProperty
import ia.view.impl.SlidingElementView

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

/**
  * Created by Dragos on 4/27/2016.
  */
object Main extends JFXApp{

  val x = new SlidingElementView

  val y = new FXObjectProperty[SlidingElementModel]

  y addListener x

  y set new SlidingElementModel

  val primaryStage = new PrimaryStage()

  primaryStage.setTitle("My Application")
  primaryStage.setWidth(800)
  primaryStage.setHeight(600)
  primaryStage.setScene(new Scene(x))

  this.stage = primaryStage

}
