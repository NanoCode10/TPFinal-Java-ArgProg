package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Especialidad;
import com.argentinaprograma.Grupo1.TpFinal.model.Incidente;
import com.argentinaprograma.Grupo1.TpFinal.model.Tecnico;
import com.argentinaprograma.Grupo1.TpFinal.repositories.TecnicoRepository;
import com.argentinaprograma.Grupo1.TpFinal.repositories.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.*;
import static java.util.Map.Entry.*;

@Service
public class TecnicoService {
    TecnicoRepository tecnicoRepository;
    IncidenteRepository incidenteRepository;
    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository, IncidenteRepository incidenteRepository) {

        this.tecnicoRepository = tecnicoRepository;
        this.incidenteRepository = incidenteRepository;
    }
    public Integer guardar(Tecnico t){
        return  tecnicoRepository.save(t).getId();
    }

    public List<Tecnico> buscarTodos(){
        return tecnicoRepository.findAll();
    }


    //Quién fue el técnico con más incidentes resueltos en los últimos N días
    public Tecnico buscarTodosConMasIncidentesNdias(int n){

       LocalDate fechaAnterior = LocalDate.now().minusDays(n);
       List<Incidente> incidenteList = incidenteRepository.findAll();

       //lista filtrada x n dias
       List<Incidente> incidentesListNdias =  incidenteList.stream()
               .filter(i ->i.getFechaResolucion()
                       .isAfter(fechaAnterior))
                      .collect(Collectors.toList());

       //ordena la lista por tecnicos
        Map<Tecnico, Long> incidentesPorTecnico = incidentesListNdias.stream()
                .collect(Collectors.groupingByConcurrent(Incidente::getTecnico, Collectors.counting()));


        // Obtener el técnico con más incidentes
        Tecnico tecnicoConMasIncidentes = incidentesPorTecnico.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get().getKey();

        return  tecnicoConMasIncidentes;


    }

    //Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    public Tecnico buscarTecnicoXEspecialidadEnNdias(Especialidad especialidad, int n){

        LocalDate fechaAnterior = LocalDate.now().minusDays(n);
        List<Incidente> incidenteList = incidenteRepository.findAll();


        // Crear un stream de incidentes para trabajar mas comodo
        Stream<Incidente> incidentesStream = incidenteList.stream();

        // Filtrar los incidentes por especialidad
        List<Incidente> IncidentesDeEspecialidadEspecifica = incidentesStream
                .filter(i ->i.getFechaResolucion()
                        .isAfter(fechaAnterior))
               .filter(incidente -> incidente.getEspecialidad().equals(especialidad))
                .collect(Collectors.toList());

        // Agrupar los incidentes por técnico
        Map<Tecnico, List<Incidente>> incidentesPorTecnico = IncidentesDeEspecialidadEspecifica.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico));

        // Contar el número de incidentes por técnico
        Map<Tecnico, Integer> incidentesPorTecnicoYNumero = incidentesPorTecnico.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().size()));

        // Obtener el técnico con el recuento más alto
        Tecnico tecnicoConMasIncidentes = incidentesPorTecnicoYNumero.entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue()))
                .map(entry -> entry.getKey())
                .orElse(null);

        return tecnicoConMasIncidentes;

    }

    //Quién fue el técnico que más rápido resolvió los incidentes
    public Tecnico buscaTecnicoMasRapidoResolucionIncidentes(){
        List<Incidente> incidenteList = incidenteRepository.findAll();


        // Agrupar incidentes por técnico
        Map<Tecnico, List<Incidente>> incidentesPorTecnico = incidenteList.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico));

        // Encontrar al técnico que resolvió más rápido un único incidente
        Optional<Map.Entry<Tecnico, Double>> tecnicoMasRapido = incidentesPorTecnico.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(incidente -> calcularTiempoEstimadoResolucion(
                                        incidente.getFechaIngreso(),
                                        incidente.getFechaResolucion()))
                                .min(Comparator.naturalOrder()) // Menor tiempo de resolución para un solo incidente
                                .orElse(Double.MAX_VALUE) // Valor máximo en caso de que no haya incidentes
                ))
                .entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue));

        // Devolver el técnico o null si no hay resultados
        return tecnicoMasRapido.map(Map.Entry::getKey).orElse(null);
    }

    //Metodo para resolver el tiempo estimado fechas entre fechas
    private Double calcularTiempoEstimadoResolucion(LocalDate fechaIngreso, LocalDate fechaResolucion) {
        // Calcula la diferencia en días
        double diferenciaEnDias = (fechaResolucion.toEpochDay() - fechaIngreso.toEpochDay());

        // Multiplica la diferencia en días por el número de minutos por día
        return diferenciaEnDias * 24 * 60;
    }
}
