package com.example.infrastructure;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExampleRepository extends ReactiveCrudRepository<Example, ExampleId> {}
