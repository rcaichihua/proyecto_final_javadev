package com.caichihua.trabajo_final_caichihua.controller;

import com.caichihua.trabajo_final_caichihua.dto.EstudianteDTO;
import com.caichihua.trabajo_final_caichihua.dto.GenericResponse;
import com.caichihua.trabajo_final_caichihua.dto.MatriculaDTO;
import com.caichihua.trabajo_final_caichihua.model.Estudiante;
import com.caichihua.trabajo_final_caichihua.model.Matricula;
import com.caichihua.trabajo_final_caichihua.service.IEstudianteService;
import com.caichihua.trabajo_final_caichihua.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService service;
    private final MapperUtil mapperUtil;

    @GetMapping("/desc/edad")
    public ResponseEntity<List<EstudianteDTO>> filtro() throws Exception{
        List<EstudianteDTO> list = mapperUtil.mapList(service.findAll(), EstudianteDTO.class);
        //lista ordenada
        List<EstudianteDTO> listaOrdenada = list.stream()
                .sorted(Comparator.comparingInt(EstudianteDTO::getEdad))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaOrdenada);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception{
        List<EstudianteDTO> list = mapperUtil.mapList(service.findAll(), EstudianteDTO.class);

        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Estudiante obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, EstudianteDTO.class));
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@Valid @RequestBody EstudianteDTO dto) throws Exception{
        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class));

        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EstudianteDTO dto) throws Exception{
        Estudiante obj = service.update(id, mapperUtil.map(dto, Estudiante.class));

        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    ////////////////////////queries/////////////////////////

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<EstudianteDTO>> findByName(@PathVariable("name") String name) {
        List<EstudianteDTO> list = mapperUtil.mapList(service.findByName(name), EstudianteDTO.class, "categoryMapper");

        return ResponseEntity.ok(list);
    }




}
