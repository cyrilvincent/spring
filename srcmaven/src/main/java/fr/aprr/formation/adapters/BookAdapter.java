package fr.aprr.formation.adapters;

import fr.aprr.formation.dtos.BookDTO;
import fr.aprr.formation.dtos.CustomerDTO;
import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;

public class BookAdapter {

    public static BookDTO toDTO(Book entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getNetPrice());
        return dto;
    }
}
