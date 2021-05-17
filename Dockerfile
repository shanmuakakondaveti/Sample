FROM openjdk:8

RUN apt update

RUN apt -y install default-jre

RUN apt -y install testng

RUN apt -y install git

ENV DISPLAY :10

EXPOSE 5555

ADD src/com/wtt/test/SeleniumSample.java SeleniumSample.java 

#RUN javac src/com/wtt/test/SeleniumSample.java
CMD java src/com/wtt/test/SeleniumSample

ENTRYPOINT [ "java","SeleniumSample.java"] 

