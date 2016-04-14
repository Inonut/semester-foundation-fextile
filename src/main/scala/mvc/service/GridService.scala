package mvc.service
import javafx.scene.control.TextField
import javafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints}

import com.sun.javafx.application.PlatformImpl
import mvc.event.{ClearGridEvent, PopulateGridEvent}
import mvc.model.GridModel

import scalafx.application.Platform


/**
  * Created by Dragos on 14.04.2016.
  */
class GridService extends Service{
  override def receive: Receive = {
    case PopulateGridEvent(model: GridModel) =>

      (1 to model.width.value).foreach(i => {
        model.rowConstraints.add(new RowConstraints())
      })

      (1 to model.height.value).foreach(j => {
        model.columnConstraints.add(new ColumnConstraints())
      })

      (1 to model.width.value).foreach(i => {
        (1 to model.height.value).foreach(j => {
          PlatformImpl.runAndWait(new Runnable {
            override def run(): Unit = {
              model.children.add(new TextField() {
                GridPane.setRowIndex(this, i)
                GridPane.setColumnIndex(this, j)
              })
            }
          })
        })
      })
    case ClearGridEvent(model: GridModel) =>
      PlatformImpl.runAndWait(new Runnable {
        override def run(): Unit = {
          model.rowConstraints.clear()
          model.columnConstraints.clear()
          model.children.clear()
        }
      })

  }
}
