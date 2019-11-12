package com.github.rafaelsilvestri.reactornetty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.netty.http.client.HttpClient;

public class Client {

  private static final Logger log = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    log.info("Starting request");

    HttpClient.create()
        .port(8080)
        .get()
        .uri("/v1/hello")
        .responseContent()
        .aggregate()
        .asString()
        .log("com.github.rafaelsilvestri")
        .block();
  }
}
