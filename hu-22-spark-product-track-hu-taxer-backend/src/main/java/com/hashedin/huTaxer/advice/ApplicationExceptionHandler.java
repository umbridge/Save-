package com.hashedin.huTaxer.advice;

import com.hashedin.huTaxer.Exception.ExistingUserException;
import com.hashedin.huTaxer.Exception.InvalidCredentials;
import com.hashedin.huTaxer.Exception.SamePasswordException;
import com.hashedin.huTaxer.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException exception)
    {
        Map<String,String> map = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return map;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleUserException(UserNotFoundException exception)
    {
        Map<String,String> map  = new HashMap<>();
        map.put("Error" , exception.getMessage());
        return map;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ExistingUserException.class)
    public Map<String,String> handleUserException(ExistingUserException exception)
    {
        Map<String,String> map  = new HashMap<>();
        map.put("Error" , exception.getMessage());
        return  map;

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SamePasswordException.class)
    public  Map<String,String>handlePasswordException(SamePasswordException e)
    {
        Map<String,String> map = new HashMap<>();
        map.put("Error" , e.getMessage());
        return  map;
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidCredentials.class)
    public Map<String,String> handleInvalidCredentials(InvalidCredentials e)
    {
        Map<String,String> map = new HashMap<>();

        map.put("Error",e.getMessage());
        return  map;
    }

}
