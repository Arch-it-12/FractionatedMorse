/** 
  Author: Mark Estep
  Date: 1/5/22
  Edited:
**/

public class ModifiedRailFenceCipher implements Cipherable{
  private int numRails;
  public ModifiedRailFenceCipher(int r){
    numRails = Math.abs(r);
  }
  public String encode(String in){
    String ans = "";
     //pad with spaces so string length is mulitple of numRails
    while(in.length() % numRails != 0){
      in += '\t';
    }
    for(int rail = 0; rail < numRails; rail++){
      for(int place = rail; place < in.length(); place+=numRails){
        ans += in.charAt(place);
      }
    }
    return ans;
  }
  public String decode(String in){
    String ans = "";
    int j = in.length() / numRails;
    for(int i = 0; i < j; i++){
      for(int place = i; place < in.length(); place += j){
        if(in.charAt(place) != '\t'){
          ans += in.charAt(place);
       }
      }
    }
    return ans;
  }
}