package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import com.argentinaprograma.Grupo1.TpFinal.model.TipoProblema;
import com.argentinaprograma.Grupo1.TpFinal.repositories.TecnicoRepository;
import com.argentinaprograma.Grupo1.TpFinal.repositories.TipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProblemaService {
    TipoProblemaRepository tipoProblemaRepository;
    @Autowired
    public TipoProblemaService(TipoProblemaRepository tipoProblemaRepository) {
        this.tipoProblemaRepository = tipoProblemaRepository;
    }
    public Integer guardar(TipoProblema t){
        return tipoProblemaRepository.save(t).getId();

    }

}
