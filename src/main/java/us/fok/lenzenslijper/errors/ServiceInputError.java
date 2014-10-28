package us.fok.lenzenslijper.errors;

public class ServiceInputError extends RuntimeException {

    public ServiceInputError(String message) {
        super(message);
    }

}
