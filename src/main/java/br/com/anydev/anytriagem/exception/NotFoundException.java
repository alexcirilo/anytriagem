package br.com.anydev.anytriagem.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
public class NotFoundException extends BaseException{

    public NotFoundException(){
        super(HttpStatus.NOT_FOUND);
    }

    public NotFoundException(HttpStatus status) {
        super(status);
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
