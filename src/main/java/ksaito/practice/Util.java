package ksaito.practice;

public class Util {

  /**
   * 入力値が"Y"または空文字のときにTRUE
   * @param input 文字列
   * @return .
   */
  public static boolean isY(String input) {
    return input.equalsIgnoreCase("Y") || input.isEmpty();
  }

  /**
   * 入力値が"Y"または空文字以外の時にTRUE
   * @param input 文字列
   * @return .
   */
  public static boolean isOtherThanYes(String input) {
    return Util.isY(input);
  }
}
