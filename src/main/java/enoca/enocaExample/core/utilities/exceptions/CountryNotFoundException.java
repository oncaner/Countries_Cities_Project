package enoca.enocaExample.core.utilities.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String message) {
        super(message);
    }
}
