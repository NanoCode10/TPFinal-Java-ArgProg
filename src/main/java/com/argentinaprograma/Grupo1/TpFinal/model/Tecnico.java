package com.argentinaprograma.Grupo1.TpFinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tecnico")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;

    @ManyToMany
    @JoinTable(
            name = "Tecnico_especialidad",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad")
        )
    private List<Especialidad> especialidadList;

    @ManyToOne
    @JoinColumn(name = "id_mediocomunicacion",referencedColumnName = "id")
    private MedioComunicacion medioComunicacion;


}
