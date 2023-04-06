package com.example.usecase;

import com.example.domain.Example;
import com.example.domain.ExampleId;
import com.example.domain.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExampleUseCase {

  // TODO 独自に定義した型に対するCodecを登録する方法がないっぽい？
  // https://github.com/r2dbc/r2dbc-h2/issues/178
  // どうしても解決できなければリポジトリ側で変換する
  private final ExampleRepository exampleRepository;

  public Mono<Example> findById(ExampleId id) {
    return exampleRepository.findById(id);
  }

  public Flux<Example> findByAllId(Iterable<ExampleId> ids) {
    return exampleRepository.findAllById(ids);
  }
}
