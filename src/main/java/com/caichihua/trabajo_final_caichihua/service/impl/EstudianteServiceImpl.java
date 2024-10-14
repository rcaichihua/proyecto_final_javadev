package com.caichihua.trabajo_final_caichihua.service.impl;

import com.caichihua.trabajo_final_caichihua.model.Estudiante;
import com.caichihua.trabajo_final_caichihua.repo.IEstudianteRepo;
import com.caichihua.trabajo_final_caichihua.repo.IGenericRepo;
import com.caichihua.trabajo_final_caichihua.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Estudiante> findByName(String name) {
        return null;
    }

    @Override
    public List<Estudiante> findByNameLike(String name) {
        return null;
    }
}
