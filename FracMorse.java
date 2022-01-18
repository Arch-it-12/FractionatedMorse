/*
Archit Ashok
Block Y
1/17/22

Fractionated Morse Code Cipher Class
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class FracMorse implements Cipherable {
    private ArrayList<Character> key = new ArrayList<>();
    private final ArrayList<String> morse = new ArrayList<>(Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", ".-.-.-", "--..--", "---...", "---...", ".-..-.", ".----.", "-.-.--", "..--..", ".--.-.", "-....-"
            , "-.-.-.", "-.--.", "-.--.-", "-...-"));
    private final ArrayList<String> table = new ArrayList<>(Arrays.asList("...", "..-", "..x", ".-.", ".--", ".-x", ".x.", ".x-", ".xx", "-..", "-.-", "-.x", "--.",
            "---", "--x", "-x.", "-x-", "-xx", "x..", "x.-", "x.x", "x-.", "x--", "x-x", "xx.", "xx-"));

    public FracMorse(String key) {
        for(char val : key.toLowerCase(Locale.ROOT).toCharArray()) {
            this.key.add(val);
        }

        ArrayList<Character> key2 = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5',
                '6', '7', '8', '9', '0', '.', ',', ':', '"', '\'', '!', '?', '@', '-', ';', '(', ')', '='));
        this.key.addAll(key2);
    }

    public FracMorse() {
        this("QWERTYUIOPASDFGHJKLZXCVBNM");
    }

    @Override
    public String encode(String in) {
        in = in.toLowerCase(Locale.ROOT);
        StringBuilder morseCode = new StringBuilder();

        for(char val : in.toCharArray()) {
            if(val == ' ') {
                morseCode.append("x");
            } else {
                morseCode.append(this.morse.get(this.key.indexOf(val)));
                morseCode.append("x");
            }
        }

        morseCode.delete(morseCode.length(), morseCode.length() + 1);
        while(morseCode.length() % 3 != 0) {
            morseCode.append("x");
        }

        StringBuilder encoded = new StringBuilder();
        for(int i = 0; i < morseCode.length(); i+=3) {
            String m = morseCode.substring(i, i+3);
            int j = table.indexOf(m);
            System.out.println(m);
            encoded.append(key.get(j));
        }

        return encoded.toString();
    }

    @Override
    public String decode(String in) {
        in = in.toLowerCase(Locale.ROOT);

        StringBuilder morseCode = new StringBuilder();
        for(char val:in.toCharArray()) {
            morseCode.append(table.get(key.indexOf(val)));
        }

        StringBuilder temp = new StringBuilder();
        StringBuilder decoded = new StringBuilder();

        for(char val:morseCode.toString().toCharArray()) {
            if(temp.toString().equals("x")) {
                if(val == 'x') {
                    decoded.append(" ");
                    continue;
                }
                temp.setLength(0);
            } if(val != 'x') {
                temp.append(val);
            } else {
                decoded.append(key.get(morse.indexOf(temp.toString())));
                temp.setLength(0);
                temp.append('x');
            }
        }

        return decoded.toString();
    }
}
