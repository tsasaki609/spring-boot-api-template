package com.example.infrastructure.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExampleReactiveCrudRepository
    extends ReactiveCrudRepository<ExampleRecord, Integer> {}
