package com.example.demo.domain;

import lombok.NonNull;

public record Demo(@NonNull DemoId id,
                   @NonNull DemoProperty1 property1,
                   @NonNull DemoProperty2 property2) {
}
