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

  implicit val service = List[ActorRef](Util.system.actorOf(Props[GridService]))

  val model = new GridModel()

  val pupulateGridEv = new PopulateGridEvent(model)
  val clearGridEv = new ClearGridEvent(model)

  model.width.onChange((_, oldVal, newVal) => {
    clearGridEv.fire()
    pupulateGridEv.fire()
  })

  model.height.onChange((_, oldVal, newVal) => {
    clearGridEv.fire()
    pupulateGridEv.fire()
  })


  val stage = new PrimaryStage {
    title = "My Application"
    width = 800
    height = 600
    scene = new Scene {
      root = new GridPane(){
        model.columnConstraints = columnConstraints
        model.rowConstraints = rowConstraints
        model.children = children
      }
    }
  }

}