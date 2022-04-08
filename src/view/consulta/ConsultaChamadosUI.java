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

import controller.ChamadoController;
import model.Chamado;
import view.cadastro.CadastroChamadoUI;
import view.tables.ChamadoTableModel;

public class ConsultaChamadosUI extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tableConsultaChamado;
	private static ChamadoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaChamadosUI frame = new ConsultaChamadosUI();
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
	public ConsultaChamadosUI() {
		setTitle("Consulta de Chamados");
		setClosable(true);
		setBounds(50, 50, 800, 440);
		
		tableConsultaChamado = new JTable();
		
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
				Chamado Chamado = getChamadoSelecionado();
				
				try {
					getController().excluir(Chamado.getId());
					carregarTabela();
					showMessage("Chamado excluído com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
					showMessage("Erro ao excluir chamado!");
				}
;			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = getChamadoSelecionado();
				CadastroChamadoUI cadastroChamadoUI = new CadastroChamadoUI();
				cadastroChamadoUI.editar(chamado);
				cadastroChamadoUI.setVisible(true);
				getParent().add(cadastroChamadoUI, 0);
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
		
		scrollPane.setViewportView(tableConsultaChamado);
		getContentPane().setLayout(groupLayout);

	}
	
	private ChamadoTableModel getChamadoTableModel(){
		List<Chamado> chamados = getController().listar();
		return new ChamadoTableModel(chamados);
	}
	
	private ChamadoController getController() {
		if (controller == null) {
			controller = new ChamadoController();
		}
		return controller;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private Chamado getChamadoSelecionado() {
		int linhaSelecionada = tableConsultaChamado.getSelectedRow();
		ChamadoTableModel ChamadoTableModel = (ChamadoTableModel) tableConsultaChamado.getModel();
		return ChamadoTableModel.get(linhaSelecionada);
	}
	
	public void carregarTabela() {
		tableConsultaChamado.setModel(getChamadoTableModel());
	}
}
