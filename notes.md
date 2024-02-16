### Few basic things about Java

* OO language
* Functional programming language
* Compiled programming language
* Install JDK from **https://www.oracle.com/java/technologies/downloads** or from Amazon or Microsoft or IBM
* JDK contains the tools and basic libraries to get you started working with Java
* Bring up your command prompt or Terminal and type

```
java -version
```

* Write your java code in a **.java** file
* Compile using **javac**
* Run using **java**


* .NET languages -> C#, VB.NET, F#
* JVM languages -> Java, Kotlin, Groovy, Scala


### Day 01

* Data types; Primitive and Reference types
* Primitive types are stored on the stack
* Reference types are stored on the heap; They have a reference from variables on the stack
* int, boolean, char, double; Integer, Boolean, Character, Double
* JVM is responsible for memory management; It allocates memory and also cleans up the memory
* if-else, switch-case statements/expression
* for, for in, while, do-while 


### Day 02

* String is a reference type
* It's immutable. 
* String literals are stored in a separate place on the heap called string pools
* You can create a string using new keyword or without using new keyword
* An implicit object is created when you create without using new keyword
* Everytime you change the value of a string, a new string is created, since it's immutable
* **Two points** to remember while working with string
* Stick to one way of creating a string preferrably without new keyword
* Compare strings using **.equals** method or **.equalsIgnoreCase** method
* If you want to perform a lot of operations on a string use **StringBuilder** instead
* Multi-line strings """ """
* Arrays; 2D; square brackets [] can be placed after the datatype or after the variable name

```
String[] cities = {};
String cities[] = {};
```


### Day 03

* Creating classes and objects
* Constructors called during object creation
* There are no destructors in Java. Even the **finalize** method that acts as a destructor is deprecated
* Create a class with private member variables and public getter/setter methods or properties
* In Java a class with private members and public getters/setters and a no-argument constructor is called a **Java Bean**
* Pass by value and pass by ref


### Day 04

* Inheritance denotes "is-a" relationship
* **extends** keyword is used in class-based inheritance
* method overriding where the base class method needs to be redefined with the same signature in the derived class
* **super** keyword
* Whenever a derived class object is created, the base class object is instantiated first, followed by the derived class
* **abstract** used to define abstract classes; can have abstract methods
* records, enums
* interfaces can be used to list all the constants; since the variables defined in an interface are implicitly public, static and final

### Day 05

* interfaces
* constants, abstract methods, default methods, static methods
* core jdk is organized into modules
* **java.base** module contains the core APIs
* java.lang, java.util, java.net, java.nio

##### Packaging in Java

* Java applications are bundled into **.jar** files or **.jmod** files
* jar stands for java archive; jar file is very similar to WinZip file.

* Application is organized into **modules**; Each module contains several packages; Each package contains several classes
* Application is organized into **jars**; Each jar contains several packages; Each package contains several classes

```
java -jar <jarFileName>
```

### Day 07

*  java.util.function package has a list of built-in functional interfaces
* Predicate, Function, Supplier, Consumer
* **Predicate** is a FI that accepts data of any type and returns boolean
* isEven, greaterThan etc.
* and, or, negate default methods that help you to chain methods


### Day 08

* Stream API
* java.util.stream.Stream
* Stream is used to sequentially process collections in a functional style
* Streams can be created by using **.stream()**
* Streams are lazily evaluated and cannot be reused
* filter, map, collect, forEach
* filter takes a Predicate as argument; map takes a Function as argument; collect takes a Supplier as argument; foreach takes a Consumer as argument



### Day 11

* **java.util.concurrent** package contains classes to work with threads
* Thread object by passing a Runnable interface 
* Runnable is a functional interface.
* Calling **start()** on the thread object creates a thread(OS thread)
* Thread pools.
* ExecutorService to create different thread pools 
* fixed thread pool, cached thread pool, forkjoinpool
* You submit a task to the thread pool
* Parallel streams can be created using .parallel() or .parallelStream() method
* By default it creates a **forkjoinpool** with **(number of cores - 1)** threads
* You can customize the pool based on CPU/IO intensive and create a custom forkjoin pool

### Enterprise application development in Java

* Java SE present in JDK
* Java EE (JEE) contains specs for persistence, web services, Restful services, Transactions, Security, Messaging (Kafka, RabbitMQ)
* As a developer you need the implementation libraries 
* Say you want to develop RESTful API
* RESTful API is available as a spec in JEE stack
* But what you need is an implementation library/framework
* You need a mall(or frameworks) that provides you access to all JEE implementations
* Spring boot, Quarkus, Micronaut, Oracle RI
* **Quarkus** is a framework designed to build enterprise applications in Java

### Quarkus

