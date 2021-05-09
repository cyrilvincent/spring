package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Author;
import fr.aprr.formation.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorJPARepository extends CrudRepository<Author, Integer> {

    @Query("select a from Author a inner join fetch a.books where a.id=:id")
    Author findById(@Param("id") int id);

}
