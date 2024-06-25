package com.example.springboot.services;

import com.example.springboot.dtos.ConsultaRecordDTO;
import com.example.springboot.enums.EstadoSessaoEnum;
import com.example.springboot.models.ConsultaModel;
import com.example.springboot.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository;
    public ConsultaModel create(@Valid ConsultaRecordDTO consulta){
        var consultaModel = this.convert(consulta);
        consultaModel.setEstadoSessao(EstadoSessaoEnum.REGISTRADA);
        consultaRepository.save(consultaModel);

        return consultaModel;
    }
    public ConsultaModel get(Integer id){
        ConsultaModel consulta = findById(id);
        return consulta;
    }


    public ConsultaModel iniciarConsulta(Integer id){
        ConsultaModel consulta = findById(id);
        consulta.setEstadoSessao(EstadoSessaoEnum.INICIADA);
        consultaRepository.save(consulta);
        return consulta;
    }

    public ConsultaModel finalizarConsulta(Integer id){
        ConsultaModel consulta = findById(id);
        consulta.setEstadoSessao(EstadoSessaoEnum.FINALIZADA);
        consultaRepository.save(consulta);
        return consulta;
    }

    private ConsultaModel findById(Integer id){
        var consulta = consultaRepository.findById(id);
        if(consulta.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Consulta não encontrada"
            );
        }

        return consulta.get();
    }
    private ConsultaModel convert(ConsultaRecordDTO consulta){
        ConsultaModel consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consulta, consultaModel);

        return consultaModel;
    }
}
