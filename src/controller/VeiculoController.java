package controller;

import java.util.List;

import dao.FuncionarioDao;
import dao.VeiculoDao;
import model.Veiculo;

public class VeiculoController {
	
	public void salvar(Veiculo veiculo) throws Exception {
		if (veiculo.getDescricao() == null || veiculo.getPlaca() == null) {
			throw new Exception("Veiculo sem descrição ou placa!");
		}
		VeiculoDao.getInstance().salvar(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) throws Exception {
		if (veiculo.getId() == 0) {
			throw new Exception("Número do Veiculo Inválido!");
		}
		VeiculoDao.getInstance().atualizar(veiculo);
	}
	
	public void excluir(int idVeiculo) throws Exception {
		if (idVeiculo == 0) {
			throw new Exception("Nenhum Chamado Selecionado!");
		}
		VeiculoDao.getInstance().excluir(idVeiculo);
	}
	
	public List<Veiculo> listar() {
		return VeiculoDao.getInstance().listar();
	}
}
