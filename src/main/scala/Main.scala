package main

import akka.actor._
import akka.cluster._
import akka.cluster.ClusterEvent._

object Main extends App {
  implicit val system = ActorSystem()
  system.actorOf(Props[ClusterListener])
  sys.addShutdownHook(system.shutdown())
}

class ClusterListener extends Actor with ActorLogging {

  override def preStart = Cluster(context.system).subscribe(self, classOf[ClusterDomainEvent])

  def receive = {
    case MemberUp(member) => log.info("memberUp={}", member.address)
    case event ⇒ log.debug("event={}", event.toString)
  }
}
