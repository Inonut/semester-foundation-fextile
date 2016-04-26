package ia.model

import ia.model.impl.{SlidingGridModel, SlidingModel}
import mvc.observable.FXObjectProperty

/**
  * Created by Dragos on 4/26/2016.
  */
object GeneralModel{

  val slidingModel = new FXObjectProperty[SlidingModel]
  val slidingGridModel = new FXObjectProperty[SlidingGridModel]
}
