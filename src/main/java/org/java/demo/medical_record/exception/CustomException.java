package org.java.demo.medical_record.exception;

import lombok.NoArgsConstructor;

public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }

}
