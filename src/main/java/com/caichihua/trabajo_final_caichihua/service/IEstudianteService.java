package com.caichihua.trabajo_final_caichihua.service;

import com.caichihua.trabajo_final_caichihua.model.Estudiante;

import java.util.List;


public interface IEstudianteService extends ICRUD<Estudiante, Integer>{

    List<Estudiante> findByName(String name);
    List<Estudiante> findByNameLike(String name);
}
