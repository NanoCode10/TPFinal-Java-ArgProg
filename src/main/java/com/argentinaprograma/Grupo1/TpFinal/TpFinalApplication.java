package com.argentinaprograma.Grupo1.TpFinal;

import com.argentinaprograma.Grupo1.TpFinal.model.*;
import com.argentinaprograma.Grupo1.TpFinal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class TpFinalApplication {
	private static ClienteService clienteService;
	private static ServicioService servicioService;
	private static TecnicoService tecnicoService;
	private static EspecialidadService especialidadService;
	private  static TipoProblemaService tipoProblemaService;
	private static IncidenteService incidenteService;
	private static MedioComunicacionService medioComunicacionService;
	@Autowired
	public TpFinalApplication(
							  ClienteService clienteService,
							  ServicioService servicioService,
							  TecnicoService tecnicoService,
							  EspecialidadService especialidadService,
							  IncidenteService incidenteService,
							  MedioComunicacionService medioComunicacionService,
							  TipoProblemaService tipoProblemaService
	)
	{
		this.clienteService = clienteService;
		this.servicioService = servicioService;
		this.tecnicoService = tecnicoService;
		this.especialidadService = especialidadService;
		this.incidenteService = incidenteService;
		this.medioComunicacionService = medioComunicacionService;
		this.tipoProblemaService = tipoProblemaService;

	}

	public static void main(String[] args) {

		SpringApplication.run(TpFinalApplication.class, args);

		//inicializa las entidades
		inicializarEntidades();

		//crea una especialidad para compararla
		Especialidad e1 = new Especialidad(1,"Sistemas Operativos","soporte de windows, linux y mac");

		//Requerimiento: A
		System.out.println("Requerimiento: A ,  Quién fue el técnico con más incidentes resueltos en los últimos N días");
		System.out.println("--------------------------------------------\n");
		System.out.println(tecnicoService.buscarTodosConMasIncidentesNdias(30));
		System.out.println("--------------------------------------------\n");

		//Requerimiento: B
		System.out.println("Requerimiento: B , Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días");
		System.out.println("--------------------------------------------");
		System.out.println(tecnicoService.buscarTecnicoXEspecialidadEnNdias(e1, 20));
		System.out.println("--------------------------------------------\n");

		//Requerimiento: C
		System.out.println("Requerimiento: C , Quién fue el técnico que más rápido resolvió los incidentes");
		System.out.println("--------------------------------------------\n");
		System.out.println(tecnicoService.buscaTecnicoMasRapidoResolucionIncidentes());
		System.out.println("--------------------------------------------\n");

	}

	private static void inicializarEntidades(){

		//MEDIO COMUNICACION

		MedioComunicacion m1 = new MedioComunicacion(1,MedioEnum.WHATSAPP,"Agustina");
		MedioComunicacion m2 = new MedioComunicacion(2,MedioEnum.EMAIL,"Fabiana");
		MedioComunicacion m3 = new MedioComunicacion(3,MedioEnum.WHATSAPP,"Ignacio");
		MedioComunicacion m4 = new MedioComunicacion(4,MedioEnum.EMAIL,"Marcos");
		MedioComunicacion m5 = new MedioComunicacion(5,MedioEnum.WHATSAPP,"Rodrigo");
		MedioComunicacion m6 = new MedioComunicacion(6,MedioEnum.EMAIL,"Valentin");
		MedioComunicacion m7 = new MedioComunicacion(7,MedioEnum.WHATSAPP,"Pedro");
		MedioComunicacion m8 = new MedioComunicacion(8,MedioEnum.EMAIL,"Juan");
		MedioComunicacion m9 = new MedioComunicacion(9,MedioEnum.WHATSAPP,"Luciana");
		MedioComunicacion m10 = new MedioComunicacion(10,MedioEnum.EMAIL,"Carlos");

		m1.setId(medioComunicacionService.guardar(m1));
		m2.setId(medioComunicacionService.guardar(m2));
		m3.setId(medioComunicacionService.guardar(m3));
		m4.setId(medioComunicacionService.guardar(m4));
		m5.setId(medioComunicacionService.guardar(m5));
		m6.setId(medioComunicacionService.guardar(m6));
		m7.setId(medioComunicacionService.guardar(m7));
		m8.setId(medioComunicacionService.guardar(m8));
		m9.setId(medioComunicacionService.guardar(m9));
		m10.setId(medioComunicacionService.guardar(m10));


		//ESPECIALIDAD

		Especialidad e1 = new Especialidad(1,"Sistemas Operativos","soporte de windows, linux y mac");
		Especialidad e2 = new Especialidad(2,"Sistemas contables y tango","soporte al sistema contable y tango");
		Especialidad e3 = new Especialidad(3,"Sistemas auditoria interna","soporte a auditoria interna");
		Especialidad e4 = new Especialidad(4,"Sistemas camaras , redes y asistencia","soporte a camaras , redes y sistem de asitencia");
		Especialidad e5 = new Especialidad(5,"Sistemas webs y moviles","soporte web y moviles");

		e1.setId(especialidadService.guardar(e1));
		e2.setId(especialidadService.guardar(e2));
		e3.setId(especialidadService.guardar(e3));
		e4.setId(especialidadService.guardar(e4));
		e5.setId(especialidadService.guardar(e5));


        //TECNICO

		Tecnico t1 = new Tecnico(1,"Pedro","Gonzales",List.of(e1),m1);
		Tecnico t2 = new Tecnico(2,"Juan","Alvarez",List.of(e1,e2,e3),m2);
		Tecnico t3 = new Tecnico(3,"Raul","Pereyra",List.of(e4,e1),m3);
		Tecnico t4 = new Tecnico(4,"Carlos","Tejedor",List.of(e2,e3),m4);
		Tecnico t5 = new Tecnico(5,"Emilia","Rodriguez",List.of(e5),m5);
		Tecnico t6 = new Tecnico(6,"Fabiana","Pelizza",List.of(e5),m6);
		Tecnico t7 = new Tecnico(7,"Lucia","Ortiz",List.of(e1,e2),m7);
		Tecnico t8 = new Tecnico(8,"Horacio","Tevez",List.of(e1,e2,e3),m8);
		Tecnico t9 = new Tecnico(9,"Tomas","Martinez",List.of(e2,e3,e4),m9);
		Tecnico t10 = new Tecnico(10,"Valen","Messi",List.of(e1,e2,e3,e4,e5),m10);

		t1.setId(tecnicoService.guardar(t1));
		t2.setId(tecnicoService.guardar(t2));
		t3.setId(tecnicoService.guardar(t3));
		t4.setId(tecnicoService.guardar(t4));
		t5.setId(tecnicoService.guardar(t5));
		t6.setId(tecnicoService.guardar(t6));
		t7.setId(tecnicoService.guardar(t7));
		t8.setId(tecnicoService.guardar(t8));
		t9.setId(tecnicoService.guardar(t9));
		t10.setId(tecnicoService.guardar(t10));


		//SERVICIO

		Servicio s1= new Servicio(1,"Windows","esto es un servicio de windows ");
		Servicio s2= new Servicio(2,"MacOs","esto es un servicio de MacOs ");
		Servicio s3= new Servicio(3,"Linux","Soportte a sistema Linux ");
		Servicio s4= new Servicio(4,"Sistema Contable","Soporte a un sistema contable externo ");
		Servicio s5= new Servicio(5,"Sistema de Asistencia","Sistema de asistencias ");
		Servicio s6= new Servicio(6,"Sistema de Auditoria Interna","Soporte a un sistema de aud interno ");
		Servicio s7= new Servicio(7,"Administracion de Camaras","Soporte a la admin de camaras ");
		Servicio s8= new Servicio(8,"Administacion de Redes","Asistencia a redes para las empresas ");
		Servicio s9= new Servicio(9,"Sistemas Web","Soporte a aplicaciones web ");
		Servicio s10= new Servicio(10,"Sistemas Moviles","Soporte aplicaciones android");

		s1.setId(servicioService.guardar(s1));
		s2.setId(servicioService.guardar(s2));
		s3.setId(servicioService.guardar(s3));
		s4.setId(servicioService.guardar(s4));
		s5.setId(servicioService.guardar(s5));
		s6.setId(servicioService.guardar(s6));
		s7.setId(servicioService.guardar(s7));
		s8.setId(servicioService.guardar(s8));
		s9.setId(servicioService.guardar(s9));
		s10.setId(servicioService.guardar(s10));

		//TIPO_PROBLEMA

		TipoProblema tp1 = new TipoProblema(1,"error al cargar widows", 2,24 );
		TipoProblema tp2 = new TipoProblema(2,"error al cargar MacOs", 2,4 );
		TipoProblema tp3 = new TipoProblema(3,"error al cargar Linux", 5,10 );
		TipoProblema tp4 = new TipoProblema(4,"error contable", 6,12 );
		TipoProblema tp5 = new TipoProblema(5,"error asistencia", 4,8 );
		TipoProblema tp6 = new TipoProblema(6,"error en la auditoria", 4,8 );
		TipoProblema tp7 = new TipoProblema(7,"error camaras", 4,8 );
		TipoProblema tp8 = new TipoProblema(8,"error redes", 8,16 );
		TipoProblema tp9 = new TipoProblema(9,"error web", 12,24 );
		TipoProblema tp10 = new TipoProblema(10,"error app movil", 12,48 );

		tp1.setId(tipoProblemaService.guardar(tp1));
		tp2.setId(tipoProblemaService.guardar(tp2));
		tp3.setId(tipoProblemaService.guardar(tp3));
		tp4.setId(tipoProblemaService.guardar(tp4));
		tp5.setId(tipoProblemaService.guardar(tp5));
		tp6.setId(tipoProblemaService.guardar(tp6));
		tp7.setId(tipoProblemaService.guardar(tp7));
		tp8.setId(tipoProblemaService.guardar(tp8));
		tp9.setId(tipoProblemaService.guardar(tp9));
		tp10.setId(tipoProblemaService.guardar(tp10));


	   //CLIENTE

		Cliente c1 = new Cliente(1,1234,"mail1@mail","primerEmpresa","juan","pablo1",s1);
		Cliente c2 = new Cliente(2,5678,"mail2@mail","sengaEmpresa","juan2","pablo2",s2);
		Cliente c3 = new Cliente(3,4583,"mail3@mail","tercerEmpresa","juan3","pablo3",s3);
		Cliente c4 = new Cliente(4,9758,"mail4@mail","cuartaEmpresa","juan4","pablo4",s4);
		Cliente c5 = new Cliente(5,3632,"mail5@mail","quintaEmpresa","juan5","pablo5",s5);
		Cliente c6 = new Cliente(6,7643,"mail6@mail","sexectaEmpresa","juan6","pablo6",s6);
		Cliente c7 = new Cliente(7,9836,"mail7@mail","septimaEmpresa","juan7","pablo7",s7);
		Cliente c8 = new Cliente(8,2853,"mail8@mail","octavaEmpresa","juan8","pablo8",s8);
		Cliente c9 = new Cliente(9,9572,"mail9@mail","novenaEmpresa","juan9","pablo9",s9);
		Cliente c10 = new Cliente(10,9532,"mail10@mail","decimaEmpresa","juan10","pablo10",s10);

		c1.setId(clienteService.guardar(c1));
		c2.setId(clienteService.guardar(c2));
		c3.setId(clienteService.guardar(c3));
		c4.setId(clienteService.guardar(c4));
		c5.setId(clienteService.guardar(c5));
		c6.setId(clienteService.guardar(c6));
		c7.setId(clienteService.guardar(c7));
		c8.setId(clienteService.guardar(c8));
		c9.setId(clienteService.guardar(c9));
		c10.setId(clienteService.guardar(c10));


		//INCIDENTE

		Incidente i1 = new Incidente(
				1,
				"no carga windows",
				"pantalla azul de windows cuando inicia",
				LocalDate.of(2023,11,11),
				LocalDate.of(2023,11,15),
				LocalDate.of(2023,11,15),
				EstadoEnum.FINALIZADO,
				"es un servidor",
				c1,tp1,List.of(s1), e1,t1);

		Incidente i2 = new Incidente(
				2,
				"no carga Mac",
				"pantalla error de mac",
				LocalDate.of(2023,11,12),
				LocalDate.of(2023,11,13),
				LocalDate.of(2023,11,13),
				EstadoEnum.FINALIZADO,
				"es el jefe",
				c2,tp2,List.of(s2), e1,t2);

		Incidente i3 = new Incidente(
				3,
				"no carga Linux",
				"raro nunca pasa jeje",
				LocalDate.of(2023,11,15),
				LocalDate.of(2023,11,20),
				LocalDate.of(2023,11,18),
				EstadoEnum.FINALIZADO,
				"es un servidor",
				c3,tp3,List.of(s3), e1,t2);

		Incidente i4 = new Incidente(
				4,
				"no carga contable",
				"No puede cargar una factura",
				LocalDate.of(2023,11,14),
				LocalDate.of(2023,11,20),
				LocalDate.of(2023,11,19),
				EstadoEnum.FINALIZADO,
				"se deben 3 meses",
				c4,tp4,List.of(s4), e2,t4);

		Incidente i5 = new Incidente(
				5,
				"Auditoria interna",
				"Se necesita auditar al personal",
				LocalDate.of(2023,11,5),
				LocalDate.of(2023,11,15),
				LocalDate.of(2023,11,11),
				EstadoEnum.FINALIZADO,
				"se necesita capacitacion",
				c5,tp6,List.of(s6),e3,t5);

		Incidente i6 = new Incidente(
				6,
				"sistema de camaras",
				"se necesitan grabaciones",
				LocalDate.of(2023,11,16),
				LocalDate.of(2023,11,20),
				LocalDate.of(2023,11,16),
				EstadoEnum.FINALIZADO,
				"robo del vecino",
				c6,tp7,List.of(s7), e4,t6);

		Incidente i7 = new Incidente(
				7,
				"sistema de  asitencias",
				"agregar un nuevo empleado",
				LocalDate.of(2023,11,7),
				LocalDate.of(2023,11,15),
				LocalDate.of(2023,11,10),
				EstadoEnum.FINALIZADO,
				"entra mas tarde que el resto",
				c7,tp7,List.of(s5), e4,t10);

		Incidente i8 = new Incidente(
				8,
				"error en la web",
				"error 404",
				LocalDate.of(2023,11,8),
				LocalDate.of(2023,11,18),
				LocalDate.of(2023,11,17),
				EstadoEnum.FINALIZADO,
				"necesitan ayuda",
				c8,tp8,List.of(s9), e5,t10);

		Incidente i9 = new Incidente(
				9,
				"error en la app",
				"no carga un modulo",
				LocalDate.of(2023,11,9),
				LocalDate.of(2023,11,28),
				LocalDate.of(2023,11,25),
				EstadoEnum.FINALIZADO,
				"el modulo de  compras no anda",
				c9,tp9,List.of(s9), e5,t10);

		Incidente i10 = new Incidente(
				10,
				"actualizar tango",
				"nuevo decrecto del estado tango actualizar",
				LocalDate.of(2023,11,10),
				LocalDate.of(2023,11,18),
				LocalDate.of(2023,11,11),
				EstadoEnum.FINALIZADO,
				"es actualziar",
				c10,tp9,List.of(s4), e2,t10);

		i1.setId(incidenteService.guardar(i1));
		i2.setId(incidenteService.guardar(i2));
		i3.setId(incidenteService.guardar(i3));
		i4.setId(incidenteService.guardar(i4));
		i5.setId(incidenteService.guardar(i5));
		i6.setId(incidenteService.guardar(i6));
		i7.setId(incidenteService.guardar(i7));
		i8.setId(incidenteService.guardar(i8));
		i9.setId(incidenteService.guardar(i9));
		i10.setId(incidenteService.guardar(i10));


	}

}
