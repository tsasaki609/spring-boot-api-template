package com.example.presentation;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import com.example.usecase.ExampleUseCase;
import java.util.List;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/v1/example", produces = "text/event-stream")
@RequiredArgsConstructor
public class ExampleController {
  private final ExampleUseCase exampleUseCase;

  @GetMapping("/{example-id}")
  public Mono<Example> get(@PathVariable("example-id") ExampleId id) {
    final var result = exampleUseCase.findById(id);
    return result;
  }

  @GetMapping
  public Flux<Example> list(ListExampleRequest request) {
    return exampleUseCase.findByAllId(request.getExampleId());
  }

  @Data
  public static class ListExampleRequest {
    private @NonNull List<ExampleId> exampleId = List.of();
  }
}
