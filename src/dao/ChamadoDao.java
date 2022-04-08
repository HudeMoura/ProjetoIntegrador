package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import model.Funcionario;
import model.Veiculo;
import util.ConnectionUtil;

public class ChamadoDao {
	
	private static ChamadoDao instance;
	private Connection connection = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void salvar(Chamado chamado) {
		try {
			String sql = "insert into chamado (id_funcionario, id_veiculo, endereco, data) values (?, ?, ?, ?)";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, chamado.getFuncionario().getId());
			prepareStatement.setInt(2, chamado.getVeiculo().getId());
			prepareStatement.setString(3, chamado.getEndereco());
			prepareStatement.setTimestamp(4, Timestamp.valueOf(chamado.getData()));
			
			prepareStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Chamado chamado) {
		try {
			String sql = "update chamado set id_funcionario = ?, id_veiculo = ?, endereco = ?, data = ? where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, chamado.getFuncionario().getId());
			prepareStatement.setInt(2, chamado.getVeiculo().getId());
			prepareStatement.setString(3, chamado.getEndereco());
			prepareStatement.setTimestamp(4, Timestamp.valueOf(chamado.getData()));
			prepareStatement.setInt(5, chamado.getId());
			
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void excluir(int idChamado) {
		try {
			String sql = "delete from chamado where id = ?";
			
			Chamado chamado = getById(idChamado);
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, idChamado);
			
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Chamado> listar() {
		ArrayList<Chamado> chamados = new ArrayList<Chamado>();
		
		try {
			Statement createStatement = connection.createStatement();
			
			String sql = "select * from chamado";
			ResultSet resultSet = createStatement.executeQuery(sql);
			
			while(resultSet.next()) {
				Chamado chamado = getChamadoFrom(resultSet);
				
				chamados.add(chamado);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chamados;
	}
	
	private Chamado getChamadoFrom(ResultSet resultSet) {
		Chamado chamado = new Chamado();
		
		try {
			int idFuncionario = resultSet.getInt("id_funcionario");
			Funcionario funcionario = FuncionarioDao.getInstance().getById(idFuncionario);
			
			int idVeiculo = resultSet.getInt("id_veiculo");
			Veiculo veiculo = VeiculoDao.getInstance().getById(idVeiculo);
			
			int id = resultSet.getInt("id");
			double quilometrosPercorridos = resultSet.getDouble("quilometros_percorridos");
			String endereco = resultSet.getString("endereco");
			LocalDateTime data = resultSet.getTimestamp("data").toLocalDateTime();
			
			chamado = new Chamado(funcionario, veiculo, endereco, data);
			chamado.setId(id);
			chamado.setQuilometrosPercorridos(quilometrosPercorridos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chamado;
	}
	
	public Chamado getById(int idChamado) {
		Chamado chamado = new Chamado();
		
		try {
			String sql = "select * from chamado where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, idChamado);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			resultSet.next();
			chamado = getChamadoFrom(resultSet);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chamado;
	}

}
