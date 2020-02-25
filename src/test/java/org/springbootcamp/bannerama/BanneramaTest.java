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

    assertThat(banner).isEqualTo("  _          _ _                                _     _ \n"
      + " | |        | | |                              | |   | |\n"
      + " | |__   ___| | | ___ ________      _____  _ __| | __| |\n"
      + " | '_ \\ / _ \\ | |/ _ \\______\\ \\ /\\ / / _ \\| '__| |/ _` |\n"
      + " | | | |  __/ | | (_) |      \\ V  V / (_) | |  | | (_| |\n"
      + " |_| |_|\\___|_|_|\\___/        \\_/\\_/ \\___/|_|  |_|\\__,_|\n"
      + "                                                        \n"
      + "                                                        \n"
      + "banner=Bannerama(text=hello-world, font=BIG, debug=true)\n"
      + "environment=EnvironmentFake{properties={}}\n"
      + "sourceClass=class org.springbootcamp.bannerama.BanneramaTest\n");
  }
}
