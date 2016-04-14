package mvc.event

import java.security.Provider.Service

import akka.actor.ActorRef

import scalafx.event

/**
  * Created by Dragos on 11.04.2016.
  */
trait Event[S] {

  implicit val service: List[ActorRef]
  val source: S

  def fire(): Unit ={
    service.map(s => s ! this)
  }

}

case class FillEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class TextEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class WidthChangeEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class HeightChangeEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class PopulateGridEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
case class ClearGridEvent[S](source: S)(implicit val service: List[ActorRef]) extends Event[S]
