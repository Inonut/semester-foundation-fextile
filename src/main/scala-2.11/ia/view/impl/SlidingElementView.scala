package ia.view.impl

import javafx.beans.value.{ObservableValue, ChangeListener}
import javafx.scene.control.Label
import javafx.scene.layout.StackPane

import ia.model.impl.SlidingElementModel
import ia.view.View

/**
  * Created by Dragos on 4/27/2016.
  */
class SlidingElementView extends StackPane with View{

  override def onChange: PartialFunction[Any, Unit] = {
    case (_, _, newValue: SlidingElementModel) =>
      this.getChildren add new Label{
        this.textProperty bindBidirectional newValue.title
      }

  }
}
