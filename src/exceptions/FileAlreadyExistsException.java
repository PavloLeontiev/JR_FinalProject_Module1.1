package exceptions;

public class FileAlreadyExistsException extends RuntimeException{
    public FileAlreadyExistsException(String file){
        super("The file already exists at this path: " + file);
    }
}
