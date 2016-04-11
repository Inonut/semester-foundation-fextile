package mvc.service
import javafx.scene.paint.{Color, Paint}

import com.sun.javafx.application.PlatformImpl
import mvc.event.{FillEvent, TextEvent}
import mvc.util.Util

import scala.concurrent.Future
import scala.util.Random
import scalafx.application.Platform
import scalafx.beans.property.{ObjectProperty, StringProperty}

/**
  * Created by Dragos on 11.04.2016.
  */
class SimpleService extends Service{

  //implicit val fxExecutionContext = Util.fxExecutionContext

  private val r = new Random()

  override def receive: Receive = {
    case FillEvent(source: ObjectProperty[Paint]) =>
      source.value = new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),r.nextDouble())
    case TextEvent(source: StringProperty) =>


        println(Thread.currentThread())
        //while(true){
          //Thread.sleep(100)
          source.value = (source.value.toInt + 1).toString
        Thread.sleep(10000)
        //}

      //Thread.sleep(10000)
  }
}
