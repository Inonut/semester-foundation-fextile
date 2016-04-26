package mvc.service



import java.util.function.Consumer
import javafx.scene.Node
import javafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints}

import akka.actor.Status.Success
import mvc.model.GridModel
import mvc.util.Util.PopulateGrid
import mvc.view.SlidingElement

/**
  * Created by Dragos on 19.04.2016.
  */
class GridService extends Service{

  def populateGrid(model: GridModel): Unit =  {
    (1 to model.width.get).foreach(i => {
      model.rowConstraints.add(new RowConstraints)
    })

    (1 to model.height.get).foreach(j => {
      model.columnConstraints.add(new ColumnConstraints)
    })

    (1 to model.width.get).foreach(i => {
      (1 to model.height.get).foreach(j => {

        val continer = new SlidingElement()

        GridPane.setRowIndex(continer,i)
        GridPane.setColumnIndex(continer,j)

        model.children.add(continer)
      })
    })

    var k = 0
    model.children.stream().limit(model.width.get*model.height.get-1).forEach(new Consumer[Node] {
      override def accept(t: Node): Unit = t match {
        case x: SlidingElement =>
          k+=1
          x.model.text.set(k.toString)
      }
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
    case _ => println("----")
  }
}

