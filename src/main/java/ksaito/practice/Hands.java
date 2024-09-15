package ksaito.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum Hands {
  Rock("グー"),
  Paper("パー"),
  Scissors("チョキ");

  private final String displayName;

  public static Optional<Hands> choice(int index) {
    return Stream.of(Hands.values()).filter(h -> h.ordinal() == index).findFirst();
  }

  public String toString() {
    return this.displayName;
  }
}
