package de.cat.rest.appcat.cat;

public class CatNotFoundException extends RuntimeException {

    public CatNotFoundException(String message) {
        super(message);
    }
}
