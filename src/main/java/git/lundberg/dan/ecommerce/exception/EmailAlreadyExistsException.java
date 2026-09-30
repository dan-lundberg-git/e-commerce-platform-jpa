package git.lundberg.dan.ecommerce.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("A customer with email '%s' already exists".formatted(email));
    }
}
