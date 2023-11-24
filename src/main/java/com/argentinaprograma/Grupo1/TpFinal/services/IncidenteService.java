package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import com.argentinaprograma.Grupo1.TpFinal.repositories.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenteService {

    IncidenteRepository incidenteRepository;

    @Autowired
    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    public Integer guardar(Incidente i){
        return incidenteRepository.save(i).getId();
    }

}
