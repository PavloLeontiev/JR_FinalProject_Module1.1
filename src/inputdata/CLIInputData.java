package inputdata;

import exception.FileNotFoundException;
import exception.IllegalCipherModeArgumentException;
import exception.IllegalKeyArgumentException;
import util.ValidationInputData;

import java.util.Scanner;

public class CLIInputData extends InputData {
    Scanner scanner = new Scanner(System.in);

    public String getCipherMode() {
        String cipherMode = "";
        try {
            System.out.println("""           
                Choose the mode: ENCRYPT / DECRYPT / BRUTE_FORCE 
                """);
            cipherMode = ValidationInputData.validateCipherMode(scanner.next().toUpperCase().trim());
        } catch (IllegalCipherModeArgumentException e) {
            System.out.println("Illegal cipher mode");
            getCipherMode();
        }
        return cipherMode;
    }

    public String getFilePath() {
        String filePath = "";
        System.out.println("""          
                Please enter the path to the file:
                                
                If there are spaces or special characters in the path to the jar file or to the text file.
                symbols: (* / \\ $ % & # @ ! ( ) { } [ ] , ; ' ” < > | ^ ~.)`,then enclose such a path in DOUBLE QUOTES     
                """);
        try {
            filePath = ValidationInputData.validateFilePath(scanner.next());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            filePath = ValidationInputData.validateFilePath(scanner.next());
        }
        return filePath;
    }

    public String getKey(boolean isBruteForce) {
        String key = "";
        System.out.println("""                
                    Please enter your key:
                     № | Encryption method       | Possible key
                    1) | CaesarCipher            | 0-∞
                    2) | VigenereCipher          | Any word(without numbers and symbols)
                       |                         | the key must be in the same language as the content of the file
                    3) | Brute force             | Just press ENTER (without argument)

                """);
        try {
            if (!isBruteForce) {
                key = ValidationInputData.validateKey(scanner.next());
            }
        } catch (IllegalKeyArgumentException e) {
            System.out.println("The key must consist of only numbers or only symbols");
            getKey(isBruteForce);
        }
        return key;
    }
}
