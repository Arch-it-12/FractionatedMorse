/** 
  Author: Mark Estep
  Date: 1/5/22
  Edited:
**/

public class SubstitutionCipher implements Cipherable{
  private String key;
  public SubstitutionCipher(String k){
    key = k;
  }
  public String encode(String in){
    String upper = in.toUpperCase();
    String ans = "";
    for(int i = 0; i < in.length(); i++){
      char upperCh= upper.charAt(i);
      if(Character.isLetter(upperCh)){
        int index = upperCh - 'A';
        char letter = key.charAt(index);
        if(Character.isLowerCase(in.charAt(i))){
          letter = Character.toLowerCase(letter);
        }
        ans += letter;
      }else{
        ans += upperCh;
      }
    }
    return ans;
  }
  //"QWERTYUIOPASDFGHJKLZXCVBNM"
  public String decode(String in){
    String upper = in.toUpperCase();
    String ans = "";
    for(int i = 0; i < in.length(); i++){
      char upperCh= upper.charAt(i);
      if(Character.isLetter(upperCh)){
        int index = key.indexOf(upperCh);//upperCh - 'A';
        char letter = (char)(index + 'A');//key.charAt(index);
        if(Character.isLowerCase(in.charAt(i))){
          letter = Character.toLowerCase(letter);
        }
        ans += letter;
      }else{
        ans += upperCh;
      }
    }
    return ans;
  }
}