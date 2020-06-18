package shop;

public class CDNotFoundException extends RuntimeException{
    public CDNotFoundException(String message) {
        super(message);
    }
}
