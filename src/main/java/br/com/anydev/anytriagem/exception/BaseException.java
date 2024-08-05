package br.com.anydev.anytriagem.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@ToString
public class BaseException extends RuntimeException{
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private final List<Error> errors = new ArrayList<>();

    public BaseException(HttpStatus status){
        this.status = status;
    }
    public BaseException(String message){
        super(message);
        addError(message);
    }

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        addError(message);
    }

    public final void addError(String message){
        errors.add(new Error(message));
    }
}
