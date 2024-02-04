package algorithm;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class CaesarCipher extends Algorithm{
    private HashMap<Character, Character> encryptAlphabet = new HashMap<>();
    public CaesarCipher(int key, ArrayList<Character> alphabet){
        for (int i = 0; i < alphabet.size(); i++) {
            encryptAlphabet.put(alphabet.get(i), alphabet.get(i + key));
        }
    }
    public BufferedWriter encrypt() {
        return null;
    }
}
