package mvc.util

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

/**
  * Created by Dragos on 19.04.2016.
  */
object Util {

  val system = ActorSystem("mvc",ConfigFactory.load)

}
