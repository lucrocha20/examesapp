package com.examesapp.examesapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.examesapp.examesapp.model.Exame;
import com.examesapp.examesapp.service.ExameService;

@Controller
public class ExameController {

	@Autowired
	private ApplicationContext context;
	
	// Lista de Exames
	@GetMapping("/exames")
	public String listarExames(Model model) {
		ExameService es = context.getBean(ExameService.class);
		model.addAttribute("exames", es.listarExames());
		return "listaexames";
	}
	
	// Visualizar Exame
	@GetMapping("/exame/{id}")
	public String formExame(@PathVariable("id") int id, Model model) {
		ExameService es = context.getBean(ExameService.class);
		Map<String, Object> old = es.pegarExame(id);
		Exame exame = new Exame((String) old.get("nome"),
								(String) old.get("paciente"),
								(String) old.get("data"),
								(String) old.get("resultado"));
		model.addAttribute("old", exame);
		model.addAttribute("id", id);
		return "formexame";
	}
	
	// Adicionar novo Exame
	@GetMapping("/exameadd")
	public String formExameAdd(Model model) {
		model.addAttribute("exame", new Exame());
		return "formexameadd";
	}
	
	@PostMapping("/exameadd")
	public String inserirExame(@ModelAttribute Exame exame) {
		ExameService es = context.getBean(ExameService.class);
		es.inserirExame(exame);
		return "redirect:/exames";
	}
	
	// Atualizar dados do Exame
	@GetMapping("/exameupd/{id}")
	public String formExameUpd(@PathVariable("id") int id, Model model) {
		ExameService es = context.getBean(ExameService.class);
		Map<String, Object> old = es.pegarExame(id);
		Exame exame = new Exame((String) old.get("nome"),
								(String) old.get("paciente"),
								(String) old.get("data"),
								(String) old.get("resultado"));
		model.addAttribute("old", exame);
		model.addAttribute("id", id);
		return "formexameupd";
	}
	
	@PostMapping("/exameupd/{id}")
	public String atualizarExame(@PathVariable("id") int id, @ModelAttribute Exame exame) {
		ExameService es = context.getBean(ExameService.class);
		es.atualizarExame(id, exame);
		return "redirect:/exames";
	}
	
	// Deletar Exame
	@PostMapping("/examedel/{id}")
	public String deletarExame(@PathVariable("id") int id) {
		ExameService es = context.getBean(ExameService.class);
		es.deletarExame(id);
		return "redirect:/exames";
	}
	
}
