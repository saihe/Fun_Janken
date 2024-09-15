package ksaito.practice;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {
  private final Processor target = new Processor();

  @Nested
  class Judge {
    @Test
    void rockWinsBy2Players() {
      var params = new ArrayList<Attendee>(){{
        add(new Player().hand(Hands.Rock));
        add(new Player().hand(Hands.Scissors));
      }};
      assertEquals(Optional.of(Hands.Rock), target.judge(params));
    }
    @Test
    void rockWinsBy3Players() {
      var params = new ArrayList<Attendee>(){{
        add(new Player().hand(Hands.Rock));
        add(new Player().hand(Hands.Rock));
        add(new Player().hand(Hands.Scissors));
      }};
      assertEquals(Optional.of(Hands.Rock), target.judge(params));
    }

    @Test
    void drawBy2Players() {
      var params = new ArrayList<Attendee>(){{
        add(new Player().hand(Hands.Rock));
        add(new Player().hand(Hands.Rock));
      }};
      assertEquals(Optional.empty(), target.judge(params));
    }

    @Test
    void drawBy3Players() {
      var params = new ArrayList<Attendee>(){{
        add(new Player().hand(Hands.Rock));
        add(new Player().hand(Hands.Rock));
        add(new Player().hand(Hands.Rock));
      }};
      assertEquals(Optional.empty(), target.judge(params));
    }
  }
}