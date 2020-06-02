package lab7;

public class WrongPriceException extends Exception {
    public WrongPriceException() {
        super("Enter correct price!");
    }
}
