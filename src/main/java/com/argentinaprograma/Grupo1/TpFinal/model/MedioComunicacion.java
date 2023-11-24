package com.argentinaprograma.Grupo1.TpFinal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "medio_comunicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedioComunicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private MedioEnum medio;
    private String contacto;

}
