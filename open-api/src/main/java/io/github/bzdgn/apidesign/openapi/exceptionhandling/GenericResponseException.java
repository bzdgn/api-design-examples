package io.github.bzdgn.apidesign.openapi.exceptionhandling;

public class GenericResponseException extends RuntimeException{
    public GenericResponseException(String data) {
        super(data);
    }
}
