package mvc.model

import javafx.scene.paint.Paint

import scalafx.beans.property.{ObjectProperty, StringProperty}

/**
  * Created by Dragos on 11.04.2016.
  */
class SimpleModel {

  val fillProp = new ObjectProperty[Paint]()
  val textProp = new StringProperty("0")
}
