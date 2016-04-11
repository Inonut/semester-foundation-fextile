package mvc.util

import java.util
import java.util.Collections
import java.util.concurrent.{AbstractExecutorService, ExecutorService, ThreadFactory, TimeUnit}

import akka.dispatch.{DispatcherPrerequisites, ExecutorServiceConfigurator, ExecutorServiceFactory}
import com.sun.javafx.application.PlatformImpl
import com.typesafe.config.Config
import semester.foundation.fextile.application.Fextile

import scala.concurrent.Future

class JavaFXEventThreadExecutorServiceConfigurator(config: Config, prerequisites: DispatcherPrerequisites) extends ExecutorServiceConfigurator(config, prerequisites) {
  override def createExecutorServiceFactory(id: String, threadFactory: ThreadFactory): ExecutorServiceFactory = new ExecutorServiceFactory {
    override def createExecutorService: ExecutorService = new AbstractExecutorService {
      override def execute(command: Runnable): Unit =
        Future {
          PlatformImpl.runAndWait(command)
        }(Fextile.system.dispatcher)

      override def shutdown(): Unit = {}

      override def isTerminated: Boolean = false

      override def awaitTermination(timeout: Long, unit: TimeUnit): Boolean = true

      override def shutdownNow(): util.List[Runnable] = Collections.emptyList[Runnable]

      override def isShutdown: Boolean = false
    }
  }
}
