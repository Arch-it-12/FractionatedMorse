/** 
  Author: Mark Estep
  Date: 1/7/22
  Edited:
**/

public class MyCipherApp {
  public static void main(String[] args) {
    do {
      Cipherable cipher = getCipherChoiceFromUser();
      switch (getEncodeOrDecodeFromUser()) {
        case 1: // Code

          break;
        case 2: // Decode

          break;
        default:
          System.out.println("There has been an error - this line should never print");

      }
    } while (userWantsToContinue());
    System.out.println("Thank you for using the Cipher App.");
  }

  public static Cipherable getCipherChoiceFromUser() {
    return new CaesarCipher(1);
  }

  public static int getEncodeOrDecodeFromUser() {
    return 1;
  }

  public static boolean userWantsToContinue() {
    return false;
  }
}