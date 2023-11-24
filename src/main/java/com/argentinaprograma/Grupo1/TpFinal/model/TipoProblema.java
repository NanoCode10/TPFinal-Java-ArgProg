package com.argentinaprograma.Grupo1.TpFinal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_problema")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipoProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private int tiempoEstimado;
    private int tiempoMaximo;


}
