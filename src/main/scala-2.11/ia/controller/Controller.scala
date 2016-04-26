package ia.controller

import java.util.concurrent.TimeUnit

import akka.util.Timeout

/**
  * Created by Dragos on 4/26/2016.
  */
trait Controller {

  implicit val timeout: Timeout = new Timeout(5, TimeUnit.SECONDS)

  bind()
  init()

  def init(): Unit
  def bind(): Unit
}
