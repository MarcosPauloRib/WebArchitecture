package org.example.controller;

import org.example.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/clima")
    public String perverTempo(){
        return service.preverTempo();
    }
}
