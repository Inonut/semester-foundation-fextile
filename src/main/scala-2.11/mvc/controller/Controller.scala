package mvc.controller

import java.util.concurrent.TimeUnit

import akka.util.Timeout

import scala.concurrent.duration.{Duration, FiniteDuration}

/**
  * Created by Dragos on 19.04.2016.
  */
trait Controller {

  implicit val timeout: Timeout = new Timeout(5, TimeUnit.SECONDS)

  bind()
  init()

  def init()

  def bind()
}
