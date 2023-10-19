package com.folcademy.exampleapi.Models.Repositories;

import com.folcademy.exampleapi.Models.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByEmail(String email);
    Optional<UserEntity> findOneByEmail(String email);
}
