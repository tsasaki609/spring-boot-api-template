package com.example.demo.presentation;

import com.example.demo.domain.Demo;
import com.example.demo.domain.DemoId;
import com.example.demo.usecase.DemoUseCase;
import java.util.List;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/v1/demo", produces = "text/event-stream")
@RequiredArgsConstructor
public class DemoController {
  private final DemoUseCase demoUseCase;

  @GetMapping("/{demo-id}")
  public Mono<Demo> get(@PathVariable("demo-id") DemoId id) {
    final var result = demoUseCase.findById(id);
    return result;
  }

  @GetMapping
  public Flux<Demo> list(ListDemoRequest request) {
    return demoUseCase.findByAllId(request.getDemoId());
  }

  @Data
  public static class ListDemoRequest {
    private @NonNull List<DemoId> demoId = List.of();
  }

  // TODO move to global class
  @Component
  public static class DemoIdConverter implements Converter<String, DemoId> {
    @Override
    public DemoId convert(String source) {
      return new DemoId(Integer.parseInt(source));
    }
  }
}
