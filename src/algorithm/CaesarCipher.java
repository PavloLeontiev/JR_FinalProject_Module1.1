package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class CaesarCipher extends Algorithm {
    private HashMap<Character, Character> encryptAlphabet = new HashMap<>();
    private ArrayList<Character> alphabetArray;

    public CaesarCipher(int key, ArrayList<Character> alphabet) {
        this.alphabetArray = alphabet;
        for (int i = 0; i < alphabetArray.size(); i++) {
            encryptAlphabet.put(alphabetArray.get(i), alphabetArray.get((i + key) % alphabetArray.size()));
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
