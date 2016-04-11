package mvc.util

import java.util.concurrent.Executor
import javafx.application

import akka.actor.ActorSystem
import com.sun.javafx.application.PlatformImpl
import com.typesafe.config.ConfigFactory
import mvc.event.Event
import semester.foundation.fextile.application.Fextile

import scala.collection.mutable.ListBuffer
import scala.concurrent.{ExecutionContext, Future}
import scalafx.application.Platform

/**
  * Created by Dragos on 11.04.2016.
  */
object Util {

  val system = ActorSystem("mvc",ConfigFactory.load)

  val generalEvents = ListBuffer[Event[_]]()

  def fxExecutionContext: ExecutionContext = {
    ExecutionContext.fromExecutor(
      new Executor {
        override def execute(command: Runnable): Unit = {
          Future {
            PlatformImpl.runAndWait(command)
          }(Fextile.system.dispatcher)
        }
      }
    )
  }

}
