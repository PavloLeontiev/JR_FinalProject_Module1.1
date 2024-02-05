package util;

import algorithm.CaesarCipher;
import alphabet.Alphabet;
import mode.CipherMode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InitializeCaesarKey {
    public static int initializeKey(String cipherMode, String filePath, String key, Alphabet alphabet) {
        ArrayList<Character> arrayList = alphabet.getARRAY_LIST();
        ArrayList<String> stringArrayList = alphabet.getFREQUENTLY_USED_WORDS();
        return switch (CipherMode.valueOf(cipherMode)) {
            case ENCRYPT -> getEncryptKey(key, arrayList);
            case DECRYPT -> getDecryptKey(key, arrayList);
            case BRUTE_FORCE -> getBruteForce(filePath, arrayList, stringArrayList);
        };

    }

    private static int getEncryptKey(String key, ArrayList<Character> alphabet) {
        return Integer.parseInt(key) % alphabet.size();

    }

    private static int getDecryptKey(String key, ArrayList<Character> alphabet) {
        return alphabet.size() - (Integer.parseInt(key) % alphabet.size());
    }

    private static int getBruteForce(String filePath, ArrayList<Character> alphabet, ArrayList<String> frequentlyUsedWords) {
        HashMap<Integer, Integer> keySearch = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            char[] encryptedChars = new char[1024];
            int charsRead = reader.read(encryptedChars);
            for (int key = 0; key < alphabet.size(); key++) {
                int numberOfCoincidences = 0;
                char[] decryptedChars = new CaesarCipher(key, alphabet).encrypt(encryptedChars, charsRead);
                String[] wordsOfText = String.valueOf(decryptedChars).split(" ");
                for (int j = 0; j < wordsOfText.length; j++) {
                    if (frequentlyUsedWords.contains(wordsOfText[j])) {
                        numberOfCoincidences++;
                    }
                }
                keySearch.put(key, numberOfCoincidences);
            }
            int suitableKey = 0;
            int maxCoincidences = 0;
            for (int key : keySearch.keySet()) {
                int coincidences = keySearch.get(key);
                if (coincidences > maxCoincidences) {
                    maxCoincidences = coincidences;
                    suitableKey = key;
                }
            }
            return suitableKey;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
