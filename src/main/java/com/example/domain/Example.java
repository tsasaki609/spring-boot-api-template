package com.example.domain;

import lombok.NonNull;

public record Example(
    @NonNull ExampleId id,
    @NonNull ExampleProperty1 property1,
    @NonNull ExampleProperty2 property2) {}
