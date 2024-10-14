package com.caichihua.trabajo_final_caichihua.service.impl;


import com.caichihua.trabajo_final_caichihua.model.Curso;
import com.caichihua.trabajo_final_caichihua.model.Detallematricula;
import com.caichihua.trabajo_final_caichihua.repo.ICursoRepo;
import com.caichihua.trabajo_final_caichihua.repo.IDetalleMatriculaRepo;
import com.caichihua.trabajo_final_caichihua.repo.IGenericRepo;
import com.caichihua.trabajo_final_caichihua.service.ICursoService;
import com.caichihua.trabajo_final_caichihua.service.IDetalleMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleMatriculaServiceImpl extends CRUDImpl<Detallematricula, Integer> implements IDetalleMatriculaService {

    private final IDetalleMatriculaRepo repo;

    @Override
    protected IGenericRepo<Detallematricula, Integer> getRepo() {
        return repo;
    }



}
