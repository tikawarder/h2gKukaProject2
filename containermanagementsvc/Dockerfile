FROM openjdk:17-alpine
VOLUME /tmp
ADD target/**.jar containermanagementsvc-1.0-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /containermanagementsvc-1.0-SNAPSHOT.jar" ]