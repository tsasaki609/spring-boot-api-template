package com.example.domain;

import lombok.NonNull;
import org.springframework.data.annotation.Id;

public record Example(
    @NonNull @Id ExampleId id,
    @NonNull ExampleProperty1 property1,
    @NonNull ExampleProperty2 property2) {}
