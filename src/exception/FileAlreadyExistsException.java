package exception;

public class FileAlreadyExistsException extends RuntimeException{
    public FileAlreadyExistsException(String filePath){
        super("The file already exists at this path: " + filePath);
    }
}