* Quarkus is cloud-native framework
* Quarkus gives you one feature that makes the application more performant than Spring boot
* Quarkus applications can be packaged into native executables(like exe file) instead of jars
* Quarkus is based on Microprofile standard (https://microprofile.io/)
* Using Quarkus you can develop REST apis, command line applications, scheduled jobs, SOAP-based Web services, messaging applications ...etc
* **Dependency Injection** is the fundamental principle of working with Quarkus
* DI is a simple mechanism by which you avoid writing code for creating objects, looking up for objects
* Quarkus is a **POJO** framework


### Dependency Injection

* **quarkus-arc** is the dependency that you need in every quarkus application for DI
* You define a class or bean and mark the scope as **@Singleton** or **@ApplicationScoped** or @RequestScoped
* You can **@Inject** annotation
* @ConfigProperty, @Named

### REST API

* RESTEasy Reactive Jackson dependency
* Netty server internally 
* Define Resources (similar to Controllers)
* @Path, @GET, @POST, @QueryParam, @PathParam, @FormParam


### DB with Quarkus

* You can jdbc or ORM
* Inject a datasource and get the connection in case of JDBC
* JPA is the uniform API to work with ORM
* Multiple implementations of ORM available; Toplink, MyBatis, Hibernate
* To work with ORM in Quarkus select **hibernate panache** library
* Define an Entity class and map it with the table
* Map the variables with the columns
* @Entity, @Table, @Column, @Id, @GeneratedValue
* You can use Repository or ActiveRecord pattern to implement the repository/DAO classes
* Define a Repository by implementing **PanacheRepositoryBase**
* CUD operations, the method should execute in a transaction context; **@Transactional**


### Kafka

* Broadcasting messages
* A single message can be consumed by many consumers
* Producers and Consumers
* Message contains data + timestamp
* Messages in Kafka are commonly referred to as **Events**
* Kafka's equivalent in Azure environment is **EventHub**
* One of the reasons Kafka is used; Stream millions of events per second 
* Topic is the main entity in Kafka. It's a storage box that contains n messages
* Each producer produces messages to a Topic
* Consumers consume messages from a Topic
* Topic can be treated as a Newspaper vendor
* Kafka was developed by LinkedIn team
* Apache Kafka(Open source) and Confluent Kafka(Kafka on the cloud)
* You need a kafka server(bootstrap server) and kafka client

#### Kafka consumers

* Consumer polls records every n seconds
* Each consumer needs to be part of a consumer group
* Consumer group id is treated as an unique consumer by kafka
* Kafka maintains a list of consumer groups along with their offset
* Based on the offset position for every consumer, Kafka sends the records to the consumers
* After processing each record, consumer sends an acknowledgement to kafka and kafka updates the offset for that consumer group
 * **ConsumerRecord, ConsumerRecords** to access more information about every message
 * **OutgoingKafkaRecordMetadata** to publish metadata information 
 * You can configure key/value serializers while publishing messages and key/value deserializers while consuming messages

#### Partitions

* When kafka receives a message with a key
* It performs a routing algorithm using the key and the total number of partitions
* It then determines the partition number and forwards this message to that partition
* You can have consumer instances <= to the number of partitions in a topic
* Each consumer instance is assigned to one or more partitions
* Whenever a consumer goes up/down rebalancing occurs and the assignment changes
* **Moral of the story**: When you work with Kafka you need to work closely with the devops team and specify the number of instances and number of partitions required otherwise you will land up wasting resources (and cost)


### CDC

* **Transactional Outbox pattern** https://microservices.io/patterns/data/transactional-outbox.html
* Change Data Capture
* Whenever a change occurs in a DB, how to insert a message to Kafka
* Apache Beam, Debezium **(Code based)**
* CDC, Azure Functions, which writes to Event Hub
* Azure Data Factory(still a preview feature)


### GraphQL

* Does not have to do with Graph Databases all the time
* You want to fetch appropriate data(pick and choose) from Rest APIs. You have different applications like Mobile, Tablet, Browser, Desktop that need the same data but you are not interested in all the items
* You want to club the fetch request in a say portal. Instead of sending multiple individual requests to various Apis, how about we club all the requests and send


``` graphql

query {
  companies {
    name
	ceo
    headCount
    listed
    id
  }
}

query {
  all: companies {
    name
	ceo
    headCount
    listed
    id
  }
  names: companies {
    name
  }
  ceos: companies {
    ceo
  }
}
query {
  allCompanies: companies {
    name
		ceo
    headCount
    listed
    id
  }
  allStartUps: startUps {
    name
    founder
    funding
  }
  
}
query info($listed: Boolean!, $name: String!) {
  list: listedCompanies(listed: $listed) {
    name
    ceo
    headCount
    listed @include (if: $listed)
  }
  info: companyInfo(name: $name) {
    id
    name
    ceo
  }
  startUps: startUps {
    name
    founder
    funding
  }
}

query info($listed: Boolean!, $name: String!) {
  list: listedCompanies(listed: $listed) {
    ...companyFragment
    headCount
    listed @include (if: $listed)
  }
  info: companyInfo(name: $name) {
    id
    ...companyFragment
  }
  startUps: startUps {
    name
    founder
    funding
  }
}
fragment companyFragment on Company {
  name
  ceo
}

mutation operationsOnCompany($name1: String, $name2: String) {
  company1:removeCompany(name: $name1)
  company2: removeCompany(name: $name2)
  addCompany(company: {
    id: "10001",
    name: "Google",
    ceo: "Sundar Pichai",
    listed: true,
    headCount: 100000
  }) {
    name
  }
}


query {
  titles: libraries {
    books {
      title
    }
  }
  authors: libraries {
    books {
      author {
        name
      }
    }
  }
  cities: libraries {
    books {
      author {
        city {
          name
        }
      }
    }
  }
  
  all: libraries {
    name
    books {
      title
      isbn
      author {
        id
        name
        city {
          id
          name
          country
        }
      }
    }
  }
}
subscription {
  onCompanyAdded {
    name
    ceo
  }
}

```

* GraphqQL service; smallrye-graphql
* @GraphqlApi, @Query, @Mutation, @Subscription
* Queries are executed parallelly
* Mutations are executed sequentially
* Schema is automatically generated based on the code in Quarkus, while in most other frameworks you may have to define ***.graphql** files and define the schema and **queries/mutations**
* You can pass combine queries; reuse snippets using fragments; use @include directives; pass variables into queries






































.































