package pl.uwm.faculty.facultative.global.exceptions;

public class EmptyFieldException extends RuntimeException {

    public final String fieldName;

    public EmptyFieldException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

}
