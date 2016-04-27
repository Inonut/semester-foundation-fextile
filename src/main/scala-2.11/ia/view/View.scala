package ia.view

/**
  * Created by Dragos on 4/27/2016.
  */
trait View {

  def onChange: PartialFunction[Any, Unit]

}
