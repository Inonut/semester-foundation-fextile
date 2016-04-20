package mvc.service

import akka.actor.Actor.Receive
import akka.actor.Status.Success
import mvc.model.GridModel

/**
  * Created by Dragos on 19.04.2016.
  */
class GridService extends Service{

  def populateGrid(model: GridModel): Unit = {

  }

  override def receive: Receive = {
    case _ =>
      Thread.sleep(5000)
      println("----")
      sender ! Success(System.nanoTime())
  }
}
