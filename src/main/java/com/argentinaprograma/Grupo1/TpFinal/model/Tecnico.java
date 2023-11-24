package com.argentinaprograma.Grupo1.TpFinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "tecnico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_incidete", referencedColumnName = "id")
    private Incidente incidente;

    @ManyToOne
    @JoinColumn(name = "id_especialidad",referencedColumnName = "id")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "id_mediocomunicacion",referencedColumnName = "id")
    private MedioComunicacion medioComunicacion;


}
