package com.example.demo.infrastructure;

import com.example.demo.domain.Demo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DemoRepository extends ReactiveCrudRepository<Demo, Integer> {
}
