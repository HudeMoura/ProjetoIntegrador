package dao;

import java.util.ArrayList;
import java.util.List;

import model.Veiculo;

public class VeiculoDao {
	
	private static VeiculoDao instance;
	private List<Veiculo> listaVeiculo = new ArrayList<>();
	
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		listaVeiculo.add(veiculo);
		int indexOf = listaVeiculo.indexOf(veiculo);
		listaVeiculo.get(indexOf).setId(indexOf + 1);
	}
	
	public void atualizar(Veiculo veiculo) {
		listaVeiculo.set(veiculo.getId() - 1, veiculo);
	}

	
	public void excluir(int idVeiculo) {
		listaVeiculo.remove(idVeiculo - 1);
		
	}
	
	public List<Veiculo> listar() {
		return listaVeiculo;
	}

}