/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 11/6/2023$
 * Time: 4:27 AM$
 * Project Name: exam_portal_backend$
 */


package com.project.examportal.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> handleUserFoundException(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

}
