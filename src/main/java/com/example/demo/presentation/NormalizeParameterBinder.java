package com.example.demo.presentation;

import com.google.common.base.CaseFormat;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class NormalizeParameterBinder {
  @InitBinder
  public void initBinder(
      WebDataBinder binder, WebRequest request, HttpServletRequest httpServletRequest) {
    final var propertyValues = new MutablePropertyValues();
    request
        .getParameterNames()
        .forEachRemaining(
            name -> {
              if (!StringUtils.contains(name, '-')) {
                return;
              }

              final var values = request.getParameterValues(name);
              Arrays.stream(values)
                  .sequential()
                  .forEach(
                      value ->
                          propertyValues.add(
                              CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, name), value));
            });
    binder.bind(propertyValues);
  }
}
