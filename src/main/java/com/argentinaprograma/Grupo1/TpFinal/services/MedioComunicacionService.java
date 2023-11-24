package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.MedioComunicacion;
import com.argentinaprograma.Grupo1.TpFinal.repositories.MedioComunicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedioComunicacionService {

    MedioComunicacionRepository medioComunicacionRepository;

    @Autowired
    public MedioComunicacionService(MedioComunicacionRepository medioComunicacionRepository) {
        this.medioComunicacionRepository = medioComunicacionRepository;
    }
}

