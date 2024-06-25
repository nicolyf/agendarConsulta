package com.example.springboot.services;

import com.example.springboot.dtos.EnderecoRecordDTO;
import com.example.springboot.models.EnderecoModel;
import com.example.springboot.repositories.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService
{
    @Autowired
    EnderecoRepository enderecoRepository;
    public EnderecoModel create(EnderecoRecordDTO endereco){
        var enderecoModel = this.convert(endereco);
        enderecoRepository.save(enderecoModel);

        return enderecoModel;
    }

    public EnderecoModel update(EnderecoRecordDTO endereco){
        var enderecoModel = this.convert(endereco);
        enderecoRepository.save(enderecoModel);

        return enderecoModel;
    }

    public EnderecoModel convert (EnderecoRecordDTO endereco){
        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(endereco, enderecoModel);

        return enderecoModel;
    }
}
