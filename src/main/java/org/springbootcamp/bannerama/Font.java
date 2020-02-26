package org.springbootcamp.bannerama;

import static com.github.dtmo.jfiglet.FigFontResources.BIG_FLF;
import static com.github.dtmo.jfiglet.FigFontResources.SLANT_FLF;
import static com.github.dtmo.jfiglet.FigFontResources.SMALL_FLF;
import static com.github.dtmo.jfiglet.FigFontResources.STANDARD_FLF;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Font collection, references {@link com.github.dtmo.jfiglet.FigFontResources}.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Font {

  BIG(BIG_FLF),
  SLANT(SLANT_FLF),
  SMALL(SMALL_FLF),
  STANDARD(STANDARD_FLF),
  ;

  @Getter
  private final String flf;

}
