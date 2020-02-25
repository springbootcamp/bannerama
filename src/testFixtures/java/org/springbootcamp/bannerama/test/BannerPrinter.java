package org.springbootcamp.bannerama.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

@Value
public class BannerPrinter implements Function<Banner, String> {

  private static final Charset CHARSET = StandardCharsets.UTF_8;

  private final Environment environment;
  private Class<?> sourceClass;

  @Override
  @SneakyThrows
  public String apply(Banner banner) {
    try (
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos, true, CHARSET.name())
    ) {
      banner.printBanner(environment, sourceClass, ps);

      return new String(baos.toByteArray(), CHARSET);
    }
  }
}
