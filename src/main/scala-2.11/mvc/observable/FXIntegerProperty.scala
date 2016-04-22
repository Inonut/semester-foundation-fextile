package mvc.observable

import javafx.beans.property.SimpleIntegerProperty

import mvc.util.Util

/**
  * Created by Dragos on 14.04.2016.
  */
class FXIntegerProperty extends SimpleIntegerProperty{
  override def set(newValue: Int): Unit = Util.fxThread{ super.set(newValue)}
}
