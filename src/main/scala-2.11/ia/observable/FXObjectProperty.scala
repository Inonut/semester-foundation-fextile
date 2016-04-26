package ia.observable

import javafx.beans.property.SimpleObjectProperty

import ia.util.Util


/**
  * Created by Dragos on 13.04.2016.
  */
class FXObjectProperty[T] extends SimpleObjectProperty[T]{
  override def set(newValue: T): Unit = Util.fxThread { super.set(newValue)}
}


