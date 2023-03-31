package com.example.demo.presentation;

import com.example.demo.domain.Demo;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {
  public Mono<Demo> get(DemoRequest request) {
    return Mono.empty();
  }

  public Flux<Demo> list() {
    return Flux.empty();
  }

  public static class DemoRequest {
    private String demoId;
  }
}
