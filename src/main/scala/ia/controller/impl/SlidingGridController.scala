package ia.controller.impl

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

import akka.actor.{ActorRef, Props}
import ia.controller.Controller
import ia.model.GeneralModel
import ia.model.impl.{SlidingElementModel, SlidingGridModel}
import ia.service.impl.SlidingService
import ia.util.Util
import ia.util.Util.function1Consumer

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingGridController extends Controller {


  val service: ActorRef = Util.system.actorOf(Props[SlidingService])

  def setOnMouseClickedSlidingElement(): EventHandler[_ >: MouseEvent] = new EventHandler[MouseEvent] {
    override def handle(event: MouseEvent): Unit = {
      println("123")
    }
  }

  override def init(): Unit = {
    val model: SlidingGridModel = GeneralModel.slidingGridModel.get

    var k = 0
    model.children
      .stream()
      .limit(model.width.get * model.height.get - 1)
      .forEach((elem: SlidingElementModel) => elem.title set "" + (k += 1))
  }

  override def bind(): Unit = {

  }
}
