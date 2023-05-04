package com.example;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.example", importOptions = ImportOption.DoNotIncludeTests.class)
public class ExampleArchitectureTest {
  @ArchTest
  static final ArchRule domainRule =
      noClasses()
          .that()
          .resideInAPackage("com.example.domain..")
          .should()
          .dependOnClassesThat()
          .resideOutsideOfPackages(
              "com.example.domain..",
              "org.springframework.lang..",
              "reactor.core.publisher..",
              "lombok..",
              "java..",
              "javax..");

  //TODO usecase,presentation,infrastructure
}
