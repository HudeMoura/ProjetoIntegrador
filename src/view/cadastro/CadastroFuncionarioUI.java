package view.cadastro;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.FuncionarioController;
import model.Funcionario;
import view.consulta.ConsultaFuncionariosUI;

public class CadastroFuncionarioUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldDataNascimento;
	private JCheckBox chckbxHabilitadoConduzir;
	
	private Funcionario funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioUI frame = new CadastroFuncionarioUI();
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
	public CadastroFuncionarioUI() {
		setTitle("Cadastro de Funcionario");
		setClosable(true);
		setBounds(100, 100, 450, 255);
		
		chckbxHabilitadoConduzir = new JCheckBox("Habilitado para conduzir");
		
		JPanel panelCadastroFuncionario = new JPanel();
		panelCadastroFuncionario.setBorder(new TitledBorder(null, "Funcionario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salvar();
					dispose();
					atualizarConsulta();
				} catch (Exception ex) {
					ex.printStackTrace();
					showMessage("Erro ao salvar funcionário!");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCadastroFuncionario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCadastroFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblCPF = new JLabel("CPF");
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setColumns(10);
		
		GroupLayout gl_panelCadastroFuncionario = new GroupLayout(panelCadastroFuncionario);
		gl_panelCadastroFuncionario.setHorizontalGroup(
			gl_panelCadastroFuncionario.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCadastroFuncionario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastroFuncionario.createParallelGroup(Alignment.TRAILING)
						.addComponent(chckbxHabilitadoConduzir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
						.addGroup(gl_panelCadastroFuncionario.createSequentialGroup()
							.addGroup(gl_panelCadastroFuncionario.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblDataNascimento, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
								.addComponent(lblCPF, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadastroFuncionario.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldDataNascimento, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
								.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
								.addComponent(textFieldCPF, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))))
					.addGap(10))
		);
		gl_panelCadastroFuncionario.setVerticalGroup(
			gl_panelCadastroFuncionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroFuncionario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastroFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCadastroFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCPF)
						.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCadastroFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxHabilitadoConduzir)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panelCadastroFuncionario.setLayout(gl_panelCadastroFuncionario);
		getContentPane().setLayout(groupLayout);

	}

	public void editar(Funcionario funcionario) {
		this.funcionario = funcionario;
		preencheFomulario();
	}
	
	private void preencheFomulario() {
		if (this.funcionario != null) {
			textFieldNome.setText(this.funcionario.getNome());
			textFieldCPF.setText(this.funcionario.getCpf());
			textFieldDataNascimento.setText(this.funcionario.getDataNascimento().toString());
			chckbxHabilitadoConduzir.setSelected(this.funcionario.isHabilitadoConduzir());
		}
	}
	
	private void salvar() throws Exception {
		if(isEdicao()) {
			atualizarFuncionario();
			showMessage("Funcionário atualizado com sucesso!");
		} else {
			salvarFuncionario();
			showMessage("Funcionário salvo com sucesso!");
		}
	}
	
	private boolean isEdicao() {
		return this.funcionario != null && this.funcionario.getId() > 0;
	}
	
	private void atualizarFuncionario() throws Exception {
		this.funcionario.setNome(textFieldNome.getText());
		this.funcionario.setCpf(textFieldCPF.getText());
		this.funcionario.setDataNascimento(LocalDate.parse(textFieldDataNascimento.getText()));
		this.funcionario.setHabilitadoConduzir(chckbxHabilitadoConduzir.isSelected());
		
		new FuncionarioController().atualizar(this.funcionario);
	}
	
	private void salvarFuncionario() throws Exception {
		String nome = textFieldNome.getText();
		String cpf = textFieldCPF.getText();
		LocalDate dataNascimento = LocalDate.parse(textFieldDataNascimento.getText());
		boolean habilitadoConduzir = chckbxHabilitadoConduzir.isSelected();
		Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, habilitadoConduzir);
		
		new FuncionarioController().salvar(funcionario);
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private void atualizarConsulta() {
		if (getParent() == null) return;
		Component[] components = getParent().getComponents();
		for (int i = 0; i < components.length; i++ ) {
			Component component = components[i];
			if (component instanceof ConsultaFuncionariosUI) {
				((ConsultaFuncionariosUI) component).carregarTabela();
			}
		}
		
	}

}
