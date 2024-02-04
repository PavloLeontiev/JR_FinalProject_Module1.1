package util;

import algorithm.Algorithm;
import algorithm.CaesarCipher;
import algorithm.VigenereCipher;
import util.InitializeCaesarKey;

import java.util.ArrayList;

public class DefineAlgorithm {
    public static Algorithm defineAlgorithm(String mode, String filePath, String key, ArrayList<Character> alphabet) {
        if (key.matches("^[0-9]*$")) {
            int modifyKey = InitializeCaesarKey.initializeKey(mode, filePath, key, alphabet);
            return new CaesarCipher(modifyKey, alphabet);
        } else if (key.matches("^[a-zA-Zа-яА-ЯІіЇїЄєҐґ]*$")) {
            int[] modifyKey = InitializeVigenereKey.initializeKey(mode, filePath, key, alphabet);
            return new VigenereCipher(modifyKey, alphabet);
        }
        return null;
    }
}
