**coin-exchange  数字货币交易系统**

**1.项目简介**

  coin-exchange 是基于Java的SpringCloudAlibaba微服务框架开发的货币交易系统。项目特点

**2.项目特点**

(1)基于内存撮合引擎，比传统基于数据库撮合引擎更快 ；

(2) 前后端分离，基于OAuth2.0 + JWT的API授权机制 ；

(3) 基于SpringCloudAlibaba微服务架构，扩展更容易 ;

(3) MySQL、MongoDB、Redis多种数据存储方式，只为更稳和更快 ；

(4) RocketMQ发布订阅消息队列，让订单更快流转 ；

(5) Netty秒级实时K-Line推送 ;

(6) 主流币种对接区块链接口齐全；

**3 后台管理功能**

![](H:\gitup\coin-exchange\arch\图片1.png)

**4.前台功能**

![](H:\gitup\coin-exchange\arch\图片2.png)

**5.移动端功能**

![](H:\gitup\coin-exchange\arch\图片3.png)

**4.系统架构**

![](H:\gitup\coin-exchange\arch\图片4.png)

**5.逻辑架构**

![](H:\gitup\coin-exchange\arch\图片5.png)

**5.后端开发环境安装**

 （1） 服务器  CentOS 7.9 64位 

   (2 )  安装Docker：

  <!--安装docker-->

 `yum -y install docker`

  <!--开机自启-->

`systemctl enable docker`

<!--启动Docker-->

`systemctl start docker`

<!--查看Docker当前的版本-->

`docker version`

<!--启动docker-->

`systemctl restart docker`

（3）安装mysql

`docker run --name mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=你的密码 -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --restart=always`

（4）安装Redis

 `docker run --name redis -p 6380:6379 -d --restart=always redis`

   <!--Redis 密码配置 略-->

(5 )  安装开发环境的RocketMQ（生成环境使用Kafka)

<!--Namesrv的安装-->

`docker run --name namesrv -p 9876:9876 -e "MAX_POSSIBLE_HEAP=100000000" -d --restart=always rocketmqinc/rocketmq sh mqnamesrv`

<!--Namesrv 的配置 略-->

<!--安装broker-->

`docker run --name broker -p 10911:10911 -p 10909:10909 -v /usr/local/rocketmq/broker.conf:/opt/rocketmq-4.4.0/conf/broker.conf --link namesrv:namesrv -e "NAMESRV_ADDR=namesrv:9876" -e "MAX_POSSIBLE_HEAP=200000000" -d --restart=always rocketmqinc/rocketmq:4.4.0 sh mqbroker -c /opt/rocketmq-4.4.0/conf/broker.conf`

<!--安装 console-->

`docker run --name=rocketmq-console -e "JAVA_OPTS=-Drocketmq.namesrv.addr=你的IP:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" -p 8080:8080 -d --restart=always styletang/rocketmq-console-ng`

（6）MongoDB 安装

`docker run --name mongo -p 27017:27017 -d --restart=always mongo --auth`

​    <!--设置密码 略-->

 (7) Nacos-Server  安装

`docker run --name nacos -e MODE=standalone -p 8848:8848 -d --restart=always nacos/nacos-server:1.1.4`

(8) Sentinel-Dashboard 安装

`docker run --name sentinel  -p 8858:8858 -d  bladex/sentinel-dashboard`
`docker update --restart=always sentinel`

(9) Seata-Server安装

`docker run --name seata-server -p 8091:8091  -e SEATA_IP=121.40.140.138 -d seataio/seata-server`



# 



​    