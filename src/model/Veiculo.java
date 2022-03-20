package model;

public class Veiculo {

	private int id;
	private String placa;
	private String descricao;
	private Double quilometrosPorLitro;
	private boolean veiculoDisponivel;

	public Veiculo(String placa, String descricao, Double quilometrosPorLitro, boolean veiculoDisponivel) {
		this.placa = placa;
		this.descricao = descricao;
		this.quilometrosPorLitro = quilometrosPorLitro;
		this.veiculoDisponivel = veiculoDisponivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getQuilometrosPorLitro() {
		return quilometrosPorLitro;
	}

	public void setQuilometrosPorLitro(Double quilometrosPorLitro) {
		this.quilometrosPorLitro = quilometrosPorLitro;
	}

	public boolean isVeiculoDisponivel() {
		return veiculoDisponivel;
	}

	public void setVeiculoDisponivel(boolean veiculoDisponivel) {
		this.veiculoDisponivel = veiculoDisponivel;
	}
}
