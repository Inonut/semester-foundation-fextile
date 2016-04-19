package mvc.observable

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
    Platform.runLater{
      super.value_=(v)
    }
  }
}
