package mvc.util

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import mvc.event.Event

import scala.collection.mutable.ListBuffer
import scalafx.scene.control.TextField
import scalafx.scene.layout.{ColumnConstraints, Pane, RowConstraints, StackPane}
import scalafx.scene.paint.Color

/**
  * Created by Dragos on 11.04.2016.
  */
object Util {

  val system = ActorSystem("mvc",ConfigFactory.load)

  val generalEvents = ListBuffer[Event[_]]()

  val colConst = new ColumnConstraints{

  }

  val rowConst = new RowConstraints{

  }

  val elemGrid = new StackPane(){
    children = List(
      new TextField()
    )
  }

}
