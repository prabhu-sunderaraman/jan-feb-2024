### Need for docker

* Install multiple versions of the same software in your host machine; MySQL 5, MySQL 8
* Be able to install and configure any software without having to deal with executables and configuration
* Mimic a production environment in host machine
* **Docker Desktop** installs all the tools required to work with docker

### Docker

* Docker is a Golang application
* You can create containers
* A docker container is a Linux VM
* When you say you have 5 docker containers running in your machine, it means you have 5 Linux VMs running in your machine
* When you say you have a **MySQL container**, it means you have a Linux VM with Mysql installed in it
* When you say you have a **Herbalife Vendor API container**, it means you have a Linux VM that has the Vendor API running inside it in a web server

### OO story

* Create a class say MySQL
* Create an Object of MySQL
* Create any number of objects of MySQL class

### Docker story

* Create an image say MySQL
* Create an instance of MySQL image, ie., a container
* Create any number of containers(or instances) of MySQL image
* All the images are present in a public repository **https://hub.docker.com**

#### MySQL server and UI client

```
docker run --name jan-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
```

```
docker run --name mysql-client -p8001:80 -d --link jan-mysql:db phpmyadmin
```

### Build an image

```
docker build -t word-api:1.0.0 .
```

### Run the image

```
docker run -d --name=word -p8080:8080 word-api:1.0.0
```

