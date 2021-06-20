package com.examesapp.examesapp.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examesapp.examesapp.model.Exame;

@Repository
public class ExameRepository {
	
	@Autowired
	DataSource datasource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(datasource);
	}
	
	// Inserir novo Exame
	public void inserirExame(Exame exame) {
		String sql = "INSERT INTO exames(nome, paciente, data, resultado) VALUES (?,?,?,?)";
		Object[] obj = new Object[4];
		obj[0] = exame.getNome();
		obj[1] = exame.getPaciente();
		obj[2] = exame.getData();
		obj[3] = exame.getResultado();
		jdbc.update(sql, obj);
	}

	// Listar todos os Exames
	public List<Map<String, Object>> listarExames() {
		String sql = "SELECT * FROM exames ORDER BY nome";
		return (List<Map<String, Object>>) jdbc.queryForList(sql);
	}

	// Pegar Exame pelo ID
	public Map<String, Object> pegarExame(int id) {
		String sql = "SELECT * FROM exames WHERE id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	// Atualizar dados do Exame
	public void atualizarExame(int id, Exame exame) {
		String sql = "UPDATE exames SET nome = ?, paciente = ?, data = ?, resultado = ? WHERE id = ?";
		Object[] obj = new Object[5];
		obj[0] = exame.getNome();
		obj[1] = exame.getPaciente();
		obj[2] = exame.getData();
		obj[3] = exame.getResultado();
		obj[4] = id;
		jdbc.update(sql, obj);		
	}

	// Deletar Exame pelo ID
	public void deletarExame(int id) {
		String sql = "DELETE FROM exames WHERE id = ?";
		jdbc.update(sql, new Object[] {id});
	}
}
