package com.caichihua.trabajo_final_caichihua.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;


    @ManyToOne
    @JoinColumn(name = "idEstudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_USER"))
    private Estudiante estudiante;

    @Column(nullable = false)
    private LocalDateTime fechaMatricula;

     @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<Detallematricula> detalleMatricula;

    @Column(nullable = false)
    private boolean estado;

}
