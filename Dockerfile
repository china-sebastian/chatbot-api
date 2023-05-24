
# 基础镜像
FROM openjdk:8-jre-slim

# 作者
MAINTAINER binge

#配置
ENV PARAMS=""

#时区
ENV ln -snf /usr/local/zoneinfo/$TZ  /etc/localtime && $TZ > /etc/timezone

#添加应用
ADD /chatbot-api-interface/target/chatbot-api.jar  /chatbot-api.jar

#执行镜像
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /chatbot-api.jar $PARAMS"]