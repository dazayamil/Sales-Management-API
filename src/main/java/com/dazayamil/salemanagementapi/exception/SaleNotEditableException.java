package com.dazayamil.salemanagementapi.exception;

public class SaleNotEditableException extends RuntimeException{
    public SaleNotEditableException(){
        super("Sale cannot be updated unless it is COMPLETED");
    }
}
