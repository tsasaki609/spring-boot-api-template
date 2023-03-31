package com.example.demo.presentation;

import com.example.demo.domain.Demo;
import com.example.demo.domain.DemoId;
import java.util.List;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/v1/demo", produces = "text/event-stream")
public class DemoController {
  @GetMapping("/{demo-id}")
  public Mono<Demo> get(@PathVariable("demo-id") DemoId id) {
    return Mono.empty();
  }

  @GetMapping
  public Flux<Demo> list(ListDemoRequest request) {
    return Flux.empty();
  }

  @Data
  public static class ListDemoRequest {
    private List<DemoId> demoId;
  }

  @Component
  public static class DemoIdConverter implements Converter<String, DemoId> {
    @Override
    public DemoId convert(String source) {
      return new DemoId(Integer.parseInt(source));
    }
  }
}
