package Principal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import controller.ChamadoController;
import controller.FuncionarioController;
import controller.VeiculoController;
import model.Chamado;
import model.Funcionario;
import model.Veiculo;

public class Principal {
	
	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario("Antonio Nunes", "11111111111", LocalDate.of(2020,12,12), true);
		
		Funcionario f2 = new Funcionario("Roberto Carlos","22222222222", LocalDate.of(2020,11,11), true);
				
		FuncionarioController funcionarioController = new FuncionarioController();
		
		System.out.println(" --- Salvar Funcionário 1 e 2 --- ");
		
		try {
			funcionarioController.salvar(f1);
			funcionarioController.salvar(f2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Funcionario c : funcionarioController.listar()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" --- Atualizar Funcionário 1 --- ");
		
		f1.setNome("Amado Batista");
		try {
			funcionarioController.atualizar(f1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Funcionario c : funcionarioController.listar()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" --- Excluido Funcionário 2 --- ");
		
		try {
			funcionarioController.excluir(f2.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Funcionario c : funcionarioController.listar()) {
			System.out.println(c.toString());
		}
		
		
		Veiculo v1 = new Veiculo("AAA0505", "Mercedez 2.0", 14.0, true);
		
		Veiculo v2 = new Veiculo("BBB1010", "Mercedez 1.6", 18.0, true);
		
		VeiculoController veiculoController = new VeiculoController();
		
		
		System.out.println(" --- Salvar Veículo 1 e 2 --- ");
		
		try {
			veiculoController.salvar(v1);
			veiculoController.salvar(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Veiculo c : veiculoController.listar()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" --- Atualizar Veículo 1 --- ");
		
		v1.setDescricao("Mercedez 2.5");
		try {
			veiculoController.atualizar(v1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Veiculo c : veiculoController.listar()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" --- Excluido Veículo 2 --- ");
		
		try {
			veiculoController.excluir(v2.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Veiculo c : veiculoController.listar()) {
			System.out.println(c.toString());
		}
		
		Chamado c1 = new Chamado(f1, v1, "Rua Aleatoria, 12", LocalDateTime.now());
		
		Chamado c2 = new Chamado(f2, v2, "Rua Estranha, 33", LocalDateTime.now());
		
		
		ChamadoController chamadoController = new ChamadoController();
		
		
		System.out.println(" --- Salvar Chamado 1 e 2 --- ");
		
		try {
			chamadoController.salvar(c1);
			chamadoController.salvar(c2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Chamado c : chamadoController.listar()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" --- Atualizar Chamado 1 --- ");
		
		v1.setDescricao("Mercedez 2.5");
		try {
			chamadoController.atualizar(c1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Chamado c : chamadoController.listar()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" --- Excluido Chamado 2 --- ");
		
		try {
			chamadoController.excluir(c2.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Chamado c : chamadoController.listar()) {
			System.out.println(c.toString());
		}
		
		
		
		
		
	}
}

