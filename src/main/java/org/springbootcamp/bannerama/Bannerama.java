package org.springbootcamp.bannerama;

import com.github.dtmo.jfiglet.FigletRenderer;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Map;
import java.util.Optional;

import static com.github.dtmo.jfiglet.FigFontResources.loadFigFontResource;
import static org.springbootcamp.bannerama.Bannerama.PlaceHolders.APPLICATION_NAME;
import static org.springbootcamp.bannerama.Bannerama.PlaceHolders.MANIFEST_TITLE;
import static org.springbootcamp.bannerama.Bannerama.PlaceHolders.MANIFEST_VERSION;
import static org.springbootcamp.bannerama.Bannerama.PlaceHolders.SPRINGBOOT_VERSION;

//  ${application.formatted-version}	The version number of your application, as declared in MANIFEST.MF and formatted for display

@Value
@Builder
public class Bannerama implements Banner {

  public static final Bannerama DEFAULT = Bannerama.builder().build();

  @Default
  @NonNull String text = APPLICATION_NAME;

  @Default
  @NonNull String title = MANIFEST_TITLE;

  @Default
  @NonNull String version = MANIFEST_VERSION;

  @Default
  @NonNull String springBootVersion = SPRINGBOOT_VERSION;

  @NonNull
  @Singular
  Map<String, String> additionalVersions;

  @Default
  @NonNull Font font = Font.STANDARD;

  @Default
  boolean debug = false;

  @Default
  int newLinesAfter = 1;

  @Override
  @SneakyThrows
  public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
    new Worker(environment, sourceClass, out)
      .before()
      .banner()
      .versions()
      .debug()
      .after()
      .close();
  }

  @RequiredArgsConstructor
  private class Worker {

    private final Environment environment;
    private final Class<?> sourceClass;
    private final PrintStream out;

    Worker before() {
      return newLines(1);
    }

    @SneakyThrows
    Worker banner() {
      return println(new FigletRenderer(loadFigFontResource(font.getFlf())).renderText(
        resolveString(text, sourceClass.getSimpleName().toLowerCase())
      ))
        .println(Optional.ofNullable(resolveString(title)).map(it -> "  :: " + it + "  ::").orElse(null))
        .newLines(1);
    }

    Worker versions() {
      printVersion("Application Version", version, "N/A");
      printVersion("SpringBoot Version ", springBootVersion, "N/A");

      additionalVersions.forEach((label, value) -> printVersion(label, value, "N/A"));

      return this;
    }

    Worker printVersion(String label, String value, String defaultValue) {
      return println(String.format(
        "  > %s\t= %s",
        label,
        resolveString(value, defaultValue))
      );
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

    void close() {
      println(resolveString("${AnsiColor.DEFAULT}", null));
    }

    Worker println(String line) {
      Optional.ofNullable(line).ifPresent(out::println);
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
      return resolveString(value, null);
    }

    private String resolveString(String value, String defaultValue) {
      return (value.startsWith("${") && value.endsWith("}"))
        ? environment.getProperty(value.substring(2, value.length() - 1), defaultValue)
        : value;
    }
  }

  public enum PlaceHolders {
    ;

    public static final String APPLICATION_NAME = "${spring.application.name}";
    public static final String MANIFEST_TITLE = "${application.title}";
    public static final String MANIFEST_VERSION = "${application.version}";
    public static final String MANIFEST_FORMATTED_VERSION = "${application.formatted-version}";
    public static final String SPRINGBOOT_VERSION = "${spring-boot.version}";
    public static final String SPRINGBOOT_FORMATTED_VERSION = "${spring-boot.formatted-version}";
  }
}
