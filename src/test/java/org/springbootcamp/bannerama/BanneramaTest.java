package org.springbootcamp.bannerama;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springbootcamp.bannerama.test.EnvironmentFake.EMPTY;

import org.junit.jupiter.api.Test;
import org.springbootcamp.bannerama.test.BannerPrinter;

class BanneramaTest {

  @Test
  void just_text() {
    String banner =  new BannerPrinter(EMPTY, BanneramaTest.class)
      .apply(Bannerama.builder()
        .font(Font.BIG)
        .text("hello-world")
        .debug(true)
        .build());

    assertThat(banner).isEqualTo("\n"
      + "\n"
      + "  _          _ _                                _     _ \n"
      + " | |        | | |                              | |   | |\n"
      + " | |__   ___| | | ___ ________      _____  _ __| | __| |\n"
      + " | '_ \\ / _ \\ | |/ _ \\______\\ \\ /\\ / / _ \\| '__| |/ _` |\n"
      + " | | | |  __/ | | (_) |      \\ V  V / (_) | |  | | (_| |\n"
      + " |_| |_|\\___|_|_|\\___/        \\_/\\_/ \\___/|_|  |_|\\__,_|\n"
      + "                                                        \n"
      + "                                                        \n"
      + "\n"
      + "  > Application Version\t= N/A\n"
      + "  > SpringBoot Version \t= N/A\n"
      + "\n"
      + "\n"
      + "Debug:\n"
      + "\tbanner=Bannerama(text=hello-world, title=${application.title}, version=${application.version}, springBootVersion=${spring-boot.version}, additionalVersions={}, font=BIG, debug=true, newLinesAfter=3)\n"
      + "\tenvironment=EnvironmentFake{properties={}}\n"
      + "\tsourceClass=class org.springbootcamp.bannerama.BanneramaTest\n"
      + "\n"
      + "\n"
      + "\n");
  }

  @Test
  void application_name() {
    System.out.println(new BannerPrinter(EMPTY, BanneramaTest.class).apply(Bannerama.DEFAULT));
  }
}
