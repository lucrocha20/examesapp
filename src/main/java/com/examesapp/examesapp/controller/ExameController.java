package com.examesapp.examesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.examesapp.examesapp.service.ExameService;

@Controller
public class ExameController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/exame")
	public String listarExames(Model model) {
		ExameService es = context.getBean(ExameService.class);
		model.addAttribute("exames", es.listarExames());
		return "listaexames";
	}
}
