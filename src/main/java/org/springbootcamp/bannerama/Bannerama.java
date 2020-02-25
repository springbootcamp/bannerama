package org.springbootcamp.bannerama;

import java.io.PrintStream;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NonNull;
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

  @Override
  @SneakyThrows
  public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
    out.println(font.renderText(text));

    if (debug) {
      out.println("banner=" + this);
      out.println("environment=" + environment);
      out.println("sourceClass=" + sourceClass);
    }
  }
}
