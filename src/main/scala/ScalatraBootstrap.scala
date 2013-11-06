import akka.actor._
import akka.cluster.Cluster
import akka.cluster.ClusterEvent._
import akka.actor.{Props, ActorSystem}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.ClusterDomainEvent
import javax.servlet.ServletContext
import org.example.akka.cluster.SimpleClusterListener
import org.scalatra.LifeCycle

/**
 * @author tomerb
 * Date: 11/6/13 Time: 12:39 PM
 */
class ScalatraBootstrap extends LifeCycle {

  // Override the configuration of the port
  // when specified as program argument

  // Create an Akka system
  val system = ActorSystem("ClusterSystem")
  val clusterListener = system.actorOf(Props[SimpleClusterListener],
    name = "clusterListener")

  Cluster(system).subscribe(clusterListener, classOf[ClusterDomainEvent])

  override def init(context: ServletContext) {
    println("starting")
  }

  override def destroy(context:ServletContext) {
    system.shutdown()
  }

}
