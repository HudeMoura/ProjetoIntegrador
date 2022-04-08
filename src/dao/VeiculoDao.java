package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {
	
	private static String table = "veiculo";
	private static VeiculoDao instance;
	private Connection connection = ConnectionUtil.getConnection();
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		try {
			String sql = "insert into " + table + " (placa, descricao, quilometros_litro, veiculo_disponivel) values (?, ?, ?, ?)";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, veiculo.getPlaca());
			prepareStatement.setString(2, veiculo.getDescricao());
			prepareStatement.setDouble(3, veiculo.getQuilometrosPorLitro());
			prepareStatement.setBoolean(4, veiculo.isVeiculoDisponivel());
			
			prepareStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update " + table + " set placa = ?, descricao = ?, quilometros_litro = ?, veiculo_disponivel = ? where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, veiculo.getPlaca());
			prepareStatement.setString(2, veiculo.getDescricao());
			prepareStatement.setDouble(3, veiculo.getQuilometrosPorLitro());
			prepareStatement.setBoolean(4, veiculo.isVeiculoDisponivel());
			prepareStatement.setInt(5, veiculo.getId());
			
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idVeiculo) {
		try {
			String sql = "delete from " + table + " where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, idVeiculo);
			
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> listar() {
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			Statement createStatement = connection.createStatement();
			
			String sql = "select * from " + table;
			ResultSet resultSet = createStatement.executeQuery(sql);
			
			while(resultSet.next()) {
				Veiculo veiculo = getVeiculoFrom(resultSet);
				
				veiculos.add(veiculo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return veiculos;
	}
	
	private Veiculo getVeiculoFrom(ResultSet resultSet) {
		Veiculo veiculo = new Veiculo();
		
		try {
			int id = resultSet.getInt("id");
			String placa = resultSet.getString("placa");
			String descricao = resultSet.getString("descricao");
			double quilometrosPorLitro = resultSet.getDouble("quilometros_litro");
			boolean isVeiculoDisponivel = resultSet.getBoolean("veiculo_disponivel");
			
			veiculo = new Veiculo(placa, descricao, quilometrosPorLitro, isVeiculoDisponivel);
			veiculo.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return veiculo;
	}
	
	public Veiculo getById(int idVeiculo) {
		Veiculo funcionario = new Veiculo();
		
		try {
			String sql = "select * from veiculo where id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, idVeiculo);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			resultSet.next();
			funcionario = getVeiculoFrom(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}

}