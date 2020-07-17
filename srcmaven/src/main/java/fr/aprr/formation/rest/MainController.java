package fr.aprr.formation.rest;

import fr.aprr.formation.adapters.BookAdapter;
import fr.aprr.formation.adapters.CustomerAdapter;
import fr.aprr.formation.dtos.BookDTO;
import fr.aprr.formation.dtos.CustomerDTO;
import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.services.CustomerJPAService;
import fr.aprr.formation.services.JPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CustomerJPAService customerService;

    @Autowired
    private JPAService bookService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello "+name;
    }

    @GetMapping("/customer/mock/{id}")
    public CustomerDTO customerMock(@PathVariable int id) {
//        CustomerDTO dto = new CustomerDTO();
//        dto.setId(id);
//        dto.setFullName("Cyril Vincent");
//        return dto;
        Customer c = new Customer(id,"Vincent","Cyril","");
        CustomerAdapter adapt = new CustomerAdapter();
        return adapt.toDTO(c);
    }

    @GetMapping("/customers")
    public List<CustomerDTO> customers() {
        CustomerAdapter adapt = new CustomerAdapter();
        List<CustomerDTO> dtos = new ArrayList<>();
        customerService.getRepository().findAll().forEach(e -> dtos.add(adapt.toDTO(e)));
        return dtos;
    }

    @GetMapping("/books")
    public List<BookDTO> books() {
        List<BookDTO> dtos = new ArrayList<>();
        bookService.getRepository().findAll().forEach(e -> dtos.add(BookAdapter.toDTO(e)));
        return dtos;
    }

    @GetMapping("/books/price/{price}")
    public List<BookDTO> booksByPrice(@PathVariable double price) {
        List<BookDTO> dtos = new ArrayList<>();
        bookService.getRepository().findByPriceLessThan(price).forEach(e -> dtos.add(BookAdapter.toDTO(e)));
        return dtos;
    }

    @GetMapping("/book/{id}")
    public BookDTO book(@PathVariable int id) {
        Book b = bookService.getRepository().findById(id);
        if(b == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
        return BookAdapter.toDTO(b);
    }

    @PostMapping("/book")
    public Book postBook(@RequestBody Book book) {
        bookService.getRepository().save(book);
        return book;
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.getRepository().deleteById(id);
    }

    @PutMapping("/book/{id}")
    public BookDTO putBook(@PathVariable int id, @RequestBody Book book) {
        Book b = bookService.getRepository().findById(id);
        if(b == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
        b.setPrice(book.getPrice());
        b.setTitle(book.getTitle());
        bookService.getRepository().save(b);
        return BookAdapter.toDTO(b);
    }


}
