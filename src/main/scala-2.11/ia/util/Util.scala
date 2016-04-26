package ia.util

import java.util.function.Consumer
import javafx.beans.value.{ObservableValue, ChangeListener}
import javafx.{scene => jfxs}

import akka.actor.ActorSystem
import com.sun.javafx.application.PlatformImpl
import com.typesafe.config.ConfigFactory

/**
  * Created by Dragos on 19.04.2016.
  */
object Util {


  val system = ActorSystem("mvc",ConfigFactory.load)

  def fxThread[R](op: => R) {
    PlatformImpl.runAndWait(new Runnable {
      override def run(): Unit = op
    })
  }

  implicit def function3ChangeListener[T](f: (ObservableValue[_ <: T], T, T) => Any) = new ChangeListener[T] {
    override def changed(observable: ObservableValue[_ <: T], oldValue: T, newValue: T): Unit = f(observable,oldValue,newValue)
  }

  implicit def function1Consumer[T](f: T => Any) = new Consumer[T] {
    override def accept(t: T): Unit = f(t)
  }

  def default[T](elem1: T, elem2: T): T ={
    if(elem1 != null){
      elem1
    } else {
      elem2
    }
  }
}
