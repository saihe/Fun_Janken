package ksaito.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandsTest {

  @Test
  void toBeRock() {
    var result = Hands.choice(0);
    assertTrue(result.isPresent());
    assertEquals(Hands.Rock, result.get());
  }

  @Test
  void toBePaper() {
    var result = Hands.choice(1);
    assertTrue(result.isPresent());
    assertEquals(Hands.Paper, result.get());
  }

  @Test
  void toBeScissors() {
    var result = Hands.choice(2);
    assertTrue(result.isPresent());
    assertEquals(Hands.Scissors, result.get());
  }
}