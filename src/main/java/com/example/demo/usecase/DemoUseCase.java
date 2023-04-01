package com.example.demo.usecase;

import com.example.demo.domain.Demo;
import com.example.demo.domain.DemoId;
import com.example.demo.infrastructure.DemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DemoUseCase {
  private final DemoRepository demoRepository;

  public Mono<Demo> findById(DemoId id) {
    return demoRepository.findById(id);
  }

  public Flux<Demo> findByAllId(Iterable<DemoId> ids) {
    return demoRepository.findAllById(ids);
  }
}
