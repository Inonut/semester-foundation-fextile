package ia.view

import ia.controller.Controller
import ia.model.Model

/**
  * Created by Dragos on 4/26/2016.
  */
trait View {

  val controller: Controller
  val model: Model
}
