package exception;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException(String filePath){
        super("File not found at this path: " + filePath);
    }
}
