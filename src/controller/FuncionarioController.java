package controller;

import java.util.List;

import dao.FuncionarioDao;
import model.Funcionario;


public class FuncionarioController {
	
	public void salvar(Funcionario funcionario) throws Exception {
		if (funcionario.getNome() == null || funcionario.getNome().length() < 3) {
			throw new Exception("Funcion�rio inv�lido!");
		}
		FuncionarioDao.getInstance().salvar(funcionario);
	}
	
	public void atualizar(Funcionario funcionario) throws Exception{
		if (funcionario.getNome() == null || funcionario.getNome().length() < 3) {
			throw new Exception("Funcion�rio inv�lido!");
		}
		FuncionarioDao.getInstance().salvar(funcionario);
		
	}
	
	public void excluir(int idFuncionario) throws Exception {
		if (idFuncionario == 0) {
			throw new Exception("Nenhum Funcionario Selecionado!");
		}
		FuncionarioDao.getInstance().excluir(idFuncionario);
		
	}
	
	public List<Funcionario> listar() {
		return FuncionarioDao.getInstance().listar();
	}
}
