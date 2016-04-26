package ia.controller.impl

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

import akka.actor.{Props, ActorRef}
import ia.controller.Controller
import ia.model.GeneralModel
import ia.model.impl.{SlidingElementModel, SlidingGridModel, SlidingModel}
import ia.service.impl.SlidingService
import ia.util.Util
import ia.util.Util.function1Consumer

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingGridController(val model:SlidingGridModel = GeneralModel.slidingGridModel,
                            val service: ActorRef      = Util.system.actorOf(Props[SlidingService])) extends Controller{

  def setOnMouseClickedSlidingElement(): EventHandler[_ >: MouseEvent] = new EventHandler[MouseEvent] {
    override def handle(event: MouseEvent): Unit = {
      println("123")
    }
  }

  def reinit(): Unit = {
    var k = 0
    model.children
      .stream()
      .limit(model.width.get * model.height.get -1)
      .forEach((elem: SlidingElementModel) => elem.title set "" + (k+=1))
  }

  override def init(): Unit = {

  }

  override def bind(): Unit = {

  }
}
