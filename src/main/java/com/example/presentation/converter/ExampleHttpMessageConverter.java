package com.example.presentation.converter;

import com.example.domain.Example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class ExampleHttpMessageConverter extends AbstractHttpMessageConverter<Example> {
  private final ObjectMapper objectMapper;

  public ExampleHttpMessageConverter(ObjectMapper objectMapper) {
    super(MediaType.TEXT_EVENT_STREAM);
    this.objectMapper = objectMapper;
  }

  @Override
  protected boolean supports(Class<?> clazz) {
    return Example.class.isAssignableFrom(clazz);
  }

  @Override
  protected Example readInternal(Class<? extends Example> clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {
    try (InputStream inputStream = inputMessage.getBody()) {
      return objectMapper.readValue(inputStream, clazz);
    } catch (JsonProcessingException e) {
      throw new HttpMessageNotReadableException(
          "Failed to read JSON request body", e, inputMessage);
    }
  }

  @Override
  protected void writeInternal(Example example, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {
    try (OutputStream outputStream = outputMessage.getBody()) {
      objectMapper.writeValue(outputStream, example);
    } catch (JsonProcessingException e) {
      throw new HttpMessageNotWritableException("Failed to write JSON response body", e);
    }
  }
}
