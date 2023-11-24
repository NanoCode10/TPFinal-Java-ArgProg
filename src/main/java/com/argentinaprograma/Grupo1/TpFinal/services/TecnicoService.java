package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Tecnico;
import com.argentinaprograma.Grupo1.TpFinal.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {

        this.tecnicoRepository = tecnicoRepository;
    }
    public Integer guardar(Tecnico t){
        return  tecnicoRepository.save(t).getId();
    }
}
