package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import com.argentinaprograma.Grupo1.TpFinal.model.MedioComunicacion;
import com.argentinaprograma.Grupo1.TpFinal.repositories.MedioComunicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedioComunicacionService {
    MedioComunicacionRepository medioComunicacionRepository;

    @Autowired
    public MedioComunicacionService(MedioComunicacionRepository medioComunicacionRepository) {
        this.medioComunicacionRepository = medioComunicacionRepository;
    }

    public Integer guardar(MedioComunicacion m){
        return medioComunicacionRepository.save(m).getId();
    }


}

