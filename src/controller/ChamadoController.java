package controller;

import java.util.List;

import dao.ChamadoDao;
import model.Chamado;


public class ChamadoController {
	
	public void salvar(Chamado chamado) throws Exception {
		if (chamado.getId() == 0) {
			throw new Exception("Chamado inválido!");
		}
		ChamadoDao.getInstance().salvar(chamado);
	}
	
	public void atualizar(Chamado chamado) throws Exception{
		if (chamado.getId() == 0) {
			throw new Exception("Número de Chamado Inválido!");
		}
		ChamadoDao.getInstance().atualizar(chamado);
		
	}
	
	public void excluir(int idChamado) throws Exception {
		if (idChamado == 0) {
			throw new Exception("Nenhum Chamado Selecionado!");
		}
		ChamadoDao.getInstance().excluir(idChamado);
		
	}
	
	public List<Chamado> listar() {
		return ChamadoDao.getInstance().listar();
	}
}

