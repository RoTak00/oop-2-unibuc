package lab5.ex1;

public class PriceInvalidException extends RuntimeException {
    public PriceInvalidException(String message) {
        super("Invalid price for product with ID: " + message);
    }
}
