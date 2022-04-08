package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import model.Funcionario;
import util.ConnectionUtil;

public class FuncionarioDao {
	
	private static FuncionarioDao instance;
	private Connection connection = ConnectionUtil.getConnection();
	
	public static FuncionarioDao getInstance() {
		if (instance == null) {
			instance = new FuncionarioDao();
		}
		return instance;
	}
	
	public void salvar(Funcionario funcionario) {
		try {
			String sql = "insert into funcionario (nome, cpf, data_nascimento, habilitado_conduzir) values (?, ?, ?, ?)";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, funcionario.getNome());
			prepareStatement.setString(2, funcionario.getCpf());
			prepareStatement.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
			prepareStatement.setBoolean(4, funcionario.isHabilitadoConduzir());
			
			prepareStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		try {
			String sql = "update funcionario set nome = ?, cpf = ?, data_nascimento = ?, habilitado_conduzir = ? where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, funcionario.getNome());
			prepareStatement.setString(2, funcionario.getCpf());
			prepareStatement.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
			prepareStatement.setBoolean(4, funcionario.isHabilitadoConduzir());
			prepareStatement.setInt(5, funcionario.getId());
			
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void excluir(int idFuncionario) {
		try {
			String sql = "delete from funcionario where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, idFuncionario);
			
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listar() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			Statement createStatement = connection.createStatement();
			
			String sql = "select * from funcionario";
			ResultSet resultSet = createStatement.executeQuery(sql);
			
			while(resultSet.next()) {
				Funcionario funcionario = getFuncionarioFrom(resultSet);
				
				funcionarios.add(funcionario);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionarios;
	}
	
	private Funcionario getFuncionarioFrom(ResultSet resultSet) {
		Funcionario funcionario = new Funcionario();
		
		try {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String cpf = resultSet.getString("cpf");
			LocalDate dataNascimento = resultSet.getDate("data_nascimento").toLocalDate();
			boolean isHabilitadoConduzir = resultSet.getBoolean("habilitado_conduzir");
			
			funcionario = new Funcionario(nome, cpf, dataNascimento, isHabilitadoConduzir);
			funcionario.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	public Funcionario getById(int idFuncionario) {
		Funcionario funcionario = new Funcionario();
		
		try {
			
			String sql = "select * from funcionario where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, idFuncionario);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			resultSet.next();
			funcionario = getFuncionarioFrom(resultSet);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}

}