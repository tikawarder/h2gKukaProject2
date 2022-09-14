FROM openjdk:17-alpine
VOLUME /tmp
COPY target/**.jar customermanagementsvc-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /customermanagementsvc-0.0.1-SNAPSHOT.jar" ]