package com.argentinaprograma.Grupo1.TpFinal.repositories;

import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import com.argentinaprograma.Grupo1.TpFinal.model.TipoProblema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProblemaRepository extends JpaRepository<TipoProblema, Integer> {
}
