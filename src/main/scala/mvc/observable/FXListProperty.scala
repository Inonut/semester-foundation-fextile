package mvc.observable

import javafx.beans.property.{ListProperty, SimpleListProperty}
import javafx.collections.ObservableList

import com.sun.javafx.application.PlatformImpl

/**
  * Created by Dragos on 14.04.2016.
  */
class FXListProperty[E] extends SimpleListProperty[E]{


  override def clear(): Unit = {
    PlatformImpl.runAndWait(new Runnable {
      override def run(): Unit = {
        clearr()
      }
    })
  }

  override def add(element: E): Boolean = {
    var result = false
    PlatformImpl.runAndWait(new Runnable {
      override def run(): Unit = {
        result = addd(element)
      }
    })
    result
  }

  override def set(newValue: ObservableList[E]): Unit = {
    PlatformImpl.runAndWait(new Runnable {
      override def run(): Unit = {
        sett(newValue)
      }
    })
  }

  private def sett(newValue: ObservableList[E]): Unit = super.set(newValue)
  private def addd(element: E): Boolean = super.add(element)
  private def clearr(): Unit = super.clear()

}
