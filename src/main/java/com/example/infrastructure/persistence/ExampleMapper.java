package com.example.infrastructure.persistence;

import com.example.domain.Example;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExampleMapper {

  @Mapping(source = "id.value", target = "id")
  @Mapping(source = "property1.value", target = "property1")
  @Mapping(source = "property2.value", target = "property2")
  ExampleRecord toRecord(Example example);

  @Mapping(source = "id", target = "id.value")
  @Mapping(source = "property1", target = "property1.value")
  @Mapping(source = "property2", target = "property2.value")
  Example toDomain(ExampleRecord example);
}
