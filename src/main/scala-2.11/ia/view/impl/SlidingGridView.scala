package ia.view.impl

import javafx.scene.control.Label
import javafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints}

import ia.model.impl.{SlidingElementModel, SlidingGridModel}
import ia.observable.FXObjectProperty
import ia.view.View
import ia.util.Util.partialFunction3ChangeListener
import ia.util.Util.function1Consumer

/**
  * Created by Dragos on 27.04.2016.
  */
class SlidingGridView extends GridPane with View{


  private def pupulateGrid(model: SlidingGridModel): Unit ={

    (1 to model.width.get).foreach(i => this.getRowConstraints add new RowConstraints)
    (1 to model.height.get).foreach(i => this.getColumnConstraints add new ColumnConstraints)
    for (i <- 1 to model.width.get; j <- 1 to model.height.get) {
      val continer = new SlidingElementView
      val continerModel = new FXObjectProperty[SlidingElementModel]

      GridPane.setRowIndex(continer, i)
      GridPane.setColumnIndex(continer, j)


      continerModel addListener continer.onChange
      continerModel set new SlidingElementModel


      this.getChildren add continer
      model.children add continerModel.get
    }
  }


  def clearGrid() = {
    this.getColumnConstraints.clear()
    this.getRowConstraints.clear()
    this.getChildren.clear()
  }

  def initGrid(model: SlidingGridModel): Unit = {

    var k = 0
    model.children
      .stream()
      .limit(model.width.get * model.height.get - 1)
      .forEach((elem: SlidingElementModel) => {
        k+=1
        elem.title set "" + k
      })
  }

  override def onChange: PartialFunction[Any, Unit] = {
    case (_, _, newValue: SlidingGridModel) =>
      clearGrid()
      pupulateGrid(newValue)
      initGrid(newValue)
  }
}
