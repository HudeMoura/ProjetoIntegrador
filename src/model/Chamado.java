package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Chamado {

	private int id;
	private Funcionario funcionario;
	private Veiculo veiculo;
	private Double quilometrosPercorridos;
	private String endereco;
	private LocalDateTime data;

	public Chamado(Funcionario funcionario, Veiculo veiculo, String endereco, LocalDateTime data) {
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.endereco = endereco;
		this.quilometrosPercorridos = 0.0;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Double getQuilometrosPercorridos() {
		return quilometrosPercorridos;
	}

	public void setQuilometrosPercorridos(Double quilometrosPercorridos) {
		this.quilometrosPercorridos = quilometrosPercorridos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Double calcularCO2Emitido() {
		if (veiculo.getQuilometrosPorLitro() == 0 || this.quilometrosPercorridos == null) { return null; }

		Double percentualGasolinaPorLitro = 0.82;
		Double densidadeGasolina = 0.75;
		Double fatorTransformacaoGasolina = 3.7;

		Double consumoGasolinaLitros = this.quilometrosPercorridos / veiculo.getQuilometrosPorLitro();

		return consumoGasolinaLitros * percentualGasolinaPorLitro * densidadeGasolina * fatorTransformacaoGasolina;
	}
	
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return this.data.format(formatter) + " - " + this.endereco + " - " + this.funcionario.toString();
	}

}
