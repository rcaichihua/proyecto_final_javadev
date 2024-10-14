package com.caichihua.trabajo_final_caichihua.dto;

import com.caichihua.trabajo_final_caichihua.model.Curso;
import com.caichihua.trabajo_final_caichihua.model.Matricula;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {

    @JsonBackReference
    private MatriculaDTO matricula;

    private CursoDTO curso;

    private String aula;
}
