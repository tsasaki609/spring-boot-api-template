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
  private final ExampleMapper exampleMapper;

  @Override
  public Mono<Example> findById(ExampleId id) {
    return exampleReactiveCrudRepository
        .findById(id.getValue())
        .map(e -> exampleMapper.toDomain(e));
  }

  @Override
  public Flux<Example> findAllById(Iterable<ExampleId> ids) {
    return exampleReactiveCrudRepository
        .findAllById(
            StreamSupport.stream(ids.spliterator(), true).map(ExampleId::getValue).toList())
        .map(e -> exampleMapper.toDomain(e));
  }

  @Override
  public Mono<Example> create(Example example) {
    return exampleReactiveCrudRepository
        .save(exampleMapper.toRecord(example))
        .map(e -> exampleMapper.toDomain(e));
  }

  @Override
  public Mono<Example> update(Example example) {
    return exampleReactiveCrudRepository
        .save(exampleMapper.toRecord(example))
        .map(e -> exampleMapper.toDomain(e));
  }

  @Override
  public Mono<Example> delete(ExampleId id) {
    return exampleReactiveCrudRepository
        .findById(id.getValue())
        .flatMap(e -> exampleReactiveCrudRepository.delete(e).thenReturn(e))
        .map(e -> exampleMapper.toDomain(e));
  }
}
