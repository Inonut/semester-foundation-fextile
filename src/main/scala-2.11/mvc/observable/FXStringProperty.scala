package mvc.observable

import mvc.util.Util

import scalafx.application.Platform
import scalafx.beans.property.StringProperty

/**
  * Created by Dragos on 13.04.2016.
  */
class FXStringProperty extends StringProperty{

  def this(initialValue: String) {
    this()
    value = initialValue
  }

  override def value_=(v: String): Unit = {
    Util.fxThread ( super.value_=(v))
  }
}
