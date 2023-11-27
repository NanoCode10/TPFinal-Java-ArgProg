package com.argentinaprograma.Grupo1.TpFinal.repositories;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

   // Cliente buscarPorId(long cuit, String email, String razonSocial, String nombre, String apellido);

    //Cliente borrarCliente(long cuit, String email, String razonSocial, String nombre, String apellido);


  //  Cliente deleteById(long cuit, String email, String razonSocial, String nombre, String nombre1, String apellido);


}
