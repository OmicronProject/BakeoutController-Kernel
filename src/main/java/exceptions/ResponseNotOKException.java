package exceptions;

import java.io.IOException;

/**
 * Thrown if a message is expected that is supposed to return a response of
 * "OK", and the OK response is not received
 */
public class ResponseNotOKException extends IOException {
    public ResponseNotOKException(String message){
        super(message);
    }
}
