Going reactive (with the unfortunate tomcat7 and maven boilerplate)

There is a great course currently held in coursera reactive programming.
In anyway sometimes your system is already based on tomcat so you would not want akka as standalone (the operations team alreayd knows to monitor tomcat), in these cases you want akka on top of tomcat, if your system is also built on maven you also want your maven to be aware of akka (instead of using plain sbt).

Using akka cluster in tomcat7 with maven and scala to publish a message among all tomcat nodes.

Preparing your project for akka cluster and publish subscribe.

<dependency>
	<groupId>com.typesafe.akka</groupId>
	<artifactId>akka-contrib_2.10</artifactId>
	<version>2.1.0</version>
</dependency>

which will enable you to use import DistributedPubSubMediator class.

You need to have a class named ScalatraBootsrap at the root of your project (src/scala) scalatra will search for this file by default.
This file should initialize your actor system (as can be seen in example).

to run two nodes in the cluster see following configuration with intellij

![alt text 1](http://github.com/tomer-ben-david/akkaServlet/raw/master/doc/images/tomcat-akka-cluster-2552.png)

and for the second node:

![alt text 2](http://github.com/tomer-ben-david/akkaServlet/raw/master/doc/images/tomcat-akka-cluster-2552.png)


A sample for the Typesafe Stack (http://typesafe.com/stack).

Akka 2.0 sample project using Java and Maven to implement a simple asynchronous servlet.

To run and test it use Maven invoke: 'mvn clean install' and then copy the WAR file from target to a Tomcat 7.0 or other Servlet 3.0-compliant container.

Call http://localhost:8080/akkaServlet-0.1-SNAPSHOT/ to test the Akka version
Call http://localhost:8080/akkaServlet-0.1-SNAPSHOT/plain to test the plain old servlet version
