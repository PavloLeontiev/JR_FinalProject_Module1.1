package exception;

public class IllegalKeyArgumentException extends RuntimeException{
    public IllegalKeyArgumentException(){
        super("The key must consist of only numbers or only symbols");
    }
}
