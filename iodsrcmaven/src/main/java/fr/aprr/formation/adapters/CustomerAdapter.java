package fr.aprr.formation.adapters;

import fr.aprr.formation.dtos.CustomerDTO;
import fr.aprr.formation.entities.Customer;

public class CustomerAdapter {

    public CustomerDTO toDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFname() + " " + entity.getLname());
        return dto;
    }
}
