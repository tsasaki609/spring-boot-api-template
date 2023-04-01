package com.example.demo.domain;

import lombok.NonNull;
import org.springframework.data.annotation.Id;

public record Demo(@NonNull @Id DemoId id,
                   @NonNull DemoProperty1 property1,
                   @NonNull DemoProperty2 property2) {
}
