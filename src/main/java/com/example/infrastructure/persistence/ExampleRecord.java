package com.example.infrastructure.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("example")
@Data
public class ExampleRecord {
  private @Id Integer id;
  private String property1;
  private String property2;
}
