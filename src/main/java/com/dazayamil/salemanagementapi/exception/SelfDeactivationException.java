package com.dazayamil.salemanagementapi.exception;

public class SelfDeactivationException extends RuntimeException{
    public SelfDeactivationException(){
        super("You cannot deactivate yout own account");
    }
}
