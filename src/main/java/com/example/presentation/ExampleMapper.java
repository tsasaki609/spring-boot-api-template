package com.example.presentation;

import com.example.domain.Example;
import com.example.presentation.ExampleController.CreateExampleRequest;
import com.example.presentation.ExampleController.ExampleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationName = "PresentationExampleMapperImpl")
public interface ExampleMapper {
  @Mapping(source = "id", target = "id.value")
  @Mapping(source = "property1", target = "property1.value")
  @Mapping(source = "property2", target = "property2.value")
  Example toDomain(CreateExampleRequest request);

  @Mapping(source = "id.value", target = "id")
  @Mapping(source = "property1.value", target = "property1")
  @Mapping(source = "property2.value", target = "property2")
  ExampleResponse toResponse(Example example);
}
