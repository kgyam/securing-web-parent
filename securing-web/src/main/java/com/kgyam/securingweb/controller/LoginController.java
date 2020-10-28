package com.kgyam.securingweb.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class LoginController {
    @GetMapping(value = "/{name}")
    public String getCode(@PathVariable("name") String name) {
        return name;
    }

}
