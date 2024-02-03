package util;

import exceptions.*;
import modes.CipherMode;
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
           throw new FileAlreadyExistsException(filePath);
        }
        return filePath;
    }
    public static String validateKey(String key) {
        if (!key.matches("^[0-9]*$") || !key.matches("^[a-zA-Zа-яА-ЯІіЇїЄєҐґ]*$")) {
            throw new IllegalKeyArgumentException();
        }
        return key;
    }
}
