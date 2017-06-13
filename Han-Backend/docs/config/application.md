客户端配置类：EurekaClientConfig，EurekaConstants
EurekaClientConfigBean

服务端配置类：EurekaServerConfig，EurekaConstatns
EurekaServerConfigBean

服务实例的配置类：EurekaInstanceConfig
EurekaInstanceConfigBean

###### 服务提供者 #####

1、服务注册
#是否将该服务进行注册 默认是true，注册
配置信息：
eureka.client.register-with-eureka=true

2、服务同步
#在集群的注册服务上注册，可以被集群所有的服务共享

3、服务续约
#服务提供者启动后，会维护一个心跳，来持续告诉 Eureka Server,当前服务还存在，防止Eureka Server的“剔除任务”，将该服务实例，从服务列表中清除
配置信息：
#定义服务时效的时间，默认90s
eureka.instance.lease-expiration-duration-in-seconds=90
#服务续约任务的调用时间间隔，默认30s
eureka.instance.lease-renewal-interval-in-seconds=30


###### 服务消费者 ######

1、获取服务
#启动服务消费者的时候，会发送REST请求到注册中心，获取上面的注册清单，为了性能，Eureka Server会维护一份只读服务清单
同时该缓存清单，每隔30s更新一次
配置信息：
#获取缓存清单，默认是true，获取缓存清单
eureka.client.fetch-registry=true
#服务清单更新的时间，默认是30s
eureka.client.registry-fetch-interval-seconds=30

2、服务调用
#根据服务清单元信息，可选择调用哪个服务实例
#Ribbon中默认采用轮训的方式进行调用，从而实现客户端的负载均衡
#对于访问实例的选择：概念，Region，Zone概念
一个Region包含多个Zone
每个服务客户端被注册到一个Zone中，所以每个客户端对应一个Zone和一个Region
在服务调用的时候，优先访问同一个Zone中的服务提供方
TODO 源码详解
###客户端配置类：EurekaClientConfig
###服务端配置类：EurekaServerConfig

#客户端，设置region 默认是
eureka.client.region=default，没有特殊配置，就使用 eureka.client.serviceUrl.defaultZone =
#客户端，设置zone，可配置多个，用“,”隔开
eureka.client.availability-zones=

以上为获取具体的Region和Zone的信息，然后是加载Eureka Server的具体信息


#安全校验用户名，密码
#<username>:<password>@

#启用Eureka客户端
eureka.client.enabled=true
#从Eureka中获取注册信息时间间隔，单位：秒
eureka.client.registry-fetch-interval-seconds=30
#更新实例的信息变化到Eureka服务的时间间隔
eureka.client.instance-info-replication-interval-seconds=30
#初始化实例信息到Eureka服务端的时间间隔
eureka.client.initial-instance-info-replication-interval-seconds=40
#轮询Eureka服务端地址更改的间隔时间
#TODO 当我们与cloud config配合使用的时候，动态刷新Eureka的serviceUrl地址时，需要关注此参数
eureka.client.eureka-service-url-poll-interval-seconds=300
#读取Eureka信息的超时时间
eureka.client.eureka-server-read-timeout-seconds=8
#连接Eureka的超时时间
eureka.client.eureka-server-connect-timeout-seconds=5
#从Eureka客户端，到所有Eureka服务端的连接总数
eureka.client.eureka-server-total-connections=200
#从Eureka客户端，到每个Eureka服务端的连接总数
eureka.client.eureka-server-total-connections-per-host=50
#Eureka服务端连接的空闲关闭时间
eureka.client.eureka-connection-idle-timeout-seconds=50
#心跳连接池初始化线程连接数
eureka.client.heartbeat-executor-thread-pool-size=2
#心跳超时重试延迟时间的最大乘数值
eureka.client.heartbeat-executor-exponential-back-off-bound=10
#使用DNS来获取Eureka服务端的serviceUrl
eureka.client.use-dns-for-fetching-service-urls=false
#是否将自身的实例注册到Eureka服务端
eureka.client.register-with-eureka=true
#是否偏好使用处于相同zone的Eureka服务端
eureka.client.prefer-same-zone-eureka=true
#获取实例时是否过滤，仅保留UP状态的实例
eureka.client.filter-only-up-instances=true
#是否从Eureka服务端获取注册信息
eureka.client.fetch-registry=true




#自定义参数 ，metadataMap.<key>=<value> 格式
#eureka.instance.metadataMap.<key>=<value>

#服务实例ID
#eureka.instance.instance-id=

#当应用设置了content-path路径，此时就会导致重写
#management-content-path = /hello
#例如
#eureka.instance.status-page-url-path=${management-content-path}/info
#例如
#eureka.instance.health-check-url-path=${management-content-path}/health


#是否优先使用IP地址作为主机名的标识
eureka.instance.prefer-ip-address=false
#Eureka服务端在收到最后一次心跳后的等待时间上限
#超过该时间后，Eureka会将该服务实例从服务清单中剔除，从而禁止服务调用请求被发送到该服务实例上
eureka.instance.lease-expiration-duration-in-seconds=90
#客户端向Eureka服务端，发送心跳的时间间隔
eureka.instance.lease-renewal-interval-in-seconds=30
#非安全的通信端口号
eureka.instance.non-secure-port=80
#是否启用非安全的通信端口号
eureka.instance.non-secure-port-enabled=true;
#安全的通信端口号
eureka.instance.secure-port=443
#是否启用安全的通信端口号
eureka.instance.secure-port-enabled=true;
#服务名，默认取用spring.application.name的配置值，如果没有则unknown
eureka.instance.appname="unknown"
#主机名，不配置的时候根据操作系统的主机名来获取
eureka.instance.hostname=



3、服务下线
#服务提供方，正常关闭的时候，向Eureka Server发送REST下线请求，将该服务状态置为DOWN,并把该下线事件传播出去

###### 服务注册中心 ######

1、失效剔除
#服务实例，并非正常下线，可能由于内存溢出，网络等原因不能正常工作，注册中心未收到“服务下线”。
#注册中心启动的时候，创建一个定时任务，每隔一段时间(默认60s),将当前清单中超时(默认90s),没有续约的服务剔除
TODO 源码查看定时器执行时间设置

2、自我保护
#本地调试基于Eureka程序时，在注册服务中心控制面板会出现红色信息警告：EMERGENCY~,就是Eureka Server的自我保护机制

原因：服务提供者，启动服务，启动“心跳连接”，维持自身不被Eureka Server剔除，而Eureka Server定时器在运行的时候，会统计
心跳失败的比例在15分钟内是否低于85%，如果出现低于的情况，会将当前服务实例的注册信息保存起来，让这些实例不会过期
然而在这段保护期间，若服务实例出现问题，客户端很容易拿到已经不存在的实例，会出现调用失败，所以客户端要有容错机制
TODO 比如：请求重试、断路器等机制    TODO 剔除清单和缓存起来的区分是什么？？？
#单机调试，屏蔽本地保护机制，默认是true保护
eureka.server.enable-self-preservation=false


























