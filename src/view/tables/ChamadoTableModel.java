package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Chamado;

public class ChamadoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_FUNCIONARIO = 1;
	private static final int COL_VEICULO = 2;
	private static final int COL_ENDERECO = 3;
	private static final int COL_DATA = 4;
	private static final int COL_QUILOMETROS_PERCORRIDOS = 5;

	private List<Chamado> valores;       

	public ChamadoTableModel(List<Chamado> valores) {
		this.valores = new ArrayList<Chamado>(valores);
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int column) {
		
		String columnName;
		
		switch (column) {
			case COL_ID:
				columnName =  "Id";
				break;
			case COL_FUNCIONARIO:
				columnName =  "Funcionário";
				break;
			case COL_VEICULO:
				columnName =  "Veículo";
				break;
			case COL_ENDERECO:
				columnName =  "Endereço";
				break;
			case COL_DATA:
				columnName =  "Data";
				break;
			case COL_QUILOMETROS_PERCORRIDOS:
				columnName =  "Quilômetros percorridos";
				break;
			default:
				columnName = "";
				break;
		}
		
		return columnName;
	}

	public Object getValueAt(int row, int column) {
		Chamado Chamado = valores.get(row);
		Object value;
		
		switch (column) {
			case COL_ID:
				value = Chamado.getId();
				break;
			case COL_FUNCIONARIO:
				value = Chamado.getFuncionario();
				break;
			case COL_VEICULO:
				value = Chamado.getVeiculo();
				break;
			case COL_ENDERECO:
				value = Chamado.getEndereco();
				break;
			case COL_DATA:
				value = Chamado.getData();
				break;
			case COL_QUILOMETROS_PERCORRIDOS:
				value = Chamado.getQuilometrosPercorridos();
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

	public Chamado get(int row) {
		return valores.get(row);
	}
	
}
