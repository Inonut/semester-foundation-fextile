package mvc.observable

import scalafx.application.Platform
import scalafx.beans.property.IntegerProperty

/**
  * Created by Dragos on 14.04.2016.
  */
class FXIntegerProperty extends IntegerProperty{

  def this(initialValue: Int) {
    this()
    value = initialValue
  }

  override def value_=(v: Int): Unit = {
    Platform.runLater{
      super.value_=(v)
    }
  }
}
