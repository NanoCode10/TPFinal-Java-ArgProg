package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import com.argentinaprograma.Grupo1.TpFinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ClienteService {
    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteService() {
    }


    //Crud

    //Guardar

    public Integer guardar(Cliente c){
        return clienteRepository.save(c).getId();

    }






//Buscar Cliente por id
//
//    public Cliente buscarPorId(Cliente id){
//        return (clienteRepository.buscarPorId(id.getCuit(),
//                id.getEmail(),id.getRazonSocial(),
//                id.getNombre(),id.getApellido()));
//
//    }
//
////Borrar por id
//  public Integer borrarPorId( Cliente c){
//      return clienteRepository.deleteById(c).getId();
//
//   }







}












