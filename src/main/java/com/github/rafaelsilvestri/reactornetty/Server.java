package com.github.rafaelsilvestri.reactornetty;

import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

public class Server {

  private static final Logger log = LoggerFactory.getLogger(Server.class);

  public static void main(String[] args) {
    log.info("Starting server");
    long begin = System.currentTimeMillis();

    HttpServer.create()
        .port(8080)
        .route(routes ->
            routes.get("/v1/hello", (request, response) ->
                response.sendString(Mono.just("Hello!!"))))
        .bindUntilJavaShutdown(Duration.ofSeconds(3), disposableServer -> {
          long elapsed = System.currentTimeMillis() - begin;
          log.info("Server started in {} ms ", elapsed);
        });
  }
}
