package com.example.sistema_bbb.controller;

import com.example.sistema_bbb.dto.VotoRequest;
import com.example.sistema_bbb.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processaVoto(@RequestBody VotoRequest request) {
        votoService.processaVoto(request);
    }
}