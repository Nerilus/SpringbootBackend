package com.contentfilter.contentfilter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object>Response(String message,HttpStatus status,Object responseObj) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("responseObj", responseObj);
        return new  ResponseEntity<Object>(map,status); 

    }
}
