package org.springbootcamp.bannerama.test;

import java.util.Map;
import java.util.Optional;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.lang.NonNull;

@Value
@Builder
public class EnvironmentFake implements Environment {

  public static final Environment EMPTY = EnvironmentFake.builder().build();

  @Singular
  @lombok.NonNull
  private final Map<String,String> properties;

  @Override
  @NonNull
  public String[] getActiveProfiles() {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  @NonNull
  public String[] getDefaultProfiles() {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  @NonNull
  public boolean acceptsProfiles(String... profiles) {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public boolean acceptsProfiles(Profiles profiles) {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public boolean containsProperty(String key) {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public String getProperty(String key) {
    return getProperty(key, (String)null);
  }

  @Override
  public String getProperty(String key, String defaultValue) {
    return Optional.ofNullable(properties.get(key)).orElse(defaultValue);
  }

  @Override
  public <T> T getProperty(String key, Class<T> targetType) {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public String getRequiredProperty(String key) throws IllegalStateException {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public String resolvePlaceholders(String text) {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
    throw new UnsupportedOperationException("not implemented");
  }

  @Override
  public String toString() {
    return "EnvironmentFake{" +
      "properties=" + properties +
      '}';
  }
}
