package org.otus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionResponse {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, Object> showCustomMessage(Exception e) {


        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        response.put("status", 400);
        response.put("error", "Плохой запрос");
        response.put("message", e.getCause() == null ? e.getMessage() : e.getCause().getMessage());

        return response;
    }
}
