package foodDelivery.exception;

import org.springframework.http.HttpStatus;

public class ApiDeliveryException extends RuntimeException{

    private final HttpStatus status;

    public ApiDeliveryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
