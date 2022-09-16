FROM openjdk:17-alpine
VOLUME /tmp
COPY target/**.jar resourcemanagementsvc-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /resourcemanagementsvc-0.0.1-SNAPSHOT.jar" ]