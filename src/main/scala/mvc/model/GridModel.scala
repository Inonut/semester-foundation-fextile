package mvc.model


import javafx.beans.binding.ListBinding
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.{ColumnConstraints, RowConstraints}

import mvc.observable.FXIntegerProperty



/**
  * Created by Dragos on 14.04.2016.
  */
class GridModel {

  var children: ObservableList[Node] = null

  var rowConstraints: ObservableList[RowConstraints] = null

  var columnConstraints: ObservableList[ColumnConstraints] = null

  val width = new FXIntegerProperty(30)
  val height = new FXIntegerProperty(30)


}
