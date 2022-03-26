package Principal;

import java.time.LocalDate;

import controller.FuncionarioController;
import model.Funcionario;

public class Principal {
	
	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario("Antonio Nunes", "123456789", LocalDate.of(2020,12,12), true);
		
		Funcionario f2 = new Funcionario("Roberto Carlos","123456798", LocalDate.of(2020,11,11), true);
				
		FuncionarioController controller = new FuncionarioController();
		try {
			controller.salvar(f1);
			controller.salvar(f2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Funcionario c : controller.listar()) {
			System.out.println(c.toString());
		}
	}
}

