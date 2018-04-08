package org.plytimebandit.web.webbootflux.handler;

import org.plytimebandit.web.webbootflux.data.Foo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ExampleHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello the 2nd!"));
    }

    public Flux<Foo> hi(ServerRequest request) {
        return Flux.just(new Foo("foo", "one"), new Foo("bar", "two"));
    }

    public Mono<ServerResponse> hi2(ServerRequest request) {
        Flux<Foo> foos = hi(request);
        return ServerResponse.ok().body(foos, Foo.class);
    }

}
