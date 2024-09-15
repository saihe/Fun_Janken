package ksaito.practice;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 参加者：プレイヤー（手動操作）.
 */
public class Player extends Attendee {
  @Override
  public void inputName(BufferedReader br) throws IOException {
    var inputIsNotFinished = true;
    while (inputIsNotFinished) {
      System.out.println("名前を入力してください。");
      this.name = br.readLine();
      if (this.name.isEmpty()) {
        this.name = "Player";
      }
      System.out.printf("%s　この名前で決定しますか？[Y/n]%n", this.name);
      var input = br.readLine();
      if (input.equalsIgnoreCase("Y") || input.isEmpty()) {
        inputIsNotFinished = false;
      }
    }
  }

  @Override
  public void choice(BufferedReader br) throws IOException {
    var selectedValueIsInvalid = true;
    while (selectedValueIsInvalid) {
      System.out.println("手を選択してください。");
      System.out.println("[0：グー、1：パー、2：チョキ]");
      var input = br.readLine();
      switch (input) {
        case "0", "1", "2" -> {
          selectedValueIsInvalid = false;
          Hands.choice(Integer.parseInt(input)).ifPresent(h -> this.hand = h);
        }
        default -> System.out.println("入力された値が不正です。（入力可能値：[0, 1, 2]）");
      }
    }
  }
}
