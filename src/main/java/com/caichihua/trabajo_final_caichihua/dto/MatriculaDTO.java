package com.caichihua.trabajo_final_caichihua.dto;

import com.caichihua.trabajo_final_caichihua.model.Detallematricula;
import com.caichihua.trabajo_final_caichihua.model.Estudiante;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {

    private Integer idMatricula;
    private EstudianteDTO estudiante;
    private LocalDateTime fechaMatricula;

    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalleMatricula;

    private boolean estado;
}
