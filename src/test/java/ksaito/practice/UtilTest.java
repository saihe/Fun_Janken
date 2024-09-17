package ksaito.practice;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {

  @Nested
  class IsY {
    @ParameterizedTest
    @ValueSource(strings = {"Y", ""})
    void toBeTrue(String param) {
      assertTrue(Util.isY(param));
    }

    @ParameterizedTest
    @ValueSource(strings = {"n", " ", "　", "1", "abc", "あ", "-1", "1234567890-^[@poiuytrewqasdfghjkl;:]/.,mnbvcxz"})
    void toBeFalse(String param) {
      assertFalse(Util.isY(param));
    }
  }

  @Nested
  class IsOtherThanYes {
    @ParameterizedTest
    @ValueSource(strings = {"n", " ", "　", "1", "abc", "あ", "-1", "1234567890-^[@poiuytrewqasdfghjkl;:]/.,mnbvcxz"})
    void toBeTrue(String param) {
      assertTrue(Util.isOtherThanYes(param));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Y", ""})
    void toBeFalse(String param) {
      assertFalse(Util.isOtherThanYes(param));
    }
  }
}