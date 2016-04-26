package ia.service.impl

import java.util.function.Consumer
import javafx.scene.Node
import javafx.scene.layout.{GridPane, ColumnConstraints, RowConstraints}

import akka.actor.Actor.Receive
import akka.actor.Status.Success
import ia.model.impl.SlidingModel
import ia.service.Service
import ia.util.PopulateGrid

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingService extends Service{

 

  def createGrid(model: SlidingModel) = ???

  def initGrid(model: SlidingModel) = ???

  def clearGrid(model: SlidingModel) = ???

  override def receive: Receive = {
    case PopulateGrid(model: SlidingModel) =>

      clearGrid(model)
      createGrid(model)
      initGrid(model)

      sender ! Success
  }
}
