package ia.model.impl

import ia.model.Model
import ia.observable.{FXListProperty, FXIntegerProperty}

/**
  * Created by Dragos on 4/26/2016.
  */
class SlidingGridModel extends Model{

  val width = new FXIntegerProperty
  val height = new FXIntegerProperty

  val children = new FXListProperty[SlidingElementModel]
}
