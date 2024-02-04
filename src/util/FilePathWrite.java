package util;

import mode.CipherMode;

public class FilePathWrite {
    public static String createFilePathWrite(String cipherMode,String filePathRead){
        return switch (CipherMode.valueOf(cipherMode)){
            case ENCRYPT -> fileNameEncrypt(filePathRead);
            case DECRYPT, BRUTE_FORCE -> fileNameDecrypt(filePathRead);
        };
    }

    private static String fileNameEncrypt(String fileRead) {
        int index = fileRead.lastIndexOf('.');
        return fileRead.substring(0, index) + "[ENCRYPTED]" + fileRead.substring(index);
    }

    private static String fileNameDecrypt(String fileRead) {
        int firstIndex = fileRead.lastIndexOf('[');
        int lastIndex = fileRead.lastIndexOf(']');
        return fileRead.substring(0, firstIndex) + "[DECRYPTED]" + fileRead.substring(lastIndex + 1);
    }
}
