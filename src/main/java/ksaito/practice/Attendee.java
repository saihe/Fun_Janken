package ksaito.practice;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.BufferedReader;
import java.io.IOException;

@Accessors(fluent = true, chain = true)
@Setter
public abstract class Attendee {
  /** 参加者名. */
  protected String name;
  /** 参加者選択手. */
  protected Hands hand;

  /**
   * 参加者名を入力させる.
   * @param br .
   * @throws IOException .
   */
  public abstract void inputName(BufferedReader br) throws IOException;

  /**
   * 手を選択する.
   * @param br .
   * @throws IOException .
   */
  public abstract void choice(BufferedReader br) throws IOException;

  public String toString() {
    return String.format("%s：%s", this.name, this.hand);
  }
}
