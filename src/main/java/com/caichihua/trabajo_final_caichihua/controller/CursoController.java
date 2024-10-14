package com.caichihua.trabajo_final_caichihua.controller;

import com.caichihua.trabajo_final_caichihua.dto.*;
import com.caichihua.trabajo_final_caichihua.model.Curso;
import com.caichihua.trabajo_final_caichihua.service.ICursoService;
import com.caichihua.trabajo_final_caichihua.service.IDetalleMatriculaService;
import com.caichihua.trabajo_final_caichihua.service.IMatriculaService;
import com.caichihua.trabajo_final_caichihua.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService service;
    private final IMatriculaService eservicematricula;
    private final IDetalleMatriculaService eservicematriculadetalle;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception{
        List<CursoDTO> list = mapperUtil.mapList(service.findAll(), CursoDTO.class);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/relacion")
    public ResponseEntity<Map<String, List<String>>> relacionCursoAlumnos() throws Exception{
        List<CursoDTO> cursos = mapperUtil.mapList(service.findAll(), CursoDTO.class);
        List<MatriculaDTO> matriculas = mapperUtil.mapList(eservicematricula.findAll(), MatriculaDTO.class);
        List<DetalleMatriculaDTO> detallematriculas = mapperUtil.mapList(eservicematriculadetalle.findAll(), DetalleMatriculaDTO.class);

        Map<String, List<String>> relacion = detallematriculas.stream()
                .collect(Collectors.groupingBy(
                        matricula -> matricula.getCurso().getNombre(), // Agrupar por el nombre del curso
                        Collectors.mapping(
                                matricula -> matricula.getMatricula().getEstudiante().getNombre(), // Obtener nombre del alumno
                                Collectors.toList() // Convertir en lista de nombres
                        )
                ));
        return ResponseEntity.ok(relacion);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Curso obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, CursoDTO.class));
    }

    @PostMapping
    public ResponseEntity<CursoDTO> save(@Valid @RequestBody CursoDTO dto) throws Exception{
        Curso obj = service.save(mapperUtil.map(dto, Curso.class));

        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CursoDTO dto) throws Exception{
        Curso obj = service.update(id, mapperUtil.map(dto, Curso.class));

        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
