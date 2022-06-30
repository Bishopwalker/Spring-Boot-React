package com.bishop.student_management_system.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentException extends RuntimeException{
    public StudentException(String message) {
        super(message);
        String msg = "StudentException: " + message + getMessage();
        System.out.println(msg+ "Toco");
        String msg2 = "Basically there are no people in the database";
        log.error(msg2);
    log.warn(msg, getMessage(), getCause());
    }



    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
