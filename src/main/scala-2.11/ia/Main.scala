package ia

import javafx.scene.Scene

import ia.model.impl.{SlidingElementModel, SlidingGridModel}
import ia.observable.FXObjectProperty
import ia.view.impl.{SlidingElementView, SlidingGridView}

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import ia.util.Util.partialFunction3ChangeListener

/**
  * Created by Dragos on 4/27/2016.
  */
object Main extends JFXApp{

  val x = new SlidingGridView

  val y = new FXObjectProperty[SlidingGridModel]

  y addListener x.onChange

  y set new SlidingGridModel{
    height set 3
    width set 3
  }

  val primaryStage = new PrimaryStage()

  primaryStage.setTitle("My Application")
  primaryStage.setWidth(800)
  primaryStage.setHeight(600)
  primaryStage.setScene(new Scene(x))

  this.stage = primaryStage

  /*def fct: PartialFunction[Any,Unit] = {
    case (x: Int, y: Int, z: Int) => println(x + y + z)
  }

  fct(1,2,3)*/

}
