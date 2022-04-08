package view.cadastro;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controller.VeiculoController;
import model.Veiculo;
import view.consulta.ConsultaVeiculosUI;

public class CadastroVeiculoUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldPlaca;
	private JTextField textFieldDescricao;
	private JTextField textFieldQuilometrosPorLitro;
	private JCheckBox checkboxVeiculoDisponivel;
	
	private Veiculo veiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculoUI frame = new CadastroVeiculoUI();
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
	public CadastroVeiculoUI() {
		setClosable(true);
		setTitle("Cadastro de Ve\u00EDculo");
		setBounds(100, 100, 450, 240);
		
		checkboxVeiculoDisponivel = new JCheckBox("Ve\u00EDculo dispon\u00EDvel");
		
		initialize(checkboxVeiculoDisponivel);
		
		JPanel panelCadastroVeiculo = new JPanel();
		panelCadastroVeiculo.setBorder(new TitledBorder(null, "Ve\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
					atualizarConsulta();
				} catch (Exception e) {
					e.printStackTrace();
					showMessage("Erro ao salvar veículo!");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCadastroVeiculo, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
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
					.addComponent(panelCadastroVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblPlaca = new JLabel("Placa");
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		
		JLabel lblQuilometrosPorLitros = new JLabel("Quil\u00F4metros por litro");
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setColumns(10);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		
		textFieldQuilometrosPorLitro = new JTextField();
		textFieldQuilometrosPorLitro.setColumns(10);
		
		GroupLayout gl_panelCadastroVeiculo = new GroupLayout(panelCadastroVeiculo);
		gl_panelCadastroVeiculo.setHorizontalGroup(
			gl_panelCadastroVeiculo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroVeiculo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastroVeiculo.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(checkboxVeiculoDisponivel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPlaca, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(lblQuilometrosPorLitros, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
						.addComponent(lblDescricao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCadastroVeiculo.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldQuilometrosPorLitro, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(textFieldDescricao, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
						.addComponent(textFieldPlaca, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCadastroVeiculo.setVerticalGroup(
			gl_panelCadastroVeiculo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroVeiculo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastroVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlaca)
						.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastroVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescricao)
						.addComponent(textFieldDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastroVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuilometrosPorLitros)
						.addComponent(textFieldQuilometrosPorLitro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkboxVeiculoDisponivel)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panelCadastroVeiculo.setLayout(gl_panelCadastroVeiculo);
		getContentPane().setLayout(groupLayout);

	}
	
	private void initialize(JCheckBox checkboxVeiculoDisponivel) {
		checkboxVeiculoDisponivel.setSelected(true);
		checkboxVeiculoDisponivel.setEnabled(false);
	}

	public void editar(Veiculo veiculo) {
		this.veiculo = veiculo;
		checkboxVeiculoDisponivel.setEnabled(true);
		preencheFomulario();
	}
	
	private void preencheFomulario() {
		if (this.veiculo != null) {
			textFieldPlaca.setText(this.veiculo.getPlaca());
			textFieldDescricao.setText(this.veiculo.getDescricao());
			textFieldQuilometrosPorLitro.setText(this.veiculo.getQuilometrosPorLitro().toString());
			checkboxVeiculoDisponivel.setSelected(veiculo.isVeiculoDisponivel());
		}
	}
	
	private void salvar() throws Exception {
		if(isEdicao()) {
			atualizarveiculo();
			showMessage("Veículo salvo com sucesso!");
		} else {
			salvarveiculo();
			showMessage("Veículo salvo com sucesso!");
		}
	}
	
	private boolean isEdicao() {
		return this.veiculo != null && this.veiculo.getId() > 0;
	}
	
	private void salvarveiculo() throws Exception {
		String placa = textFieldPlaca.getText();
		String descricao = textFieldDescricao.getText();
		Double quilometrosPorLitro = Double.valueOf(textFieldQuilometrosPorLitro.getText());
		boolean veiculoDisponivel = checkboxVeiculoDisponivel.isSelected();
		Veiculo veiculo = new Veiculo(placa, descricao, quilometrosPorLitro, veiculoDisponivel);
		
		new VeiculoController().salvar(veiculo);
	}
	
	private void atualizarveiculo() throws Exception {
		this.veiculo.setPlaca(textFieldPlaca.getText());
		this.veiculo.setDescricao(textFieldDescricao.getText());
		this.veiculo.setQuilometrosPorLitro(Double.valueOf(textFieldQuilometrosPorLitro.getText()));
		this.veiculo.setVeiculoDisponivel(checkboxVeiculoDisponivel.isSelected());
		
		new VeiculoController().atualizar(this.veiculo);
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private void atualizarConsulta() {
		if (getParent() == null) return;
		Component[] components = getParent().getComponents();
		for (int i = 0; i < components.length; i++ ) {
			Component component = components[i];
			if (component instanceof ConsultaVeiculosUI) {
				((ConsultaVeiculosUI) component).carregarTabela();
			}
		}
	}
	
}
