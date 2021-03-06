package ia.observable

import javafx.beans.property.SimpleListProperty
import javafx.collections.{FXCollections, ObservableList}

import ia.util.Util

/**
  * Created by Dragos on 14.04.2016.
  */
class FXListProperty[E] extends SimpleListProperty[E](FXCollections.observableArrayList()){

  override def clear(): Unit = {
    Util.fxThread{super.clear()}
  }

  override def add(element: E): Boolean = {
    var result = false
    Util.fxThread { result = super.add(element) }
    result
  }

  override def set(newValue: ObservableList[E]): Unit = {
    Util.fxThread { super.set(newValue) }
  }

}
