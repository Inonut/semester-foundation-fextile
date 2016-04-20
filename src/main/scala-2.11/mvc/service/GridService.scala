package mvc.service



import java.util.function.Consumer
import javafx.scene.Node

import akka.actor.Status.Success
import mvc.model.GridModel
import mvc.util.Util.PopulateGrid
import mvc.view.SlidingElement

import scala.collection.mutable.ListBuffer
import scalafx.scene.control.Label
import scalafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints, StackPane}

/**
  * Created by Dragos on 19.04.2016.
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

        val continer = new SlidingElement()

        GridPane.setRowIndex(continer,i)
        GridPane.setColumnIndex(continer,j)

        model.children.add(continer)
      })
    })

  }

  def clearGrid(model: GridModel): Unit =  {
    model.rowConstraints.clear()
    model.columnConstraints.clear()
    model.children.clear()
  }

  override def receive: Receive = {
    case PopulateGrid(model: GridModel) =>

      clearGrid(model)
      populateGrid(model)

      sender ! Success
  }
}

