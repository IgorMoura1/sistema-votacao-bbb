package com.example.sistema_bbb.repository;

import com.example.sistema_bbb.entity.Voto;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface VotoRepository extends CrudRepository<Voto, Long> {



}
