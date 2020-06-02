package lab7;

public class WrongIExceprion extends Exception {
    public WrongIExceprion(int i) {
        super("i = " + i + " must be greater than 0 and less than size of NewList!");
    }
}
