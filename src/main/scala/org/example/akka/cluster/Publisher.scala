package org.example.akka.cluster

import akka.contrib.pattern.{DistributedPubSubExtension, DistributedPubSubMediator}
import akka.actor.Actor
import java.util.Date

/**
 * @author tomerb
 *         Date: 11/7/13 Time: 3:54 PM
 */
class Publisher extends Actor {
  import DistributedPubSubMediator.Publish
  // activate the extension
  val mediator = DistributedPubSubExtension(context.system).mediator

  def receive = {
    case PublishMessage ⇒
      mediator ! Publish("topicA", "ActorMesage [" + System.getProperty("akka.remote.netty.tcp.port") + "] -->")
  }
}
