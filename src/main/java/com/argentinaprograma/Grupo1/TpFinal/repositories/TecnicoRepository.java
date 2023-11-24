package com.argentinaprograma.Grupo1.TpFinal.repositories;

import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import com.argentinaprograma.Grupo1.TpFinal.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
