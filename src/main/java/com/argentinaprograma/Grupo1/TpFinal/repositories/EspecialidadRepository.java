package com.argentinaprograma.Grupo1.TpFinal.repositories;

import com.argentinaprograma.Grupo1.TpFinal.model.Especialidad;
import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
