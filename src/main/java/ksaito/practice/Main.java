package ksaito.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      var p = new Processor();
      System.out.println("じゃんけんをします。");
      p.play(br, p.setupAttendees(br, p.setupAttendeesCount(br)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}