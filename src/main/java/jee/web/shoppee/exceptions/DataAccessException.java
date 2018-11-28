package jee.web.shoppee.exceptions;

public class DataAccessException extends RuntimeException {
    private static final long serialVersionUID = 8001412223349871621L;

    public DataAccessException() {
        super();
    }

    public DataAccessException(String message, Throwable t) {
        super(message, t);
    }
}
