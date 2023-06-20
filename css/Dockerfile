FROM openjdk:11
RUN mkdir -p deploy
WORKDIR deploy
COPY /css/build/libs/css-0.0.1.jar css.jar
ENTRYPOINT ["java", "-jar", "/deploy/css.jar"]