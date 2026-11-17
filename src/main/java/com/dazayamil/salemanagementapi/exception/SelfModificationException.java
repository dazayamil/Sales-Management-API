package com.dazayamil.salemanagementapi.exception;

public class SelfModificationException extends RuntimeException{
    public SelfModificationException(){
        super("You cannot deactivate yout own account");
    }
}
