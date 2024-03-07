package com.hdtech.HDTech_E_Learning.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Initialize {

    @RequestMapping("/initialize")
    public ResponseEntity<?> initialize() {

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
