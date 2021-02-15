package com.example.demospringboot.routes;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class FileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/C:/Trainings/input?fileName=Test_Camel.txt").to("file:/C:/Trainings/output/")
        .log(LoggingLevel.INFO, "File is moved to destination");

    }
}
