package mvc.model


import javafx.scene.Node
import javafx.scene.layout.{ColumnConstraints, RowConstraints}

import mvc.observable.{FXIntegerProperty, FXListProperty}



/**
  * Created by Dragos on 14.04.2016.
  */
class GridModel {

  val children = new FXListProperty[Node]()

  val rowConstraints = new FXListProperty[RowConstraints]()

  val columnConstraints  = new FXListProperty[ColumnConstraints]()

  val width = new FXIntegerProperty(30)
  val height = new FXIntegerProperty(30)


}
