package com.goodibooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path= {"/book/"})
public class BookController {

	@GetMapping(path= {"/list"})
	public String showList() {
		
		return "book/list";
	}
}
