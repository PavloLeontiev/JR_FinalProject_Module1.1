package exception;

public class IllegalCipherModeArgumentException extends RuntimeException{
    public IllegalCipherModeArgumentException(String cipherMode){
        super("Illegal cipher mode: " + cipherMode + ". Choose from ENCRYPT / DECRYPT / BRUTE_FORCE");
    }
}
