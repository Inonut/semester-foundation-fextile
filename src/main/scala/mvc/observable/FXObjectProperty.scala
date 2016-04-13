package mvc.observable


import com.sun.javafx.application.PlatformImpl

import scalafx.application.Platform
import scalafx.beans.property.ObjectProperty


/**
  * Created by Dragos on 13.04.2016.
  */
class FXObjectProperty[T] extends ObjectProperty[T]{

  override def value_=(v: T): Unit = {
    Platform.runLater{
      super.value_=(v)
    }
  }
}


object Test{
  def main(args: Array[String]) {

    var x = new FXObjectProperty[String]()

    println(x.value)

    x.value = "123"

    println(x.value)
  }
}