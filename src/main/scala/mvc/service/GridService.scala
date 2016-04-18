package mvc.service
import javafx.scene.control.TextField
import javafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints}

import akka.actor.Status.Success
import mvc.event.{ClearGridEvent, Event, PopulateGridEvent}
import mvc.model.GridModel
import mvc.util.Util
import akka.pattern.ask

import scala.async.Async.async
import scala.concurrent.Future


/**
  * Created by Dragos on 14.04.2016.
  */
class GridService extends Service{


  def populateGrid(model: GridModel): Unit =  {
    (1 to model.width.value).foreach(i => {
      model.rowConstraints.add(new RowConstraints())
    })

    (1 to model.height.value).foreach(j => {
      model.columnConstraints.add(new ColumnConstraints())
    })

    (1 to model.width.value).foreach(i => {
      (1 to model.height.value).foreach(j => {
        model.children.add(new TextField(){
          GridPane.setRowIndex(this,i)
          GridPane.setColumnIndex(this,j)
        })
      })
    })
  }

  def clearGrid(model: GridModel): Unit =  {
    model.rowConstraints.clear()
    model.columnConstraints.clear()
    model.children.clear()
  }

  override def receive: Receive = {
    case PopulateGridEvent(model: GridModel) =>



    case ClearGridEvent(model: GridModel) =>

      clearGrid(model)
      sender ! Success("ClearGridEvent")
  }

}
