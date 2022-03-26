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
		int indexOf = listaChamado.indexOf(chamado);
		listaChamado.get(indexOf).setId(indexOf + 1);
	}
	
	public void atualizar(Chamado chamado) {
		listaChamado.set(chamado.getId() - 1, chamado);
	}

	
	public void excluir(int idChamado) {
		listaChamado.remove(idChamado - 1);
		
	}
	
	public List<Chamado> listar() {
		return listaChamado;
	}

}
