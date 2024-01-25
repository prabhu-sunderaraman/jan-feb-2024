### In this lab you will practice making two quarkus applications interact with each other


##### Service 01

* Create a Quarkus application, say __palindrome-api__ running on **8082**
* Create an endpoint **http://localhost:8082/palindrome/{word}** 
* This endpoint computes if the given word is a palindrome or not; ie., return a boolean
* **Package this application and run from command-prompt**



##### Service 02

* Create a Quarkus application, say __word-api__ running on **8081**
* Create an endpoint **http://localhost:8081/word/{word}** 
* When you hit this endpoint, programmatically connect to Service 01 **http://localhost:8082/palindrome/{word}** and print the output
* **Package this application and run from command-prompt**



<br/>

* Externalize the configuration in **application.properties** wherever required
* You can use **HttpClient** if you use Java 11 or above
