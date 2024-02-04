package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class CaesarCipher extends Algorithm {
    private HashMap<Character, Character> encryptAlphabet = new HashMap<>();

    public CaesarCipher(int key, ArrayList<Character> alphabet) {
        for (int i = 0; i < alphabet.size(); i++) {
            encryptAlphabet.put(alphabet.get(i), alphabet.get((i + key) % alphabet.size()));
        }
    }

    public char[] encrypt(char[] array, int bytesRead) {
        char[] encryptedArray = new char[array.length];
        for (int i = 0; i < bytesRead; i++) {
            char currentChar = array[i];
            encryptedArray[i] = encryptAlphabet.getOrDefault(currentChar, currentChar);
        }
        return encryptedArray;
    }
}
