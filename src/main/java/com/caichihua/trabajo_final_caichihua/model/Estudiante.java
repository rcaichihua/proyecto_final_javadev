package com.caichihua.trabajo_final_caichihua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudiante {


     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEstudiante;

    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(length = 25, nullable = false)
    private String apellidos;

    @Column(length = 25, nullable = false)
    private String dni;

    @Column(length = 2, nullable = false)
    private int edad;

}
