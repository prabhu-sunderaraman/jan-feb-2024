### Quarkus  Lab06

* Create a new project __quarkus-lab06-kafka__ in IntelliJ

### Part I

* Create a topic **lab06-topic** with **1 partition**
* Configure the following in application.properties file

```
quarkus.application.name=lab06-consumer
quarkus.package.type=uber-jar
kafka.bootstrap.servers=localhost:9092

mp.messaging.incoming.lab06-in.connector=smallrye-kafka
mp.messaging.incoming.lab06-in.topic=lab06-topic
mp.messaging.incoming.lab06-in.group.id=lab06-group-dev-1
mp.messaging.incoming.lab06-in.auto.offset.reset=earliest
```

* Have the following class in your project

``` java
package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Lab06Consumer {

    @Incoming("lab06-in")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("***** Record key: " + record.key());
        System.out.println("***** Record: value: " + record.value());
        System.out.println("***** Record: offset: " + record.offset());
	    System.out.println("***** Partition: : " + record.partition());
    }
}

```

* Build your application.
* Open three terminal windows and run the jar file

```
java -jar <jarFileName>
```

* Publish messages through **Offset Explorer**
* Observe the output in all three windows
* Bring down each of them and observe the output


* Open three terminal windows and run the jar file

```
java -jar -Dmp.messaging.incoming.lab06-in.group.id=lab06-group-dev-2 <jarFileName>
```

```
java -jar -Dmp.messaging.incoming.lab06-in.group.id=lab06-group-dev-3 <jarFileName>
```

```
java -jar -Dmp.messaging.incoming.lab06-in.group.id=lab06-group-dev-4 <jarFileName>
```

##### For windows

* Please wrap the system property in double quotes like this

```
java -jar "-Dmp.messaging.incoming.lab06-in.group.id=lab06-group-dev-4" <jarFileName>
```

* Publish messages through **Offset Explorer**
* Observe the output in all three windows

### Part II

* Remove **lab06-topic**
* Create a topic **lab06-topic** with **3 partitions**
* Repeat (Part I) and observe the output in all windows












