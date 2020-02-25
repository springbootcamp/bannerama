package org.springbootcamp.bannerama;

import static com.github.dtmo.jfiglet.FigFontResources.loadFigFontResource;

import com.github.dtmo.jfiglet.FigFontResources;
import com.github.dtmo.jfiglet.FigletRenderer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Font {

  BIG(FigFontResources.BIG_FLF),
  STANDARD(FigFontResources.STANDARD_FLF),
  ;

  @Getter
  private final String flf;


  @SneakyThrows
  public String renderText(String text) {
    return new FigletRenderer(loadFigFontResource(flf)).renderText(text);
  }
}
