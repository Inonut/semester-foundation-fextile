package mvc.model

import javafx.scene.paint.Paint

import mvc.observable.{FXObjectProperty, FXStringProperty}

import scalafx.beans.property.{ObjectProperty, StringProperty}

/**
  * Created by Dragos on 11.04.2016.
  */
class SimpleModel {

  val fillProp = new FXObjectProperty[Paint]()
  val textProp = new FXStringProperty("0")
}
