package com.giffgaff.ims.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
        return "jsp/database_error";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Exception occured")
    @ExceptionHandler(Exception.class)
    public void handleIOException(){
        //returning 404 error code
    }
}
