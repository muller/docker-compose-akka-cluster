# docker-compose-akka-cluster

Minimalistic implementation of Akka [Cluster Usage](http://doc.akka.io/docs/akka/2.4.1/scala/cluster-usage.html) using [Docker Compose](https://docs.docker.com/compose/) to scale the nodes.

## How to use
```bash
sbt docker:publishLocal     # to create the Docker images
docker-compose up -d        # to start the seed and the first node
docker-compose scale node=5 # to scale up the number of nodes
```
## Seed output log `docker logs dockercomposeakkacluster_node_1`
```
[INFO] [12/06/2015 17:27:52.325] [main] [akka.remote.Remoting] Starting remoting
[INFO] [12/06/2015 17:27:52.508] [main] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://default@172.17.0.3:2552]
[INFO] [12/06/2015 17:27:52.512] [main] [akka.remote.Remoting] Remoting now listens on addresses: [akka.tcp://default@172.17.0.3:2552]
[INFO] [12/06/2015 17:27:52.524] [main] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Starting up...
[INFO] [12/06/2015 17:27:52.632] [main] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Registered cluster JMX MBean [akka:type=Cluster]
[INFO] [12/06/2015 17:27:52.632] [main] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Started up successfully
[INFO] [12/06/2015 17:27:53.200] [default-akka.actor.default-dispatcher-18] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Welcome from [akka.tcp://default@akkaseed:2552]
[INFO] [12/06/2015 17:27:53.208] [default-akka.actor.default-dispatcher-4] [akka.tcp://default@172.17.0.3:2552/user/$a] memberUp=akka.tcp://default@akkaseed:2552
[INFO] [12/06/2015 17:27:53.396] [default-akka.actor.default-dispatcher-15] [akka.tcp://default@172.17.0.3:2552/user/$a] memberUp=akka.tcp://default@172.17.0.3:2552
[INFO] [12/06/2015 17:27:59.689] [default-akka.actor.default-dispatcher-19] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Leader is moving node [akka.tcp://default@172.17.0.4:2552] to [Up]
[INFO] [12/06/2015 17:27:59.689] [default-akka.actor.default-dispatcher-19] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Leader is moving node [akka.tcp://default@172.17.0.5:2552] to [Up]
[INFO] [12/06/2015 17:27:59.689] [default-akka.actor.default-dispatcher-19] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Leader is moving node [akka.tcp://default@172.17.0.6:2552] to [Up]
[INFO] [12/06/2015 17:27:59.689] [default-akka.actor.default-dispatcher-19] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.3:2552] - Leader is moving node [akka.tcp://default@172.17.0.7:2552] to [Up]
[INFO] [12/06/2015 17:27:59.692] [default-akka.actor.default-dispatcher-15] [akka.tcp://default@172.17.0.3:2552/user/$a] memberUp=akka.tcp://default@172.17.0.4:2552
[INFO] [12/06/2015 17:27:59.694] [default-akka.actor.default-dispatcher-15] [akka.tcp://default@172.17.0.3:2552/user/$a] memberUp=akka.tcp://default@172.17.0.5:2552
[INFO] [12/06/2015 17:27:59.695] [default-akka.actor.default-dispatcher-3] [akka.tcp://default@172.17.0.3:2552/user/$a] memberUp=akka.tcp://default@172.17.0.6:2552
[INFO] [12/06/2015 17:27:59.695] [default-akka.actor.default-dispatcher-3] [akka.tcp://default@172.17.0.3:2552/user/$a] memberUp=akka.tcp://default@172.17.0.7:2552
```
## Node output log `docker logs dockercomposeakkacluster_node_3`
```
[INFO] [12/06/2015 17:27:57.213] [main] [akka.remote.Remoting] Starting remoting
[INFO] [12/06/2015 17:27:57.665] [main] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://default@172.17.0.4:2552]
[INFO] [12/06/2015 17:27:57.672] [main] [akka.remote.Remoting] Remoting now listens on addresses: [akka.tcp://default@172.17.0.4:2552]
[INFO] [12/06/2015 17:27:57.693] [main] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.4:2552] - Starting up...
[INFO] [12/06/2015 17:27:57.901] [main] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.4:2552] - Registered cluster JMX MBean [akka:type=Cluster]
[INFO] [12/06/2015 17:27:57.908] [main] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.4:2552] - Started up successfully
[INFO] [12/06/2015 17:27:58.732] [default-akka.actor.default-dispatcher-5] [akka.cluster.Cluster(akka://default)] Cluster Node [akka.tcp://default@172.17.0.4:2552] - Welcome from [akka.tcp://default@akkaseed:2552]
[INFO] [12/06/2015 17:27:58.780] [default-akka.actor.default-dispatcher-3] [akka.tcp://default@172.17.0.4:2552/user/$a] memberUp=akka.tcp://default@akkaseed:2552
[INFO] [12/06/2015 17:27:58.802] [default-akka.actor.default-dispatcher-2] [akka.tcp://default@172.17.0.4:2552/user/$a] memberUp=akka.tcp://default@172.17.0.3:2552
[INFO] [12/06/2015 17:28:00.942] [default-akka.actor.default-dispatcher-16] [akka.tcp://default@172.17.0.4:2552/user/$a] memberUp=akka.tcp://default@172.17.0.4:2552
[INFO] [12/06/2015 17:28:00.948] [default-akka.actor.default-dispatcher-16] [akka.tcp://default@172.17.0.4:2552/user/$a] memberUp=akka.tcp://default@172.17.0.5:2552
[INFO] [12/06/2015 17:28:00.948] [default-akka.actor.default-dispatcher-16] [akka.tcp://default@172.17.0.4:2552/user/$a] memberUp=akka.tcp://default@172.17.0.6:2552
[INFO] [12/06/2015 17:28:00.948] [default-akka.actor.default-dispatcher-16] [akka.tcp://default@172.17.0.4:2552/user/$a] memberUp=akka.tcp://default@172.17.0.7:2552
```
