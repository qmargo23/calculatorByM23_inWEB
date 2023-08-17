package pro.sky.calculatorbyM23.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArgumentIsZeroException  extends HttpStatusCodeException {
    public ArgumentIsZeroException(String message) {
            super(HttpStatus.BAD_REQUEST, message);
        }
}
