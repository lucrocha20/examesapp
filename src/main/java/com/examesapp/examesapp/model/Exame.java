package com.examesapp.examesapp.model;

public class Exame {
	private int id;
	private String nome;
	private String paciente;
	private String data;
	private String resultado;
	
	public Exame() { }

	public Exame(int id, String nome, String paciente, String data, String resultado) {
		super();
		this.id = id;
		this.nome = nome;
		this.paciente = paciente;
		this.data = data;
		this.resultado = resultado;
	}

	public Exame(String nome, String paciente, String data, String resultado) {
		super();
		this.nome = nome;
		this.paciente = paciente;
		this.data = data;
		this.resultado = resultado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nome=" + nome + ", paciente=" + paciente + ", dataExame=" + data
				+ ", resultado=" + resultado + "]";
	}
	
}
