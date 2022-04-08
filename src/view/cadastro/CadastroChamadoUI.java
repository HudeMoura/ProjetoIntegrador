package view.cadastro;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.ChamadoController;
import controller.FuncionarioController;
import controller.VeiculoController;
import model.Chamado;
import model.Funcionario;
import model.Veiculo;
import view.consulta.ConsultaChamadosUI;
import view.consulta.ConsultaVeiculosUI;

public class CadastroChamadoUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<Funcionario> comboBoxFuncionario = new JComboBox<Funcionario>();
	JComboBox<Veiculo> comboBoxVeiculo = new JComboBox<Veiculo>();
	private JTextField textFieldEndereco;
	private JTextField textFieldData;
	
	private Chamado chamado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroChamadoUI frame = new CadastroChamadoUI();
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
	public CadastroChamadoUI() {
		setClosable(true);
		setTitle("Cadastro de Chamados");
		setBounds(100, 100, 399, 250);
		
		JPanel panelCadastroChamados = new JPanel();
		panelCadastroChamados.setBorder(new TitledBorder(null, "Chamado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		comboBoxFuncionario.setModel(getFuncionarioModel());
		comboBoxVeiculo.setModel(getVeiculoModel());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					salvar();
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
					showMessage("Erro ao registrar chamado!");
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelCadastroChamados, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCadastroChamados, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addGap(23))
		);
		
		JLabel lblFuncionario = new JLabel("Funcion\u00E1rio");
		
		JLabel lblVeiculo = new JLabel("Veiculo");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		
		JLabel lblData = new JLabel("Data");
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setEditable(false);
		textFieldData.setColumns(10);
		
		GroupLayout gl_panelCadastroChamados = new GroupLayout(panelCadastroChamados);
		gl_panelCadastroChamados.setHorizontalGroup(
			gl_panelCadastroChamados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroChamados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCadastroChamados.createSequentialGroup()
							.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblVeiculo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblFuncionario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
								.addComponent(lblEndereo, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
							.addGap(10))
						.addGroup(gl_panelCadastroChamados.createSequentialGroup()
							.addComponent(lblData, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastroChamados.createSequentialGroup()
							.addComponent(textFieldData, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelCadastroChamados.createSequentialGroup()
							.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxFuncionario, Alignment.LEADING, 0, 253, Short.MAX_VALUE)
								.addComponent(textFieldEndereco, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
								.addComponent(comboBoxVeiculo, Alignment.LEADING, 0, 253, Short.MAX_VALUE))
							.addGap(10))))
		);
		gl_panelCadastroChamados.setVerticalGroup(
			gl_panelCadastroChamados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroChamados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuncionario)
						.addComponent(comboBoxFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVeiculo)
						.addComponent(comboBoxVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndereo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCadastroChamados.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblData))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panelCadastroChamados.setLayout(gl_panelCadastroChamados);
		getContentPane().setLayout(groupLayout);

	}
	
	private DefaultComboBoxModel<Funcionario> getFuncionarioModel() {
		DefaultComboBoxModel<Funcionario> model = new DefaultComboBoxModel<Funcionario>();
		for (Funcionario funcionario : new FuncionarioController().listar()) {
			model.addElement(funcionario);
		}
		return model;
	}
	
	private DefaultComboBoxModel<Veiculo> getVeiculoModel() {
		DefaultComboBoxModel<Veiculo> model = new DefaultComboBoxModel<Veiculo>();
		for (Veiculo veiculo : new VeiculoController().listar()) {
			if (veiculo.isVeiculoDisponivel()) {
				model.addElement(veiculo);				
			}
		}
		return model;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private LocalDateTime getDataChamado() {
		LocalDateTime dataChamado;
		
		if (textFieldData.getText().isEmpty()) {
			dataChamado = LocalDateTime.now();
		} else {
			dataChamado = LocalDateTime.parse(textFieldData.getText());			
		}
		
		return dataChamado;
	}
	
	public void editar(Chamado chamado) {
		this.chamado = chamado;
		preencheFomulario();
	}
	
	private void preencheFomulario() {
		if (this.chamado != null) {
			comboBoxFuncionario.setSelectedItem(chamado.getFuncionario());
			comboBoxVeiculo.setSelectedItem(chamado.getVeiculo());
			textFieldEndereco.setText(this.chamado.getEndereco());
			textFieldData.setText(this.chamado.getData().toString());
		}
	}
	
	private void salvar() throws Exception {
		if(isEdicao()) {
			atualizarChamado();
			showMessage("Chamado atualizado com sucesso!");
		} else {
			salvarChamado();
			showMessage("Chamado salvo com sucesso!");
		}
	}
	
	private boolean isEdicao() {
		return this.chamado != null && this.chamado.getId() > 0;
	}
	
	private void atualizarChamado() throws Exception {
		this.chamado.setFuncionario((Funcionario) comboBoxFuncionario.getSelectedItem());
		this.chamado.setVeiculo((Veiculo) comboBoxVeiculo.getSelectedItem());
		this.chamado.setEndereco(textFieldEndereco.getText());
		this.chamado.setData(getDataChamado());
		
		new ChamadoController().atualizar(this.chamado);
	}
	
	private void salvarChamado() throws Exception {
		 Funcionario funcionario = (Funcionario) comboBoxFuncionario.getSelectedItem();
		 Veiculo veiculo = (Veiculo) comboBoxVeiculo.getSelectedItem();
		 String endereco = textFieldEndereco.getText();
		 LocalDateTime data = getDataChamado();
		 
		 veiculo.setVeiculoDisponivel(false);
		 
		 Chamado chamado = new Chamado(funcionario, veiculo, endereco, data);
		
		new ChamadoController().salvar(chamado);
	}

	private void atualizarConsulta() {
		if (getParent() == null) return;
		Component[] components = getParent().getComponents();
		for (int i = 0; i < components.length; i++ ) {
			Component component = components[i];
			if (component instanceof ConsultaChamadosUI) {
				((ConsultaChamadosUI) component).carregarTabela();
			}
		}
	}
	
}
