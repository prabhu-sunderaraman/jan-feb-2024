* Create a docker compose file that has MySQL server and MySQL client (phpmyadmin) configured
* Run them and launch mysql and mysql client in a single shot

#### MySQL server and UI client

```
docker run --name jan-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
```

```
docker run --name mysql-client -p8001:80 -d --link jan-mysql:db phpmyadmin
```
