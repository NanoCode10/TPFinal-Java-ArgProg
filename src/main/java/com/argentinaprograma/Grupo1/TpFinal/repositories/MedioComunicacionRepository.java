package com.argentinaprograma.Grupo1.TpFinal.repositories;

import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import com.argentinaprograma.Grupo1.TpFinal.model.MedioComunicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedioComunicacionRepository extends JpaRepository<MedioComunicacion, Integer> {
}
