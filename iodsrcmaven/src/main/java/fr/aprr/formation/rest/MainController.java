package fr.aprr.formation.rest;

import fr.aprr.formation.adapters.CustomerAdapter;
import fr.aprr.formation.dtos.CustomerDTO;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.services.CustomerJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CustomerJPAService customerService;

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
        customerService.getRepository().findAll().forEach(c -> dtos.add(adapt.toDTO(c)));
        return dtos;
    }
}
