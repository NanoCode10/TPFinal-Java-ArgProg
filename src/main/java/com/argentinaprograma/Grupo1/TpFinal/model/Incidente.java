package com.argentinaprograma.Grupo1.TpFinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "incidente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaIngreso;
    private LocalDate fechaEstimadaResolucion;
    private LocalDate fechaResolucion;
    private EstadoEnum estado;
    private String consideraciones;

    @ManyToOne
    @JoinColumn(name = "id_incidente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipoproblema", referencedColumnName = "id")
    private TipoProblema tipoProblema;

    @ManyToMany
    @JoinTable(
            name = "incidente_servicio",
            joinColumns = @JoinColumn(name = "id_incidente"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<Servicio> servicio;

    @ManyToMany
    @JoinTable(
            name = "incidente_especialidad",
            joinColumns = @JoinColumn(name = "id_incidente"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad")
    )
    private List<Especialidad> especialidadList;

    @OneToOne
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id")
    private Tecnico tecnico;


}






