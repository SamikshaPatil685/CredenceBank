package com.CredenceBank.CredenceBank.exceptions;

public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String error){
        super(error);
    }
}
