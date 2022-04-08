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

import controller.VeiculoController;
import model.Veiculo;
import view.cadastro.CadastroVeiculoUI;
import view.tables.VeiculoTableModel;

public class ConsultaVeiculosUI extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tableConsultaVeiculo;
	private static VeiculoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVeiculosUI frame = new ConsultaVeiculosUI();
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
	public ConsultaVeiculosUI() {
		setTitle("Consulta de Ve\u00EDculos");
		setClosable(true);
		setBounds(50, 50, 800, 440);
		
		tableConsultaVeiculo = new JTable();
		
		carregarTabela();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Veiculo Veiculo = getVeiculoSelecionado();
				
				try {
					getController().excluir(Veiculo.getId());
					carregarTabela();
					showMessage("Funcionário excluído com sucesso");
				} catch (Exception e) {
					e.printStackTrace();
					showMessage("Erro ao excluir funcionário");
				}
;			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = getVeiculoSelecionado();
				CadastroVeiculoUI cadastroVeiculoUI = new CadastroVeiculoUI();
				cadastroVeiculoUI.editar(veiculo);
				cadastroVeiculoUI.setVisible(true);
				getParent().add(cadastroVeiculoUI, 0);
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
		
		scrollPane.setViewportView(tableConsultaVeiculo);
		getContentPane().setLayout(groupLayout);

	}
	
	private VeiculoTableModel getVeiculoTableModel(){
		List<Veiculo> Veiculos = getController().listar();
		return new VeiculoTableModel(Veiculos);
	}
	
	private VeiculoController getController() {
		if (controller == null) {
			controller = new VeiculoController();
		}
		return controller;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private Veiculo getVeiculoSelecionado() {
		int linhaSelecionada = tableConsultaVeiculo.getSelectedRow();
		VeiculoTableModel VeiculoTableModel = (VeiculoTableModel) tableConsultaVeiculo.getModel();
		return VeiculoTableModel.get(linhaSelecionada);
	}
	
	public void carregarTabela() {
		tableConsultaVeiculo.setModel(getVeiculoTableModel());
	}
}
