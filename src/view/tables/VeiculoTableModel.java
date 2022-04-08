package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Veiculo;

public class VeiculoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_PLACA = 1;
	private static final int COL_DESCRICAO = 2;
	private static final int COL_QUILOMETRO_POR_LITRO = 3;
	private static final int COL_VEICULO_DISPONIVEL = 4;

	private List<Veiculo> valores;       

	public VeiculoTableModel(List<Veiculo> valores) {
		this.valores = new ArrayList<Veiculo>(valores);
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int column) {
		
		String columnName;
		
		switch (column) {
			case COL_ID:
				columnName =  "Id";
				break;
			case COL_PLACA:
				columnName =  "Nome";
				break;
			case COL_DESCRICAO:
				columnName =  "Cpf";
				break;
			case COL_QUILOMETRO_POR_LITRO:
				columnName =  "Data de nascimento";
				break;
			case COL_VEICULO_DISPONIVEL:
				columnName =  "Habilitado a conduzir";
				break;
			default:
				columnName = "";
				break;
		}
		
		return columnName;
	}

	public Object getValueAt(int row, int column) {
		Veiculo veiculo = valores.get(row);
		Object value;
		
		switch (column) {
			case COL_ID:
				value = veiculo.getId();
				break;
			case COL_PLACA:
				value = veiculo.getPlaca();
				break;
			case COL_DESCRICAO:
				value = veiculo.getDescricao();
				break;
			case COL_QUILOMETRO_POR_LITRO:
				value = veiculo.getQuilometrosPorLitro();
				break;
			case COL_VEICULO_DISPONIVEL:
				value = veiculo.isVeiculoDisponivel() ? "Sim" : "Não" ;
				break;
			default:
				value = "";
				break;
		}
		
		return value;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Veiculo get(int row) {
		return valores.get(row);
	}
	
}
