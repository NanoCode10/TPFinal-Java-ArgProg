package com.argentinaprograma.Grupo1.TpFinal;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import com.argentinaprograma.Grupo1.TpFinal.model.Servicio;
import com.argentinaprograma.Grupo1.TpFinal.services.ClienteService;
import com.argentinaprograma.Grupo1.TpFinal.services.IncidenteService;
import com.argentinaprograma.Grupo1.TpFinal.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpFinalApplication {
	private static ClienteService clienteService;
	private static ServicioService servicioService;

	@Autowired
	public TpFinalApplication(ClienteService clienteService, ServicioService servicioService) {
		this.clienteService = clienteService;
		this.servicioService = servicioService;

	}

	public static void main(String[] args) {
		SpringApplication.run(TpFinalApplication.class, args);

		inicializarEntidades();

		System.out.println("Funca todo ok ok");
	}

	private static void inicializarEntidades(){

		Servicio s1= new Servicio(1,"Windows","esto es un soporte sobre el s.o windows ");

		s1.setId(servicioService.guardar(s1));

		Cliente c1 = new Cliente(1,1234,"mail@mail","primerempresa","juan","pablo",s1);

		c1.setId(clienteService.guardar(c1));






	}

}
