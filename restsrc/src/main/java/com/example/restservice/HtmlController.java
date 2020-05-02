package com.example.restservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/html")
public class HtmlController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/customers")
	public String customers(Model model) {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1,"Cyril","Vincent"));
		customers.add(new Customer(2,"Jack","Bauer"));
		model.addAttribute("customers", customers);
		return "customers";
	}
}
