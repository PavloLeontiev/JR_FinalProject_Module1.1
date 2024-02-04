package util;

import exception.*;
import mode.CipherMode;
import java.io.File;

public class ValidationInputData {
    public static String validateCipherMode(String cipherMode){
        try {
            CipherMode.valueOf(cipherMode);
        } catch (RuntimeException e){
            throw new IllegalCipherModeArgumentException(cipherMode);
        }
        return cipherMode;
    }
    public static String validateFilePath(String filePath){
        if(!new File(filePath).exists()){
           throw new FileNotFoundException(filePath);
        }
        return filePath;
    }
    public static String validateKey(String key) {
        if (key.matches("^[0-9]*$")) {
            return key;
        } else if (key.matches("^[a-zA-Zа-яА-ЯІіЇїЄєҐґ]*$")){
            return key;
        } else {
            throw new IllegalKeyArgumentException();
        }
    }
}
