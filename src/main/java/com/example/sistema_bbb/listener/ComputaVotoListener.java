package com.example.sistema_bbb.listener;

import com.example.sistema_bbb.dto.VotoRequest;
import com.example.sistema_bbb.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ComputaVotoListener {

    @Autowired
    private VotoService votoService;

    @RabbitListener(queues = "computar-voto.queue")
    public void processMessage(VotoRequest request) {
        votoService.save(request);
        System.out.println("Voto computado para o candidato de id: " + request.getIdCandidato());
    }

}
