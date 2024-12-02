# How to run in local

### Install DB (Using Docker to install mysql)
```
docker run --name orderdb \
-p 22201:3306 \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_ROOT_HOST='%' \
--restart=unless-stopped \
-d \
mysql/mysql-server:8.0 \
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
### connect to mysql client and create 'local_order'

``` 
$ docker exec -it orderdb /bin/bash
# mysql -uroot -proot 
mysql> CREATE DATABASE local_order CHARACTER SET utf8mb4;
```
At last, you can run the sql query script in the `resources` folder, which is located at `order-domain` module, to create the table and insert some data.