package mvc

import com.sun.javaws.jnl.JavaFXAppDesc
import mvc.util.Util
import mvc.view.{GridView, SimpleView}

import scalafx.application.JFXApp
import scalafx.scene.paint.Color

/**
  * Created by Dragos on 11.04.2016.
  */
object Main extends JFXApp{

  val view = new GridView()

  //view.events.map(e=>e.fire())

  //Util.generalEvents.map(e => e.fire())

  stage = view.stage

}
