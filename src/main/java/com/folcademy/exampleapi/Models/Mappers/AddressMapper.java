package com.folcademy.exampleapi.Models.Mappers;

import com.folcademy.exampleapi.Models.Dtos.AddressReadDTO;
import com.folcademy.exampleapi.Models.Entities.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressEntity addressReadDTOToAddressEntity(AddressReadDTO addressReadDTO) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setNumber(addressReadDTO.getNumber());
        addressEntity.setStreet(addressReadDTO.getStreet());
        return addressEntity;
    }
}
