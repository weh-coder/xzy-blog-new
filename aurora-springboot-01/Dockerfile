FROM openjdk:8-jdk-alpine

# 设置维护者信息
#LABEL maintainer="dev@example.com"
MAINTAINER weh

# VOLUME 指向了一个/tmp的目录，由于 SpringBoot使用内置的Tomcat容器，Tomcat默认使用/tmp作为工作目录。
# 这个命令的效果是：在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
VOLUME /tmp

# 将本地JAR包打包到容器中，并重命名(campus_gang.jar是重命名后的jar)
ADD aurora-springboot-0.0.1.jar aurora-0.1.jar

#docker启动时，运行的命令，这里容器启动时直接运行jar服务。
ENTRYPOINT ["java","-jar","aurora-0.1.jar","--spring.profiles.active=pro"]

# 暴露容器内应用的端口号
EXPOSE 9990
