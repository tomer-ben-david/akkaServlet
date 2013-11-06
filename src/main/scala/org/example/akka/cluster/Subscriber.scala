package org.example.akka.cluster

import akka.actor.{Actor, ActorLogging}
import akka.contrib.pattern.{DistributedPubSubExtension, DistributedPubSubMediator}

/**
 * @author tomerb
 *         Date: 11/6/13 Time: 12:04 PM
 */
class Subscriber extends Actor with ActorLogging {
  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSubExtension(context.system).mediator
  // subscribe to the topic named "content"
  mediator ! Subscribe("content", self)

  def receive = {
    case SubscribeAck(Subscribe("content", `self`)) ⇒
      context become ready
  }

  def ready: Actor.Receive = {
    case s: String ⇒
      log.info("Got {}", s)
  }
}
