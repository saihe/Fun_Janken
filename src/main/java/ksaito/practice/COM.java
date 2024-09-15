package ksaito.practice;

import java.io.BufferedReader;
import java.security.SecureRandom;
import java.util.UUID;

public class COM extends Attendee {
  @Override
  public void inputName(BufferedReader br) {
    this.name = String.format("COM_%s", UUID.randomUUID());
  }

  @Override
  public void choice(BufferedReader br) {
    Hands.choice(new SecureRandom().nextInt(3)).ifPresentOrElse(
      h -> this.hand = h,
      () -> this.hand = Hands.Rock
    );
  }
}
