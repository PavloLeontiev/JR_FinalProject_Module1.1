package inputdata;

import util.ValidationInputData;

import java.util.Scanner;

public class CLIInputData extends InputData{
    Scanner scanner = new Scanner(System.in);

    public String getCipherMode() {
        System.out.println("""
                Welcome to the text encryption program!             
                Choose the mode: ENCRYPT / DECRYPT / BRUTE_FORCE 
                """);
        return ValidationInputData.validateCipherMode(scanner.next().toUpperCase().trim());
    }

    public String getFilePath() {
        System.out.println("""          
                Please enter the path to the file:
                Example: C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\encryptMe.txt
                                
                !!! Pay attention !!!
                If there are spaces or special characters in the path to the jar file or to the text file.
                symbols: (* / \\ $ % & # @ ! ( ) { } [ ] , ; ' ” < > | ^ ~.)`,
                then enclose such a path in DOUBLE QUOTES     
                """);
        return ValidationInputData.validateFilePath(scanner.next());
    }

    public String getKey(boolean isBruteForce) {
        System.out.println("""                
            Please enter your key:
             № | Encryption method       | Possible key
            1) | CaesarCipher            | 0-∞
            2) | VigenereCipher          | Any word(without numbers and symbols)
               |                         | the key must be in the same language as the content of the file
            3) | Brute force             | Just press ENTER (without argument)

        """);
        if(!isBruteForce) return ValidationInputData.validateKey(scanner.next());
        return null;
    }
}
