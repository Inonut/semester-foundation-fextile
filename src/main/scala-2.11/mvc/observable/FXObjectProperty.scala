package mvc.observable

import mvc.util.Util

import scalafx.application.Platform
import scalafx.beans.property.ObjectProperty


/**
  * Created by Dragos on 13.04.2016.
  */
class FXObjectProperty[T] extends ObjectProperty[T]{

  override def value_=(v: T): Unit = {
    Util.fxThread ( super.value_=(v))
  }
}


