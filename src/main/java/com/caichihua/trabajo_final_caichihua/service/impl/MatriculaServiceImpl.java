package com.caichihua.trabajo_final_caichihua.service.impl;

import com.caichihua.trabajo_final_caichihua.model.Matricula;
import com.caichihua.trabajo_final_caichihua.repo.IGenericRepo;
import com.caichihua.trabajo_final_caichihua.repo.IMatriculaRepo;
import com.caichihua.trabajo_final_caichihua.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }



}
