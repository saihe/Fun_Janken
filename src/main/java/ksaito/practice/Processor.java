package ksaito.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Processor {
  /**
   * 参加人数、プレイヤー人数およびプレイヤー名を決定する。
   * @param br .
   * @return 参加者
   * @throws IOException .
   */
  public List<Attendee> setup(BufferedReader br) throws IOException {
    Attendee[] res = null;

    var isNotFinishedSetUp = true;
    while (isNotFinishedSetUp) {
      System.out.print("参加人数：");
      var input = br.readLine();
      if (input.matches("\\d+")) {
        var attendeeCount = Integer.parseInt(input);
        System.out.printf("参加人数は %d 人ですね？[Y/n]%n", attendeeCount);
        input = br.readLine();
        if (input.equalsIgnoreCase("Y") || input.isEmpty()) {
          isNotFinishedSetUp = false;
          res = new Attendee[attendeeCount];
        }
      } else {
        System.out.println("入力値が不正です。操作をやり直してください。");
      }
    }

    isNotFinishedSetUp = true;
    while (isNotFinishedSetUp) {
      System.out.print("プレイヤー人数：");
      var input = br.readLine();
      if (input.matches("\\d+")) {
        var playerCount = Integer.parseInt(input);
        if (playerCount < res.length) {
          System.out.printf("プレイヤー人数は %d 人ですね？[Y/n]%n", playerCount);
          input = br.readLine();
          if (input.equalsIgnoreCase("Y") || input.isEmpty()) {
            isNotFinishedSetUp = false;
            for (var i = 0; i < playerCount; i++) {
              res[i] = new Player();
              res[i].inputName(br);
            }
            for (var i = playerCount; i < res.length; i++) {
              res[i] = new COM();
              res[i].inputName(br);
            }
          }
        } else {
          System.out.println("参加人数よりプレイヤー人数が多くなってしました。操作をやり直してください。");
        }
      } else {
        System.out.println("入力値が不正です。操作をやり直してください。");
      }
    }
    return Arrays.asList(res);
  }

  /**
   * じゃんけんをする。
   * @param br .
   * @param attendees 参加者
   * @throws IOException .
   */
  public void play(BufferedReader br, List<Attendee> attendees) throws IOException {
    for (Attendee attendee: attendees) {
      attendee.choice(br);
    }

    System.out.println("じゃんけん、ぽん");
    attendees.forEach(System.out::println);

    var res = this.judge(attendees);
    if (res.isPresent()) {
      var winHand = res.get();
      System.out.println("以下勝利参加者です。");
      var winners = attendees.stream().filter(a -> a.hand == winHand).toList();
      winners.stream().map(w -> w.name).forEach(System.out::println);
      if (winners.size() > 1) {
        this.play(br, winners);
      }
    } else {
      this.play(br, attendees);
    }
  }

  public Optional<Hands> judge(List<Attendee> attendees) {
    if (
      (
        attendees.stream().anyMatch(a -> a.hand == Hands.Rock)
        && attendees.stream().anyMatch(a -> a.hand == Hands.Paper)
        && attendees.stream().anyMatch(a -> a.hand == Hands.Scissors)
      )
      || attendees.stream().filter(a -> a.hand == Hands.Rock).count() == attendees.size()
      || attendees.stream().filter(a -> a.hand == Hands.Paper).count() == attendees.size()
      || attendees.stream().filter(a -> a.hand == Hands.Scissors).count() == attendees.size()
    ) {
      System.out.println("あいこです。");
      return Optional.empty();
    }
    if (attendees.stream().noneMatch(a -> a.hand == Hands.Rock)) {
      System.out.printf("%s の勝ちです。%n", Hands.Scissors.displayName());
      return Optional.of(Hands.Scissors);
    }
    if (attendees.stream().noneMatch(a -> a.hand == Hands.Paper)) {
      System.out.printf("%s の勝ちです。%n", Hands.Rock.displayName());
      return Optional.of(Hands.Rock);
    }
    if (attendees.stream().noneMatch(a -> a.hand == Hands.Scissors)) {
      System.out.printf("%s の勝ちです。%n", Hands.Paper.displayName());
      return Optional.of(Hands.Paper);
    }
    return Optional.empty();
  }
}
