package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import com.argentinaprograma.Grupo1.TpFinal.model.Especialidad;
import com.argentinaprograma.Grupo1.TpFinal.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadService {

    EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public Integer guardar(Especialidad e){
        return especialidadRepository.save(e).getId();

    }

}
