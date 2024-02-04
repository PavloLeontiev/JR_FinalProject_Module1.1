package util;

import mode.CipherMode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InitializeVigenereKey {
    public static int[] initializeKey(String cipherMode, String filePath, String key, ArrayList<Character> alphabet){
        return switch (CipherMode.valueOf(cipherMode)){
            case ENCRYPT -> getEncryptKey(key, alphabet);
            case DECRYPT -> getDecryptKey(key, alphabet);
            case BRUTE_FORCE -> getBruteForceKey(filePath);
        };
    }

    private static int[] getEncryptKey(String key, ArrayList<Character> alphabet) {
        int[] modifyKey = new int[key.length()];
        for (int i = 0; i < modifyKey.length; i++){
            modifyKey[i] = alphabet.indexOf(key.charAt(i));
        }
        return modifyKey;
    }

    private static int[] getDecryptKey(String key, ArrayList<Character> alphabet) {
        int[] modifyKey = new int[key.length()];
        for (int i = 0; i < modifyKey.length; i++){
            modifyKey[i] = alphabet.size() - alphabet.indexOf(key.charAt(i));
        }
        return modifyKey;
    }

    private static int[] getBruteForceKey(String filePath) {
        return null;
    }
}
