package mvc.view



import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

import akka.actor.{ActorRef, Props}
import mvc.event.{Event, FillEvent, TextEvent}
import mvc.model.SimpleModel
import mvc.service.SimpleService
import mvc.util.Util

import scala.concurrent.Future
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.StackPane



/**
  * Created by Dragos on 11.04.2016.
  */
class SimpleView extends View{



  implicit val service = List[ActorRef](Util.system.actorOf(Props[SimpleService].withDispatcher("javafx-dispatcher")))

  val model = new SimpleModel()

  private val fillEv = new FillEvent(model.fillProp)
  private val textEv = new TextEvent(model.textProp)


  Util.generalEvents += fillEv



  val stage = new PrimaryStage {
    title = "My Application"
    width = 800
    height = 600
    scene = new Scene {
      onMouseClicked = new EventHandler[MouseEvent]() {
        override def handle(event: MouseEvent): Unit = {
          fillEv.fire()
          textEv.fire()

        }
      }
      fill <== model.fillProp
      root = new StackPane {
        children = List(
          new TextField{
            text <== model.textProp
          }
        )
      }
    }
  }
}
