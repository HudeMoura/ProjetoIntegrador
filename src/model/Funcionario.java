package model;

import java.time.LocalDate;

public class Funcionario {

	private int id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private boolean habilitadoConduzir;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, boolean habilitadoConduzir) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.habilitadoConduzir = habilitadoConduzir;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isHabilitadoConduzir() {
		return habilitadoConduzir;
	}

	public void setHabilitadoConduzir(boolean habilitadoConduzir) {
		this.habilitadoConduzir = habilitadoConduzir;
	}
	
	public String toString() {
		return this.nome + " - " + this.cpf;
	}
}
