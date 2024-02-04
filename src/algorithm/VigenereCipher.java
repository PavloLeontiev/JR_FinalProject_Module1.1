package algorithm;

import java.io.BufferedWriter;
import java.util.ArrayList;

public class VigenereCipher extends Algorithm{
    private ArrayList<Character> alphabet;
    private int[] key;
    public VigenereCipher(int[] key, ArrayList<Character> alphabet){
        this.alphabet = alphabet;
        this.key = key;
    }
    public BufferedWriter encrypt() {
        return null;
    }
}
