package pl.uwm.faculty.facultative.global.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = EmptyFieldException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public String emptyFieldException(EmptyFieldException exception) {
        return exception.getMessage();    }

    @ExceptionHandler(value = InvalidLengthException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public String invalidLengthException(InvalidLengthException exception) {
        return exception.getMessage();    }

    @ExceptionHandler(value = InvalidSignsException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public String invalidSignsException(InvalidSignsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        return result.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> constraintViolationException(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }

}
