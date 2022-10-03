package com.kuka.h2g.resourcemanagementsvc.dal.exceptions;

public class NoReturnDataException extends RuntimeException {

    public NoReturnDataException(){
        super("No data arrived from query");
    }
}
