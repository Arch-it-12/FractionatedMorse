import java.util.*;

/**
  Author: Mark Estep
  Date: 1/7/22
  Edited: Archit Ashok, 1/17/22
**/

public class MyCipherApp {
  public static void main(String[] args) {
    int option = checkOption(3, "What Cipher would you like to do?\n\t0 - Caesar Cipher\n\t1 - Modified Railfence\n\t2 - Substitution Cipher\n\t3 - Fractionated Morse\n\n");
    int code = checkOption(1, "Would you like to encode (0) or decode (1): ");
    String message = checkMessage("Please enter the message you would like to encode/decode");
    int key;
    String key1;
    Cipherable l;

    switch (option) {
      case 0:
        key = Integer.parseInt(checkInput(true));
        l = new CaesarCipher(key);
        break;
      case 1:
        key = Integer.parseInt(checkInput(true));
        l = new ModifiedRailFenceCipher(key);
        break;
      case 2:
        key1 = checkInput(false);
        l = new SubstitutionCipher(key1);
        break;
      case 3:
        key1 = checkInput(false);
        l = new FracMorse(key1);
        break;
      default:
        l = new CaesarCipher(1);
        break;
    }

    switch (code) {
      case 0:
        System.out.println(l.encode(message));
        break;
      case 1:
        System.out.println(l.decode(message));
        break;
    }
  }

  public static int checkOption(int max, String prompt) {
    Scanner skan = new Scanner(System.in);
    System.out.println(prompt);
    boolean flag;
    int option = 1;
    do {
      flag = false;
      try {
        option = skan.nextInt();

        if(option < 0 || option > max) {
          System.out.println();
          flag = true;
        }
      } catch (InputMismatchException e) {
        System.out.println("Please enter a valid integer!\n");
        skan.nextLine();
        flag = true;
      }
    } while (flag);

    return option;
  }

  public static String checkMessage(String prompt) {
    System.out.println(prompt + ": ");
    Scanner skan = new Scanner(System.in);
    String message = "";
    boolean flag;
    do {
      flag = false;
      try {
        message = skan.nextLine();
      } catch (InputMismatchException e) {
        skan.nextLine();
        System.out.println("Invalid Input!\n");
        flag = true;
      }
    } while (flag);

    return message;
  }

  public static String checkInput(boolean is_int) {
    System.out.println("Please enter the key: ");
    Scanner skan = new Scanner(System.in);
    boolean flag;

    String key1 = "";

    do {
      flag = false;
      ArrayList<String> keyList = new ArrayList<>();
      ArrayList<String> check = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
      if(is_int) {
        try {
          int key = skan.nextInt();
          key1 = Integer.toString(key);
        } catch (InputMismatchException e) {
          System.out.print("Invalid Input!  Please enter a valid integer\n");
          skan.nextLine();
          flag = true;
        }
      } else {
        try {
          key1 = skan.next();

          for(char val:key1.toLowerCase(Locale.ROOT).toCharArray()) {
            keyList.add(Character.toString(val));
          }
          
          keyList.sort(String.CASE_INSENSITIVE_ORDER);

          if(!keyList.equals(check)) {
            System.out.println("Invalid Input!  Please enter all 26 letters in any order with no spaces\n");
            flag = true;
          }
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input!  Please enter all 26 letters in any order with no spaces\n");
          skan.nextLine();
          flag = true;
        }


      }
    } while(flag);

    return key1;
  }
}