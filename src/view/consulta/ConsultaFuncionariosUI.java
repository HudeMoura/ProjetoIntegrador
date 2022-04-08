package view.consulta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.FuncionarioController;
import model.Funcionario;
import view.cadastro.CadastroFuncionarioUI;
import view.tables.FuncionarioTableModel;

public class ConsultaFuncionariosUI extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tableConsultaFuncionario;
	private FuncionarioController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionariosUI frame = new ConsultaFuncionariosUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaFuncionariosUI() {
		setTitle("Consulta de Funcion\u00E1rios");
		setClosable(true);
		setBounds(50, 50, 800, 440);
		
		tableConsultaFuncionario = new JTable();
		
		carregarTabela();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = getFuncionarioSelecionado();
				
				try {
					getController().excluir(funcionario.getId());
					carregarTabela();
					showMessage("Funcionário excluído com sucesso");
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("Erro ao excluir funcionário");
				}
;			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = getFuncionarioSelecionado();
				CadastroFuncionarioUI cadastroFuncionarioUI = new CadastroFuncionarioUI();
				cadastroFuncionarioUI.editar(funcionario);
				cadastroFuncionarioUI.setVisible(true);
				getParent().add(cadastroFuncionarioUI, 0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		scrollPane.setViewportView(tableConsultaFuncionario);
		getContentPane().setLayout(groupLayout);

	}
	
	private FuncionarioTableModel getFuncionarioTableModel(){
		List<Funcionario> funcionarios = getController().listar();
		return new FuncionarioTableModel(funcionarios);
	}
	
	private FuncionarioController getController() {
		if (controller == null) {
			controller = new FuncionarioController();
		}
		return controller;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private Funcionario getFuncionarioSelecionado() {
		int linhaSelecionada = tableConsultaFuncionario.getSelectedRow();
		FuncionarioTableModel funcionarioTableModel = (FuncionarioTableModel) tableConsultaFuncionario.getModel();
		return funcionarioTableModel.get(linhaSelecionada);
	}
	
	public void carregarTabela() {
		tableConsultaFuncionario.setModel(getFuncionarioTableModel());
	}
}
