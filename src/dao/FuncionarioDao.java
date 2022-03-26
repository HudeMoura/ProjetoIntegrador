package dao;

import java.util.ArrayList;
import java.util.List;


import model.Funcionario;


public class FuncionarioDao {
	
	private static FuncionarioDao instance;
	private List<Funcionario> listaFuncionario = new ArrayList<>();
	
	
	public static FuncionarioDao getInstance() {
		if (instance == null) {
			instance = new FuncionarioDao();
		}
		return instance;
	}
	
	public void salvar(Funcionario funcionario) {
		listaFuncionario.add(funcionario);
		int indexOf = listaFuncionario.indexOf(funcionario);
		listaFuncionario.get(indexOf).setId(indexOf + 1);
	}
	
	public void atualizar(Funcionario funcionario) {
		listaFuncionario.set(funcionario.getId() - 1, funcionario);
	}

	
	public void excluir(int idFuncionario) {
		listaFuncionario.remove(idFuncionario - 1);
		
	}
	
	public List<Funcionario> listar() {
		return listaFuncionario;
	}

}