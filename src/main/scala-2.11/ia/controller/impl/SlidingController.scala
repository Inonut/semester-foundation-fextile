package ia.controller.impl

import javafx.beans.value.ObservableValue

import akka.actor.{ActorRef, Props}
import ia.controller.Controller
import ia.model.GeneralModel
import ia.model.impl.SlidingModel
import ia.service.impl.SlidingService
import ia.util.{PopulateGrid, Util}
import akka.pattern.ask
import ia.util.Util.function3ChangeListener

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingController extends Controller{


  override def init(): Unit = {
    //model.width set 3
    //model.height set 3
  }

  override def bind(): Unit = {
    //model.width addListener ((observable: ObservableValue[_ <: Number], oldValue: Number, newValue: Number) => service ? PopulateGrid(model))
   // model.height addListener ((observable: ObservableValue[_ <: Number], oldValue: Number, newValue: Number) => service ? PopulateGrid(model))
  }
}
