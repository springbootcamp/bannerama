package org.springbootcamp.bannerama;

import java.io.PrintStream;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

@Value
@Builder
public class Bannerama implements Banner {

  public static final Bannerama DEFAULT = Bannerama.builder().build();

  @Default
  @NonNull
  private String text = "${spring.application.name}";

  @Default
  @NonNull
  private Font font = Font.STANDARD;

  @Default
  private boolean debug = false;

  @Default
  private int newLinesAfter = 3;

  @Override
  @SneakyThrows
  public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
    new Worker(environment, sourceClass, out)
      .before()
      .banner()
      .debug()
      .after();
  }

  @RequiredArgsConstructor
  private class Worker {

    private final Environment environment;
    private final Class<?> sourceClass;
    private final PrintStream out;

    Worker before() {
      return newLines(2);
    }

    Worker banner() {
      return println(font.renderText(resolveString(text)));
    }

    Worker debug() {

      if (debug) {
        out.println("\nDebug:");
        out.println("\tbanner=" + Bannerama.this);
        out.println("\tenvironment=" + environment);
        out.println("\tsourceClass=" + sourceClass);
      }
      return this;
    }

    Worker after() {
      return newLines(newLinesAfter);
    }

    Worker println(String... lines) {
      Stream.of(lines).forEach(out::println);
      return this;
    }

    private Worker newLines(int num) {
      if (num > 0) {
        for (int i = 0; i < num; i++) {
          out.println("");
        }
      }
      return this;
    }

    private String resolveString(String value) {
      return (value.startsWith("${") && value.endsWith("}"))
        ? environment.getProperty(value.substring(2, value.length()-1), value)
        : value;
    }
  }
}
