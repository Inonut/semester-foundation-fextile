package mvc.controller

import java.util.concurrent.TimeUnit

import akka.util.Timeout

/**
  * Created by Dragos on 19.04.2016.
  */
trait Controller {

  implicit val timeout = new Timeout(10, TimeUnit.SECONDS)
}
