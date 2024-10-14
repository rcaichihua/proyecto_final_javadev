package com.caichihua.trabajo_final_caichihua.service.impl;


import lombok.RequiredArgsConstructor;



import com.caichihua.trabajo_final_caichihua.model.Curso;
import com.caichihua.trabajo_final_caichihua.repo.ICursoRepo;
import com.caichihua.trabajo_final_caichihua.repo.IGenericRepo;
import com.caichihua.trabajo_final_caichihua.service.ICursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService{

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }



}
