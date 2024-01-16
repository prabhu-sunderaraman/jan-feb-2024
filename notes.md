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






