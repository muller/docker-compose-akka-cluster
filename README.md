# docker-compose-akka-cluster

Minimalistic implementation of Akka [Cluster Usage](http://doc.akka.io/docs/akka/2.4.1/scala/cluster-usage.html) using [Docker Compose](https://docs.docker.com/compose/) to scale the nodes.

## How to use
```bash
sbt docker:publishLocal     # to create the Docker images
docker-compose up -d        # to start the seed and the first node
docker-compose scale node=5 # to scale up the number of nodes
```
