package com.caichihua.trabajo_final_caichihua.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Detallematricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatriculaDetalle;

    @ManyToOne
    @JoinColumn(nullable = false, name = "idMatricula", foreignKey = @ForeignKey(name = "FK_DETAIL_SALE"))
    private Matricula matricula;

     @ManyToOne
    @JoinColumn(nullable = false, name = "idCurso", foreignKey = @ForeignKey(name = "FK_DETAIL_PRODUCT"))
    private Curso curso;

    @Column(length = 25, nullable = false)
    private String aula;


    
}
