package de.cat.rest.appcat;

import de.cat.rest.appcat.cat.CatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CatAppRestControllerAdvice {

    @ExceptionHandler(CatNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String catNotFoundException(CatNotFoundException e) {
        return e.getMessage();
    }

}
