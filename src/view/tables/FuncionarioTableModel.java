package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_CPF = 2;
	private static final int COL_DATA_NASCIMENTO = 3;
	private static final int COL_HABILITADO_CONDUZIR = 4;

	private List<Funcionario> valores;       

	public FuncionarioTableModel(List<Funcionario> valores) {
		this.valores = new ArrayList<Funcionario>(valores);
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
			case COL_NOME:
				columnName =  "Nome";
				break;
			case COL_CPF:
				columnName =  "Cpf";
				break;
			case COL_DATA_NASCIMENTO:
				columnName =  "Data de nascimento";
				break;
			case COL_HABILITADO_CONDUZIR:
				columnName =  "Habilitado a conduzir";
				break;
			default:
				columnName = "";
				break;
		}
		
		return columnName;
	}

	public Object getValueAt(int row, int column) {
		Funcionario funcionario = valores.get(row);
		Object value;
		
		switch (column) {
			case COL_ID:
				value = funcionario.getId();
				break;
			case COL_NOME:
				value = funcionario.getNome();
				break;
			case COL_CPF:
				value = funcionario.getCpf();
				break;
			case COL_DATA_NASCIMENTO:
				value = funcionario.getDataNascimento();
				break;
			case COL_HABILITADO_CONDUZIR:
				value = funcionario.isHabilitadoConduzir() ? "Sim" : "Não";
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

	public Funcionario get(int row) {
		return valores.get(row);
	}
	
}
