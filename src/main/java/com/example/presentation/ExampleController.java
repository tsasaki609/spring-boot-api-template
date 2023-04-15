package com.example.presentation;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import com.example.usecase.ExampleUseCase;
import java.util.List;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/v1/example", produces = "text/event-stream")
@RequiredArgsConstructor
public class ExampleController {
  private final ExampleMapper exampleMapper;
  private final ExampleUseCase exampleUseCase;

  @GetMapping("/{example-id}")
  public Mono<ExampleResponse> get(@PathVariable("example-id") ExampleId id) {
    return exampleUseCase.findById(id).map(e -> exampleMapper.toResponse(e));
  }

  @GetMapping
  public Flux<ExampleResponse> list(ListExampleRequest request) {
    return exampleUseCase.findByAllId(request.getExampleId()).map(e -> exampleMapper.toResponse(e));
  }

  @PostMapping
  public Mono<ExampleResponse> create(CreateExampleRequest example) {
    return exampleUseCase
        .create(exampleMapper.toDomain(example))
        .map(e -> exampleMapper.toResponse(e));
  }

  @PostMapping("/{example-id}")
  public Mono<ExampleResponse> update(Example example) {
    return exampleUseCase.update(example).map(e -> exampleMapper.toResponse(e));
  }

  @DeleteMapping("/{example-id}")
  public Mono<ExampleResponse> delete(@PathVariable("example-id") ExampleId id) {
    return exampleUseCase.delete(id).map(e -> exampleMapper.toResponse(e));
  }

  @Data
  public static class ListExampleRequest {
    private @NonNull List<ExampleId> exampleId = List.of();
  }

  @Data
  public static class ExampleResponse {
    private String id;
    private String property1;
    private String property2;
  }

  @Data
  public static class CreateExampleRequest {
    private final String id = String.valueOf(ExampleId.UNREGISTERED_PLACE_HOLDER_ID);
    private String property1;
    private String property2;
  }

  @Data
  public static class UpdateExampleRequest {
    private String id;
    private String property1;
    private String property2;
  }
}
