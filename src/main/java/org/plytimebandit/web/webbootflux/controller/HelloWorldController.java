package org.plytimebandit.web.webbootflux.controller;

import org.plytimebandit.web.webbootflux.handler.ExampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World! Zoooooom!!!" +
                "<br />" +
                "<a href=\"example\">example</a>";
    }

    @Bean
    public RouterFunction<ServerResponse> example(ExampleHandler exampleHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/example")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                exampleHandler::hello);
    }

}
