package util;

import alphabet.Alphabet;
import alphabet.EnglishAlphabet;
import alphabet.UkrainianAlphabet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DefineLanguageInFileContent {
    private static ArrayList<Character> english = new EnglishAlphabet().getARRAY_LIST();
    private static ArrayList<Character> ukrainian = new UkrainianAlphabet().getARRAY_LIST();
    private static int englishCoincidences;
    private static int ukrainianCoincidences;
    private static int bufferCapacity = 1024;
    public static Alphabet defineLanguage(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            char[] charArray = new char[bufferCapacity];
            reader.read(charArray);
            for (char ch : charArray) {
                if (english.contains(ch)) {
                    englishCoincidences++;
                } else if (ukrainian.contains(ch)) {
                    ukrainianCoincidences++;
                }
            }
            return englishCoincidences > ukrainianCoincidences ? new EnglishAlphabet() : new UkrainianAlphabet();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
