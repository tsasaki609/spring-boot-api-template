package com.example.usecase;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import com.example.domain.repository.ExampleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExampleUseCase {
  private final ExampleRepository exampleRepository;

  public Mono<Example> findById(@NonNull ExampleId id) {
    return exampleRepository.findById(id);
  }

  public Flux<Example> findByAllId(@NonNull Iterable<ExampleId> ids) {
    return exampleRepository.findAllById(ids);
  }

  public Mono<Example> create(@NonNull Example example) {
    return exampleRepository.create(example);
  }

  public Mono<Example> update(@NonNull Example example) {
    return exampleRepository.update(example);
  }

  public Mono<Example> delete(@NonNull ExampleId id) {
    return exampleRepository.delete(id);
  }
}
