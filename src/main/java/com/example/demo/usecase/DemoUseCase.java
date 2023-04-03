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

  // TODO 独自に定義した型に対するCodecを登録する方法がないっぽい？
  // https://github.com/r2dbc/r2dbc-h2/issues/178
  // どうしても解決できなければリポジトリ側で変換する
  private final DemoRepository demoRepository;

  public Mono<Demo> findById(DemoId id) {
    return demoRepository.findById(id);
  }

  public Flux<Demo> findByAllId(Iterable<DemoId> ids) {
    return demoRepository.findAllById(ids);
  }
}
