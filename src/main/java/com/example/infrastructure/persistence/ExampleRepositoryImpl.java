package com.example.infrastructure.persistence;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import com.example.domain.repository.ExampleRepository;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ExampleRepositoryImpl implements ExampleRepository {
  private final ExampleReactiveCrudRepository exampleReactiveCrudRepository;

  @Override
  public Mono<Example> findById(ExampleId id) {
    return exampleReactiveCrudRepository
        .findById(id.value())
        .map(e -> ExampleMapper.INSTANCE.fromRecord(e));
  }

  @Override
  public Flux<Example> findAllById(Iterable<ExampleId> ids) {
    return exampleReactiveCrudRepository
        .findAllById(StreamSupport.stream(ids.spliterator(), true).map(ExampleId::value).toList())
        .map(e -> ExampleMapper.INSTANCE.fromRecord(e));
  }
}
