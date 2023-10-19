package com.folcademy.exampleapi.Models.Repositories;

import com.folcademy.exampleapi.Models.Entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
