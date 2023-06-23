package ch.ny.restfood_backend.domain.exceptions;

public class IdNotNullException extends RuntimeException{
    public IdNotNullException(String message){
        super(message);
    }
}
