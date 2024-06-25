package com.example.springboot.services;

import com.example.springboot.dtos.AvaliacaoRecordDTO;
import com.example.springboot.dtos.ConsultaRecordDTO;
import com.example.springboot.enums.EstadoSessaoEnum;
import com.example.springboot.models.AvaliacaoModel;
import com.example.springboot.models.ConsultaModel;
import com.example.springboot.repositories.AvaliacaoRepository;
import com.example.springboot.repositories.ConsultaRepository;
import com.example.springboot.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
@Service
public class AvaliacaoService {
    @Autowired
    AvaliacaoRepository avaliacaoRepository;
    UserRepository userRepository;
    ConsultaRepository consultaRepository;
    public AvaliacaoModel create(Integer userId, Integer consultaId, @Valid AvaliacaoRecordDTO avaliacao){
       findUserById(userId);
       findConsultaById(consultaId);

       AvaliacaoModel avaliacaoCreated = convert(avaliacao);
       this.avaliacaoRepository.save(avaliacaoCreated);

       return avaliacaoCreated;
    }

    public void delete(Integer id) {
        this.findById(id);
        this.avaliacaoRepository.deleteById(id);
    }
    private AvaliacaoModel convert(AvaliacaoRecordDTO avaliacao){
        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
        BeanUtils.copyProperties(avaliacao, avaliacaoModel);

        return avaliacaoModel;
    }
    private void findById(Integer id){
        var avaliacao = this.avaliacaoRepository.findById(id);
        if(avaliacao.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Avaliação não encontrada"
            );
        }
    }
    private void findUserById(Integer id){
        var user = this.userRepository.findById(id);
        if(user.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuário não encontrado"
            );
        }
    }
    private void findConsultaById(Integer id){
        var consulta = consultaRepository.findById(id);

        if(consulta.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Consulta não encontrada"
            );
        }

        ConsultaModel consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consulta, consultaModel);

        if(consultaModel.getEstadoSessao() != EstadoSessaoEnum.FINALIZADA) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "A consulta não foi finalizada"
            );
        }
    }
}
