package com.example.springboot.services;

import com.example.springboot.dtos.UserRecordDTO;
import com.example.springboot.models.UserModel;
import com.example.springboot.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    EnderecoService enderecoService;

    public UserModel create(UserRecordDTO user){
        var userModel = this.convert(user);
        var endereco = enderecoService.create(user.endereco());
        userModel.setEndereco(endereco);
        userRepository.save(userModel);

        return userModel;
    }

    public UserModel get(Integer id){
        return this.findById(id);
    }

    public UserModel update(UserRecordDTO user){
        var userModel = this.convert(user);
        if(user.endereco() != null){
            var endereco = this.enderecoService.update(user.endereco());
            userModel.setEndereco(endereco);
        }
        userRepository.save(userModel);
        return userModel;
    }

    public void delete(Integer id) {
        var user = this.findById(id);
        this.userRepository.delete(user);
    }
    private UserModel findById(Integer id){
        var user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuário não encontrado"
            );
        }

        return user.get();
    }
    private UserModel convert (UserRecordDTO user){
        var userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);

        return userModel;
    }
}
