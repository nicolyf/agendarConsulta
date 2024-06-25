package com.example.springboot.services;

import com.example.springboot.dtos.ProfissionalRecordDTO;
import com.example.springboot.models.ProfissionalModel;
import com.example.springboot.repositories.ProfissionalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository profissionalRepository;
    public ProfissionalModel create(ProfissionalRecordDTO profissional){
        var profissionalModel = this.convert(profissional);
        profissionalRepository.save(profissionalModel);

        return profissionalModel;
    }

    public ProfissionalModel get(Integer id){
        return this.findById(id);
    }

    public ProfissionalModel update(ProfissionalRecordDTO profissional){
        var profissionalModel = this.convert(profissional);
        profissionalRepository.save(profissionalModel);
        return profissionalModel;
    }

    public void delete(Integer id) {
        var profissional = this.findById(id);
        this.profissionalRepository.delete(profissional);
    }
    private ProfissionalModel findById(Integer id){
        var profissional = profissionalRepository.findById(id);
        if(profissional.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Profissional não encontrado"
            );
        }

        return profissional.get();
    }
    private ProfissionalModel convert (ProfissionalRecordDTO profissional){
        var profissionalModel = new ProfissionalModel();
        BeanUtils.copyProperties(profissional, profissionalModel);

        return profissionalModel;
    }
}
