package com.dazayamil.salemanagementapi.exception;

public class SaleNotFoundException extends RuntimeException{
    public SaleNotFoundException(Long id){
        super("Sale not found with ID: " + id);
    }
}
