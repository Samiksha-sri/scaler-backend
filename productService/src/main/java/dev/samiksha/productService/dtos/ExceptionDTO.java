package dev.samiksha.productService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDTO {

    private HttpStatus errorCode;
    private String message;

    public ExceptionDTO(HttpStatus status, String message){
        this.errorCode = errorCode;
        this.message = message;
    }
}
