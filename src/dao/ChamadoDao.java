package dao;

import java.util.ArrayList;
import java.util.List;

import model.Chamado;

public class ChamadoDao {
	
	private static ChamadoDao instance;
	private List<Chamado> listaChamado = new ArrayList<>();
	
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void salvar(Chamado chamado) {
		listaChamado.add(chamado);
	}
	
	public void atualizar(Chamado chamado) {
		listaChamado.set(chamado.getId(), chamado);
	}

	
	public void excluir(int idChamado) {
		listaChamado.remove(idChamado);
		
	}
	
	public List<Chamado> listar() {
		return listaChamado;
	}

}
