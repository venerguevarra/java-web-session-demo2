package jee.web.shoppee.exceptions;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 8001412223349871621L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable t) {
        super(message, t);
    }
}
