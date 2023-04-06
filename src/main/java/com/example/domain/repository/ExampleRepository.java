package com.example.domain.repository;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExampleRepository {

  Mono<Example> findById(ExampleId id);

  Flux<Example> findAllById(Iterable<ExampleId> ids);
}
