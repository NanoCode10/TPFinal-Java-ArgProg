package com.argentinaprograma.Grupo1.TpFinal.repositories;

import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
}
