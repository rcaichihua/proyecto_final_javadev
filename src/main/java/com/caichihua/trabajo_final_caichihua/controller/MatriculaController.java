package com.caichihua.trabajo_final_caichihua.controller;

import com.caichihua.trabajo_final_caichihua.dto.MatriculaDTO;
import com.caichihua.trabajo_final_caichihua.model.Matricula;
import com.caichihua.trabajo_final_caichihua.service.IMatriculaService;
import com.caichihua.trabajo_final_caichihua.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/matricula")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{
        List<MatriculaDTO> list = mapperUtil.mapList(service.findAll(), MatriculaDTO.class);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Matricula obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, MatriculaDTO.class));
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto) throws Exception{
        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));

        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MatriculaDTO dto) throws Exception{
        Matricula obj = service.update(id, mapperUtil.map(dto, Matricula.class));

        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


}
