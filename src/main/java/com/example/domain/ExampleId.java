package com.example.domain;

import lombok.Getter;
import lombok.NonNull;

public class ExampleId {
  public static Integer UNREGISTERED_PLACE_HOLDER_ID = Integer.MAX_VALUE;
  private final @Getter Integer value;

  public ExampleId(@NonNull Integer value) {
    if (value < 0) {
      throw new IllegalArgumentException("id must be positive");
    }

    this.value = value;
  }
}
