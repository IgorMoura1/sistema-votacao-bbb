package com.example.sistema_bbb.service;

import com.example.sistema_bbb.dto.VotoRequest;
import com.example.sistema_bbb.entity.Candidato;
import com.example.sistema_bbb.entity.Voto;
import com.example.sistema_bbb.repository.VotoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    private final VotoRepository votoRepository;

    private final RabbitTemplate rabbitTemplate;

    public VotoService(VotoRepository votoRepository, RabbitTemplate rabbitTemplate) {
        this.votoRepository = votoRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void processaVoto(VotoRequest request) {
        rabbitTemplate.convertAndSend("computar-voto.ex", "", request);
    }

    public void save(VotoRequest request) {
        Voto voto = new Voto();
        voto.setCandidato(new Candidato(request.getIdCandidato()));
        voto.setDataHora(java.time.LocalDateTime.now());
    }
}