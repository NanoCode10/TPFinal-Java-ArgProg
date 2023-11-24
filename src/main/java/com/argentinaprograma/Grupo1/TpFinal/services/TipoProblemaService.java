package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.repositories.TecnicoRepository;
import com.argentinaprograma.Grupo1.TpFinal.repositories.TipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TipoProblemaService {
    TipoProblemaRepository tipoProblemaRepository;
    @Autowired
    public TipoProblemaService(TipoProblemaRepository tipoProblemaRepository) {
        this.tipoProblemaRepository = tipoProblemaRepository;
    }
}
