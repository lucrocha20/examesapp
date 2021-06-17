package com.examesapp.examesapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examesapp.examesapp.model.Exame;
import com.examesapp.examesapp.repository.ExameRepository;

@Service
public class ExameService {

	@Autowired
	ExameRepository exameRepo;
	
	public void inserirExame(Exame exame) {
		exameRepo.inserirExame(exame);
	}
	
	public List<Map<String, Object>> listarExames() {
		return exameRepo.listarExames();
	}
	
	public Map<String, Object> pegarExame(int id) {
		return exameRepo.pegarExame(id);
	}
	
	public void atualizarExame(int id, Exame exame) {
		exameRepo.atualizarExame(id, exame);
	}
	
	public void deletarExame(int id) {
		exameRepo.deletarExame(id);
	}
}
