package com.folcademy.exampleapi.Services;

import com.folcademy.exampleapi.Exceptions.ExceptionsKind.UserBadRequestException;
import com.folcademy.exampleapi.Exceptions.ExceptionsKind.UserCreateException;
import com.folcademy.exampleapi.Exceptions.ExceptionsKind.UserNotFoundException;
import com.folcademy.exampleapi.Models.Dtos.UserAddDTO;
import com.folcademy.exampleapi.Models.Dtos.UserEditDTO;
import com.folcademy.exampleapi.Models.Dtos.UserReadDTO;
import com.folcademy.exampleapi.Models.Entities.UserEntity;
import com.folcademy.exampleapi.Models.Mappers.UserMapper;
import com.folcademy.exampleapi.Models.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserReadDTO> findAll(){
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::userEntityToUserReadDTO)
                .collect(Collectors.toList());
    }
    public UserReadDTO add(UserAddDTO userAddDTO){
        Boolean emailExist = userRepository.existsByEmail(userAddDTO.getEmail());
        if (emailExist) throw new UserBadRequestException("Ya existe usuario con ese email");
        return Optional
                .ofNullable(userAddDTO)
                .map(userMapper::userAddDTOToUserEntity)
                .map(userRepository::save)
                .map(userMapper::userEntityToUserReadDTO)
                .orElseThrow(()-> new UserCreateException("Ocurrio un error inesperado en la creacion del usuario"));

    }
    public UserReadDTO findById(Integer userId){
        return userRepository
                .findById(userId)
                .map(studentEntity -> userMapper.userEntityToUserReadDTO(studentEntity) )
                .orElseThrow(()-> new UserNotFoundException("No se encontro el usuario con el id especificado"));
    }

    public UserReadDTO deleteById(Integer userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("No se encontro el usuario con el id especificado"));

        userRepository.delete(user);

        return userMapper.userEntityToUserReadDTO(user);
    }

    public UserReadDTO edit(Integer userId, UserEditDTO user) {

        UserEntity userOld = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("No se encontro el usuario con el id especificado"));
        if(user.getName().isBlank() && user.getSurname().isBlank())
            throw new UserBadRequestException("No se encontraron datos para realizar la modificacion");
        if(!user.getName().isBlank() ) userOld.setName(user.getName());
        if(Objects.nonNull(user.getSurname())) userOld.setSurname(user.getSurname());

        UserEntity userNew = userRepository.save(userOld);

        return userMapper.userEntityToUserReadDTO(userNew);

    }
}
