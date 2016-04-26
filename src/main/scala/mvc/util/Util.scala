package mvc.util

import javafx.{scene => jfxs}

import akka.actor.ActorSystem
import com.sun.javafx.application.PlatformImpl
import com.typesafe.config.ConfigFactory
import mvc.model.GridModel

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



  case class PopulateGrid(model: GridModel)
}
