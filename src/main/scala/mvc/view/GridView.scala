package mvc.view



import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.TextField

import akka.actor.{ActorRef, Props}
import mvc.event.{ClearGridEvent, PopulateGridEvent}
import mvc.model.GridModel
import mvc.service.GridService
import mvc.util.Util

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.{GridPane, VBox}

/**
  * Created by Dragos on 14.04.2016.
  */
class GridView {

  //service
  implicit val service = List[ActorRef](Util.system.actorOf(Props[GridService]))

  //model
  val model = new GridModel()

  //event
  val pupulateGridEv = new PopulateGridEvent(model)
  val clearGridEv = new ClearGridEvent(model)

  Util.generalEvents += clearGridEv

  //bind
  model.width.onChange((_, oldVal, newVal) => {
    pupulateGridEv.fire()
  })

  model.height.onChange((_, oldVal, newVal) => {
    pupulateGridEv.fire()
  })

  //view
  val stage = new PrimaryStage {
    title = "My Application"
    width = 800
    height = 600
    scene = new Scene {
      root = new GridPane(){
        model.columnConstraints.set(columnConstraints)
        model.rowConstraints.set(rowConstraints)
        model.children.set(children)
      }
    }
  }

}
