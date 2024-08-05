package br.com.anydev.anytriagem.exception;


import org.springframework.http.HttpStatus;

public class InternalServerException extends BaseException{

    public InternalServerException(){
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public InternalServerException(String message){
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
