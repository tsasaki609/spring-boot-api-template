package com.example.presentation.converter;

import com.example.domain.ExampleId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExampleIdConverter implements Converter<String, ExampleId> {
  @Override
  public ExampleId convert(String source) {
    return new ExampleId(Integer.parseInt(source));
  }
}
