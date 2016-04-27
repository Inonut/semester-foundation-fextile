package ia.model.impl

import ia.observable.{FXIntegerProperty, FXListProperty}

/**
  * Created by Dragos on 27.04.2016.
  */
class SlidingGridModel {

  val width = new FXIntegerProperty
  val height = new FXIntegerProperty

  val children = new FXListProperty[SlidingElementModel]
}
