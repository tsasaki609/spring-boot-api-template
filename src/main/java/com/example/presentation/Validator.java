package com.example.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Validator {
  private final jakarta.validation.Validator validator;

  public <T> void validate(T object) {
    final var violations = validator.validate(object);
    if (!violations.isEmpty()) {
      throw new IllegalArgumentException(violations.toString());
    }
  }
}
