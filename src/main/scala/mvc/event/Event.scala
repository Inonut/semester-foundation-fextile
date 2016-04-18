package mvc.event

import java.util.concurrent.TimeUnit

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future

/**
  * Created by Dragos on 11.04.2016.
  */
trait Event[S] {

  private implicit val timeout = new Timeout(10, TimeUnit.SECONDS)
  private val serviceFuture = ListBuffer[Future[Any]]()

  implicit val service: Seq[ActorRef]
  val source: S


  def fire(): Event[S] = {
    serviceFuture ++= service.map(s =>  s ? this)
    this
  }
}

case class FillEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class TextEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class WidthChangeEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class HeightChangeEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class PopulateGridEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class ClearGridEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
