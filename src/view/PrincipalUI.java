package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.cadastro.CadastroChamadoUI;
import view.cadastro.CadastroFuncionarioUI;
import view.cadastro.CadastroVeiculoUI;
import view.consulta.ConsultaChamadosUI;
import view.consulta.ConsultaFuncionariosUI;
import view.consulta.ConsultaVeiculosUI;

public class PrincipalUI extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Pegada CO2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 720);
		
		JMenuBar menuBarPrincipal = new JMenuBar();
		setJMenuBar(menuBarPrincipal);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuBarPrincipal.add(menuCadastro);
		
		JMenuItem menuItemCadastroChamado = new JMenuItem("Chamados");
		menuItemCadastroChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela(CadastroChamadoUI.class);
			}
		});
		menuCadastro.add(menuItemCadastroChamado);
		
		JMenuItem menuItemCadastroFuncionario = new JMenuItem("Funcion\u00E1rios");
		menuItemCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela(CadastroFuncionarioUI.class);
			}
		});
		menuCadastro.add(menuItemCadastroFuncionario);
		
		JMenuItem menuItemCadastroVeiculo = new JMenuItem("Ve\u00EDculos");
		menuItemCadastroVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela(CadastroVeiculoUI.class);
			}
		});
		menuCadastro.add(menuItemCadastroVeiculo);
		
		JMenu menuConsulta = new JMenu("Consulta");
		menuBarPrincipal.add(menuConsulta);
		
		JMenuItem menuItemConsultaChamado = new JMenuItem("Chamados");
		menuItemConsultaChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela(ConsultaChamadosUI.class);
			}
		});
		menuConsulta.add(menuItemConsultaChamado);
		
		JMenuItem menuItemConsultaFuncionario = new JMenuItem("Funcion\u00E1rios");
		menuItemConsultaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela(ConsultaFuncionariosUI.class);
			}
		});
		menuConsulta.add(menuItemConsultaFuncionario);
		
		JMenuItem menuItemConsultaVeiculo = new JMenuItem("Ve\u00EDculos");
		menuItemConsultaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela(ConsultaVeiculosUI.class);
			}
		});
		menuConsulta.add(menuItemConsultaVeiculo);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 838, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 457, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private <T extends JInternalFrame> void abrirJanela(Class<T> frame) {
		try {
			JInternalFrame frameInstance = frame.getDeclaredConstructor().newInstance();
			frameInstance.setVisible(true);
			getContentPane().add(frameInstance);			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao abrir janela " + frame.getName());
		}
	}

}
