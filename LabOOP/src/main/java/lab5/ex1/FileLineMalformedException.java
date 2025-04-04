package lab5.ex1;

public class FileLineMalformedException extends Exception {
    public FileLineMalformedException(String message) {
        super("Line malformed: " + message);
    }
}
