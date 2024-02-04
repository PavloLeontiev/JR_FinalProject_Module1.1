package util;

import mode.CipherMode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InitializeCaesarKey {
    public static int initializeKey(String cipherMode, String filePath, String key, ArrayList<Character> alphabet){
        return switch (CipherMode.valueOf(cipherMode)){
            case ENCRYPT -> getEncryptKey(key, alphabet);
            case DECRYPT -> getDecryptKey(key, alphabet);
            case BRUTE_FORCE -> getBruteForceKey(filePath);
        };

    }

    private static int getEncryptKey(String key, ArrayList<Character> alphabet) {
        return Integer.parseInt(key) % alphabet.size();

    }

    private static int getDecryptKey(String key, ArrayList<Character> alphabet) {
        return alphabet.size() - (Integer.parseInt(key) % alphabet.size());
    }

    private static int getBruteForceKey(String filePath) {
        return 0;
    }
}
