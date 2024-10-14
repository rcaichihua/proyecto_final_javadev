package com.caichihua.trabajo_final_caichihua.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caichihua.trabajo_final_caichihua.dto.CursoDTO;
import com.caichihua.trabajo_final_caichihua.model.Curso;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

  
}
