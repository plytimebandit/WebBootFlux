package org.plytimebandit.web.webbootflux.controller;

import org.plytimebandit.web.webbootflux.data.Foo;
import org.plytimebandit.web.webbootflux.handler.ExampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World! Zoooooom!!!"
                + "<br />"
                + "<a href=\"example\">example</a><br />"
                + "<a href=\"example2\">example2</a><br />"
                + "<a href=\"example3\">example3</a><br />";
    }

    @Bean
    public RouterFunction<ServerResponse> example(ExampleHandler exampleHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/example")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                exampleHandler::hello);
    }

    @RequestMapping("/example2")
    public Flux<Foo> example2(ExampleHandler exampleHandler) {
        return exampleHandler.hi(null);
    }

    @Bean
    public RouterFunction<ServerResponse> example3(ExampleHandler exampleHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/example3")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
                exampleHandler::hi2
        );
    }

}
